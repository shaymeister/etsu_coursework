/**
 * ---------------------------------------------------------------------------
 * File name: Participant.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 * Course:  CSCI 1260-288
 * Creation Date: April 6, 2020
 * ---------------------------------------------------------------------------
 */

package zork;

/**
 * Represent game entities such as players or monsters
 *
 * <hr>
 * Date created: April 6, 2020
 * <hr>
 *
 * @author Shay Snyder
 */
public abstract class Participant
{
    // global variables
    protected int health; // to hold the participant's health
    protected int damage; // to hold the participant's damage capability

    /**
	 * return the participant's health
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public int getHealth()
    {
        // return the participant's health
        return this.health;
    } // END: getHealth() method

    /**
	 * return a boolean attribute specifying if a participant is alive
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public boolean isAlive()
    {
        /*
         * if the participant's health is lower than 0, return true; otherwise,
         * return true
         */
        if(this.health <= 0)
        {
            return true; // return true
        }
        else
        {
            return false; // return false
        } // END: if
    } // END: isAlive() method

    /**
	 * decrease the participant's health by the argumented value
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public void decreaseHealth(int damage)
    {
        // decrease the participant's health by the argumented value
        this.health -= damage;
    } // END: decreaseHealth(int damage) method

    /**
	 * return an integer value that represents this participant's damage
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public abstract int attack();
} // END: Participant class