package per.johnson.jvm.classinit;

/**
 * Created by Johnson on 2018/7/19.
 */
public class SuperClass {
    static {
        System.out.println("SuperClass init");
    }
    public static final String hello = "Hello World";
}
