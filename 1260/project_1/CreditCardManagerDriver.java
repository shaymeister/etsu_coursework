/**
 * ---------------------------------------------------------------------------
 * File name: CreditCardManagerDriver.java
 * Project name: Credit_Card_Manager
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 * Course:  CSCI 1260-288
 * Creation Date: Jan 31, 2020
 * ---------------------------------------------------------------------------
 */

import javax.swing.JOptionPane;

/**
 * use JOptionPane to drive and manage the CreditCard class
 *
 * <hr>
 * Date created: Jan 31, 2020
 * <hr>
 * @author Shay Snyder
 */
public class CreditCardManagerDriver
{

	/**
	 * act as the main method behind the driver class
	 *
	 * <hr>
	 * Date created: Jan 31, 2020
	 *
	 * <hr>
	 */
	public static void main (String [ ] args)
	{
		// introduce the program to the user
		intro();

		// perform the main functions of the program
		core();

		// thank the user
		outro();
	} // END: main method

	/**
	 * introduce the program to the user
	 *
	 * <hr>
	 * Date created: Jan 31, 2020
	 *
	 * <hr>
	 */
	private static void intro()
	{
		// create a String variable that contains the desired intro message
		String message = "Welome to my Credit Card Manager!\n\n"
			+ "This program allows the user to enter their credit card\n"
			+ "information and a prompt, listing various attributes of a\n"
			+ "given credit, will be generated.\n\n"
			+ "Enjoy!";

		// use JOptionPane to display the intro message
		JOptionPane.showMessageDialog(null, message,
			"Credit Card Manager", JOptionPane.INFORMATION_MESSAGE);
	} // END: intro method

	/**
	 * process the user's credit card information until they decide to stop
	 *
	 * <hr>
	 * Date created: Jan 31, 2020
	 *
	 * <hr>
	 */
	private static void core()
	{
		/*
		 * use a post-test loop to check if the user would like to enter more
		 * credit card information. if so, continue the program. if not,
		 * end the program
		 */
		do
		{
			// create an instance of the CreditCard class
			CreditCard card = new CreditCard();

			/*
			 * use JOptionPane to prompt the user to enter the card holder's
			 * name
			 */
			String name = JOptionPane.showInputDialog(
				"What is the card holder's full name?");
			/*
			 * if the user clicks cancel or closes the window,
			 * break away from the loop and start the outro
			 *
			 * if the user enters a value, use the CreditCard class set
			 * the value
			 */
			if (name != null)
			{
				card.setCardHolderName(name);
			}
			else
			{
				break;
			}



			/*
			 * use JOptionPane to prompt the user to enter the credit card
			 * number
			 */
			String cardNumber = JOptionPane.showInputDialog(
				"What is the card number");
			/*
			 * if the user clicks cancel or closes the window,
			 * break away from the loop and start the outro
			 *
			 * if the user enters a value, use the CreditCard class set
			 * the value
			 */
			if(cardNumber != null)
			{
				card.setCardNumber(cardNumber);
			}
			else
			{
				break;
			}


			/*
			 * use JOptionPane to prompt the user to enter the card's
			 * expiration date
			 */
			String date = JOptionPane.showInputDialog(
				"What is the card's expiration date?",
				"<MM>/<YYYY>");
			/*
			 * if the user clicks cancel or closes the window,
			 * break away from the loop and start the outro
			 *
			 * if the user enters a value, use the CreditCard class set
			 * the value
			 */
			if(date != null)
			{
				card.setExpirationDate(date);
			}
			else
			{
				break;
			}

			// process the entered information
			card.processCardInformation();

			/*
			 * use JOptionPane to display a report of the entered credit card
			 * information
			 */
			JOptionPane.showMessageDialog(null,
					card.generateReport(),
					"Credit Card Summary",
					JOptionPane.INFORMATION_MESSAGE);

			/*
			 * use JOptionPane to ask the user if they have any more credit
			 * card information they would like to process
			 */
		} while (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(
			null, "Do you have more information to process?")); // END: do-while loop
	} // END: core method

	/**
	 * thank the user for using the program
	 *
	 * <hr>
	 * Date created: Jan 31, 2020
	 *
	 * <hr>
	 * @param args not used in the program
	 */
	private static void outro()
	{
		// create a String variable that contains the desired outro message
		String message = "Thank you for using my Credit Card Manager!\n"
			+ "Please come again!";

		// use JOptionPane to display the outro message
		JOptionPane.showMessageDialog(null, message,
			"Credit Card Manager", JOptionPane.INFORMATION_MESSAGE);
	} // END: outro method
} // END: CreditCardManagerDriver class