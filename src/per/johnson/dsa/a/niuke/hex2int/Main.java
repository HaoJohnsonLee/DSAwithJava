package per.johnson.dsa.a.niuke.hex2int;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Johnson on 2018/7/3.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> input = new ArrayList<>();
        while(sc.hasNext()){
            input.add(sc.next());
        }
        for(int i=0 ; i< input.size(); i++){
            System.out.println(Integer.parseInt(input.get(i).substring(2),16));
        }
    }
}
