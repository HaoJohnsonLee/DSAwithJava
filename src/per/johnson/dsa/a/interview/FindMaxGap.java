package per.johnson.dsa.a.interview;

import per.johnson.dsa.a.basic.QuickSort;
import per.johnson.dsa.util.AlgorithmUtils;

/**
 * Created by Johnson on 2018/7/27.
 */
public class FindMaxGap {
    public static int findMaxGap(int [] array){
        if(array == null || array.length <2) return 0;
        int len = array.length;
        Bucket[] buckets = new Bucket[len + 1];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int anArray : array) {
            if (anArray > max) max = anArray;
            if (anArray < min) min = anArray;
        }
        if(min == max) return 0;
        buckets[0] = new Bucket(min,min);
        buckets[buckets.length - 1] = new Bucket(max,max);
        for (int value : array) {
            int index = findBucketIndex(max, min, buckets.length, value);
            Bucket bucket = buckets[index];
            if (bucket == null) {
                buckets[index] = new Bucket(value, value);
            } else {
                if (bucket.max < value) bucket.max = value;
                if (bucket.min > value) bucket.min = value;
            }
        }
        int maxD = Integer.MIN_VALUE;
        int lastMax = buckets[0].max;
        for(int j = 0; j <= len; j++){
            if(buckets[j] != null){
                maxD = Math.max(maxD,buckets[j].min - lastMax);
                lastMax = buckets[j].max;
            }
        }
        return maxD;
    }

    private static int findBucketIndex(double max, double min, double size, double value){
        double s = (max - min) / size;
        return (int)(s * value);
    }

    public static void main(String[] args) {
        int[] a = AlgorithmUtils.randomArray(10,20);
        System.out.println(AlgorithmUtils.array2String(a));
        System.out.println(findMaxGap(a));
        QuickSort.quickSort(a);
        System.out.println(AlgorithmUtils.array2String(a));
    }
}
class Bucket{
    public int min;
    public int max;
    public Bucket(){
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }
    public Bucket(int min,int max){
        this.min = min;
        this.max = max;
    }
}
