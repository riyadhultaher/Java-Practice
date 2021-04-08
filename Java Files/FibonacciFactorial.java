import textio.TextIO;
import java.math.BigInteger;

public class FibonacciFactorial {

	public static void main (String [] args) {

		String input;
		int number;

		System.out.println ("This program will print out a factorial or fibonacci sequence for a number of your choosing.");
		System.out.println ();
		System.out.println ("Please input 'fact' for factorials or 'fib' for fibonacci.");

		do {

			input = TextIO.getln ();
			
			if ( ! (input.equals ("fact") || input.equals ("fib"))) {

				System.out.println ("Invalid option.");
			}
		} while ( ! (input.equals ("fact") || input.equals ("fib")));

		System.out.println ("Please input a number.");

		do {

			number = TextIO.getInt ();

			if (number < 0) {

				System.out.println ("Your number must be non negative.");
			}
		} while (number < 0);
		
		if (input.equals ("fact")) {

			number = fact (number);
			System.out.println ("Your factorial number is " + number);
		}
		if (input.equals ("fib")) {

			number = fib (number);
			System.out.println ("Your fibonacci number is " + number);
		}
	}

	private static int fib (int n) {
		
		int m;
		int counter = n;

		if (counter <= 0) {

			return 0;
		}
		n += (n - 1);
		m = fib (counter - 2);
		return n + m;
	}

	private static int fact (int n) {

		int m;
		int counter = n;

		if (counter <= 1) {

			return 1;
		}
		n *= (n - 1);
		m = fact (counter - 2);
		return n * m;
	}
}