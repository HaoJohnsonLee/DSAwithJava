package per.johnson.dsa.a.leetcode;

/**
 * Created by Johnson on 2018/7/22.
 */
public class EditDistance {
    private int[][] d_;
    public int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        d_ = new int[w1.length + 1][w2.length + 1];
        for (int i = 0; i < d_.length; i++)
            for (int j = 0; j < d_[i].length; j++)
                d_[i][j] = -1;
        return minDistance(w1,w2,w1.length,w2.length);
    }
    private int minDistance(char[] w1, char[] w2, int l1, int l2){
        if(l1 == 0) return l2;
        if (l2 == 0) return l1;
        if(d_[l1][l2] >= 0) return d_[l1][l2];
        int ans;
        if(w1[l1-1] == w2[l2 -1]) ans = minDistance(w1,w2,l1 -1,l2 - 1);
        else ans = Math.min(Math.min(minDistance(w1,w2,l1 - 1,l2 - 1),minDistance(w1,w2,l1 - 1,l2)),(minDistance(w1,w2,l1,l2-1))) + 1;
        return d_[l1][l2] = ans;
    }

    public static void main(String[] args) {
        System.out.println(new EditDistance().minDistance("horse","ros"));
    }
}
