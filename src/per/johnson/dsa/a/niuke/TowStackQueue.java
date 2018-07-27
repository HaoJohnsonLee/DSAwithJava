package per.johnson.dsa.a.niuke;

import java.util.Stack;

/**
 * Created by Johnson on 2018/7/5.
 */
public class Stack2Queue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
