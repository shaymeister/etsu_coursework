/**
 * ---------------------------------------------------------------------------
 * File name: Sword.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 * Course:  CSCI 1260-288
 * Creation Date: April 6, 2020
 * ---------------------------------------------------------------------------
 */

package zork;

/**
 * represent a sword as a weapon
 *
 * <hr>
 * Date created: April 6, 2020
 * <hr>
 *
 * @author Shay Snyder
 */
public class Sword extends Weapon
{
    /**
	 * initialize the Sword class and define
     * the required attributes
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public Sword()
    {
        // set the weapon's damage to 6
        super.damage = 6;

        // set the weapon's title to "Sword"
        super.type = "Sword";
    } // END: Sword() default no-arg constructor
} // END: Laser class