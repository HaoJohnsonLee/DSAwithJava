package per.johnson.jvm.classinit;

/**
 * Created by Johnson on 2018/7/19.
 */
public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init");
    }
}
