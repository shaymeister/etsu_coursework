import java.util.Scanner;

public class Quiz3DecisionsLab
{
	public static void main(String[] args)
	{
		double quizAvg = 0;
		double projAvg = 0;
		double testAvg = 0;
		double average = 0;
		char letterGrade = ' ';
		int absences = 0;
		char likeJava = ' ';
		
        // create a new instance of the scanner class
		Scanner keyboard = new Scanner(System.in);

		// greet the user
		System.out.println("I am going to have you enter some grades "
							+ "and give you some feedback...");
		
		// get the user's quiz average
		System.out.println("Enter your quiz average:");
		quizAvg = keyboard.nextDouble();

		// get the user's project average
		System.out.println("Enter your project average");
		projAvg = keyboard.nextDouble();

		// get the user's test average
		System.out.println("Enter your test average");
		testAvg = keyboard.nextDouble();

		// define the weight of different assessments
		final double QUIZ_WEIGHT = 0.25,
			   		 PROJECT_WEIGHT = 0.35,
			   		 TEST_WEIGHT = 0.40;

		// calculate the average
		average = (quizAvg *QUIZ_WEIGHT) + (projAvg * PROJECT_WEIGHT) + (testAvg * TEST_WEIGHT);
		
		// display the average to the cmd line
		System.out.println("\n\n\n\n\n\n\n" +
						   "*********************************************\n" + 
						   "Average: " + average);
		
		if (projAvg > testAvg && projAvg > quizAvg)
		{
			System.out.println("You scored highest on projects");
		}
		else if (testAvg > projAvg && testAvg > quizAvg)
		{
			System.out.println("You scored highest on tests");		
		}
		else
		{
			System.out.println("You scored highest on quizzes");
		}
		
		if (projAvg < testAvg && projAvg < quizAvg)
		{
			System.out.println("You scored lowest on projects");
		}
		else if (testAvg < projAvg && testAvg < quizAvg)
		{
			System.out.println("You scored lowest on tests");		
		}
		else
		{
			System.out.println("You scored lowest on quizzes");
		}
		
		System.out.println("\n**********************************************");
		
		// ask the user how many times they were absent
		System.out.println("How many abscences did you have?");
		absences = keyboard.nextInt();

		switch(absences)
		{
			case 0:
				average += 2;
				System.out.println("Because you had perfect attendance, I will add 2 points to your average");
				break;
			case 1:
				average ++;
				System.out.println("Because you had only one absence, I will add 1 point to your average");
				break;
			default:
				average = average - absences;
				System.out.println("Because you missed multiple classes, I am subtracting one point per abscence!");
				break;
		}	

		//absorb the extra carriage return left in the input buffer
		keyboard.nextLine();
		
		System.out.println("Do you like Java? (Y/N)");
		likeJava = keyboard.nextLine().charAt(0);

		if (likeJava != 'Y' && likeJava != 'y' && likeJava != 'N' && likeJava != 'n' )
		{
			System.out.println("Your input should have been Y or N.  I'll take that as a No");
		}
		
		if (likeJava == 'Y' || likeJava == 'y')
		{
			average += 3;
			System.out.println("Because you like Java, I'm adding 3 points to your average!");
		}
		else
		{
			System.out.println("I'm sorry you don't like Java.  That's too bad...");
		}
	

		if (average >= 90)
		{
			letterGrade = 'A';
		}
		else if (average >= 80)
		{
			letterGrade = 'B';
		}
		else if (average >= 70)			
		{
			letterGrade = 'C';
		}
		else if (average >= 60)
		{
			letterGrade = 'D';
		}
		else 
		{
			letterGrade = 'F';
		}
						
		System.out.println("\n\n\n**********************************************");
		
		System.out.println("Based on the information you have provided,\n" +
						   "your FINAL AVERAGE is......  " + average + "  (" + letterGrade + ")");


		// these strings save some typing in the print statements
		String aOrB = "Congratulations!  Keep up the good work...",
		       cOrD = "This class may be more difficult than you anticipated!",
			   f = "Hmmm...you must have a mean teacher! :-)";
		
		switch (letterGrade)
		{
			case 'A':
				System.out.println(aOrB);
				break;
			case 'B':
				System.out.println(aOrB);
				break;
			case 'C':
				System.out.println(cOrD);
				break;
			case 'D':
				System.out.println(cOrD);
				break;
			case 'F':
				System.out.println(f);
				break;
	
		}

		System.out.println("\n**********************************************");		
	}//end main
}//end DecisionsLab




