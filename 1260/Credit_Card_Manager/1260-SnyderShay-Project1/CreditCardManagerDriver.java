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
	 * @param args not used in the program
	 */
	public static void main (String [ ] args)
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
			card.setCardHolderName(JOptionPane.showInputDialog(
				"What is the card holder's full name?"));


			/*
			 * use JOptionPane to prompt the user to enter the credit card
			 * number
			 *
			 * a try-catch was used to prevent issues if the user
			 * were to press the cancel button
			 */
			card.setCardNumber(JOptionPane.showInputDialog(
				"What is the card number"));


			/*
			 * use JOptionPane to prompt the user to enter the card's
			 * expiration date
			 */
			card.setExpirationDate(JOptionPane.showInputDialog(
					"What is the card's expiration date?",
					"<MM>/<YYYY>"));

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
			null, "Would you have more information to process?")); // END: do-while loop
	} // END: main method
} // END: CreditCardManagerDriver class