package per.johnson.dsa.test;

/**
 * Created by Johnson on 2018/7/4.
 */
public class ValueAndReference {
    public static void main(String[] args) {
        ValueAndReference inc = new ValueAndReference();
        int i = 0;
        inc.fermin(i);
        i= i ++;
        System.out.println(i);

    }
    void fermin(int i){
        i++;
    }
}
