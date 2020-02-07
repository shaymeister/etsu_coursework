/**
 * ---------------------------------------------------------------------------
 * File name: CardsDriver.java
 * Project name: Classwork_Cards
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 * Course:  CSCI 1260-288
 * Creation Date: Feb 6, 2020
 * ---------------------------------------------------------------------------
 */

 import java.util.Scanner;

 /**
 * drive the Card class
 *
 * <hr>
 * Date created: Feb 6, 2020
 * <hr>
 * @author Shay Snyder
 */
public class CardsDriver
{
    /**
	 * act as the main method behind the driver class
	 *
	 * <hr>
	 * Date created: Feb 6, 2020
	 *
	 * <hr>
	 */
    public static void main(String[] args)
    {
        // create an instance of the scanner class
        Scanner kb = new Scanner(System.in);

        // create a card using the default constructor
        Card defaultCard = new Card();

        // display the default card to the command line
        System.out.println("The default card is " + defaultCard.toString());

        // create an integer value to represent the user's decisions
        int userChoice;

        while(true)
        {
            // ask the user to enter an integer between 1 and 52.
            System.out.print("\nPlease type an integer between 1 and 52. Type -1 to stop. ");
            userChoice = kb.nextInt();

            /*
             * make sure the user entered a value of -1 or between 1 and 52
             * if they didn't ask them to enter again
             */
            while(userChoice != 1 && (userChoice < -1 || userChoice > 52 || userChoice == 0))
            {
                // ask the user to enter an integer between 1 and 52.
                System.out.print("\nINVALID: Please type an integer between 1 and 52. Type -1 to stop. ");
                userChoice = kb.nextInt();
            }

            // if the user enters -1, show them the deck and exit the program
            if(userChoice == -1)
            {
                // show desk
                showDeck();

                // end program
                System.exit(0);
            }

            // create a Card object using the integer provided by the user
            Card card = new Card(userChoice);

            // display the card information based on the entered value
            System.out.println("\tThe card matching " + userChoice + " is " + card.toString());
        }

    } // END: main method

    /**
	 * display the full deck to the command line
	 *
	 * <hr>
	 * Date created: Feb 6, 2020
	 *
	 * <hr>
	 */
    private static void showDeck()
    {
        System.out.println("All 52 Cards Follow:\n");
        for(int i = 1; i < 53; i++)
        {
            // create a new card object using the iterator
            Card card = new Card(i);

            // display the card's attributes to the command line
            System.out.println(card.toString());
        }
    } // END: showDeck method
} // END: CardsDriver class
