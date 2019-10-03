import java.util.Scanner;

public class Test1Review
{
    public static void main(String[] args)
    {
        //------------------ Variables & Class Instances ----------------------
        // Create a new instance of the Scanner class
        Scanner keyboard = new Scanner(System.in);

        double test1, // to hold the score of test 1
               test2, // to hold the score of test 2
               test3, // to hold the score of test 3
               testAvg = 0, // to hold the avg of the test scores
               testMax = 0, // to hold the max of the test scores
               testMin = 0; // to hold the min of the test scores

        int desiredOutput; // to hold the user's desire for the program

        boolean calcAvg = false,
                calcMin = false,
                calcMax = false,
                calcAll = false;

        final int NUM_OF_TESTS = 3; // to hold the number of test scores provided

        //================== END: Variables & Class Instances =================



        //------------------ User Input ---------------------------------------
        // ask the user for score of test 1
        System.out.println("What did you score on the first test?");
        test1 = keyboard.nextDouble();

        // ask the user for score of test 2
        System.out.println("What did you score on the second test?");
        test2 = keyboard.nextDouble();

        // ask the user for score fo test 3
        System.out.println("What did you score on the third test?");
        test3 = keyboard.nextDouble();

        // ask the user what they would like to do with their test scores
        System.out.println("What would you like to calculate?\n" +
                "1. Avg\n" + 
                "2. Max\n" +
                "3. Min\n" +
                "4. All of the above");
        desiredOutput = keyboard.nextInt();

        //------------------ END: User Input ----------------------------------



        //------------------ Computation & Exportation -------------------------

        //TODO: refactor with switch statement
        // make sure the user's input is in the correct range
        if (desiredOutput != 1 &&
                desiredOutput != 2 &&
                desiredOutput != 3 &&
                desiredOutput != 4)
        {
            System.out.println("Invalid Selection");
        }
        else if (desiredOutput == 1)
        {
            calcAvg = true;
        }
        else if (desiredOutput == 2)
        {
            calcMax = true;
        }
        else if (desiredOutput == 3)
        {
            calcMin = true;
        }
        else if (desiredOutput == 4)
        {
            calcAll = true;
        }

        // calculate the average of the test scores w/out "MATH" class
        if (calcAvg == true || calcAll == true)
        {
            testAvg = (test1 + test2 + test3) / NUM_OF_TESTS;
            System.out.println("The average score of your tests is " + testAvg);
        }

        // calculate the max of the test scores w/out "MATH" class
        if (calcMax = true || calcAll == true)
        {
            if (test1 >= test2 && test1 >= test3)
            {
                testMax = test1;
            }
            else if (test2 >= test1 && test2 >= test3)
            {
                testMax = test2;
            }
            else if (test3 >= test1 && test3 >= test2)
            {
                testMax = test3;
            }
            else
            {
                System.out.println("An unexpected error has occured.");
                System.exit(0);
            }

            System.out.println("The maximum score of your tests is " + testMax);
        }

        // calculate the min of the test scores w/out "MATH" class
        if (calcMin = true || calcAll == true)
        {
            if (test1 <= test2 && test1 <= test2)
            {
                testMin = test1;
            }
            else if (test2 <= test1 && test2 <= test3)
            {
                testMin = test2;
            }
            else if (test3 <= test1 && test3 <= test2)
            {
                testMin = test3;
            }
            else
            {
                System.out.println("An unexpected error has occured.");
                System.exit(0);
            }

            System.out.println("The minimum score of your tests is " + testMin);
        }

        //================== END: Computation & Exportation ====================

    } //END: "main" method
} //END: "Test1Review" class
