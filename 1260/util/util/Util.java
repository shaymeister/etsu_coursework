package util;

import java.util.Scanner;

/**
 * Class contains several static methods that provide utility functionality for
 * tasks such as Press Key to Continue, Skip n blank lines, and a
 * pseudo-ClearScreen.<br>
 * 
 * <hr>
 * Date created: June 1, 2017<br>
 * <hr>
 * 
 * @author Don Bailes
 */

/**
 * Set of static utility methods
 * 
 * <hr>
 * Date created: June 1, 2017
 * <hr>
 * 
 * @author Don Bailes
 */
public class Util
{
	private static Scanner kb = new Scanner (System.in);

	/**
	 * Press Enter key to continue <br>
	 * 
	 * <hr>
	 * Date created: June 1, 2017 <br>
	 * 
	 * <hr>
	 */
	public static void pressEnter ( )
	{
		System.out.println ("\n\n\t\tPress the enter key to continue");
		kb.nextLine ( );
	} // end Press Enter

	/**
	 * Press Enter key to continue<br>
	 * 
	 * <hr>
	 * Date created: June 1, 2017 <br>
	 * 
	 * <hr>
	 * 
	 * @param to
	 */
	public static void pressEnter (String to)
	{
		System.out.println ("\n\n\t\tPress the enter key to " + to);
		kb.nextLine ( );
	} // end Press Enter to

	/**
	 * Skip n lines <br>
	 * 
	 * <hr>
	 * Date created: June 1, 2017 <br>
	 * 
	 * <hr>
	 * 
	 * @param n
	 */
	public static void skip (int n)
	{
		for (int i = 0; i < n; i++ )
			System.out.println (" ");
	} // end skip

	/**
	 * Simulate a clear screen by writing blank lines <br>
	 * 
	 * <hr>
	 * Date created: June 1, 2017 <br>
	 * 
	 * <hr>
	 */
	public static void clrscr ( )
	{
		for (int i = 1; i < 45; i++ )
		{
			System.out.println ( );
		}
	} // end clrscr

	/**
	 * Right justify str in n columns by adding leading spaces if needed <br>
	 * 
	 * <hr>
	 * Date created: June 1, 2017 <br>
	 * 
	 * <hr>
	 * 
	 * @param str
	 *            - the string to be right justified
	 * @param n
	 *            - the width of the resulting field
	 * @return - the right-justified field in n columns
	 */
	public static String right (String str, int n)
	{
		String strS = str;
		if (str.length ( ) < n)
		{
			for (int i = 0; i < n - str.length ( ); i++ )
				strS = " " + strS;
		}
		return strS;
	}
} // end Util
