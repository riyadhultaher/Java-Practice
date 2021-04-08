import textio.TextIO;

public class RomanNumeralTest {

	public static void main (String [] args) {

		RomanNumeral output;

		System.out.println ("This program will convert Arabic numerals to Roman numerals and vice versa.");
		System.out.println ();
		System.out.println ("The bounds are values between 1 and 3999.");
		System.out.println ();


		while (true) {

			System.out.println ("Please enter a Roman numeral or an Arabic numeral.");
			

			while (TextIO.peek () == ' ' || TextIO.peek () == '\t') {

				TextIO.getAnyChar ();
			}

			if (TextIO.peek () == '\n') {

				break;
			}

			
			if (Character.isDigit (TextIO.peek ())) {

				int arabic;

				arabic = TextIO.getlnInt ();

				
				try {

					output = new RomanNumeral (arabic);
					System.out.println (output.toInt () + " = " + output.toString ());
					System.out.println ();
				}
			
				catch (NumberFormatException e) {

					System.out.println ("Invalid input.");
					System.out.println (e.getMessage ());
				}
			}
		
			else {

				String roman;

				roman = TextIO.getln ();


				try {

					output = new RomanNumeral (roman);
					System.out.println (output.toString () + " = " + output.toInt ());
					System.out.println ();
				}
			
				catch (NumberFormatException e) {

					System.out.println ("Invalid input.");
					System.out.println (e.getMessage ());
				}
			}
		}
	}
}