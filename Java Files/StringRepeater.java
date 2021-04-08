import textio.TextIO;

public class StringRepeater {

	public static void main (String [] args) {

		String input;
		
		System.out.println ("This program inputs a line of text with 25 characters per character.");
		System.out.println ("Please enter a line of text or enter 0 if you no longer wish to continue.");
		
		input = TextIO.getln ();

		
		while ( ! (input.equals ("0"))) {

			printRowsFromString (input);
			System.out.println ();
			System.out.println ("Please enter a line of text or enter 0 if you no longer wish to continue.");
			input = TextIO.getln ();
		}
	}

	private static void printRowsFromString (String str) {

		int i;


		for (i = 0; i < str.length (); i ++) {

			printRow (str.charAt (i), 25);
		}
	}

	private static void printRow (char ch, int n) {

		int i;


		for (i = 1; i <= n; i ++) {

			System.out.print (ch);
		}
	}

}