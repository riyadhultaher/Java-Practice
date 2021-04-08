/*
This program will find out how many rolls it takes before a pair
of dice achieves snake eyes. The difference is that we will be 
creating a new object using the PairOfDice class.
*/

public class PairOfDiceSnakeEyes {

	/*
	The main method will create the dice object and will call the class
	until snake eyes is achieved.
	*/

	public static void main (String [] args) {

		PairOfDice roll;
		int total;
		int count;

		roll = new PairOfDice ();
		total = 0;
		count = 0;

		System.out.println ("This program will count how many times a pair of dice is rolled before it comes up snake eyes.");
		System.out.println ();


		do {

			roll.computeRoll ();
			total = roll.computeTotal ();
			System.out.println ("The first die comes up " + roll.getDie1 () + " and the second die comes up " + roll.getDie2 ());
			System.out.println ("The total is " + roll.getTotal ());
			count ++;
		
		} while (total != 2);
	
		System.out.println ("It took " + count + " attempts to achieve snake eyes.");
	}	
}