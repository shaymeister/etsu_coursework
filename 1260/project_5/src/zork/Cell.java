/**
 * ---------------------------------------------------------------------------
 * File name: Cell.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 * Course:  CSCI 1260-288
 * Creation Date: April 6, 2020
 * ---------------------------------------------------------------------------
 */

package zork;

import java.util.Random;

/**
 * represent a cell
 *
 * <hr>
 * Date created: April 6, 2020
 * <hr>
 *
 * @author Shay Snyder
 */
public class Cell
{
    // global variables
    private Random rnd; // to hold the cell's Random object
    private Monster monster; // to hold the cell's monster
    private Weapon weapon; // to hold the cell's weapon
    private Player player; // to hold the game's player
    private CellType type; // to hold the cell's type

    /**
	 * arg-constructor for the Cell class
     *
     * this constructor accepts
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public Cell(CellType type, Player player, Random rnd, boolean generateWeapon, boolean generateMonster)
    {
        // set the Cell's type to the argumented value
        this.type = type;

        // set the Cell's player
        this.player = player;

        // set the Cell's random object
        this.rnd = rnd;

        /*
         * if the argumented 'generateWeapon' attribute is true, randomly
         * generate a weapon and assign it to this cell's 'weapon' attribute
         *
         * if the argumented 'generateWeapon' attribute is false, set this
         * cell's 'weapon' attribute to 'null'
         */
        if (generateWeapon == true)
        {
            // randomly create a weapon, and assign it to this cell's 'weapon'
            this.weapon = createWeapon();
        } // END: if 'generateWeapon' == true
        else
        {
            // set this cell's 'weapon' to null
            this.weapon = null;
        } // END: if 'generateWeapon' == false

