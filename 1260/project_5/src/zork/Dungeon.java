/**
 * ---------------------------------------------------------------------------
 * File name: Dungeon.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 * Course:  CSCI 1260-288
 * Creation Date: April 6, 2020
 * ---------------------------------------------------------------------------
 */

package zork;

import java.util.ArrayList;
import java.util.Random;

/**
 * TODO Put Class Description Here
 *
 * <hr>
 * Date created: April 6, 2020
 * <hr>
 *
 * @author Shay Snyder
 */
public class Dungeon
{
    // global variables
    private Player player; // to hold the game's player
    private int numberOfCells; // to hold the number of cells in the dungeon
    private int currentCell; // to hold the current cell
    private ArrayList<Cell> cells; // to hold all cells
    private Random rnd; // to hold a Random object
    private boolean gameOver; // to specify if the game has been completed

    /**
	 * TODO Put Method Description Here
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public Dungeon()
    {
        // create a new player
        player = new Player();

        /*
         * Randomly determine the number of cells to generate
         * min number of cells = 5
         * max number of cells = 5
         */
        numberOfCells =  5 + rnd.nextInt(5);


    } // EMD: Dungeon() constructor

    /**
	 * TODO Put Method Description Here
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public String showDungeon()
    {
        // TODO Finish Implementation
    } // END: showDungeon() method

    /**
	 * TODO Put Method Description Here
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public boolean move(String move)
    {
        // TODO Finish Implementation
    } // END: move(String move) method

    /**
	 * TODO Put Method Description Here
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    private String fight(Monster monster)
    {
        // TODO Finish Implementation
    } // END: fight(Monster monster) method

    /**
	 * TODO Put Method Description Here
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    private void returnToPreviousRoom()
    {
        // TODO Finish Implementation
    } // END: returnToPreviousRoom() method

    /**
	 * TODO Put Method Description Here
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    private void advanceToNextRoom()
    {
        // TODO Finish Implementation
    } // END: advanceToNextRoom() method

    /**
	 * TODO Put Method Description Here
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public boolean isGameOver()
    {
        /*
         * return the 'gameOver' attribute which specifies if a given
         * dungeon has been complete
         *
         * true = game is over
         * fale = game isn't over
         */
        return this.gameOver;
    } // END: isGameOver
} // END: Dungeon class