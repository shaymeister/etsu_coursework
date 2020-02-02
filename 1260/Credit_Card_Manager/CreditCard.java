/**
 * ---------------------------------------------------------------------------
 * File name: CreditCard.java
 * Project name: Credit_Card_Manager
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 * Course:  CSCI 1260-288
 * Creation Date: Jan 31, 2020
 * ---------------------------------------------------------------------------
 */

import java.util.Calendar;

/**
 * encapsulate and manage the information
 * for credit card objects
 *
 * <hr>
 * Date created: Jan 31, 2020
 * <hr>
 * @author Shay Snyder
 */
public class CreditCard
{
	// Initialize the Calendar Class
	Calendar calendar = Calendar.getInstance();

	// Variables
	private int currentMonth = calendar.get(calendar.MONTH);
	private int currentYear = calendar.get(calendar.MONTH);
	private String cardHolderName;
	private String cardNumber;
	private String expirationDate;
	private String accountNumber;
	private boolean isCardNumberValid;
	private boolean isCardExpired;
	private Brand brand;
	private Industry majorIndustry;

	/**
	 * Constructor
	 * Default constructor for the CreditCard class
     *
	 * <hr>
	 * Date created: Jan 31, 2020
	 *
	 *
	 */
	public CreditCard()
	{
        // Set the default values for new credit card objects
		this.cardHolderName = null;
		this.cardNumber = null;
		this.expirationDate = null;
		this.isCardNumberValid = false;
		this.isCardExpired = true;
	} // END: CreditCard constructor

	/**
	 * allow programs that instanciate the CredidCard class to manipulate
     * the String attribute containing the cardholder's name
	 *
	 * <hr>
	 * Date created: Jan 31, 2020
	 *
	 * <hr>
	 * @param name (string variable containing the cardholder's name)
	 */
	public void setCardHolderName(String name)
	{
		this.cardHolderName = name;
	} // END: setCardHolderName method

	/**
	 * allow programs that instanciate the CreditCard class to manipulate
     * the String attribute containing the card's number
	 *
	 * <hr>
	 * Date created: Jan 31, 2020
	 *
	 * <hr>
	 * @param number (string variable containing the credit card number)
	 */
	public void setCardNumber(String number)
	{
		this.cardNumber = number;
	} // END: setCardNumber method

	/**
	 * allow programs that instanciate the CreditCard class to manipulate
     * the String attribute containing the card's expiration date 
	 *
	 * <hr>
	 * Date created: Jan 31, 2020
	 *
	 * <hr>
	 * @param date (String variable containing the card's expiration date as MM/YYYY)
	 */
	public void setExpirationDate(String date)
	{
		this.expirationDate = date;
	} // END: setExpirationDate method

	/**
	 * allow programs that instanciate the CreditCard class to intialize
     * the process of checking the card number's validity and expiration
     * date. If the card number is valid, the method determine the
     * card's specific network / industry
	 *
	 * <hr>
	 * Date created: Jan 31, 2020
	 *
	 * <hr>
	 */
	public void processCardInformation()
	{
		checkCardNumber();
		checkExpirationDate();

		if(isCardNumberValid)
		{
			determineBrand();
			determineIndustry();
		}
    } // END: processCardInformation method

	/**
	 * generate a detailed report of various attributes
     * about the credit card in the form of a String
	 *
	 * <hr>
	 * Date created: Jan 31, 2020
	 *
	 * <hr>
	 * @return a String variable containing the report
	 */
	public String generateReport()
	{
		String report; // to hold the soon to be generated report

        // if the card is valid, generate a report detailing various attributes
		if (isCardNumberValid)
		{   
			report = "---------------------------------------------------------------------------\n"
				   + "Is Card Number Valid? " + this.isCardNumberValid + "\n"
				   + "Is Card Expired? " + this.isCardExpired + "\n"
				   + "Issuer Identification Number: " + this.cardNumber.substring(0, 5) + "\n"
				   + "Card Brand: " + this.brand + "\n"
				   + "Card Holder: " + this.cardHolderName + "\n"
				   + "Card Number: " + this.cardNumber + "\n"
				   + "Expiration Date: " + this.expirationDate + "\n"
				   + "Account Number: " + this.cardNumber.substring(6, this.cardNumber.length() - 2) + "\n"
				   + "---------------------------------------------------------------------------";
		}
        // if the card isn't valid, generate a report listing that single attributes
		else
		{
			report = "Sorry, the card number is invalid.";
		}

        // return the generated report to the runtime environment
		return report;
	} // END: generateReport method

