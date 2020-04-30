package shapes;
/**
 * ---------------------------------------------------------------------------
 * File name: Shape.java Project name: Shapes
 * ---------------------------------------------------------------------------
 * Creator's name and email: Don Bailes, bailes@etsu.edu
 * Course-Section: CSCI1260
 * Creation Date: April 4, 2018
 * ---------------------------------------------------------------------------
 */

/**
 * Enter type purpose here<br>
 * 
 * <hr>
 * Date created: April 4, 2018<br>
 * <hr>
 * 
 * @author Don Bailes
 */

import java.text.DecimalFormat;

public abstract class Shape implements Comparable <Shape>
{
	protected String		title;
	protected double		area;
	protected double		perimeter;
	protected DecimalFormat	formatter;

	/**
	 * Constructor with title parameter <br>
	 * 
	 * <hr>
	 * Date created: Sep 19, 2008 <br>
	 * Date last modified: Sep 19, 2008 <br>
	 * 
	 * <hr>
	 * 
	 * @param titleIn
	 */
	public Shape (String titleIn)
	{
		this.title = titleIn;
		formatter = new DecimalFormat ("#0.00");
	}

	/**
	 * @return area
	 */
	public double getArea ( )
	{
		return this.area;
	}

	/**
	 * @return perimeter
	 */
	public double getPerimeter ( )
	{
		return this.perimeter;
	}

	/**
	 * Getter for the title <br>
	 * 
	 * <hr>
	 * Date created: Feb 24, 2009 <br>
	 * Date last modified: Feb 24, 2009 <br>
	 * 
	 * <hr>
	 * 
	 * @return the name of the shape
	 */
	public String getTitle ( )
	{
		return title;
	}

	/**
	 * Compare two shape objects based on Area <br>
	 * 
	 * <hr>
	 * Date created: Feb 22, 2009 <br>
	 * Date last modified: Feb 22, 2009 <br>
	 * 
	 * <hr>
	 * 
	 * @param rhs the shape to be compared (right-hand side)
	 * @return integer that indicates whether the current shape
	 *         has a larger or smaller area vs. rhs
	 * @see Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo (Shape rhs)
	{
		if (this.getArea ( ) == rhs.getArea ( ))
			return 0;
		else if (this.getArea ( ) > rhs.getArea ( ))
			return 1;
		else
			return -1;
	}

	/**
	 * Format the title, area, and perimeter of this shape for display <br>
	 * 
	 * <hr>
	 * Date created: April 4, 2018<br>
	 * Date last modified: April 4, 2018<br>
	 * 
	 * <hr>
	 */
	protected final String titleString ( )
	{
		return "\n\nObject Type:\t" + this.getClass ( ).getSimpleName ( ) + "\nTitle:\t\t" + title + "\nArea:\t\t" +
						formatter.format (area) + "\nPerimeter:\t" + formatter.format (perimeter) + "\n";
	}

	protected abstract void calcArea ( );

	protected abstract void calcPerimeter ( );

	@Override
	public abstract String toString ( );
}
