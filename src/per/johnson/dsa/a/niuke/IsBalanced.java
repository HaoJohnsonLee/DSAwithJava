package per.johnson.dsa.a.niuke;

import per.johnson.dsa.a.niuke.ds.TreeNode;

/**
 * Created by Johnson on 2018/7/28.
 */
public class IsBalanced {
    public boolean IsBalanced_Solution(TreeNode root) {
        Boolean res = Boolean.TRUE;
        getHeight(root,1,res);
        return res;
    }
    private int getHeight(TreeNode node, int level, Boolean res){
        if(node == null) return level;
        int lH = getHeight(node.left,level+1,res);
        if(!res) return level;
        int rH = getHeight(node.right,level+1,res);
        if(!res) return level;
        if(Math.abs(lH - rH) > 1)res = Boolean.FALSE;
        return Math.max(lH,rH);
    }
}
