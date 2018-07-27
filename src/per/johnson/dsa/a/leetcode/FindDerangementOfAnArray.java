package per.johnson.dsa.a.leetcode;

/**
 * Created by Johnson on 2018/7/24.
 */
public class FindDerangementOfAnArray{
    /**
     * 1 [1]  ->  0
     * 2 [1,2]  -> [2,1]  1
     * 3 [1,2,3] -> [2,3,1]，[3,1,2]  2
     * n [1,2,3,...,n]  -> (n - 1)*[f(n-1) + f(n-2)]
     * @param n array size
     * @return nums of Derangement Of AnArray
     */
    public int find(int n) {
        int m = 0;
        int s = 1;
        if(n == 1) return m;
        if(n == 2) return s;
        int i = 3;
        int temp;
        while(i <= n){
            temp = s;
            s = (i - 1) * (s + m);
            m = temp;
            i++;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(new FindDerangementOfAnArray().find(4));
    }
}
