/**
 * ---------------------------------------------------------------------------
 * File name: CreditCardListDriver.java
 * Project name: Credit_Card_List
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 * Course:  CSCI 1260-288
 * Creation Date: Feb 13, 2020
 * ---------------------------------------------------------------------------
 */

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.plaf.DimensionUIResource;

/**
 * allow the user to interact with the CreditCardList class
 * by providing an easy to use interface and the methodology
 * required to run the other classes
 *
 * <hr>
 * Date created: Feb 23, 2020
 * <hr>
 * @author Shay Snyder
 */
public class CreditCardListDriver
{
    /**
	 * The main() method acts as the central nervous system
     * of the entire CreditCardList project. All other
     * method calls originate from this point
	 *
	 * <hr>
	 * Date created: Feb 23, 2020
	 *
	 * <hr>
	 */
    public static void main(String[] args)
    {
        // use the CreditCardList class to create a wallet object
        CreditCardList wallet = new CreditCardList();

        // use the intro() method to introduce the project to the user
        intro();

        // start the main aspect of the program
        core(wallet);
    } // END: main() method

    /**
	 * The intro() method uses JOptionPane to display a prompt to the
     * user once the CreditCardList project is initialized
	 *
	 * <hr>
	 * Date created: Feb 23, 2020
	 *
	 * <hr>
	 */
    private static void intro()
    {
        // Use JOptionPane to welcome the user to the program
        JOptionPane.showMessageDialog(null,
                "Welcome to Shay's Credit Card List Project!",
                "Credit Card List Manager",
                JOptionPane.INFORMATION_MESSAGE);
    } // END: intro() method

    /**
	 * The core() method is the epicenter of the CreditCardList project,
     * this is where the user will be able to see a list of their cards, and
     * be able to manipulate the ArrayList of CreditCard objects. JOptionPane
     * will be used to provide a visually appealing gui and manage the i/o
	 *
	 * <hr>
	 * Date created: Feb 23, 2020
	 *
	 * <hr>
	 */
    private static void core(CreditCardList wallet)
    {
        // run the core until the user decides to end the program
        while (true)
        {
            /*
             * Create a String array of the various ways the user can
             * manipulate their wallet
             */
            final String[] OPTIONS = {"get card(s)",
                                      "sort cards",
                                      "remove card",
                                      "add card"};

            /*
             * create a JTextArea that will allow us to create a text area with
             * a scroll bar so the user can view all of their cards
             */
            JTextArea textArea = new JTextArea(wallet.getAllCards(), 50, 50);

            // make the text area uneditable
            textArea.setEditable(false);

            // create a scroll pane with our text area
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setMaximumSize(new DimensionUIResource(500, 500));
            scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            /*
             * display a JOptionPane OptionDialog box that lists all cards in
             * the wallet and display various options for the user to
             * manipulate the wallet
             */
            int result = JOptionPane.showOptionDialog(null,
                        scrollPane,
                        "Credit Card List Manager",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        OPTIONS,
                        -1);

            switch (result)
            {
                // User presses 'X' button
                case -1:
                    // call the outro method
                    outro();
                    break;

                // User presses 'get card(s)' button
                case 0:
                    /*
                     * call the 'getCards()' method with the argumented
                     * CreditCardList 'wallet' object that represents the
                     * user's array of credit cards
                     */
                    getCards(wallet);
                    break;

                // User presses 'sort cards' button
                case 1:
                    /*
                     * call the 'sortCards()' method with the argumented
                     * CreditCardList 'wallet' object that represents the
                     * user's array of credit cards
                     */
                    sortCards(wallet);
                    break;

                // User presses 'remove card' button
                case 2:
                    /*
                     * call the 'removeCard()' method with the argumented
                     * CreditCardList 'wallet' object that represents the
                     * user's array of credit cards
                     */
                    removeCard(wallet);
                    break;

                // User presses 'add card' button
                case 3:
                    /*
                     * call the 'removeCard()' method with the argumented
                     * CreditCardList 'wallet' object that represents the
                     * user's array of credit cards
                     */
                    addCard(wallet);
                    break;

                // default method in case an invalid parameter is passed
                default:
                    JOptionPane.showMessageDialog(null,
                                    "WARNING: an unexpected error has occured,"
                                  + "please try again",
                                    "Credit Card List Manager",
                                    JOptionPane.WARNING_MESSAGE);
                    break;
            } // END: switching options
        } // END: endless while loop
    } // END: core() method

