package per.johnson.dsa.ds;

import java.util.Collections;

/**
 * Created by Johnson on 2018/6/30.
 */
public class LinkedList<T extends Comparable<T>> {
    private int _size;
    private Node<T> _header;
    private Node<T> _trailer;

    public LinkedList() {
        init();
    }

    private void init() {
        _size = 0;
        _header = new Node<>();
        _trailer = new Node<>();
        _header.next = _trailer;
        _trailer.pre = _header;
    }

    public Node<T> first() {
        return _header;
    }

    public Node<T> last() {
        return _trailer;
    }

    public Node<T> get(int index) {
        checkIndex(index);
        Node<T> p = first();
        while (index-- >= 0) p = p.next;
        return p;
    }

    public T getValue(int index){
        return get(index).value;
    }

    public int size(){return _size;}

    public int rank(Node<T> p) {
        int rank = 0;
        Node<T> temp = p;
        while (temp != first()) {
            temp = temp.pre;
            rank++;
        }
        return rank;
    }

    public Node<T> find(T value, int n, Node<T> p) {
        while (p != first() && n-- > 0) {
            p = p.pre;
            if (p.value.equals(value)) return p;
        }
        return null;
    }

    public Node<T> find(T value) {
        return find(value, _size, last());
    }

    public void insert(int index, T value) {
        checkIndex(index);
        Node<T> temp = first();
        while (index-- > 0) temp = temp.next;
        Node<T> newNode = new Node<>(value);
        newNode.next = temp;
        newNode.pre = temp.pre;
        temp.pre.next = newNode;
        temp.pre = newNode;
        _size++;
    }

    public void insert(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = last();
        newNode.pre = last().pre;
        last().pre.next = newNode;
        last().pre = newNode;
        _size++;
    }
    public void insertNext(Node<T> p, T value){
        Node<T> newNode = new Node<>(value);
        p.next.pre = newNode;
        newNode.next = p.next.next;
        newNode.pre = p;
        p.next = newNode;
        _size++;
    }
    public void insertPre(Node<T> p, T value){
        Node<T> newNode = new Node<>(value);
        p.pre.next = newNode;
        newNode.pre = p.pre;
        newNode.next = p;
        p.pre = newNode;
        _size++;
    }

    /**
     * 从lo - hi 有序序列中查找比value小的最大的节点
     * @param lo 起点
     * @param hi 终点
     * @param value 目标值
     * @return 满足条件的节点 可能是 header
     */
    public Node<T> search(int lo,int hi,T value){
        checkIndex(lo);
        checkIndex(hi);
        //if(lo==hi) return get(lo);
        Node<T> hiNode = get(hi).pre;
        while(hi - lo > 0){
            if(hiNode.value.compareTo(value) <= 0) break;
            hi --;
            hiNode = hiNode.pre;
        }
        return hiNode;
    }

    public T remove(Node<T> p) {
        T value = p.value;
        p.pre.next = p.next;
        p.next.pre = p.pre;
        _size--;
        return value;
    }

    public T remove(int index) {
        Node<T> p = get(index);
        return remove(p);
    }

    public void swap(int r1, int r2) {
        checkIndex(r1);
        checkIndex(r2);
        if (r1 == r2) return;
        Node<T> p1 = get(r1);
        Node<T> p2 = get(r2);
        T p1Value = p1.value;
        p1.value = p2.value;
        p2.value = p1Value;
    }

    /**
     * bug stay
     */
    public void insertSort(){
        Node<T> temp = first().next;
        int cur = 0;
        while(temp.value!=null && temp!=last()){
            insertNext(search(0,cur,temp.value),temp.value);
            temp = temp.next;
            remove(temp.pre);
            cur++;
        }
    }
    private void checkIndex(int index) {
        if (index < 0 || index >= _size) throw new IndexOutOfBoundsException();
    }

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.insert(0);ll.insert(7);
        ll.insert(4);
        ll.insert(48);ll.insert(52);

        ll.insertSort();
        Node<Integer> s =ll.search(0,0,0);
    }

}

class Node<T> {
    Node(T value) {
        this.value = value;
        this.pre = null;
        this.next = null;
    }

    Node() {
        this.value = null;
        this.pre = null;
        this.next = null;
    }

    Node(T value, Node<T> next, Node<T> pre) {
        this.value = value;
        this.pre = pre;
        this.next = next;
    }

    T value;
    Node<T> pre;
    Node<T> next;
}
