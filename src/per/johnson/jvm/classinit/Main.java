package per.johnson.jvm.classinit;

/**
 * Created by Johnson on 2018/7/19.
 */
public class Main {
    static {
        System.out.println("Main init");
    }
    public static void main(String[] args) {
        System.out.println(SubClass.hello);
    }
}
