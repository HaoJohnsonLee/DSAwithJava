package per.johnson.dsa.test;


import java.util.concurrent.ConcurrentHashMap;

public class Test {
    int count = 21;
    public void count() {
        System.out.println(++count);
    }
    public static void main(String args[]) {
        new Test().count();
        new Test().count();
    }
}