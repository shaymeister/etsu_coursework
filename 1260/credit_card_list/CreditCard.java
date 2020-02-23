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
 * encapsulate, manage, and process information
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

	// ----- Variables -----
	// use the calendar object to get the current date and year
	// +1 is used here because the months in Calendar are zero-indexed
	private int currentMonth = calendar.get(calendar.MONTH) + 1;
	private int currentYear = calendar.get(calendar.YEAR);
	private String cardHolderName;
	private String cardNumber;
	private String expirationDate;
	private boolean isCardNumberValid;
	private boolean isCardExpired;
	private Issuers issuer; // network provider such as VISA or DISCOVER
	private Industry majorIndustry; // the card's major industry (MII)

	/**
	 * Constructor
	 * Default constructor for the CreditCard class
     *
	 * <hr>
	 * Date created: Jan 31, 2020
	 */
	public CreditCard()
	{
        // Set the default values for new credit card objects
		this.cardHolderName = null;
		this.cardNumber = null;
		this.expirationDate = "00/0000";
		this.isCardNumberValid = false;
		this.isCardExpired = true;
	} // END: CreditCard constructor

	/**
	 * return the expiration status of a credit card object
     *
	 * <hr>
	 * Date created: Feb 23, 2020
	 */
	public boolean getIsCardExpired()
	{
		// return the isCardExpired boolean attribute from this card
		return this.isCardExpired;
	} // END: getIsCardExpired() method

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
		// error catching if the inputed date is null
		if (date == null)
		{
			this.expirationDate = "00/0000"; // 00/0000 has no meaning
		}
		// if the inputed date is in the correct format,
		// assign it to expirationDate attribute
		else if (date.length() == 7)
		{
			this.expirationDate = date;
		}
	} // END: setExpirationDate method

	/**
	 * allow programs that instanciate the CreditCard class to intialize
     * the process of checking the card number's validity and expiration
     * date. If the card number is valid, the method determine the
     * card's specific network, industry, and expiration status
	 *
	 * <hr>
	 * Date created: Jan 31, 2020
	 *
	 * <hr>
	 */
	public void processCardInformation()
	{
		checkCardNumber();

		if(isCardNumberValid)
		{
			checkExpirationDate();
			determineIssuer();
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
			/*
			 * the substring for the issuer identification number is based upon
			 * the concept that the issuer identification number is located
			 * within the first six digits a given credit card number
			 *
			 * the substring for the account number is based upon the concept
			 * that the card's account number is located between the 6th and
			 * last digits encluding the 6th and last digits
			 */
			report = "Card Holder: " + this.cardHolderName + "\n"
				   + "Card Number: " + this.cardNumber + "\n"
				   + "Expiration Date: " + this.expirationDate + "\n"
				   + "Is Card Expired? " + this.isCardExpired + "\n"
				   + "Issuer Identification Number: " + this.cardNumber.substring(0, 6) + "\n"
				   + "Card Issuer: " + this.issuer + "\n"
				   + "Account Number: " + this.cardNumber.substring(6, this.cardNumber.length() - 1) + "\n"
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
		/*
		 * Given the expirationDate attribute is required to be in the form of
		 * "MM/YYYY", the if statement below makes sure the string is of length
		 * 7, and uses substrings to extract the expiration month and year to
		 * determine if the given card is expired
		 */
		// making sure user input is in the correct format "MM/YYYY"
		if (this.expirationDate.length() != 7)
		{
			this.isCardExpired = true;
		}
		// checking if card expires in future years
		else if (Integer.parseInt(this.expirationDate.substring(3, 7)) > currentYear)
		{
			this.isCardExpired = false;
		}
		// checking if card expired in future months
		else if(this.expirationDate.length() == 7 &&
			(Integer.parseInt(this.expirationDate.substring(0, 2)) > currentMonth &&
			Integer.parseInt(this.expirationDate.substring(3, 7)) == currentYear))
		{
			this.isCardExpired = false;
		}
        // the card is expired, return true
		else
		{
			this.isCardExpired = true;
		}
	} // END: checkExpirationDate method

	/**
	 * use the Luhn Algorithm, also known as the "mod 10 algorithm",
	 * to validate the credit card number
	 *
	 * <hr>
	 * Date created: Jan 31, 2020
	 *
	 * <hr>
	 */
	private void checkCardNumber()
	{
		// create a variable to hold the sum as required by the algorithm
		int sum = 0;
		boolean isSecondDigit = false;

		// loop through every 2nd integer of the credit card number
		for(int i = this.cardNumber.length() -1 ; i >= 0; i--)
		{
			// use a substring to access every digit
			// int n = Integer.parseInt(this.cardNumber.substring(i, i + 1));
			int n = Character.getNumericValue(this.cardNumber.charAt(i));

			// if the loop is at a second digit, multiply by 2
			if(isSecondDigit)
			{
				n *= 2;

				// if the integer is greater than 9, use the sum of indivudal digits
				if( n > 9 ) n -= 9;
			}

			// add the value of n to the total sum
			sum += n;

			// flip the toggle
			isSecondDigit = !isSecondDigit;
		} // END: looping through every digit and summation

		/*
		 * if the total sum can be evenly divided by 10, the card is valid
		 * if the total sum isn't evenly divisble by 10, the card is invalid
		 */
		if(sum % 10 == 0 && sum > 0)
		{
			this.isCardNumberValid = true;
		}
		/*
		 * no statement is made to set the isCardValid boolean to false because
		 * of the values defined in the default constructor
		 */
	} // END: checkCardNumber method

	/**
	 * use the Major Industry Indentifier to determine the category of the
	 * enitity which issued the card
	 *
	 * <hr>
	 * Date created: Jan 31, 2020
	 *
	 * <hr>
	 */
	private void determineIssuer()
	{
		/*
		 * Checking for American Express
		 *
		 * substrings are used to test for these cases:
		 * 34xxxx and 37xxxx
		 */
		if (this.cardNumber.substring(0, 2).equals("34") ||
			this.cardNumber.substring(0, 2).equals("37"))
		{
			this.issuer = Issuers.AMERICAN_EXPRESS;
		}

		/*
		 * Checking for Discover
		 *
		 * substrings are used to test for these cases:
		 * 6011xx, 644xxx, and 65xxxx
		 */
		else if(this.cardNumber.substring(0, 4).equals("6011") ||
				this.cardNumber.substring(0, 3).equals("644") ||
				this.cardNumber.substring(0, 3).equals("655"))
		{
			this.issuer = Issuers.DISCOVER;
		}

		/*
		 * Checking for MasterCard
		 *
		 * substrings are used to test for these cases:
		 * 51xxxx and 55xxxx
		 */
		else if(this.cardNumber.substring(0, 2).equals("51") ||
			    this.cardNumber.substring(0, 2).equals("55"))
		{
			this.issuer = Issuers.MASTERCARD;
		}

		/*
		 * Checking for VISA
		 *
		 * a substring is used to test for the case: 4xxxxx
		 */
		else if(this.cardNumber.charAt(0) == '4')
		{
			this.issuer = Issuers.VISA;
		}

		// Misc card issuer
		else
		{
			this.issuer = Issuers.OTHER;
		}
	} // END: determnineIssuer method

	/**
	 * use the charAT method and a switch statement to access the card's
	 * major industry identifer and designate the cards accordingly
	 *
	 * <hr>
	 * Date created: Jan 31, 2020
	 *
	 * <hr>
	 */
	private void determineIndustry()
	{
		// use the charAt method to access the MII
		switch(this.cardNumber.charAt(0))
		{
			// MII: 1 or 2 = Airlines Industry
			case 1:
			case 2:
				this.majorIndustry = Industry.AIRLINES;
				break;

			// MII: 3 = Travel Industry
			case 3:
				this.majorIndustry = Industry.TRAVEL;
				break;

			// MII: 4 or 5 = Banking and Financial Industry
			case 4:
			case 5:
				this.majorIndustry = Industry.BANKING_AND_FINANCIAL;
				break;

			// MII: 6 = Merchandising and Banking / Financial Industry
			case 6:
				this.majorIndustry = Industry.MERCHANDISING_BANKING_AND_FINANCIAL;
				break;

			// MII: 7 = Petroleum Industry
			case 7:
				this.majorIndustry = Industry.PETROLEUM;
				break;

			// MII: 8 = Healthcare / Telecommunications Industry
			case 8:
				this.majorIndustry = Industry.HEALTHCARE_OR_TELECOMMUNICATIONS;
				break;

			// MII: 9 = National Assignment Industry
			case 9:
				this.majorIndustry = Industry.NATIONAL_ASSIGNMENT;
				break;
		} // END: switch statement
	} // END: determineIndustry method
} // END: CreditCard class