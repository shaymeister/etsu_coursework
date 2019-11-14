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
    //TODO - Finish Documentation
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
    public static void main(String[] args)
    {
        // Introduce the user to the game
        welcome();

        // Start the game itself
        game(); 
    } //END: 'main' method

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
    public static void game()
    {
        /* Class Instaces
         * Random class: used to randomly determine which player will make the first move.
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
                /* Ask the user for their move by calling the 'player' method.
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

    //TODO - Finish Documentation
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
    public static boolean computer(char[][] board, int round)
    {
        //TODO - Finish Documentation
        // Variables
        char player = 'X';
        String move = " ";

        while(!submitMove(move, board, player))
        {
            move = generateMove(board, round);
        }

        if(round == 1)
        {
            System.out.println("\nThe computer will start first.\n"
                             + "The computer has chosen slot: " + move);
        }
        else
        {
            System.out.println("The computer has chosen to go in " + move);
        }

        checkStatus(board, player);
        return true;
    }

    //TODO - Finish Documentation
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
    public static String generateMove(char[][] board, int round)
    {
        //TODO - Finish Documentation
        String move = null;
        Random random = new Random();
        for(int i = 0; i <= 2; i++)
        {
            if (board[i][0] != 'O' && board[i][1] != 'O' && board[i][2] != 'O')
            {
                if(board[i][0] == 'X' && board[i][1] == 'X')
                {
                    if (i == 0)
                    {
                        return "A3";
                    }
                    else if (i == 1)
                    {
                        return "B3";
                    }
                    else if (i == 2)
                    {
                        return "C3";
                    }
                }
                else if(board[i][1] == 'X' && board[i][2] == 'X')
                {
                    if (i == 0)
                    {
                        return "A1";
                    }
                    else if (i == 1)
                    {
                        return "B1";
                    }
                    else if (i == 2)
                    {
                        return "C1";
                    }
                }
                else if(board[i][0] == 'X' && board[i][2] == 'X')
                {
                    if (i == 0)
                    {
                        return "A2";
                    }
                    else if (i == 1)
                    {
                        return "B2";
                    }
                    else if (i == 2)
                    {
                        return "C2";
                    }
                }
            }

            if (board[0][i] != 'O' && board[1][i] != 'O' && board[2][i] != 'O')
            {
                if(board[0][i] == 'X' && board[1][i] == 'X')
                {
                    if (i == 0)
                    {
                        return "C1";
                    }
                    else if (i == 1)
                    {
                        return "C2";
                    }
                    else if (i == 2)
                    {
                        return "C3";
                    }
                }
                else if(board[1][i] == 'X' && board[2][i] == 'X')
                {
                    if (i == 0)
                    {
                        return "A1";
                    }
                    else if (i == 1)
                    {
                        return "A2";
                    }
                    else if (i == 2)
                    {
                        return "A3";
                    }
                }
                else if(board[0][i] == 'X' && board[2][i] == 'X')
                {
                    if (i == 0)
                    {
                        return "B1";
                    }
                    else if (i == 1)
                    {
                        return "B2";
                    }
                    else if (i == 2)
                    {
                        return "B3";
                    }
                }
            }
        }

        if(board[0][0] != 'O' && board[1][1] != 'O' && board[2][2] != 'O')
        {
            if (board[0][0] == 'X' && board[1][1] == 'X')
            {
                return "C3";
            }
            else if (board[0][0] == 'X' && board[2][2] == 'X')
            {
                return "B2";
            }
            else if (board[2][2] == 'X' && board[1][1] == 'X')
            {
                return "A1";
            }
        }

        if(board[2][0] != 'O' && board[1][1] != 'O' && board[0][2] != 'O')
        {
            if (board[2][0] == 'X' && board[1][1] == 'X')
            {
                return "A3";
            }
            else if (board[2][0] == 'X' && board[0][2] == 'X')
            {
                return "B2";
            }
            else if (board[0][2] == 'X' && board[1][1] == 'X')
            {
                return "C1";
            }
        }
        for(int i = 0; i <= 2; i++)
        {
            if (board[i][0] != 'X' && board[i][1] != 'X' && board[i][2] != 'X')
            {
                if(board[i][0] == 'O' && board[i][1] == 'O')
                {
                    if (i == 0)
                    {
                        return "A3";
                    }
                    else if (i == 1)
                    {
                        return "B3";
                    }
                    else if (i == 2)
                    {
                        return "C3";
                    }
                }
                else if(board[i][1] == 'O' && board[i][2] == 'O')
                {
                    if (i == 0)
                    {
                        return "A1";
                    }
                    else if (i == 1)
                    {
                        return "B1";
                    }
                    else if (i == 2)
                    {
                        return "C1";
                    }
                }
                else if(board[i][0] == 'O' && board[i][2] == 'O')
                {
                    if (i == 0)
                    {
                        return "A2";
                    }
                    else if (i == 1)
                    {
                        return "B2";
                    }
                    else if (i == 2)
                    {
                        return "C2";
                    }
                }
            }
            if (board[0][i] != 'X' && board[1][i] != 'X' && board[2][i] != 'X')
            {
                if(board[0][i] == 'O' && board[1][i] == 'O')
                {
                    if (i == 0)
                    {
                        return "C1";
                    }
                    else if (i == 1)
                    {
                        return "C2";
                    }
                    else if (i == 2)
                    {
                        return "C3";
                    }
                }
                else if(board[1][i] == 'O' && board[2][i] == 'O')
                {
                    if (i == 0)
                    {
                        return "A1";
                    }
                    else if (i == 1)
                    {
                        return "A2";
                    }
                    else if (i == 2)
                    {
                        return "A3";
                    }
                }
                else if(board[0][i] == 'O' && board[2][i] == 'O')
                {
                    if (i == 0)
                    {
                        return "B1";
                    }
                    else if (i == 1)
                    {
                        return "B2";
                    }
                    else if (i == 2)
                    {
                        return "B3";
                    }
                }
            }
        }

        if(board[0][0] != 'X' && board[1][1] != 'X' && board[2][2] != 'X')
        {
            if (board[0][0] == 'O' && board[1][1] == 'O')
            {
                return "C3";
            }
            else if (board[0][0] == 'O' && board[2][2] == 'O')
            {
                return "B2";
            }
            else if (board[2][2] == 'O' && board[1][1] == 'O')
            {
                return "A1";
            }
        }

        if(board[2][0] != 'X' && board[1][1] != 'X' && board[0][2] != 'X')
        {
            if (board[2][0] == 'O' && board[1][1] == 'O')
            {
                return "A3";
            }
            else if (board[2][0] == 'O' && board[0][2] == 'O')
            {
                return "B2";
            }
            else if (board[0][2] == 'O' && board[1][1] == 'O')
            {
                return "C1";
            }
        }
        
        switch(round)
        {
            case 1:
            {
                return "A1";
            }

            case 2:
            {
                return (board[1][1] == 'O') ? "A1" : "A2";
            }

            case 3:
            {
                if(board[1][1] == 'O')
                {
                    return "C3";
                }
                else if(board[0][1] == ' ' && board[0][2] == ' ')
                {
                    return "A3";
                }
                else if(board[1][0] == ' ' && board[2][0] == ' ')
                {
                    return "C1";
                }
                break;
            }

            case 4:
            {
                if((board[0][0] == 'O' || board[0][2] == 'O') && board[1][1] == 'X')
                {
                    return "A2";
                }
                if((board[2][0] == 'O' || board[2][2] == 'O') && board[1][1] == 'X')
                {
                    return "C2";
                }
                break;
            }

            case 5:
            case 6:
            {
                if(board[1][0] != 'O' && board[2][0] != 'O' && board[2][1] != 'O' && board[2][2] != 'O')
                {
                    return (board[2][0] == 'X') ? "C3" : "C1";
                }
                else if(board[0][1] != 'O' && board[0][2] != 'O' && board[1][2] != 'O' && board[2][2] != 'O')
                {
                    return (board[0][2] == 'X') ? "C3" : "A3";
                }
                else if(board[1][1] != 'O' && board[1][1] != 'X')
                {
                    return "B2";
                }
                break;
            }

            case 7:
            {
                if (board[1][0] != 'O' && board[2][0] != 'O')
                {
                    if(board[1][0] == 'X')
                    {
                        return "C1";
                    }
                    else if(board[2][0] == 'X')
                    {
                        return "B1";
                    }
                }
                else if (board[0][1] != 'O' && board[0][2] != 'O')
                {
                    if (board[0][1] == 'X')
                    {
                        return "A3";
                    }
                    else if (board[0][2] == 'X')
                    {
                        return "A2";
                    }
                }
                else if (board[0][2] != 'X' && board[1][2] != 'O' && board[2][2] != 'X')
                {
                    return "B3";
                }
                else if (board[2][0] != 'X' && board[2][1] != 'O' && board[2][2] != 'X')
                {
                    return "C2";
                }
                else if (board[0][2] != 'O' && board[1][1] != 'O' && board[2][0] != 'O')
                {
                    if(board[0][2] == 'X' && board[1][1] == 'X')
                    {
                        return "C1";
                    }
                    else if(board[2][0] == 'X' && board[1][1] == 'X')
                    {
                        return "A3";
                    }
                    else if(board[0][2] == 'X' && board[1][1] == 'X')
                    {
                        return "B2";
                    }
                }
                else if (board[1][1] != 'O' && board[2][2] != 'O')
                {
                    if (board[1][1] == 'X')
                    {
                        return "C3";
                    }
                    else if (board[2][2] == 'X')
                    {
                        return "B2";
                    }
                }
                break;
            }
        }

        int randomNumber = random.nextInt(8);

        switch(randomNumber)
        {
            case 0:
            {
                return "A1";
            }

            case 1:
            {
                return "A2";
            }

            case 2:
            {
                return "A3";
            }

            case 3:
            {
                return "B1";
            }

            case 4:
            {
                return "B2";
            }

            case 5:
            {
                return "B3";
            }

            case 6:
            {
                return "C1";
            }

            case 7:
            {
                return "C2";
            }

            case 8:
            {
                return "C3";
            }
        }
        return null;
    }

    
    //TODO - Finish Documentation
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
    public static boolean player(char[][] board, int round)
    {
        //TODO - Finish Documentation
        // Class instances
        Scanner keyboard = new Scanner(System.in);
        
        // variables
        String move = "none";
        char player = 'O';
        int counter = 0;
        while(!isMoveValid(move) || !submitMove(move, board, player))
        {   
            if (counter++ > 0)
            {
                System.out.println("INVALID ENTRY!!! Please try again.");
            }
            if(round == 1)
            {
                System.out.print("\nSince the board is blank, where would you like to start? ");
            }
            else
            {
                System.out.print("Where would you like to play? ");
            }
            move = keyboard.nextLine();
        }
        checkStatus(board, player);
        return false;
    }

    //TODO - Finish Documentation
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
    public static void checkStatus(char[][] board, char player)
    {
        //TODO - Finish Documentation
        if (isWinner(board, player)) 
        {
            printBoard(board);
            if (player == 'O')
            {
                System.out.println("Congrats, you have won the game!");
            }
            else
            {
                System.out.println("Sorry, the computer has won the game.");
            }
            playAgain();
        }
    }

    //TODO - Finish Documentation
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
    public static boolean isCat(char[][] board, int i)
    {
        if(i >= 10)
        {
            return true;
        }
        return false;
    }

    //TODO - Finish Documentation
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
    public static boolean isMoveValid(String move)
    {
        //TODO - Finish Documentation
        String[] possibleMoves = {"A1","A2","A3", "B1", "B2", "B3", "C1", "C2", "C3"};

        for(String possibleMove : possibleMoves)
        {
            if(move.equals(possibleMove))
            {
                return true;
            }
        } 
        return false;
    }

    //TODO - Finish Documentation
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
    public static boolean isWinner(char[][] board, char player)
    {
        //TODO - Finish Documentation
        // Check each column and row for a winner
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

        // check '\' diagonal for winner
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2])
        {
            if (!(board[1][1] == ' '))
            {
                return true;
            }
        }
         
        // check '/' diagonal for winner
        if (board[0][2] == board[1][1] && board[0][2] == board[2][0])
        {
            if (!(board[1][1] == ' '))
            {
                return true;
            }
        }
         
        return false;
    }

    //TODO - Finish Documentation
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
    public static void playAgain()
    {
        //TODO - Finish Documentation
        Scanner keyboard = new Scanner(System.in);
        char decision = ' ';

        while (decision == ' ')
        {
            System.out.print("\nWould you like to play again? (Y/N) ");
            decision = keyboard.nextLine().toUpperCase().charAt(0);
        }

        if (decision == 'Y')
        {
            game();
        }
        else
        {
            System.out.println("Thank you for playing!");
            System.exit(0);
        }
    }

    //TODO - Finish Documentation
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
    public static void printBoard(char[][] board)
    {
        //TODO - Finish Documentation
        System.out.println("\n"
            +"\n\t " + board[0][0] + " | " + board[1][0] + " | " + board[2][0]
            +"\n\t---|---|---"
            +"\n\t " + board[0][1] + " | " + board[1][1] + " | " + board[2][1]
            +"\n\t---|---|---"
            +"\n\t " + board[0][2] + " | " + board[1][2] + " | " + board[2][2]
            +"\n\n");
    }

    //TODO - Finish Documentation
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
    public static boolean submitMove(String move, char[][] board, char player)
    {
        //TODO - Finish Documentation
        if (move.equals("A1"))
        {
            if (board[0][0] == ' ')
            {
                board[0][0] = player;
                return true;
            } 
        }
        else if (move.equals("A2"))
        {
            if (board[0][1] == ' ')
            {
                board[0][1] = player;
                return true;
            } 
        }
        else if (move.equals("A3"))
        {
            if (board[0][2] == ' ')
            {
                board[0][2] = player;
                return true;
            } 
        }
        else if (move.equals("B1"))
        {
            if (board[1][0] == ' ')
            {
                board[1][0] = player;
                return true;
            } 
        }
        else if (move.equals("B2"))
        {
            if (board[1][1] == ' ')
            {
                board[1][1] = player;
                return true;
            } 
        }
        else if (move.equals("B3"))
        {
            if (board[1][2] == ' ')
            {
                board[1][2] = player;
                return true;
            } 
        }
        else if (move.equals("C1"))
        {
            if (board[2][0] == ' ')
            {
                board[2][0] = player;
                return true;
            } 
        }   
        else if (move.equals("C2"))
        {
            if (board[2][1] == ' ')
            {
                board[2][1] = player;
                return true;
            } 
        }
        else if (move.equals("C3"))
        {
            if (board[2][2] == ' ')
            {
                board[2][2] = player;
                return true;
            } 
        }
        return false;
    }

    //TODO - Finish Documentation
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
    public static void welcome()
    {
        //TODO - Finish Documentation
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
            + "1) Which player goes first will be chosen randomly\n"
            + "2) To win, there must be 3 of a kind in a straight line in any direction\n"
            + "3) To place your chracter, you will be asked to enter a String (A-C,1-3)\n"
            + "4) Have fun!");
    }
}