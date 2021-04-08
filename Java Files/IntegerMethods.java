import textio.TextIO;

/*
* This program will print out the first number with the most divisors between 1 and 10000
* as well as what the maximum amount of divisors is. (There are actually two numbers that
* have the most amount which is 64; the program will print out the last one that it processes.
*/

public class IntegerMethods {

	/*
	* Preconditions: None
	* Postconditions: This method will print out the number with the most divisors as well as 
	* specifically how many divisors that is. We run two methods that are exactly identical except
	* one of them returns the maximum amount of divisors and the other returns the number with the maximum
	* amount of divisors.
	*/

	public static void main (String [] args) {

		int maxDivisors;
		int numWithMax;
		
		maxDivisors = 0;
		numWithMax = 0;

		System.out.println ("This program will evaluate the numbers between 1 and 10000 and find out the number that has the most divisors as well as how many divisors that number has.");
		System.out.println ();

		maxDivisors = computeMaxDivisors (maxDivisors);
		numWithMax = computeNumWithMax (numWithMax);

		System.out.println ("The number, " + maxDivisors + ", has the most divisors with " + numWithMax + " divisors.");
		System.out.println ();
	}

	/*
	* Preconditions: None
	* Postconditions: This method will evaluate all the numbers between 1 and 10000 and determine the
	* maximum amount of divisors.
	*/

	private static int computeMaxDivisors (int maxDivisors) {

		int n;


		for (n = 1; n <= 10000; n ++) {

			int d;
			int currentDivisors;

			currentDivisors = 0;


			for (d = 1; d <= n; d ++) {


				if (n % d == 0) {

					currentDivisors ++;
				}
			
				if (currentDivisors > maxDivisors) {

					maxDivisors = currentDivisors;
				}
			}
		}

		return maxDivisors;

	}

	/*
	* Preconditions: None
	* Postconditions: This method will evaluate all the numbers between 1 and 10000 and determine the
	* number with the maximum amount of divisors. A variable localMaxDivisors is created that serves the
	* same function as maxDivisors in the previous method.
	*/

	private static int computeNumWithMax (int numWithMax) {

		int n;
		int localMaxDivisors;

		localMaxDivisors = 0; 

		for (n = 1; n <= 10000; n ++) {

			int d;
			int currentDivisors;

			currentDivisors = 0;


			for (d = 1; d <= n; d ++) {


				if (n % d == 0) {

					currentDivisors ++;
				}
			
				if (currentDivisors > localMaxDivisors) {

					numWithMax = n;
				}
			}
		}

		return numWithMax;

	}
}