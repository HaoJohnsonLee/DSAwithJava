package per.johnson.dsa.a.niuke;

/**
 * Created by Johnson on 2018/7/5.
 */
public class NumberOf1 {
    public static int NumberOf1(int n) {
        int count = 0;
        for(int i=0; i < 32; i++){
            count +=  n >> i & 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1(-124324423));
        System.out.println(Integer.bitCount(-124324423));
    }
}
