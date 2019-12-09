/**
 * -----------------------------------------------------------------------------
 * File name: Computer.java
 * Project name: Project4
 *
 * -----------------------------------------------------------------------------
 * Author’s name and email: Shay Snyder snyderse2@etsu.edu
 * Course-Section: CSCI 1250.088
 *
 * Creation Date: December 7, 2019
 * Last modified: (Shay Snyder, 12/07/19, snyderse2@etsu.edu)
 *
 * -----------------------------------------------------------------------------
 */

// Imports
import java.util.Random;

/**
 * Class Name: Computer <br>
 * Class Purpose: act as the blueprint for a computer player in tic-tac-toe <br>
 *
 * <hr>
 * Date created: December 07, 2019 <br>
 * Last modified: Shay Snyder, snyderse2@etsu.edu, 12/07/19
 * @author Shay Snyder
 */
public class Computer
{
    // Global Variables
    char id;

    /**
     * Method Name: Computer <br>
     * Method Purpose: act as the default constructor for the computer class <br>
     *
     * <hr>
     * Date created: December 07, 2019 <br>
     * Last modified: 12/07/19 <br>
     */
    public Computer()
    {
        // Set this object's idenifier to X
        this.id = 'X';
    } // END: Computer (no-arg) constructor

    /**
     * Method Name: Computer <br>
     * Method Purpose: create a computer object with some argumented value <br>
     *
     * <hr>
     * Date created: December 7, 2019 <br>
     * Last modified: 12/07/19 <br>
     *
     * <hr>
     * @param someChar a char variable that contains the desired identifier
     */
    public Computer(char someChar)
    {
        // assign this computer object's idenifier to the specified value
        this.id = someChar;
    } // END: Computer (arg) constructor

    /**
     * Method Name: setID <br>
     * Method Purpose: mutate the given object's identifier <br>
     *
     * <hr>
     * Date created: December 7, 2019 <br>
     * Last modified: 12/07/19 <br>
     *
     * <hr>
     * @param someId a char variable that contains the desired idenifier
     * @return void
     */
    public void setId(char someId)
    {
        // set this objects idenifier to the argumented value
        this.id = someId;
    } // END: setId method

    /**
     * Method Name: move <br>
     * Method Purpose: allow the computer to make a move <br>
     *
     * <hr>
     * Date created: December 7, 2019 <br>
     * Last modified: 12/07/19 <br>
     *
     * <hr>
     * @param someBoard a Board object that represents the playing surface
     * @param round an int variable that represents game progression
     * @return void
     */
    public void move(Board someBoard, int round)
    {
        // Variables
        String move = "noMoveAvailable";

        // Repeat until a move has been determined
        do
        {
            if (move.equals("noMoveAvailable"))
            {
                move = checkForWinningMove(someBoard);
            }

            if (move.equals("noMoveAvailable"))
            {
                move = checkForDefensiveMove(someBoard);
            }

            if (move.equals("noMoveAvailable"))
            {
                move = checkForStrategicMove(someBoard, round);
            }

            if (move.equals("noMoveAvailable"))
            {
                move = generateRandomMove(someBoard);
            }

        } while (!someBoard.isMoveAvailable(move));

        // tell the user where the computer has decided to play
        System.out.println("The computer has chosen to play in slot " + move);

        // submit said move to the playing surface
        someBoard.submitMove(move, this.id);

        // display said surface to the command line
        someBoard.printBoard();
    } // END: move method

