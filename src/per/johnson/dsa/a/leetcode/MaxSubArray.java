package per.johnson.dsa.a.leetcode;

/**
 * Created by Johnson on 2018/7/22.
 */
public class MaxSubArray {
    /**
     *
     * @param nums [-2,1,-3,4,-1,2,1,-5,4]
     *            f [-2,1,-2,4,3,5,6,1,5]
     * @return 6
     * [4,-1,2,1] has the largest sum = 6.
     */
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = nums[0];
        for(int i=1; i< nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            if(sum > max) max = sum;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new MaxSubArray().maxSubArray(nums));
    }

}
