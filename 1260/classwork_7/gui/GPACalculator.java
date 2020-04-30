/**
 * ---------------------------------------------------------------------------
 * File name: GPACalculator.java
 * Project name: Classwork 7: GUI Exercise
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 * Course:  CSCI 1260-288
 * Creation April 2, 2020
 * ---------------------------------------------------------------------------
 */

package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 * Represent a grade point average calculator via JFrames
 *
 * <hr>
 * Date created: April 2, 2020
 * <hr>
 * @author Shay Snyder
 */
public class GPACalculator
{
	// Main Window
	JFrame window;

	// Window Specifications & Constants
	final int WINDOW_HEIGHT = 180; // default height of 180 pixels
	final int WINDOW_WIDTH = 240; // default width of 240 pixels
	final int TEXT_AREA_WIDTH = 4; // set the default text field width

	// Fields
	JTextField creditsField, hoursField, gpaField;

	// Labels
	JLabel creditsLabel, hoursLabel, gpaLabel;

	// Buttons
	JButton calculateButton, quitButton;

	// Panels
	JPanel mainPanel, upperPanel, lowerPanel;

    public GPACalculator()
    {
        // Create a new JFramw object
		window = new JFrame("GPA Calculator");

		// set the window size to 240 x 180 as per the instructions
		window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

		// set the default close operation to exit
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// build the main panel
		buildMainPanel();

		// add the panel to the window
		window.add(mainPanel);

		// place the window in the center of the screen
		window.setLocationRelativeTo(null);

		// set the default button to calculate
		window.getRootPane().setDefaultButton(calculateButton);
		// show the window
		window.setVisible(true);
	} // END: default, no-arg constructor

	/**
	 * Build the 'Calculate' and 'Quit' buttons
	 *
	 * <hr>
	 * Date created: April 2, 2020
	 */
	private void buildButtons()
	{
		// create the Calculate and Quit buttons
		calculateButton = new JButton("Calculate");
		quitButton = new JButton("Quit");

		// add the action listeners
		calculateButton.addActionListener(new CalculateButtonListener());
		quitButton.addActionListener(new QuitButtonListener());
	} // END: buildButtons() method

	/**
	 * Build the credits, hours, and gpa labels
	 *
	 * <hr>
	 * Date created: April 2, 2020
	 */
	private void buildLabels()
	{
		// create the labels for Credits, Hours, & GPA
		creditsLabel = new JLabel("Credits Earned");
		hoursLabel = new JLabel("Hours Completed");
		gpaLabel = new JLabel("GPA");
	} // END: buildLabels() method

	/**
	 * Build the credist, hours, and gpa fields
	 *
	 * <hr>
	 * Date created: April 2, 2020
	 */
	private void buildFields()
	{
		// create the text fields for Credits, Hours, & GPA
		creditsField = new JTextField(TEXT_AREA_WIDTH);
		hoursField = new JTextField(TEXT_AREA_WIDTH);
		gpaField = new JTextField(TEXT_AREA_WIDTH);

		// justify all fields to the right
		creditsField.setHorizontalAlignment(JTextField.RIGHT);
		hoursField.setHorizontalAlignment(JTextField.RIGHT);
		gpaField.setHorizontalAlignment(JTextField.RIGHT);

		// implement the FocusListener
		creditsField.addFocusListener(new CreditsFocusListener());
		hoursField.addFocusListener(new HoursFocusListener());

		// make the gpa field uneditable
		gpaField.setEditable(false);
	} // END: buildFields() method

