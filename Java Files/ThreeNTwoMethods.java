import textio.TextIO;

/*
* This program will take a value inputted by the user and will perform the ThreeN sequence.
* This entails looping a program until the value of the initial input equals 1. The program
* will continuously run a while loop as long as the value is greater than 1. The loop method
* sends the value to another method that creates a new value for the variable. If the value 
* prior to this methodis odd, 3 multiplied by the value plus one is returned. If the value is
* even, then the value divided by 2 is returned. This continues until the value equals 1. The
* program will then print how many iterations it took to achieve this.
*/

public class ThreeNTwoMethods {

	/*
	* Preconditions: User is able to input an initial value.
	* Postconditions: This method will take the value and send it to the print3NLoopingSequence method to be
	* looped. If the user enters 0 as the initial value, then the program is terminated.
	*/

	public static void main (String [] args) {

		int input;

		System.out.println ("This program prints the 3NSequence. The program will continue until the initial value equals 1, printing every next iteration. If the value of the previous iteration is odd, the program will compute the value multiplied by 3 plus one. If it is even, it will compute the value divided by two. Let's begin.");
		System.out.println ();
		

		while (true) {
		
			System.out.println ("Please input a starting value or enter 0 if you no longer wish to continue.");

			input = TextIO.getInt ();


			if (input == 0) {

				break;
			}

			else {

				print3NLoopingSequence (input);
	
			}
		}
	}

	/*
	* Preconditions: Inputted value from the previous method must be a positive integer greater than 1.
	* Postconditions: This method will provide the looping part where it will continue to call determineNextValue
	* until currentValue equals 1. This method also provides an onLine variable that prints five values on one line
	* before performing a carriage return.
	*/

	private static void print3NLoopingSequence (int currentValue) {

		int onLine;
		int count;

		onLine = 1;
		count = 1;

		System.out.println ("The ThreeNSequence starting from " + currentValue);
		System.out.println ();
		System.out.print (currentValue);
		System.out.print (' ');


		while (currentValue > 1) {

			currentValue = determineNextValue (currentValue);
			count ++;

			if (onLine == 5) {

				System.out.println ();
				onLine = 0;
			}
		
			System.out.print (currentValue);
			System.out.print (' ');
			onLine ++;
		}
	
		System.out.println ();
		System.out.println ();
		System.out.println ("There were " + count + " terms in the sequence.");

	}

	/*
	* Preconditions: This method must have received a positive value greater than 1 from print3NLoopingSequence.
	* Postconditions: This method will simply return 3N + 1 if the previous value is odd or will return N / 2 if the
	* previous value is even.
	*/

	private static int determineNextValue (int currentValue) {


		if (currentValue % 2 == 1) {

			return ((currentValue) * 3) + 1;
		}
	
		else {

			return (currentValue / 2);
		}
	}
}