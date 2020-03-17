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

        boolean playAgain = true;

        // Welcome the user
        System.out.println("Welcome to my Project 2!");

        while(playAgain)
        {
            // create a new instance of the Deck class
            Deck deck = new Deck();

            // prompt the user to enter the number of cards per hand
            System.out.print("\nHow many cards in in one hand? ");

            // assign the desired number of cards to numOfCards
            int numOfCards = kb.nextInt();

            // prompt the user to enter the number of players
            System.out.print("How many players of playing? ");

            // assign the desired number of players to numOfPlayers
            int numOfPlayers = kb.nextInt();

            // check if the desire number of cards is too large
            while (numOfCards * numOfPlayers > 52 || numOfCards * numOfPlayers < 1)
            {
                // display an error message telling the user that there aren't
                // enough cards for the desired number of players and hands
                System.out.println("There are not enough cards to deal "
                    + numOfPlayers + " hands of " + numOfCards + " cards."
                    + " Try Again.\n\n");

                // prompt the user to enter the number of cards per hand
                System.out.print("How many cards in in one hand? ");
                numOfCards = kb.nextInt();

                // prompt the user to enter the number of players
                System.out.print("How many players of playing? ");
                numOfPlayers = kb.nextInt();
            } // END: looping until proper num of cards and players

            // shuffle the deck
            deck.shuffle();

            // generate a hand for every player
            for(int i = 1; i <= numOfPlayers; i++)
            {
                // use the deck class to generate a hand
                Hand hand = new Hand(deck.dealAHand(numOfCards));

                // print the hand to the command line
                System.out.println("\nPlayer " + i + ":" + hand.toString());
            } // END: looping through every player

            // clear the keyboard buffer
            kb.nextLine();

            // ask the user if they would like to play again
            System.out.print("\nWould you like to play again? (0 = no / 1 = yes) ");
            // if the user doesn't enter y, yes, Yes, or Y, end the program
            if (kb.nextInt() != 1)
            {
                playAgain = false;
            }

        } // END: while(playAgain)

        // Outro
        System.out.println("\nThank you for playing!");
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
