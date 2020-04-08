/**
 * ---------------------------------------------------------------------------
 * File name: Stick.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 * Course:  CSCI 1260-288
 * Creation Date: April 6, 2020
 * ---------------------------------------------------------------------------
 */

package zork;

/**
 * represent a Stick as a Weapon object
 *
 * <hr>
 * Date created: April 6, 2020
 * <hr>
 *
 * @author Shay Snyder
 */
public class Stick extends Weapon
{
    /**
	 * Initialize the Stick class
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public Stick()
    {
        // set the Stick's damage to 4
        super.damage = 4;

        // set the Stick's title to "Stick"
        super.type = "Stick";
    } // END: Stick() default no-arg constructor
} // END: Laser class