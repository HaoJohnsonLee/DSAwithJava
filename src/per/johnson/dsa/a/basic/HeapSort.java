package per.johnson.dsa.a.basic;

import per.johnson.dsa.util.ArrayUtil;

/**
 * Created by Johnson on 2018/7/27.
 */
public class HeapSort {
    public static void heapSort(int[] array){
        buildHeap(array);
        int heapSize = array.length;
        while(heapSize > 0){
            ArrayUtil.swap(array,0,--heapSize);
            heapify(array,0,heapSize);
        }
    }
    private static void buildHeap(int [] array){
        for(int i = 0; i< array.length; i++){  // O(n)
            heapInsert(array,i);
        }
    }

    private static void heapInsert(int[] array, int index){
        int p;
        while(array[index] > array[p = parent(index)]){
            ArrayUtil.swap(array,index,p);
            index = p;
        }
    }

    private static void heapify(int[] array, int index, int heapSize){
        int left = (index << 1) + 1;
        while(left < heapSize){
            int largest = left + 1 < heapSize && array[left+1] > array[left] ?
                    left + 1: left;
            largest = array[index] > array[largest] ? index : largest;
            if(largest == index) break;
            ArrayUtil.swap(array,index,largest);
            index = largest;
            left = (index << 1) + 1;
        }
    }

    private static int parent(int index){
        if(index <0 )throw new IndexOutOfBoundsException("index : "+ index);
        return (index - 1) / 2;
    }

    public static void main(String[] args) {
        int[] a = {2,1,3,6,0,4};
        heapSort(a);
        System.out.println(ArrayUtil.array2String(a));
    }
}
