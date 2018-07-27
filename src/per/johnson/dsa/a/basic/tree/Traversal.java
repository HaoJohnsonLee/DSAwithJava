package per.johnson.dsa.a.basic.tree;

import per.johnson.dsa.a.niuke.ds.TreeNode;
import per.johnson.dsa.util.ArrayUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Johnson on 2018/7/27.
 */
public class Traversal {
    /**
     * 前序遍历递归版本
     *
     * @param root   root
     * @param result 结果集
     */
    public static void preOrder0(TreeNode root, ArrayList<Integer> result) {
        if (root != null) {
            result.add(root.val);
            preOrder0(root.left, result);
            preOrder0(root.right, result);
        }
    }

    /**
     * 中序遍历递归版本
     *
     * @param root   root
     * @param result 结果集
     */
    public static void inOrder0(TreeNode root, ArrayList<Integer> result) {
        if (root != null) {
            inOrder0(root.left, result);
            result.add(root.val);
            inOrder0(root.right, result);
        }
    }

    /**
     * 后序遍历递归版本
     *
     * @param root   root
     * @param result 结果集
     */
    public static void postOrder0(TreeNode root, ArrayList<Integer> result) {
        if (root != null) {
            postOrder0(root.left, result);
            postOrder0(root.right, result);
            result.add(root.val);
        }
    }

    /**
     * 前序遍历非递归版本
     *
     * @param root   root
     * @param result 结果集
     */
    public static void preOrder(TreeNode root, ArrayList<Integer> result) {
        if(root == null)return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }


    /**
     * 中序遍历非递归版本
     *
     * @param root   root
     * @param result 结果集
     */
    public static void inOrder(TreeNode root, ArrayList<Integer> result) {
        if(root == null)return;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.empty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
    }

    /**
     * 后续遍历非递归版本
     * @param root
     * @param result
     */
    public static void postOrder(TreeNode root, ArrayList<Integer> result){
        if(root == null)return;

    }

    /**
     * 层次遍历
     * @param root root
     * @param result 结果集
     */
    public static void floorOrder(TreeNode root, ArrayList<Integer> result){
        if(root == null)return;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            result.add(cur.val);
            if(cur.left!=null) queue.add(cur.left);
            if(cur.right!=null) queue.add(cur.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = ArrayUtil.buildBinTree();
        ArrayList<Integer> result = new ArrayList<>();
        floorOrder(root, result);
        System.out.println(ArrayUtil.array2String(result));
    }
}
