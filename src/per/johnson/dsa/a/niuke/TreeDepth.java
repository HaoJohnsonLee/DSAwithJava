package per.johnson.dsa.a.niuke;

import per.johnson.dsa.a.niuke.ds.TreeNode;

/**
 * Created by Johnson on 2018/7/28.
 */
public class TreeDepth {
    public int TreeDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(TreeDepth(root.left) , TreeDepth(root.right)) + 1;
    }
}
