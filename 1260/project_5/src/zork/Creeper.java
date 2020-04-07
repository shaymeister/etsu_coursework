/**
 * ---------------------------------------------------------------------------
 * File name: Creeper.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 * Course:  CSCI 1260-288
 * Creation Date: April 6, 2020
 * ---------------------------------------------------------------------------
 */

package zork;

/**
 * represent a Creeper monster
 *
 * <hr>
 * Date created: April 6, 2020
 * <hr>
 *
 * @author Shay Snyder
 */
public class Creeper extends Monster
{
    /**
	 * Initialize the Creeper class
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public Creeper()
    {
        // set the creeper's damage to 6
        super.damage = 6;

        // set the creeper's health to 20
        super.health = 20;

        // set the creeper's type to "creeper"
        super.type = "Creeper";
    } // END: Creeper no-arg constructor
} // END: Creeper class