//''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
// Author: Shay Snyder
// Class: Intro to Computer Science 1: 1250.088
// Date of Creation: September 25, 2019
//''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''

/**
 * The purpose this program is to accept an integer from the user and respond
 * with the respective roman numeral counterpart 
 */
import java.util.Scanner; // used to receive user input

// RomanNumerals class *********************************************************
public class RomanNumerals
{
    // Main Method =============================================================
        public static void main(String[] args)
    {
        // creation of class instances ----------------------------------------<
        Scanner keyboard = new Scanner(System.in); // to receive user input
        // END of class instance creation -------------------------------------<



        // variables ----------------------------------------------------------<
        int number; // to hold the integer entered by the user
        String romanNumeral = null; // to hold the roman numeral of the integer
        // END of variables ---------------------------------------------------<



        // ask the user to input an number and assign to "number" -------------<
        System.out.print("Enter an integer: ");
        number = keyboard.nextInt();
        // END of user input --------------------------------------------------<
        


        // Verify the users input ---------------------------------------------<
        // if statement to verify the user's input is between 1 and 10 
        if (number >= 10 || number <= 1)
        {
            if (number >= 10)
            {
                System.out.println("The entered value was too large. " +
                                   "Enter an integer no larger than 10.");
            }
            else if (number <= 1)
            {
                System.out.println("The entered value was too small. " +
                                   "Enter an integer no smaller than 1.");
            }
            else
            {
                System.out.println("An unexpected error has occured. " +
                                   "Please try again.");
            }
        }
        // END of user input verification -------------------------------------<



        // Convert the user's input and show them the results -----------------<
        // Use a switch statement to determine the roman numeral version 
        // of the integer entered by the user
        switch (number)
        {
            case 1:
                romanNumeral = "I";
                break;
            case 2:
                romanNumeral = "II";
                break;
            case 3:
                romanNumeral = "III";
                break;
            case 4:
                romanNumeral = "IV";
                break;
            case 5:
                romanNumeral = "V";
                break;
            case 6:
                romanNumeral = "VI";
                break;
            case 7:
                romanNumeral = "VII";
                break;
            case 8:
                romanNumeral = "VIII";
                break;
            case 9:
                romanNumeral = "IX";
                break;
            case 10:
                romanNumeral = "X";
                break;
        }
        
        // display the roman numeral version of the integer to the cmd line
        System.out.println("Roman Numeral: " + romanNumeral);
        // END of numerical conversions and exportation -----------------------<
    }
    // END of main method ======================================================
}
// END of RomanNumerals class **************************************************