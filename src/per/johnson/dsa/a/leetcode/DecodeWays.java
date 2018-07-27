package per.johnson.dsa.a.leetcode;

/**
 * Created by Johnson on 2018/7/23.
 */
public class DecodeWays {
    int[] map;

    public int numDecodings(String s) {
        map = new int[s.length()];
        return numDecodings(s.toCharArray(), 0, s.length() - 1);
    }

    /**
     * @param s  origin
     * @param lo [lo
     * @param hi hi]
     * @return number
     */
    private int numDecodings(char[] s, int lo, int hi) {
        if(lo <= hi) {
            if (map[lo] > 0) return map[lo];
            if (s[lo] == '0') return 0;
        }
        if (lo >= hi) return 1;
        int w = numDecodings(s, lo + 1, hi);
        final int prefix = (s[lo] - '0') * 10 + (s[lo + 1] - '0');
        if (prefix <= 26)
            w += numDecodings(s, lo + 2, hi);
        return map[lo] = w;
    }

    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("102213"));
    }
}
