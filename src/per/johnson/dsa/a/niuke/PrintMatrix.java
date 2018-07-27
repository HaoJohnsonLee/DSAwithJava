package per.johnson.dsa.a.niuke;

import java.util.ArrayList;

/**
 * Created by Johnson on 2018/7/5.
 */
public class PrintMatrix {
    /**
     *
     * @param matrix {{1,2,3,4},{5,6,7,8},{9,10,11,12}}
     * @return  1 2 3 4 8 12 11 10 9 5 6 7
     */
    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix.length == 0 || matrix[0] == null) return null;
        int sX = 0, sY = 0, eX = matrix.length-1, eY = matrix[0].length - 1;
        while(sX<=eX && sY <= eY){
            printOneCircle(list,matrix,sX++,sY++,eX--,eY--);
        }
        return list;
    }

    /**
     * 打印一圈
     *
     * @param list   存储位置
     * @param matrix 原始数组
     * @param sX     起始位置x
     * @param sY     起始位置y
     * @param eX     起始位置对角位置x
     * @param eY     起始位置对角位置y
     */
    private static void printOneCircle(ArrayList<Integer> list, int[][] matrix, int sX, int sY, int eX, int eY) {
        if (sX == eX) {  //同一行或列
            while (sY <= eY) {
                list.add(matrix[sX][sY++]);
            }
        } else if(sY == eY){
            while (sX <= eX) {
                list.add(matrix[sX++][sY]);
            }
        }
        else { //不同行列
            int tmp = sY;
            while (tmp <= eY) {
                list.add(matrix[sX][tmp++]);
            }
            tmp = sX + 1;
            while (tmp <= eX) {
                list.add(matrix[tmp++][eY]);
            }
            tmp = eY - 1;
            while (tmp >= sY) {
                list.add(matrix[eX][tmp--]);
            }
            tmp = eX - 1;
            while (tmp > sX) {
                list.add(matrix[tmp--][sY]);
            }

        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        ArrayList<Integer> s =printMatrix(matrix);
        for(int i : s){
            System.out.println(i);
        }
    }
}
