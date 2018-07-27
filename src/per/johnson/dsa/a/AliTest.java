package per.johnson.dsa.a;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class Point{
    private int x;
    private int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getDistance(Point anotherP){
        return Math.abs(this.x-anotherP.x)+Math.abs(anotherP.y-this.y);
    }
    public int getDistance(int x, int y){
        return Math.abs(this.x-x)+Math.abs(y-this.y);
    }
}

/**
 * 4
 * 2 2
 * 2 8
 * 4 4
 * 7 2
 */
public class AliTest {
    private static int calculate(ArrayList<Point> points){
        int count = 0;
        int curMin = Integer.MAX_VALUE;
        int minIndex = -1;
        Point curPoint = new Point(0,0);
        while(!points.isEmpty()) {
            for (int i = 0; i < points.size(); i++) {
                int dis = curPoint.getDistance(points.get(i));
                if (dis < curMin) {
                    curMin = dis;
                    minIndex = i;
                }
            }
            curPoint = points.get(minIndex);
            count += curMin;
            points.remove(minIndex);
            curMin = Integer.MAX_VALUE;
        }
        count += curPoint.getDistance(0,0);
        return count;
    }

   static int calculate(String[] locations) {
        ArrayList<Point> points = new ArrayList<>(locations.length);
        for(String pStr : locations){
            String[] xy = pStr.split(" ");
            points.add(new Point(Integer.valueOf(xy[0]), Integer.valueOf(xy[1])));
        }
        return calculate(points);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine().trim());
        int index = 0;
        String[] locations = new String[num];
        while(num-- > 0){
            locations[index++] = scanner.nextLine();
        }
        System.out.println(calculate(locations));
    }
}