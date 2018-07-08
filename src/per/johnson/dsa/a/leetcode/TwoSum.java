package per.johnson.dsa.a.leetcode;

import java.util.HashMap;

public class TwoSum {
    /**
     * Original version
     * On2
     * @param nums input array
     * @param target sum of the numbers
     * @return
     *      the indexes of 2 numbers who added result is target
     */
    private static int[] twoSum(int[] nums,int target){
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    /**
     * Improvement version
     * On
     * @param nums input array
     * @param target sum of the numbers
     * @return
     *      the indexes of 2 numbers who added result is target
     */
    private static int[] twoSum1(int[] nums,int target){
        HashMap<Integer,Integer> solution=new HashMap<>(nums.length);
        for(int i=0;i<nums.length;i++){
            int result=target-nums[i];
            if(solution.containsKey(nums[i])){
                return new int[]{solution.get(nums[i]),i};
            }
            solution.put(result,i);
        }
        return null;
    }


    public static void main(String[] args) {
        int[] nums={2,9,11,7};
        int[] a=TwoSum.twoSum1(nums,9);
        if(a!=null)
            System.out.printf("%d  %d",a[0],a[1]);
    }
}
