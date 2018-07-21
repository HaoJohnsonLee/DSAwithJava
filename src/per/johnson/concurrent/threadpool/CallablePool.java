package per.johnson.concurrent.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Johnson on 2018/7/20.
 */
public class CallablePool {
    public static void main(String[] args) {
        AtomicInteger bags = new AtomicInteger(100);
        ExecutorService ex = Executors.newFixedThreadPool(5);
        List<Future<Integer>> futures = new ArrayList<>();
        try {
            for (int i = 0; i < 100; i++) {
                Future<Integer> ft = ex.submit(bags::decrementAndGet);
                futures.add(ft);
            }
            for (int i=0; i < 100 ; i++){
                System.out.println(futures.get(i).get());
            }
        }catch (Exception ignored){}
        finally {
            ex.shutdown();
        }
    }
}
