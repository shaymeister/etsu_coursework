import java.util.Scanner;
import java.util.Random;

public class Project4
{
    public static void main(String[] args)
    {
        introduction();
        startGame();
    }

    public static void startGame()
    {
        Scanner keyboard = new Scanner(System.in);
        char userChoice = ' ';
        System.out.print("\nAs the user, you have three ways to play the game:"
                         + "\na) player vs player"
                         + "\nb) player vs computer"
                         + "\nc) computer vs computer"
                         +"\nEnter a character: ");
        do
        {
            try
            {
                userChoice = keyboard.nextLine().charAt(0);
            }
            catch(Exception e)
            {
                startGame();
            }
        } while (userChoice != 'a' && userChoice != 'b' && userChoice != 'c');

        System.out.println(" ");
        switch(userChoice)
        {
            case 'a':
                playerVsPlayer();
                break;
            case 'b':
                playerVsComputer();
                break;
            case 'c':
                computerVsComputer();
                break;
        }

        playAgain();
    }

    public static void playerVsPlayer()
    {
        Random random = new Random();
        Player player1 = new Player('X');
        Player player2 = new Player('O');
        Board board = new Board();
        Scanner keyboard = new Scanner(System.in);
        boolean toggle = random.nextBoolean();
        String move = "flag";

        for(int round = 1; round < 10; round++)
        {
            if (round == 1)
            {
                if(toggle)
                {
                    System.out.println("Player 1 gets to start! ( X )");
                    player1.move(board);
                    toggle = false;
                }
                else
                {
                    System.out.println("Player 2 gets to start! ( O )");
                    player2.move(board);
                    toggle = true;
                }
            }
            else if (toggle)
            {
                System.out.println("Player 1's Move ( X )");
                player1.move(board);
                checkForWinner(board, round, "Player 1");
                toggle = false;
            }
            else
            {
                System.out.println("Player 2's Move ( O )");
                player2.move(board);
                checkForWinner(board, round, "Player 2");
                toggle = true;
            }

            if (round > 9 && !board.isCat())
            {
                System.out.println("The game has concluded in a draw!");
                playAgain();
            }
        }
    }

    public static void playerVsComputer()
    {
        Random random = new Random();
        Player player = new Player();
        Computer computer = new Computer();
        Board board = new Board();
        Scanner keyboard = new Scanner(System.in);
        boolean toggle = random.nextBoolean();
        for(int round = 1; round < 10; round++)
        {
            if (round == 1)
            {
                if(toggle)
                {
                    System.out.println("Computer gets to start! ( X )");
                    computer.move(board, round);
                    toggle = false;
                }
                else
                {
                    System.out.println("You get to start! ( O )");
                    player.move(board);
                    toggle = true;
                }
            }
            else if (toggle)
            {
                computer.move(board, round);
                checkForWinner(board, round, "The computer");
                toggle = false;
            }
            else
            {
                player.move(board);
                checkForWinner(board, round, "You");
                toggle = true;
            }

            if (round > 9 && !board.isCat())
            {
                System.out.println("The game has concluded in a draw!");
                playAgain();
            }
        }
    }

    public static void computerVsComputer()
    {
        Random random = new Random();
        Computer computer1 = new Computer('X');
        Computer computer2 = new Computer('O');
        Board board = new Board();
        boolean toggle = random.nextBoolean();

        for(int round = 1; round < 10; round++)
        {
            if (round == 1)
            {
                if(toggle)
                {
                    System.out.println("Computer 1 gets to start!  ( X )");
                    computer1.move(board, round);
                    toggle = false;
                }
                else
                {
                    System.out.println("Computer 2 gets to start! ( O )");
                    computer2.move(board, round);
                    toggle = true;
                }
            }
            else if (toggle)
            {
                System.out.println("Computer 1's Move ( X )");
                computer1.move(board, round);
                toggle = false;

                if (round >= 5)
                {
                    checkForWinner(board, round, "Computer1");
                }
            }
            else
            {
                System.out.println("Computer 2's Move ( O )");
                computer2.move(board, round);
                toggle = true;

                if (round >= 5)
                {
                    checkForWinner(board, round, "You");
                }
            }

            if (round > 9 && !board.isCat())
            {
                System.out.println("The game has concluded in a draw!");
                playAgain();
            }

            try {
                Thread.sleep(500);
            }
            catch ( InterruptedException ie) { }

        }
    }

    public static void checkForWinner(Board someBoard, int round, String player)
    {
        if (round >= 5 && someBoard.isWinner())
        {
            System.out.println(player + " has won the game!");
            playAgain();
        }
    }

    public static void playAgain()
    {
        Scanner keyboard = new Scanner(System.in);
        char userChoice = ' ';
        System.out.print("Would you like to play again? (Y/N) ");
        do
        {
            userChoice = keyboard.nextLine().toUpperCase().charAt(0);
        } while (userChoice != 'Y' && userChoice != 'N');

        if (userChoice == 'Y')
        {
            startGame();
            System.out.println("Shouldn't be here");
        }
        else
        {
            System.out.println("Thank you for playing!");
            System.exit(0);
        }
    }

    public static void introduction()
    {
        System.out.println(
              "Welcome to my tic tac toe game!\n"
            + "The board is layed out in a 3x3 grid as such:\n"
            + "\n"
            + "\t(A1)|(B1)|(C1)\n"
            + "\t----|----|----\n"
            + "\t(A2)|(B2)|(C2)\n"
            + "\t----|----|----\n"
            + "\t(A3)|(B2)|(C3)\n"
            + "\n"
            + "Rules:\n"
            + "2) To win, there must be 3 of a kind in a straight line in any direction\n"
            + "3) To place your chracter, you will be asked to enter a String (A-C,1-3)\n"
            + "4) Have fun!");
    }
}
