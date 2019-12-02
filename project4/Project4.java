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
        int userChoice = -1;
        System.out.print("As the user, you have three ways to play the game:"
                         + "\n1) player vs player"
                         + "\n2) player vs computer"
                         + "\n3) computer vs computer"
                         +"\nEnter an integer: ");
        do
        {
            userChoice = keyboard.nextInt();
        } while (userChoice <= 0 || userChoice >= 4);

        switch(userChoice)
        {
            case 1:
                playerVsPlayer();
                break;
            case 2:
                playerVsComputer();
                break;
            case 3:
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

        for(int i = 1; i < 10; i++)
        {
            if (i == 1)
            {
                if(toggle)
                {
                    System.out.println("Player 1 gets to start!");
                    player1.move(board);
                    toggle = false;
                }
                else
                {
                    System.out.println("Player 2 gets to start!");
                    player2.move(board);
                    toggle = true;
                }
            }
            else if (toggle)
            {
                player1.move(board);
                toggle = false;
            }
            else
            {
                player2.move(board);
                toggle = true;
            }

            if (i > 9 && !board.isCat())
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

        if (toggle)
        {

        }
        else
        {

        }
    }

    public static void computerVsComputer()
    {
        Random random = new Random();
        Computer computer1 = new Computer('X');
        Computer computer2 = new Computer('O');
        Board board = new Board();
        boolean toggle = random.nextBoolean();

        if (toggle)
        {

        }
        else
        {

        }
    }

    public static void playAgain()
    {
        Scanner keyboard = new Scanner(System.in);
        char userChoice = ' ';
        System.out.print("Would you like to play again? (Y/N)");
        do
        {
            userChoice = keyboard.nextLine().toUpperCase().charAt(0);
        } while (userChoice != 'Y' || userChoice != 'N');

        if (userChoice == 'Y')
        {
            startGame();
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
