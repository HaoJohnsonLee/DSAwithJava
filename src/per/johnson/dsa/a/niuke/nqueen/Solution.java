package per.johnson.dsa.a.niuke.nqueen;

/**
 * Created by Johnson on 2018/6/30.
 */
public class Solution {
    public static Queen[] placeQueen(int N){
        Queen[] solu = new Queen[N];
        int curRow=0;
        while(true){
            for(int i=0; i<N;i++){ //若循环能找到当前行解决方案
                Queen curQueen = new Queen(curRow, i);
                if(confirm(solu, curRow, curQueen)){
                    solu[i] = curQueen;
                    curRow++;
                    break;
                }
            }//若不能,回溯至找到位置
            Queen queen = solu[curRow];
            for(int i=queen.x+1; i<N; i++){
                queen.x = i;
                if(confirm(solu, curRow, queen)){
                    break;
                }
            }

            break;
        }

        return solu;
    }
    private static boolean confirm(Queen[] solu, int curRow, Queen curQueen){
        for(int i=0; i<curRow;i++){
            if(solu[i].equals(curQueen)) return false;
        }
        return true;
    }
}
