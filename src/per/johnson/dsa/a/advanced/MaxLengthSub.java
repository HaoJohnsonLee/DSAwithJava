package per.johnson.dsa.a.huawei;

import java.util.Scanner;

/**
 * Created by Johnson on 2018/8/1.
 */
public class MaxLengthSub {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if(line == null || line.length() < 1 || line.trim().equals("")) return;
        char[] chars = line.toCharArray();
        char maxChar = 'Z';
        char last = chars[0];
        int maxLo = 0, maxHi = 0;
        int lo = 0, hi;
        for (int i = 1; i < chars.length; i++) {
            char cur = chars[i];
            hi = i;
            if (cur != last || i == chars.length -1) {
                if(i == chars.length -1) hi ++;
                if ((hi - lo) > (maxHi - maxLo)) { //超过
                    maxLo = lo;
                    maxHi = hi;
                    maxChar = last;
                } else if ((hi - lo) == (maxHi - maxLo)) { //等于
                    if (last < maxChar) {
                        maxLo = lo;
                        maxHi = hi;
                        maxChar = last;
                    }
                }
                lo = i;
                last = cur;
            }
            else last = cur;
        }
        System.out.println(line.substring(maxLo, maxHi));
    }
}
