import java.util.*;

public class Search
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("How long would you like your array? ");
        int arrayLength = keyboard.nextInt();
        int location = -1;
        System.out.print("What number are you searching for? ");
        int desiredNumber = keyboard.nextInt();

        int[] array = new int[arrayLength];

        for (int index = 0; index < array.length; index++)
        {
            System.out.print("Enter an integer for slot " + (index + 1) + ": ");
            array[index] = keyboard.nextInt();
        }

        for(int i = 0; i <= arrayLength; i++)
        {
            if (desiredNumber == array[i])
            {
                location = i;
                break;
            }
        }
        
        if (location == -1)
        {
            System.out.println("Sorry, the deisred number isn't in your array.");
        }
        else
        {
            System.out.println("Congrats, " + desiredNumber + " is located at index: " + location);
        }
    }
}