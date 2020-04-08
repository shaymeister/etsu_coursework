/**
 * ---------------------------------------------------------------------------
 * File name: Gun.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 * Course:  CSCI 1260-288
 * Creation Date: April 6, 2020
 * ---------------------------------------------------------------------------
 */

package zork;

/**
 * represent a gun as a weapon
 *
 * <hr>
 * Date created: April 6, 2020
 * <hr>
 *
 * @author Shay Snyder
 */
public class Gun extends Weapon
{
    /**
	 * initialize the Gun class and define
     * the initial value
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public Gun()
    {
        // set the weapons's damage to 7
        super.damage = 7;

        // set the weapon's title to "Gun"
        super.type = "Gun";
    } // END: Gun() default no-arg constructor
} // END: Laser class