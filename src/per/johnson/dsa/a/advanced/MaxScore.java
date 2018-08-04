package per.johnson.dsa.a.huawei;

import java.util.Scanner;

/**
 * Created by Johnson on 2018/7/31.
 */
public class MaxScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()){
            String numsAndQUs = scanner.nextLine();
            String[] s = numsAndQUs.split(" ");
            int stus = Integer.valueOf(s[0]);
            int lines = Integer.valueOf(s[1]);
            String[] scoresStr = scanner.nextLine().split(" ");
            int[] scores = new int[stus];
            for(int i=0; i< stus; i++){
                scores[i] = Integer.valueOf(scoresStr[i]);
            }
            for(int i = 0; i< lines ; i++){
                String[] cmd = scanner.nextLine().split(" ");
                int c1 = Integer.valueOf(cmd[1]);
                int c2 = Integer.valueOf(cmd[2]);
                if(cmd[0].equals("U")){
                    scores[c1 - 1] = c2;
                }else{
                    if(c1 > c2){
                        int tmp = c1;
                        c1 = c2;
                        c2 = tmp;
                    }
                    int max = scores[c1 - 1];
                    for(int j = c1; j<c2; j++){
                        if(scores[j] > max){
                            max = scores[j];
                        }
                    }
                    System.out.println(max);
                }
            }
        }
    }
}
