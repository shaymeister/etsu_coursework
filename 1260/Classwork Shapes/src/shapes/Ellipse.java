package shapes;
/**
 * ---------------------------------------------------------------------------
 * File name: Ellipse.java Project name: Shapes
 * ---------------------------------------------------------------------------
 * Creator's name and email: Don Bailes, bailes@etsu.edu
 * Course-Section: CSCI1260
 * Creation Date: April 4, 2018
 * Date of Last Modification: April 4, 2018
 * ---------------------------------------------------------------------------
 */

/**
 * Represent an Ellipse<br>
 * 
 * <hr>
 * Date created: April 4, 2018<br>
 * Date last modified: April 4, 2018<br>
 * <hr>
 * 
 * @author Don Bailes
 */

/**
 * Ellipse class, inherits from Shape<br>
 * 
 * <hr>
 * Date created: April 4, 2018<br>
 * <hr>
 * 
 * @author Don Bailes
 */
public class Ellipse extends Shape
{
	protected double	major;
	protected double	minor;

	/**
	 * Constructor initializes fields and determines area and perimeter <br>
	 * 
	 * <hr>
	 * Date created: April 4, 2018 <br>
	 * 
	 * <hr>
	 * 
	 * @param titleIn
	 */
	public Ellipse (String titleIn, double majorIn, double minorIn)
	{
		super (titleIn);
		this.major = majorIn;
		this.minor = minorIn;

		calcArea ( );
		calcPerimeter ( );
	}

	/**
	 * Calculate ellipse area <br>
	 * 
	 * <hr>
	 * Date created: Sep 11, 2008 <br>
	 * Date last modified: Sep 11, 2008 <br>
	 * 
	 * <hr>
	 * 
	 * @see Shape#calcArea()
	 */
	@Override
	protected void calcArea ( )
	{
		area = Math.PI * (major * minor);
	}

	/**
	 * Calculate approximate circumference <br>
	 * 
	 * <hr>
	 * Date created: Sep 11, 2008 <br>
	 * Date last modified: Sep 11, 2008 <br>
	 * 
	 * <hr>
	 * 
	 * @see Shape#calcPerimeter()
	 */
	@Override
	protected void calcPerimeter ( )
	{
		perimeter = 2 * Math.PI * Math.sqrt ( (major * major + minor * minor) / 2);
	}

	/**
	 * Return displayable string for Ellipse object <br>
	 * 
	 * <hr>
	 * Date created: Sep 11, 2008 <br>
	 * Date last modified: Sep 11, 2008 <br>
	 * 
	 * <hr>
	 * 
	 * @see Shape#toString()
	 */
	@Override
	public String toString ( )
	{
		return titleString ( ) + "Major radius:\t" + formatter.format (this.major) + "\nMinor radius:\t" +
						formatter.format (this.minor);
	}
}
