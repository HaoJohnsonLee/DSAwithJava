package per.johnson.dsa.a.leetcode;

import per.johnson.dsa.a.basic.MergeSort;
import per.johnson.dsa.a.niuke.Merge;
import per.johnson.dsa.util.ArrayUtil;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Johnson on 2018/7/11.
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i<= k; i++){
            queue.offer(nums[i]);
        }
        for(int i = k + 1; i<nums.length; i++){
            int num = nums[i];
            if(num > queue.peek()){
                queue.poll();
                queue.offer(num);
            }
        }
        return queue.peek();
    }


    public static void main(String[] args) {
        int[] nums = {9, 3, 1, 10, 5, 7, 6, 2, 8, 0};
        System.out.println(new KthLargestElementInAnArray().findKthLargest(nums,5));
        MergeSort.sort(nums);
        System.out.println(ArrayUtil.array2String(nums));
    }
}
