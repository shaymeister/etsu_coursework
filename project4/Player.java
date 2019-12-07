/**
 * -----------------------------------------------------------------------------
 * File name:
 * Project name:
 *
 * -----------------------------------------------------------------------------
 * Author’s name and email:
 * Course-Section:
 *
 * Creation Date:
 * Last modified: (Name, Date, email)
 *
 * -----------------------------------------------------------------------------
 */

// Imports
import java.util.Scanner;

/**
 * Class Name: class name here <br>
 * Class Purpose: class purpose here <br>
 *
 * <hr>
 * Date created: date here <br>
 * Last modified: name, email, date here
 * @author Author’s name here
 */
public class Player
{
    char id;

    /**
     * Method Name: method name here <br>
     * Method Purpose: method purpose here <br>
     *
     * <hr>
     * Date created: date here <br>
     * Last modified: date here <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     * notes go here
     *
     * <hr>
     *   @param  name of param1 description of param1
     *   @param  name of param2 description of param2, etc.
     *   @return a String containing the data read from the file.
     */
    public Player()
    {
        this.id = 'O';
    }

    /**
     * Method Name: method name here <br>
     * Method Purpose: method purpose here <br>
     *
     * <hr>
     * Date created: date here <br>
     * Last modified: date here <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     * notes go here
     *
     * <hr>
     *   @param  name of param1 description of param1
     *   @param  name of param2 description of param2, etc.
     *   @return a String containing the data read from the file.
     */
    public Player(char character)
    {
        this.id = character;
    }

    /**
     * Method Name: method name here <br>
     * Method Purpose: method purpose here <br>
     *
     * <hr>
     * Date created: date here <br>
     * Last modified: date here <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     * notes go here
     *
     * <hr>
     *   @param  name of param1 description of param1
     *   @param  name of param2 description of param2, etc.
     *   @return a String containing the data read from the file.
     */
    public void setId(char character)
    {
        this.id = character;
    }

    /**
     * Method Name: method name here <br>
     * Method Purpose: method purpose here <br>
     *
     * <hr>
     * Date created: date here <br>
     * Last modified: date here <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     * notes go here
     *
     * <hr>
     *   @param  name of param1 description of param1
     *   @param  name of param2 description of param2, etc.
     *   @return a String containing the data read from the file.
     */
    public char getId()
    {
        return this.id;
    }

    /**
     * Method Name: method name here <br>
     * Method Purpose: method purpose here <br>
     *
     * <hr>
     * Date created: date here <br>
     * Last modified: date here <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     * notes go here
     *
     * <hr>
     *   @param  name of param1 description of param1
     *   @param  name of param2 description of param2, etc.
     *   @return a String containing the data read from the file.
     */
    public void move(Board board)
    {
        String move = "flag";
        Scanner keyboard = new Scanner(System.in);

        while(!board.isMoveAvailable(move))
        {
            System.out.print("Where would you like to play? ");
            move = keyboard.nextLine();
        }

        board.submitMove(move, this.id);
        board.printBoard();
    }
}