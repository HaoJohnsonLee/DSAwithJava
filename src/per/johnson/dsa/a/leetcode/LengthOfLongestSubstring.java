package per.johnson.dsa.a.leetcode;


import java.util.Arrays;

public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int[] m = new int[256];
        Arrays.fill(m, -1);
        int res = 0, left = -1;
        for (int i = 0; i < s.length(); ++i) {
            left = Math.max(left, m[s.charAt(i)]);
            m[s.charAt(i)] = i;
            res = Math.max(res, i - left);
        }
        return res;
    }

    /**
     * 窗口移动，判断
     * @param s
     * @return
     */
    public static int solu2(String s){
        int[] cs=new int[256];
        Arrays.fill(cs,0);
        int max=0;
        int left=0;
        int right=0;
        while(right<s.length()){
            if(cs[s.charAt(right)]!=0){
                while(s.charAt(left)!=s.charAt(right)){
                    cs[s.charAt(left)]=0;
                    left++;
                }
                left++;
            }else{
                cs[s.charAt(right)]=1;
            }
            max=Math.max(max,right-left+1);
            right++;
        }
        max=Math.max(max,right-left);
        return max;

    }

    public static void main(String[] args) {
        String h="abcabcaa";
        long q1=System.nanoTime();
        for(int i=0;i<10000;i++) {
            lengthOfLongestSubstring(h);
        }
        long q2=System.nanoTime();
        System.out.println((q2-q1)/10000);


        long q3=System.nanoTime();
        for(int i=0;i<10000;i++) {
            solu2(h);
        }
        long q4=System.nanoTime();
        System.out.println((q4-q3)/10000);
    }
}
