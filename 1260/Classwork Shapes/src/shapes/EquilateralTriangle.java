/**
 * 
 */
package shapes;

/**
 * Create a class to represent an equilateral triangle<br>
 * 
 * <hr>
 * Date created: March 26, 2020<br>
 *
 * <hr>
 * 
 * @author Shay Snyder
 */
public class EquilateralTriangle extends Triangle
{
	/**
	 * arg constructor for the EquilateralTriangle class<br>
	 * 
	 * <hr>
	 * Date created: March 26, 2020<br>
	 * <hr>
	 * 
	 * @author Shay Snyder
	 */
	public EquilateralTriangle(String title, double side) throws Exception
	{	
		// call the super constructor
		super(title, side, side, side);
	} // END: RightTriangle

	/**
	 * calculate the area of a equilateral triangle<br>
	 * 
	 * <hr>
	 * Date created: March 26, 2020<br>
	 * <hr>
	 * 
	 * @author Shay Snyder
	 */
	protected void calcArea()
	{
		super.area = (Math.sqrt(3) / 4) * (super.side1 * super.side1);
	} // END: calcArea() method
	
	
	/**
	 * return displayable information about the equilateral triangle<br>
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
}
