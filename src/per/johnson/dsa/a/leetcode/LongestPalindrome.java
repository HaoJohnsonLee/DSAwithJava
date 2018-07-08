package per.johnson.dsa.a.leetcode;

/**
 * Created by Johnson on 2018/7/8.
 */
public class LongestPalindrome {
    /**
     * Given a string s, find the longest palindromic substring in s.
     * You may assume that the maximum length of s is 1000.
     *
     * @param s "babad"
     * @return "bab"
     */
    public String longestPalindrome(String s) {
        char[] origin = s.toCharArray();
        char[] ma = insert(origin);
        int[] mp = new int[ma.length];
        int mx = 0;   //当前右边界
        int id = 0;  //最长回文字串index
        mp[0] = 0;
        for (int i = 1; i < ma.length; i++) {
            int mirror = 2 * id - i;
            if (i <= mx) {  // 当前位置处于回文范围内
                mp[i] = Math.min(mp[mirror], mx - i);
            } else { //在回文区域外
                mp[i] = 0;
            }
            //尝试扩充
            while ((i - mp[i] - 1) > -1 && (i + mp[i] + 1) < ma.length && (ma[i - mp[i] - 1] == ma[i + mp[i] + 1]))
                mp[i]++;
            if (i + mp[i] > mx) { //扩展边界值
                mx = i + mp[i];
                id = mp[id] > mp[i] ? id : i;
            }
        }
        int length = mp[id];
        return String.valueOf(origin, (id - 1 - length) / 2, length);
    }

    private char[] insert(char[] origin) {
        char[] newArray = new char[origin.length * 2 + 1];
        for (int i = 0; i < origin.length; i++) {
            newArray[2 * i] = '#';
            newArray[2 * i + 1] = origin[i];
        }
        newArray[newArray.length - 1] = '#';
        return newArray;
    }

    public String longestPalindrome0(String s) {
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        int maxLength = 0;
        for (int i = 0; i < length; i++) {
            int curLength = 1;
            while (i - curLength > -1 && i + curLength < length && s.charAt(i - curLength) == s.charAt(i + curLength)) {
                curLength++;
            }
            if (curLength > maxLength) {
                maxLength = curLength;
                sb.delete(0, sb.length());
                sb.append(s, i - curLength + 1, i + curLength);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome0("babad"));
    }

}
