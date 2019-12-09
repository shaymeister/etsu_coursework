/**
 * -----------------------------------------------------------------------------
 * File name: Board.java
 * Project name: Project4
 *
 * -----------------------------------------------------------------------------
 * Author’s name and email: Shay Snyder snyderse2@etsu.edu
 * Course-Section: CSCI 1250.088
 *
 * Creation Date: December 8, 2019
 * Last modified: (Shay Snyder, 12/08/19, snyderse2@etsu.edu)
 *
 * -----------------------------------------------------------------------------
 */

/**
 * Class Name: Board <br>
 * Class Purpose: build an object that represents the playing surface <br>
 *
 * <hr>
 * Date created: December 8, 2019 <br>
 * Last modified: Shay Snyder, snyderse2@etsu.edu, 12/08/19
 * @author Shay Snyder
 */
public class Board
{
    // Class level variables
    char[][] playingSurface = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};

    /**
     * Method Name: isCat <br>
     * Method Purpose: determine if not possible moves can be made <br>
     *
     * <hr>
     * Date created: December 8. 2019 <br>
     * Last modified: 12/08/19 <br>
     *
     * <hr>
     * @return a boolean representing the cat status of the board
     */
    public boolean isCat()
    {
        // Loop through every slot
        for (int i = 0; i < 3; i++)
        {
            // If any slot on the board is empty, return false
            if (this.playingSurface[0][i] == ' ' || this.playingSurface[i][0] == ' ')
            {
                return false;
            }
        }

        // If all slots are full, return true;
        return true;
    }

    /**
     * Method Name: isWinner <br>
     * Method Purpose: determine if a winning move has been made <br>
     *
     * <hr>
     * Date created: December 8, 2019 <br>
     * Last modified: 12/08/19 <br>
     *
     * <hr>
     * @return a boolean as to the state of a player winning the game
     */
    public boolean isWinner()
    {
        /* Check each column and row for a winner
         * if a win has occured, return true
         */
        for(int i = 0; i <= 2; i++)
        {
            if (this.playingSurface[i][0] == this.playingSurface[i][1] &&
                this.playingSurface[i][0] == this.playingSurface[i][2])
            {
                if (!(this.playingSurface[i][0] == ' '))
                {
                    return true;
                }
            }
            if (this.playingSurface[0][i] == this.playingSurface[1][i] &&
                this.playingSurface[0][i] == this.playingSurface[2][i])
            {
                if (!(this.playingSurface[0][i] == ' '))
                {
                    return true;
                }
            }
        }

        /* check '\' diagonal for winner
         * if a win has occured, return true
         */
        if (this.playingSurface[0][0] == this.playingSurface[1][1] &&
            this.playingSurface[0][0] == this.playingSurface[2][2])
        {
            if (!(this.playingSurface[1][1] == ' '))
            {
                return true;
            }
        }

        /* check '/' diagonal for winner
         * if a win has occured, return true
         */
        if (this.playingSurface[0][2] == this.playingSurface[1][1] &&
            this.playingSurface[0][2] == this.playingSurface[2][0])
        {
            if (!(this.playingSurface[1][1] == ' '))
            {
                return true;
            }
        }

        // else, return false
        return false;
    } // END: isWinner method

    /**
     * Method Name: isMoveValid <br>
     * Method Purpose: determine the validity of the desired move <br>
     *
     * <hr>
     * Date created: November 11, 2019 <br>
     * Last modified: November 11, 2019 <br>
     *
     * <hr>
     * @param move a string containing the desired move
     * @return a boolean refering to the validity of the move
     */
    public boolean isMoveValid(String move)
    {
        // define possible moves
        String[] validMoves = {"A1","A2","A3","B1","B2","B3","C1","C2","C3"};

        // check the desired move by looping through array
        for(String validMove : validMoves)
        {
            // if the desired moves matches an element within the array, return true
            if (move.equals(validMove))
            {
                return true;
            }
        }

        // else, return false
        return false;
    } // END: isMoveValid method

    /**
     * Method Name: isMoveAvailable <br>
     * Method Purpose: determine if a given move is possible <br>
     *
     * <hr>
     * Date created: December 8. 2019 <br>
     * Last modified: December 8, 2019 <br>
     *
     * <hr>
     * @param move a String variable that specifies a player's desired move
     * @return a boolean as to the validity of said move
     */
    public boolean isMoveAvailable(String move)
    {
        if (move.equals("A1") && this.playingSurface[0][0] == ' ')
        {
            return true;
        }
        else if (move.equals("A2") && this.playingSurface[0][1] == ' ')
        {
            return true;
        }
        else if (move.equals("A3") && this.playingSurface[0][2] == ' ')
        {
            return true;
        }
        else if (move.equals("B1") && this.playingSurface[1][0] == ' ')
        {
            return true;
        }
        else if (move.equals("B2") && this.playingSurface[1][1] == ' ')
        {
            return true;
        }
        else if (move.equals("B3") && this.playingSurface[1][2] == ' ')
        {
            return true;
        }
        else if (move.equals("C1") && this.playingSurface[2][0] == ' ')
        {
            return true;
        }
        else if (move.equals("C2") && this.playingSurface[2][1] == ' ')
        {
            return true;
        }
        else if (move.equals("C3") && this.playingSurface[2][2] == ' ')
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Method Name: submitMove <br>
     * Method Purpose: add the argumented move to the board <br>
     *
     * <hr>
     * Date created: November 11, 2019 <br>
     * Last modified: November 11, 2019 <br>
     *
     * <hr>
     * @param move a string containing the desired move
     * @param someId a character that specifies the current player
     */
    public void submitMove(String move, char someId)
    {
        /* Determine if the desired move is even possible
         * Then determine if the move is available
         *
         * if both = true, add the move to the board and return true
         * if either = false, return false
         */
        if (move.equals("A1") && this.playingSurface[0][0] == ' ')
        {
            this.playingSurface[0][0] = someId;
            return;
        }
        else if (move.equals("A2") && this.playingSurface[0][1] == ' ')
        {
            this.playingSurface[0][1] = someId;
            return;
        }
        else if (move.equals("A3") && this.playingSurface[0][2] == ' ')
        {
            this.playingSurface[0][2] = someId;
            return;
        }
        else if (move.equals("B1") && this.playingSurface[1][0] == ' ')
        {
            this.playingSurface[1][0] = someId;
            return;
        }
        else if (move.equals("B2") && this.playingSurface[1][1] == ' ')
        {
            this.playingSurface[1][1] = someId;
            return;
        }
        else if (move.equals("B3") && this.playingSurface[1][2] == ' ')
        {
            this.playingSurface[1][2] = someId;
            return;
        }
        else if (move.equals("C1") && this.playingSurface[2][0] == ' ')
        {
            this.playingSurface[2][0] = someId;
            return;
        }
        else if (move.equals("C2") && this.playingSurface[2][1] == ' ')
        {
            this.playingSurface[2][1] = someId;
            return;
        }
        else if (move.equals("C3") && this.playingSurface[2][2] == ' ')
        {
            this.playingSurface[2][2] = someId;
            return;
        }
        else
        {
            System.out.println("An incorrect move has been submitted.");
            System.exit(0);
        }
    } // END: submitMove method

    /**
     * Method Name: printBoard <br>
     * Method Purpose: display the playing surface on the command line <br>
     *
     * <hr>
     * Date created: November 11, 2019 <br>
     * Last modified: Movember 11, 2019 <br>
     *
     * <hr>
     * @return void
     */
    public void printBoard()
    {
        // Displaying the playing surface via the command line
        System.out.println("\n"
            +"\n\t " + this.playingSurface[0][0] + " | " + this.playingSurface[1][0] + " | " + this.playingSurface[2][0]
            +"\n\t---|---|---"
            +"\n\t " + this.playingSurface[0][1] + " | " + this.playingSurface[1][1] + " | " + this.playingSurface[2][1]
            +"\n\t---|---|---"
            +"\n\t " + this.playingSurface[0][2] + " | " + this.playingSurface[1][2] + " | " + this.playingSurface[2][2]
            +"\n\n");
    }
}