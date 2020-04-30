package shapes;
/**
 * ---------------------------------------------------------------------------
 * File name: ShapesDriver.java Project name: Shapes
 * ---------------------------------------------------------------------------
 * Creator's name and email: Don Bailes, bailes@etsu.edu
 * Course-Section: CSCI1260
 * Creation Date: April 4, 2018
 * ---------------------------------------------------------------------------
 */

/**
 * Test the Shape class and its derived classes<br>
 * 
 * <hr>
 * Date created: April 4, 2018<br>
 * Date last modified: April 4, 2018<br>
 * <hr>
 * 
 * @author Don Bailes
 */
import java.util.ArrayList;
import java.util.Scanner;
import util.Menu;

/**
 * Driver demonstrates the use of late binding (polymorphism) in an inheritance
 * hierarchy.
 * 
 * Also demos a sort routine that can sort Comparable (interface) shapes
 * 
 * Uses a Menu class and some other utility methods from a package named
 * myUtilities.<br>
 * 
 * <hr>
 * Date created: Oct 3, 2008<br>
 * Date last modified: Oct 3, 2008<br>
 * <hr>
 * 
 * @author Don Bailes
 */
public class ShapesDriver
{
	private static Scanner				kb			= new Scanner (System.in);
	private static int					statCount	= 1;
	private static ArrayList <Shape>	alShapes	= new ArrayList <> ( );					// Base-class

	/**
	 * Driver to demo the Shape inheritance hierarchy <br>
	 * 
	 * <hr>
	 * Date created: April 4, 2018<br>
	 * 
	 * <hr>
	 * 
	 * @param args
	 * @throws Exception 
	 */
	public static void main (String [ ] args)
	{
		String title;
		int choice;

		double d, h, w, majorRadius, minorRadius;

		Menu mnuMain = new Menu ("Shapes Menu");

		mnuMain.addChoice ("Create a Rectangle");
		mnuMain.addChoice ("Create a Square");
		mnuMain.addChoice ("Create an Ellipse");
		mnuMain.addChoice ("Create a Circle");
		mnuMain.addChoice ("Create a Triangle");
		mnuMain.addChoice ("Create a Right Triangle");
		mnuMain.addChoice ("Create an Equilateral Triangle");
		mnuMain.addChoice ("Display all created shapes");
		mnuMain.addChoice ("Sort all shapes by area");
		mnuMain.addChoice ("Display item with a given title");
		mnuMain.addChoice ("Exit");

		while ( (choice = mnuMain.getChoice ( )) != 11)
		{

			switch (choice)
			{
				case 1:
					title = getTitle ("Rectangle");
					System.out.println ("What is the width of the rectangle?");
					try // allow the user to enter the width of their rectangle
					{
						w = kb.nextDouble ( );
					} // END: try
					catch (Exception e) // if an error occurs, simply break away from the switch
					{
						break;
					} // END: catch
					System.out.println ("What is the length of the rectangle?");
					try // allow the user to enter the width of their rectangle
					{
						h = kb.nextDouble ( );
					} // END: try
					catch (Exception e) // if an error occurs, simply break away from the switch
					{
						break;
					} // END: catch
					alShapes.add (new Rectangle (title, w, h));
					break;

				case 2:
					title = getTitle ("Square");
					System.out.println ("What is the length of the square's side?");
					try // Allow the user to enter the length of their square
					{
						w = kb.nextDouble ( );
					} // END: try
					catch (Exception e) // If an error is thrown, simply break away from the switch
					{
						break;
					} // END: catch
					alShapes.add (new Square (title, w));
					break;

				case 3:
					title = getTitle ("Ellipse");
					System.out.println ("What is the length of the major axis?");
					try // allow the user to enter the length of the major axis
					{
						majorRadius = kb.nextDouble ( );
					} // END: try
					catch (Exception e) // If an error is thrown, simply break away from the switch
					{
						break;
					} // END: catch
					System.out.println ("What is the length of the minor axis?");
					try // allow the user to enter the length of the minor axis
					{
						minorRadius = kb.nextDouble ( );
					} // END: try
					catch (Exception e) // If an error is thrown, simply break away from the switch
					{
						break;
					} // END: catch
					alShapes.add (new Ellipse (title, majorRadius, minorRadius));
					break;

				case 4:
					title = getTitle ("Circle");
					System.out.println ("What is the radius?");
					try // allow the user to enter the radius of the circle
					{
						majorRadius = kb.nextDouble ( );
					} // END: try
					catch (Exception e) // If an error is thrown, simply break away from the loop
					{
						break;
					} // END: catch
					alShapes.add (new Circle (title, majorRadius));
					break;

				case 5:
					title = getTitle ("Triangle");
					System.out.println ("What is the length of the base?");
					try // allow the use to enter the length of the base
					{
						w = kb.nextDouble ( );
					} // END: try
					catch (Exception e) // if an error is thrown, simply break away from the loop
					{
						break;
					} // END: catch
					System.out.println ("What is the length of one side?");
					try // allow the user to enter the length of one side
					{
						h = kb.nextDouble ( );
					} // END: try
					catch (Exception e) // If an error us thrown, simply break away from the loop
					{
						break;
					} // END: catch
					System.out.println ("What is the length of the other side?");
					try // allow the user to enter the length of the last side
					{
						d = kb.nextDouble ( );
					} // END: try
					catch (Exception e)
					{
						break;
					} // END: catch
					// attempt to create a new triangle with the argumented lengths
					try
					{
						alShapes.add (new Triangle (title, w, h, d));
					} // END: attempting to 
					// catch any exceptions that may arise
					catch (Exception e)
					{
						// inform the user that their triangle must conform to pathagorean theorem
						System.out.println("INVALID: your triangle must conform with the Pathagorean Theorem");
					} // END: error catching
					break;

				case 6:
					title = getTitle ("Right Triangle");
					System.out.println ("What is the length of the base?");
					try // allow the user to enter the length of the base
					{
						w = kb.nextDouble ( );
					} // END: try
					catch (Exception e) // If an error is thrown, simple break away from the switch
					{
						break;
					} // END: catch
					System.out.println ("What is the height of the right triangle?");
					try // Allow the user to enter the height of the triangle
					{
						h = kb.nextDouble ( );
					} // END: try
					catch (Exception e) // If an error is thrown, simple break away from the switch
					{
						break;
					} // END: catch
					// attempt to create a triangle from the argumented information
					try
					{
						alShapes.add (new RightTriangle (title, Math.sqrt (w * w + h * h), w, h));
					} // END: try
					catch (Exception e) // Catch any errors that may arise during initialization
					{
						System.out.println("An unexpected error has occured. Please try again.");
						break;
					} // END: catch
					break;

				case 7:
					title = getTitle ("Equilateral Triangle");
					System.out.println ("What is the length of any side?");
					try // allow the user to enter the length of a side
					{
						w = kb.nextDouble ( );
					} // END: try
					catch (Exception e) // If an error is thrown, simple break away from the switch
					{
						System.out.println("An unexpected error has occured. Please try again.");
						break;
					} // END: catch
					try // attempt to create an Equilateral Triangle
					{
						alShapes.add (new EquilateralTriangle (title, w));
					} // END: try
					catch (Exception e) // catch any unexpected errors
					{
						System.out.println("An unexpected error has occured. Please try again.");
						break;
					} // END: catch
					break;

				case 8:
					for (Shape s : alShapes)
						System.out.println (s); // Display shape - late binding
					// Util.pressEnter ( );
					break;

				case 9:
					sort (alShapes);
					break;

				case 10:
					System.out.println ("What is the title of the shape to display?");
					kb.nextLine ( );
					try // allow the user to enter the title of a shape
					{
						title = kb.nextLine ( );
					} // END: try
					catch (Exception e) // If an error is thrown, simply break away from the loop
					{
						break;
					} // END: catch
					Shape s = find (title);
					if (s == null)
						System.out.println ("No item has that title");
					else
						System.out.println (s);
					// Util.pressEnter ( );
					break;

			} // end of switch

		} // end of while

		System.out.println ("\n\nGoodbye now.  I hope you enjoyed this program.");

	} // end of main

