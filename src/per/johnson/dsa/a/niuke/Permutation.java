package per.johnson.dsa.a.niuke;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by Johnson on 2018/7/9.
 */
public class Permutation {
    //TODO more information has to be understood
    /**
     * https://uploadfiles.nowcoder.net/images/20170705/7578108_1499250116235_8F032F665EBB2978C26C4051D5B89E90
     * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
     * 回溯法
     * @param str 输入的字串
     * @return 所有字串的数目
     */
    public ArrayList<String> permutation(String str) {

        ArrayList<String> result = new ArrayList<>();
        if(str == null || str.length() == 0)
            return  result;
        HashSet<String> set = new HashSet<>();
        perKth(set, str.toCharArray(), 0);
        result.addAll(set);
        Collections.sort(result);
        return result;
    }

    private void perKth(HashSet<String> list, char[] a, int k){
        if(k == a.length){
            list.add(String.valueOf(a));
        }
        else {
            for (int i = k; i < a.length; i++) {
                swap(a, i, k);
                perKth(list,a,k+1);
                swap(a, i, k);
            }
        }
    }
    private void swap(char[] a, int i, int j){
        char t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        ArrayList<String> a = new Permutation().permutation("abc");
    }
}
