package per.johnson.dsa.a.basic;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Johnson on 2018/7/30.
 * 一个二维矩阵 只含 0 1 求 1 围成的最大矩形
 * 先将二维数组转换为一维直方图形式
 * 通过单调栈求解 O (N * M)
 */
public class MaxRecFromBottom {

    private static int getMaxArea(int[][] array){
        if(array == null || array.length <1 || array[0].length < 1) return 0;
        int[] s = new int[array[0].length];
        int max = 0;
        for(int i = 0; i< array.length; i++){
            for(int j=0; j<array[0].length;j++){
                s[j] = array[i][j] == 1 ?  s[j] + 1 : 0;
            }
            max = Math.max(max,maxRecFromBottom(s));

        }
        return max;
    }


    // [4,3,2,5,6] -> 10
    private static int maxRecFromBottom(int[] array){
        if(array == null || array.length < 1) return 0;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();   // 最小单调栈 index
        for(int i=0; i<array.length; i++){
            while(!stack.empty() && array[stack.peek()] >= array[i]){  //出栈
                int cur = stack.pop();
                int last = stack.empty() ? -1 : stack.peek();
                int curArea = array[cur] * (i - last - 1);
                maxArea = Math.max(maxArea,curArea);
            }
            stack.push(i);
        }
        while(!stack.empty()){
            int cur = stack.pop();
            int last = stack.empty() ? -1 : stack.peek();
            int curArea = array[cur] * (array.length - last - 1);
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[][] map = {{1,0,1,1},{1,1,1,1},{1,1,1,0}};
        System.out.println(getMaxArea(map));
    }
}