	/**
	 * Input the title for this object <br>
	 * 
	 * <hr>
	 * Date created: Feb 24, 2009 <br>
	 * Date last modified: Feb 24, 2009 <br>
	 * 
	 * <hr>
	 * 
	 * @param str
	 * @return
	 */
	private static String getTitle (String str)
	{
		String strIn;
		System.out.println ("What title would you like to give this " + str + " object?");
		if (statCount++ > 1)
			kb.nextLine ( );
		strIn = kb.nextLine ( );
		return strIn;
	} // end of getTitle

	/**
	 * Demo value of an interface using a Sort routine <br>
	 * 
	 * <hr>
	 * Date created: Feb 22, 2009 <br>
	 * Date last modified: Feb 22, 2009 <br>
	 * 
	 * <hr>
	 * 
	 * @param ar
	 */
	private static void sort (ArrayList <Shape> ar)
	{
		Shape temp;

		boolean sorted = false;

		for (int pass = 1; pass < ar.size ( ) && !sorted; pass++ )
		{
			sorted = true;
			for (int n = 0; n < ar.size ( ) - pass; n++ )
				if (ar.get (n).compareTo (ar.get (n + 1)) > 0)
				{
					temp = ar.get (n);
					ar.set (n, ar.get (n + 1));
					ar.set (n + 1, temp);
					sorted = false;
				}
		}
	}

	/**
	 * Return the object with the specified title unless there is not one, in
	 * which case the method returns a null object<br>
	 * 
	 * <hr>
	 * Date created: Feb 24, 2009 <br>
	 * Date last modified: Feb 24, 2009 <br>
	 * 
	 * <hr>
	 * 
	 * @param id
	 * @return
	 */
	private static Shape find (String id)
	{
		for (int n = 0; n < alShapes.size ( ); n++ )
		{
			if (alShapes.get (n).getTitle ( ).equalsIgnoreCase (id))
				return (alShapes.get (n));
		}
		return null;
	}
}
