/**
 * ---------------------------------------------------------------------------
 * File name: DeckDriver.java
 * Project name: Classwork_Cards
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 * Course:  CSCI 1260-288
 * Creation Date: Feb 13, 2020
 * ---------------------------------------------------------------------------
 */

/**
 * run and manage the Deck class
 *
 * <hr>
 * Date created: Feb 13, 2020
 * <hr>
 * @author Shay Snyder
 */
public class DeckDriver
{
    /**
	 * main method for the DeckDriver class that was built to manage and run
     * our custom class, Deck.
	 *
	 * <hr>
	 * Date created: Feb 13, 2020
	 *
	 * <hr>
	 */
    public static void main(String[] args)
    {
        /*
         * create a new instance of the Deck class
         * using the default constructor
         */
        Deck deck = new Deck();

        // show the originial deck to the user
        System.out.println(deck.toString());

        // shuffle the deck
        deck.shuffle();

        // show the shuffled deck to the user
        System.out.println(deck.toString());
    } // END: main() method
} // END: DeckDriver class