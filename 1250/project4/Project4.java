/**
 * -----------------------------------------------------------------------------
 * File name: Project4.java
 * Project name: Project4
 *
 * -----------------------------------------------------------------------------
 * Author’s name and email: Shay Snyder snyderse2@etsu.edu
 * Course-Section: CSCI-1250.088
 *
 * Creation Date: December 7, 2019
 * Last modified: (Shay Snyder, 12/07/19, snyderse2@etsu.edu)
 *
 * -----------------------------------------------------------------------------
 */

// Imports
import java.util.Scanner;
import java.util.Random;

/**
 * Class Name: Project4 <br>
 * Class Purpose: The Project4 class is the driver for project 4. <br>
 *
 * <hr>
 * Date created: December 7, 2019 <br>
 * Last modified: Shay Snyder, snyderse2@etsu.edu, 12/07/19
 * @author Shay Snyder
 */
public class Project4
{
    /**
     * Method Name: main <br>
     * Method Purpose: The main method acts as the spinal cord of Project4 <br>
     *
     * <hr>
     * Date created: December 7, 2019 <br>
     * Last modified: 12/07/2019 <br>
     *
     * <hr>
     * @param args contains command line arguments (not used in this place)
     * @return void
     */
    public static void main(String[] args)
    {
        // Introduce the game to the user by calling the introduction() method
        introduction();

        // Start the game by calling the startGame() method
        startGame();
    } // END: main() method

    /**
     * Method Name: startGame <br>
     * Method Purpose: The startGame method is used to start the game itself <br>
     *
     * <hr>
     * Date created: December 7, 2019 <br>
     * Last modified: 12/07/19 <br>
     *
     * <hr>
     * @return void
     */
    public static void startGame()
    {
        // Create an instance (keyboard) of the scanner class
        Scanner keyboard = new Scanner(System.in);

        // Initialize a char variable that will hold the user's choice
        char userChoice = ' ';

        // Display the options to the user
        System.out.print("\nAs the user, you have three ways to play the game:"
                         + "\na) player vs player"
                         + "\nb) player vs computer"
                         + "\nc) computer vs computer"
                         +"\nEnter a character: ");

        // Prompt the user to enter a choice until a correct value is entered
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
        } while (userChoice != 'a' && userChoice != 'b' && userChoice != 'c' &&
                 userChoice != 'A' && userChoice != 'B' && userChoice != 'C' &&
                 userChoice != '1' && userChoice != '2' && userChoice != '3');

        // print a blank line to the command prompt, used to improve readability
        System.out.println(" ");

        // direct the game based upon the user's choice
        switch(userChoice)
        {
            /* If the user enters a, A, or 1, assume they want to play
             * a human vs human or p.v.p. game
             */
            case 'a':
            case 'A':
            case '1':
                playerVsPlayer();
                break;

            /* If the user enters b, B, or 2, assume they want to play
             * a human vs human or p.v.e. game
             */
            case 'b':
            case 'B':
            case '2':
                playerVsComputer();
                break;

            /* If the user enters c, C, or 3, assume they want to play
             * a computer vs computer or e.v.e. game
             */
            case 'c':
            case 'C':
            case '3':
                computerVsComputer();
                break;
        } // END: (userChoice) switch

