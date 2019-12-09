// ---------------------------->
// Created by: Shay Snyder
// email: snyderse2@etsu.edu
// ---------------------------->
import java.util.*;

public class Quiz5
{
    public static void main(String[] args)
    {
        // create and instance of the scanner class
        Scanner keyboard = new Scanner(System.in);

        int[] WINNINGNUMBERS = {12, 35, 34, 2, 5}, // the winning lottery number
              userNumbers = new int[5]; // to hold the user's lottery number

        int matching = 0;
        
        String reward = "";

        // receive the user's lottery numbers
        for(int i = 0; i < 5; i++)
        {
            System.out.print("What is your number " + (i + 1) + "? ");
            userNumbers[i] = keyboard.nextInt();
        }

        // compare the user's numbers to the winning numbers
        // the order of the user's numbers is irrelevant 
        for(int i = 0; i < 5; i++)
        {
            for(int i2 = 0; i2 < 5; i2++)
            {
                if (userNumbers[i] == WINNINGNUMBERS[i2])
                {
                    matching++;
                }
            }
        }
        
        // determine the users's reward based 
        // on how many numbers were correct
        switch(matching)
        {
            case 0:
                reward = "$0";
                break;
            case 1:
                reward = "$1";
                break;
            case 2:
                reward = "$50";
                break;
            case 3:
                reward = "$1,000";
                break;
            case 4:
                reward = "$50,000";
                break;
            case 5:
                reward = "$90,000,000";
        }

        // tell the user how much money they would receive
        System.out.println("You have won " + reward + "!");
    }
}