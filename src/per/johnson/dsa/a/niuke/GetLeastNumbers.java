package per.johnson.dsa.a.niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Johnson on 2018/7/19.
 */
public class GetLeastNumbers {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> s = new ArrayList<>(k);
        if(input == null || input.length < k) return s;
        generate(input,k,0,input.length - 1);
        for(int i =0; i<k; i++)
            s.add(input[i]);
        return s;
    }
    private static void generate(int[] input, int k, int lo, int hi){
        int cur = input[lo];
        while(lo < hi){
            while(input[lo] <= cur)
                lo++;
            while(input[hi] >= cur)
                hi--;
            if(lo < hi)
                swap(input, hi , lo);
        }
        if(lo == k) return;
        else if(lo > k) generate(input,k,0,lo);
        else generate(input,k,lo,hi);
    }

    private static void swap(int[] input, int s, int e){
        int temp = input[s];
        input[s] = input[e];
        input[e] = temp;
    }
    private static ArrayList<Integer> GetLeastNumbers_Solution0(int[] input, int k){
        ArrayList<Integer> s = new ArrayList<>(k);
        if(input == null || input.length < k) return s;
        Arrays.sort(input);
        for(int i=0; i< k; i++){
            s.add(input[i]);
        }
        return s;
    }
    public static void main(String[] args) {
        int[] input = {4,5,1,6,2,7,3,8,15,0};
        ArrayList<Integer> s =GetLeastNumbers_Solution0(input,4);
        Collections.sort(s);
        for (int num : s){
            System.out.println(num);
        }
    }
}