    /**
	 * display an outro message to the user thanking them for using the program,
     * and make sure they want to exit the program
	 *
	 * <hr>
	 * Date created: Feb 23, 2020
	 *
	 * <hr>
	 */
    private static void outro()
    {
        // ask the user if they are sure they would like to exit the program
        int result = JOptionPane.showConfirmDialog(null,
                "Thank you for using the Credit Card List Manager!\n"
              + "Are you sure you would like to exit the program?",
                "Credit Card List Manager",
                JOptionPane.YES_NO_OPTION);

        // switch through the various outcomes to make the apporpriate action
        switch (result)
        {
            // user presses 'yes'
            case 0:
                // end the program
                System.exit(0);

            // user presses 'no'
            case 1:
                // return to the core method
                break;

            // protect against unexpected inputs
            default:
                // display a warning message to the user
                JOptionPane.showMessageDialog(null,
                    "An unexpected error has occured, exiting program",
                    "Credit Card List Manager",
                    JOptionPane.WARNING_MESSAGE);

                // end the program
                System.exit(0);
        } // END: switiching through possible results
    } // END: outro() method

    /**
	 * use getCard(), getCardNumber(), and getCardExpir() methods alongside
     * the wallet's addCard() method to add a new credit card to the user's
     * wallet
	 *
	 * <hr>
	 * Date created: Feb 23, 2020
	 *
	 * <hr>
	 */
    private static void addCard(CreditCardList wallet)
    {
        /*
         * use getCard(), getCardNumber(), and getCardExpir() methods alongside
         * the wallet's addCard() method to add a new credit card to the user's
         * wallet
         */
        wallet.addCard(getCardName(), getCardNumber(), getCardExpir());
    } // END: addCard() method

    /**
	 * Use JOptionPane to allow the user to enter the card holder's name.
     * If the entered name is invalid, prompt the user to enter another
     * until a valid name is entered.
	 *
	 * <hr>
	 * Date created: Feb 23, 2020
	 *
	 * <hr>
	 */
    private static String getCardName()
    {
        // Use JOptionPane to ask the user to enter the card holder's name
        String name = JOptionPane.showInputDialog(null,
                     "What is the card holder's name?",
                     "Credit Card List",
                     JOptionPane.QUESTION_MESSAGE);
        /*
         * if the user entered an invalid name, prompt them to enter another
         * until the name is valid
         */
        while (name == null || name.replaceAll("\\s","").equals(""))
        {
            // Use JOptionPane to as the user to enter another name
            name = JOptionPane.showInputDialog(null,
                     "WARNING: Invalid Entry. Please Try Again\n"
                   + "What is the card holder's name?",
                     "Credit Card List",
                     JOptionPane.WARNING_MESSAGE);
        } // END: looping until a correct value is entered

        // return the String variable containing the card holder's name
        return name;
    } // END: getCardName() method

    /**
	 * Use JOptionPane to allow the user to enter the card's number.
     * If the entered number is invalid, prompt the user to enter another
     * until a valid number is entered.
	 *
	 * <hr>
	 * Date created: Feb 23, 2020
	 *
	 * <hr>
	 */
    private static String getCardNumber()
    {
        // Use JOptionPane to ask the user to enter the card's number
        String number = JOptionPane.showInputDialog(null,
                     "What is the card's number",
                     "Credit Card List",
                     JOptionPane.QUESTION_MESSAGE);

        /*
         * if the user entered an invalid number, prompt them to enter another
         * until the name is valid
         */
        while (number == null || number.replaceAll("\\s", "").equals("") || !isNumeric(number))
        {
            // Use JOptionPane to as the user to enter another number
            number = JOptionPane.showInputDialog(null,
                     "WARNING: Invalid Entry. Please Try Again\n"
                   + "What is the card's number?",
                     "Credit Card List",
                     JOptionPane.WARNING_MESSAGE);
        } // END: looping until a correct value is entered

        // return the String variable containing the card's number
        return number;
    } // END: getCardNumber method

