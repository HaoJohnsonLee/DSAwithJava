package per.johnson.dsa.a.niuke.nqueen;

/**
 * 使用循环控制来实现回溯，解决N皇后
 * 开辟两个变量控制行和列，避免不必要的计算，空间换时间
 * @author newflydd@189.cn
 * Time : 2016年1月1日 下午9:37:32
 */
public class EightQueen5 {
    private static short K=10;
    private static short N=0;
    private static boolean dead=false;    //下方走到了死路
    private static short row=0;

    public static void main(String[] args) {
        for (N = 10; N <= 10; N++) {
            long begin = System.currentTimeMillis();
            row=0;
            dead=false;
            long count = 0;
            /**
             * -2：初始状态，尚未摆放 -1：开始尝试摆放 0到N-1：皇后安全的摆放在这一列的哪一行
             */
            short[] chess = new short[N];
            for (short i = 1; i < N; i++)
                chess[i] = -2;
            OUT: while (chess[0] != -2) {
                if (dead) {
                    /**
                     * 如果下方的皇后已经摆无可摆，已经走到死路 则要将当前最后一个安全的皇后右移 右移成功后，判断安全性
                     * 安全：dead清除，继续外部循环 不安全，则继续右移，直至边界溢出，再次死路
                     */
                    while (moveStep(chess)) {
                        if (isSafety(chess)) {
                            dead = false;
                            continue OUT;
                        }
                    }

                } else {
                    /**
                     * 如果当前状态下的安全棋盘并没有接受到下方传来的死路信号 则需要进一步探测下一行的摆放位置
                     */
                    chess[++row] = -1; // 准备对下一层摆放皇后
                    while (moveStep(chess)) {
                        if (isSafety(chess)) {
                            if (row == N  - 1) { // 如果最后一行找到了一个可能解
                                count++; // 计数+1
                                /**
                                 * 找到解以后，dead设为死路，最后一行清掉皇后
                                 */
                                dead = true;
                                chess[N - 1] = -2;
                                row--;
                                continue OUT;
                            }
                            continue OUT;
                        }
                    }
                }
            }
            long end = System.currentTimeMillis();
            System.out.println("解决 " + N + "皇后问题，用时：" + String.valueOf(end - begin) + "毫秒，计算结果："
                    + count);
        }
    }


    private static boolean moveStep(short[] chess) {
        if(chess[row]+1>=N){
            /**
             * 摆到边界，清空当前行的摆放记录，标志死路
             */
            chess[row]=-2;
            row--;
            dead=true;
            return false;
        }
        chess[row]=(short) (chess[row]+1);
        return true;
    }

    private static boolean isSafety(short[] chess) {
        //short col=chess[row];

        int col = chess[row];
        for(int i=0; i< row ; i++){
            if(chess[i] == col || (i + chess[i] == row + col) || i-chess[i] == row - col)return false;
        }
        return true;
    }
}
