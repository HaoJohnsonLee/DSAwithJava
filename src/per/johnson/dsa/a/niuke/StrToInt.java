package per.johnson.dsa.a.niuke;

/**
 * Created by Johnson on 2018/7/29.
 */
public class StrToInt {
    public int StrToInt(String str) {
        int result = 0;
        boolean positive = true;
        if(str.length() == 0) return 0;
        char[] chars = str.toCharArray();
        if(chars[0] == '+') chars[0] = '0';
        else if(chars[0] == '-') {
            chars[0] = '0';
            positive = false;
        }
        for(int i = 0; i< chars.length;i++){
            char cur = chars[i];
            if(cur <= '9' && cur >= '0') {
                result = result * 10 + (chars[i] - '0');
            }else return 0;
        }
        return positive ? result : -result;
    }

    public static void main(String[] args) {
        System.out.println(new StrToInt().StrToInt("-132659"));
    }
}
