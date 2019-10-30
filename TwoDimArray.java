import java.util.*;
// take the grades of three students and make various calculations

public class TwoDimArray
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        int[][] scores = new int[3][3];

        int classSum = 0;

        // fill the array
        for(int row = 0; row < scores.length; row++)
        {
            int sum = 0;
            for(int column = 0; column < scores[row].length; column++)
            {
                System.out.print("Student " + (row + 1) + " quiz " + (column + 1) + ": ");
                scores[row][column] = keyboard.nextInt();
                sum += scores[row][column];
                classSum += scores[row][column];
            }
        }

        // calculate the students average
        for(int row = 0; row < scores.length; row++)
        {
            int sum = 0;
            for(int column = 0; column < scores[row].length; column++)
            {
                sum += scores[row][column];
                classSum += scores[row][column];
            }

            System.out.println("Student " + (row + 1) + " quiz average: " + (((double)sum)/(scores[row].length)));
            System.out.println("Overall Avg: " + (classSum/((scores.length)*(scores[0].length))));
        }

        // calculate the average per quiz
        for(int column = 0; column < scores[0].length; column++)
        {
            int sum = 0;
            for(int row = 0; row < scores.length; row++)
            {
                sum += scores[row][column];
            }
            System.out.println("Quiz " + (column + 1) + " avg: " + ((double)sum/scores[0].length));
        }    
    }
}