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
 * Enter type purpose here
 *
 * <hr>
 * Date created: Jan 31, 2020
 * <hr>
 * @author Shay Snyder
 */
public class CreditCardManagerDriver
{

	/**
	 * Enter method description here         
	 *
	 * <hr>
	 * Date created: Jan 31, 2020
	 *
	 * <hr>
	 * @param args
	 */
	public static void main (String [ ] args)
	{
		/*
		 * TODO write a comment about the do-while loop
		 */
		do
		{
			// create an instance of the CreditCard class
			CreditCard card = new CreditCard();
			
			/*
			 *  use JOptionPane to prompt the user
			 *  to enter the card holder's name
			 */
			card.setCardHolderName(JOptionPane.showInputDialog(
					"What is the card holder's full name?", "Jack Bauer"));
			
			/*
			 * use JOptionPane to prompt the user 
			 * to enter the credit card number
			 */
			card.setCardNumber(JOptionPane.showInputDialog(
					"What is the card number"));
			
			/*
			 * use JOptionPane to prompt the user
			 * to enter the card's expiration date
			 */
			card.setExpirationDate(JOptionPane.showInputDialog(
					"What is the card's expiration date?",
					"MM/YYYY"));
			
			/*
			 * process the entered information
			 */
			card.processCardInformation();
			
			/*
			 * use JOptionPane to display a report of the
			 * entered credit card information
			 */
			JOptionPane.showMessageDialog(null,
					card.generateReport(),
					"Credit Card Summary",
					JOptionPane.INFORMATION_MESSAGE);
			
		} while (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(
					null, "Would you have more information to process?"));

	} // END: main method

} // END: CreditCardManagerDriver class
