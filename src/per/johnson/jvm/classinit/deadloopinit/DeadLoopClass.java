package per.johnson.jvm.classinit.deadloopinit;

/**
 * Created by Johnson on 2018/7/19.
 */
public class DeadLoopClass {
    static {
        System.out.println(Thread.currentThread() + "init DeadLoopClass");
        try {
            System.out.println("Sleep 5 seconds");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
