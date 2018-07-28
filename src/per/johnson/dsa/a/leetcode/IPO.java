package per.johnson.dsa.a.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Johnson on 2018/7/28.
 *
 * Input: k=2, W=0, Profits=[1,2,3], Capital=[0,1,1].
 *
 * Output: 4
 *
 * Explanation: Since your initial capital is 0, you can only start the project indexed 0.
 *              After finishing it you will obtain profit 1 and your capital becomes 1.
 *              With capital 1, you can either start the project indexed 1 or the project indexed 2.
 *              Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.
 *              Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.
 */
public class IPO {
    private static class Node{
        Node(int p, int c){
            this.profit = p;
            this.capital = c;
        }
        int profit;
        int capital;
    }

    // 花费小根堆
    private PriorityQueue<Node> minHeap = new PriorityQueue<>((Comparator.comparingInt(o -> o.capital)));
    // 收益大根堆
    private PriorityQueue<Node> maxHeap = new PriorityQueue<>(((o1, o2) -> o2.profit - o1.profit));

    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        if(Profits == null || Profits.length ==0)return 0;
        for(int i = 0; i<Profits.length;i++){
            minHeap.offer(new Node(Profits[i],Capital[i]));
        }
        addWork(W);
        int works = 0;
        while(!maxHeap.isEmpty() && works < k){
            Node cur = maxHeap.poll();
            works++;
            W += cur.profit;
            addWork(W);
        }
        return W;
    }

    private void addWork(int W){
        while (!minHeap.isEmpty()){
            if(minHeap.peek().capital <= W){
                maxHeap.offer(minHeap.poll());
            }else break;
        }
    }

    public static void main(String[] args) {
        int[] p = {1,2,3};
        int[] c = {0,1,1};
        System.out.println(new IPO().findMaximizedCapital(2,0,p,c));
    }
}
