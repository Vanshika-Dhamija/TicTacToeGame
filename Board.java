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
    //clear board
    public void Clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = 0;
            }
        }
    }

    //print board
    public void Print() {
        System.out.println("");
        int x = 1;
        System.out.println(" -----------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(x + " | ");
                x++;
            }
            System.out.println("");
            System.out.println(" -----------");
        }
    }

    //print board
    public void DisplayBoard() {
        System.out.println("");
        System.out.println(" -----------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    System.out.print(" ");
                } else {
                    if (board[i][j] == 1) {
                        System.out.print("X");
                    } else {
                        System.out.print("O");
                    }
                }
                System.out.print(" | ");
            }
            System.out.println("");
            System.out.println(" -----------");
        }
    }

    public void UpdateBoard(int pos, int val) {
        pos = pos- 1;
        int i = pos / 3;
        int j = pos % 3;
        board[i][j] = val;
    }
  //write from here
}
