/*
This program will simulate two pairs of dice. It will randomly
roll two pairs until they all equal the same number whatever it
might be. It will record how many attempts it took.
*/

public class RollTwoPairs {

	public static void main (String [] args) {

		PairOfDice firstDice;
		PairOfDice secondDice;

		firstDice = new PairOfDice ();
		secondDice = new PairOfDice ();

		int countRolls;
		int total1;
		int total2;

		countRolls = 0;


		do {

			firstDice.roll ();
			total1 = firstDice.die1 + firstDice.die2;
			System.out.println ("First pair comes up " + total1);

			secondDice.roll ();
			total2 = secondDice.die1 + secondDice.die2;
			System.out.println ("Second pair comes up " + total2);

			countRolls ++;
			System.out.println ();
		
		} while (total1 != total2);
	
		System.out.println ("It took " + countRolls + " rolls until the totals were the same.");
		System.out.println ();
	}
}