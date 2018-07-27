package per.johnson.dsa.util;


import java.util.HashMap;

/**
 * Created by Johnson on 2018/7/27.
 */
public class IntegerUtils {
    public static boolean isPowIfTow(int value) {
        return (value & -value) == value;
    }

    public static int findMinPowOfTow(final int value) {
        int n = value - 1;
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;
        return n < 0 ? (1 << 30) : n + 1;
    }
}
