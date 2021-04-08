import textio.TextIO;

/*
* This program will print out the first number with the most divisors between 1 and 10000
* as well as what the maximum amount of divisors is. (There are actually two numbers that
* have the most amount which is 64; the program will print out both of these.
*/

public class IntegerArrayMethods {

	static int maxDivisors;

	/*
	* Preconditions: None
	* Postconditions: This method will print out the number with the most divisors as well as 
	* specifically how many divisors that is. Due to the necessity to return two variables, we needed
	* to create an array of length 2 to return both variables.
	*/

	public static void main (String [] args) {

		int [] divisorArray;

		divisorArray = new int [10001];

		System.out.println ("This program will evaluate the numbers between 1 and 10000 and find out the number that has the most divisors as well as how many divisors that number has.");
		System.out.println ();

		divisorArray = computeMaxDivisors (divisorArray);
		System.out.println ("Between the numbers 1 and 10000, the maximum amount of divisors was " + maxDivisors + ", coming from these numbers:");
		printNumbersWithMaxDivisors (divisorArray);
		
		System.out.println ();
	}

	/*
	* Preconditions: None
	* Postconditions: This method will evaluate all the numbers between 1 and 10000 and determine which
	* numbers have the most divisors and how many divisors that is.
	*/

	private static int [] computeMaxDivisors (int [] array) {

		int n;


		for (n = 1; n <= 10000; n ++) {

			int d;
			int currentDivisors;

			currentDivisors = 0;


			for (d = 1; d <= n; d ++) {


				if (n % d == 0) {

					currentDivisors ++;
				}
			
				array [n] = currentDivisors;

				
				if (currentDivisors > maxDivisors) {

					maxDivisors = currentDivisors;
				}
			}
		}

		return array;

	}

	/*
	Preconditions: Every number between 1 and 10000 must have a value for the number of divisors it contains.
	Postconditions: This method will return every value between this range that has the maximum number of divisors.
	*/

	private static void printNumbersWithMaxDivisors (int [] divisorArray) {

		int n;

		
		for (n = 1; n <= 10000; n ++) {


			if (divisorArray [n] == maxDivisors) {

				 System.out.println (n);
			}
		}
	}

}