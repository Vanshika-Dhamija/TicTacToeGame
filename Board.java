import java.util.Random;

public class Board {
    public int[][] board = new int[3][3];
    // 1 means X and -1 means O here and 0 means empty position
    //unoccupied positions
    public int Check(int pos) {
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

    public int Winner() {
        int sum;
        //check rows
        for (int i = 0; i < 3; i++) {
            sum = 0;
            for (int j = 0; j < 3; j++) {
                sum = sum + board[i][j];
            }
            if (sum == 3) {
                return 1;
            } else if (sum == -3) {
                return -1;
            }
        }

        //check the columns
        for (int i = 0; i < 3; i++) {
            sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += board[j][i];
            }
            if (sum == 3) {
                return 1;
            } else if (sum == -3) {
                return -1;
            }
        }

        sum = 0;

        //check diagonals
        for (int i = 0; i < 3; i++) {
            sum += board[i][2-i];
        }
        if (sum == 3) {
            return 1;
        } else if (sum == -3) {
            return -1;
        }

        sum = 0;

        // check for the another diagonal
        for (int i = 0; i < 3; i++) {
            sum += board[i][i];
        }
        if (sum == 3) {
            return 1;
        } else if (sum == -3) {
            return -1;
        }
        return 0;
    }

    public int Computer() {
        int pos;

        // Win of computer
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pos = 3 * i + j + 1;
                if (Check(pos) == 1) {
                    board[i][j] = -1;
                    if (Winner() == -1) {
                        return pos;
                    }
                    board[i][j] = 0;
                }
            }
        }

        // computer will try that the player could not Win
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pos = 3 * i + j + 1;
                if (Check(pos) == 1) {
                    board[i][j] = 1;
                    if (Winner() == 1) {
                        board[i][j] = -1;
                        return pos;
                    }
                    board[i][j] = 0;
                }
            }
        }

        // random allocation of position 
        Random random = new Random();
        pos = random.nextInt(9) + 1;
        while (Check(pos) == 0) {
            pos = random.nextInt(9) + 1;
        }
        UpdateBoard(pos, -1);
        return pos;
    }
}
