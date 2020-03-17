/**
 * ---------------------------------------------------------------------------
 * File name: Deck.java
 * Project name: Classwork_Cards
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 * Course:  CSCI 1260-288
 * Creation Date: Feb 6, 2020
 * ---------------------------------------------------------------------------
 */
import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.Collections;

/**
 * create a blueprint that represents a deck of Card objects
 *
 * <hr>
 * Date created: Feb 6, 2020
 * <hr>
 * @author Shay Snyder
 */
public class Deck
{
    /*
     * this ArrayList will be used to hold all
     * cards within a deck of cards
     */
    private ArrayList<Card> deck = new ArrayList<Card>();

    // create an integer variable that keeps track of the card creation process
    private int nextCard;

    /**
	 * no-arg constructor
	 *
	 * <hr>
	 * Date created: Feb 6, 2020
	 *
	 * <hr>
	 */
    public Deck()
    {
        // loop through all cards within a standard 52 card deck
        for(int i = 1; i <= 52; i++)
        {
            // use the iterator to create a unique card at during each repition
            Card card = new Card(i);

            // add the newly created card to the ArrayList
            this.deck.add(card);
        } // END: looping through possible cards
    } // END: Deck() default constructor

    /**
	 * parameterized constructor that creates a new Deck object that
     * is based on a deep copy an an argumented Deck
	 *
	 * <hr>
	 * Date created: Feb 6, 2020
	 *
	 * <hr>
	 */
    public Deck(ArrayList<Card> existingDeck)
    {
        // Loop through every card in a deck of cards
        for(int i = 1; i < 53; i++)
        {
            /*
             * copy the card object at i and place into the
             * new Deck's ArrayList at i
             */
            this.deck.add(existingDeck.get(i));
        } // END: looping through all items
    } // END: Deck() copy constructor

    /**
	 * this method uses the Collections class to
     * shuffle the deck of cards
	 *
	 * <hr>
	 * Date created: Feb 6, 2020
	 *
	 * <hr>
	 */
    public void shuffle()
    {
        // shuffle the deck
        Collections.shuffle(deck);
    } // END: shuffle() method

    /**
	 * return a card to the user
	 *
	 * <hr>
	 * Date created: Feb 6, 2020
	 *
	 * <hr>
	 */
    public Card dealACard()
    {
        /*
         * extract a card from the deck using the global int variable
         */
        Card cardToReturn = deck.get(nextCard);

        // add one to the global int variable
        this.nextCard++;

        // return the extracted card
        return cardToReturn;
    } // END: dealACard() method

    /**
	 * accept an integer variable form the user; return a hand of cards
     * that reflects the users desired amount of cards
	 *
	 * <hr>
	 * Date created: Feb 6, 2020
	 *
	 * <hr>
	 */
    public Hand dealAHand(int handSize)
    {
        Hand hand = new Hand(handSize);

        // use a loop to add the desire number of card to the hand
        for (int i = 0; i <= handSize; i++)
        {
            // deal a card and add the card to the hand
            hand.addCard(dealACard());
        } // END: looping through desired hand size

        // return the newly created hand
        return hand;
    } // END: dealAHand() method

    /**
	 * return a String of 52 lines in length that contains
     * every card within the deck
	 *
	 * <hr>
	 * Date created: Feb 6, 2020
	 *
	 * <hr>
	 */
    public String toString()
    {
        // initialize the StringBuilder class
        StringBuilder string = new StringBuilder();

        // loop through every card in the deck
        for(int i = 1; i < deck.size(); i++)
        {
            // add the card to the String
            string.append("\n" + deck.get(i).toString());
        }

        // return the StringBuilder objects
        return string.toString();
    } // END: toString() method
} // END: Deck class