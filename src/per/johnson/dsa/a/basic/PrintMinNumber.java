package per.johnson.dsa.a.basic;

import java.util.Arrays;

/**
 * Created by Johnson on 2018/7/28.
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumber {
    public String printMinNumber(int [] numbers) {
        String[] numbersStr = new String[numbers.length];
        for(int i = 0; i<numbers.length; i++ ){
            numbersStr[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(numbersStr,(o1,o2)->(o1 + o2).compareTo(o2 + o1));
        StringBuilder sb = new StringBuilder();
        for(String s : numbersStr){
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] a = {3,32,321};
        System.out.println(new PrintMinNumber().printMinNumber(a));
    }
}
