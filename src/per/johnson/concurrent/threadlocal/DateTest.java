package per.johnson.concurrent.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Johnson on 2018/7/24.
 */
public class DateTest implements Runnable{
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    @Override
    public void run() {
        try {
            Random random = new Random();
            long s = random.nextInt(5000);
            System.out.println(s);
            Thread.sleep(s);
            System.out.println(simpleDateFormat.format(new Date()));
        } catch (InterruptedException ignored) {
        }
    }
}
