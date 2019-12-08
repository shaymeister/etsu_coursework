/**
 * -----------------------------------------------------------------------------
 * File name: Player.java
 * Project name: Project4
 *
 * -----------------------------------------------------------------------------
 * Author’s name and email: Shay Snyder
 * Course-Section: CSCI 1250.088
 *
 * Creation Date: December 8, 2918
 * Last modified: (Shay Snyder, 12/08/19, snyderse2@etsu.edu)
 *
 * -----------------------------------------------------------------------------
 */

// Imports
import java.util.Scanner;

/**
 * Class Name: Player <br>
 * Class Purpose: represent a human player within a game of tic-tac-toe <br>
 *
 * <hr>
 * Date created: December 8, 2019 <br>
 * Last modified: Shay Snyder, snyderse2@etsu.edu, 12/08/19
 * @author Shay Snyder
 */
public class Player
{
    char id;

    /**
     * Constructor Name: Player<br>
     * Constructor Purpose: Create a default Player object<br>
     *
     * <hr>
     * Date created: December 8, 2019 <br>
     * Last modified: 12/08/19 <br>
     */
    public Player()
    {
        // Set this player's id to 'O'
        this.id = 'O';
    } // END: Player (no-arg) constructor

    /**
     * Constructor Name: Player <br>
     * Method Purpose: Create a custom Player obect <br>
     *
     * <hr>
     * Date created: December 8, 2019 <br>
     * Last modified: 12/08/19 <br>
     *
     * <hr>
     * @param character a char variable that holds the player's board piece
     */
    public Player(char character)
    {
        // Set this player's id to the argumented value
        this.id = character;
    } // END: Player (arg) constructor

    /**
     * Method Name: setID <br>
     * Method Purpose: mutate the player's id <br>
     *
     * <hr>
     * Date created: December 8, 2019 <br>
     * Last modified: 12/08/19 <br>
     *
     * <hr>
     * @param character a char variable that contains the desired identifier
     * @return void
     */
    public void setId(char character)
    {
        // Set this player's id to the argumented value
        this.id = character;
    } // END: setID method

    /**
     * Method Name: getID <br>
     * Method Purpose: retrieve the player's id <br>
     *
     * <hr>
     * Date created: December 8, 2019 <br>
     * Last modified: 12/08/19 <br>
     *
     * <hr>
     * @return id, the player's custom identifier
     */
    public char getId()
    {
        // return the player's id
        return this.id;
    } // END: getID method

    /**
     * Method Name: move <br>
     * Method Purpose: allow the player to make a move <br>
     *
     * <hr>
     * Date created: December 8, 2019 <br>
     * Last modified: 12/08/19 <br>
     *
     * <hr>
     * @param board a Board object that represents the playing surface
     * @return void
     */
    public void move(Board board)
    {
        // Create an instance of the scanner class
        Scanner keyboard = new Scanner(System.in);

        // Variables
        String move = "flag"; // to hold the player's desired move

        // While an invalid move has been entered, prompt the user to enter another
        while(!board.isMoveAvailable(move))
        {
            // Display the question
            System.out.print("Where would you like to play? ");

            // Get the user's move from the keyboard
            move = keyboard.nextLine();
        } // END: while(!board.isMoveAvailable(move))

        // Submit the player move
        board.submitMove(move, this.id);

        // Display the board to the command line
        board.printBoard();
    } // END: move method
} // END: Player class