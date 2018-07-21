package per.johnson.dsa.a.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Johnson on 2018/7/11.
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        int hi = nums.length - 1;
        int index = partition(nums, 0 , hi);
        int lo = 0;
        while(index != k){
            if(index > k) {
                hi = index -1;
                index = partition(nums, lo, hi);
            }
            if(index < k) {
                lo = index;
                index = partition(nums, lo, hi);
            }
        }
        return nums[index];
    }
    private int partition(int[] nums, int lo, int hi){
        int miValue = nums[lo];
        while (lo < hi){
            while(nums[lo] < miValue)
                lo++;
            while (nums[hi] > miValue)
                hi --;
            swap(nums, lo, hi);
        }
        return lo;
    }
    private void swap(int[] nums, int pre, int last){
        int temp = nums[last];
        nums[last] = nums[pre];
        nums[pre] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {9, 3, 1, 10, 5, 7, 6, 2, 8, 0};
        System.out.println(new KthLargestElementInAnArray().findKthLargest(nums,5));
    }
}
