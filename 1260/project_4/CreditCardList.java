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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

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

    // create a boolean attribute to determine when a save is needed
    private boolean saveNeeded = false;

    // create a boolean attribute to determine if the list was imported
    private boolean imported;

    // create a String attribute representing the location of the CreditCardList
    private String filePath = null;

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
        this.wallet = new ArrayList<CreditCard>();

        // set the default file path
        this.filePath = "CreditCardData/tmp.text";

        // set the saveNeedted and imported attributes to 'false'
        this.imported = false;
        this.saveNeeded = false;

    } // END: no-arg constructor

    /**
	 * create a list of CreditCard objects from a specificied file at
     * the argumented path
	 *
	 * <hr>
	 * Date created: March 15, 2020
	 *
	 * <hr>
	 */
    public CreditCardList(String path)
    {
        // Initialize the ArrayList of CreditCard objects
        this.wallet = new ArrayList<CreditCard>();

        // Attempt to read from the file at the argumented path
        try
        {
            // initialize the PrintWriter class to the specified path
            File file = new File(path);

            // initialize the Scanner class with the specified file
            Scanner inputFile = new Scanner(file);

            // create a String array to hold each card's details
            String[] cardDetails = null;

            // loop through every line the argumented file
            while(inputFile.hasNextLine())
            {
                // split the line of the file into the cardDetails String array
                cardDetails = inputFile.nextLine().split("\\|");
                
                /* 
                 * if the String array fits the following criteria, add the card to the list
                 * 
                 * 1) cardDetails != null : this ensures the String array contains some value
                 * 2) cardDetails.length == 3 : this ensures that their are three distinct sets of
                 *     data within a given line
                 * 3) cardDetails[0] != null : this ensures that the first data attribute contains
                 *     some form of data, even an empty String
                 * 4) cardDetails[1] != null : this ensures that the second data attribute contains
                 *     soem form of data, even an empty String
                 * 5) isNumeric(cardDetails) : this ensures the data within the second data
                 *     attribute is numerical
                 * 6) cardDetails[2] != null : this ensures that there is some form of data within
                 *     within the third data attribute, even an empty String
                 * 7) cardDetails[2].length() == 7 : this ensures that the third data attribute is
                 *     in the correct format (MM/YYYY)
                 * 8) isNumeric(cardDetails[2].substring(0,2) : aside from the forward slash,
                 *     this ensures the month section in the third data attribute contains
                 *     numerical data
                 * 9) isNumeric(cardDetails[2].substring(4)) : aside from the forward slash, this
                 *     ensures the year section in the third data attribute contains numerical data
                 */
                if (cardDetails != null && cardDetails.length == 3 && cardDetails[0] != null &&
                    cardDetails[1] != null && isNumeric(cardDetails[1]) && cardDetails[2] != null &&
                    cardDetails[2].length() == 7 && isNumeric(cardDetails[2].substring(0,2)) &&
                    isNumeric(cardDetails[2].substring(4)))
                {
                    /*
                     * Create a new CreditCard object based upon the data in the cardDetails String[]
                     * 
                     * Assuming the cardDetails variable is in the correct format:
                     * cardDetails[0] = the card holder's name in the form of a String
                     * cardDetails[1] = the card's number in the form of a String
                     * cardDetails[2] = the card's expiration date in the form of a String
                     */
                    wallet.add(new CreditCard(cardDetails[0], cardDetails[1], cardDetails[2]));
                } // END: if data at line n is valid
            } // END: looping through all lines within the file

            // set the imported, filePath, and saveNeed attributes
            this.filePath = path;
            this.imported = true;
            this.saveNeeded = false;

            // close the Scanner object
            inputFile.close();
        } // END: attempting to read from file
        // catch any errors that may arise
        catch(IOException e)
        {
            // set the default file path
            this.filePath = "CreditCardData/tmp.text";

            // set the saveNeedted and imported attributes to 'false'
            this.imported = false;
            this.saveNeeded = false;
        } // END: error catching
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
	 * return the boolean attribute specifiying if the list was imported
	 *
	 * <hr>
	 * Date created: Feb 23, 2020
	 *
	 * <hr>
	 */
    public boolean getImported()
    {
        // return the imported boolean
        return this.imported;
    } // END: getImported() method

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

        // toggle the saveNeeded boolean
        this.saveNeeded = true;
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

            // toggle the saveNeeded boolean
            this.saveNeeded = true;

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

        // toggle the saveNeeded boolean
        this.saveNeeded = true;
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

        // toggle the saveNeeded boolean
        this.saveNeeded = true;
    } // END: sortCardsByName method

    /**
	 * Determine if the argument String can be parsed to an int
	 *
	 * <hr>
	 * Date created: Feb 23, 2020
	 *
	 * <hr>
	 */
    private static boolean isNumeric(String number)
    {
        /*
         * Use a try catch to determine if the String can
         * be parsed to an integer
         */
        try
        {
            // try to parse the String
            Long.parseLong(number);
        } // END: try
        catch (Exception e)
        {
            // return false is the String fails to parse
            return false;
        } // END: catch

        /*
         * assuming no error what thrown, return true as the
         * String was successfully parsed to an int
         */
        return true;
    } // END: isNumeric() method

    /**
	 * save the user's CreditCardList to either the imported file or a
     * temporary file
	 *
	 * <hr>
	 * Date created: March 15, 2020
	 *
	 * <hr>
	 */
    public void save()
    {   
        PrintWriter outfile = null; // to hold the PrintWriter object

        // create and open a new PrintWriter file object
        try
        {
            outfile = new PrintWriter (this.filePath);
        } // END: attempting to create a PrintWriter object at the savePath
        catch (FileNotFoundException e) 
        {
            // Display the error to the command prompt
            System.out.println("An unexpected error has occured.");

            // Terminate the progam
            System.exit(0);
        } // END: catching potential errors during PrintWriter initialization

        /*
         * loop through every CreditCard in the list except the last one
         */
        for (int i = 0; i < wallet.size() - 1; i++)
        {
            outfile.println(wallet.get(i).toString());
        }

        /*
         * Print the last CreditCard in the ArrayList; print is used rather
         * than println to avoid leaving a blank line at the end of the file
         */
        outfile.print(wallet.get(wallet.size() - 1).toString());

        // close the PrintWriter object
        outfile.close();

        // toggle the saveNeeded boolean attribute
        this.saveNeeded = false;
    } // END: save() method

    /**
	 * save the user's CreditCardList to the specified file
	 *
	 * <hr>
	 * Date created: March 15, 2020
	 *
	 * <hr>
	 */
    public void save(String path)
    {
        PrintWriter outfile = null; // to hold the PrintWriter object

        // create and open a new PrintWriter file object
        try
        {
            outfile = new PrintWriter (path);
        } // END: attempting to create a PrintWriter object at the savePath
        catch (FileNotFoundException e) 
        {
            // Display the error to the command prompt
            System.out.println("An unexpected error has occured.");

            // Terminate the progam
            System.exit(0);
        } // END: catching potential errors during PrintWriter initialization

        /*
         * loop through every CreditCard in the list except the last one
         */
        for (int i = 0; i < wallet.size() - 1; i++)
        {
            outfile.println(wallet.get(i).toString());
        }

        /*
         * Print the last CreditCard in the ArrayList; print is used rather
         * than println to avoid leaving a blank line at the end of the file
         */
        outfile.print(wallet.get(wallet.size() - 1).toString());

        // close the PrintWriter object
        outfile.close();

        // toggle the saveNeeded boolean attribute
        this.saveNeeded = false;
    } // END: save() method

    /**
	 * delete the program's temp file
	 *
	 * <hr>
	 * Date created: March 15, 2020
	 *
	 * <hr>
	 */
    public void deleteTempFile()
    {
        // make sure the file wasn't imported
        if (!imported)
        {
            // create a new file object of the temp file
            File file = new File(this.filePath);

            // delete the temp file
            file.delete();
        } // END: if not imported
    } // END: deleteTempFile() method
} // END: CreditCardList class