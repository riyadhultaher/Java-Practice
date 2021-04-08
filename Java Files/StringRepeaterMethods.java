import textio.TextIO;

/*
* This program will take a line inputted by the user and will print out 25
* characters for each character in the line. For example, if the input is "boy"
* then there will be 25 characters of the letter 'b', 25 characters of the letter 'o',
* and 25 letters of the character 'y'.
*/

public class StringRepeaterMethods {

	/* 
	* Preconditions: User must be able to input a line of text.
	* Postconditions: This main method will take a line of text from the user, then will run
	* the printLineOfText method. The method will then ask the user if they would like to run
	* the program again.
	*/

	public static void main (String [] args) {

		String line;
		boolean tryAgain;

		System.out.println ("This program will print out 25 characters for each character of any line of text of your choosing.");


		do {

			System.out.println ("Please enter a line of text.");
			line = TextIO.getln ();

			printLineOfText (line);

			System.out.println ("Do you want to try again?");
			tryAgain = TextIO.getBoolean ();
		
		} while (tryAgain == true);
	
		System.out.println ("Goodbye.");
		System.out.println ();
	}

	/*
	* Preconditions: Must have received the line parameter from the main method.
	* Postconditions: This method will take the line parameter and reprint it with 25 characters
	* per inputted character.
	*/

	private static void printLineOfText (String line) {

		int i;


		for (i = 0; i < line.length (); i ++) {

			printTwentyFiveCharacters (line.charAt (i), 25);
		}
	}

	/*
	* Preconditions: This method relies on printLineOfText where that method must currently be on a character.
	* Postconditions: This method will print out 25 copies of whatever character printLineOfText is currently at.
	*/

	private static void printTwentyFiveCharacters (char ch, int n) {

		int i;


		for (i = 0; i < n; i ++) {

			System.out.print (ch);
		}
	}

}