	/**
	 * build the main panel from the upper and lower panels
	 *
	 * <hr>
	 * Date created: April 2, 2020
	 */
	private void buildMainPanel()
	{
		// build the upper and lower panels
		buildLowerPanel();
		buildUpperPanel();

		// build the main panel using a border layout
		mainPanel = new JPanel(new BorderLayout());

		// add the upper panel to the center
		mainPanel.add(upperPanel, BorderLayout.CENTER);

		// add the lower panel to the south
		mainPanel.add(lowerPanel, BorderLayout.SOUTH);

		// add a empty boarder to the main panel
		mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 2, 5, 10));
	} // END: buildMainPanel() method

	/**
	 * build the lower panel from the JButtons
	 *
	 * <hr>
	 * Date created: April 2, 2020
	 */
	private void buildLowerPanel()
	{
		// build the buttons
		buildButtons();

		// build the lower panel using the Flow Layout and center them
		lowerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

		// add the buttons
		lowerPanel.add(calculateButton);
		lowerPanel.add(quitButton);
	} // END: buildLowerPanel() method

	/**
	 * build the upper panel from the JButtons
	 *
	 * <hr>
	 * Date created: April 2, 2020
	 */
	private void buildUpperPanel()
	{
		// build the labels and fields
		buildLabels();
		buildFields();

		// Build the upper panel by using a grid layout w/ 2 columns and 3 rows
		upperPanel = new JPanel(new GridLayout(3,2));

		// add the items in row 1
		upperPanel.add(creditsLabel);
		upperPanel.add(creditsField);

		// add the elements in row 2
		upperPanel.add(hoursLabel);
		upperPanel.add(hoursField);

		// add the elements to row 3
		upperPanel.add(gpaLabel);
		upperPanel.add(gpaField);
	} // END: buildUpperPanel() method

	/**
 	 * listen for the 'quit' button to be clicked
     *
     * <hr>
     * Date created: April 2, 2020
     * <hr>
     * @author Shay Snyder
     */
	private class QuitButtonListener implements ActionListener
	{
	    /**
	     * build the upper panel from the JButtons
	     *
	     * <hr>
	     * Date created: April 2, 2020
	     */
		public void actionPerformed(ActionEvent e)
		{
			// Thank the user for using the calculator
			JOptionPane.showMessageDialog(null,
										  "Thank you for using this GPA Calculator",
										  "Goodbye",
										  JOptionPane.INFORMATION_MESSAGE);

			// Terminate the program
			System.exit(0);
		} // END: actionPerformed() method
	} // END: QuitButtonListener class

	/**
 	 * listen for the 'calculate' button to be clicked
     *
     * <hr>
     * Date created: April 2, 2020
     * <hr>
     * @author Shay Snyder
    */
	private class CalculateButtonListener implements ActionListener
	{
		/**
	     * build the upper panel from the JButtons
	     *
	     * <hr>
	     * Date created: April 2, 2020
	     */
		public void actionPerformed(ActionEvent e)
		{
			// get the hours and credits from their labels
			String hoursString =  hoursField.getText().strip();
			String creditsString = creditsField.getText().strip();

			// determine if our data is numeric
			if (isNumeric(hoursString) && isNumeric(creditsString))
			{
				// parse our variables to double
				double hours = Double.parseDouble(hoursString);
				double credits = Double.parseDouble(creditsString);

				// if either number is negative, don't calculate gpa
				if(hours > 0 && credits >= 0)
				{
					// use the formula for gpa
					double gpa = credits / hours;

					// apply the gpa to the label and only show two decimal places
					gpaField.setText(String.format("%.2f", gpa));

					// return to the runtime environment
					return;
				} // END: if values are positivet
			} // END: if data is numeric

			// prompt the user of the error and clear the gpa field
			JOptionPane.showMessageDialog(null,
									 	 "Invalid Inputs. Please try again.",
										 "Input Error",
										 JOptionPane.ERROR_MESSAGE);

			// clear the gpa field
			gpaField.setText("");
		} // END: actionPerformed() method
	} // END: CalculateButtonListener class

	/**
 	 * listen for the 'calculate' button to be clicked
     *
     * <hr>
     * Date created: April 2, 2020
     * <hr>
     * @author Shay Snyder
	*/
	private class HoursFocusListener implements FocusListener
	{
		/**
	     * build the upper panel from the JButtons
	     *
	     * <hr>
	     * Date created: April 2, 2020
	     */
		public void focusGained(FocusEvent event)
		{
			// highlight the hours text field
			hoursField.selectAll();
		} // END: focusGained() method

		/**
	     * build the upper panel from the JButtons
	     *
	     * <hr>
	     * Date created: April 2, 2020
	     */
		public void focusLost(FocusEvent event)
		{
			// unselect the hours text field
			hoursField.getHighlighter().removeAllHighlights();
		} // END: focusLost() method
	} // END: TextFieldFocusListener class

		/**
 	 * listen for the 'calculate' button to be clicked
     *
     * <hr>
     * Date created: April 2, 2020
     * <hr>
     * @author Shay Snyder
	*/
	private class CreditsFocusListener implements FocusListener
	{
		/**
	     * build the upper panel from the JButtons
	     *
	     * <hr>
	     * Date created: April 2, 2020
	     */
		public void focusGained(FocusEvent event)
		{
			// Select all text upon focus
			creditsField.selectAll();
		} // END: focusGained() method

		/**
	     * build the upper panel from the JButtons
	     *
	     * <hr>
	     * Date created: April 2, 2020
	     */
		public void focusLost(FocusEvent event)
		{
			// unselect all text upon focus lost
			creditsField.getHighlighter().removeAllHighlights();
		} // END: focusLost() method
	} // END: TextFieldFocusListener class

	/**
	 * Determine if the argument String can be parsed to an int
	 *
	 * <hr>
	 * Date created: Feb 23, 2020
	 *
	 * <hr>
	 */
    private static boolean isNumeric(String number)
    {
        /*
         * Use a try catch to determine if the String can
         * be parsed to an integer
         */
        try
        {
            // try to parse the String
            Long.parseLong(number);
        } // END: try
        catch (Exception e)
        {
            // return false is the String fails to parse
            return false;
        } // END: catch

        /*
         * assuming no error what thrown, return true as the
         * String was successfully parsed to an int
         */
        return true;
    } // END: isNumeric() method


} // END: GPACalculator class
