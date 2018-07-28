package per.johnson.dsa.a.interview;

/**
 * Created by Johnson on 2018/7/28.
 */
public class RecursionProblems {
    /**
     * 打印字符串所有的子序列
     * @param str 输入的字符串序列
     * @param i 当前指针位置
     * @param res 上层传递的串
     */
    public static void printAllSubString(char[] str, int i, String res){
        if(i == str.length){
            System.out.println(res);
        }else {
            printAllSubString(str, i + 1, res);
            printAllSubString(str, i + 1, res + str[i]);
        }
    }

    public static void main(String[] args) {
        String test = "test";
        printAllSubString(test.toCharArray(),0,"");
    }
}
