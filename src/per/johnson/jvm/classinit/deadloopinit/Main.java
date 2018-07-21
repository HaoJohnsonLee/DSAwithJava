package per.johnson.jvm.classinit.deadloopinit;

/**
 * Created by Johnson on 2018/7/19.
 */
public class Main {
    public static void main(String[] args) {
        Runnable script = ()->{
            System.out.println(Thread.currentThread() + " start");
            DeadLoopClass dlc = new DeadLoopClass();
            System.out.println(Thread.currentThread() + " over");
        };
        Thread thread1 = new Thread(script);
        Thread thread2 = new Thread(script);
        thread1.start();
        thread2.start();
    }
}
