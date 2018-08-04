package per.johnson.dsa.a.basic;

import per.johnson.dsa.util.AlgorithmUtils;

import java.util.Arrays;

/**
 * Created by Johnson on 2018/7/27.
 */
public class BucketSort {
    public static void sort(int[] array, int lo, int hi){
        int max = Integer.MIN_VALUE;
        for(int i=0; i< array.length; i++){
            if(array[i] > max) max = array[i];
        }
        int[] map = new int[max + 1];
        Arrays.fill(map,0);
        for(int i = lo; i<= hi; i++){
            map[array[i]] ++;
        }
        int cur = 0;
        for(int j=0; j<map.length; j++){
            while(map[j]>0){
                array[cur++] = j;
                map[j] --;
            }
        }
    }
    public static void sort(int[] array){
        sort(array,0,array.length - 1);
    }

    public static void main(String[] args) {
        int[] a = AlgorithmUtils.randomArray(30,50);
        int[] b = AlgorithmUtils.arrayCopy(a);
        System.out.println(AlgorithmUtils.array2String(a));
        HeapSort.heapSort(b);
        sort(a);
        System.out.println(AlgorithmUtils.array2String(a));
        System.out.println(AlgorithmUtils.isEquals(a,b));
    }
}
