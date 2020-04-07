/**
 * ---------------------------------------------------------------------------
 * File name: Zombie.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 * Course:  CSCI 1260-288
 * Creation Date: April 6, 2020
 * ---------------------------------------------------------------------------
 */

package zork;

/**
 * represent a Zombie monster
 *
 * <hr>
 * Date created: April 6, 2020
 * <hr>
 *
 * @author Shay Snyder
 */
public class Zombie extends Monster
{
    /**
	 * Initialize the Zombie class
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public Zombie()
    {
        // set the zombie's damage to 3
        super.damage = 3;

        // set the zombie's health to 20
        super.health = 20;

        // set the zombie's type to zombie
        super.type = "Zombie";
    } // END: Zombie no-arg constructor
} // END: Zombie class