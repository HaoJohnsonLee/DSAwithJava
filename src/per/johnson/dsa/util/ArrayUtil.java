package per.johnson.dsa.util;

import per.johnson.dsa.a.niuke.ds.ListNode;
import per.johnson.dsa.a.niuke.ds.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Johnson on 2018/7/27.
 */
public class ArrayUtil {
    public static int[] randomArray(int minSize, int maxSize){
        Random random = new Random();
        int capacity = (random.nextInt(1) * (maxSize - minSize)) + maxSize;
        int[] array = new int[capacity];
        for(int i = 0; i<array.length; i++){
            array[i] = random.nextInt(maxSize);
        }
        return array;
    }

    public static void swap(int[] array, int s0,int s1){
        if(s0 == s1) return;
        array[s0] = array[s1] ^ array[s0];
        array[s1] = array[s0] ^ array[s1];
        array[s0] = array[s0] ^ array[s1];
    }

    public static String array2String(int[] array){
        return Arrays.toString(array);
    }

    public static String array2String(ArrayList<Integer> integers){
        StringBuilder sb = new StringBuilder("[");
        for(int i=0; i<integers.size() - 1 ; i++)
            sb.append(integers.get(i)).append(",");
        sb.append(integers.get(integers.size() -1)).append("]");
        return sb.toString();
    }

    public static boolean isEquals(int[] array1, int[] array2){
        if(array1 == null || array2 == null)
            throw new NullPointerException("Exist null array!");
        if(array1.length != array2.length) return false;

        for(int i = 0; i< array1.length; i++){
            if (array1[i] != array2[i]) return false;
        }
        return true;
    }

    public static int[] arrayCopy(int[] array){
        if (array == null) throw new NullPointerException("Null input array");
        int[] a = new int[array.length];
        System.arraycopy(array,0,a,0,a.length);
        return a;
    }

    public static String linkedList2String(ListNode node){
        StringBuilder sb = new StringBuilder("[");
        while(true){
            if(node.next == null){
                sb.append(node.val);
                sb.append("]");
                break;
            }
            sb.append(node.val).append(",");
            node = node.next;
        }
        return sb.toString();
    }

    public static ListNode array2LinkedList(int[] array){
        if(array == null || array.length == 0)return null;
        ListNode head = new ListNode(array[0]);
        ListNode tmp = head;
        for(int i=1;i<array.length;i++){
            tmp.next = new ListNode(array[i]);
            tmp = tmp.next;
        }
        return head;
    }

    /**
     *                           15
     * @return                |    \
     *                        8      1
     *                      | \     |  \
     *                    16  6    3   10
     *                    |
     *                    2
     *      pre   -> 15 8 16 2 6 1 3 10
     *      in    -> 2 16 8 6 15 3 1 10
     *      post  -> 2 16 6 8 3 10 1 15
     *      floor -> 15 8 1 16 6 3 10 2
     */
    public static TreeNode buildBinTree(){
        TreeNode root = new TreeNode(15);
        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(16);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(6);
        TreeNode t6 = new TreeNode(3);
        TreeNode t7 = new TreeNode(10);
        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t1.right = t5;
        t3.left = t4;
        t2.left = t6;
        t2.right = t7;
        return root;
    }
}
