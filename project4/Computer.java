import java.util.Random;

public class Computer
{
    char id;

    public Computer()
    {
        this.id = 'X';
    }

    public Computer(char someChar)
    {
        this.id = someChar;
    }

    public void setId(char someId)
    {
        this.id = someId;
    }

    public char getId()
    {
        return this.id;
    }

    public void move(Board someBoard, int round)
    {
        String move = "noMoveAvailable";

        do
        {
            if (move.equals("noMoveAvailable"))
            {
                move = checkForBestMove(someBoard, true);
            }

            if (move.equals("noMoveAvailable"))
            {
                move = checkForBestMove(someBoard, true);
            }

            if (move.equals("noMoveAvailable"))
            {
                move = checkForStrategicMove(someBoard, round);
            }

            if (move.equals("noMoveAvailable"))
            {
                move = checkForBestMove(someBoard, true);
            }

            if (move.equals("noMoveAvailable"))
            {
                move = generateRandomMove(someBoard);
            }

        } while (!someBoard.isMoveAvailable(move));

        someBoard.submitMove(move, this.id);
        someBoard.printBoard();
    }

    public String checkForBestMove(Board someBoard, boolean offensive)
    {
        char[][] board = someBoard.playingSurface;
        char offender = ' ';
        char defender = ' ';
        if (this.id == 'X')
        {
            if (offensive)
            {
                offender = 'X';
                defender = 'Y';
            }
            else
            {
                offender = 'Y';
                defender = 'N';
            }
        }
        else if (this.id == 'Y')
        {
            if (offensive)
            {
                offender = 'Y';
                defender = 'X';
            }
            else
            {
                offender = 'N';
                defender = 'Y';
            }
        }

        // Loop through every row and column, checking for winning moves
        for(int i = 0; i <= 2; i++)
        {
            // Check if said column is available to conquer
            if (board[i][0] != defender && board[i][1] != defender && board[i][2] != defender)
            {
                /* Check if the computer has occupied the first two slots in said column
                 * if so, play in the last slot
                 */
                if(board[i][0] == offender && board[i][1] == offender)
                {
                    // Determine which column to play into
                    if (i == 0)
                    {
                        // play in column 1, last slot
                        return "A3";
                    }
                    else if (i == 1)
                    {
                        // play in column 2, last slot
                        return "B3";
                    }
                    else if (i == 2)
                    {
                        // play in column 3, last slot
                        return "B3";
                    }
                } // END: if first two slots are occupied by computer

                /* Check if the computer has occupied the last two slots in said column
                 * if so, play in the first slot
                 */
                else if(board[i][1] == offender && board[i][2] == offender)
                {
                    // determine which column to play into
                    if (i == 0)
                    {
                        // play in column 1, first slot
                        return "A1";
                    }
                    else if (i == 1)
                    {
                        // play in column 2, first slot
                        return "B1";
                    }
                    else if (i == 2)
                    {
                        // play in column 3, first slot
                        return "B2";
                    }
                } // END: if the last two slots are occupied by computer

                /* Check if the computer has occupied the outer two slots in said column
                 * if so, play in the middle slot
                 */
                else if(board[i][0] == offender && board[i][2] == offender)
                {
                    // determine which column to play into
                    if (i == 0)
                    {
                        // pay in column 1, middle slot
                        return "A2";
                    }
                    else if (i == 1)
                    {
                        // play in column 2, middle slot
                        return "B2";
                    }
                    else if (i == 2)
                    {
                        // play in column 3, middle slot
                        return "C2";
                    }
                } // END: if the outer two slots are occupied by computer
            } // END: looping through columns for winning move

            // Check if said row is available to conquer
            if (board[0][i] != defender && board[1][i] != defender && board[2][i] != defender)
            {
                /* Check if the computer has occupied the first two slots in said row
                 * if so, play in the last slot
                 */
                if(board[0][i] == offender && board[1][i] == offender)
                {
                    // Determine which row to play into
                    if (i == 0)
                    {
                        // play in row 1, last slot
                        return "C1";
                    }
                    else if (i == 1)
                    {
                        // play in row 2, last slot
                        return "C2";
                    }
                    else if (i == 2)
                    {
                        // play in row 3, last slot
                        return "C3";
                    }
                } // END: if first two slots are occupied by the computer

                /* Check if the computer has occupied the last two slots in said row
                 * if so, play in the first slot
                 */
                else if(board[1][i] == offender && board[2][i] == offender)
                {
                    // determine which row to play into
                    if (i == 0)
                    {
                        // play in row 1, first slot
                        return "A1";
                    }
                    else if (i == 1)
                    {
                        // play in row 2, first slot
                        return "A2";
                    }
                    else if (i == 2)
                    {
                        // play in row 3, first slot
                        return "A3";
                    }
                } // END: if the last two slots are occupied by the user

                /* Check if the computer has occupied the outer two slots in said row
                 * if so, play in the middle slot
                 */
                else if(board[0][i] == offender && board[2][i] == offender)
                {
                    // determine which row to play into
                    if (i == 0)
                    {
                        // play in row 1, middle slot
                        return "B1";
                    }
                    else if (i == 1)
                    {
                        // play in row 2, middle slot
                        return "B2";
                    }
                    else if (i == 2)
                    {
                        // play in row 3, middle slot
                        return "B3";
                    }
                } // END: if outer two slots are occupied by the computer
            } // END: looping through rows for winning move
        } // END: looping through all rows and columns for winning move

        // check '\' diagonal for winning move
        if(board[0][0] != defender && board[1][1] != defender && board[2][2] != defender)
        {
            // check if the first two slots are occupied by the computer
            if (board[0][0] == offender && board[1][1] == offender)
            {
                // play in column 3, last slot
                return "C3";
            }

            // check if the outer two slots are occupied by the computer
            else if (board[0][0] == offender && board[2][2] == offender)
            {
                // play in column 2, middle slot
                return "B2";
            }

            // check if last two slots are occupied by the computer
            else if (board[2][2] == offender && board[1][1] == offender)
            {
                // play in column 1, first slot
                return "A1";
            }
        } // END: checking for '\' diagonal winning moves

        // check '/' diagonal for winning move
        if(board[2][0] != defender && board[1][1] != defender && board[0][2] != defender)
        {
            // check if the last two slots are occopied by the computer
            if (board[2][0] == offender && board[1][1] == offender)
            {
                //play in  column 1, last slot
                return "A3";
            }

            // check if the outer two slots are occupied by th
            else if (board[2][0] == offender && board[0][2] == offender)
            {
                // play in column 2, middle slot
                return "B2";
            }

            // check if the first two slots are occupied by the computer
            else if (board[0][2] == offender && board[1][1] == offender)
            {
                // play in column 3, first slot
                return "C1";
            }
        } // END: checking for '\' diagonal winning moves

        return "noMoveAvailable";
    } // END: checkForBestMove method

