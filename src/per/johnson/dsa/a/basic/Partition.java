package per.johnson.dsa.a.basic;

import per.johnson.dsa.util.ArrayUtil;

import java.util.Arrays;

/**
 * Created by Johnson on 2018/7/27.
 */
public class Partition {
    /**
     * @param array [1,8,3,2,7,9]
     * @param basic 5
     *              array -> [1,3,2,8,7,9]
     */
    private static void partition1(int[] array, int basic) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= basic) {
                ArrayUtil.swap(array, i, ++index);
            }
        }
    }

    /**
     * @param array 16,7,10,9,2,32,10,1,9,15,10,6,7
     * @param basic 10
     *              array --> 7,9,2,1,9,6,7,10,10,10,16,32,15
     */
    private static void partition0(int[] array, int basic) {
        int L = -1;
        int R = array.length;
        int i = 0;
        while (i < array.length) {
            if( R == i + 1)break;
            if (array[i] < basic) {
                ArrayUtil.swap(array, i, ++L);
                i++;
            } else if (array[i] > basic) {
                ArrayUtil.swap(array, i, --R);
            } else {
                i++;
            }
        }

    }

    public static void main(String[] args) {
        //int[] s = ArrayUtil.randomArray(10, 20);
        int[] s = {16, 7, 10, 8, 2, 32, 10, 1, 9, 15, 10, 6, 7};
        System.out.println(Arrays.toString(s));
        partition0(s, 10);
        System.out.println(Arrays.toString(s));
    }
}
