/**
 * ---------------------------------------------------------------------------
 * File name: Skeleton.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 * Course:  CSCI 1260-288
 * Creation Date: April 6, 2020
 * ---------------------------------------------------------------------------
 */

package zork;

/**
 * represent a Skeleton monster
 *
 * <hr>
 * Date created: April 6, 2020
 * <hr>
 *
 * @author Shay Snyder
 */
public class Skelton extends Monster
{
    /**
	 * Initialize the Skeleton class
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public Skelton()
    {
        // set the skelton's damage to 5
        super.damage = 5;

        // set the skeleton's health to 20
        super.health = 20;

        // set the skeleton's type to "skelton"
        super.type = "Skelton";
    } // END: Skeleton() default no-arg constructor
} // END: Skeleton class