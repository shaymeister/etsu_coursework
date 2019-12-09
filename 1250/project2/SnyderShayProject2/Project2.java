/**
 * ---------------------------------------------------------------------------
 * File name: Project2.java
 * Project name: Project2
 * ---------------------------------------------------------------------------
 * Authors's name and email: Shay Snyder snyderse2@etsu.edu
 * Course-Section: CSCI1250-088
 * Creation Date: October 17, 2019
 * Last modified: October 20, 2019 - Shay Snyder snyderse2@etsu.edu
 * ---------------------------------------------------------------------------
 */

import java.util.*;

/**
 * Class Name: Project2<br>
 * Class Purpose: The main class of the program. This purpose of this class is 
 *   to create a game in which the user enters whether or not a number posed to
 *   her is a prime number. The user will be playing against a computer opponent
 *   that will randomly guess yes or no. The program will keep score. <br>
 *
 * <hr>
 * Date created: October 17, 2019 <br>
 * Date last modified: October 17, 2019
 * @author Shay Snyder
 */
public class Project2 
{
    /**
     * Method Name: main <br>
     * Method Purpose: The main method. Initializes the integers userScore &
     *   computerScore, then introduces the impending game to the user.
     *   Following the introduction, the first round of the game will begin when
     *   the game method is called.<br>
     *
     * <hr>
     * Date created: October 17, 2019<br>
     * Date last modified: October 17, 2019<br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions: N/A
     *
     * <hr>
     *   @param  args array of Strings (not used in this program)
     *   @returns void 
     */
    public static void main(String[] args) 
    {
        // create and initialize the varibles to be used throughout each round
        int userScore = 0, computerScore = 0;

        // introduce the game to the user along with the appropriate inputs
        System.out.println("***************************\n"
                         + "Prime Number Guessing Game\n"
                         + "Y = Yes, N = No, Q = Quit\n"
                         + "***************************");

        // start the first round of the game
        game(userScore, computerScore);
    } // END: "main" method

    /**
     * Method Name: game <br>
     * Method Purpose: This method respresents the actions that must take place
     *     during every round of the game. <br>
     *
     * <hr>
     * Date created: October 17, 2019<br>
     * Date last modified: October 17, 2019<br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions: N/A
     *
     * <hr>
     *   @param userScore integer that holds the user's score
     *   @param computerScore integer that holds the user's score
	 *   @returns void 
     */
    public static void game(int userScore, int computerScore)
    {
        // class instances
        Scanner keyboard = new Scanner(System.in);
        Random rnd = new Random();
        
        // variables
        double number;
        boolean prime,
                userCorrect = false,
                userAnswer = false,
                computerCorrect = false,
                computerAnswer = rnd.nextBoolean();
        char answer = ' ';

        // Generate Random Number
        number = (double) rnd.nextInt(1001);

        // determine the random number is prime
        prime = isPrime(number);

        // prompt the user to answer the question
        System.out.print("Is " + (int)number + " prime? ");
        try 
        {
            answer = keyboard.nextLine().charAt(0);
        } 
        catch (Exception e)
        {
            System.out.println("INVALID entry! You did not enter Y, N, or Q!\n"
                             + "Please enter one of Y = Yes, N = No, Q = Quit"
                             + "\n"
                             + "\n"
                             + "\n");
            game(userScore, computerScore);
        }

        // input validation
        if (answer == 'Y' || answer == 'y')
        {
            userAnswer = true;
        }
        else if (answer == 'N' || answer == 'n')
        {
            userAnswer = false;
        }
        else if (answer == 'Q' || answer == 'q')
        {
            System.out.println("You want to quit..\n"
                             + "\n"
                             + "Thank you for playing! Bye!");
            System.exit(0);
        }
        else
        {
            System.out.println("INVALID entry! You did not enter Y, N, or Q!\n"
                             + "Please enter one of Y = Yes, N = No, Q = Quit"
                             + "\n"
                             + "\n"
                             + "\n");
            game(userScore, computerScore);
        }

        // determine if the user and/or computer is correct
        userCorrect = (userAnswer == prime);
        computerCorrect = (prime == computerAnswer);

        // if the user is correct, add one to their score
        if (userCorrect == true)
        {
            userScore += 1;  
        }

        // if the computer is correct, add one to its score
        if (computerCorrect == true)
        {
            computerScore += 1;
        }

        // display computer's answer
        if (computerAnswer == true)
        {
            System.out.println("The computer answers... Y");
        }
        else if (computerAnswer == false)
        {
            System.out.println("The computer answers... N");
        }
        else
        {
            error();
        }

        // display if the user is correct
        if (userCorrect == true)
        {
            System.out.println("You are CORRECT!");
        }
        else if (userCorrect == false)
        {
            System.out.println("You are INCORRECT...");
        }
        else
        {
            error();
        }

        // display if the user is correct
        if (computerCorrect == true)
        {
            System.out.println("The computer is CORRECT...");
        }
        else if (computerCorrect == false)
        {
            System.out.println("The computer is INCORRECT!");
        }
        else
        {
            error();
        }

        // show the players score
        System.out.println("Your Score: " + userScore + "\n"
                         + "The Computer's Score: " + computerScore + "\n"
                         + "\n"
                         + "\n");

        // begin the next round
        game(userScore, computerScore);
    } // END: "game" method

    /**
     * Method Name: isPrime <br>
     * Method Purpose: determine the primality of a number <br>
     *
     * <hr>
     * Date created: October 17, 2019<br>
     * Date last modified: October 17, 2019<br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions: N/A
     *
     * <hr>
     *   @param number the number to take the primality of  
     *   @returns boolean 
     */
    public static boolean isPrime(double number) 
    {
        // if the number is less than 2 
        if (number < 2)
        {
            return false;
        }

        // determine if the number is divisible by anything 
        // other than itself and one
        for (int test = 2; test <= Math.sqrt(number); test++)
        {
            if (number % test == 0) {
                return false;
            }
        }
        
        // if the number has made it this far in the method, we declare the
        // primality of the number to be true
        return true;
    } // END: "isPrime" method

    /**
     * Method Name: error <br>
     * Method Purpose: used to definsively guard against unforseen errors<br>
     *
     * <hr>
     * Date created: October 17, 2019<br>
     * Date last modified: October 17, 2019<br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions: N/A
     *
     * <hr>
     *   @param none (not used in this program)
	 *   @returns void 
     */
    public static void error() 
    {
        // tell the user an unexoected error has occured
        System.out.println("An unexpected error has occured\n" 
                         + "Please try again");

        // exit the program
        System.exit(0);
    } // END: "error" method
} // END: "project2" class