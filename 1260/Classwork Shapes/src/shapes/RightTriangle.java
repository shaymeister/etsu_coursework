/**
 * ---------------------------------------------------------------------------
 * File name: RightTriangle.java Project name: Shapes
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder, snyderse2@etsu.edu
 * Course-Section: CSCI1260
 * Creation Date: March 26, 2020
 * ---------------------------------------------------------------------------
 */
package shapes;

/**
 * Represent a Right Triangle<br>
 * 
 * <hr>
 * Date created: March 26, 2020<br>
 * 
 * <hr>
 * 
 * @author Shay Snyder
 */
public class RightTriangle extends Triangle{

	/**
	 * arg constructor for the RightTriangle class<br>
	 * 
	 * <hr>
	 * Date created: March 26, 2020<br>
	 * <hr>
	 * 
	 * @author Shay Snyder
	 */
	public RightTriangle(String title, double side1, double side2, double side3) throws Exception
	{	
		// call the super constructor
		super(title, side1, side2, side3);
	} // END: RightTriangle

	/**
	 * calculate the area of a right triangle<br>
	 * 
	 * <hr>
	 * Date created: March 26, 2020<br>
	 * <hr>
	 * 
	 * @author Shay Snyder
	 */
	protected void calcArea()
	{
		super.area = (side2 * side3) / 2.0;
	} // END: calcArea() method
	
	
	/**
	 * return displayable information about the right triangle<br>
	 * 
	 * <hr>
	 * Date created: March 26, 2020<br>
	 * <hr>
	 * 
	 * @author Shay Snyder
	 */
	@Override
	public String toString()
	{
		System.out.print("Should display info");
		// return information about the shape
		return super.titleString();
	} // END: calcArea() method
} // END: RightTriangle class
