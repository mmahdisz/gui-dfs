/**
 * Created by Mehdi on 20/06/2017.
 */
public class Sorted {
    int idx;
    int g;
    int []board;

    Sorted(int i){
        idx = 0;
        g = 0;
        board = new int[i];
    }

    public void add(int i){
        board[idx] = i;
        idx++;
    }

    public int get(){
        return board[g++];
    }

}
