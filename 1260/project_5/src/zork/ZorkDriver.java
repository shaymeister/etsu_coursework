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
        // Create a String to introduce the user to the game
        String introPrompt = "\nWelcome to the Zork game!"
                           + "\n"
                           + "\n-------------------------------------------------------------------"
                           + "\nIn this game, there is a dungeon containing 5 to 10 cells. The"
                           + "\nplayer begins in the west-most cell and tries to to get the"
                           + "\neast-most cell which contains the dungeon exit. A successful exit"
                           + "\nfrom the final cell wins the game. Along the way, each cell may"
                           + "\nhave a monster that must be defeated. One cell contains a weapon"
                           + "\nwhich may be used on the monster, if any, in that cell."
                           + "\n"
                           + "\nThe game continues until the player is defeated by a monster or"
                           + "\nuntil the player successfully exits the eastmost cell. In each"
                           + "\ncell, a player may move one cell to the east or one cell to the"
                           + "\nwest, if there is an exit in that direction."
                           + "\n"
                           + "\nTypes of weapons and their damage: Hand (3), Stick 'St' (4), Knife 'Kn' (5),"
                           + "\n\tSword 'Sw' (6), Gun 'Gu' (7), Laser 'La' (8)"
                           + "\n"
                           + "\nTypes of monsters and their damage: Zombie 'Zo' (3), Skeleton 'Sk' (5),"
                           + "\n\tCreeper 'Cr' (6)"
                           + "\n-------------------------------------------------------------------";

        // use JOptionPane to welcome the user to the game
        JOptionPane.showMessageDialog(null,
                        introPrompt,
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

        // assuming the game is over, ask the user if they would like to play again
        /*
         * Using a JOptionPane.showConfirmDialog, asking the user if they want
         * to play again
         */
        int response = JOptionPane.showConfirmDialog(null,
                                                    "Would you like to play again?",
                                                    "Zork",
                                                    JOptionPane.YES_NO_OPTION);

        /*
         * Use an if statement to manage the various outputs of the
         * ConfirmDialog box
         *
         * if the user selects 'yes', restart the game
         * otherwise, terminate the program.
         */
        if (response == JOptionPane.YES_OPTION)
        {
            // restart the game
            startGame();
        } // END: if user selects yes
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
         * otherwise, terminate
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