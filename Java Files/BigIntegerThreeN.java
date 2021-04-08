import textio.TextIO;
import java.math.BigInteger;

public class BigIntegerThreeN {

	public static void main (String [] args) {

		System.out.println ("This program will print out the 3N + 1 sequence for starting values that you specify using BigInteger objects.");
		System.out.println ();

		String line;
		BigInteger number;


		while (true) {

			System.out.println ("Please enter a positive number or enter a blank line if you no longer wish to continue.");
			line = TextIO.getln ();


			if (line.length () == 0) {

				break;
			}
		
			try {

				number = new BigInteger (line);
				print3NSequence (number);
			}

			catch (NumberFormatException e) {

				System.out.println (e.getMessage ());
				System.out.println ("Invalid response. Try again.");
				System.out.println ();
				continue;
			}
		}
	}

	private static void print3NSequence (BigInteger n) {

		if (n.signum () != 1) {

			throw new NumberFormatException ("Initial number must be positive.");
		}

		int count;
		int onLine;
		BigInteger m;

		count = 1;
		onLine = 1;
		m = new BigInteger ("1");

		System.out.println ("The 3N + 1 sequence starting from " + n.toString ());
		System.out.println ();
		System.out.print (n.toString ());
		System.out.print (' ');


		while (! (n.equals (m) && n.signum () == 1)) {

			n = nextN (n);
			count ++;


			if (onLine == 5) {

				System.out.println ();
				onLine = 0;
			}
		
			System.out.print (n.toString ());
			System.out.print (' ');
			onLine ++;
		} 
	
		System.out.println ();
		System.out.println ();
		System.out.println ("There were " + count + " terms in the sequence.");
	}

	private static BigInteger nextN (BigInteger currentN) {

		BigInteger m;
		BigInteger o;


		if (currentN.testBit (0)) {

			m = new BigInteger ("3");
			o = new BigInteger ("1");

			currentN = currentN.multiply (m);
			currentN = currentN.add (o);

			return currentN;
		}
	
		else {

			m = new BigInteger ("2");

			return currentN.divide (m);
		}
	}
}