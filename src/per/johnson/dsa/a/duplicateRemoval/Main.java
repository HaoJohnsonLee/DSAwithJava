package per.johnson.dsa.a.duplicateRemoval;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Johnson on 2018/7/3.
 */
public class Main {

    /*public static void dunpliAndSort(ArrayList<Integer> input){
        int[] map = new int[1000];
        for(int i=0; i<1000; i++){
            map[i] = 0;
        }
        for(int i=0 ; i< input.size(); i++){
            int cur = input.get(i);
            if(map[cur] == 0) { //加入排序
                map[cur] = 1;
                int p = i;
                for(int j = i-1; j>=0; j--){
                    if(input.get(j) > input.get(p)){
                        int temp = input.get(j);
                        input.set(j,cur);
                        input.set(p,temp);
                        p--;
                    }
                }
            }
            else{ //去重
                input.remove(i);
                i--;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> s = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i=0;
        while(i<n && sc.hasNext()){
            s.add(sc.nextInt());
            i++;
        }
        dunpliAndSort(s);
        for(int p=0 ; p< s.size(); p++ ){
            System.out.println(s.get(p));
        }
    }*/

    public static void main(String[] args){
        int N,n;
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            N = sc.nextInt();
            n =0;
            int[] result = new int[1000];
            for(int i =0 ;i<1000; i++){
                result[i] = 0;
            }
            while(n < N && sc.hasNextInt()){
                result[sc.nextInt()] = 1;
                n++;
            }
            for(int i =0 ;i<1000; i++){
                if(result[i] == 1)
                    System.out.println(i);
            }
        }
    }
}
