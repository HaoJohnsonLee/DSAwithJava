package per.johnson.dsa.a.niuke;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Johnson on 2018/8/3.
 *
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */
public class FirstAppearingOnce {
    Queue<Character> queue = new LinkedList<>();
    int[] chars = new int[256];

    //Insert one char from stringstream
    public void Insert(char ch) {
        chars[ch]++ ;
        queue.add(ch);
        while(!queue.isEmpty()&& chars[queue.peek()] == 2){
            queue.poll();
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        return queue.isEmpty() ? '#' : queue.peek();
    }
}
