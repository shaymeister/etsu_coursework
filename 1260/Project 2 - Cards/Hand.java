/**
 * ---------------------------------------------------------------------------
 * File name: Hands.java
 * Project name: Project 2
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 * Course:  CSCI 1260-288
 * Creation Date: Feb 20, 2020
 * ---------------------------------------------------------------------------
 */

import java.lang.StringBuilder;
import java.util.ArrayList;

/**
 * create a blueprint that represents a hand of Card objects
 *
 * <hr>
 * Date created: Feb 6, 2020
 * <hr>
 * @author Shay Snyder
 */
public class Hand
{
    private int handSize; // the size of a given hand
    private int cardsInHand; // the number of cards in a given hand
    private ArrayList<Card> hand = new ArrayList<Card>(); // ArrayList of all cards in the hand


    /**
	 * no-arg constructor that creates a hand of size 5
	 *
	 * <hr>
	 * Date created: Feb 20, 2020
	 *
	 * <hr>
	 */
    public Hand()
    {
        // set the hand size to 5
        this.handSize = 5;

        // set the number of cards in hand to 0
        this.cardsInHand = 0;
    } // END: no-arg constructor

    /**
	 * parameterized constructor that creates a new hand of
     * the argumented size
	 *
	 * <hr>
	 * Date created: Feb 20, 2020
	 *
	 * <hr>
	 */
    public Hand(int size)
    {
        // set the hand size to the argumented value
        this.handSize = size;

        // set the number of cards in the hand to 0
        this.cardsInHand = 0;
    } // END: parameterized constructor

    /**
	 * parameterized constructor that creates deep copy
     * of an existing hand
	 *
	 * <hr>
	 * Date created: Feb 20, 2020
	 *
	 * <hr>
	 */
    public Hand(Hand hand)
    {
        ArrayList<Card> otherHand = hand.getHand();
        int count = otherHand.size();

        // for every card in the other hand, copy that card to the new hand
        for(int i = 0; i < count - 1; i++)
        {
            // copy the cards from the other hand based on index
            this.hand.add(otherHand.get(i));

            // increment the counter
            this.cardsInHand++;
        } // END: looping through every card in the other hand
    } // END: copy constructor

    /**
	 * getter method that returns the hand's ArrayList of Cards
	 *
	 * <hr>
	 * Date created: Feb 20, 2020
	 *
	 * <hr>
	 */
    public ArrayList<Card> getHand()
    {
        // return the hand ArrayList
        return this.hand;
    } // END: getHand() method

    /**
	 * The addCard method is used to add one card at a time to the hand unless
     * the hand ArrayList is full. The cardsInHand counter is incremented each
     * time a card is added to the hand
	 *
	 * <hr>
	 * Date created: Feb 20, 2020
	 *
	 * <hr>
	 */
    public void addCard(Card card)
    {
        // only add a card to the hand if there is room
        if (this.cardsInHand < this.handSize)
        {
            // add the argumented to card to the hand
            this.hand.add(card);

            // increment the cardsInHand counter
            this.cardsInHand++;
        } // END: if cardsInHand < handSize
    } // END: addCard() method

    /**
	 * toString method that returns a string containing every
     * card within a given hand
	 *
	 * <hr>
	 * Date created: Feb 20, 2020
	 *
	 * <hr>
	 */
    public String toString()
    {
        // instanciate the StringBuilder class
        StringBuilder string = new StringBuilder();

        /*
         * for every card in the hand, append a new line to the string
         * displaying information about that card
         */
        for(int i = 0; i < this.cardsInHand; i++)
        {
            // append the recently card to the StringBuilder object
            string.append("\n\t" + this.hand.get(i));
        }

        // return the newly created String object
        return string.toString();
    } // END: toString() method
} // END: Hand class