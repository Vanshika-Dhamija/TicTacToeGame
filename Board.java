import java.util.Random;

public class Board
{
    public int[][] board = new int[3][3];
    // 1 means X and -1 means O here and 0 means empty position
    //unoccupied positions
    public int Check(int pos)
    {
        pos -= 1;
        int i = pos / 3;
        int j = pos % 3;
        if (board[i][j] == 0) {
            return 1; // If unoccupied return 1
        } else {
            return 0; // If occupied return 0
        }
    } 
  //write from here
}
