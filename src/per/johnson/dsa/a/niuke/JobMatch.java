package per.johnson.dsa.a.niuke;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Johnson on 2018/7/19.
 */
public class JobMatch {
    private static int[] match(int[] ability, HashMap<Integer, Integer> jobs){
        int[] match = new int[ability.length];
        for(int i=0;i< ability.length;i++){
            int highest = 0;
            Set<Integer> ab = jobs.keySet();
            //可先排序
            for(int s : ab){
                if(ability[i] >= s){
                    int pay = jobs.get(s);
                    if(highest < pay)
                        highest = pay;
                }
            }
            match[i] = highest;
        }
        return match;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        String[] firstParams = firstLine.split(" ");
        int jobNum =Integer.valueOf(firstParams[0]);
        int partnerNum =Integer.valueOf(firstParams[1]);
        int[] ability = new int[partnerNum];
        HashMap<Integer, Integer> map = new HashMap<>(jobNum);
        for(int i = 0; i< jobNum ; i++){
            String[] job = scanner.nextLine().split(" ");
            map.put(Integer.valueOf(job[0]), Integer.valueOf(job[1]));
        }
        String[] partner = scanner.nextLine().split(" ");
        for(int i = 0; i< partnerNum; i++){
            ability[i] = Integer.valueOf(partner[i]);
        }
        int [] jobsMatch = match(ability,map);
        for(int i=0 ; i< partnerNum; i++){
            System.out.println(jobsMatch[i]);
        }
    }
}