    /**
     * Method Name: checkForWinning <br>
     * Method Purpose: allow the computer to determine if a fatal move can be made <br>
     *
     * <hr>
     * Date created: December 7, 2019 <br>
     * Last modified: 12/07/19 <br>
     *
     * <hr>
     * @param someBoard a Board object that represents the playing surface
     * @return a String containing the computer's move
     */
    public String checkForWinningMove(Board someBoard)
    {
        // Variables
        char[][] board = someBoard.playingSurface;

        // Compensate for different indentifers
        char computer = 'X',
             opponent = 'O';

        if (this.id == 'O')
        {
            computer = 'O';
            opponent = 'X';
        }

        // Loop through every row and column, checking for winning moves
        for(int i = 0; i <= 2; i++)
        {
            // Check if said column is available to conquer
            if (board[i][0] != opponent && board[i][1] != opponent && board[i][2] != opponent)
            {
                /* Check if this computer has occupied the first two slots in said column
                 * if so, play in the last slot
                 */
                if (board[i][0] == computer && board[i][1] == computer)
                {
                    // Determine which column to play into
                    if (i == 0)
                    {
                        // column 1, last slot
                        return "A3";
                    }
                    else if (i == 1)
                    {
                        // column 2, last slot
                        return "B3";
                    }
                    else if (i == 2)
                    {
                        // column 3, last slot
                        return "C3";
                    }
                } // END: if first two slots are occupied by computer

                /* Check if this computer has occupied the last two slots in said column
                 * if so, play in the first slot
                 */
                else if (board[i][1] == computer && board[i][2] == computer)
                {
                    // determine which column to play into
                    if (i == 0)
                    {
                        // column 1, first slot
                        return "A1";
                    }
                    else if (i == 1)
                    {
                        // column 2, first slot
                        return "B1";
                    }
                    else if (i == 2)
                    {
                        // column 3, first slot
                        return "C1";
                    }
                } // END: if the last two slots are occupied by computer

                /* Check if this computer has occupied the outer two slots in said column
                 * if so, play in the middle slot
                 */
                else if(board[i][0] == 'X' && board[i][2] == computer)
                {
                    // determine which column to play into
                    if (i == 0)
                    {
                        // column 1, middle slot
                        return "A2";
                    }
                    else if (i == 1)
                    {
                        // column 2, middle slot
                        return "B2";
                    }
                    else if (i == 2)
                    {
                        // column 3, middle slot
                        return "C2";
                    }
                } // END: if the outer two slots are occupied by computer
            } // END: looping through columns for winning move

            // Check if said row is available to conquer
            if (board[0][i] != opponent && board[1][i] != opponent && board[2][i] != opponent)
            {
                /* Check if the computer has occupied the first two slots in said row
                 * if so, play in the last slot
                 */
                if(board[0][i] == computer && board[1][i] == computer)
                {
                    // Determine which row to play into
                    if (i == 0)
                    {
                        // row 1, last slot
                        return "C1";
                    }
                    else if (i == 1)
                    {
                        // row 2, last slot
                        return "C2";
                    }
                    else if (i == 2)
                    {
                        // row 3, last slot
                        return "C3";
                    }
                } // END: if first two slots are occupied by the computer

                /* Check if the computer has occupied the last two slots in said row
                 * if so, play in the first slot
                 */
                else if(board[1][i] == computer && board[2][i] == computer)
                {
                    // determine which row to play into
                    if (i == 0)
                    {
                        // row 1, first slot
                        return "A1";
                    }
                    else if (i == 1)
                    {
                        // row 2, first slot
                        return "A2";
                    }
                    else if (i == 2)
                    {
                        // row 3, first slot
                        return "A3";
                    }
                } // END: if the last two slots are occupied by the user

                /* Check if the computer has occupied the outer two slots in said row
                 * if so, play in the middle slot
                 */
                else if(board[0][i] == computer && board[2][i] == computer)
                {
                    // determine which row to play into
                    if (i == 0)
                    {
                        // row 1, middle slot
                        return "B1";
                    }
                    else if (i == 1)
                    {
                        // row 2, middle slot
                        return "B2";
                    }
                    else if (i == 2)
                    {
                        // row 3, middle slot
                        return "B3";
                    }
                } // END: if outer two slots are occupied by the computer
            } // END: looping through rows for winning move
        } // END: looping through all rows and columns for winning move

        // check '\' diagonal for winning move
        if(board[0][0] != opponent && board[1][1] != opponent && board[2][2] != opponent)
        {
            // check if the first two slots are occupied by the computer
            if (board[0][0] == computer && board[1][1] == computer)
            {
                // column 3, last slot
                return "C3";
            }

            // check if the outer two slots are occupied by the computer
            else if (board[0][0] == computer && board[2][2] == computer)
            {
                // column 2, middle slot
                return "B2";
            }

            // check if last two slots are occupied by the computer
            else if (board[2][2] == computer && board[1][1] == computer)
            {
                // column 1, first slot
                return "A1";
            }
        } // END: checking for '\' diagonal winning moves

        // check '/' diagonal for winning move
        if(board[2][0] != opponent && board[1][1] != opponent && board[0][2] != opponent)
        {
            // check if the last two slots are occopied by the computer
            if (board[2][0] == computer && board[1][1] == computer)
            {
                // column 1, last slot
                return "A3";
            }

            // check if the outer two slots are occupied by th
            else if (board[2][0] == computer && board[0][2] == computer)
            {
                // column 2, middle slot
                return "B2";
            }

            // check if the first two slots are occupied by the computer
            else if (board[0][2] == computer && board[1][1] == computer)
            {
                // column 3, first slot
                return "C1";
            }
        } // END: checking for '\' diagonal winning moves


        return "noMoveAvailable";
    } // END: checkForWinningMove method

