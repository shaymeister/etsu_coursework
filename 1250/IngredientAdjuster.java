/**
 * ---------------------------------------------------------------------------
 * File name: IngredientAdjuster.java
 * Project name: IngredientAdjuster
 * ---------------------------------------------------------------------------
 * Authors's name and email: Shay Snyder snyderse2@etsu.edu
 * Course-Section: CSCI-1250-088
 * Creation Date: September 13, 2019
 * Last modified: Shay Snyder snyderse2@etsu.edu September 13, 2019
 * ---------------------------------------------------------------------------
 */

import java.util.Scanner; // import the Scanner class to retreive user input

/**
 * Class Name: Ingredient Adjustor<br>
 * Class Purpose: The main class of the program.  It will calculate the 
 * required amount of ingredients needed to bake x number of cookies. With x
 * being defined by the user during the execution of the program<br>
 *
 * <hr>
 * Date created: September 13, 2019<br>
 * Date last modified: September 13, 2019
 * @author Shay Snyder
 */
public class IngredientAdjuster
{

       /**
        * Method Name: main <br>
        * Method Purpose: The main method. It will calculate the required 
        * amount of ingredients needed to bake x number of cookies. With x 
        * being defined by the user during the execution of the program <br>
        *
        * <hr>
        * Date created: September 13, 2019<br>
        * Date last modified: September 13, 2019<br>
        *
        * <hr>
        * Notes on specifications, special algorithms, and assumptions: N/A
        *
        * <hr>
        * 
        * @param args array of Strings (not used in this program)
        * @returns void
        */
       public static void main(String[] args)
       {
              double requestedCookies, // holds requested number of cookies
                     neededButter, // holds required ammount of butter (cups)
                     neededFlour, // holds required ammount of flour (cups)
                     neededSugar, // holds required ammount of sugar (cups)
                     ratio; // holds ratio of cookies

              // defining the recipe into the program
       
              /* --------------------------------------------------------------
              * Couldn't make constants "public" & "static" as in the 1250
              * coding standards due to compilation error.
              *
              * Example:
              * public static final double BUTTER = 1,   // # cups of butter
              *                            FLOUR = 2.75, // # cups of flour
              *                            COOKIES = 48, // # of cookies
              *                            SUGAR = 1.5;  // # cups of sugar
              *  --------------------------------------------------------------
              */
              final double BUTTER = 1,   // # cups of butter
                           FLOUR = 2.75, // # cups of flour
                           COOKIES = 48, // # of cookies
                           SUGAR = 1.5;  // # cups of sugar

              String formattedNeededButter, // rounded # cups of butter
                     formattedNeededFlour,  // rounded # cups of flour
                     formattedNeededSugar;  // rounded # cups of sugar

              // create a new instance of the Scanner class
              Scanner keyboard = new Scanner(System.in);

              // ask the user how many cookies they would like to bake
              // while statement creation: https://stackoverflow.com/a/13115286
              Scanner scan = new Scanner(System.in);
              System.out.println("How many cookies would you like to bake?");
              while(!scan.hasNextDouble()) {
                     scan.next();
                     System.out.println("Please enter an integer!");
              }//end while scan.hasNextDouble()
              requestedCookies = scan.nextInt();

              // close the scanner object
              keyboard.close();

              // calculate the ratio of requested cookies to
              // the amount called for in the recipe
              ratio = requestedCookies / COOKIES;

              // calculate the amount of ingredients based on ratio
              neededButter = BUTTER * ratio;
              neededFlour = FLOUR * ratio;
              neededSugar = SUGAR * ratio;

              // round the required ingredients
              // .format() accreditation: https://stackoverflow.com/a/10457088 
              formattedNeededButter = String.format("%.02f", neededButter);
              formattedNeededFlour = String.format("%.02f", neededFlour);
              formattedNeededSugar = String.format("%.02f", neededSugar);

              // print the required ingredients
              // "\n" was added to make prompt easier to read
              System.out.println("\nTo make " + requestedCookies + 
                                 " cookies, you will need:");
              System.out.println(formattedNeededButter + " cups of butter");
              System.out.println(formattedNeededFlour + " cups of flour");
              System.out.println(formattedNeededSugar + " cups of sugar");
       } // end main method
} // end class IngredientAdjuster
