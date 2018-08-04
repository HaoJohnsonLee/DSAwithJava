package per.johnson.dsa.a.advanced;

import java.util.Stack;

/**
 * Created by Johnson on 2018/8/1.
 */
public class Calculator {
    public static int calculate(String origin){
        char[] chars = origin.toCharArray();
        StringBuilder tmp = new StringBuilder();
        int lo=0,hi;
        boolean enter = false;
        for(int i=0; i< chars.length;i++){
            char cur = chars[i];
            if(cur == '('){
                enter = true;
                lo = i+1;
                continue;
            }
            if(cur == ')'){
                enter = false;
                hi = i-1;
                tmp.append(calculate(chars,lo,hi));
                continue;
            }
            if (enter) continue;
            tmp.append(cur);
        }
        return calculate(tmp.toString().toCharArray(),0,tmp.length()-1);
    }

    public static int calculate(char[] s, int lo, int hi) {
        Stack<String> aim = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean first = false;
        for (int i = lo; i < hi; i++) {
            char cur = s[i];
            if (cur <= '9' && cur >= '0') {
                sb.append(s[i]);
            } else if (cur == '+' || cur == '-') {
                if(cur == '-' && aim.empty()){
                    sb.append(cur);
                    continue;
                }
                aim.push(sb.toString());
                sb.setLength(0);
                if (first) {
                    String num1 = aim.pop();
                    String op = aim.pop();
                    String num2 = aim.pop();
                    if (op.equals("*")) {
                        aim.push(String.valueOf(Integer.valueOf(num2) * Integer.valueOf(num1)));
                    } else {
                        aim.push(String.valueOf(Integer.valueOf(num2) / Integer.valueOf(num1)));
                    }
                    first = false;
                }
                aim.push(String.valueOf(cur));
            } else if (cur == '*' || cur == '/') {
                first = true;
                aim.push(sb.toString());
                sb.setLength(0);
                aim.push(String.valueOf(cur));
            }
        }
        sb.append(s[hi]);
        aim.push(sb.toString());
        if(first){
            String num1 = aim.pop();
            String op = aim.pop();
            String num2 = aim.pop();
            if (op.equals("*")) {
                aim.push(String.valueOf(Integer.valueOf(num2) * Integer.valueOf(num1)));
            } else {
                aim.push(String.valueOf(Integer.valueOf(num2) / Integer.valueOf(num1)));
            }
        }
        while (!aim.empty() && aim.size() != 1) {
            String num1 = aim.pop();
            String op = aim.pop();
            String num2 = aim.pop();
            if (op.equals("+")) {
                aim.push(String.valueOf(Integer.valueOf(num2) + Integer.valueOf(num1)));
            } else {
                aim.push(String.valueOf(Integer.valueOf(num2) - Integer.valueOf(num1)));
            }
        }
        return Integer.valueOf(aim.pop());
    }

    public static void main(String[] args) {
        String c = "3+6*(3+1)";
        System.out.println(calculate(c));
        System.out.println(3 + 6 * (3 + 1));
    }
}
