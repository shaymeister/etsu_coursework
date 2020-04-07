/**
 * ---------------------------------------------------------------------------
 * File name: Monster.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 * Course:  CSCI 1260-288
 * Creation Date: April 6, 2020
 * ---------------------------------------------------------------------------
 */

package zork;

/**
 * Represent a monster participant
 *
 * <hr>
 * Date created: April 6, 2020
 * <hr>
 *
 * @author Shay Snyder
 */
public class Monster extends Participant
{
    // global variables
    protected String type; // to define the type of monster

    /**
	 * Initialize the Monster class by creating a new monster
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public Monster()
    {
        // Set the monster's health to 20
        super.health = 20;

        // Set the monster's damage to 4
        super.damage = 4;

        // Set the monster's type to "monster"
        this.type = "Monster";
    } // END: Monster() default constructor

    /**
	 * TODO Put Method Description Here
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public int attack()
    {
        return super.damage;
    } // END: attack() method
} // END: Monster class