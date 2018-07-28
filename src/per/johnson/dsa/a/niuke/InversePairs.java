package per.johnson.dsa.a.niuke;

/**
 * Created by Johnson on 2018/7/28.
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class InversePairs {
    public int InversePairs(int [] array) {
        if(array == null || array.length < 2) return 0;
        long s =calculate(array, 0, array.length - 1);
        return (int)(s%(long)1000000007);
    }
    private long calculate(int[] array, int lo, int hi){
        if(lo == hi) return 0;
        int mi = lo + ((hi - lo) >> 1);
        return calculate(array,lo,mi) + calculate(array,mi+1,hi) + calculate(array,lo,mi,hi);
    }

    private long calculate(int[] array, int lo, int mi , int hi){
        int[] help = new int[hi - lo + 1];
        int cur = 0 ;
        long count = 0;
        int l1 = lo;
        int l2 = mi + 1;
        while(l1 <= mi && l2 <=hi){
            if(array[l1] > array[l2]){
                count += hi - l2 + 1;
                help[cur++] = array[l1++];
            }else{
                help[cur++] = array[l2++];
            }
        }
        while(l1 <= mi){
            help[cur++] = array[l1++];
        }
        while(l2 <= hi){
            help[cur++] = array[l2++];
        }
        for(int k = 0; k<help.length; k++){
            array[k + lo] = help[k];
        }
        return count;

    }

    public static void main(String[] args) {
        int[] s = {1,2,3,4,5,6,7,0};
        System.out.println(new InversePairs().InversePairs(s));
    }
}