    /**
	 * Use JOptionPane to prompt the user to enter their card's expiration
     * date. Error checking will be done throughout the process
	 *
	 * <hr>
	 * Date created: Feb 23, 2020
	 *
	 * <hr>
	 */
    private static String getCardExpir()
    {
        /*
         * Use JOptionPane to prompt the user to enter a value that
         * represents the user's credit card expiration month
         */
        String month = JOptionPane.showInputDialog(null,
                            "What month does your card expire? (XX)",
                            "Credit Card List Manager",
                            JOptionPane.QUESTION_MESSAGE);

        /*
         * If the user's input is invalid or not possible, display a prompt
         * informing them of this error and allow them to enter another value
         */
        while(!isNumeric(month) || month.length() != 2
           || Integer.parseInt(month) < 1 || Integer.parseInt(month) > 12 )
        {
            month = JOptionPane.showInputDialog(null,
                        "INVALID: Please try again\n"
                      + "What month does your card expire? (XX)",
                        "Credit Card List Manager",
                        JOptionPane.QUESTION_MESSAGE);
        } // END: looping until user enter

        /*
         * Use JOptionPane to prompt the user to enter a value that
         * represents the user's credit card expiration month
         */
        String year = JOptionPane.showInputDialog(null,
                            "What year does your card expire? (XXXX)",
                            "Credit Card List Manager",
                            JOptionPane.QUESTION_MESSAGE);

        /*
         * If the user's input is invalid or not possible, display a prompt
         * informing them of this error and allow them to enter another value
         */
        while ( year.length() != 4 || !isNumeric(year) )
        {
            year = JOptionPane.showInputDialog(null,
                        "INVALID: Please try again\n"
                      + "What year does your card expire? (XX)",
                        "Credit Card List Manager",
                        JOptionPane.QUESTION_MESSAGE);
        } // END: looping until user enter

        /*
         * create a data variable that is the concatenation of month (XX)
         * and year (XXXX) into the form of (XX/XXXX)
         */
        String date = month + "/" + year;

        // return the String variable containing the card's expiration date
        return date;
    } // END: getCardNumber method

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
	 * Use JOptionPane to allow the user to remove a card at a given index.
     * The method will make sure the index is occupied and verify that the
     * user wants to remove the specific card. Then the method will display the
     * status of the removal process
	 *
	 * <hr>
	 * Date created: Feb 23, 2020
	 *
	 * <hr>
	 */
    private static void removeCard(CreditCardList wallet)
    {
        /*
         * prompt the user to enter an integer value representing the location
         * of the credit card they would like to me removed
         */
        String index = JOptionPane.showInputDialog(null,
                        "Based on index, which card would you like to remove?",
                        "Credit Card List Manager",
                        JOptionPane.QUESTION_MESSAGE);

        // if the user fails to enter a value or closes the window, return
        if (index == null || index.equals(""))
        {
            // return to the core() method
            core(wallet);
        } // END: if index is blank or null

        // make sure the argumented value can be parsed to an int
        while (!isNumeric(index))
        {
            // until a valid number is argumented, prompt the user to re-enter
            index = JOptionPane.showInputDialog(null,
                        "Based on index, which card would you like to remove?",
                        "Credit Card List Manager",
                        JOptionPane.WARNING_MESSAGE);

            // if the user fails to enter a value or closes the window, return
            if (index == null || index.equals(""))
            {
                // return to the core() method
                core(wallet);
            } // END: if index is blank or null
        } // END: looping until valid index

        // attempt to remove the card at the given index and respond appropriately
        if (wallet.removeCard(Integer.parseInt(index)))
        {
            // prompt the user of the successful removal
            JOptionPane.showMessageDialog(null,
                        "The card at index " + index + " was successfully removed!");
        } // END: if removal works
        else
        {
            // prompt the user of the unsuccessful removal
            JOptionPane.showMessageDialog(null,
                        "The card at index " + index + " was unable to be removed");
        } // END: if removal fails
    } // END: removeCard() method

