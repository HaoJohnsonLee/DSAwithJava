package per.johnson.jvm.staticdispatch;

/**
 * Created by Johnson on 2018/7/22.
 */
public class StaticDispatch {
    static abstract class Human {}
    static class Man extends Human{}
    static class Woman extends Human{}

    public void sayHello(Man man){
        System.out.println("hello man");
    }

    public void sayHello(Woman woman){
        System.out.println("hello woman");
    }

    public void satHello(Human human){
        System.out.println("hello human");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch sd = new StaticDispatch();
        sd.satHello(man);
        sd.satHello(woman);
    }
}
