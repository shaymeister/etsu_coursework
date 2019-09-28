//''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
// Author: Shay Snyder
// Class: Intro to Computer Science 1 1250.088
// Date of Creation: September 25, 2019
//''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''

/**
 * The goal of this program is to take three runner's names from the user and 
 * the time, in minutes, it took for them to finish the race. Then it will 
 * display the name of the runner who came in first, second, and third
 */

import java.util.Scanner; // used to receive user input

// DecisionStructures class ****************************************************
public class DecisionStructures
{
    // main method =============================================================
    public static void main(String[] args)
    {
        // variables ----------------------------------------------------------<
        String runner1, // to hold the name of runner 1
               runner2, // to hold the name of runner 2
               runner3; // to hold the name of runner 3
        
        double time1, // to hold the time of runner 1
               time2, // to hold the time of runner 2
               time3; // to hold the time of runner 3
        // END variables ------------------------------------------------------<

 

        // class instance creation --------------------------------------------<
        // create an instance of the Scanner class and assign to "keyboard"
        Scanner keyboard = new Scanner(System.in);
        // END class instance creation ----------------------------------------<



        // receive input from the user ----------------------------------------<
        System.out.print("What is the name of the first runner? ");
        runner1 = keyboard.nextLine();

        System.out.print("What was " + runner1 + "'s time in seconds? ");
        time1 = keyboard.nextDouble();

        // used to clear keyboard buffer
        keyboard.nextLine();

        System.out.print("\nWhat is the name of the second runner? ");
        runner2 = keyboard.nextLine();

        System.out.print("What was " + runner2 + "'s time in seconds? ");
        time2 = keyboard.nextDouble();

        // used to clear keyboard buffer
        keyboard.nextLine();

        System.out.print("\nWhat is the name of the third runner? ");
        runner3 = keyboard.nextLine();

        System.out.print("What was " + runner3 + "'s time in seconds? ");
        time3 = keyboard.nextDouble();
        // END of user input --------------------------------------------------<
        


        // determine the order of the runner's, fastest to slowest

        // used to clean up cmd line
        System.out.println("\nIn Conclusion:");

        if (time1 < time2 && time1 < time3) // was runner1 the fastest? 
        {
            // runner one came first
            System.out.println("1st: " + runner1);
            if (time2 < time3) // was runner2 faster than runner3
            {
                System.out.println("2nd: " + runner2); // 2nd = runner2
                System.out.println("3rd: " + runner3); // 3rd = runner3
            }
            else if (time3 < time2) // was runner3 faster than runner2
            {
                System.out.println("2nd: " + runner3); // 2nd = runner3
                System.out.println("3rd: " + runner2); // 3rd = runner2
            }
            else // error catching
            {
                System.out.println("An unexpected error has occured");
            }
        }
        else if (time2 < time1 && time2 < time3) // was runner2 the fastest
        {
            // runner two came first
            System.out.println("1st: " + runner2);
            if (time1 < time3) // was runner1 faster than runner3
            {
                System.out.println("2nd: " + runner1); // 2nd = runner1
                System.out.println("3rd: " + runner3); // 3rd = runner3
            }
            else if (time3 < time1) // was runner3 faster than runner1
            {
                System.out.println("2nd: " + runner3); // 2nd = runner3
                System.out.println("3rd: " + runner1); // 3rd = runner1
            }
            else // error catching
            {
                System.out.println("An unexpected error has occured");
            }
        }
        else if (time3 < time1 && time3 < time3) // was runner3 the fastest
        {
            // runner two came first
            System.out.println("1st: " + runner3);
            if (time2 < time1) // was runner2 faster than runner1
            {
                System.out.println("2nd: " + runner2);
                System.out.println("3rd: " + runner1);
            }
            else if (time1 < time2) // was runner1 faster than runner2
            {
                System.out.println("2nd: " + runner1);
                System.out.println("3rd: " + runner2);
            }
            else // error cqtching
            {
                System.out.println("An unexpected error has occured");
            }
        }
    }
    // END main method =========================================================
}
// End DecisionStructures class ************************************************

