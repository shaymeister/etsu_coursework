/**
 * ---------------------------------------------------------------------------
 * File name: WordGame.java
 * Project name: WordGame
 * ---------------------------------------------------------------------------
 * Authors's name and email: Shay Snyder snyderse2@etsu.edu
 * Course-Section: CSCI 1250-088
 * Creation Date: September 14, 2019
 * Last modified: Shay Snyder snyderse2@etsu.ed September 14, 2019
 * ---------------------------------------------------------------------------
 */

// import the scanner class
import java.util.Scanner; // used to receive user input

/**
 * Class Name: WordGame<br>
 * Class Purpose: The main class of the program.  It displays a series of  
 * sentances to the console window that contain user defined variables.
 *
 * <hr>
 * Date created: September 14, 2019<br>
 * Date last modified: September 14, 2019
 * @author Shay Snyder
 */
public class WordGame
{

   /**
    * Method Name: main <br>
    * Method Purpose: The main method. It displays a series of  
    * sentances to the console window that contain user defined variables.<br>
    *
    * <hr>
    * Date created: September 14, 2019<br>
    * Date last modified: September 14, 2019<br>
    *
    * <hr>
    * Notes on specifications, special algorithms, and assumptions: N/A
    *
    * <hr>
    *   @param  args array of Strings (not used in this program)
	*   @returns void 
    */
    public static void main(String[] args) 
    {
        // create an instance of the scanner class
        Scanner keyboard = new Scanner(System.in);

        String name,       // to hold user's name
               city,       // to hold city name
               college,    // to hold college name
               profession, // to hold profession
               animal,     // to hold animal type
               animalName; // to hold pet name
               
        int age;        // to hold the user's age

        // retreive the user's name & assign to "name"
        System.out.println("\nWhat is your name?"); // "\n" makes prompt  
        name = keyboard.nextLine();                 // easier to read
        
        // retrieve the user's age & assign to "age"
        // while checking to make sure their input is of type "int"
        // while statement creation: https://stackoverflow.com/a/13115286
        System.out.println("\nHow old are you?"); // "\n" makes prompt 
        while(!keyboard.hasNextInt())             // easier to read
        {
            keyboard.next();
            System.out.println("Please enter an integer!");
        }//end while scan.hasNextDouble()
        age = keyboard.nextInt();

        // used to clear buffer
        keyboard.nextLine();

        // retrieve a city name from the user & assign to "city"
        System.out.println("\nName a city"); // "\n" makes prompt
        city = keyboard.nextLine();          // easier to read

        // retrieve a college from the user & assign to "college"
        System.out.println("\nName a college"); // "\n" makes prompt 
        college = keyboard.nextLine();          // easier to read

        // retreive a profession from the user & assign to "profession"
        System.out.println("\nName a profession"); // "\n" makes prompt 
        profession = keyboard.nextLine();          // easier to read

        // retreive a type of animal from the user & assign to "animal" 
        System.out.println("\nName a type of animal"); // "\n"  makes prompt
        animal = keyboard.nextLine();                  // easier to read

        // retrieve the user defined pet name
        System.out.println("\nWhat would you name a pet?"); //"\n" makes prompt
        animalName = keyboard.nextLine();                   // easier to read

        // close the scanner object
        keyboard.close();

        // report the output of the Word Game to the command prompt!
        // "\n" makes prompt easier to read
        System.out.println("\nThere once was a person named " + name + " who "+ 
                           "lived in " + city + ". At the age of " + age +
                           ", " + name + " went to college at " + college +
                           ". " + name + " graduated and went to work as a " +
                           profession + ". Then, " + name + " adopted a(n) " +
                           animal + " named " + animalName + ". They both " +
                           "lived happily ever after!");
    } //end main method
} //end WordGame class