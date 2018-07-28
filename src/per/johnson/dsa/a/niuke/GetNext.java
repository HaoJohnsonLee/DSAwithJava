package per.johnson.dsa.a.niuke;

import per.johnson.dsa.a.niuke.ds.TreeLinkNode;
import per.johnson.dsa.util.ArrayUtil;

/**
 * Created by Johnson on 2018/7/28.
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class GetNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode == null)return null;
        if(pNode.right !=null) {
            pNode = pNode.right;
            while(true){
                if(pNode.left == null) return pNode;
                pNode = pNode.left;
            }
        }
        if(isLeftChild(pNode)) return pNode.next;
        else if(isRightChild(pNode)){
            while((pNode = pNode.next) !=null){
                if(isLeftChild(pNode))
                    return pNode.next;
            }
        }
        return null;
    }

    private boolean isLeftChild(TreeLinkNode node){
        return node!=null&&node.next!=null && node.next.left == node;
    }
    private boolean isRightChild(TreeLinkNode node){
        return node!=null&&node.next!=null && node.next.right == node;
    }

    public static void main(String[] args) {
        TreeLinkNode root = ArrayUtil.buildBinTree(15);
        while(true){
            if(root.left == null) break;
            root = root.left;
        }
        GetNext next = new GetNext();
        while(root!=null){
            System.out.println(root.val);
            root = next.GetNext(root);
        }
    }
}
