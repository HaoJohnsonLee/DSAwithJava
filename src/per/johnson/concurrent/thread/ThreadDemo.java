package per.johnson.concurrent.thread;

import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Johnson on 2018/7/26.
 */
public class ThreadDemo {
    private static Data share;

    /**
     * interrupted() 方法清除中断状态
     *
     * @throws InterruptedException
     */
    public void interruptTest() throws InterruptedException {
        Runnable r = () -> {
            String name = Thread.currentThread().getName();
            int count = 0;
            while (!Thread.interrupted()) {
                System.out.println(name + ": " + count++);
            }
            System.out.println(Thread.interrupted());
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        Thread.sleep(1000);
        t1.interrupt();
        t2.interrupt();
    }

    /**
     * 三个线程依次运行
     *
     * @throws InterruptedException
     */
    public void joinTest() throws InterruptedException {
        JoinThread jt1 = new JoinThread(1);
        JoinThread jt2 = new JoinThread(2);
        JoinThread jt3 = new JoinThread(3);
        System.out.println("Start");
        jt1.start();
        jt1.join();
        jt2.start();
        jt2.join();
        jt3.start();
        jt3.join();
        System.out.println("End");
    }

    /**
     * 死亡线程在start() 抛出 IllegalThreadStateException
     *
     * @throws InterruptedException
     */
    public void deadTest() throws InterruptedException {
        Runnable run = () -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getState().name());
            System.out.println("I am going to dead");
        };
        Thread thread = new Thread(run);
        System.out.println(thread.getState().name());
        thread.start();
        System.out.println(thread.getState().name());
        Thread.sleep(1000);
        System.out.println(thread.getState().name());
        thread.start();
    }

    public void shareTest() throws InterruptedException {
        Runnable r = () -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            share = new Data("Data");
        };
        Thread t = new Thread(r);
        t.start();
        System.out.println(share);
    }

    public void testLock() throws InterruptedException {
        Integer mutex = 0;
        Runnable r = () -> {
            share = new Data("lalalla");
            synchronized (mutex) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(r).start();
        Thread.sleep(1000);
        synchronized (mutex) {
            if (share != null)
                System.out.println(share.data);
            else
                System.out.println("Null");
        }
    }

    public void testPC() {
        Shared s = new Shared();
        Producer producer = new Producer(s);
        Consumer consumer = new Consumer(s);
        producer.start();
        consumer.start();
        System.out.println(Thread.currentThread().getThreadGroup().activeCount());
    }

    public void testFinal() {
        String a = "hello world";
        final String s = "hello";
        String c = "hello";
        String d = s + " world";
        String e = c + " world";
        System.out.println(a == d);
        System.out.println(a == e);
    }

    public void testExceptiop() {
        Runnable r = ()-> {
            int s =  5/0;
        };
        Thread s = new Thread(r);
        Thread.UncaughtExceptionHandler uceh = (t,e)->{
            System.out.println("Caught throwable "+ e + " on thread " +t.getName());
        };
        s.setUncaughtExceptionHandler(uceh);
        s.start();
    }

    public void testThreadLocal(){
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        Runnable runnable = ()->{
            String name = Thread.currentThread().getName();
          if(name.equals("A"))
              threadLocal.set(100);
          else if(name.equals("B"))
              threadLocal.set(200);
          else
              threadLocal.set(300);
          System.out.println(name + " : "+threadLocal.get());
        };
        Thread ta = new Thread(runnable);
        ta.setName("A");
        Thread tb = new Thread(runnable);
        tb.setName("B");
        ta.start();
        tb.start();
    }

    public void testTimer(){
        TimerTask task = new TimerTask() {
            int count=0;
            @Override
            public void run() {
                count ++;
                System.out.println(System.currentTimeMillis());
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 0 , 1000);

    }

    public static void main(String[] args) throws InterruptedException {
        /*ThreadDemo td = new ThreadDemo();
        td.testTimer();*/
        System.out.println(Integer.toBinaryString(9));
        System.out.println(Integer.toBinaryString(-9));
        System.out.println(Integer.toBinaryString(8));
        System.out.println(Integer.toBinaryString(-8));
    }
}

class JoinThread extends Thread {
    private int num;

    public JoinThread(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        Random random = new Random();
        long s = random.nextInt(5000);
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我是 " + num + " 号线程");
    }
}

class Shared {
    private char c;
    private volatile boolean writable = true;

    synchronized void setSharedChar(char c) {
        while (!writable) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.c = c;
        System.out.println("P produced char " + c);
        writable = false;
        notify();
    }

    synchronized char getSharedChar() {
        while (writable) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        writable = true;
        System.out.println("C consumed char " + c);
        notify();
        return c;
    }
}

class Producer extends Thread {
    private Shared s;

    public Producer(Shared s) {
        this.s = s;
    }

    @Override
    public void run() {
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            s.setSharedChar(ch);
        }
    }
}

class Consumer extends Thread {
    private Shared s;

    public Consumer(Shared s) {
        this.s = s;
    }

    @Override
    public void run() {
        char ch;
        do {
            ch = s.getSharedChar();
        } while (ch != 'Z');
    }
}
