public class PairOfDice {

	private int die1;
	private int die2;
	private int total;

	public PairOfDice () {

		computeRoll ();
	}

	public PairOfDice (int val1, int val2) {

		die1 = val1;
		die2 = val2;
	}

	public PairOfDice (int startingTotal) {

		total = startingTotal;
	}

	public int getDie1 () {

		return die1;
	}

	public int getDie2 () {

		return die2;
	}
	
	public int getTotal () {

		return total;
	}
	
	public void computeRoll () {

		die1 = (int)(Math.random () * 6) + 1;
		die2 = (int)(Math.random () * 6) + 1;
	}

	public int computeTotal () {

		total = die1 + die2;
		return total;
	}
}