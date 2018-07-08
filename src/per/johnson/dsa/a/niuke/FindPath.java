package per.johnson.dsa.a.niuke;

import per.johnson.dsa.a.niuke.ds.TreeNode;

import java.util.ArrayList;

/**
 * Created by Johnson on 2018/7/6.
 */
public class FindPath {

    ArrayList<ArrayList<Integer>> allPath = new ArrayList<>();
    ArrayList<Integer>  path = new ArrayList<>();

    /**
     * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     * @param root root
     * @param target target
     * @return path
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root == null) return  allPath;
        path.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null) //递归基
            allPath.add(new ArrayList<>(path));
        this.FindPath(root.left,target);
        this.FindPath(root.right,target);
        path.remove(path.size()-1); // 回溯
        return allPath;
    }
}
