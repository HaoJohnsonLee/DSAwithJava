package per.johnson.dsa.ds;

/**
 * Created by Johnson on 2018/6/30.
 */
public class Stack<T> {
    private int _size;
    private StackNode<T> _top;

    public boolean empty() {
        return _size == 0;
    }

    public int size() {
        return _size;
    }

    public T top() {
        if (!empty()) return _top.value;
        return null;
    }

    public T pop() {
        if (!empty()) {
            T value = _top.value;
            _top = _top.next;
            _size--;
            return value;
        }
        return null;
    }

    public void push(T value) {
        StackNode<T> node = new StackNode<>(value);
        if (empty()) _top = node;
        else {
            node.next = _top;
            _top = node;
        }
        _size++;
    }
    public static boolean paren(String exp){
        Stack<Character> stack = new Stack<>();
        char[] ca = exp.toCharArray();
        for(int i=0; i< ca.length; i++){
            switch (ca[i]){
                case '(': case '[': case '{':stack.push(ca[i]); break;
                case ')': if(stack.empty() || stack.pop() != '(') return false; break;
                case ']': if(stack.empty() || stack.pop() != '[') return false; break;
                case '}': if(stack.empty() || stack.pop() != '{') return false; break;
                default: break;
            }
        }
        return stack.empty();
    }
}

class StackNode<T> {
    StackNode(T value) {
        this.value = value;
        this.next = null;
    }

    StackNode() {
        this.value = null;
        this.next = null;
    }

    StackNode(T value, StackNode<T> next) {
        this.value = value;
        this.next = next;
    }

    T value;
    StackNode<T> next;
}