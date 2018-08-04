package per.johnson.dsa.a.advanced;

import java.util.Scanner;

/**
 * Created by Johnson on 2018/8/1.
 */
public class DivideApple {

    private static int divide(int[] array) {
        int n = array.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += array[i];
        }
        if (sum % n != 0) return -1;
        int average = sum / n;
        int cnt = 0;
        int addCount = 0;
        for (int i = 0; i < n; i++) {
            int cur = array[i];
            if((cur- average) % 2 != 0) return -1;
            int time = (cur - average)/2;
            if(cur > average) cnt += time;
            addCount += time;
        }
        return addCount == 0 ? cnt : -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println(divide(array));
    }
}
