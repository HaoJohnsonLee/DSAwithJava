package per.johnson.dsa.a.niuke;

/**
 * Created by Johnson on 2018/7/23.
 */
public class FindGreatestSumOfSubArray {
    /**
     *
     * @param array 6,-3,-2,7,-15,1,2,2
     * @return 8
     */
    public int findGreatestSumOfSubArray(int[] array) {
        int max = array[0];
        int cur = array[0];
        for(int i = 1; i< array.length; i++){
             cur = cur < 0 ? array[i] : (cur + array[i]);
             max = cur > max ? cur : max;
        }
        return max;
    }
    public static void main(String[] args) {
        int [] arr = new int[]{6,-3,-2,7,-15,1,2,2};
        System.out.println(new FindGreatestSumOfSubArray().findGreatestSumOfSubArray(arr));
    }
}
