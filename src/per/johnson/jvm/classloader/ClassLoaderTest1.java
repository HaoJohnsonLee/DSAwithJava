package per.johnson.jvm.classloader;

/**
 * Created by Johnson on 2018/7/19.
 */
public class ClassLoaderTest1 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyClassLoader myClassLoader = new MyClassLoader("F://");
        Object obj = myClassLoader.loadClass("per.johnson.jvm.classloader.People",false).newInstance();
        System.out.println(obj instanceof per.johnson.jvm.classloader.People);
        System.out.println(obj.getClass().getClassLoader());
        People p = (People)obj;
        p.say();
    }
}
