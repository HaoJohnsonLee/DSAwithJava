package per.johnson.dsa.a.niuke;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Johnson on 2018/7/5.
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Main {


    /**
     * 二位数组
     * a[i][j] > a[i][j-1]
     * a[i][j] > a[i-1][j]
     * find target
     *
     * @param target target value
     * @param array  target array
     * @return true only if target in array
     */
    private static boolean Find(int target, int[][] array) {
        try {
            int row = array.length;
            int rol = array[0].length;
            for (int i = 0; i < row; i++) {
                if (array[i][0] <= target && array[i][rol - 1] >= target) {
                    int lo = 0;
                    int hi = rol;
                    while (lo < hi) {
                        int mi = (lo + hi) >> 1;
                        if (array[i][mi] > target) hi = mi;
                        else if (array[i][mi] == target) {
                            return true;
                        } else lo = mi + 1;
                    }
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * replace " "(space) to "%20"
     *
     * @param str target string
     * @return
     */
    public static String replaceSpace(StringBuffer str) {
        int origin = str.length();
        /**
        char[] temp = new char[origin << 1];
        int pos = 0;

        for (int i = 0; i < origin; i++) {
            char cur = str.charAt(i);
            if (cur == ' ') {
                temp[pos++] = '%';
                temp[pos++] = '2';
                temp[pos++] = '0';
            } else {
                temp[pos++] = cur;
            }
        }
        return String.valueOf(temp);**/
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < origin; i++) {
            char cur = str.charAt(i);
            if (cur == ' ') {
                sb.append("%20");
            } else {
                sb.append(cur);
            }
        }
        return sb.toString();
    }

    /**
     * 反转链表
     * @param listNode 链表
     * @return
     */
    private static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode == null) return new ArrayList<>();
        int[] s = new int[100];
        int size = 0;

        while(listNode !=null){
            s[size++] = listNode.val;
            listNode = listNode.next;
        }
        ArrayList<Integer> arrayList = new ArrayList<>(size);
        for(int i=size -1; i>=0; i--){
            arrayList.add(s[i]);
        }
        return arrayList;
    }

    /**
     * 根据前序遍历与中序遍历重建二叉树
     * @param pre 前序
     * @param in 中序
     * @return root
     */
    private static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(in.length == 0) return null;
        return reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
    }
    private static TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn){
        if(startPre > endPre || startIn > endIn) return null;
        TreeNode root = new TreeNode(pre[startPre]);
        for(int i = startIn; i<= endIn ; i++){
            if(in[i] == pre[startPre]){
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
                break;
            }
        }
        return root;
    }

    /**
     * 旋转数组
     * @param array
     * @return
     */
    public static int minNumberInRotateArray(int [] array) {
        if(array.length == 0)
            return 0;
        int lo = 0;
        int hi = array.length - 1;
        int mi;
        while(hi - lo > 1){
            mi = (hi + lo) >> 1;
            if(array[mi] >= array[lo]){
                lo = mi;
            }else{
                hi = mi;
            }
        }
        return array[hi];
    }
    public static void main(String[] args) {
        int[] a = {3,4,5,1,2};
        System.out.println(minNumberInRotateArray(a));
    }
}
