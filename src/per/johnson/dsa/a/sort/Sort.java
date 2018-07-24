package per.johnson.dsa.a.sort;

import java.util.Arrays;

/**
 * Created by Johnson on 2018/7/24.
 */
public class Sort {
    private int partition(int[] a, int lo, int hi){
        int i = lo;
        int j = lo + 1;
        int standard = a[lo];
        for(; j <= hi;j++){
            if(a[j] < standard){
                i++;
                swap(a,i ,j);
            }
        }
        swap(a, i , lo);
        return i;
    }
    private void swap(int[] a, int s, int e){
        int temp = a[s];
        a[s] = a[e];
        a[e] = temp;
    }

    private void quickSort(int[] arr,int lo, int hi){
        if(lo < hi){
            int partition = partition(arr, lo, hi);
            quickSort(arr,lo,partition - 1);
            quickSort(arr,partition+1,hi);
        }
    }

    public void quickSort(int[] arr){
        quickSort(arr,0,arr.length - 1);
    }

    public static void main(String[] args) {
        int[] a = {12,2,6,8,56,62,9,10,4,11};
        Sort qs = new Sort();
        qs.quickSort(a);
        System.out.println(Arrays.toString(a));
    }
}
