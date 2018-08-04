package per.johnson.dsa.a.advanced;

import java.util.*;

/**
 * Created by Johnson on 2018/8/1.
 */
public class SortAscii {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Set<Character> set = new HashSet<>();
        ArrayList<Character> list = new ArrayList<>(line.length());
        for(int i = 0; i< line.length(); i++){
            Character cur = line.charAt(i);
            if(set.contains(cur)){
                list.add(cur);
            }else set.add(cur);
        }
        Arrays.sort(list.toArray());
        StringBuilder sb = new StringBuilder();
        for(char c : list){
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}
