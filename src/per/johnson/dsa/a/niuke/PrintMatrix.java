package per.johnson.dsa.a.niuke;

import java.util.ArrayList;

/**
 * Created by Johnson on 2018/7/5.
 */
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if(matrix.length == 0 || matrix[0] == null)return null;
        int rows = matrix.length-1;
        int rols = matrix[0].length-1;
        int lo = 0;
        int hi = rols;
        while(hi > lo){
            printOneCircle(list, matrix,lo,lo);
            lo++;
            hi--;
        }

        return list;
    }

    /**
     * 打印一圈
     * @param list 存储位置
     * @param matrix 原始数组
     * @param sX 起始位置x
     * @param sY 起始位置y
     */
    private static void printOneCircle(ArrayList<Integer> list,int[][] matrix,int sX, int sY){
        if(sX == sY){
            list.add(matrix[sX][sY]);
            return;
        }
        int curX = sX;
        int curY = sY;


    }
}
