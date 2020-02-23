/**
 * ---------------------------------------------------------------------------
 * File name: CreditCardList.java
 * Project name: Credit_Card_List
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 * Course:  CSCI 1260-288
 * Creation Date: Feb 13, 2020
 * ---------------------------------------------------------------------------
 */
import java.lang.StringBuilder;
import java.util.ArrayList;

/**
 * create an ArrayList of CreditCard objects and
 * provide the necessary methodology
 *
 * <hr>
 * Date created: Feb 23, 2020
 * <hr>
 * @author Shay Snyder
 */
 public class CreditCardList
 {
    // create a private ArrayList of CreditCard objects
    private ArrayList<CreditCard> wallet;

    /**
	 * default, no-arg constructor for the CreditCardList class
	 *
	 * <hr>
	 * Date created: Feb 23, 2020
	 *
	 * <hr>
	 */
    public CreditCardList()
    {
        // Initialize the ArrayList of CreditCard objects
        wallet = new ArrayList<CreditCard>();
    } // END: no-arg constructor

    /**
	 * Add a new CreditCard object to the ArrayList<CreditCard>
     * This method accepts three String parameters: name, number, and date.
     * String name = the name of the card holder
     * String number = the credit card number
     * String date = the expiration date of the card (MM/YYY)
	 *
	 * <hr>
	 * Date created: Feb 23, 2020
	 *
	 * <hr>
	 */
    public void addCard(String name, String number, String date)
    {
        // Create a new credit card object
        CreditCard card = new CreditCard();

        // set the card holder's name
        card.setCardHolderName(name);

        // set the card's number
        card.setCardNumber(number);

        // set the card's expiration date
        card.setExpirationDate(date);

        // process the card's information
        card.processCardInformation();

        // add the card to the ArrayList
        this.wallet.add(card);
    } // END: addCard() method

    /**
	 * attempt to remove the CreditCard object at the argumented index.
     * return true if success
     * return false if fail
	 *
	 * <hr>
	 * Date created: Feb 23, 2020
	 *
	 * <hr>
	 */
    public boolean removeCard(int n)
    {
        // attempt to remove the CreditCard at index n
        try
        {
            // remove the CreditCard object at index n
            wallet.remove(n);

            // assuming the removal is a success, return true;
            return true;
        } // END: trying to remove CreditCard object at index n
        // Catch any errors that may arise while attempting to remove CreditCard
        catch (Exception e)
        {
            // assuming the removal fails, return false
            return false;
        } // END: Catching out of bounds errors
    } // END: removeCard() method

    /**
	 * TODO Add Description
	 *
	 * <hr>
	 * Date created: Feb 23, 2020
	 *
	 * <hr>
	 */
    public ArrayList<CreditCard> getCardsByExpir()
    {
        return null;
    } // END: getCardsbyExpir() method

    /**
	 * TODO Add Description
	 *
	 * <hr>
	 * Date created: Feb 23, 2020
	 *
	 * <hr>
	 */
    public CreditCard getCardByIndex(int n)
    {
        return null;
    } // END: getCardByIndex() method

    /**
	 * TODO Add Description
	 *
	 * <hr>
	 * Date created: Feb 23, 2020
	 *
	 * <hr>
	 */
    public ArrayList<CreditCard> getCardsByName(String name)
    {
        return null;
    } // END: getCardsByName() method

    /**
	 * TODO Add Description
	 *
	 * <hr>
	 * Date created: Feb 23, 2020
	 *
	 * <hr>
	 */
    public ArrayList<CreditCard> getCardsByNumber(String number)
    {
        return null;
    } // END: getCardsByNumber() met

    /**
	 * Loop through the entire wallet, and send its information to the
     * StringBuilder object so the user can view their entire wallet. The
     * StringBuilder object will be converted to a String before being
     * return to the runtime environment
	 *
	 * <hr>
	 * Date created: Feb 23, 2020
	 *
	 * <hr>
	 */
    public String getAllCards()
    {
        // if the wallet is empty, return this
        if (wallet.size() == 0)
        {
            return "Your wallet is empty!";
        } // END: if wallet is empty

        // create a new StringBuilder object
        StringBuilder allCards = new StringBuilder();

        /*
         * loop through the entire wallet, and sending its information to the
         * StringBuilder object so the user can view their entire wallet
         */
        for (int i = 0; i < wallet.size(); i++)
        {
            // add the information about the current card to the StringBuilder
            allCards.append("Card at Index " + i + ":\n");
            allCards.append(wallet.get(i).generateReport());
            allCards.append("\n");
        } // END: looping through wallet

        // return the String converstion of the StringBuilder object
        return allCards.toString();
    } // END: getAllCards() method

    /**
	 * TODO Add Description
	 *
	 * <hr>
	 * Date created: Feb 23, 2020
	 *
	 * <hr>
	 */
    public void sortCardsByNumber()
    {

    } // END: sortCardsByNumber() method

    /**
	 * TODO Add Description
	 *
	 * <hr>
	 * Date created: Feb 23, 2020
	 *
	 * <hr>
	 */
    public void sortCardsByName()
    {

    } // END: sortCardsByName method
 } // END: CreditCardList class