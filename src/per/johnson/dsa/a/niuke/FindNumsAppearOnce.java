package per.johnson.dsa.a.niuke;

/**
 * Created by Johnson on 2018/7/27.
 */
public class FindNumsAppearOnce {
    public static void findNumsAppearOnce(int [] array,int num1[] , int num2[]){
        if(array == null || array.length < 2)return;
        int orSum = 0;
        for(int i=0;i<array.length;i++){
            orSum ^= array[i];
        }
        if(orSum == 0)return;
        int index = 0;
        while((orSum & 1) == 0){
            orSum = orSum >> 1;
            index++;
        }
        for(int i = 0; i< array.length; i++){
            if(isOne(array[i],index)){
                num1[0] ^=array[i];
            }else{
                num2[0] ^= array[i];
            }
        }
    }
    private static boolean isOne(int value, int index){
        value = value >> index;
        return (value & 1) == 1;
    }

    public static void main(String[] args) {
        int[] s = {1,5,3,9,5,3,9,1,8,15};
        int[] a = new int[1];
        int[] b = new int[1];
        findNumsAppearOnce(s,a,b);
        System.out.println(a[0]);
        System.out.println(b[0]);
    }
}