    /**
     * Method Name: checkForDefensiveMove <br>
     * Method Purpose: allow the computer to determine if a defensive move can be made <br>
     *
     * <hr>
     * Date created: December 7, 2019 <br>
     * Last modified: 12/07/19 <br>
     *
     * <hr>
     * @param someBoard a Board object that represents the playing surface
     * @return a String containing the computer's move
     */
    public String checkForDefensiveMove(Board someBoard)
    {
        // Variables
        char[][] board = someBoard.playingSurface;

        // Compensate for differing idenifiers
        char computer = 'X',
             opponent = 'O';

        if (this.id == 'O')
        {
            computer = 'O';
            opponent = 'X';
        }

        // Loop through every row and column, checking for defensive moves
        for(int i = 0; i <= 2; i++)
        {
            // check if opponent has the chance to win in said column
            if (board[i][0] != computer && board[i][1] != computer && board[i][2] != computer)
            {
                // check if the opponent has occupied the first two slots
                if(board[i][0] == opponent && board[i][1] == opponent)
                {
                    // determine which column to play into
                    if (i == 0)
                    {
                        // column 1, last slot
                        return "A3";
                    }
                    else if (i == 1)
                    {
                        // column 2, last slot
                        return "B3";
                    }
                    else if (i == 2)
                    {
                        // column 3, last slot
                        return "C3";
                    }
                } // END: checking for defensive moves in last row

                // check if the opponent has occupied the outer two slots
                else if(board[i][0] == opponent && board[i][2] == opponent)
                {
                    // determine which column tp play into
                    if (i == 0)
                    {
                        // column 1, slot 2
                        return "A2";
                    }
                    else if (i == 1)
                    {
                        // column 2, slot 2
                        return "B2";
                    }
                    else if (i == 2)
                    {
                        // column 3, slot 2
                        return "C2";
                    }
                } // END: checking for defensive moves in middle row

                // check if the opponent has occupied the last to slots
                else if(board[i][1] == opponent && board[i][2] == opponent)
                {
                    // determine which column to play into
                    if (i == 0)
                    {
                        // column 1, slot 1
                        return "A1";
                    }
                    else if (i == 1)
                    {
                        // column 2, slot 1
                        return "B1";
                    }
                    else if (i == 2)
                    {
                        // column 3, slot 1
                        return "C1";
                    }
                } // END: checking for defensive moves in first row
            } // END: checking columns for winning moves

            // check if the opponent has the chance to win in said row
            if (board[0][i] != computer && board[1][i] != computer && board[2][i] != computer)
            {
                // check if the first two slots have been occupied by the opponent
                if(board[0][i] == opponent && board[1][i] == opponent)
                {
                    // determine which row to play into
                    if (i == 0)
                    {
                        // row 1, last column
                        return "C1";
                    }
                    else if (i == 1)
                    {
                        // row 2, last column
                        return "C2";
                    }
                    else if (i == 2)
                    {
                        // row 3, last column
                        return "C3";
                    }
                } // END: checking for defensive moves in last column

                // check if the two outer slots have been occupied by the opponent
                else if(board[0][i] == opponent && board[2][i] == opponent)
                {
                    // determine which row to play into
                    if (i == 0)
                    {
                        // column 2, slot 1
                        return "B1";
                    }
                    else if (i == 1)
                    {
                        // column 2, slot 2
                        return "B2";
                    }
                    else if (i == 2)
                    {
                        // column 2, slot 3
                        return "B3";
                    }
                } // END: checking for defensive moves in middle column

                // check if the last two slots have been occupied by the opponent
                else if(board[1][i] == opponent && board[2][i] == opponent)
                {
                    // determine which row to play into
                    if (i == 0)
                    {
                        // column 1, slot 1
                        return "A1";
                    }
                    else if (i == 1)
                    {
                        // column 1, slot 2
                        return "A2";
                    }
                    else if (i == 2)
                    {
                        // column 1, slot 3
                        return "A3";
                    }
                } // END: checking for defensive moves in last column
            } // END: checking for defensive moves in rows
        } // END: checking for defensive moves in all columns and rows

        // check the '\' diagonal for a potential loss
        if(board[0][0] != computer && board[1][1] != computer && board[2][2] != computer)
        {
            // check if the first two slots are occupied by the opponent
            if (board[0][0] == opponent && board[1][1] == opponent)
            {
                // column 3, slot 3
                return "C3";
            }

            // check if the two outer slots are occupied by the opponent
            else if (board[0][0] == opponent && board[2][2] == opponent)
            {
                // column 2, slot 2
                return "B2";
            }

            // check if the last two slots are occupied by the opponent
            else if (board[2][2] == opponent && board[1][1] == opponent)
            {
                // column 1, slot 1
                return "A1";
            }
        } // END: checking for potential loss in the '\' diagonal

        // check the '/' diagonal for a potential loss
        if(board[2][0] != computer && board[1][1] != computer && board[0][2] != computer)
        {
            // check if the first two slots are occupied by the opponent
            if (board[2][0] == opponent && board[1][1] == opponent)
            {
                // column 1, slot 3
                return "A3";
            }

            // check if the outer two slots are occupied by the opponent
            else if (board[2][0] == opponent && board[0][2] == opponent)
            {
                // column 2, slot 2
                return "B2";
            }

            // check if th last two slots are occupied by the opponent
            else if (board[0][2] == opponent && board[1][1] == opponent)
            {
                // column 3, slot 1
                return "C1";
            }
        } // END: checking for potential loss in the '\' diagonal

        return "noMoveAvailable";
    } // END: checkForDefensiveMove method

