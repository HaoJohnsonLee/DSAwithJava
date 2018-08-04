package per.johnson.dsa.a.niuke;

import per.johnson.dsa.a.niuke.ds.TreeNode;

/**
 * Created by Johnson on 2018/8/3.3
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class IsSymmetrical {
    boolean isSymmetrical(TreeNode pRoot) {
        return pRoot == null || isMirror(pRoot.left, pRoot.right);
    }
    boolean isMirror(TreeNode l, TreeNode r){
        if(l==null && r ==null) return true;
        if(l==null || r==null) return false;
        return l.val == r.val && (isMirror(l.left, r.right) && isMirror(l.right, r.left));
    }
}
