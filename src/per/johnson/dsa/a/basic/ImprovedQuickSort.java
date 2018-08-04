package per.johnson.dsa.a.basic;

import per.johnson.dsa.util.AlgorithmUtils;

/**
 * Created by Johnson on 2018/7/27.
 */
public class ImprovedQuickSort {

    public static void quickSort(int[] array) {
        if (array == null || array.length < 2) return;
        quickSort(array, 0, array.length - 1);
    }

    /**
     * @param array 2 8 9 6 8 5 9
     * @param lo    0
     * @param hi    6
     * @return array  -> 2 5 6 8 8 9 9  {0,0}
     */
    private static int[] partition(int[] array, int lo, int hi) {
        int R = hi;
        int L = lo - 1;
        while (lo < R) {
            if (array[lo] > array[hi]) AlgorithmUtils.swap(array, lo, --R);
            else if (array[lo] < array[hi]) AlgorithmUtils.swap(array, lo++, ++L);
            else lo++;
        }
        AlgorithmUtils.swap(array, lo, hi);
        return new int[]{++L, R};
    }

    private static void quickSort(int[] array, int lo, int hi) {
        if(lo < hi) {
            int[] is = partition(array, lo, hi);
            quickSort(array, lo, is[0] - 1);
            quickSort(array, is[1] + 1, hi);
        }
    }

    public static void main(String[] args) {
        int[] array = AlgorithmUtils.randomArray(10,20);
        int[] array2 = AlgorithmUtils.arrayCopy(array);
        System.out.println(AlgorithmUtils.isEquals(array,array2));
        quickSort(array);
        QuickSort.quickSort(array2);
        System.out.println(AlgorithmUtils.isEquals(array,array2));
    }
}
