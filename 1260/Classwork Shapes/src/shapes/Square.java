/**
 * ---------------------------------------------------------------------------
 * File name: Square.java Project name: Shapes
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder
 * Course-Section: CSCI1260
 * Creation Date: March 26, 2020
 * ---------------------------------------------------------------------------
 */
package shapes;

/**
 * Represent a square shape<br>
 * 
 * <hr>
 * Date created: March 26, 2020<br>
 * Date last modified: March 26, 2020<br>
 * <hr>
 * 
 * @author Shay Snyder
 */
public class Square extends Rectangle {

	/**
	 *   arg-constructor for the Square class
	 *   
	 *   <hr>
	 *   Date Created: March 26, 2020
	 *   
	 *   <hr>
	 *   
	 *   @param title // to hold the shape's title
	 *   @param width // to hold the shape's length
	 */
	public Square(String title, double width)
	{
		// create a new square using the super constructor
		super(title, width, width);
	} // END: arg-constructor
} // END: Square class