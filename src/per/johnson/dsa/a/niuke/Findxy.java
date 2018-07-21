package per.johnson.dsa.a.niuke;

import per.johnson.dsa.ds.Vector;

/**
 * Created by Johnson on 2018/7/19.
 */
public class Findxy {
    private static int calculate(int n, int k){
        int count = 0;
        for(int i = 1; i <= n; i++){
            if(i == k){
                count += (n - k -1);
            }
            if(i > k){
                count += (k - 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(calculate(5,2));
    }
}
