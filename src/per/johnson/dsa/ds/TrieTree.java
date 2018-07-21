package per.johnson.dsa.ds;

/**
 * Created by Johnson on 2018/7/11.
 */
public class TrieTree {
    TrieTreeNode root;
    public TrieTree(){
        root = new TrieTreeNode();
    }

    public void insert(String src){
        char[] array = src.toCharArray();
        TrieTreeNode cur;
        TrieTreeNode temp = root;
        for(int i = 0; i<array.length; i++){
            int index = array[i] - 'a';
            cur = temp.next[index];
            if(cur == null){
                temp.next[index] = new TrieTreeNode();
                cur = temp.next[index];
                cur.isWord = (i == array.length - 1);
            }else{
                cur.count++;
            }
            temp = cur;
        }
    }
    public int trieNum(String sample){
        char[] chars = sample.toCharArray();
        TrieTreeNode end = null ;
        TrieTreeNode temp =root;
        for(int i = 0; i < chars.length; i++){
            int index = chars[i] - 'a';
            temp = temp.next[index];
            end = temp;
            if(temp == null) break;
        }
        return end == null ? 0 : end.count;
    }

    public static void main(String[] args) {
        TrieTree tree = new TrieTree();
        tree.insert("banana");
        tree.insert("band");
        tree.insert("bee");
        tree.insert("absolute");
        tree.insert("acm");

        System.out.println(tree.trieNum("ba"));
        System.out.println(tree.trieNum("b"));
        System.out.println(tree.trieNum("band"));
        System.out.println(tree.trieNum("abc"));
    }

}
class TrieTreeNode{
    int count; //以该单词为前缀的单词数目，自己为自己前缀
    TrieTreeNode[] next;  // 子节点
    boolean isWord; //是否以此为结束的一个单词
    public TrieTreeNode(){
        count = 1;
        isWord = false;
        next = new TrieTreeNode[26];
    }
}
