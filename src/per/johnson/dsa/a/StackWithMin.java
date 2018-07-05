package per.johnson.dsa.a;

import java.util.Stack;

/**
 * Created by Johnson on 2018/7/5.
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数。
 */
public class StackWithMin {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    int min = Integer.MAX_VALUE;
    public void push(int node) {
        stack.push(node);
        if(node < min){
            min = node;
            minStack.push(node);
        }
    }

    public void pop() {
        int s = stack.pop();
        if(s == minStack.peek()) {
            minStack.pop();
            min = minStack.peek();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min;
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
