package shapes;
/**
 * ---------------------------------------------------------------------------
 * File name: Triangle.java Project name: Shapes
 * ---------------------------------------------------------------------------
 * Creator's name and email: Don Bailes, bailes@etsu.edu
 * Course-Section: CSCI1260
 * Creation Date: April 4, 2018
 * ---------------------------------------------------------------------------
 */

import java.util.ArrayList;

/**
 * Triangle class<br>
 * 
 * <hr>
 * Date created: April 4, 2018<br>
 * <hr>
 * 
 * @author Don Bailes
 */
public class Triangle extends Shape
{
	protected double	side1;
	protected double	side2;
	protected double	side3;

	/**
	 * Constructor with parameters for the sides <br>
	 * 
	 * <hr>
	 * Date created: April 4, 2018 <br>
	 * 
	 * <hr>
	 * 
	 * @param titleIn - Triangle name
	 * @param side1 - first side of triangle
	 * @param side2 - second side of triangle
	 * @param side3 - third side of triangle
	 */
	public Triangle (String titleIn, double side1, double side2, double side3) throws Exception
	{
		super (titleIn);
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
		checkSides ( );
		calcArea ( );
		calcPerimeter ( );
	}

	/**
	 * Validate the lengths of the sides are OK; length of longest
	 * side must be shorter than the sum of the other two;
	 * throws Exception otherwise;
	 *
	 * <hr>
	 * Date created: Mar 29, 2017
	 *
	 * <hr>
	 */
	private void checkSides ( ) throws Exception
	{
		ArrayList <Double> sides = new ArrayList <> ( );
		sides.add (side1);
		sides.add (side2);
		sides.add (side3);
		sides.sort (null);
		if (sides.get (2) >= sides.get (0) + sides.get (1))
			throw new Exception (
							"Sides are not valid - the longest side must be shorter than the sum of the other two sides");
	}

	/*
	 * (non-Javadoc)
	 * @see Shape#calcArea()
	 */
	@Override
	protected void calcArea ( )
	{
		double ds;
		ds = (side1 + side2 + side3) / 2;
		area = Math.sqrt (ds * (ds - side1) * (ds - side2) * (ds - side3));
	}

	/*
	 * (non-Javadoc)
	 * @see Shape#calcPerimeter()
	 */
	@Override
	protected void calcPerimeter ( )
	{
		this.perimeter = side1 + side2 + side3;
	}

	/*
	 * (non-Javadoc)
	 * @see Shape#toString()
	 */
	@Override
	public String toString ( )
	{
		return titleString ( ) + "Side1:\t\t" + formatter.format (side1) + "\nSide2:\t\t" + formatter.format (side2) +
						"\nSide3:\t\t" + formatter.format (side3);
	}
}