    public String checkForStrategicMove(Board someBoard, int round)
    {
        char[][] board = someBoard.playingSurface;
        char offender = ' ';
        char defender = ' ';
        if (this.id == 'X')
        {
            offender = 'X';
            defender = 'O';
        }
        else if (this.id == 'Y')
        {
            offender = 'O';
            offender = 'X';
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
                /* check if the user has played in the middle position
                 * if true: column 1, slot 1
                 * if false: column 1, slot 2
                 */
                if (board[1][1] == 'O')
                {
                    return "A1";
                }
                else
                {
                    return "A2";
                }
            }

            // round 3
            case 3:
            {
                // check if the user has played in the middle position
                if(board[1][1] == defender)
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
                if((board[0][0] == defender || board[0][2] == defender) && board[1][1] == offender)
                {
                    // play in column 1, slot 2
                    return "A2";
                }

                /* check if:
                 * the use user has played in either of the right corners &&
                 * if the computer has played in the middle
                 */
                if((board[2][0] == defender || board[2][2] == defender) && board[1][1] == offender)
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
                if(board[1][0] != defender && board[2][0] != defender && board[2][1] != defender && board[2][2] != defender)
                {
                    /* Check if the computer has previously gone in the second column, row 2
                     * if true: column 3, slot 3
                     * if false: column 3, slot 1
                     */
                    if (board[2][0] == offender)
                    {
                        return "C3";
                    }
                    else
                    {
                        return "C1";
                    }
                }

                // Check if the user has played in any of the last two slots in column 1 and row 3
                else if(board[0][1] != defender && board[0][2] != defender && board[1][2] != defender && board[2][2] != defender)
                {
                    /* Check if the computer has previously gone in the first column, row 3
                     * if true: column 3, slot 3
                     * if false: column 1, slot 3
                     */
                    if (board[0][2] == offender)
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
                if (board[1][0] != defender && board[2][0] != defender)
                {
                    // check which slot in which the computer has already played
                    if(board[1][0] == offender)
                    {
                        // column 3, slot 1
                        return "C1";

                    }
                    else if(board[2][0] == offender)
                    {
                        // column 2, slot 1
                        return "B1";
                    }
                }

                // check if the computer has a winning chance via the first column
                else if (board[0][1] != defender && board[0][2] != defender)
                {
                    // check which slot in which the computer has already played
                    if (board[0][1] == offender)
                    {
                        // column 1, slot 3
                        return "A3";
                    }
                    else if (board[0][2] == offender)
                    {
                        // column 1, slot 2
                        return "A2";
                    }
                }

                // check if the computer has a winning chance via row 3
                else if (board[0][2] != offender && board[1][2] != defender && board[2][2] != defender)
                {
                    // column 2, slot 3
                    return "B3";
                }

                // check if the computer has a winning chance column 3
                else if (board[2][0] != offender && board[2][1] != defender && board[2][2] != defender)
                {
                    // column 3, slot 2
                    return "C2";
                }

                // TODO Finish refactoring return values

                // check if the computer has a winning chance via the '/' diagonal
                else if (board[0][2] != defender && board[1][1] != defender && board[2][0] != defender)
                {
                    // check if the computer has occupied the first two slots
                    if(board[0][2] == offender && board[1][1] == offender)
                    {
                        // column 1, slot 1
                        someBoard.submitMove("C1", this.id);
                        return true;
                    }

                    // check if the computer has occupied the two outer slots
                    else if(board[0][2] == offender && board[1][1] == offender)
                    {
                        // column 2, slot 2
                        someBoard.submitMove("B2", this.id);
                        return true;
                    }

                    // check if the computer has occupied the last two slots
                    else if(board[2][0] == offender && board[1][1] == offender)
                    {
                        // column 1, slot 3
                        someBoard.submitMove("A3", this.id);
                        return true;
                    }
                }

                // check if the computer has a winning chance via the '\' diagonal
                else if (board[1][1] != defender && board[2][2] != defender)
                {
                    /* assuming the computer has occupied the first slot,
                     * check if the computer has occupied the middle slot
                     */
                    if (board[1][1] == offender)
                    {
                        // column 3, slot 3
                        someBoard.submitMove("C3", this.id);
                        return true;
                    }

                    /* assuming the computer has occupied the first slot,
                     * check if the computer has occupied the last slot
                     */
                    else if (board[2][2] == offender)
                    {
                        // column 2, slot 2
                        someBoard.submitMove("B2", this.id);
                        return true;
                    }
                }

                // break away from the switch
                break;
            }
        }
        return false;
    }

    public void generateRandomMove(Board someboard)
    {
        Random random = new Random();
        String move = "flag";

        do
        {
            // randomly generate a number from 0-8
            int randomNumber = random.nextInt(8);

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

        someboard.submitMove(move, this.id);
    }
} // END: Computer class
