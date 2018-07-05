package per.johnson.dsa.a.niuke.nqueen;

/**
 * Created by Johnson on 2018/6/30.
 */


public class EightQueen {
    private static int row;  //当前处理的行
    private static boolean error;  //当前行到结尾 需要回溯

    public static int palceQueen(int N) {
        row = 0;
        error = false;
        int count = 0;
        int[] chess = new int[N];
        for (int i = 1; i < N; i++) chess[i] = -2;
        OUT:
        while (chess[0] != -2) {
            if (error) { //出错
                while (move(chess, N)) {
                    if (confirm(chess)) {
                        error = false;
                        continue OUT;
                    }
                }
            } else { //未出错，探测至下一步
                chess[++row] = -1;
                while (move(chess, N)) {
                    if (confirm(chess)) {
                        if (row == N - 1) { //找到解
                            count++;
                            error = true;
                            chess[row--] = -2;
                            continue OUT;
                        }
                        continue OUT;
                    }
                }
            }
        }
        return count;
    }

    private static boolean move(int[] chess, int N) {
        if (chess[row] + 1 == N) {//到达边界
            chess[row] = -2;
            row--;
            error = true;
            return false;
        }
        chess[row]++;
        return true;
    }

    private static boolean confirm(int[] chess) {
        int col = chess[row];
        for (int i = 0; i < row; i++) {
            if (chess[i] == col || (i + chess[i] == row + col) || i - chess[i] == row - col) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(palceQueen(4));
    }
}
