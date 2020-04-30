
package shapes;
/**
 * ---------------------------------------------------------------------------
 * File name: Comparable.java <br>
 * Project name: Shapes <br>
 * ---------------------------------------------------------------------------
 * Creator name and email: Don Bailes, bailes@etsu.edu <br>
 * Course-Section: CSCI1260<br>
 * Creation Date: April 4, 2018 <br>
 * ---------------------------------------------------------------------------
 */

/**
 * Any class that implements this interface has elements that are comparable
 * using the compareTo method declared in this interface<br>
 * 
 * <hr>
 * Date created: April 4, 2018<br>
 * <hr>
 * 
 * @author Don Bailes
 */
public interface Comparable <T>
{
	public int compareTo (T obj);
}
