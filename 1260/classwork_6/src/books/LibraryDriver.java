/**
 * ---------------------------------------------------------------------------
 * File name: LibraryDriver.java Project name: Files-Books
 * ---------------------------------------------------------------------------
 * Creator's name and email: Don Bailes, bailes@etsu.edu
 * Course-Section: CSCI1260
 * Creation Date: March 21, 2018
 * ---------------------------------------------------------------------------
 */

package books;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

/**
 * Demo the Book and Library classes<br>
 *
 * <hr>
 * Date created: March 21, 2018<br>
 * <hr>
 *
 * @author Don Bailes
 */
public class LibraryDriver
{
	private static Library	lib			= new Library ( );
	private static String	fileName	= "";								   // Save filename for later use

	/**
	 * Main method - fill library from input file; add books; save library<br>
	 *
	 * <hr>
	 * Date created: March 21, 2018 <br>
	 *
	 * <hr>
	 *
	 * @param args
	 *            - not used here
	 */
	public static void main (String [ ] args)
	{
		UIManager.put ("OptionPane.messageFont", new FontUIResource (new Font ("Arial", Font.PLAIN,
						12)));
		JOptionPane.showMessageDialog (null, "Welcome to the Library Manager.", "Library Manager",
			JOptionPane.INFORMATION_MESSAGE);
		inputFile ( );
		displayLibrary ( );
		addBooks ( );

		JOptionPane.showMessageDialog (null, "Thank you for using the Library Manager.",
			"Goodbye Now", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Save the file back to its original position <br>
	 *
	 * <hr>
	 * Date created: March 21, 2018 <br>
	 *
	 * <hr>
	 */
	private static void saveFile ( )
	{
		// attempt to save the file
		try
		{
			// create a new print writer
			PrintWriter writer = new PrintWriter("/TextFiles/BookFile.txt");
			
			// loop through every book in the library
			for(int i = 0; i < lib.getNumBooks ( ); i++)
			{
				writer.println(lib.getBook(i).getTitle ( ) + "," +
							   lib.getBook(i).getAuthor ( ) + "," +
							   lib.getBook(i).getPrice ( ));
			}
			
			writer.close ( );
		}
		catch (Exception e)
		{
			System.out.println("Unable to the save the library.");
		}
	}

	/**
	 * Allow the user to try to add any number of books to the library; this
	 * will result in an exception if one tries to add a book beyond the library
	 * size <br>
	 *
	 * <hr>
	 * Date created: March 21, 2018 <br>
	 *
	 * <hr>
	 * returns - number of books added
	 */
	private static void addBooks ( )
	{
		// counter for the number of books added
		int booksAdded = 0;

		// allow the user to enter as many books as they need
		while(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog (null, "Would you like to add another book to the library?"))
		{			
			String title = "";
			String author = "";
			Double price = -1.0;
		
			// repeat until a valid input is reached
			while(title == "")
			{
				// prompt the user to enter the title
				title = JOptionPane.showInputDialog ("What is the book's title?");
				
				// assume that if the user enters a null value, they don't want to add a book
				if (title == null)
				{
					// display the library
					displayLibrary();
				}
			} // END: looping until a valid input is reached
				
			// repeat until a valid input is reached
			while(author == null || author == "")
			{
				// prompt the user to enter the author
				author = JOptionPane.showInputDialog ("Who is the book's author?");
				
				// assume that if the user enters a null value, they don't want to add a book
				if (title == null)
				{
					// display the library
					displayLibrary();
				}// prompt the user to enter the authors name
			}
			
			// repeat until a valid input is reached
			while(price < 0)
			{
				// prompt the user to enter the book's price
				try
				{
					price = Double.parseDouble (JOptionPane.showInputDialog ("What is the book's price?"));
				}
				catch(Exception e)
				{
					System.out.println("Invalid Input");
					price = -1.0;
				} // END: catching error
			} // END: looping until valid input is reached
				
			// create a new book
			Book book = new Book();
				
			// set the book's author
			book.setAuthor (author);
		
			// set the book's title
			book.setTitle (title);
				
			// set the book's price
			book.setPrice (price);
				
			// attempt to add the book to the library; catch any errors
			try
			{
				lib.addBook (book);
			}
			catch(Exception e)
			{
				System.out.println("Error: " + e.getMessage ( ));
			}
			
			// iterate the books added counter
			booksAdded++;
			
			// save the file
			saveFile();
		} // END: looping until all desired books have been added
			
		if (booksAdded > 0)
		{
			JOptionPane.showMessageDialog (null, booksAdded + " books added", "Books Added",
				JOptionPane.INFORMATION_MESSAGE);

			displayLibrary ( );
			saveFile ( );
		}
	}

	/**
	 * Get the filename from the user and try to open it (JFileChooser); read contents and
	 * build library; handle any exceptions that occur. Save the filename and path for
	 * later use by the saveFile method<br>
	 *
	 * <hr>
	 * Date created: March 21, 2018 <br>
	 *
	 * <hr>
	 */
	private static void inputFile ( )
	{
		// Create a scanner object called 'input' and initialize to null
		Scanner input = null;

		// create a new instance of the JFileChooser class
		JFileChooser fileChooser = new JFileChooser("TextFiles"); // start in the TextFiles subfolder

		// prompt the user to select the desired file
		int result = fileChooser.showOpenDialog(null);
		System.out.println("Should have closed open dialog");

		// attempt to import the file
		try
		{
			// if they don't cancel the program, get the file's path
			if(result != JFileChooser.CANCEL_OPTION)
			{
				// get the desired file
				File file = fileChooser.getSelectedFile();
				
				// add the file to the Scanner
				input = new Scanner(file);
			}
			else
			{
				System.exit(0); // terminate the program if the user presses cancel
			}
		}
		// Catch any errors that may arise during runtime
		catch (IOException e)
		{
			// display the error message
			System.out.println("Error: " + e.getMessage());
		}

		// loop through every line within the file
		while(input.hasNext())
		{
			// read the given line
			String line = input.nextLine();
			
			// split the given String into a String array
			String[] lineSplit = line.split(",");
			
			// create a new Book
			Book book = new Book();
			
			// set the book's title from the array
			book.setTitle (lineSplit[0]);
			
			// set the book's author from the array
			book.setAuthor (lineSplit[1]);
			
			// set the book's price from the array
			book.setPrice (Double.parseDouble (lineSplit[2]));
			
			// attempt to add the book to the library; catch any errors
			try
			{
				lib.addBook (book);
			}
			catch(Exception e)
			{
				System.out.println("Error: " + e.getMessage ( ));
			}
		} // END: looping through all lines 
	} // END: input file method

	/**
	 * Display all books in the library <br>
	 *
	 * <hr>
	 * Date created: March 21, 2018 <br>
	 *
	 * <hr>
	 */
	private static void displayLibrary ( )
	{
		JOptionPane.showMessageDialog (null, "There are " + lib.getNumBooks ( ) + " books in the library.",
			"Library Size", JOptionPane.INFORMATION_MESSAGE);
		System.out.println ("\n\n\nLibrary Contents\n----------------\n");
		System.out.println (lib);
		System.out.println ("\n\n");
	}
}
