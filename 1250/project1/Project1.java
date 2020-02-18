/**
 * ------------------------------------------------------------------------------------------------
 * File name: Project1.java
 * Project name: Project1
 * ------------------------------------------------------------------------------------------------
 * Author's name and email: Shay Snyder snyderse2'at'etsu.edu
 * Course-Section: 1250.088
 * Creation Date: September 25, 2019
 * Last Modified: September 25, 2019
 * ------------------------------------------------------------------------------------------------
 */

// Packages
import java.util.Scanner; // to receive input from the user

/**
 * Class Name: Project1 <br>
 * Class Purpose: This class acts as the skeleton of Project1 <br>
 *
 * <br>
 * Date created: September 25, 2019
 * Last Modified: Shay Snyder -  snyderse2'at'etsu.edu - September 25, 2019
 * @author Shay Snyder
 */
public class Project1
{
    /**
     * Method Name: Main <br>
     * Method Purpose: Ties the entire project together given it is the main method
     * The user will be prompted to enter to enter their name and how many hours of tv they watch
     * daily. Given these varaible, the main method will determine the user's initials and calculate
     * the sum of their respective unicode values. Furthermore, main method will calculate the
     * amount of tv the user will watch over x number of years given their daily avg. The output of
     * these calculations will be printed to the cmd line in three units: hours, days, years.<br>
     *
     * <br>
     * Date Created: September 25, 2019 <br>
     * Last Modified: September 25, 2019 <br>
     *
     * <br>
     * Notes:
     * Project1 assumes:
     * - a year consists of exactly 365 days
     * - a day consists of exactly 24 hours
     *
     * Leap years are not accounted for in the program's calculations
     *
     * <br>
     * @param args array of Strings (not used in this program)
     * @return void
     */
    public static void main(String[] args)
    {
        // Create and instance of the Scanner class and assign to "keyboard"
        Scanner keyboard = new Scanner(System.in);

        // Contants
        final double DAYS_PER_YEAR = 365, // holds the number of days per year
                     HOURS_PER_DAY = 24; // holds the number of hours per day

        final int NUM_OF_YEARS = 10; // holds the number of years used for calculations

        final String MY_NAME = "Shay"; // hols the name of the programmer

        // Variables
        String firstName, // to hold the user's first name
               lastName, // to hold the user's last name
               fullName, // to hold the user's full name
               initials; // to hold the user's combined initials

        char firstInitial, // to hold the user's first initial
             secondInitial; // to hold the user's second initial

        double dailyHours, // to hold the average hour of TV per day for the user
               hoursWatched, // hours of TV watched over x number of years given daily avg
               daysWatched, // days of TV watched over x number of years given daily avg
               yearsWatched; // years of TV watched over x number of years given daily avg

        int unicodeSum; // to hold the sumation of the user's initital's unicode

        // Introduce yourself and ask the user for their name and assign to "firstName"
        System.out.print("\n"+
                         "**********************************************************\n" +
                         "Hello, my name is " + MY_NAME + "! What is your name? ");
        firstName = keyboard.nextLine();

        // Ask the user for their last name and assign to "lastName"
        System.out.print("What is your last name? ");
        lastName = keyboard.nextLine();

        // determine the user's full name
        fullName = firstName + " " + lastName;

        // determine the user's initials given their inputs
        firstInitial = firstName.charAt(0);
        secondInitial = lastName.charAt(0);

        // combine the user's initials into one string
        initials = String.valueOf(firstInitial) + String.valueOf(secondInitial);

        // determine the sum of the user's initials' unicode
        unicodeSum = (int) firstInitial + (int) secondInitial;

        // say hello to the user and ask them hour many hours of tv they watch per week
        System.out.print("\n" +
                         "Hello, " + fullName + "(" + initials + ")!\n"+
                         "\n" +
                         "The sum of your name's initials' Unicode values is " + unicodeSum + "\n"+
                         "\n" +
                         "Now tell me, how many hours of TV do you watch per day <on avg>? ");
        dailyHours = keyboard.nextDouble();

        // make sure the entered value of hours is greater than or equal to 0
        if (dailyHours < 0)
        {
            System.out.println("\nThat is not a VALID NUMBER " + fullName);
            System.exit(0);
        }

        // calculate the number of hours of TV watched over x number of years given "dailyHours"
        hoursWatched = dailyHours * DAYS_PER_YEAR * NUM_OF_YEARS;

        // calculate the number of days of TV watched over x number of years given "hoursWatched"
        daysWatched = hoursWatched / HOURS_PER_DAY;

        // calculate the number of years of TV watched over x number of years given "daysWatched"
        yearsWatched = daysWatched / DAYS_PER_YEAR;

        // display the output of calculations to the cmd line
        System.out.print("\n" +
                         "**********************************************************\n" +
                         "\n" +
                         "I bet you didn't realize that in the next " + NUM_OF_YEARS + " years\n" +
                         "you could potentially spend a total of...\n" +
                         "\n" +
                         "\t" + hoursWatched + " hours, or\n" +
                         "\n" +
                         "\t" + daysWatched + " days, or\n" +
                         "\n" +
                         "\t" + yearsWatched + " years watching TV!\n" +
                         "\n" +
                         "That's eye opening isn't it, " + fullName + "!?\n" +
                         "\n" +
                         "**********************************************************\n");
    } // END Main Method
} // END Class Project1
