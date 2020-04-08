/**
 * ---------------------------------------------------------------------------
 * File name: Laser.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 * Course:  CSCI 1260-288
 * Creation Date: April 6, 2020
 * ---------------------------------------------------------------------------
 */

package zork;

/**
 * represemt a laser as a weapon
 *
 * <hr>
 * Date created: April 6, 2020
 * <hr>
 *
 * @author Shay Snyder
 */
public class Laser extends Weapon
{
    /**
	 * initialize the laser class and define
     * the required attributes
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public Laser()
    {
        // set the weapon's damage to 8
        super.damage = 8;

        // set the weapon's title to "Laser"
        super.type = "Laser";
    } // END: Laser() default no-arg constructor
} // END: Laser class