package per.johnson.dsa.a.basic;

import java.util.Arrays;

/**
 * Created by Johnson on 2018/7/27.
 */
public class MergeSort {

    public static void sort(int[] array){
        if(array == null || array.length < 2) return;
        sort(array,0,array.length -1);
    }

    private static void sort(int[] array, int lo, int hi){
        if(lo == hi) return;
        int mi = lo + ((hi - lo) >> 1);
        sort(array,lo,mi);
        sort(array,mi + 1,hi);
        merge(array,lo,hi,mi);
    }
    private static void merge(int[] array, int lo, int hi, int mi){
        int[] help = new int[hi - lo + 1];
        int L = lo;
        int R = mi + 1;
        int i = 0;
        while(L <= mi && R <= hi){
            if(array[L] < array[R]){
                help[i++] = array[L++];
            }else{
                help[i++] = array[R++];
            }
        }
        if(L > mi){
            for(int j = R; j <= hi; j++)
                help[i++] = array[j];
        }
        if(R > hi){
            for(int j = L; j <= mi; j++)
                help[i++] = array[j];
        }
        for(int k = 0; k<help.length; k++){
            array[lo + k] = help[k];
        }
    }

    public static void main(String[] args) {
        int[] s = {16, 7, 10, 8, 2, 32, 10, 1, 9, 15, 10, 6, 7};
        sort(s);
        System.out.println(Arrays.toString(s));
    }
}
