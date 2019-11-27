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

    public void move(Board someBoard, round)
    {
        if (checkForBestMove(someBoard, true))
        {
            return;
        }

        if (checkForBestMove(someBoard, false))
        {
            return;
        }

        if (checkForStrategicMove(someBoard, round))
        {
            return;
        }
        generateRandomMove(someBoard);
    }

    public boolean checkForBestMove(Board someBoard, boolean offensive)
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
                        someBoard.submitMove("A3", this.id);

                        // return to the runtime environment
                        return true;
                    }
                    else if (i == 1)
                    {
                        // play in column 2, last slot
                        someBoard.submitMove("B3", this.id);

                        // return to the runtime environment
                        return true;
                    }
                    else if (i == 2)
                    {
                        // play in column 3, last slot
                        someBoard.submitMove("C3", this.id);

                        // return to the runtime environment
                        return true;
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
                        someBoard.submitMove("A1", this.id);

                        // return to runtime environment
                        return true;
                    }
                    else if (i == 1)
                    {
                        // play in column 2, first slot
                        someBoard.submitMove("B1", this.id);

                        // return to runtime environment
                        return true;
                    }
                    else if (i == 2)
                    {
                        // play in column 3, first slot
                        someBoard.submitMove("C1", this.id);

                        // return to runtime environment
                        return true;
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
                        someBoard.submitMove("A2", this.id);

                        // return to runtime environent
                        return true;
                    }
                    else if (i == 1)
                    {
                        // play in column 2, middle slot
                        someBoard.submitMove("B2", this.id);

                        // return to runtime environment
                        return true;
                    }
                    else if (i == 2)
                    {
                        // play in column 3, middle slot
                        someBoard.submitMove("C2", this.id);

                        // return to runtime environment
                        return true;
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
                        someBoard.submitMove("C1", this.id);

                        // return to runtime environment
                        return true;
                    }
                    else if (i == 1)
                    {
                        // play in row 2, last slot
                        someBoard.submitMove("C2", this.id);

                        // return to runtime environment
                        return true;
                    }
                    else if (i == 2)
                    {
                        // play in row 3, last slot
                        someBoard.submitMove("C3", this.id);

                        // return to runtime environment
                        return true;
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
                        someBoard.submitMove("A1", this.id);

                        // return to runtime environment
                        return true;
                    }
                    else if (i == 1)
                    {
                        // play in row 2, first slot
                        someBoard.submitMove("A2", this.id);

                        // return to runtime environment
                        return true;
                    }
                    else if (i == 2)
                    {
                        // play in row 3, first slot
                        someBoard.submitMove("A3", this.id);

                        // return to runtime environment
                        return true;
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
                        someBoard.submitMove("B1", this.id);

                        // return to runtime environment
                        return true;
                    }
                    else if (i == 1)
                    {
                        // play in row 2, middle slot
                        someBoard.submitMove("B2", this.id);

                        // return to runtime environment
                        return true;
                    }
                    else if (i == 2)
                    {
                        // play in row 3, middle slot
                        someBoard.submitMove("B3", this.id);

                        // return to runtime environment
                        return true;
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
                someBoard.submitMove("C3", this.id);

                // return to runtime environment
                return true;
            }

            // check if the outer two slots are occupied by the computer
            else if (board[0][0] == offender && board[2][2] == offender)
            {
                // coplay in lumn 2, middle slot
                someBoard.submitMove("B2", this.id);

                // return to runtime environment
                return true;
            }

            // check if last two slots are occupied by the computer
            else if (board[2][2] == offender && board[1][1] == offender)
            {
                // play in column 1, first slot
                someBoard.submitMove("A1", this.id);

                // return to runtime environment
                return true;
            }
        } // END: checking for '\' diagonal winning moves

        // check '/' diagonal for winning move
        if(board[2][0] != defender && board[1][1] != defender && board[0][2] != defender)
        {
            // check if the last two slots are occopied by the computer
            if (board[2][0] == offender && board[1][1] == offender)
            {
                //play in  column 1, last slot
                someBoard.submitMove("A3", this.id);

                // return to runtime environment
                return true;
            }

            // check if the outer two slots are occupied by th
            else if (board[2][0] == offender && board[0][2] == offender)
            {
                // cplay in olumn 2, middle slot
                someBoard.submitMove("B2", this.id);

                // return to runtime environment
                return true;
            }

            // check if the first two slots are occupied by the computer
            else if (board[0][2] == offender && board[1][1] == offender)
            {
                // play in column 3, first slot
                someBoard.submitMove("C1", this.id);

                // return to runtime environment
                return true;
            }
        } // END: checking for '\' diagonal winning moves

        return false;
    } // END: checkForBestMove method

    public boolean checkForStrategicMove(Board someBoard, int round)
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
                someBoard.submitMove("A1", this.id);
                return true;
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
                    someBoard.submitMove("A1", this.id);
                    return true;
                }
                else
                {
                    someBoard.submitMove("A2", this.id);
                    return true;
                }
            }

            // round 3
            case 3:
            {
                // check if the user has played in the middle position
                if(board[1][1] == defender)
                {
                    // play in column 3, slot 3
                    someBoard.submitMove("C3", this.id);
                    return true;
                }

                // check if the last two slots are available in the first column
                else if(board[0][1] == ' ' && board[0][2] == ' ')
                {
                    // play in column 1, slot 3
                    someBoard.submitMove("A3", this.id);
                    return true;
                }

                // check if the last two slots are available in the first row
                else if(board[1][0] == ' ' && board[2][0] == ' ')
                {
                    // play in column 3, slot 1
                    someBoard.submitMove("C1", this.id);
                    return true;
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
                    someBoard.submitMove("A2", this.id);
                    return true;
                }

                /* check if:
                 * the use user has played in either of the right corners &&
                 * if the computer has played in the middle
                 */
                if((board[2][0] == defender || board[2][2] == defender) && board[1][1] == offender)
                {
                    // play in column 3, slot 2
                    someBoard.submitMove("C2", this.id);
                    return true;
                }

                // break away from the switch
                return false;
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
                    return (board[2][0] == offender) ? "C3" : "C1";
                }

                // Check if the user has played in any of the last two slots in column 1 and row 3
                else if(board[0][1] != defender && board[0][2] != defender && board[1][2] != defender && board[2][2] != defender)
                {
                    /* Check if the computer has previously gone in the first column, row 3
                     * if true: column 3, slot 3
                     * if false: column 1, slot 3
                     */
                    return (board[0][2] == offender) ? "C3" : "A3";
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
                if (board[1][0] != 'O' && board[2][0] != 'O')
                {
                    // check which slot in which the computer has already played
                    if(board[1][0] == 'X')
                    {
                        // column 3, slot 1
                        return "C1";
                    }
                    else if(board[2][0] == 'X')
                    {
                        // column 2, slot 1
                        return "B1";
                    }
                }

                // check if the computer has a winning chance via the first column
                else if (board[0][1] != 'O' && board[0][2] != 'O')
                {
                    // check which slot in which the computer has already played
                    if (board[0][1] == 'X')
                    {
                        // column 1, slot 3
                        return "A3";
                    }
                    else if (board[0][2] == 'X')
                    {
                        // column 1, slot 2
                        return "A2";
                    }
                }

                // check if the computer has a winning chance via row 3
                else if (board[0][2] != 'X' && board[1][2] != 'O' && board[2][2] != 'X')
                {
                    // column 2, slot 3
                    return "B3";
                }

                // check if the computer has a winning chance column 3
                else if (board[2][0] != 'X' && board[2][1] != 'O' && board[2][2] != 'X')
                {
                    // column 3, slot 2
                    return "C2";
                }

                // check if the computer has a winning chance via the '/' diagonal
                else if (board[0][2] != 'O' && board[1][1] != 'O' && board[2][0] != 'O')
                {
                    // check if the computer has occupied the first two slots
                    if(board[0][2] == 'X' && board[1][1] == 'X')
                    {
                        // column 1, slot 1
                        return "C1";
                    }

                    // check if the computer has occupied the two outer slots
                    else if(board[0][2] == 'X' && board[1][1] == 'X')
                    {
                        // column 2, slot 2
                        return "B2";
                    }

                    // check if the computer has occupied the last two slots
                    else if(board[2][0] == 'X' && board[1][1] == 'X')
                    {
                        // column 1, slot 3
                        return "A3";
                    }
                }

                // check if the computer has a winning chance via the '\' diagonal
                else if (board[1][1] != 'O' && board[2][2] != 'O')
                {
                    /* assuming the computer has occupied the first slot,
                     * check if the computer has occupied the middle slot
                     */
                    if (board[1][1] == 'X')
                    {
                        // column 3, slot 3
                        return "C3";
                    }

                    /* assuming the computer has occupied the first slot,
                     * check if the computer has occupied the last slot
                     */
                    else if (board[2][2] == 'X')
                    {
                        // column 2, slot 2
                        return "B2";
                    }
                }

                // break away from the switch
                break;
            }
        }

    }
} // END: Computer class