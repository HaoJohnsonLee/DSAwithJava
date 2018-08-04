package per.johnson.dsa.a.niuke;

import java.util.ArrayList;

/**
 * Created by Johnson on 2018/8/3.
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class TwoSumS {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>(2);
        int min = Integer.MAX_VALUE;
        int s = 0;
        int e = array.length - 1;
        while(s < e){
            int sv = array[s];
            int ev = array[e];
            if(sv + ev > sum){
                e--;
            }else if(sv + ev == sum){
                int m = sv * ev;
                if(m < min){
                    min = m;
                    res.clear();
                    res.add(sv);
                    res.add(ev);
                }
                s++;
            }else{
                s++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        new TwoSumS().FindNumbersWithSum(a,21);
    }
}
