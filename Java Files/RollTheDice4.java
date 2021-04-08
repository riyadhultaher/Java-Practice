import textio.TextIO;

/*
This program will perform 10000 experiments per possible dice total.
It will record the average number of rolls, the standard deviation, and
the maximum number of rolls.
*/

public class RollTheDice4 {

	final static int EXPERIMENTS = 10000;
	static double averageNumber;
	static double standardDeviation;
	static double maximumRolls;

	/*
	The main method will create an object for each potential dice total
	using the PairOfDice class. It will call the rollExperiment method to 
	perform this experiment repeatedly. It will then use the StatCalc class to 
	calculate the average number of rolls, standard deviation, and max rolls.
	It will then create a table to display all of this information.
	*/

	public static void main (String [] args) {

		int i;
		double [][] table;

		table = new double [13][3];

		System.out.println ("This program will create a table and display the average number of rolls, maximum number of rolls, and standard deviation per possible dice total for 10000 experiments.");
		System.out.println ();
		System.out.println ("Total On Dice    Average    Max Rolls    Standard Deviation");
		System.out.println ("-------------    -------    ---------    ------------------");

		for (i = 2; i < 13; i ++) {

			rollExperiment (i);
			table [i] [0] = averageNumber;
			table [i] [1] = maximumRolls;
			table [i] [2] = standardDeviation;
			System.out.println ("      " + i + "             " + table [i] [0] + "           " + table [i] [1] + "                " + table [i] [2]);
		}
	}

	/*
	This method will experiment each possible total 10000 times. It will call
	the computeRoll function. It will 
	*/

	private static void rollExperiment (int currentPossibleTotal) {

		StatCalc calculator;
		PairOfDice dice;
		int i;
		double currentAttempts;

		calculator = new StatCalc ();
		dice = new PairOfDice ();


		for (i = 1; i < EXPERIMENTS; i ++) {

			currentAttempts = computeRoll (currentPossibleTotal, dice);
			calculator.enter (currentAttempts);
		}
	
		averageNumber = calculator.getMean ();
		maximumRolls = calculator.getMax ();
		standardDeviation = calculator.getStandardDeviation ();

		return;
	}

	/*
	This method will call the PairOfDice class to roll the dice and return
	the value of the roll. It will do this until the established goal is reached
	and then will return the number of attempts to rollExperiment.
	*/

	private static double computeRoll (int goal, PairOfDice roll) {

		double attempts;

		attempts = 0.0;


		do {

			roll.computeRoll ();
			roll.computeTotal ();
			attempts ++;
		
		} while (roll.getTotal () != goal);
	
		return attempts;
	}
}