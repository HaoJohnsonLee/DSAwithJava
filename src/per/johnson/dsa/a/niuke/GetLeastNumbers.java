package per.johnson.dsa.a.niuke;

import java.util.*;

/**
 * Created by Johnson on 2018/7/19.
 */
public class GetLeastNumbers {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> s = new ArrayList<>(k);
        if(input.length < k || k<=0) return s;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int i = 0; i < k;i++){
            queue.add(input[i]);
        }
        for(int i = k ; i<input.length;i++){
            if(input[i] < queue.peek()){
                queue.poll();
                queue.add(input[i]);
            }
        }
        while(!queue.isEmpty()){
            s.add(queue.poll());
        }
        return s;
    }
    public static void main(String[] args) {
        int[] input = {4,5,1,6,2,7,3,8,15,0};
        ArrayList<Integer> s =GetLeastNumbers_Solution(input,100);
        Collections.sort(s);
        for (int num : s){
            System.out.println(num);
        }
    }
}
