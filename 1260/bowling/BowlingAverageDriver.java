/**
 * ---------------------------------------------------------------------------
 * File name: BowlingAverageDriver.java
 * Project name: bowling
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 * Course:  CSCI 1260-288
 * Creation Date: Mar 5, 2020
 * ---------------------------------------------------------------------------
 */

package bowling;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * drive the BowlingAverage & BowlingException class
 *
 * <hr>
 * Date created: Mar 5, 2020
 * <hr>
 * @author Shay Snyder
 */
public class BowlingAverageDriver
{

	/**
	 * allow the user to demonstrate a default BowlingAverage object and other
	 * BowlingAverageObjects created with the parameterized constructor      
	 *
	 * <hr>
	 * Date created: Mar 5, 2020
	 *
	 * <hr>
	 * @param args 
	 */
	public static void main (String [ ] args) throws BowlingException
	{
		// create a BowlingAverage object using the default constructor
		BowlingAverage defBowlingAverage = new BowlingAverage();
		
		// demonstrate the default BowlingAverage object
		System.out.print(defBowlingAverage.toString ( ));
		
		// print a line of dashes to improve visuals and introduce the users
		System.out.print("------------------------------------------------------\n\n");
		
		// create a new Scanner object
		Scanner kb = new Scanner(System.in);
		
		/*
		 * this boolean is used to determine if the
		 * would like to enter more values
		 * true = yes, allow the user to enter more values
		 * 0 = no, end the program
		 */
		boolean repeat = false;
		
		do
		{
			// represent the number of games played by the user
			int numOfGames = -1;
			
			// loop until a valid, positive number of games in entered
			do
			{
				// allow the user to enter the number of games played
				try
				{
					// prompt the user to enter the number of games bowled
					System.out.print ("How many games were bowled? ");
					
					// assign their inputed value to numOfGames
					numOfGames = kb.nextInt ( );	
				}
				// gracefully repeat the process until a valid number is entered
				catch(InputMismatchException e)
				{
					// prompt the user of the error
					System.out.println("\nInvalid Integer Input.\n");
					
					// clear the keyboard buffer
					kb.nextLine ( );
					
				} // END: try/catch
			} while(numOfGames < 0); // END: looping until valid num of games
			
			// print a blank line for better readability
			System.out.println ( );
			
			// create an integer array of the appropriate size
			int[] scores = new int[numOfGames];
			
			// loop through every game asking the user to enter their score
			for (int i = 0; i < scores.length; i++)
			{
				// allow the user to enter their score
				try
				{
					// prompt the user to enter the number of games bowled
					System.out.print ("What was the score for game " + (i + 1) + "? ");
						
					// assign their inputed score to the array
					scores[i] = kb.nextInt ( );	
				}
				// gracefully repeat the process until a valid number is entered
				catch(InputMismatchException e)
				{
					// prompt the user of the error
					System.out.println("\nInvalid Integer Input.\n");
						
					// clear the keyboard buffer
					kb.nextLine ( );
				} // END: try/catch
			} // END: looping through all games
		
			
			// print a blank line for better readability
			System.out.println ( );
			
			// attempt to calculate the average score
			try
			{
				// create a new BowlingAverage object from the user's games
				BowlingAverage avg = new BowlingAverage(scores, numOfGames);
				
				// print the bowling average to the screen
				System.out.println(avg.toString ( ));
			}
			catch(BowlingException e)
			{
				System.out.println("------------------------------------------------------\n"
					              + e.getMessage ( )
								  +"\n------------------------------------------------------\n");
			} // END: attempting to calculate average
			
			// print a line of dashes to improve visuals
			System.out.print("------------------------------------------------------\n\n");
			
			// used to hold the users response to the following question
			String userChoice = null;
			
			// clear the Scanner buffer
			kb.nextLine ( );
			
			// ask the user if they would like to average more scores
			System.out.print("Would you like to enter more scores? ");
			
			/*
			 * allow the user to enter their choice and 
			 * catch any null pointer exceptions
			 */
			try
			{
				userChoice = kb.nextLine();
			}
			catch(NullPointerException e)
			{
				System.out.println("Invalid Input.");
			} // END: catching null pointer exceptions
			
			// if the user enters yes or y
			if(userChoice.toLowerCase().equals("yes") || userChoice.toLowerCase().equals("y"))
			{
				// toggle the repeat to true
				repeat = true;
			} // end of checking if use would like to repeat the program
			
			// add a space for better visuals
			System.out.println();
		} while (repeat); // END: looping until the user has no more scores
		
		// thank the user for using our program
		System.out.print("Thank you for using my program!");
	} // END: main() method
} // END: BowlingAverageDriver class
