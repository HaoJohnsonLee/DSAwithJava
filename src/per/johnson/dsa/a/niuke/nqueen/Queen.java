package per.johnson.dsa.a.niuke.nqueen;

/**
 * Created by Johnson on 2018/6/30.
 */
public class Queen {
    public int x;
    public int y;
    public Queen(int x,int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj instanceof Queen){
            Queen queen = (Queen) obj;
            return queen.x==x||queen.y == y || (x+y ==queen.x+queen.y)||(x-y==queen.x-queen.y);
        }
        return false;
    }

    @Override
    public String toString() {
        return "x="+x + " y="+y;
    }
}
