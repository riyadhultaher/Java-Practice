import textio.TextIO;

/*
This program will create a ten question addition quiz using randomly
generated numbers between 1 and 100. The createQuiz method will create
the quiz. The administerQuiz method will test the user and the gradeQuiz
method will grade the quiz and display the user's score.
*/

public class Quiz3 {

	private static int [] userResponse;
	private static IntQuestion [] questionStorage;

	/*
	The main method will simply call the three methods.
	*/

	public static void main (String [] args) {

		char begin;

		System.out.println ("This program is a simple ten question quiz. It will ask you ten questions and then grade them in the end.");
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

	private static void createQuiz () {

		int i;
		int question;

		questionStorage = new IntQuestion [11];
		userResponse = new int [11];


		for (i = 1; i <= 10; i ++) {

			question = (int)(Math.random () * 3);


			switch (question) {

				case 0 :
				questionStorage [i] = new AdditionQuestion ();
				break;

				case 1 :
				questionStorage [i] = new SubtractionQuestion ();
				break;

				default :
				questionStorage [i] = new WordQuestion ();
				break;
			}
		}
	}

	/*
	This method will administer the quiz using the numbers from the above
	method. This method will ask the user for a response.
	*/

	private static void administerQuiz () {

		int i;

		System.out.println ("GENERATING QUIZ");
		System.out.println ();

		
		for (i = 1; i <= 10; i ++) {

			System.out.println ("Question " + i + ":");
			System.out.println ();
			System.out.println (questionStorage [i].getQuestion ());
			
			userResponse [i] = TextIO.getInt ();
			System.out.println ();
		}
	}

	private static void gradeQuiz () {

		int i;
		int correctResult;
		int score;

		score = 0;

		System.out.println ("GENERATING RESULTS");
		System.out.println ();


		for (i = 1; i <= 10; i ++) {

			System.out.println ("Question " + i + ":");
			System.out.println ();

			correctResult = questionStorage [i].getCorrectAnswer ();
			System.out.println (questionStorage [i].getQuestion ());
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