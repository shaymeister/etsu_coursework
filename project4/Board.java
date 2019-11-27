public class Board
{
    char[][] playingSurface = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};

    public boolean isCat()
    {
        if (playingSurface[0][0] != ' ' && playingSurface[0][0] != ' ' && playingSurface[0][0] != ' ')
        {
            return true;
        }
        else if (playingSurface[0][0] != ' ' && playingSurface[0][0] != ' ' && playingSurface[0][0] != ' ')
        {
            return true;
        }
        else if (playingSurface[0][0] != ' ' && playingSurface[0][0] != ' ' && playingSurface[0][0] != ' ')
        {
            return true;
        }
        else
        {
            return false;
        }
    } // END: isCat method

    public boolean isWinner(Board someBoard)
    {
        char[][] board = someBoard.playingSurface;
        
        /* Check each column and row for a winner
         * if a win has occured, return true 
         */
        for(int i = 0; i <= 2; i++)
        {
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2])
            {
                if (!(board[i][0] == ' '))
                {
                    return true;
                }
            } 
            if (board[0][i] == board[1][i] && board[0][i] == board[2][i])
            {
                if (!(board[0][i] == ' '))
                {
                    return true;
                }
            }
        }

        /* check '\' diagonal for winner
         * if a win has occured, return true
         */
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2])
        {
            if (!(board[1][1] == ' '))
            {
                return true;
            }
        }
         
        /* check '/' diagonal for winner
         * if a win has occured, return true
         */
        if (board[0][2] == board[1][1] && board[0][2] == board[2][0])
        {
            if (!(board[1][1] == ' '))
            {
                return true;
            }
        }
        
        // else, return false
        return false;
    } // END: isWinner method

    public boolean isMoveValid(String move)
    {
        // define possible moves
        String[] possibleMoves = {"A1","A2","A3", "B1", "B2", "B3", "C1", "C2", "C3"};

        // check the desired move by looping through array
        for(String possibleMove : possibleMoves)
        {
            // if the desired moves matches an element within the array, return true
            if(move.equals(possibleMove))
            {
                return true;
            }
        } 

        // else, return false
        return false;
    } // END: isMoveValid method

    public boolean isMoveAvailable()
    {
        return false;
    } // END: isMoveAvailable method

    public void submitMove(String someMove, char someId)
    {

    } // END: submitMove method
} // END: Board class