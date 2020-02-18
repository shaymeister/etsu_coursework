/**
 * ---------------------------------------------------------------------------
 * File name: Face.java
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
 * create a blueprint that represents a credit card
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
	 * parameterized constructor that accepts an integer value
     * that is then converted into the appropriate face and suit
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
	 * parameterized constructor that accepts an integer value
     * that is then converted into the appropriate face and suit
	 *
	 * <hr>
	 * Date created: Feb 6, 2020
	 *
	 * <hr>
	 */
    public Deck(ArrayList<Card> existingDeck)
    {
        for(int i = 1; i < 53; i++)
        {
            this.deck.add(existingDeck.get(i));
        }
    }

    /**
	 * parameterized constructor that accepts an integer value
     * that is then converted into the appropriate face and suit
	 *
	 * <hr>
	 * Date created: Feb 6, 2020
	 *
	 * <hr>
	 */
    public void shuffle()
    {
        Collections.shuffle(deck);
    }

    /**
	 * parameterized constructor that accepts an integer value
     * that is then converted into the appropriate face and suit
	 *
	 * <hr>
	 * Date created: Feb 6, 2020
	 *
	 * <hr>
	 */
    public Card dealACard()
    {
        Card cardToReturn = deck.get(nextCard);
        this.nextCard++;
        return cardToReturn;
    }

    /**
	 * parameterized constructor that accepts an integer value
     * that is then converted into the appropriate face and suit
	 *
	 * <hr>
	 * Date created: Feb 6, 2020
	 *
	 * <hr>
	 */
    public String dealAHand(int handSize)
    {
        StringBuilder string = new StringBuilder();
        for(int i = 1; i <= handSize; i++)
        {
            Card someCard = dealACard();
            string.append("\n" + someCard.toString());;
        }
        return string.toString();
    }

    /**
	 * parameterized constructor that accepts an integer value
     * that is then converted into the appropriate face and suit
	 *
	 * <hr>
	 * Date created: Feb 6, 2020
	 *
	 * <hr>
	 */
    public String toString()
    {
        StringBuilder string = new StringBuilder();
        for(int i = 1; i < deck.size(); i++)
        {
            string.append("\n" + deck.get(i).toString());
        }
        return string.toString();
    }

}