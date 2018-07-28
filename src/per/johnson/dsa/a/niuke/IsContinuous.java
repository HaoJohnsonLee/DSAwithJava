package per.johnson.dsa.a.niuke;

/**
 * Created by Johnson on 2018/7/28.
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票
 * 嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....
 * LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何
 * 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 */
public class IsContinuous {
    /**
     * 要求
     *     1. 除去 0 外不能有重复的数
     *     2. 0 不能出现5次
     *     3. max - min <= 5 - (0的个数)
     *
     * @param numbers 输入的五个数
     * @return 是否能组成顺子
     */
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length != 5) return false;
        int max = 1;
        int min = 14;
        int s = 0;
        int zeroNum = 0;
        for (int number : numbers) {
            if (number == 0) {
                zeroNum++;
                if (zeroNum > 4) return false;
                continue;
            }
            if (((s >> number) & 1) == 1) return false;
            s = s | (1 << number);
            if (number > max) max = number;
            if (number < min) min = number;
        }
        return max - min < 5;
    }

    public static void main(String[] args) {
        int[] nums = {0, 3, 3, 6, 4};
        System.out.println(new IsContinuous().isContinuous(nums));
    }
}
