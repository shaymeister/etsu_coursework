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
 * Enter type purpose here
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
	private String checkDigit;
	private String accountNumber;
	private boolean isCardNumberValid;
	private boolean isCardExpired;
	private Brand brand;
	private Industry majorIndustry;



	/**
	 * Constructor
	 *
	 * <hr>
	 * Date created: Jan 31, 2020
	 *
	 *
	 */
	public CreditCard()
	{
		this.cardHolderName = null;
		this.cardNumber = null;
		this.expirationDate = null;
		this.isCardNumberValid = false;
		this.isCardExpired = true;
	}

	/**
	 * Enter method description here
	 *
	 * <hr>
	 * Date created: Jan 31, 2020
	 *
	 * <hr>
	 * @param name
	 */
	public void setCardHolderName(String name)
	{
		this.cardHolderName = name;
	}

	/**
	 * Enter method description here
	 *
	 * <hr>
	 * Date created: Jan 31, 2020
	 *
	 * <hr>
	 * @param number
	 */
	public void setCardNumber(String number)
	{
		this.cardNumber = number;
	}

	/**
	 * Enter method description here
	 *
	 * <hr>
	 * Date created: Jan 31, 2020
	 *
	 * <hr>
	 * @param date
	 */
	public void setExpirationDate(String date)
	{
		this.expirationDate = date;
	}

	/**
	 * Enter method description here
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
		else
		{
			String promptForMissingInfo = "UNKNOWN";

			this.brand = Brand.UNKNOWN;
			this.majorIndustry = Industry.UNKNOWN;
			this.accountNumber = promptForMissingInfo;
			this.checkDigit = promptForMissingInfo;
		}
	}

	/**
	 * Enter method description here
	 *
	 * <hr>
	 * Date created: Jan 31, 2020
	 *
	 * <hr>
	 * @return
	 */
	public String generateReport()
	{
		String prompt;
		if (isCardNumberValid)
		{
			prompt = "---------------------------------------------------------------------------\n"
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
		else
		{
			prompt = "Sorry, the card number is invalid.";
		}
		return prompt;
	}

	/**
	 * Enter method description here
	 *
	 * <hr>
	 * Date created: Jan 31, 2020
	 *
	 * <hr>
	 */
	private void checkExpirationDate()
	{
		if (this.expirationDate.length() == 7 &&
			Integer.parseInt(this.expirationDate.substring(0, 1)) < currentMonth &&
			Integer.parseInt(this.expirationDate.substring(3, 6)) >= currentYear)
		{
			this.isCardExpired = false;
		}
		else
		{
			this.isCardExpired = true;
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
	private void checkCardNumber()
	{

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
		if (this.cardNumber.substring(0, 1) == "34" ||
			this.cardNumber.substring(0, 1) == "37")
		{
			this.brand = Brand.AMERICAN_EXPRESS;
		}

		// Checking for Discover
		else if(this.cardNumber.substring(0, 3) == "6011" ||
				this.cardNumber.substring(0, 2) == "644" ||
				this.cardNumber.substring(0, 1) == "655")
		{
			this.brand = Brand.DISCOVER;
		}

		// Checking for MasterCard
		else if(this.cardNumber.substring(0, 1) == "51" ||
			    this.cardNumber.substring(0, 1) == "55")
		{
			this.brand = Brand.MASTERCARD;
		}

		// Checking for VISA
		else if(this.cardNumber.charAt(0) == 4)
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