    /**
	 * Using JOptionPane, allow the users to select different manners to
     * retrieve CreditCard objects from their wallet
	 *
	 * <hr>
	 * Date created: Feb 23, 2020
	 *
	 * <hr>
	 */
    private static void getCards(CreditCardList wallet)
    {
        // String array of the possible ways to get the user's cards
        final String[] OPTIONS = {"expiration date", "index", "card holder", "card number"};

        /*
         * Using JOptionPane, prompt the user to select the way to retrieve
         * a given set of credit cards from their wallet
         */
        int result = JOptionPane.showOptionDialog(null,
                        "Which attribute should the get method utilize?",
                        "Credit Card List Manager",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        OPTIONS,
                        -1);

        // use a switch statement to manage the retrieval options in 'result'
        switch (result)
        {
            // result = -1 occurs when the user closes the window
            case -1:
                /*
                 * no method is called so return to the main screen
                 * by breaking away from the switch
                 */
                break;

            // result = 0 occurs when the user selects 'expiration date'
            case 0:
                /*
                 * Use JOptionPane and the wallet's getCardsByExpir()
                 * method to display all cards that are expired
                 */
                JOptionPane.showMessageDialog(null,
                            wallet.getCardsByExpir(),
                            "Credit Card List Manager",
                            JOptionPane.INFORMATION_MESSAGE);
                break;

            // result = 1 occurs when the user selects 'index'
            case 1:
                /*
                 * prompt the user to enter an integer value representing the location
                 * of the credit card they would like to me retrieve
                 */
                String index = JOptionPane.showInputDialog(null,
                        "Based on index, which card would you like to retrieve?",
                        "Credit Card List Manager",
                        JOptionPane.QUESTION_MESSAGE);

                // if the user fails to enter a value or closes the window, return
                if (index == null || index.equals(""))
                {
                    // return to the core() method
                    core(wallet);
                } // END: if index is blank or null

                // make sure the argumented value can be parsed to an int
                while (!isNumeric(index))
                {
                    // until a valid number is argumented, prompt the user to re-enter
                    index = JOptionPane.showInputDialog(null,
                        "Invalid Input! Based on index, which card would you like to retrieve?",
                        "Credit Card List Manager",
                        JOptionPane.WARNING_MESSAGE);

                    // if the user fails to enter a value or closes the window, return
                    if (index == null || index.equals(""))
                    {
                        // return to the core() method
                        core(wallet);
                    } // END: if index is blank or null
                } // END: looping until valid index

                // display information about the retrieved card
                JOptionPane.showMessageDialog(null,
                            wallet.getCardByIndex(Integer.parseInt(index)),
                            "Credit Card List Manager",
                            JOptionPane.INFORMATION_MESSAGE);
                break;

            // result = 2 occurs when the user selects 'card holder'
            case 2:
                /*
                 * prompt the user to enter the name of the card holer they
                 * would like to look for
                 */
                String name = JOptionPane.showInputDialog(null,
                        "What card holder name would you like to look for?",
                        "Credit Card List Manager",
                        JOptionPane.QUESTION_MESSAGE);

                // if the user fails to enter a value or closes the window, return
                if (name == null || name.equals(""))
                {
                    // return to the core() method
                    core(wallet);
                } // END: if index is blank or null

                // display information about the retrieved card
                JOptionPane.showMessageDialog(null,
                            wallet.getCardsByName(name),
                            "Credit Card List Manager",
                            JOptionPane.INFORMATION_MESSAGE);
                break;

            // result = 3 occures when the user selects 'card number'
            case 3:
                /*
                 * prompt the user to enter an integer value representing the
                 * number of the credit card they would like to retrieve
                 */
                String number = JOptionPane.showInputDialog(null,
                        "What card number would you like to look for?",
                        "Credit Card List Manager",
                        JOptionPane.QUESTION_MESSAGE);

                // if the user fails to enter a value or closes the window, return
                if (number == null || number.equals(""))
                {
                    // return to the core() method
                    core(wallet);
                } // END: if index is blank or null

                // make sure the argumented value can be parsed to an int
                while (!isNumeric(number))
                {
                    // until a valid number is argumented, prompt the user to re-enter
                    number = JOptionPane.showInputDialog(null,
                        "Incorrect Input! What card number would you like to look for?",
                        "Credit Card List Manager",
                        JOptionPane.WARNING_MESSAGE);

                    // if the user fails to enter a value or closes the window, return
                    if (number == null || number.equals(""))
                    {
                        // return to the core() method
                        core(wallet);
                    } // END: if index is blank or null
                } // END: looping until valid index

                // display information about the retrieved card
                JOptionPane.showMessageDialog(null,
                            wallet.getCardsByNumber(number),
                            "Credit Card List Manager",
                            JOptionPane.INFORMATION_MESSAGE);
                break;
        } // END: switching through getCards() options
    } // END: getCards() method

    /**
	 * Use JOptionPane to allow the user to choose to sort to their wallet by
     * card holder or card number
     * w
	 *
	 * <hr>
	 * Date created: Feb 23, 2020
	 *
	 * <hr>
	 */
    private static void sortCards(CreditCardList wallet)
    {
        // String array of the possible ways to sort the user's cards
        final String[] OPTIONS = {"card holder", "card number"};

        /*
         * Using JOptionPane, prompt the user to select the way to retrieve
         * a given set of credit cards from their wallet
         */
        int result = JOptionPane.showOptionDialog(null,
                        "Which attribute should the sort method utilize?",
                        "Credit Card List Manager",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        OPTIONS,
                        -1);

        // switch through possible user actions
        switch (result)
        {
            // result = -1 occurs when the user closes the window
            case -1:
                /*
                 * no method is called so return to the main screen
                 * by breaking away from the switch
                 */
                break;

            // result = 0 occurs when the user selects 'card holder'
            case 0:
                // sort the cards by number
                wallet.sortCardsByName();
                break;

            // result = 1 occures when user selects 'card number'
            case 1:
                // sort the cards by name
                wallet.sortCardsByNumber();
                break;

            // the default is used for error catching
            default:
                // display a prompt the user about the unexpected error
                JOptionPane.showMessageDialog(null,
                                "Sorry, an unexpected error has occured.",
                                "Credit Card List Manager",
                                JOptionPane.WARNING_MESSAGE);
                break;
        } // END: switching through possible outcomes
    } // END: sortCards() method
} // END: CreditCardListDriver class