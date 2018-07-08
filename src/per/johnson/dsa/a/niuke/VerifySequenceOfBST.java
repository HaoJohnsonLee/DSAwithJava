package per.johnson.dsa.a.niuke;

/**
 * Created by Johnson on 2018/7/6.
 */
public class VerifySequenceOfBST {
    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
     * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
     * @param sequence 整数数组
     * @return
     */
    public static boolean VerifySequenceOfBST(int [] sequence) {
        if(sequence.length == 0) return false;
        return VerifySequenceOfBST(sequence,0, sequence.length);
    }
    public static boolean VerifySequenceOfBST(int[] sequence, int lo, int hi){ //[lo,hi）
        if(lo >= hi) return true;
        int root = sequence[hi-1];
        int i= lo;
        while(root > sequence[i]) i++;
        int h = i;
        while(i < hi-1){
            if(root > sequence[i])return false;
            i++;
        }
        return VerifySequenceOfBST(sequence,lo,h-1)&&VerifySequenceOfBST(sequence,h,hi-1);
    }
}
