package per.johnson.dsa.a.niuke;

/**
 * Created by Johnson on 2018/7/5.
 */
public class Mirror {
    /**
     * 二叉树的镜像定义：源二叉树
     *     	    8
     *     	   /  \
     *     	  6   10
     *     	 / \  / \
     *     	5  7 9 11
     *     	镜像二叉树
     *     	    8
     *     	   /  \
     *     	  10   6
     *     	 / \  / \
     *     	11 9 7  5
     * @param root root 结点
     */
    public static void Mirror(TreeNode root) {
        if(root == null)return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }
}
