package per.johnson.dsa.a.niuke;

import java.util.Stack;

/**
 * Created by Johnson on 2018/7/5.
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数。
 */
public class StackWithMin {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public void push(int node) {
        if(stack.empty()){
            minStack.push(node);
        }else{
            if(node < minStack.peek()){
                minStack.push(node);
            }else{
                minStack.push(minStack.peek());
            }
        }
        stack.push(node);
    }

    public void pop() {
        int s = stack.pop();
        if(s == minStack.peek()) {
            minStack.pop();
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        StackWithMin stack = new StackWithMin();
        stack.push(3);
        System.out.println(stack.min());
        stack.push(4);
        System.out.println(stack.min());
        stack.push(2);
        System.out.println(stack.min());
        stack.push(3);
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.push(0);
        System.out.println(stack.min());
    }
}
