/**
 * ---------------------------------------------------------------------------
 * File name: Hand.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 * Course:  CSCI 1260-288
 * Creation Date: April 6, 2020
 * ---------------------------------------------------------------------------
 */

package zork;

/**
 * represent a hand as a weapon
 *
 * <hr>
 * Date created: April 6, 2020
 * <hr>
 *
 * @author Shay Snyder
 */
public class Hand extends Weapon
{
    /**
	 * initialize the hand class and define
     * the weapon's attributes
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public Hand()
    {
        // set the weapon's damage to 3
        super.damage = 3;

        // set the weapon's type to hand
        super.type = "Hand";
    } // END: Hand() no-arg constructor
} // END: Hand class