    /**
     * Method Name: checkForStrategicMove <br>
     * Method Purpose: allow the computer to determine if a strategic move can be made <br>
     *
     * <hr>
     * Date created: December 7, 2019 <br>
     * Last modified: 12/07/19 <br>
     *
     * <hr>
     * @param someBoard a Board object that represents the playing surface
     * @return a String containing the computer's move
     */
    public String checkForStrategicMove(Board someBoard, int round)
    {
        // Variables
        char[][] board = someBoard.playingSurface;

        // Compensate for differing identifiers
        char computer = 'X',
             opponent = 'O';

        if (this.id == 'O')
        {
            computer = 'O';
            opponent = 'X';
        }

        // this switch is used when there are no available winning or defensive moves available
        switch(round)
        {
            // round 1
            case 1:
            {
                // play in column 1, slot 1
                return "A1";
            }

            // round 2
            case 2:
            {
                /* check if the opponent has played in the middle position
                 * if true: column 1, slot 1
                 * if false: column 1, slot 2
                 */
                if (board[1][1] == opponent)
                {
                    return "A1";
                }
                else
                {
                    return "B2";
                }
            }

            // round 3
            case 3:
            {
                // check if the opponent has played in the middle position
                if(board[1][1] == opponent)
                {
                    // play in column 3, slot 3
                    return "C3";
                }

                // check if the last two slots are available in the first column
                else if(board[0][1] == ' ' && board[0][2] == ' ')
                {
                    // play in column 1, slot 3
                    return "A3";
                }

                // check if the last two slots are available in the first row
                else if(board[1][0] == ' ' && board[2][0] == ' ')
                {
                    // play in column 3, slot 1
                    return "C1";
                }

                // break out of the switch
                break;
            }

            // round 4
            case 4:
            {
                /* check if:
                 * the use user has played in either of the leftmost corners &&
                 * if the computer has played in the middle
                 */
                if((board[0][0] == opponent || board[0][2] == opponent) && board[1][1] == computer)
                {
                    // play in column 1, slot 2
                    return "A2";
                }

                /* check if:
                 * the use user has played in either of the right corners &&
                 * if the computer has played in the middle
                 */
                if((board[2][0] == opponent || board[2][2] == opponent) && board[1][1] == computer)
                {
                    // play in column 3, slot 2
                    return "C2";
                }

                // break away from the switch
                break;
            }

            // rounds 5 & 6
            case 5:
            case 6:
            {
                // Check if the user has played in any of the last two slots in row 1 and column 3
                if(board[1][0] != opponent && board[2][0] != opponent && board[2][1] != opponent && board[2][2] != opponent)
                {
                    /* Check if the computer has previously gone in the second column, row 2
                     * if true: column 3, slot 3
                     * if false: column 3, slot 1
                     */
                    if (board[2][0] == computer)
                    {
                        return "C3";
                    }
                    else
                    {
                        return "C1";
                    }
                }

                // Check if the opponent has played in any of the last two slots in column 1 and row 3
                else if(board[0][1] != opponent && board[0][2] != opponent && board[1][2] != opponent && board[2][2] != opponent)
                {
                    /* Check if the computer has previously gone in the first column, row 3
                     * if true: column 3, slot 3
                     * if false: column 1, slot 3
                     */
                    if (board[0][2] == computer)
                    {
                        return "C3";
                    }
                    else
                    {
                        return "A3";
                    }
                }

                // check if the middle slot in empty
                else if(board[1][1] == ' ')
                {
                    // column 2, slot 2
                    return "B2";
                }

                // break away from the switch
                break;
            }

            // round 7
            case 7:
            {
                // check if the computer has a winning chance via the first row
                if (board[1][0] != opponent && board[2][0] != opponent)
                {
                    // check which slot in which the computer has already played
                    if(board[1][0] == computer)
                    {
                        // column 3, slot 1
                        return "C1";

                    }
                    else if(board[2][0] == computer)
                    {
                        // column 2, slot 1
                        return "B1";
                    }
                }

                // check if the computer has a winning chance via the first column
                else if (board[0][1] != opponent && board[0][2] != opponent)
                {
                    // check which slot in which the computer has already played
                    if (board[0][1] == computer)
                    {
                        // column 1, slot 3
                        return "A3";
                    }
                    else if (board[0][2] == computer)
                    {
                        // column 1, slot 2
                        return "A2";
                    }
                }

                // check if the computer has a winning chance via row 3
                else if (board[0][2] != computer && board[1][2] != opponent && board[2][2] != opponent)
                {
                    // column 2, slot 3
                    return "B3";
                }

                // check if the computer has a winning chance column 3
                else if (board[2][0] != computer && board[2][1] != opponent && board[2][2] != opponent)
                {
                    // column 3, slot 2
                    return "C2";
                }

                // check if the computer has a winning chance via the '/' diagonal
                else if (board[0][2] != opponent && board[1][1] != opponent && board[2][0] != opponent)
                {
                    // check if the computer has occupied the first two slots
                    if(board[0][2] == computer && board[1][1] == computer)
                    {
                        // column 1, slot 1
                        return "C1";
                    }

                    // check if the computer has occupied the two outer slots
                    else if(board[0][2] == computer && board[1][1] == computer)
                    {
                        // column 2, slot 2
                        return "B2";
                    }

                    // check if the computer has occupied the last two slots
                    else if(board[2][0] == computer && board[1][1] == computer)
                    {
                        // column 1, slot 3
                        return "A3";
                    }
                }

                // check if the computer has a winning chance via the '\' diagonal
                else if (board[1][1] != opponent && board[2][2] != opponent)
                {
                    /* assuming the computer has occupied the first slot,
                     * check if the computer has occupied the middle slot
                     */
                    if (board[1][1] == computer)
                    {
                        // column 3, slot 3
                        return "C3";
                    }

                    /* assuming the computer has occupied the first slot,
                     * check if the computer has occupied the last slot
                     */
                    else if (board[2][2] == computer)
                    {
                        // column 2, slot 2
                        return "B2";
                    }
                }

                // break away from the switch
                break;
            }
        }
        return "noMoveAvailable";
    } // END: checkForStrategicMove method

