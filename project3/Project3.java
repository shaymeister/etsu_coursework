/**
 * -----------------------------------------------------------------------------
 * File name: Project3.java
 * Project name: Project 3
 * -----------------------------------------------------------------------------
 * Author’s name and email: Shay Snyder snyderse2@etsu.edu			
 * Course-Section: CSCI 1250-088
 * Creation Date: November 7, 2019	
 * Last modified: (Shay Snyder, 11/11/2019, snyderse2@etsu.edu)
 * -----------------------------------------------------------------------------
 */

// Packages
import java.util.Scanner;
import java.util.Random;

/**
 * -----------------------------------------------------------------------------
 * Class Name: Project3 <br>
 * Class Purpose: Contains the various methods required for a smart tic-tac-toe
 * game to be successfully execute <br>
 *
 * <hr>
 * Date created: November 7, 2019 <br>
 * Last modified: (Shay Snyder, 11/11/2019, snyderse2@etsu.edu)
 * @author Shay Snyder
 * -----------------------------------------------------------------------------
 */
public class Project3
{
    /**
     * Method Name: main <br>
     * Method Purpose: used to call all other methods <br>
     *
     * <hr>
     * Date created: November 11, 2019 <br>
     * Last modified: November 11, 2019 <br>
     */
    public static void main(String[] args)
    {
        // Introduce the user to the game
        welcome();

        // Start the game itself
        game(); 
    } //END: 'main' method

    /**
     * Method Name: game <br>
     * Method Purpose: acts as the central nervous system of the game;
     * used to direct the flow of the game <br>
     *
     * <hr>
     * Date created: November 11, 2019 <br>
     * Last modified: November 11, 2019 <br>
     */
    public static void game()
    {
        /* Class Instaces
         * Random class: used to randomly determine which PLAYER will make the first move.
         */
        Random random = new Random();

        /* Variables
         * char[][] board = a two dimensional array used to represent the playing surface
         * boolean userTurn (T = user makes next move, F = computer makes next move)
         */
        char[][] board = {{' ', ' ', ' '},{' ', ' ', ' '},{' ', ' ', ' '}};
        boolean userTurn;

        /* Using the random class, the program generates a boolean value:
         * true = the user will make the first move
         * false = the computer will make the first move
         */
        userTurn = random.nextBoolean();

        // This loop goes through every possible round within a game
        for(int round = 1; round <= 10; round++)
        {
            /* Assuming a round count greater than 9, this if statement determines
             * if their are any possible moves. If no possible moves are determined,
             * the game is said to be a draw.
             */
            if (round > 9 && isCat(board, round))
            {
                // Display to the user the status of the game
                System.out.println("Neither party has one the match....\n"
                                 + "It's a draw!");
                // Ask the user if they would like to play again
                playAgain();
            }

            /* This if statement takes the boolean 'userTurn' as an argument:
             * true = the user will make the next move
             * false = the computer will make the next move
             */
            if(userTurn)
            {
                /* Ask the user for their move by calling the 'PLAYER' method.
                 * This method will toggle the boolean 'userTurn',
                 * allowing the computer to make the next move.
                 */
                userTurn = player(board, round);
            }
            else
            {
                /* Ask the computer for their move by calling the 'computer' method.
                 * This method will toggle the boolean 'userTurn',
                 * allowing the user to make the next move.
                 */
                userTurn = computer(board, round);
            }

            /* The 'printBoard' method is used to display the board
             * itself between every round of the match.
             */
            printBoard(board);
        } //END: for loop (going through every round of the match)
    } //END: 'game' method

    /**
     * Method Name: computer <br>
     * Method Purpose: represents the computer within the game <br>
     *
     * <hr>
     * Date created: November 11, 2019 <br>
     * Last modified: November 11, 2019 <br>
     *
     * <hr>
     * @param board a character array that represents the playing surface
     * @param round integer value that represents the progression of the game
     * @return true, enabling the user to make the next move
     */
    public static boolean computer(char[][] board, int round)
    {
        // Variables
        final char PLAYER = 'X'; // designates the character to represent the computer
        String move = " "; // to hold the move to be made my the computer

        // while the computer hasn't made a correct move, generate another
        while(!submitMove(move, board, PLAYER))
        {
            // call the generateMove method to generate a move for the computer
            move = generateMove(board, round);
        }

        // if it is the first round of the game, tell the user the computer is going first
        if(round == 1)
        {
            System.out.println("\nThe computer will start first.\n"
                             + "The computer has chosen slot: " + move);
        }
        else
        {
            System.out.println("The computer has chosen to go in " + move);
        }

        // see if a winning move has been made
        checkStatus(board, PLAYER);

        // return true, allowing the user to make the next move
        return true;
    }

