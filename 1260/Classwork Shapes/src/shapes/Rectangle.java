/**
 * ---------------------------------------------------------------------------
 * File name: Rectangle.java Project name: Shapes
 * ---------------------------------------------------------------------------
 * Creator's name and email: Shay Snyder
 * Course-Section: CSCI1260
 * Creation Date: March 26, 2020
 * ---------------------------------------------------------------------------
 */
package shapes;

/**
 * Represent a rectangle shape<br>
 * 
 * <hr>
 * Date created: March 26, 2020<br>
 * Date last modified: March 26, 2020<br>
 * <hr>
 * 
 * @author Shay Snyder
 */
public class Rectangle extends Shape
{
	protected double width; // to hold the rectangle's width
	protected double height; // to hold the rectangle's height

	/**
	 * arg-constructor for the Rectangle class
	 * 
	 * <hr>
	 * Date Created: March 26, 2020
	 * 
	 * <hr>
	 * 
	 * @param title to hold the shape's title
	 * @param width to hold the shape's width
	 * @param height to hold the shape's height
	 */
	public Rectangle(String title, double width, double height)
	{
		// call the super constructor
		super(title);
		
		// assign the rectangle's dimensions
		this.width = width;
		this.height = height;
		
		calcArea();
		calcPerimeter();
	} // END: arg-constructor
	
	/**
	 * Calculate rectangle area
	 * 
	 * <hr>
	 * Date created: March 26, 2020
	 * 
	 * <hr>
	 * 
	 * @see Shape#calcArea()
	 */
	@Override
	protected void calcArea()
	{
		// calculate rectangle area
		super.area = this.width * this.height;
	} // END: calcArea()
	
	/**
	 * Calculate rectangle perimeter
	 * 
	 * <hr>
	 * Date Created: March 26, 2020
	 * 
	 * @see Shape#calcPerimeter()
	 */
	@Override
	protected void calcPerimeter()
	{
		super.perimeter = (2 * this.width) + (2 * this.height);
	} // END: calc perimeter
	
	/**
	 * Return a displayable string for the Rectangle Object<br>
	 * 
	 * <br>
	 * Date Created: March 26, 2020
	 * 
	 * <hr>
	 * 
	 * @see Shape#toString
	 */
	@Override
	public String toString()
	{
		return titleString();
	} // END: toString() method
	
} // END: Rectangle Class