	/**
	 * check if the credit card has expired and manipulate 
     * the isCardExpired boolean attribute accordingly
	 *
	 * <hr>
	 * Date created: Jan 31, 2020
	 *
	 * <hr>
	 */
	private void checkExpirationDate()
	{
        // if the card isn't expired, return false
		if (this.expirationDate.length() == 7 &&
			Integer.parseInt(this.expirationDate.substring(0, 1)) < currentMonth &&
			Integer.parseInt(this.expirationDate.substring(3, 6)) >= currentYear)
		{
			this.isCardExpired = false;
		}
        
        // if the card is expired, return true
		else
		{
			this.isCardExpired = true;
		}
	} // END: checkExpirationDate method

	/**
	 * Enter method description here
	 *
	 * <hr>
	 * Date created: Jan 31, 2020
	 *
	 * <hr>
	 */
	private void checkCardNumber()
	{
		int sum = 0;

		for(int i = 1; i <= this.cardNumber.length() - 1; i += 2)
		{
			int x = Integer.parseInt(this.cardNumber.substring(i, i + 1)) * 2;

			if(x > 9)
			{
				x -= 9;
			}
			sum += x;
		}

		if(sum % 10 == 0)
		{
			this.isCardNumberValid = true;
		}

	}

	/**
	 * Enter method description here
	 *
	 * <hr>
	 * Date created: Jan 31, 2020
	 *
	 * <hr>
	 */
	private void determineBrand()
	{
		// Checking for American Express
		if (this.cardNumber.substring(0, 2).equals("34") ||
			this.cardNumber.substring(0, 2).equals("37"))
		{
			this.brand = Brand.AMERICAN_EXPRESS;
		}

		// Checking for Discover
		else if(this.cardNumber.substring(0, 4).equals("6011") ||
				this.cardNumber.substring(0, 3).equals("644") ||
				this.cardNumber.substring(0, 3).equals("655"))
		{
			this.brand = Brand.DISCOVER;
		}

		// Checking for MasterCard
		else if(this.cardNumber.substring(0, 2).equals("51") ||
			    this.cardNumber.substring(0, 2).equals("55"))
		{
			this.brand = Brand.MASTERCARD;
		}

		// Checking for VISA
		else if(this.cardNumber.charAt(0).equals("4"))
		{
			this.brand = Brand.VISA;
		}

		// Misc card brand
		else
		{
			this.brand = Brand.OTHER;
		}
	}

	/**
	 * Enter method description here
	 *
	 * <hr>
	 * Date created: Jan 31, 2020
	 *
	 * <hr>
	 */
	private void determineIndustry()
	{
		switch(this.cardNumber.charAt(0))
		{
			case 1:
			case 2:
				this.majorIndustry = Industry.AIRLINES;
				break;

			case 3:
				this.majorIndustry = Industry.TRAVEL;
				break;

			case 4:
			case 5:
				this.majorIndustry = Industry.BANKING_AND_FINANCIAL;
				break;

			case 6:
				this.majorIndustry = Industry.MERCHANDISING_BANKING_AND_FINANCIAL;
				break;

			case 7:
				this.majorIndustry = Industry.PETROLEUM;
				break;

			case 8:
				this.majorIndustry = Industry.HEALTHCARE_OR_TELECOMMUNICATIONS;
				break;

			case 9:
				this.majorIndustry = Industry.NATIONAL_ASSIGNMENT;
				break;
		}
	}
}
