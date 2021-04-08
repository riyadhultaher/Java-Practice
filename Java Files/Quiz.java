import textio.TextIO;

/*
This program will create a ten question addition quiz using randomly
generated numbers between 1 and 100. The createQuiz method will create
the quiz. The administerQuiz method will test the user and the gradeQuiz
method will grade the quiz and display the user's score.
*/

public class Quiz {

	public static int [] firstNumber;
	public static int [] secondNumber;
	public static int [] userResponse;


	/*
	The main method will simply call the three methods.
	*/

	public static void main (String [] args) {

		char begin;

		System.out.println ("This program is a simple ten question addition quiz. It will ask you ten addition questions and then grade them in the end.");
		System.out.println ();
		System.out.println ("Enter any character to begin.");
		begin = TextIO.getChar ();

		createQuiz ();
		administerQuiz ();
		gradeQuiz ();
	}

	/*
	This method will create the randomly generated numbers to form the
	ten question quiz.
	*/

	public static void createQuiz () {

		int i;

		firstNumber = new int [11];
		secondNumber = new int [11];
		userResponse = new int [11];


		for (i = 1; i < firstNumber.length; i ++) {

			firstNumber [i] = (int)(Math.random () * 100) + 1;
		}
	
		for (i = 1; i < secondNumber.length; i ++) {

			secondNumber [i] = (int)(Math.random () * 100) + 1;
		}
	}

	/*
	This method will administer the quiz using the numbers from the above
	method. This method will ask the user for a response.
	*/

	public static void administerQuiz () {

		int i;

		System.out.println ("GENERATING QUIZ");
		System.out.println ();

		
		for (i = 1; i <= 10; i ++) {

			System.out.println ("Question " + i + ":");
			System.out.println ();

			System.out.println (firstNumber [i] + " + " + secondNumber [i]);
			userResponse [i] = TextIO.getInt ();
			System.out.println ();
		}
	}

	public static void gradeQuiz () {

		int i;
		int correctResult;
		int score;

		score = 0;

		System.out.println ("GENERATING RESULTS");
		System.out.println ();


		for (i = 1; i <= 10; i ++) {

			System.out.println ("Question " + i + ":");
			System.out.println ();

			correctResult = firstNumber [i] + secondNumber [i];
			System.out.println (firstNumber [i] + " + " + secondNumber [i]);
			System.out.println ();
			System.out.println ("Your response was: " + userResponse [i]);


			if (userResponse [i] == correctResult) {

				System.out.println ("This is correct.");
				score += 10;
			}
		
			else {

				System.out.println ("This is incorrect.");
				System.out.println ("The correct answer is " + correctResult);
			}
			
			System.out.println ();
		}
	
		System.out.println ("Your final score is " + score);
	}
}