    /**
     * Method Name: generateMove <br>
     * Method Purpose: determine the best move to be made by the computer, then make said move <br>
     *
     * <hr>
     * Date created: November 11, 2019 <br>
     * Last modified: November 11, 2019 <br>
     *
     * <hr>
     * @param board a character array representing the playing surface
     * @param round an integer that represents game progression
     * @return a String containing the best move for the computer
     */
    public static String generateMove(char[][] board, int round)
    {
        // Class Instances
        Random random = new Random();
        
        // Loop through every row and column, checking for winning moves
        for(int i = 0; i <= 2; i++)
        {
            // Check if said column is available to conquer
            if (board[i][0] != 'O' && board[i][1] != 'O' && board[i][2] != 'O')
            {
                /* Check if the computer has occupied the first two slots in said column
                 * if so, play in the last slot
                 */
                if(board[i][0] == 'X' && board[i][1] == 'X')
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

                /* Check if the computer has occupied the last two slots in said column
                 * if so, play in the first slot
                 */
                else if(board[i][1] == 'X' && board[i][2] == 'X')
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

                /* Check if the computer has occupied the outer two slots in said column
                 * if so, play in the middle slot
                 */
                else if(board[i][0] == 'X' && board[i][2] == 'X')
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
            if (board[0][i] != 'O' && board[1][i] != 'O' && board[2][i] != 'O')
            {
                /* Check if the computer has occupied the first two slots in said row
                 * if so, play in the last slot
                 */
                if(board[0][i] == 'X' && board[1][i] == 'X')
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
                else if(board[1][i] == 'X' && board[2][i] == 'X')
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
                else if(board[0][i] == 'X' && board[2][i] == 'X')
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
        if(board[0][0] != 'O' && board[1][1] != 'O' && board[2][2] != 'O')
        {
            // check if the first two slots are occupied by the computer
            if (board[0][0] == 'X' && board[1][1] == 'X')
            {
                // column 3, last slot
                return "C3";
            }

            // check if the outer two slots are occupied by the computer
            else if (board[0][0] == 'X' && board[2][2] == 'X')
            {
                // column 2, middle slot
                return "B2";
            }

            // check if last two slots are occupied by the computer
            else if (board[2][2] == 'X' && board[1][1] == 'X')
            {
                // column 1, first slot
                return "A1";
            }
        } // END: checking for '\' diagonal winning moves

        // check '/' diagonal for winning move
        if(board[2][0] != 'O' && board[1][1] != 'O' && board[0][2] != 'O')
        {
            // check if the last two slots are occopied by the computer
            if (board[2][0] == 'X' && board[1][1] == 'X')
            {
                // column 1, last slot
                return "A3";
            }

            // check if the outer two slots are occupied by th
            else if (board[2][0] == 'X' && board[0][2] == 'X')
            {
                // column 2, middle slot
                return "B2";
            }

            // check if the first two slots are occupied by the computer
            else if (board[0][2] == 'X' && board[1][1] == 'X')
            {
                // column 3, first slot
                return "C1";
            }
        } // END: checking for '\' diagonal winning moves

        // Loop through every row and column, checking for defensive moves
        for(int i = 0; i <= 2; i++)
        {
            // check if opponent has the chance to win in said column
            if (board[i][0] != 'X' && board[i][1] != 'X' && board[i][2] != 'X')
            {
                // check if the user has occupied the first two slots
                if(board[i][0] == 'O' && board[i][1] == 'O')
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

                // check if the user has occupied the outer two slots
                else if(board[i][0] == 'O' && board[i][2] == 'O')
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

                // check if the user has occupied the last to slots
                else if(board[i][1] == 'O' && board[i][2] == 'O')
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

            // check if the user has the chance to win in said row
            if (board[0][i] != 'X' && board[1][i] != 'X' && board[2][i] != 'X')
            {
                // check if the first two slots have been occupied by the user
                if(board[0][i] == 'O' && board[1][i] == 'O')
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

                // check if the two outer slots have been occupied by the user
                else if(board[0][i] == 'O' && board[2][i] == 'O')
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

                // check if the last two slots have been occupied by the user
                else if(board[1][i] == 'O' && board[2][i] == 'O')
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
        if(board[0][0] != 'X' && board[1][1] != 'X' && board[2][2] != 'X')
        {
            // check if the first two slots are occupied by the user
            if (board[0][0] == 'O' && board[1][1] == 'O')
            {
                // column 3, slot 3
                return "C3";
            }

            // check if the two outer slots are occupied by the user
            else if (board[0][0] == 'O' && board[2][2] == 'O')
            {
                // column 2, slot 2
                return "B2";
            }

            // check if the last two slots are occupied by the user
            else if (board[2][2] == 'O' && board[1][1] == 'O')
            {
                // column 1, slot 1
                return "A1";
            }
        } // END: checking for potential loss in the '\' diagonal

        // check the '/' diagonal for a potential loss
        if(board[2][0] != 'X' && board[1][1] != 'X' && board[0][2] != 'X')
        {
            // check if the first two slots are occupied by the user
            if (board[2][0] == 'O' && board[1][1] == 'O')
            {
                // column 1, slot 3
                return "A3";
            }

            // check if the outer two slots are occupied by the user
            else if (board[2][0] == 'O' && board[0][2] == 'O')
            {
                // column 2, slot 2
                return "B2";
            }

            // check if th last two slots are occupied by the user
            else if (board[0][2] == 'O' && board[1][1] == 'O')
            {
                // column 3, slot 1
                return "C1";
            }
        } // END: checking for potential loss in the '\' diagonal
        
        // this switch is used when there are no available winning or defensive moves available
        switch(round)
        {
            // round 1
            case 1:
            {
                // column 1, slot 1
                return "A1";
            }

            // round 2
            case 2:
            {
                /* check if the user has played in the middle position
                 * if true: column 1, slot 1
                 * if false: column 1, slot 2
                 */
                return (board[1][1] == 'O') ? "A1" : "A2";
            }

            // round 3
            case 3:
            {
                // check if the user has played in the middle position
                if(board[1][1] == 'O')
                {
                    // column 3, slot 3
                    return "C3";
                }

                // check if the last two slots are available in the first column
                else if(board[0][1] == ' ' && board[0][2] == ' ')
                {
                    // column 1, slot 3
                    return "A3";
                }

                // check if the last two slots are available in the first row
                else if(board[1][0] == ' ' && board[2][0] == ' ')
                {
                    // column 3, slot 1
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
                if((board[0][0] == 'O' || board[0][2] == 'O') && board[1][1] == 'X')
                {
                    // column 1, slot 2
                    return "A2";
                }

                /* check if:
                 * the use user has played in either of the right corners &&
                 * if the computer has played in the middle
                 */
                if((board[2][0] == 'O' || board[2][2] == 'O') && board[1][1] == 'X')
                {
                    // column 3, slot 2
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
                if(board[1][0] != 'O' && board[2][0] != 'O' && board[2][1] != 'O' && board[2][2] != 'O')
                {
                    /* Check if the computer has previously gone in the second column, row 2
                     * if true: column 3, slot 3
                     * if false: column 3, slot 1
                     */ 
                    return (board[2][0] == 'X') ? "C3" : "C1";
                }

                // Check if the user has played in any of the last two slots in column 1 and row 3
                else if(board[0][1] != 'O' && board[0][2] != 'O' && board[1][2] != 'O' && board[2][2] != 'O')
                {
                    /* Check if the computer has previously gone in the first column, row 3
                     * if true: column 3, slot 3
                     * if false: column 1, slot 3
                     */ 
                    return (board[0][2] == 'X') ? "C3" : "A3";
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

        // randomly generate a number from 0-8
        int randomNumber = random.nextInt(8);

        // covert the random number into an actual move
        switch(randomNumber)
        {
            // random number = 0
            case 0:
            {
                // column 1, slot 1
                return "A1";
            }

            // random number = 1
            case 1:
            {
                // column 1, slot 2
                return "A2";
            }

            // random number = 2
            case 2:
            {
                // column 1, slot 3
                return "A3";
            }

            // random number = 3
            case 3:
            {
                // column 2, slot 1
                return "B1";
            }

            // random number = 4
            case 4:
            {
                // column 2, slot 2
                return "B2";
            }

            // random number = 5
            case 5:
            {
                // column 2, slot 3
                return "B3";
            }

            // random number = 6
            case 6:
            {
                // column 3, slot 1
                return "C1";
            }

            // random number = 7
            case 7:
            {
                // column 3, slot 2
                return "C2";
            }

            // random number = 8
            case 8:
            {
                // column 3, slot 3
                return "C3";
            } 
        } // END: switch case = randomNumber
        return null;
    } // END: generateMove method

    /**
     * Method Name: player <br>
     * Method Purpose: to represent the user during tic-tac-toe <br>
     *
     * <hr>
     * Date created: November 11, 2019 <br>
     * Last modified: November 11, 2019 <br>
     * 
     * <hr>
     *   @param board a character array that represents the playing surface
     *   @param round an integer that represents game progression
     *   @return a boolean allowing the computer to make the next move
     */
    public static boolean player(char[][] board, int round)
    {
        // Class instances
        Scanner keyboard = new Scanner(System.in);
        
        // variables
        String move = "none"; // to hold the move of the player
        char PLAYER = 'O';    // specifes the user's representation on the board
        int counter = 0;      // used to for input validation

        // while move is invalid, ask the user for their desired move
        while(!isMoveValid(move) || !submitMove(move, board, PLAYER))
        {   
            // check if the user has entered an incorrect value and it trying again
            if (counter++ > 0)
            {
                System.out.println("INVALID ENTRY!!! Please try again.");
            }

            // first round of the match
            if(round == 1)
            {
                System.out.print("\nSince the board is blank, where would you like to start? ");
            }

            // all other rounds
            else
            {
                System.out.print("Where would you like to play? ");
            }

            // ask the user for their desired move
            move = keyboard.nextLine();
        }
        
        // check if the user has won the game
        checkStatus(board, PLAYER);

        // return false, allowing the computer to make the next move
        return false;
    } // END: player method

    /**
     * Method Name: checkStatus <br>
     * Method Purpose: determine if either player has won the match <br>
     *
     * <hr>
     * Date created: November 11, 2019 <br>
     * Last modified: November 11, 2019 <br>
     *
     * <hr>
     * @param board a character array that represents the playing surface
     * @param PLAYER a character representing the current player
     */
    public static void checkStatus(char[][] board, char PLAYER)
    {
        // check for a winner
        if (isWinner(board, PLAYER)) 
        {
            // display the board to the screen
            printBoard(board);

            // check if the user was playing
            if (PLAYER == 'O')
            {
                System.out.println("Congrats, you have won the game!");
            }

            // assume the computer was playing
            else
            {
                System.out.println("Sorry, the computer has won the game.");
            }

            // ask the user if they would like to play again
            playAgain();
        }
    } // END: checkStatus method

    /**
     * Method Name: isCat <br>
     * Method Purpose: determine if the game is a draw <br>
     *
     * <hr>
     * Date created: November 11, 2019 <br>
     * Last modified: November 11, 2019 <br>
     *
     * <hr>
     * @param board a character array that represents the playing surface
     * @param i an integer value that presents game progression
     * @return a boolean value specifying the game's continuity
     */
    public static boolean isCat(char[][] board, int i)
    {
        // assume if the game is on the tenth round, automatic draw
        if(i >= 10)
        {
            return true;
        }
        return false;
    } // END: isCat method

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
    public static boolean isMoveValid(String move)
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

    /**
     * Method Name: isWinner <br>
     * Method Purpose: determine if a player has won the game <br>
     *
     * <hr>
     * Date created: November 11, 2019 <br>
     * Last modified: November 11, 2019 <br>
     *
     * <hr>
     * @param board a character array that represents the playing surface
     * @param PLAYER a character value specifying the current player
     * @return a boolean specifying if a player has won
     */
    public static boolean isWinner(char[][] board, char PLAYER)
    {
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

    /**
     * Method Name: playAgain <br>
     * Method Purpose: determine if you user would like to play again <br>
     *
     * <hr>
     * Date created: November 11, 2019 <br>
     * Last modified: November 11, 2019 <br>
     */
    public static void playAgain()
    {
        // Class Instances
        Scanner keyboard = new Scanner(System.in);

        // Variables
        char decision = ' '; // to hold the users decision

        // while the user hasn't entered a value, ask them for the decision
        while (decision == ' ')
        {
            System.out.print("\nWould you like to play again? (Y/N) ");
            decision = keyboard.nextLine().toUpperCase().charAt(0);
        }

        // if the user says yes, restart the game
        if (decision == 'Y')
        {
            game();
        }

        // if the user says otherwise, end the game
        else
        {
            System.out.println("Thank you for playing!");
            System.exit(0);
        }
    } // END: playAgain method

    /**
     * Method Name: printBoard <br>
     * Method Purpose: display the playing surface on the command line <br>
     *
     * <hr>
     * Date created: November 11, 2019 <br>
     * Last modified: Movember 11, 2019 <br>
     *
     * <hr>
     * @param board a character array that represents the playing surface
     */
    public static void printBoard(char[][] board)
    {
        // Displaying the playing surface via the command line
        System.out.println("\n"
            +"\n\t " + board[0][0] + " | " + board[1][0] + " | " + board[2][0]
            +"\n\t---|---|---"
            +"\n\t " + board[0][1] + " | " + board[1][1] + " | " + board[2][1]
            +"\n\t---|---|---"
            +"\n\t " + board[0][2] + " | " + board[1][2] + " | " + board[2][2]
            +"\n\n");
    }

    /**
     * Method Name: submitMove <br>
     * Method Purpose: determine if the desired move is available,
     * if so, add the move to the board and return true
     * else, don't add the move and return false <br>
     *
     * <hr>
     * Date created: November 11, 2019 <br>
     * Last modified: November 11, 2019 <br>
     *
     * <hr>
     * Notes on specifications, special algorithms, and assumptions:
     * notes go here
     *
     * <hr>
     * @param move a string containing the desired move
     * @param board a character array that represents the playing surface
     * @param PLAYER a character that specifies the current player
     * @return a boolean value that specifies the validity of the move
     */
    public static boolean submitMove(String move, char[][] board, char PLAYER)
    {
        /* Determine if the desired move is even possible
         * Then determine if the move is available
         * 
         * if both = true, add the move to the board and return true
         * if either = false, return false
         */ 
        if (move.equals("A1"))
        {
            if (board[0][0] == ' ')
            {
                board[0][0] = PLAYER;
                return true;
            } 
        }
        else if (move.equals("A2"))
        {
            if (board[0][1] == ' ')
            {
                board[0][1] = PLAYER;
                return true;
            } 
        }
        else if (move.equals("A3"))
        {
            if (board[0][2] == ' ')
            {
                board[0][2] = PLAYER;
                return true;
            } 
        }
        else if (move.equals("B1"))
        {
            if (board[1][0] == ' ')
            {
                board[1][0] = PLAYER;
                return true;
            } 
        }
        else if (move.equals("B2"))
        {
            if (board[1][1] == ' ')
            {
                board[1][1] = PLAYER;
                return true;
            } 
        }
        else if (move.equals("B3"))
        {
            if (board[1][2] == ' ')
            {
                board[1][2] = PLAYER;
                return true;
            } 
        }
        else if (move.equals("C1"))
        {
            if (board[2][0] == ' ')
            {
                board[2][0] = PLAYER;
                return true;
            } 
        }   
        else if (move.equals("C2"))
        {
            if (board[2][1] == ' ')
            {
                board[2][1] = PLAYER;
                return true;
            } 
        }
        else if (move.equals("C3"))
        {
            if (board[2][2] == ' ')
            {
                board[2][2] = PLAYER;
                return true;
            } 
        }
        return false;
    } // END: submitMove method

    /**
     * Method Name: welcome <br>
     * Method Purpose: introduce the game to the player inform
     * them of the rules and how to play<br>
     *
     * <hr>
     * Date created: November 11, 2019 <br>
     * Last modified: November 11, 2019 <br>
     */
    public static void welcome()
    {
        // introduce the game to the user, the rules, and how to play
        System.out.println(
              "Welcome to my tic tac toe game!\n" 
            + "The board is layed out in a 3x3 grid as such:\n"
            + "\n"
            + "\t(A1)|(B1)|(C1)\n"
            + "\t----|----|----\n"
            + "\t(A2)|(B2)|(C2)\n"
            + "\t----|----|----\n"
            + "\t(A3)|(B2)|(C3)\n"
            + "\n"
            + "You will be playing against a smart computer!\n"
            + "\n"
            + "Rules:\n"
            + "1) Which PLAYER goes first will be chosen randomly\n"
            + "2) To win, there must be 3 of a kind in a straight line in any direction\n"
            + "3) To place your chracter, you will be asked to enter a String (A-C,1-3)\n"
            + "4) Have fun!");
    } // END: welcome method
} // END: Project3 class