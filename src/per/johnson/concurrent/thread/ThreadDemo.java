package per.johnson.concurrent.thread;

/**
 * Created by Johnson on 2018/7/26.
 */
public class ThreadDemo {
    public void interruptTest() throws InterruptedException {
        Runnable r = ()->{
            String name = Thread.currentThread().getName();
            int count = 0;
            while(!Thread.interrupted()) {
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



    public static void main(String[] args) throws InterruptedException {

    }
}
