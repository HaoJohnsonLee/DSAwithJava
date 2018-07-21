package per.johnson.dsa.a.niuke;

/**
 * Created by Johnson on 2018/7/9.
 */
public class MoreThanHalfNum {
    /**
     *
     * @param array 初始数组
     * @return a if a's show time more than half of the array
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length ==0)
            return 0;
        int cur = array[0];
        int time = 1;
        for(int i =1; i< array.length; i++){
            if(array[i] == cur){
                time++;
            }else{
                if(time == 0){
                    cur = array[i];
                    time = 1;
                }else
                    time --;
            }
        }
        int count = 0;
        cur = time > 0 ? cur : 0;
        if(cur == 0)return 0;
        for(int j = 0 ; j< array.length; j++){
            if(array[j] == cur)
                count++;
        }
        return count > array.length >> 1 ? cur : 0;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,2,4,2,5,2,3};
        System.out.println(new MoreThanHalfNum().MoreThanHalfNum_Solution(a));
    }
}
