package per.johnson.dsa.test;


import per.johnson.dsa.util.IntegerUtils;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
    int count = 21;
    public void count() {
        System.out.println(++count);
    }
    public static void main(String args[]) {
        System.out.println(IntegerUtils.findMinPowOfTow(28));
    }
}