package per.johnson.dsa.a.basic;

import per.johnson.dsa.util.AlgorithmUtils;

/**
 * Created by Johnson on 2018/7/27.
 */
public class QuickSort {
    private static void quickSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int partition = partition(arr, lo, hi);
            quickSort(arr, lo, partition - 1);
            quickSort(arr, partition + 1, hi);
        }
    }
    private static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = lo + 1;
        int standard = a[lo];
        for (; j <= hi; j++) {
            if (a[j] < standard) {
                AlgorithmUtils.swap(a, ++i, j);
            }
        }
        AlgorithmUtils.swap(a, i, lo);
        return i;
    }
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
}
