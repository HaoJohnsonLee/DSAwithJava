package per.johnson.jvm.classinit.staticinit;

/**
 * Created by Johnson on 2018/7/19.
 */
public class Child extends Parent{
    static {
        a = 3;
        System.out.println("a= " + a);
    }
    public static int b = a;
}
