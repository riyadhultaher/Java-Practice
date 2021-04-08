import textio.TextIO;

/*
This program will perform 10000 experiments per possible dice total. It will record
the average number of goals it took to achieve that total.
*/

public class RollTheDice3 {

	final static int EXPERIMENTS = 10000;

	/*
	The main method will loop all possible totals for a pair of dice. It will then 
	call the rollExperiment function which will return the average number of rolls.
	It will then print this out in a table.
	*/

	public static void main (String [] args) {

		int i;
		double averageNumber;
		double [] averageTable;

		averageTable = new double [13];

		System.out.println ("This program will create a table and display the average number of rolls per possible dice total for 10000 experiments.");
		System.out.println ();
		System.out.println ("Total On Dice    Average Number of Rolls");
		System.out.println ("-------------    -----------------------");
		
		for (i = 2; i < 13; i ++) {

			averageNumber = rollExperiment (i);
			averageTable [i] = averageNumber;
			System.out.println ("     " + i + "            " + averageTable [i]);
		}
	}

	/*
	This method will experiment each possible total 10000 times. It will call the computeRoll 
	function. It will also record the average number of rolls per possible total and return that 
	to the main method.
	*/

	private static double rollExperiment (int currentPossibleTotal) {

		int i;
		int currentAttempts;
		int totalAttempts;
		double currentAverage;

		totalAttempts = 0;

		for (i = 1; i < EXPERIMENTS; i ++) {

			currentAttempts = computeRoll (currentPossibleTotal);
			totalAttempts += currentAttempts;
		}
	
		currentAverage = (double) totalAttempts / EXPERIMENTS;

		return currentAverage;
	}

	/*
	This method will roll two dice continuously until the goal established in the
	main method is hit.
	*/

	private static int computeRoll (int goal) {

		int dice1;
		int dice2;
		int total;
		int attempts;

		attempts = 0;


		do {

			dice1 = (int)(Math.random () * 6) + 1;
			dice2 = (int)(Math.random () * 6) + 1;
			total = dice1 + dice2;
			attempts ++;
		
		} while (total != goal);
		
		return attempts;
	}
}