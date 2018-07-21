package per.johnson.concurrent.threadpool;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by Johnson on 2018/7/20.
 */
public class CallableTest implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return new Random().nextInt(100);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableTest ct = new CallableTest();

        FutureTask<Integer> ft = new FutureTask<>(ct);
        ft.run();
        if (ft.isDone()){
            System.out.println(ft.get());
        }
    }
}
