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
               testAvg, // to hold the avg of the test scores
               testMax, // to hold the max of the test scores
               testMin; // to hold the min of the test scores

        int desiredOutput; // to hold the user's desire for the program
        
        boolean calcAvg,
                calcMin,
                calcMax,
                calcAll;

        final int NUM_OF_TESTS; // to hold the number of test scores provided

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
        


        //------------------ Computations -------------------------------------
        
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
        else
        {
            System.out.println("An unexpected error has occured, please try again.")
        }


        // calculate the average of the test scores w/out "MATH" class
        if (calcAvg == true || calcAll == true)
        {
            testAvg = (test1 + test2 + test3) / NUM_OF_TESTS;    
        }
        else
        {
            break;
        }

        // calculate the max of the test scores w/out "MATH" class
        if (calcMax = true || calcAll == true)
        {
            
        }
        else
        {
            break;
        }

        // calculate the min of the test scores w/out "MATH" class
        if (calcMin = true || calcAll == true)
        {
        
        }
        else
        {
            break;
        }

        //================== END: Computations ================================
        


        //------------------ Output -------------------------------------------


        //================== END: Output ======================================
        
    } //END: "main" method
} //END: "Test1Review" class
