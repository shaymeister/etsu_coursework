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

// Required Packages
import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.Collections;

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

    // create a boolean attribute so determine when a save is needed
    boolean saveNeeded;

    // create a String attribute representing the location of the CreditCardList
    String filePath = null;

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
	 * TODO Finish Documentation
	 *
	 * <hr>
	 * Date created: March 15, 2020
	 *
	 * <hr>
	 */
    public CreditCardList(String path)
    {
        // TODO Finish Implementation
        System.out.println("Entered the argument constructor for the CreditCardList class");
    } // END: arg constructor

    /**
	 * return the boolean attribute containing the save status of the
     * CreditCard list
	 *
	 * <hr>
	 * Date created: Feb 23, 2020
	 *
	 * <hr>
	 */
    public boolean getSaveNeeded()
    {
        // return the saveNeeded boolean
        return this.saveNeeded;
    } // END: getSaveNeeded() method

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
        CreditCard card = new CreditCard(name, number, date);

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
	 * Loop through every card within the wallet and return a string detailing
     * every credit card that is expired
	 *
	 * <hr>
	 * Date created: Feb 23, 2020
	 *
	 * <hr>
	 */
    public String getCardsByExpiration()
    {
        // Create a StringBuilder object to hold all expired cards
        StringBuilder string = new StringBuilder();

        /*
         * create a boolean variable:
         * true = some cards are expired
         * false = no cards are expired
         */
        boolean someCardsExpired = false;

        /*
         * add a line to the beginning of the string describing the cards within
         */
        string.append("The following credit cards are expired:\n"
                    + "---------------------------------------------------------------------------\n");

        // loop through every card in the current wallet
        for (int i = 0; i < wallet.size(); i++)
        {
            /*
             * If the CreditCardList object at index i is expired, add it to
             * the new StringBuilder object
             */
            if (wallet.get(i).getIsCardExpired())
            {
                // add the expired card to the StringBuilder object
                string.append(wallet.get(i).generateReport());

                // change the toggle to true since a card is expired
                someCardsExpired = true;
            } // END: retrieving expired cards
        } // END: looping through every card within the wallet

        // if some cards are expired, return the String holding their information
        if (someCardsExpired)
        {
            // return the wallet containing the newly created CreditCardList Object
            return string.toString();
        }

        // default: return a String stating that no cards are expired
        return "No cards are expired!";
    } // END: getCardsbyExpiration() method

    /**
	 * return a String object detailing the card at index n
	 *
	 * <hr>
	 * Date created: Feb 23, 2020
	 *
	 * <hr>
	 */
    public String getCardByIndex(int n)
    {
        // make sure the desired index is in the ArrayList
        if (n < 0 || n >= wallet.size())
        {
            /*
             * if the desired index is outside of the array index
             * return a string saying there is no card at index n
             */
            return "No card is available at index " + n;
        }

        // return the card at index n
        return "The card at index " + n + ":\n"
             + "---------------------------------------------------------------------------\n"
             + wallet.get(n).generateReport();
    } // END: getCardByIndex() method

    /**
	 * return a String detailing all cards whose holder matches the
     * argumented String
	 *
	 * <hr>
	 * Date created: Feb 23, 2020
	 *
	 * <hr>
	 */
    public String getCardsByName(String name)
    {
        // Create a StringBuilder object to hold all matches
        StringBuilder string = new StringBuilder();

        /*
         * create a boolean variable:
         * true = some cards match
         * false = no cards match
         */
        boolean cardsFound = false;

        /*
         * add a line to the beginning of the string describing the cards within
         */
        string.append("The following credit cards are held by " + name + ":\n"
                    + "---------------------------------------------------------------------------\n");

        // loop through every card in the current wallet
        for (int i = 0; i < wallet.size(); i++)
        {
            /*
             * If the CreditCardList object at index i is held by the given
             * name, add it to the new StringBuilder object
             */
            if (wallet.get(i).compareName(name) == 0)
            {
                // add the expired card to the StringBuilder object
                string.append(wallet.get(i).generateReport());

                // change the toggle to true since a match was found
                cardsFound = true;
            } // END: retrieving matching cards
        } // END: looping through every card within the wallet

        // if some matches are found, return the String holding their information
        if (cardsFound)
        {
            // return the wallet containing the newly created CreditCardList Object
            return string.toString();
        }

        // default: return a String stating that no matches are found
        return "No matches were found!";
    } // END: getCardsByName() method

    /**
	 * return a String detailing all cards whose number matches the
     * argumented String
	 *
	 * <hr>
	 * Date created: Feb 23, 2020
	 *
	 * <hr>
	 */
    public String getCardsByNumber(String number)
    {
        // Create a StringBuilder object to hold all matches
        StringBuilder string = new StringBuilder();

        /*
         * create a boolean variable:
         * true = some cards match
         * false = no cards match
         */
        boolean cardsFound = false;

        /*
         * add a line to the beginning of the string describing the cards within
         */
        string.append("The following credit cards have the number " + number + ":\n"
                    + "---------------------------------------------------------------------------\n");

        // loop through every card in the current wallet
        for (int i = 0; i < wallet.size(); i++)
        {
            /*
             * If the CreditCardList object at index i has a matching card
             * number, add it to the new StringBuilder object
             */
            if (wallet.get(i).compareNumber(number) == 0)
            {
                // add the matching card to the StringBuilder object
                string.append(wallet.get(i).generateReport());

                // change the toggle to true since a match was found
                cardsFound = true;
            } // END: retrieving matching cards
        } // END: looping through every card within the wallet

        // if some matches are found, return the String holding their information
        if (cardsFound)
        {
            // return the wallet containing the newly created CreditCardList Object
            return string.toString();
        }

        // default: return a String stating that no matches are found
        return "No matches were found!";
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

        // the following addition is for better visuals
        allCards.append("---------------------------------------------------------------------------\n");

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
	 * Use the Selection Sort Algorithm along with the CreditCard object's
     * compareNumber method to sort the cards by number
	 *
	 * <hr>
	 * Date created: Feb 23, 2020
	 *
	 * <hr>
	 */
    public void sortCardsByNumber()
    {
        /*
         * The outer loop's purpose is to keep track of the last index within
         * the user's CreditCardList. As the loop progresses, this value will
         * be decremented to account for the action of swapping the CreditCard
         * object whose card number has the max numerical value to the last
         * position.
         */
        for (int n = wallet.size() - 1; n >= 0; n--)
        {
            /*
             * The inner loop is used to sort through the entire list to find
             * the maxiumum value. As the algorithm progresses, the indecies
             * available to this loop will shorten as the maxiumum values will
             * swapped to the end of the ArrayList and no longer need to be
             * accessed
             */
            for(int i = 0; i < n; i++)
            {
                /*
                 * Use the CreditCardList's compareNumber method to determine
                 * if the value at index i is greater than the value in the last
                 * position of the list (n), swap the CreditCard object at i w/
                 * the CreditCardObject at n
                 *
                 * As this method iterates over the entire list, the maxiumum
                 * will be determined since every value is compared with the
                 * last CreditCard object in the list
                 */
                if(wallet.get(i).compareNumber(wallet.get(n)) > 0)
                {
                    /*
                     * Use the Collections.swap() method to swap the CreditCard
                     * with a greater number at index i to the CreditCard with
                     * a lesser value at index n
                     */
                    Collections.swap(wallet, n, i);
                } // END: determining max
            } // END: iterating over entire loop
        } // END: selection sort algorithm
    } // END: sortCardsByNumber() method

    /**
	 * Use the Selection Sort Algorithm along with the CreditCard object's
     * compareName method to sort the cards by the name of their holder
	 *
	 * <hr>
	 * Date created: Feb 23, 2020
	 *
	 * <hr>
	 */
    public void sortCardsByName()
    {
        /*
         * The outer loop's purpose is to keep track of the last index within
         * the user's CreditCardList. As the loop progresses, this value will
         * be decremented to account for the action of swapping the CreditCard
         * objects whose card holder has the max alphabetical value to the last
         * position.
         */
        for (int n = wallet.size() - 1; n >= 0; n--)
        {
            /*
             * The inner loop is used to sort through the entire list to find
             * the maxiumum alphabetical value. As the algorithm progresses, the
             * indicies available to this loop will shorten as the maxiumum
             * values will swapped to the end of the ArrayList and no longer
             * need to be accessed
             */
            for(int i = 0; i < n; i++)
            {
                /*
                 * Use the CreditCardList's compareName method to determine
                 * if the alphabetical value at index i is greater than the
                 * alphabetical value in the last position of the list (n), swap
                 * the CreditCard object at i w/ the CreditCardObject at n
                 *
                 * As this method iterates over the entire list, the maxiumum
                 * will be determined since every value is compared with the
                 * last CreditCard object in the list
                 */
                if(wallet.get(i).compareName(wallet.get(n)) > 0)
                {
                    /*
                     * Use the Collections.swap() method to swap the CreditCard
                     * with a greater number at index i to the CreditCard with
                     * a lesser value at index n
                     */
                    Collections.swap(wallet, n, i);
                } // END: determining max
            } // END: iterating over entire loop
        } // END: selection sort algorithm
    } // END: sortCardsByName method

    /**
	 * TODO Finish Documentation
	 *
	 * <hr>
	 * Date created: March 15, 2020
	 *
	 * <hr>
	 */
    public void save()
    {
        // TODO: Finish Implementation
    } // END: save() method

    /**
	 * TODO Finish Documentation
	 *
	 * <hr>
	 * Date created: March 15, 2020
	 *
	 * <hr>
	 */
    public void save(String path)
    {
        // TODO: Finish Implementation
    } // END: save() method
} // END: CreditCardList class