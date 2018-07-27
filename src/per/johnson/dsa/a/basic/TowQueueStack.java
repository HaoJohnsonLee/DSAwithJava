package per.johnson.dsa.a.basic;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Johnson on 2018/7/27.
 */
public class TowQueueStack {
    private Queue<Integer> data;
    private Queue<Integer> help;
    public TowQueueStack(){
        data = new LinkedList<>();
        help = new LinkedList<>();
    }

    public void push(int value){
        data.offer(value);
    }
    public int peek(){
        while(data.size() > 1){
            help.add(data.poll());
        }
        int c =data.poll();
        help.add(c);
        swap();
        return c;
    }
    public int pop(){
        while(data.size() > 1){
            help.add(data.poll());
        }
        int c = data.poll();
        swap();
        return c;
    }
    private void swap(){
        Queue<Integer> tmp = data;
        data = help;
        help = tmp;
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }
    public static void main(String[] args) {
        TowQueueStack stack = new TowQueueStack();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
