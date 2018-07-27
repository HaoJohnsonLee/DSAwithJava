package per.johnson.dsa.a.niuke;

import java.util.Stack;

/**
 * Created by Johnson on 2018/7/5.
 */
public class TowStackQueue {
    Stack<Integer> push = new Stack<>();
    Stack<Integer> pop = new Stack<>();

    public void push(int node) {
        push.push(node);
    }

    public int pop() {
        if(pop.empty()){
            while(!push.empty()){
                pop.push(push.pop());
            }
        }
        return pop.pop();
    }
    public int peek(){
        if(pop.empty()){
            while(!push.empty()){
                pop.push(push.pop());
            }
        }
        return pop.peek();
    }
}
