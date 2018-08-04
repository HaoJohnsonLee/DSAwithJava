package per.johnson.dsa.a.huawei;

/**
 * Created by Johnson on 2018/7/31.
 * 求 int 中 二进制 1 的个数
 */
public class OneNumber {
    private int count(int num){
        int count = 0;
        while(num !=0){
            if((num & 1) == 1) count ++;
            num = num >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int num = 19974318;
        System.out.println(new OneNumber().count(num));
    }
}
