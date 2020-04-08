/**
 * ---------------------------------------------------------------------------
 * File name: Zork.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 * Course:  CSCI 1260-288
 * Creation Date: April 6, 2020
 * ---------------------------------------------------------------------------
 */

package zork;

/**
 * represent the entire entity of a game of Zork
 *
 * <hr>
 * Date created: April 6, 2020
 * <hr>
 * @author Shay Snyder
 */
public class Zork
{
    // global variables
    private Dungeon dungeon; // to hold the game's dungeon

    /**
	 * Start the entire game by building the dungeon
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public Zork()
    {
        dungeon = new Dungeon(); // instantiate the Dungeon class
    } // END: Zork() no-arg constructor

    /**
	 * return a visualization of the game
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public String display()
    {
        /*
         * Use the dungeon's showDungeon() method to return a visualization
         * of the game that shows the map and various information
         */
        return dungeon.showDungeon();
    } // END: Display() method

    /**
	 * return a String object that details the results of the user's
     * previous move
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public String move(String move)
    {
        /*
         * use the dungeon's move() method to return a String that details
         * the results of the user's previous move
         */
        return dungeon.move(move);
    } // END: move() method

    /**
	 * return a boolean attribute specifying if game is over
     *
     * true = game is over
     * false = game is not over
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public boolean isOver()
    {
        /*
         * Return the boolean attribute specifying if the game
         * is over from the Dungeon object
         *
         * true = game is over
         * false = game is not over
         */
        return dungeon.isGameOver();
    } // END: isOver() method
} // END: Zork class