package per.johnson.dsa.a.niuke;

/**
 * Created by Johnson on 2018/7/5.
 */
public class ReOrderArray {
    /**
     * 输入一个整数数组
     * 实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分
     * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     * @param array 输入数组
     */
    public static void reOrderArray(int [] array) {
        for(int i= 1 ; i< array.length; i++){
            if(isOod(array[i])){
                int j = i;
                while(j != 0 && !isOod(array[j-1])){
                    swap(array,j,j-1);
                    j--;
                }
            }
        }
    }
    private static void swap(int[] array, int i1, int i2){
        array[i1] = array[i1] + array[i2];
        array[i2] = array[i1] - array[i2];
        array[i1] = array[i1] - array[i2];
    }

    private static boolean isOod(int num){
        return (num & 1) == 1;
    }

    public static void main(String[] args) {
        int[] s = {1,6,9,4,3,26,7};
        reOrderArray(s);
        for(int si : s){
            System.out.println(si);
        }
    }
}