    /**
     * Method Name: generateRandomMove <br>
     * Method Purpose: allow the computer to randomly play <br>
     *
     * <hr>
     * Date created: December 7, 2019 <br>
     * Last modified: 12/07/19 <br>
     *
     * <hr>
     * @param someBoard a Board object that represents the playing surface
     * @return a String containing the computer's move
     */
    public String generateRandomMove(Board someboard)
    {
        // Class Instances
        Random random = new Random();

        // Variables
        String move = "flag";

        // Randomly generate a move until said move is playable
        do
        {
            // randomly generate a number from 0-8
            int randomNumber = random.nextInt(9);

            // covert the random number into an actual move
            switch(randomNumber)
            {
                // random number = 0
                case 0:
                {
                    // column 1, slot 1
                    move = "A1";
                }

                // random number = 1
                case 1:
                {
                    // column 1, slot 2
                    move = "A2";
                }

                // random number = 2
                case 2:
                {
                    // column 1, slot 3
                    move = "A3";
                }

                // random number = 3
                case 3:
                {
                    // column 2, slot 1
                    move = "B1";
                }

                // random number = 4
                case 4:
                {
                    // column 2, slot 2
                    move = "B2";
                }

                // random number = 5
                case 5:
                {
                    // column 2, slot 3
                    move = "B3";
                }

                // random number = 6
                case 6:
                {
                    // column 3, slot 1
                    move = "C1";
                }

                // random number = 7
                case 7:
                {
                    // column 3, slot 2
                    move = "C2";
                }

                // random number = 8
                case 8:
                {
                    // column 3, slot 3
                    move = "C3";
                }
            } // END: switch case = randomNumber
        } while (!someboard.isMoveAvailable(move));

        return move;
    } // END generateRandomMove method
} // END: Computer class
