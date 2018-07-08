package per.johnson.dsa.a.niuke;
import per.johnson.dsa.a.niuke.ds.TreeNode;
/**
 * Created by Johnson on 2018/7/5.
 */
public class HasSubtree {
    /**
     * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     * @param root1 父树
     * @param root2 可能的子树
     * @return
     */
    public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if(root1 != null && root2 !=null){
            if(root1.val == root2.val){ // 找到相同根结点
                result = doesTree1HaveTree2(root1, root2);
            }
            if(!result){
                result = HasSubtree(root1.left, root2);
            }
            if(!result){
                result = HasSubtree(root1.right, root2);
            }
        }
        return result;

    }

    /**
     *  根节点相同的两树，是否包含
     * @param r1 父树
     * @param r2 子树
     * @return true 如果包含
     */
    private static boolean doesTree1HaveTree2(TreeNode r1, TreeNode r2){
        if(r2 == null)
            return true;
        if(r1 == null)
            return false;
        if(r1.val != r2.val)
            return false;
        return doesTree1HaveTree2(r1.left,r2.left)&&doesTree1HaveTree2(r1.right,r2.right);
    }
}
