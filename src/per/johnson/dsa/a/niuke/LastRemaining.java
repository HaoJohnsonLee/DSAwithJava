package per.johnson.dsa.a.niuke;

import per.johnson.dsa.a.basic.PrintMinNumber;

/**
 * Created by Johnson on 2018/7/28.
 * 他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌
 * 然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中
 *从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友
 */
public class LastRemaining {
    public int LastRemaining_Solution(int n, int m) {
        if(n <=0 || m<=0) return -1;
        int[] next = new int[n];
        int[] last = new int[n];
        next[n-1] = 0;
        last[0] = n - 1;
        for(int i=0; i < next.length - 1; i++){
            next[i] = i+1;
        }
        for(int i=1; i < next.length; i++){
            last[i] = i-1;
        }
        int cur = 0;
        while(true){
            if(next[cur] == cur) return cur;
            for(int i=1; i < m;i++){  // 循环一圈
                cur = next[cur];
            }//循环 m 次后
            next[last[cur]] = next[cur];
            last[next[cur]] = last[cur];
            cur = next[cur];
        }
    }

    public int LastRemaining_Solution0(int n, int m){
        if(m <=0 || n<=0) return -1;
        int s = 0;
        for(int i=2; i<= n;i++){
            s = (s + m) % i;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(new LastRemaining().LastRemaining_Solution0(5,4));
    }
}
