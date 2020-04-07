/**
 * ---------------------------------------------------------------------------
 * File name: Cell.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 * Course:  CSCI 1260-288
 * Creation Date: April 6, 2020
 * ---------------------------------------------------------------------------
 */

package zork;

import java.util.ArrayList;

/**
 * TODO Put Class Description Here
 *
 * <hr>
 * Date created: April 6, 2020
 * <hr>
 *
 * @author Shay Snyder
 */
public class Cell
{
    // global variables
    private ArrayList<Wall> walls; // to hold the room's wall
    private Monster enemy; // to hold the room's monster
    private Weapon weapon; // to hold the room's weapon

    /**
	 * TODO Put Method Description Here
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public Cell(CellType type, boolean generateWeapon)
    {
        // TODO Finish Implementation
    } // END: Cell(ArrayList<Wall> walls, boolean generateWeapon) constructor

    /**
	 * TODO Put Method Description Here
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public String showCell()
    {
        // TODO Finish Implementation
    } // END: showCell() method

    /**
	 * TODO Put Method Description Here
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public boolean getHasMonster()
    {
        // TODO Finish Implementation
    } // END: getHasMonster() method

    /**
	 * TODO Put Method Description Here
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public Monster getMonster()
    {
        // TODO Finish Implementation
    } // END: getMonster() method

    /**
	 * TODO Put Method Description Here
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public boolean isMoveAvailable(String move)
    {
        // TODO Finish Implementation
    } // END: isMoveAvailable(String move) method
} // END: Cell class