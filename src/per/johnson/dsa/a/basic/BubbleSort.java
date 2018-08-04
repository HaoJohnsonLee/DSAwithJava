package per.johnson.dsa.a.basic;

import per.johnson.dsa.util.AlgorithmUtils;

/**
 * Created by Johnson on 2018/7/27.
 */
public class BubbleSort {
    public static void sort(int[] array){
        if(array == null || array.length < 2) return;
        for (int e = array.length - 1; e > 0; e--) {
            for (int i = 0; i < e; i++) {
                if (array[i] > array[i + 1]) {
                    AlgorithmUtils.swap(array, i, i + 1);
                }
            }
        }
    }
}
