package per.johnson.dsa;

import java.util.Scanner;

class Point{
    int x;
    int y;
    boolean visited;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        this.visited = false;
    }

    public int getLength(Point p){
        return Math.abs(x - p.x) + Math.abs(y - p.y);
    }
}

/**
 * 4
 * 2 2
 * 2 8
 * 4 4
 * 7 2
 */
public class Main {
    static final Point START = new Point(0,0);
    static int minpath = Integer.MAX_VALUE;

    public static int calculate(Point start, Point[] points, int sum, int count){
        if(count == points.length){
            minpath = Math.min(minpath, sum +start.getLength(START));
            return minpath;
        }
        for(int i = 0; i<points.length; i++){
            if(!points[i].visited){
                sum += points[i].getLength(start);
                if(sum < minpath){
                    points[i].visited = true;
                    calculate(points[i], points, sum, count+1);
                }
                sum -= points[i].getLength(start);
                points[i].visited = false;
            }
        }
        return minpath;
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int pnum = Integer.parseInt(input.nextLine().trim());
        /**构建点集*/
        Point[] points = new Point[pnum];
        for(int i = 0; i<pnum; i++){
            String[] locations = input.nextLine().trim().split(" ");
            points[i] = new Point(Integer.parseInt(locations[0]), Integer.parseInt(locations[1]));
        }
        int min = calculate(START, points, 0, 0);
        System.out.println(min);
    }
}
