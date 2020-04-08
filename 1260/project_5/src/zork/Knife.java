/**
 * ---------------------------------------------------------------------------
 * File name: Knife.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 * Course:  CSCI 1260-288
 * Creation Date: April 6, 2020
 * ---------------------------------------------------------------------------
 */

package zork;

/**
 * represent a knife as a weapon
 *
 * <hr>
 * Date created: April 6, 2020
 * <hr>
 *
 * @author Shay Snyder
 */
public class Knife extends Weapon
{
    /**
	 * initialize the knife class and define
     * the weapon's attributes
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public Knife()
    {
        // set the weapon's damage to 5
        super.damage = 5;

        // set the weapon's title to "Knife"
        super.type = "Knife";
    } // END: Knife() default no-arg constructor
} // END: Laser class