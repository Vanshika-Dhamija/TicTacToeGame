import java.util.Scanner;

public class TicTacToe {
    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        System.out.println("\nEnter 1 For MultiPlayer");
        System.out.println("Enter 2 To Play With Computer");
        System.out.println("Enter 0 To Quit\n");
        System.out.print("How Do You Wish To Play : ");
      
        int mode = scan.nextInt();
        Board board = new Board();
        while (mode != 0) {
            if (mode == 1) {
                // PLayer vs Player Mode
                System.out.println("\nPlayer 1 Is X And Player 2 is O");
                board.Print();

                int pos;
                int count = 0;

                while (board.Winner() == 0) {
                    if (count % 2 == 0) {
                        // If even then Player 1 makes a move
                        System.out.print("\nPlayer 1 Choose A Position : ");
                        pos = scan.nextInt();

                        while (pos > 9 || pos < 1) {
                            // Invalid positions error
                            System.out.print("\nChoose A Valid Position : ");
                            pos = scan.nextInt();
                        }

                        while (board.Check(pos) == 0) {
                            // Occupied Postion error
                            System.out.print("\nChoose An Unoccupied Position : ");
                            pos = scan.nextInt();

                            while (pos > 9 || pos < 1) {
                                System.out.print("\nChoose A Valid Position : ");
                                pos = scan.nextInt();
                            }
                        }
                        board.UpdateBoard(pos, 1);
                    } else {
                        // If odd then Player 2 makes a move
                        System.out.print("\nPlayer 2 Choose A Position : ");
                        pos = scan.nextInt();

                        while (pos > 9 || pos < 1) {
                            // Invalid positions error
                            System.out.print("\nChoose A Valid Position : ");
                            pos = scan.nextInt();
                        }

                        while (board.Check(pos) == 0) {
                            // Occupied Postion error
                            System.out.print("\nChoose An Unoccupied Position : ");
                            pos = scan.nextInt();

                            while (pos > 9 || pos < 1) {
                                System.out.print("\nChoose A Valid Position : ");
                                pos = scan.nextInt();
                            }
                        }
                        board.UpdateBoard(pos, -1);
                    }

                    board.DisplayBoard();
                    count++;

                    if (board.Winner() == 1) {
                        System.out.println("\nHurray, Player 1 Won The Game !!");
                        break;
                    } else if (board.Winner() == -1) {
                        System.out.println("\nHurray, Player 2 Won The Game !!");
                        break;
                    }
                    if (count == 9) {
                        // Game Draws when count becomes 9 and no body has won in this turn
                        System.out.println("\nOops, The Game Ends With A Draw !!");
                        break;
                    }
                }
                board.Clear();

                // Asking for another Player vs Player game
                System.out.print("\nWant Another Multiplayer Game Then Press y/Y Else Press Anything : ");
                char another = scan.next().charAt(0);

                if (another == 'Y' || another == 'y') {
                    continue;
                }
            } else if (mode == 2) {
                System.out.println("\nPlayer Is X And Computer is O");
                board.Print();

                int pos;
                int count = 0;

                while (board.Winner() == 0) {
                    if (count % 2 == 0) {
                        // If even then Player makes a move
                        System.out.print("\nChoose A Position : ");
                        pos = scan.nextInt();

                        while (pos > 9 || pos < 1) {
                            // Invalid Position error
                            System.out.print("\nChoose A Valid Position : ");
                            pos = scan.nextInt();
                        }

                        while (board.Check(pos) == 0) {
                            // Occupied position error
                            System.out.print("\nChoose An Unoccupied Position : ");
                            pos = scan.nextInt();

                            while (pos > 9 || pos < 1) {
                                System.out.print("\nChoose A Valid Position : ");
                                pos = scan.nextInt();
                            }
                        }

                        board.UpdateBoard(pos, 1);
                    } else {
                        // Generating a move for Computer by Computer() function
                        pos = board.Computer();
                        System.out.println("\nComputer Chose Position : " + pos);
                    }
                    board.DisplayBoard();

                    count++;

                    if (board.Winner() == 1) {
                        System.out.println("\nHurray, You Defeated The Computer !!");
                        break;
                    } else if (board.Winner() == -1) {
                        System.out.println("\nHell, AI Took Over And Won The Game !!");
                        break;
                    }
                    if (count == 9) {
                        // Game Draws when count becomes 9 and no body has won in this turn
                        System.out.println("\nOops, The Game Ends With A Draw !!");
                        break;
                    }
                }
                board.Clear();

                // Asking for another Player vs Computer game
                System.out.print("\nWant Another Game With Computer Then Press y/Y Else Press Anything : ");
                char another = scan.next().charAt(0);

                if (another == 'Y' || another == 'y') {
                    continue;
                }
            } else {
                // Invalid mode error
                System.out.println("Sorry, Unknown Command !!");
                System.out.print("Please Select The Mode Again : ");
            }

            // Asking the mode again
            System.out.println("\nEnter 1 For MultiPlayer");
            System.out.println("Enter 2 To Play With Computer");
            System.out.println("Enter 0 To Quit\n");
            System.out.print("How Do You Wish To Play : ");
            mode = scan.nextInt();
        }

        System.out.println("");
        scan.close();
    }
}