        // determine if the user like to play again by calling the playAgain() method
        playAgain();
    } // END: startGame() method

    /**
     * Method Name: playerVsPlayer <br>
     * Method Purpose: start a two player game <br>
     *
     * <hr>
     * Date created: December 7, 2019 <br>
     * Last modified: 12/07/19 <br>
     *
     * <hr>
     * @return void
     */
    public static void playerVsPlayer()
    {
        // Create an instance (random) of the Random class
        Random random = new Random();

        // Create an instance (player1) of the Player class
        Player player1 = new Player('X');

        // Create an instance (player2) of the Player class
        Player player2 = new Player('O');

        // Create an instance (board) of the Board class
        Board board = new Board();

        // Create an instance (keyboard) of the Scanner class
        Scanner keyboard = new Scanner(System.in);

        // create a boolean variable that will be used to toggle between each player
        boolean toggle = random.nextBoolean();

        // loop through the rounds of the tic-tac-toe game
        for(int round = 1; round < 10; round++)
        {
            /* on the first round of the game, prompt the user by telling
             * them which player will go first
             */
            if (round == 1)
            {
                // if (toggle == true && round == 1)
                if(toggle)
                {
                    // Prompt the players that player1 is going first
                    System.out.println("Player 1 gets to start! ( X )");

                    // get move from player1
                    player1.move(board);

                    // set toggle to false, allowing player2 to make the next move
                    toggle = false;
                } // END: if (toggle == true && round == 1)

                // if (toggle == false && round == 1)
                else
                {
                    // Prompt the players that player2 is going first
                    System.out.println("Player 2 gets to start! ( O )");

                    // get move from player2
                    player2.move(board);

                    // set toggle to true, allowing player1 to make the next move
                    toggle = true;
                } // END: if (toggle == false && round == 1)
            } // END: if (round == 1)

            // if (round != 1 && toggle == true)
            else if (toggle)
            {
                // Prompt the players that player1 is going next
                System.out.println("Player 1's Move ( X )");

                // get move from player1
                player1.move(board);

                // determine if a winning move was made
                checkForWinner(board, round, "Player 1");

                // set toggle to false, allowing player2 to make the next move
                toggle = false;
            } // END: if (round != 1 && toggle == true)

            // if (round != 1 && toggle == false)
            else
            {
                // Prompt the players that player2 is going next
                System.out.println("Player 2's Move ( O )");

                // get move from player2
                player2.move(board);

                // determine if a winning move was made
                checkForWinner(board, round, "Player 2");

                // set toggle to true, allowing player1 to make the next move
                toggle = true;
            } // END: if (round != 1 && toggle == false)

            // if (round > 9 && board.isCat())
            if (round >= 9 && board.isCat())
            {
                // Prompt the players that the game has concluded in a draw
                System.out.println("The game has concluded in a draw!");

                // ask if players would like to play again
                playAgain();
            } // END: if (round > 9 && board.isCat())
        } // END: loop

        // Close the keyboard instance of the Scanner class
        keyboard.close();
    } // END: playerVsPlayer() method

    /**
     * Method Name: playerVsComputer <br>
     * Method Purpose: start a player vs computer game <br>
     *
     * <hr>
     * Date created: December 7, 2019<br>
     * Last modified: 12/07/19 <br>
     *
     * <hr>
     * @return void
     */
    public static void playerVsComputer()
    {
        // Create an instance (random) of the Random class
        Random random = new Random();

        // Create an instance (player) of the Player class
        Player player = new Player();

        // Create an instance (computer) of the Computer class
        Computer computer = new Computer();

        // Create an instance (board) of the Board class
        Board board = new Board();

        // Create an instance (keyboard) of the Scanner class
        Scanner keyboard = new Scanner(System.in);

        // create a boolean variable that will be used to toggle between each player
        boolean toggle = random.nextBoolean();

        // loop through the rounds of the tic-tac-toe game
        for(int round = 1; round < 10; round++)
        {
            /* on the first round of the game, prompt the user by telling
             * them which player will go first
             */
            if (round == 1)
            {
                // if (toggle == true && round == 1)
                if(toggle)
                {
                    // Prompt the player that the computer is going first
                    System.out.println("Computer gets to start! ( X )");

                    // get move from the computer
                    computer.move(board, round);

                    // set toggle to false, allowing the user to make the next move
                    toggle = false;
                }  // END: if (toggle == true && round == 1)

                // if (toggle == false && round == 1)
                else
                {
                    // Prompt the player that they are going first
                    System.out.println("You get to start! ( O )");

                    // get move from the user
                    player.move(board);

                    // set toggle to true, allowing the computer to make the next move
                    toggle = true;
                } // END: if (toggle == false && round == 1)
            } // END: if (round == 1)

             // END: if (round == 1)
            else if (toggle)
            {
                // get move from the computer
                computer.move(board, round);

                // determine if a winning move was made
                checkForWinner(board, round, "The computer");

                // set toggle to false, allowing the user to make the next move
                toggle = false;
            }  // END: if (round != 1 && toggle == true)

            // if (round != 1 && toggle == false)
            else
            {
                // get move from the user
                player.move(board);

                // determine if a winning move was made
                checkForWinner(board, round, "You");

                // set toggle to true, allowing the computer to make the next move
                toggle = true;
            }  // END: if (round != 1 && toggle == false)

            // if (round > 9 && board.isCat())
            if (round >= 9 && board.isCat())
            {
                // Prompt the player that the game has concluded in a draw
                System.out.println("The game has concluded in a draw!");

                // ask if players would like to play again
                playAgain();
            }  // END: if (round > 9 && board.isCat())
        } // END: loop
    } // END: playerVsComputer() method

    /**
     * Method Name: computerVsComputer <br>
     * Method Purpose: start a computer vs computer game <br>
     *
     * <hr>
     * Date created: December 7, 2019 <br>
     * Last modified: 12/07/19 <br>
     *
     * <hr>
     * @return void
     */
    public static void computerVsComputer()
    {
        // Create an instance (random) of the Random class
        Random random = new Random();

        // Create an instance (computer1) of the Computer class
        Computer computer1 = new Computer('X');

        // Create an instance (computer2) of the Computer class
        Computer computer2 = new Computer('O');

        // Create an instance (board) of the Board class
        Board board = new Board();

        // create a boolean variable that will be used to toggle between each player
        boolean toggle = random.nextBoolean();

        // loop through the rounds of the tic-tac-toe game
        for(int round = 1; round < 10; round++)
        {
            /* on the first round of the game, prompt the user by telling
             * them which computer will go first
             */
            if (round == 1)
            {
                // if (toggle == true && round == 1)
                if(toggle)
                {
                    // Prompt the player that computer1 is going first
                    System.out.println("Computer 1 gets to start!  ( X )");

                    // get move from computer1
                    computer1.move(board, round);

                    // set toggle to false, allowing computer2 to make the next move
                    toggle = false;
                } // END: if (toggle == true && round == 1)

                // if (toggle == false && round == 1)
                else
                {
                    // Prompt the player that computer2 is going first
                    System.out.println("Computer 2 gets to start! ( O )");

                    // get move from computer2
                    computer2.move(board, round);

                    // set toggle to true, allowing computer1 to make the next move
                    toggle = true;
                } // END: if (toggle == false && round == 1)
            } // END: if (round == 1)

            // if (round != 1 && toggle == true)
            else if (toggle)
            {
                // Prompt the player that computer1 is going next
                System.out.println("Computer 1's Move ( X )");

                // get move from computer1
                computer1.move(board, round);

                // determine if a winning move was made
                checkForWinner(board, round, "Computer1");

                // set toggle to false, allowing computer2 to make the next move
                toggle = false;
            } // END: if (round != 1 && toggle == true)

            // if (round != 1 && toggle == false)
            else
            {
                // Prompt the player that computer2 is going next
                System.out.println("Computer 2's Move ( O )");

                // get move from computer2
                computer2.move(board, round);

                // determine if a winning move was made
                checkForWinner(board, round, "You");

                // set toggle to true, allowing computer1 to make the next move
                toggle = true;
            } // END: if (round != 1 && toggle == true)

            // if (round > 9 && board.isCat())
            if (round >= 9 && board.isCat())
            {
                // Prompt the player that the game has concluded in a draw
                System.out.println("The game has concluded in a draw!");

                // ask if players would like to play again
                playAgain();
            } // END: if (round > 9 && board.isCat())

            // Slow down the speed of the game
            try {
                Thread.sleep(500);
            }
            catch ( InterruptedException ie) { }
        } // END: loop
    } // END: computerVsComputer() method

    /**
     * Method Name: checkForWinner <br>
     * Method Purpose: The purpose of the checkForWinning move method is to
     * determine if a winning move has been made <br>
     *
     * <hr>
     * Date created: December 7, 2019 <br>
     * Last modified: 12/07/19 <br>
     *
     * <hr>
     * @param board an object from the Board class
     * @param round an int variable that represents game progression
     * @param player a String variable that identifies the current player
     * @return void
     */
    public static void checkForWinner(Board board, int round, String player)
    {
        if (round >= 5 && board.isWinner())
        {
            // Prompt the user that ____ player has won the game
            System.out.println(player + " has won the game!");

            // Ask the user if they would like to play again
            playAgain();
        } // END: if (round >= 5 && board.isWinner())
    } // END: checkForWinner() method

    /**
     * Method Name: playAgain <br>
     * Method Purpose: Give the user the option to restart the game <br>
     *
     * <hr>
     * Date created: December 7, 2019 <br>
     * Last modified: 12/07/19 <br>
     *
     * <hr>
     * @return void
     */
    public static void playAgain()
    {
        // Create an instance (keyboard) of the scanner class
        Scanner keyboard = new Scanner(System.in);

        // Initialize a char variable that will hold the user's choice
        char userChoice = ' ';

        // Prompt the user to enter a choice until a correct value is entered
        do
        {
            // Ask the user if they would like to play again
            System.out.print("Would you like to play again? (Y/N) ");

            userChoice = keyboard.nextLine().toUpperCase().charAt(0);
        } while (userChoice != 'Y' && userChoice != 'N');


        if (userChoice == 'Y')
        {
            // if they say yes, restart the game
            startGame();
        }
        else
        {
            /* If they say no, thank them for playing and
             * end the game
             */
            System.out.println("Thank you for playing!");
            System.exit(0);
        } // END: if (userChoice == 'Y')
    } // END: playAgain() method

    /**
     * Method Name: introduction <br>
     * Method Purpose: introduce the game to the user <br>
     *
     * <hr>
     * Date created: December 7, 2019 <br>
     * Last modified: 12/07/19 <br>
     *
     * <hr>
     * @return void
     */
    public static void introduction()
    {
        // Display the prompt to the user
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
    } // END: introduction() method
} // END: Project4 class