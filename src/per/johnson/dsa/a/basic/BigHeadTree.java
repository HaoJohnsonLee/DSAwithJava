package per.johnson.dsa.a.basic;

import per.johnson.dsa.a.niuke.ds.TreeNode;
import per.johnson.dsa.util.AlgorithmUtils;

/**
 * Created by Johnson on 2018/7/29.
 * 给一个数组，生成一棵树，树的根结点均大于子节点
 */
public class BigHeadTree {
    public TreeNode buildBigHeadTree(int[] array){
        heapify(array);
        TreeNode root = new TreeNode(array[0]);
        TreeNode tmp = root;
        for(int i = 1; i<array.length - 1; i+=2){
            tmp.left = new TreeNode(array[i]);
            tmp.right = new TreeNode(array[i + 1]);
            tmp = tmp.left;
        }
        return root;
    }
    private void heapify(int[] array){
        for(int i = 0; i< array.length; i++){
            int cur = i;
            int parent;
            while(array[cur] > array[parent = getParent(cur)]){
                AlgorithmUtils.swap(array,cur,parent);
                cur = getParent(cur);
            }
        }
    }
    private int getParent(int index){
        return (index - 1) / 2;
    }

    public static void main(String[] args) {
        BigHeadTree t = new BigHeadTree();
        int [] a = {3,2,4,1,0,5};
        TreeNode root = t.buildBigHeadTree(a);
        AlgorithmUtils.printTree(root);
    }
}
