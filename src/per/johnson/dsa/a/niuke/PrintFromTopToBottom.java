package per.johnson.dsa.a.niuke;

import per.johnson.dsa.a.niuke.ds.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Johnson on 2018/7/6.
 */
public class PrintFromTopToBottom {
    /**
     * 二叉树层次遍历
     * @param root 根节点
     * @return 层次遍历顺序
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left!=null) queue.offer(node.left);
            if (node.right!=null) queue.offer(node.right);
        }
        return list;
    }
}
