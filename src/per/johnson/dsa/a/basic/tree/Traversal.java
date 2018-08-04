package per.johnson.dsa.a.basic.tree;

import per.johnson.dsa.a.niuke.ds.TreeNode;
import per.johnson.dsa.util.AlgorithmUtils;

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
        if (root == null) return;
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
        if (root == null) return;
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
     *
     * @param root   root
     * @param result 结果集
     */
    public static void postOrder(TreeNode root, ArrayList<Integer> result) {
        if (root == null) return;
        Stack<TreeNode> first = new Stack<>();
        Stack<TreeNode> last = new Stack<>();
        first.push(root);
        while (!first.empty()) {
            TreeNode cur = first.pop();
            last.push(cur);
            if (cur.left != null) first.push(cur.left);
            if (cur.right != null) first.push(cur.right);
        }
        while (!last.empty()) {
            result.add(last.pop().val);
        }
    }

    /**
     * 层次遍历
     *
     * @param root   root
     * @param result 结果集
     */
    public static void floorOrder(TreeNode root, ArrayList<Integer> result) {
        if (root == null) return;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            result.add(cur.val);
            if (cur.left != null) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);
        }
    }


    public static void morrisIn(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        TreeNode cur = root; // 当前指针
        TreeNode mostRight;  // 当前指针左子树的最右结点
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            result.add(cur.val);
            cur = cur.right;
        }
    }


    public static void morrisPre(TreeNode root, ArrayList<Integer> result) {
        if (root == null) return;
        TreeNode cur = root;
        TreeNode mostRight;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == cur) {
                    mostRight.right = null;
                } else {
                    result.add(cur.val);
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }

            }else{
                result.add(cur.val);
            }
            cur = cur.right;
        }
    }


    public static void morrisPost(TreeNode root, ArrayList<Integer> result){
        if (root == null) {
            return;
        }
        TreeNode cur = root; // 当前指针
        TreeNode mostRight;  // 当前指针左子树的最右结点
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                    addRightEdgeReversed(cur.left,result);
                }
            }
            addRightEdgeReversed(root,result);
            cur = cur.right;
        }
    }

    /**
     * 逆序添加 node 的右子树及其本身
     * @param node node
     * @param result 结果集
     */
    private static void addRightEdgeReversed(TreeNode node, ArrayList<Integer> result){

    }

    public static void morrisLeft(TreeNode root, ArrayList<Integer> result) {
        if (root == null) return;
        TreeNode cur = root;
        TreeNode mostLeft;
        while (cur != null) {
            mostLeft = cur.right;
            if (mostLeft != null) {
                while (mostLeft.left != null && mostLeft.left != cur) {
                    mostLeft = mostLeft.left;
                }
                if (mostLeft.left == cur) {
                    mostLeft.left = null;
                } else {
                    mostLeft.left = cur;
                    cur = cur.right;
                    continue;
                }
            }
            result.add(cur.val);
            cur = cur.left;
        }
    }

    public static void main(String[] args) {
        TreeNode root = AlgorithmUtils.buildBinTree();
        AlgorithmUtils.printTree(root);
        ArrayList<Integer> result = new ArrayList<>();
        morrisIn(root, result);
        System.out.println(AlgorithmUtils.array2String(result));
    }
}
