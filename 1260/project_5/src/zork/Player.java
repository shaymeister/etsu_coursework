/**
 * ---------------------------------------------------------------------------
 * File name: Player.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 * Course:  CSCI 1260-288
 * Creation Date: April 6, 2020
 * ---------------------------------------------------------------------------
 */

package zork;

/**
 * represent the player of the game
 *
 * <hr>
 * Date created: April 6, 2020
 * <hr>
 * @author Shay Snyder
 */
public class Player extends Participant
{
    // global variables
    private Weapon weapon; // to hold the player's weapon

    /**
	 * Initialize the Player class
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public Player()
    {
        super();

        // set the player's health to 100
        this.health = 100;

        // set the player's weapon to their hand
        this.weapon = new Hand();
    } // END: Player() no-arg constructor

    /**
	 * change the player's weapon via the argued value
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public void changeWeapon(Weapon newWeapon)
    {
        // set the player's weapon to the new weapon
        this.weapon = newWeapon;
    } // END: changeWeapon() method

    /**
	 * return an integer value representing the damage
     * dealt by the player's weapon
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public int attack()
    {
        /*
         * return an integer value representing the damage dealt by
         * the player's weapon
         */
        return this.weapon.attack();
    } // END: attack() method

    /**
	 * return a String representing the player's current weapon
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public String getWeaponTitle()
    {
		return this.weapon.getType(); // return the player's weapon type
	} // END: getWeaponTitle() method
} // END: Player class