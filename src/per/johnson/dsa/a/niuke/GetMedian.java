package per.johnson.dsa.a.niuke;

import java.util.PriorityQueue;

/**
 * Created by Johnson on 2018/7/28.
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值
 * 那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class GetMedian {

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> o2 - o1));
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public void Insert(Integer num) {
        if(minHeap.isEmpty() || num > minHeap.peek()){
            minHeap.offer(num);
        }else{
            maxHeap.offer(num);
        }
        if(minHeap.size() - maxHeap.size() > 1){
                maxHeap.offer(minHeap.poll());
        }
        if(maxHeap.size() - minHeap.size() > 1){
                minHeap.offer(maxHeap.poll());
        }
    }

    public Double GetMedian() {
        if(minHeap.isEmpty())return 0.0;
        if((minHeap.size() == maxHeap.size())){
            return ((double)minHeap.peek() + (double)maxHeap.peek()) / 2;
        }else if(minHeap.size() > maxHeap.size()){
            return (double)minHeap.peek();
        }else{
            return (double)maxHeap.peek();
        }
    }
}
