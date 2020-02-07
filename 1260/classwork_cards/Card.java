/**
 * ---------------------------------------------------------------------------
 * File name: Card.java
 * Project name: Classwork_Cards
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 * Course:  CSCI 1260-288
 * Creation Date: Feb 6, 2020
 * ---------------------------------------------------------------------------
 */

/**
 * create a blueprint that represents a credit card
 *
 * <hr>
 * Date created: Feb 6, 2020
 * <hr>
 * @author Shay Snyder
 */
public class Card
{
    private Suit suit;
    private Face face;

    /**
	 * default constructor for the Card class
	 *
	 * <hr>
	 * Date created: Feb 6, 2020
	 *
	 * <hr>
	 */
    public Card()
    {
        // set the default value to an ace of spades
        this.face = Face.ACE;
        this.suit = Suit.SPADES;
    } // END: default contructor

    /**
	 * parameterized constructor that accepts an integer value
     * that is then converted into the appropriate face and suit
	 *
	 * <hr>
	 * Date created: Feb 6, 2020
	 *
	 * <hr>
	 */
    public Card(int n)
    {
        // Convert n to the proper face
        this.face = Face.values()[n % 13];

        // Convert n to the proper suit
        this.suit = Suit.values()[n % 4];
    } // END: parameterized constructor

    /**
	 * copy constructor that accepts a card input and
     * copies its value to this card
     *
	 *
	 * <hr>
	 * Date created: Feb 6, 2020
	 *
	 * <hr>
	 */
    public Card(Card existingCard)
    {
        // copy the face from the existing card
        this.face = existingCard.getFace();

        // copy the suit from the existing card
        this.suit = existingCard.getSuit();
    } // END: copy constructor

    /**
	 * getter method for the face attribute
     *
	 *
	 * <hr>
	 * Date created: Feb 6, 2020
	 *
	 * <hr>
	 */
    public Face getFace()
    {
        // return the face attribute to the runtime environment
        return this.face;
    } // END: getFace method

    /**
	 * getter method for the suit attribute
     *
	 *
	 * <hr>
	 * Date created: Feb 6, 2020
	 *
	 * <hr>
	 */
    public Suit getSuit()
    {
        // return the suit attribute to the runtime environment
        return this.suit;
    } // END: getSuit method

     /**
	 * return various attributes about this card in
     * the form of a String
     *
	 *
	 * <hr>
	 * Date created: Feb 6, 2020
	 *
	 * <hr>
	 */
    public String toString()
    {
        return "the " + face + " aof " + suit;
    }

} // END: Card class