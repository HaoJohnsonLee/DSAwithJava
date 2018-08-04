package per.johnson.dsa.a.basic;

import per.johnson.dsa.util.AlgorithmUtils;

import java.util.LinkedList;

/**
 * Created by Johnson on 2018/7/29.
 */
public class GetMaxWindow {
    public static int[] getMaxWindow(int [] array, int window){
        if(array == null || window < 1 || array.length < window)
            return null;
        int[] max = new int[array.length - window + 1];
        // 双端链表 存储array下标
        LinkedList<Integer> qmax = new LinkedList<>();
        int cur = 0;
        for(int i = 0; i< array.length; i++){
            while(!qmax.isEmpty() && array[qmax.peekLast()] <= array[i]){
                qmax.pollLast();
            }
            qmax.add(i);
            if(qmax.peekFirst() <= i - window)
                qmax.pollFirst();
            if(i >= window - 1)
                max[cur++] = array[qmax.peekFirst()];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = AlgorithmUtils.randomArray(5,10);
        System.out.println(AlgorithmUtils.array2String(a));
        int[] max = getMaxWindow(a,3);
        System.out.println(AlgorithmUtils.array2String(max));
    }
}
