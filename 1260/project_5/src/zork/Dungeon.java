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
 * Represent a Zork dungeon, which is a collection of cells
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
    private int numberOfCells; // to hold the number of cells in the dungeon
    private int cellWithWeapon; // to hold the index of the cell with a weapon
    private int currentCell; // to hold the current cell
    private ArrayList<Cell> cells; // to hold all cells
    private Random rnd; // to hold a Random object
    private boolean gameOver; // to specify if the game has been completed

    /**
	 * initialize the Dungeon class
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public Dungeon()
    {

        // Initialize the Random class
        this.rnd = new Random();

        // Set the current cell to 0
        this.currentCell = 0;

        // toggle the gameOver boolean to false
        this.gameOver = false;

        /*
         * Randomly determine the number of cells to generate
         * min number of cells = 5
         * max number of cells = 5
         */
        this.numberOfCells =  5 + rnd.nextInt(5);

        // randomly determine which cell will generate a weapon
        this.cellWithWeapon = 1 + rnd.nextInt(this.numberOfCells - 3);

        /*
         * loop through the desired number of cells, generating a new cell at
         * each iteration
         */
        for(int i = 0; i < this.numberOfCells; i++)
        {
            /*
             * This if statement is checking for the starting cell
             */
            if (i == 0)
            {
                /*
                 * Add a cell to the dungeon that:
                 * is of CellType.START
                 * has the player,
                 * has a Random object
                 * doesn't have a weapon
                 * can't generate a monster
                 */
                cells.add(new Cell(CellType.START, new Player(), rnd, false, false));
            } // END: if generating start cell

            /*
             * This if statement is checking for the cell that the
             * random number generator chose to generate a weapon in
             */
            else if (i == this.cellWithWeapon)
            {
                /*
                 * Add a cell to the dungeon that:
                 * is of CellType.NORMAL
                 * doesn't have a player,
                 * has a Random object
                 * has a weapon
                 * can generate a monster
                 */
                cells.add(new Cell(CellType.NORMAL, null, rnd, true, rnd.nextBoolean()));
            } // END: if generating normal cell with weapon

            /*
             * This is the logic for the last cell
             */
            else if (i == (this.numberOfCells - 1))
            {
                /*
                 * Add a cell to the dungeon that:
                 * is of CellType.EXIT
                 * doesn't have a player,
                 * has a Random object
                 * doesn't have a weapon
                 * can't generate a monster
                 */
                cells.add(new Cell(CellType.EXIT, null, rnd, false, false));
            } // END: if generating last cell

            /*
             * This is the logic for all regular cells
             */
            else
            {
                /*
                 * Add a cell to the dungeon that:
                 * is of CellType.NORMAL
                 * doesn't have a player,
                 * has a Random object
                 * doesn't have a weapon
                 * can generate a monster
                 */
                cells.add(new Cell(CellType.NORMAL, null, rnd, false, rnd.nextBoolean()));
            } // END: if generating normal cell
        } // END: looping throough desired number of cells
    } // EMD: Dungeon() constructor

    /**
	 * return a String object that, when printed, visualizes the game's
     * dungeon and details various attributes about the game
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public String showDungeon()
    {
        /*
         * Create a instance of the StringBuilder class that will be used to
         * build the game's vizualization
         */
        StringBuilder display = new StringBuilder();

        // loop through every cell within the dungeon
        for(int i = 0; i < this.numberOfCells; i++)
        {
            /*
             * at each iteration, add the visualization of said cell to the
             * display
             */
            display.append(cells.get(0).showCell());
        } // END: looping through every cell within the dungeon

        /*
         * add the player's health and the current cell information to the
         * display
         */
        display.append("\n Player Health: " +
                       cells.get(this.currentCell).getPlayer().getHealth() +
                       " points\nCurrent Cell: "
                       + (this.currentCell + 1));

        // return the display
        return display.toString();
    } // END: showDungeon() method

    /**
	 * return a String object that represents the results of the user's desired
     * move
     *
	 * <hr>
	 * Date created: April 6, 2020≠
	 */
    public String move(String move)
    {
        /*
         * Check if the user's desired move is possible; if the move is not
         * available, break away from this method and return a string stating
         * that said move is not available; if the move is available, simply
         * continue through the method
         */
        if (!cells.get(currentCell).isMoveAvailable(move))
        {
            /*
             * Assuming the move is invalid, return a String specifying the
             * status of the user's move
             */
            return "INVALID: The desired move is unavailable. Please try again.";
        } // END: if move isn't available

        /*
         * If the user is move to the previous room, we can simply move them to
         * the room without any extra processing; just move the user the
         * previous room
         */
        if (move.equals("west"))
        {
            // move the player to the previous move
            returnToPreviousRoom();
        } // END: if user wants to move to the previous room

        /*
         * At this point, we can assume the user is wanting to advance to the
         * next room. We will move the player to the next room, check if their
         * is a weapon available for pickup, and check if their is monster in
         * the room.
         */
        advanceToNextRoom(); // advance the player to the next room

        /*
         * check if the user has reached the end of the dungeon; if so, return
         * a String object congradulating the user for winning the game
         */
        if (currentCell == numberOfCells - 1)
        {
            // toggle the isOver boolea
            this.gameOver = true;

            // return a String congradulating the user
            return "Congradulations! You have on the game!";
        } // END: if game is over

        // equip the player with the weapon from the current cell
        cells.get(this.currentCell).equipPlayer();

        // if the new cell has a monster, return the results of the fight
        if (cells.get(this.currentCell).getMonster() != null)
        {
            // assuming the current cell has a monster, return the result of the fight
            return fight(cells.get(this.currentCell));
        } // END: if the cell has a monster

        /*
         * at this point, we can assume that the player simply wants to move
         * east; simple return a String containing the success status of the
         * move
         */
        return "SUCCESS: Move was successful.";
    } // END: move(String move) method


    /**
	 * return a boolean attribute that specifies if a given game is
     * completed
     *
     * true = game is over
     * false = game is not over
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

    /**
	 * use the Random class to determine the outcome of the fight; if the
     * player dies, toggle the 'gameOver' attribute to true
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    private String fight(Cell cell)
    {
        // TODO Finish Implementation
        // get the player from the cell
        Player player = cell.getPlayer();

        // get the monster from the cell
        Monster monster = cell.getMonster();

        // Create a StringBuilder object to hold the outcome of the fight
        StringBuilder fightReport = new StringBuilder();

        // add the first line of the report
        fightReport.append("There is a monster here and the fight begins:\n");

        // loop until either party dies
        while (player.isAlive() && monster.isAlive())
        {
            // Determine if the player hits the monster
            if (rnd.nextInt(100000) > 10000) // Assuming the player hits
            {
                // decrease the monster's health by the player's damage capability
                monster.decreaseHealth(player.attack());

                // determine the monster is no dead
                if(!monster.isAlive())
                {
                    // update the report
                    fightReport.append("The Monster is Dead!");
                } // END: monster is dead
                else
                {
                    // update the report
                    fightReport.append("The Monster was hit: ")
                } // END: monster isn't dead
            } // END: if the player hits the monster
            else // Assuming the player misses
            {

            } // END: player's move

            /*
             * Determine if the monster hits the player
             *
             * The monster has a 80% chance of hitting the player
             */
            if (rnd.nextInt(100000) > 20000) // Assuming the monster hits
            {

            }
            else // Assuming the monster misses
            {

            } // END: monster's move

        } // END: looping until one party dies
    } // END: fight(Monster monster) method

    /**
	 * return the player to the previous cell
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    private void returnToPreviousRoom()
    {
        // make sure the player isn't in the first cell
        if (this.currentCell == 0)
        {
            /*
             * Assuming the player is in the first cell, simply
             * return from this method
             */
            return;
        } // END: error checking

        // get the current cell
        Cell oldCell = cells.get(this.currentCell);

        // get the previous cell
        Cell newCell = cells.get(this.currentCell - 1);

        // get the player from the current cell
        Player player = oldCell.getPlayer();

        // add the player to the next cell
        newCell.setPlayer(player);

        // remove the player from the old cell
        oldCell.setPlayer(null);

        // iterate the currentCell attribute
        this.currentCell--;
    } // END: returnToPreviousRoom() method

    /**
	 * advance the player to the next cell
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    private void advanceToNextRoom()
    {
        // make sure the player isn't in the last cell
        if (this.currentCell == this.numberOfCells - 1)
        {
            /*
             * Assuming the player is in the last cell, simply
             * return from this method
             */
            return;
        } // END: error checking

        // get the current cell
        Cell oldCell = cells.get(this.currentCell);

        // get the next cell
        Cell newCell = cells.get(this.currentCell + 1);

        // get the player from the previous cell
        Player player = oldCell.getPlayer();

        // add the player to the next cell
        newCell.setPlayer(player);

        // remove the player from the old cell
        oldCell.setPlayer(null);

        // iterate the currentCell attribute
        this.currentCell++;
    } // END: advanceToNextRoom() method
} // END: Dungeon class