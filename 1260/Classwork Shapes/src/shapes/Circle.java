package shapes;
/**
 * ---------------------------------------------------------------------------
 * File name: Circle.java Project name: Shapes
 * ---------------------------------------------------------------------------
 * Creator's name and email: Don Bailes, bailes@etsu.edu
 * Course-Section: CSCI1260
 * Creation Date: April 4, 2018
 * ---------------------------------------------------------------------------
 */

/**
 * Circle class, inherits from Ellipse<br>
 * 
 * <hr>
 * Date created: April 4, 2018<br>
 * <hr>
 * 
 * @author Don Bailes
 */

public class Circle extends Ellipse
{

	/**
	 * Circle Constructor <br>
	 * 
	 * <hr>
	 * Date created: April 4, 2018 <br>
	 * 
	 * <hr>
	 * 
	 * @param titleIn - name of circle
	 */
	public Circle (String titleIn, double radiusIn)
	{
		super (titleIn, radiusIn, radiusIn);
	}

	/**
	 * Return displayable string for Circle object <br>
	 * 
	 * <hr>
	 * Date created: Sep 19, 2008 <br>
	 * Date last modified: Sep 19, 2008 <br>
	 * 
	 * <hr>
	 * 
	 * @return formatted object
	 * @see Shape#toString()
	 */
	@Override
	public String toString ( )
	{
		return titleString ( ) + "Radius:\t\t" + formatter.format (this.major);
	}

}
