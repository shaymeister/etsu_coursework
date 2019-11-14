/*******************************************************************
 * Name: 		Shay Snyder
 * Class: 		CSCI 1250-077
 * Date:		10/31/2019
 *
 * Description:	This program plays a prime number game with the user.
 *              It poses a number and asks the number is prime or not
 *              The user either enters a yes or no answer.
 *              A computer opponent also guesses.  The program then
 *              tells the user if s/he or the computer is correct and
 *              awards one point to each player for a correct answer.
 *******************************************************************/
//Imports
import java.util.Random;
import java.util.Scanner;

public class Project2
{
	public static void main(String[] args) 
	{
		char userAnswer,       //The user's response 
			 computerAnswer,   //The computer's answer
			 actualAnswer;     //Whether the number is prime or not
		int primeNumber,       //The potential prime number
		    userScore = 0,     //The user's score
		    computerScore = 0; //The computer's score
		
		//Scanner for keyboard input and Random for computer answer
		//and potential prime number generation
		Scanner keyboard = new Scanner(System.in);
		
		
		//Banner when the program begins
		System.out.println("**************************\n"
		                 + "Prime Number Guessing Game\n"
		                 + "Y = Yes, N = No, Q = Quit\n"
		                 + "**************************\n");
		
		//Loop until 'Q' user response with quit response
		do
		{
			
			//Generate an integer between 1 and 1000
			primeNumber = generateNumber();  
		
			//Prompt the user for an answer by posing a number
			System.out.print("Is " + primeNumber + " prime? ");
			userAnswer = keyboard.nextLine().toUpperCase().charAt(0);
			
			//Switch on the user's answer
			switch(userAnswer)
			{
				//Break out of loop if 'Q'
				case 'Q':
					System.out.println("Thank you for playing!");
					break;
			    //If the user gives a valid answer...
				case 'Y':
				case 'N':
					//Generate the computer's response (50/50 'Y' or 'N')
					//Print out the computer's answer
					computerAnswer = generateComputerAnswer();
					System.out.println("The computer answers..." + computerAnswer);
					
					// determine if the number is prime
					actualAnswer = isPrime(primeNumber) ? 'Y' : 'N';
					
					//If the actual answer is the same as the user's answer
					//tell her she is correct and increment her score, otherwise
					//tell her she is incorrect
					if(actualAnswer == userAnswer)
					{
						System.out.println("You are correct!");
						userScore++;
					}
					else
					{
						System.out.println("You are incorrect...");
					}
					
					//If the actual answer is the same as the computer's answer
					//tell tell the user that the computer is correct and increment
					//the computer's score, otherwise tell her the computer is 
					//incorrect
					if(actualAnswer == computerAnswer)
					{
						System.out.println("The computer is correct...");
						computerScore++;
					}
					else
					{
						System.out.println("The computer is incorrect!");
					}
					
					//Print the scores
					System.out.println("Your Score: " + userScore + "\n"
					                 + "The Computer's Score: " + computerScore + "\n");
					
					break;
				//The user did not supply a valid response, tell her so and
				//instruct her how to response correctly
				default:
					System.out.println("You did not enter Y, N, or Q!");
					System.out.println("Y = Yes, N = No, Q = Quit");
			}			
			
			System.out.println("");
		
		} while(userAnswer != 'Q');

	}//end main
	
	/**
	 * Using the random class, generate an integer from 0 - 1000
	 * @return int - random generated number from 0 - 1000
	 */
	public static int generateNumber()
	{
		//Create an instance of the Random class
		Random randomNumbers = new Random();

		//Generate a random number from 0 - 1000
		int primeNumber = randomNumbers.nextInt(999) + 1;

		//Returm the random number
		return primeNumber;
	}//end generate number

	/**
	 * Using the random class, generate the computer's answer (y/n)
	 * @return char - 'Y' or 'N'
	 */
	public static char generateComputerAnswer()
	{
		//Create an instance of the Random class
		Random randomNumbers = new Random();

		//Generate the computer's response (50/50 'Y' or 'N')
		char computerAnswer = (randomNumbers.nextDouble() <= 0.5 ? 'N' : 'Y');

		//Return the 'computerAnswer' variable
		return computerAnswer;
	}//end generateComputerAnswer

	/**
	 * Determine the primality of an inputed number
	 * @param primeNumber
	 * @return boolean - primality of the argumented number
	 */
	public static boolean isPrime(int primeNumber)
	{
		//Find if the number is NOT prime by seeing if any
		//positive integer less than it (besides 1) divides
		//it evenly
		boolean flag = true;  
		for(int i = 2; i <  primeNumber; i++) {
		if(primeNumber % i == 0)
		{
			flag = false;
			break;
			}
		}

		//Return the primality
		return flag;  
	}//end isPrime
}//end Project2