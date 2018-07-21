package per.johnson.dsa.a.niuke;

import per.johnson.dsa.a.niuke.ds.TreeNode;

import java.util.Stack;

/**
 * Created by Johnson on 2018/7/8.
 */
public class Convert {
    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
     * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
     * @param pRootOfTree BST 根节点
     * @return 双向链表头结点
     */
    public TreeNode convert(TreeNode pRootOfTree) {
        Stack<TreeNode> stack = new Stack<>();
        save(pRootOfTree, stack);
        if(stack.empty()) return null;
        TreeNode root = stack.pop();
        while(!stack.empty()){
            TreeNode cur = stack.pop();
            root.left = cur;
            cur.right = root;
            root = root.left;
        }
        return root;
    }
    private void save(TreeNode pRootOfTree, Stack<TreeNode> stack){
        if(pRootOfTree != null){
            save(pRootOfTree.left,stack);
            stack.push(pRootOfTree);
            save(pRootOfTree.right, stack);
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);
        TreeNode node = new Convert().convert(root);
    }
}
