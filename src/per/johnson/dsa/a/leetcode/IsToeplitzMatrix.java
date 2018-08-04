package per.johnson.dsa.a.leetcode;

/**
 * Created by Johnson on 2018/7/29.
 */
public class IsToeplitzMatrix {
    /**
     * @param matrix: the given matrix
     * @return: True if and only if the matrix is Toeplitz
     *  1  2  3  4
     *  5  1  2  3
     *  9  5  1  2   --> true
     */
    public static boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix == null) return false;
        if(matrix.length<=1 || matrix[0].length <=1) return true;
        int[] expect = new int[matrix[0].length];
        for(int i = 0; i<expect.length;i++){
            expect[i] = -1;
        }
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[i].length; j++){
                if(expect[j]>0 && expect[j] != matrix[i][j]) return false;
                else{
                    if(j !=0) expect[j] = matrix[i][j - 1];
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        int[][] a = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        System.out.println(isToeplitzMatrix(a));
    }
}
