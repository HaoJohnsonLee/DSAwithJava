package per.johnson.dsa.ds;


/**
 * Created by Johnson on 2018/6/29.
 */
public class Vector<T extends Comparable<T>> {
    private final int DEFAULT_CAPACITY = 10;
    protected int _size;
    //protected int _capacity;
    Object[] _element;

    public Vector() {
        _element = new Object[DEFAULT_CAPACITY];
        _size = 0;
    }

    public Vector(int capacity) {
        capacity = capacity < DEFAULT_CAPACITY ? DEFAULT_CAPACITY : capacity;
        _element = new Object[capacity];
        _size = 0;
    }

    public Vector(int capacity, T e) {
        capacity = capacity < DEFAULT_CAPACITY ? DEFAULT_CAPACITY : capacity;
        _element = new Object[capacity];
        _size = capacity;
        for (int i = 0; i < _size; i++) {
            _element[i] = e;
        }
    }

    public Vector(T[] A) {
        _size = A.length;
        if (_size < DEFAULT_CAPACITY)
            _element = new Object[DEFAULT_CAPACITY];
        else
            _element = new Object[_size << 1];
        for (int i = 0; i < _size; i++) {
            _element[i] = A[i];
        }
    }

    public int size() {
        return _size;
    }

    public boolean empty() {
        return _size == 0;
    }

    public void add(T element) {
        if (_element.length == _size) { //需要扩容
            grow();
        }
        _element[_size++] = element;
    }

    public T remove(int index) {
        if (index >= _size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        T value = (T) _element[index];
        for (int i = index; i < _size; i++) {
            _element[i] = _element[i + 1];
        }
        _size--;
        shrink();
        return value;
    }

    public int remove(int lo, int hi){ //[lo, hi)
        if(lo < 0 || lo > hi || hi> _size)
            throw new IndexOutOfBoundsException();
        if(hi == lo) return 0;
        while (hi < _size) _element[lo++] = _element[hi++];  //直接将hi之后元素前移，多余元素虽不为空，但无法访问，不影响
        _size = lo;
        shrink();
        return hi - lo ;
    }

    private void shrink() {
        int oldCapacity = _element.length;
        if (oldCapacity > DEFAULT_CAPACITY && _size < oldCapacity >> 1) {  //数组容量大于最低默认容量且小于最大容量的一半
            int half = oldCapacity >> 1;
            int newCapacity = half > DEFAULT_CAPACITY ? half : DEFAULT_CAPACITY;
            Object[] newElement = new Object[newCapacity];
            for (int i = 0; i < _size; i++) {
                newElement[i] = _element[i];
            }
            _element = newElement;
        }
    }


    private void grow() {
        int oldCapacity = _element.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        Object[] newElement = new Object[newCapacity];
        for (int i = 0; i < oldCapacity; i++) {
            newElement[i] = _element[i];
        }
        _element = newElement;
    }

    public static void main(String[] args) {
        Vector<Integer> vs = new Vector<>(20, 25);
        vs.add(5);
        vs.add(6);
        vs.remove(19,22);
    }

}
