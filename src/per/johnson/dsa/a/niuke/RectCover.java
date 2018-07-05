package per.johnson.dsa.a.niuke;

/**
 * Created by Johnson on 2018/7/5.
 */
public class RectCover {
    /**
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
     *
     * 考虑 f(n)是再f(n-1)下扩展的
     * 而2*1的方块 f(n)也可以在f(n-2)下扩展
     * 而f(1)=1 f(2) = 2;
     * 有f(n) = f(n - 1) +  f(n - 2)
     * @param target 2 * target 大小
     * @return 方法数目
     */
    public int RectCover(int target) {
        if(target <= 2) return target;
        int f1 = 1;
        int f2 = 2;
        while(target -- > 2){
            f1 = f2 - f1;
            f2 = f1 + f2;
        }
        return f2;
    }
}
