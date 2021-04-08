import textio.TextIO;

public class SnakeEyes2 {

	public static void main (String [] args) {

		int dice1;
		int dice2;
		int totalRoll;
		int numberOfRolls;

		totalRoll = 0;
		numberOfRolls = 0;

		
		do {

			totalRoll = 0;
			dice1 = (int)(Math.random() * 6) + 1;
			System.out.println("Your first roll is " + dice1);
			dice2 = (int)(Math.random() * 6) + 1;
			System.out.println("Your second roll is " + dice2);
			totalRoll = dice1 + dice2;
			System.out.println("Your total roll is " + totalRoll);
			numberOfRolls ++;


			if (! (dice1 == 1 && dice2 == 1)) {

				System.out.println("Let's try again.");
			}
		
		} while ( ! (dice1 == 1 && dice2 == 1));
	

		switch (numberOfRolls) {

			case 1 :
			System.out.println("It took " + numberOfRolls + " roll to achieve snake eyes.");
			break;
		
			default :
			System.out.println("It took " + numberOfRolls + " rolls to achieve snake eyes.");
			break;
		}	
	}
}