package per.johnson.dsa.a.niuke;

import per.johnson.dsa.a.niuke.ds.TreeNode;
import per.johnson.dsa.util.AlgorithmUtils;

/**
 * Created by Johnson on 2018/7/29.
 */
public class SerializeDeserialize {
    public String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) sb.append("#_");
        else {
            sb.append(root.val).append("_");
            sb.append(Serialize(root.left));
            sb.append(Serialize(root.right));
        }
        return sb.toString();
    }

    public TreeNode Deserialize(String tree) {
        return Deserialize(tree.split("_"));
    }
    int i = 0;
    private TreeNode Deserialize(String[] s) {
        TreeNode root = null;
        if (i >= s.length) return null;
        if (!s[i].equals("#")) {
            root = new TreeNode(Integer.valueOf(s[i]));
            i++;
            root.left = Deserialize(s);
            root.right = Deserialize(s);
        }else i++;
        return root;
    }

    public static void main(String[] args) {
        SerializeDeserialize sd = new SerializeDeserialize();
        TreeNode node = AlgorithmUtils.buildBinTree();
        String tree = sd.Serialize(node);
        System.out.println(tree);
        TreeNode s = sd.Deserialize(tree);
        System.out.println(AlgorithmUtils.isTreeEquels(node,s));
    }
}
