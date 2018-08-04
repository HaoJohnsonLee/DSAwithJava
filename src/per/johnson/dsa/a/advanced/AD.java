package per.johnson.dsa.a.advanced;

import java.util.Scanner;

/**
 * Created by Johnson on 2018/8/1.
 */
public class AD {

    /**
     * using namespace std;
     * int n,m,a[301];
     * int f[301][31];
     * <p>
     * int Abs(int x) {return x<0?-x:x;}//原来是abs函数写错了！
     * <p>
     * int data(int x,int y)
     * {
     * if (x==y) return 0;
     * int mid=(x+y)>>1; int sum=0;
     * for (int i=x; i<=y; i++)
     * sum+=Abs(a[i]-a[mid]);
     * return sum;
     * }
     * <p>
     * int main()
     * {
     * scanf("%d%d",&n,&m);
     * for (int i=1; i<=n; i++)
     * scanf("%d",&a[i]);
     * memset(f,0x3f,sizeof(f));
     * for (int i=1; i<=n; i++)
     * f[i][1]=data(1,i);
     * for (int i=2; i<=n; i++)
     * for (int j=1; j<=m; j++)
     * {
     * for (int k=j; k<=i-1; k++)//枚举断点
     * f[i][j]=min(f[i][j],f[k][j-1]+data(k+1,i));//这类方程就是看把最后一个分给谁的问题
     * }
     * /*  for (int i=1; i<=n; i++)
     * {
     * for (int j=1; j<=m; j++) printf("%d ",f[i][j]);
     * printf("\n");
     * }
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] s = line.split(" ");
        int ads = Integer.valueOf(s[s.length - 1]);  //广告牌数量
        int n = s.length - 1;
        int[] points = new int[s.length];
        for (int i = 1; i < points.length; i++) {  // 坐标点
            points[i] = Integer.valueOf(s[i]);
        }
        if (ads >= points.length) {
            System.out.println(0);
            return;
        }
        int[][] w = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            w[i][1] = process(points, 1, i);
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= ads; j++) {
                for (int k = j; k <= i - 1; k++)//枚举断点
                    w[i][j] = Math.min(w[i][j], w[k][j - 1] + process(points, k + 1, i));//这类方程就是看把最后一个分给谁的问题
            }
        }


        System.out.println(w[points.length - 1][ads]);
    }

    private static int process(int[] a, int x, int y) {
        if (x == y) return 0;
        int mid = (x + y) >> 1;
        int sum = 0;
        for (int i = x; i <= y; i++)
            sum += Math.abs(a[i] - a[mid]);
        return sum;
    }
}
