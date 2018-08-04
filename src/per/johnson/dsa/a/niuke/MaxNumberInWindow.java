package per.johnson.dsa.a.niuke;

import per.johnson.dsa.util.AlgorithmUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Johnson on 2018/8/3.
 *
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5};
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}，
 * {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}，
 * {2,3,4,2,6,[2,5,1]}。
 */
public class MaxNumberInWindow {
    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if(num.length < size || size == 0) return list;
        LinkedList<Integer> queue = new LinkedList<>();
        int l = 0;
        int r = 0;
        while(r < num.length){
            while(!queue.isEmpty()&&queue.peekFirst() < l){
                queue.pollFirst();
            }
            while (!queue.isEmpty()&& num[queue.peekLast()] < num[r]){
                queue.pollLast();
            }
            queue.addLast(r);
            r++;
            if(r > size - 1){
                list.add(num[queue.peekFirst()]);
                l++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,4,2,6,2,5,1};
        System.out.println(AlgorithmUtils.array2String(maxInWindows(nums,3)));
    }
}
