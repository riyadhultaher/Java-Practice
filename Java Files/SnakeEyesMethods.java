import textio.TextIO;

/** 
* This program will roll two dice at random until they both turn up snake eyes
* or both turn up 1s. This program will continue to run until this is achieved and 
* will output how many attempts it took to achieve this.
**/

public class SnakeEyesMethods {

	/** 
	* Preconditions: None.
	* Postconditions: Will take the value of the number of attempts it took to achieve snake
	* and will print it. If the value is over one, it will convert the number digit into words.
	**/

	public static void main (String [] args) {

		int result;

		result = 0;

		System.out.println ("This program will roll a pair of dice in order to achieve snake eyes. Let's begin.");
		result = computeDiceValues (result);


		switch (result) {

			case 1 :
			System.out.println ("It took one attempt to achieve snake eyes.");
			break;

			default :
			System.out.println ("It took " + NumberToWordConverter.numberToWord (result) + " attempts tp achieve snake eyes.");
			break;
		}	
	
		System.out.println ();

	}

	/**
	* Preconditions: None.
	* Postconditions: This method will roll two die and print out their values. It will then add up the
	* value of that roll and print this as well. This will continue until the value of both die is one.
	* It will then return the number of attempts it took to achieve this.
	**/

	private static int computeDiceValues (int attempts) {

		int dice1;
		int dice2;
		int totalRoll;


		do {

			dice1 = (int)(Math.random () * 6) + 1;
			System.out.println ("The first dice comes up " + NumberToWordConverter.numberToWord (dice1));
			dice2 = (int)(Math.random () * 6) + 1;
			System.out.println ("The second dice comes up " + NumberToWordConverter.numberToWord (dice2));
			totalRoll = dice1 + dice2;
			System.out.println ("Your total roll is " + NumberToWordConverter.numberToWord (totalRoll));
			attempts ++;

			if (! ((dice1 == 1) && (dice2 == 1))) {

				System.out.println ("Let's try again.");
				System.out.println ();
			}
		
		} while (! ((dice1 == 1) && (dice2 == 1)));
	
		return attempts;
	}
}