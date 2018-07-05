package per.johnson.dsa.a.bottle;

/**
 * Created by Johnson on 2018/7/3.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static int calculate(int nums){
        int cur = 0;
        int rest = nums;
        while(rest >= 3){
            int i = rest / 3;
            cur += i;
            rest = rest - i*3 + i;
        }
        if(rest == 2) cur++;
        return cur;
    }
    public static void main(String[] args)throws Exception{
        ArrayList<Integer> s = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int a;
        while(sc.hasNextInt()){
            a = sc.nextInt();
            if(a == 0) break;
            s.add(a);
        }
        for(int i=0; i<s.size(); i++){
            System.out.println(calculate(s.get(i)));
        }
    }
}
