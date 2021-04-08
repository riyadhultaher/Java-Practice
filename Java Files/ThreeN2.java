import textio.TextIO;

public class ThreeN2 {

	public static void main (String [] args) {

		System.out.println ("This program will print out the 3N + 1 sequence for starting values that you specify.");

		int k;


		while (true) {

			System.out.println ("Please enter a positive number or enter 0 if you no longer wish to continue.");
			k = TextIO.getInt ();


			if (k == 0) {

				break;
			}
			
			else {

				print3NSequence (k);
			}	
		}
	}

	static void print3NSequence (int n) {

		int count;
		int onLine;

		count = 1;
		onLine = 1;

		System.out.println ("The 3N + 1 sequence starting from " + n);
		System.out.println ();
		System.out.print (n);
		System.out.print (' ');


		while (n > 1) {

			n = nextN (n);
			count ++;


			if (onLine == 5) {

				System.out.println ();
				onLine = 0;
			}
			
			System.out.print (n);
			System.out.print (' ');
			onLine ++;

		}
		
		System.out.println ();
		System.out.println ();
		System.out.println ("There were " + count + " terms in the sequence.");

	}

	static int nextN (int currentN) {

		if (currentN % 2 == 1) {

			return 3 * currentN + 1;
		}
	
		else {

			return currentN / 2;
		}
	}
}