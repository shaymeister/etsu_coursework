/**
 * ---------------------------------------------------------------------------
 * File name: Weapon.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 * Course:  CSCI 1260-288
 * Creation Date: April 6, 2020
 * ---------------------------------------------------------------------------
 */

package zork;

/**
 * represent a general weapon that can
 * be used by a participant
 *
 * <hr>
 * Date created: April 6, 2020
 * <hr>
 * @author Shay Snyder
 */
public class Weapon
{
    // global variables
    protected int damage; // to hold the damage capability of a given weapon
    protected String type; // to hold the type of weapon

    /**
	 * Initialize the Weapon class
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public Weapon()
    {
        // set the weapon's damage to 6
        this.damage = 5;

        // set the weapon's title to "Weapon"
        this.type = "Weapon";
    } // END: Weapon() no-arg constructor

    /**
	 * return an integer value representing the
     * damage dealt due to an attack by a
     * given weapon
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public int attack()
    {
        /*
         * return an integer value representing the
         * damage dealt due to an attack by a
         * given weapon
         */
        return this.damage;
    } // END: attack() method

    /**
	 * return the weapon's type
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public String getType()
    {
        // return the weapon's type
        return this.type;
    } // END: getType() method
} // END: Weapon class