        /*
         * if the argumented 'generateMonster' attribute is true, randomly
         * generate a monster and assign it to this cell's 'monster' attribute
         *
         * if the argumented 'generateMonster' attribute is false, set this
         * cell's 'monster' attribute to 'null'
         *
         */
        if (generateMonster == true)
        {
            // randomly create a weapon, and assign it to this cell's 'monster'
            this.monster = createMonster();
        } // END: if 'generateWeapon' == true
        else
        {
            // set this cell's 'monster' to null
            this.monster = null;
        } // END: if 'generateWeapon' == false
    } // END: Cell(ArrayList<Wall> walls, boolean generateWeapon) constructor

    /**
     * randomly create a weapon and return the created weapon
     *
     * <hr>
     * Date created: April 6, 2020
     */
    private Weapon createWeapon()
    {
        // use the Random class to determine which weapon to create
        int choice = rnd.nextInt(5);

        // use a switch to decide which weapon to create
        switch (choice)
        {
            // generate and return a stick
            case 0:
                return new Stick();

            // generate and return a knife
            case 1:
                return new Knife();

            // generate and return a sword
            case 2:
                return new Sword();

            // generate and return a gun
            case 3:
                return new Gun();

            // generate and return a laser
            case 4:
                return new Laser();
        } // END: determining which weapon to generate and return

        // default to return null
        return null;
    } // END: createWeapon() method

    /**
     * randomly determine which monster will be in the cell; then return said
     * monster
     *
     * <hr>
     * Date created: April 6, 2020
     */
    private Monster createMonster()
    {
        // use the Random class to determine which monster to create
        int choice = rnd.nextInt(3);

        // use a switch to decide which monster to create
        switch (choice)
        {
            // generate and return a skelton
            case 0:
                return new Skelton();

            // generate and return a zombie
            case 1:
                return new Zombie();

            // generate and return a creeper
            case 2:
                return new Creeper();
        } // END: determining which monster to create

        // default to return null
        return null;
    } // END: createMonster() method

    /**
     * return a String that represents the Cell and its constants
     *
     * <hr>
     * Date created: April 6, 2020
     */
    public String showCell()
    {
        return " |_" + showPlayer() + "_" + showWeapon() + "_" + showMonster() + "_| ";
    } // END: showCell() method

    /**
     * return a String that represents the Cell's monster
     *
     * <hr>
     * Date created: April 6, 2020
     */
    private String showMonster()
    {
        // if the cell has a monster, return an abbreviation of the monster
        if (this.monster != null)
        {
            // check if the monster is a creeper
            if (this.monster.getType().equals("Creeper"))
            {
                // return an abbreviation of Creeper
                return "Cr";
            } // END: if monster is a creeper

            // check if the monster is a skeleton
            else if (this.monster.getType().equals("Skeleton"))
            {
                // return an abbreviation of Skeleton
                return "Sk";
            } // END: if monster is a skeleton

            // check if the monster is a zombie
            else if (this.monster.getType().equals("Zombie"))
            {
                // return an abbreviation of Zombie
                return "Zo";
            } // END: if monster is a zombie
        } // END: if the cell has the player

        // assuming the cell doesn't have a monster, return "__"
        return "__";
    } // END: showMonster() method

    /**
     * return a String that represents the Cell's weapon
     *
     * <hr>
     * Date created: April 6, 2020
     */
    private String showWeapon()
    {
        // if the cell has a weapon, return an abbreviation of the weapon
        if (this.weapon != null)
        {
            // if the weapon is a stick
            if (this.weapon.getType().equals("Stick"))
            {
                // return "St"
                return "St";
            } // END: if weapon is a stick

            // if the weapon is a sword
            else if (this.weapon.getType().equals("Sword"))
            {
                // return "Sw"
                return "Sw";
            } // END: if weapon is a sword

            // if the weapon is a knife
            else if (this.weapon.getType().equals("Knife"))
            {
                // return "Kn"
                return "Kn";
            } // END: if weapon is a knife

            // if weapon is a laser
            else if (this.weapon.getType().equals("Laser"))
            {
                // return "La"
                return "La";
            } // END: if weapon is a laser

            // if weapon is a gun
            else if (this.weapon.getType().equals("Gun"))
            {
                // return "Gu"
                return "Gu";
            } // END: if weapon is a gun
        } // END: if the cell has a weapon

        // assuming the cell doesn't have a monster, return "__"
        return "__";
    } // END: showWeapon() method

    /**
     * return a String that represents the Cell's player
     *
     * <hr>
     * Date created: April 6, 2020
     */
    private String showPlayer()
    {
        // check if the cell has the player
        if (this.player != null)
        {
            // return "P"
            return "_P";
        } // END: if cell has a weapon

        // if the cell doesn't have the player, return "__"
        return "__";
    } // END: showPlayer() method

    /**
     * return this Cell's player; if the cell doesn't contain the player, this
     * method will return 'null'
     *
     * <hr>
     * Date created: April 6, 2020
     */
    public Player getPlayer()
    {
        // return this Cell's player
        return this.player;
    } // END: getPlayer() method

    /**
	 * add the argumented player to the cell
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public void setPlayer(Player player)
    {
        // add the player to this cell
        this.player = player;
    } // END: setPlayer() method

    /**
	 * return the cell's monster; if the cell doesn't have a monster
     * this method will return null
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public Monster getMonster()
    {
        // return the cell's monster
        return this.monster;
    } // END: getMonster() method

    /**
	 * return a boolean attribute specifying whether the argumented
     * value is valid
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public boolean isMoveAvailable(String move)
    {
        /*
         * This method will do calculations based upon the type of Cell; this
         * first if-statement will be used to determine which calculations
         * are appropriate
         */
        if (this.type == CellType.START) // assuming this cell is the starting cell
        {
            /*
             * Assuming this is the starting cell, the user can only move right
             */
            if (move.equals("right"))
            {
                // assuming the move is valid, return true
                return true;
            } // END: if move correct

            // default: return false
            return false;

        } // END: starting cell
        else if (this.type == CellType.NORMAL) // assuming this cell is a normal cell
        {
            /*
             * Assuming this is a normal cell, the user can move right or left
             */
            if (move.equals("east") || move.equals("west"))
            {
                // assuming the move is valid, return true
                return true;
            } // END: if move is correct

            // default: return false
            return false;
        } // END: normal cell
        else if (this.type == CellType.EXIT) // assuming this cell is the exit cell
        {
            /*
             * Assuming this is the exit cell, the user can only move right
             */
            if (move.equals("west"))
            {
                // assuming the move is valid
                return true;
            } // END: if move correct

            // default: return false
            return false;
        } // END: exit cell

        // default: return false
        return false;
    } // END: isMoveAvailable(String move) method

    /**
	 * equip the player with the weapon in the cell; if the cell doesn't have
     * the player or a weapon, do nothing
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public void equipPlayer()
    {
        // make sure the cell has the player and a weapon
        if (this.player == null || this.weapon == null)
        {
            // simply return
            return;
        } // END: if cell doesn't have required attributes

        // return this cell's weapon
        this.player.changeWeapon(this.weapon);

        // remove the cell's weapon
        this.weapon = null;
    } // END: getWeapon() method

    /**
	 * set the Cell's monster
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public void setMonster(Monster monster)
    {
        // set the Cell's monster
        this.monster = monster;
	} // END: setMonster()
} // END: Cell class