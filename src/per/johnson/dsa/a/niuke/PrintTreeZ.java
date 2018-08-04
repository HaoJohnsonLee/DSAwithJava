package per.johnson.dsa.a.niuke;

import per.johnson.dsa.a.niuke.ds.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Johnson on 2018/8/3.
 *请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class PrintTreeZ {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        boolean flag = false;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if(pRoot == null) return list;
        ArrayList<Integer> tmp;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int leaf = 1;
        int nextLeaf = 0;
        while(!queue.isEmpty()){
            tmp = new ArrayList<>();
            while(leaf > 0){
                if(flag){
                    TreeNode node = queue.pollLast();
                    tmp.add(node.val);
                    if(node.right!=null){
                        queue.addFirst(node.right);
                        nextLeaf ++;
                    }
                    if(node.left!=null){
                        queue.addFirst(node.left);
                        nextLeaf ++;
                    }
                    leaf --;
                }else{
                    TreeNode node = queue.pollFirst();
                    tmp.add(node.val);
                    if(node.left!=null){
                        queue.addLast(node.left);
                        nextLeaf ++;
                    }
                    if(node.right!=null){
                        queue.addLast(node.right);
                        nextLeaf ++;
                    }
                    leaf --;
                }
            }
            list.add(tmp);
            flag = !flag;
            leaf = nextLeaf;
            nextLeaf = 0;
        }
        return list;
    }
}
