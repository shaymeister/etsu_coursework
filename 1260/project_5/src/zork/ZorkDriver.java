/**
 * ---------------------------------------------------------------------------
 * File name: ZorkDriver.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 * Course:  CSCI 1260-288
 * Creation Date: April 6, 2020
 * ---------------------------------------------------------------------------
 */

package zork;

import javax.swing.JOptionPane;

/**
 * Drive Project 5: Zork through JOptionPane
 *
 * <hr>
 * Date created: April 6, 2020
 * <hr>
 * @author Shay Snyder
 */
public class ZorkDriver
{
    /**
	 * Serve as the backbone for the rest of the program
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public static void main(String[] args)
    {
        // introduce the user
        intro();

        // start the game
        startGame();

        // roll the outro
        outro();
    } // END: main() method

    /**
	 * Introduce the user to Zork
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    private static void intro()
    {
        // use JOptionPane to welcome the user to the game
        JOptionPane.showMessageDialog(null,
                        "Welcome to my Zork game!",
                        "Zork",
                        JOptionPane.INFORMATION_MESSAGE);
    } // END: intro() method

    /**
	 * TODO Put Method Description Here
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    private static void startGame()
    {
        // create a new instance of the game
        Zork game = new Zork();
    } // END: startGame() method

    /**
	 * TODO Put Method Description Here
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    private static void outro()
    {
        // TODO Finish Implementation
    } // END: outro() method
} // END: ZorkDriver class