package per.johnson.dsa.a.niuke;

/**
 * Created by Johnson on 2018/7/23.
 */
public class NumberOf1Between1AndN {
    public int numberOf1Between1AndN_Solution(int n) {
        int count = 0;
        char[] s = String.valueOf(n).toCharArray();
        for(int i=0; i < s.length; i++){
            if(s[i] == '1')
                count++;
        }
        return count;
    }
}
