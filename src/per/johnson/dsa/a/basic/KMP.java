package per.johnson.dsa.a;

import java.util.Arrays;

/**
 * Created by Johnson on 2018/7/23.
 */
public class KMP {
    /**
     * @param origin  原始串
     * @param pattern 模式串
     * @return 匹配到的原始串的首索引 or -1
     */
    public int match(String origin, String pattern) {
        if (origin.length() < pattern.length()) return -1;
        int[] next = next(pattern);
        movePrefixTable(next);
        // i  ->>  origin
        // j  ->> pattern
        int M = origin.length();
        int N = pattern.length();
        int i = 0, j = 0;
        while (i < M) {
            if (j == N) {
                return i - j;
            }
            if (origin.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
                if (j == -1) {
                    j++;
                    i++;
                }
            }
        }
        return -1;
    }

    /**
     * 找到公共前后缀表
     *
     * @param pattern a   b   a   b   c
     * @return 0   0   1   2   0
     */
    private int[] next(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = 0;
        int last = -1;
        for (int i = 1; i < pattern.length(); i++) {
            if (pattern.charAt(i) == pattern.charAt(last + 1)) {
                next[i] = next[i - 1] + 1;
                last++;
            } else if (pattern.charAt(0) == pattern.charAt(i)) {
                next[i] = 1;
                last = 0;
            } else {
                next[i] = 0;
                last = -1;
            }
        }
        return next;
    }

    /**
     * 向后移位 首位置为 -1
     *
     * @param next a   b   a   b   c
     *             0   0   1   2   0
     *             ---> -1   0   0   1   2
     */
    private void movePrefixTable(int[] next) {
        for (int i = next.length - 1; i > 0; ) {
            next[i] = next[--i];
        }
        next[0] = -1;
    }

    public static void main(String[] args) {
        String origin = "ABABABABCABAAB";
        String pattern = "ABABCABAA";
        int result = new KMP().match(origin, pattern);
        if (result == -1) System.out.printf("Can't found pattern : %s", pattern);
        else System.out.printf("Found patter at %d", result);
    }
}
