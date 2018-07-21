package per.johnson.concurrent.threadpool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Johnson on 2018/7/20.
 */
public class LuckyBag {
    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(8, Integer.MAX_VALUE, 5, TimeUnit.MINUTES,new LinkedBlockingDeque<>(50));
        SendBag bag = new SendBag();
        try {
            for (int i = 0; i < 100; i++) {
                pool.execute(bag);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            pool.shutdown();
        }
    }
}

class SendBag implements Runnable{
    private AtomicInteger remain = new AtomicInteger(100);
    @Override
    public synchronized void run() {
        System.out.println(remain.decrementAndGet());
    }
}