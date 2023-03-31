import java.util.Scanner;

public class TicTacToe {
    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);

        System.out.println("\n***** TIC TAC TOE *****");

        System.out.println("\nEnter 1 For MultiPlayer");
        System.out.println("Enter 2 To Play With Computer");
        System.out.println("Enter 0 To Quit\n");
        System.out.print("How Do You Wish To Play : ");
      
        int mode = scan.nextInt();
        Board board = new Board();
    }
}
