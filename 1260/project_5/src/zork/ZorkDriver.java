/**
 * ---------------------------------------------------------------------------
 * File name: ZorkDriver.java
 * Project name: Project 5 - Zork
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 * Course:  CSCI 1260-288
 * Creation Date: April 6, 2020
 * ---------------------------------------------------------------------------
 */

package zork;

import javax.swing.JOptionPane;

/**
 * Drive Project 5: Zork through JOptionPane
 *
 * <hr>
 * Date created: April 6, 2020
 * <hr>
 * @author Shay Snyder
 */
public class ZorkDriver
{
    /**
	 * Serve as the backbone for the rest of the program
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    public static void main(String[] args)
    {
        // introduce the user
        intro();

        // start the game
        startGame();

        // roll the outro
        outro();
    } // END: main() method

    /**
	 * Introduce the user to Zork
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    private static void intro()
    {
        // use JOptionPane to welcome the user to the game
        JOptionPane.showMessageDialog(null,
                        "Welcome to my Zork game!",
                        "Zork",
                        JOptionPane.INFORMATION_MESSAGE);
    } // END: intro() method

    /**
	 * start the game by initializing the Zork class; this method will loop
     * through all necessary aspects of the game until said game is complete
     *
	 * <hr>
	 * Date created: April 6, 2020
	 */
    private static void startGame()
    {
        // create a new instance of the game
        Zork game = new Zork();

        /*
         * Create a String array representing the options the
         * user has during runtime
         *
         * move west = move the player to the cell on the left
         * move east = move the player to the cell on the right
         * help = show the player how to play
         * new game = start a new game
         * quit = terminate program
         */
        String [] options = {"quit",
                             "new game",
                             "move east",
                             "move west"};

        // continue playing the game until complete
        while(!game.isOver())
        {
            /*
             * Using JOptionPane, show the user the dungeon and
             * allow them to choose an option for how to proceed
             */
            int response = JOptionPane.showOptionDialog(null,
                                                        game.display(),
                                                        "Zork",
                                                        JOptionPane.DEFAULT_OPTION,
                                                        JOptionPane.INFORMATION_MESSAGE,
                                                        null,
                                                        options,
                                                        Integer.valueOf(0));

            /*
             * this switch is used to manage the various outputs
             * of the game's main interface, the JOptionPane.showOptionDialog
             *
             * -1 = user clicks 'X'
             * 0 = user selects 'quit'
             * 1 = user selects 'new game'
             * 2 = user selects 'move east'
             * 3 = user selects 'move west'
             *
             * if an unexpected response is given, simply return to the main
             * screen
             */
            switch (response)
            {
                /*
                 * Assuming the user clicks 'X', call confirmQuit()
                 */
                case -1:
                    confirmQuit();
                    break;

                /*
                 * Assuming the user selects 'quit', call confirmQuit()
                 */
                case 0:
                    confirmQuit();
                    break;

                /*
                 * Assuming the user selects 'new game', call confirmNewGame()
                 */
                case 1:
                    confirmNewGame();
                    break;

                /*
                 * Assuming the user selects "move east", call submitMove("east")
                 */
                case 2:
                    submitMove(game, "east");
                    break;

                /*
                 * Assuming the user selects "move west", call submitMove("west")
                 */
                case 3:
                    submitMove(game, "west");
                    break;
            } // END: switching through user responses
        } // END: while game is in progress
    } // END: startGame() method

    /**
     * make sure the user wants to quit the game
     *
     * <hr>
     * Date created: April 6, 2020
     */
    private static void confirmQuit()
    {
        /*
         * Using a JOptionPane.showConfirmDialog, make sure the user
         * wants to exit the program before terminating
         */
        int response = JOptionPane.showConfirmDialog(null,
                                                    "Are you sure you would like to exit the program?",
                                                    "Zork",
                                                    JOptionPane.YES_NO_OPTION);

        /*
         * Use an if statement to manage the various outputs of the
         * ConfirmDialog box
         *
         * if the user selects 'yes', quit the program
         * otherwise, return to the main screen
         */
        if (response == JOptionPane.YES_OPTION)
        {
            // call the outro
            outro();

            // terminate the program
            System.exit(0);
        } // END: if user selects yes
    } // END: confirmQuit() method

    /**
     * make sure the user wants to start a new game
     *
     * <hr>
     * Date created: April 6, 2020
     */
    private static void confirmNewGame()
    {
        /*
         * Using a JOptionPane.showConfirmDialog, make sure the user
         * wants to exit the program before terminating
         */
        int response = JOptionPane.showConfirmDialog(null,
                                                    "Are you sure you would like to start a new game?",
                                                    "Zork",
                                                    JOptionPane.YES_NO_OPTION);

        /*
         * Use an if statement to manage the various outputs of the
         * ConfirmDialog box
         *
         * if the user selects 'yes', start a new game
         * otherwise, return to the main screen
         */
        if (response == JOptionPane.YES_OPTION)
        {
            // start a new game
            startGame();
        } // END: if user selects yes
    } // END: confirmNewGame() method

    /**
     * submit the user's desired moves and display the resulting String
     *
     * <hr>
     * Date created: April 6, 2020
     */
    private static void submitMove(Zork game, String move)
    {
        JOptionPane.showMessageDialog(null,
                                      game.move(move),
                                      "Zork",
                                      JOptionPane.INFORMATION_MESSAGE);
    } // END: submitMove(Move move) method

    /**
     * display a message dialog box to the user thanking them for using our
     * program
     *
     * <hr>
     * Date created: April 6, 2020
     */
    private static void outro()
    {
        // display the outro prompt to the user via JOptionPane
        JOptionPane.showMessageDialog(null,
                                      "Thank you for playing Zork!",
                                      "Zork",
                                      JOptionPane.INFORMATION_MESSAGE);
    } // END: outro() method
} // END: ZorkDriver class