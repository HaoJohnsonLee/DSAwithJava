package per.johnson.jvm.classinit.staticinit;

/**
 * Created by Johnson on 2018/7/19.
 */
public class Parent {
    public static int a = 1;
    static {
        a = 2;
        System.out.println("a= " + a);
    }
}
