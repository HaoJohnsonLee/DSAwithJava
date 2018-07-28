package per.johnson.dsa.a.niuke;

/**
 * Created by Johnson on 2018/7/28.
 * S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”
 */
public class LeftRotateString {
    // 局部旋转后 全局旋转
    public String leftRotateString(String str,int n) {
        if(str==null||str.trim().equals("")) return str;
        char[] s = str.toCharArray();
        n = n%s.length;
        exchange(s,0,n-1);
        exchange(s,n,s.length-1);
        exchange(s,0,s.length-1);
        return new String(s);
    }

    private void exchange(char[] chars, int lo, int hi){
        while(lo < hi){
            char tmp = chars[hi];
            chars[hi] = chars[lo];
            chars[lo] = tmp;
            lo++;
            hi--;
        }
    }
}
