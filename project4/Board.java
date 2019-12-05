public class Board
{
    char[][] playingSurface = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};

    public boolean isCat()
    {
        for (int i = 0; i < 3; i++)
        {
            if (this.playingSurface[0][i] == ' ' || this.playingSurface[i][0] == ' ')
            {
                return false;
            }
        }
        return true;
    }

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
    }

    public boolean isMoveValid(String move)
    {
        String[] validMoves = {"A1","A2","A3","B1","B2","B3","C1","C2","C3"};

        for(String validMove : validMoves)
        {
            if (move.equals(validMove))
            {
                return true;
            }
        }
        return false;
    }

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

    public void submitMove(String move, char someId)
    {
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
    }

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