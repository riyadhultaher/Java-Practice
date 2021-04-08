import textio.TextIO;

/*
* This program will take a line of text inputted by the user and break it up
* into multiple lines for each word. It will determine where the word ends by
* the space character.
*/

public class WordBreakerMethods {

	/*
	* Preconditions: User must be able to input a line of text.
	* Postconditions: This method will run the WordBreakerCode method and will then 
	* ask if the user would like to repeat the program.
	*/

	public static void main (String [] args) {

		String line;
		boolean tryAgain;

		tryAgain = false;

		System.out.println ("This program will break up a line of text into multiple lines caused by the spaces in the line.");
		

		do {
			
			System.out.println ("Please enter a line of text.");
			System.out.println ();

			line = TextIO.getln ();
		
			determineWhereSpacesOccurFromInputLine (line);

			System.out.println ();
			System.out.println ("Would you like to try again?");
			tryAgain = TextIO.getBoolean ();

		} while (tryAgain != false);

		
		if (tryAgain == false) {

			System.out.println ("Goodbye.");
		}

		System.out.println ();	
	}

	/* 
	* Preconditions: Line must be an acceptable string in order to pass into this method.
	* Postconditions: This method will break the line of text input in the main method into
	* multiple lines separated based on the word. This method looks for the space character 
	* between words and uses that to determine a new line.
	*/

	private static void determineWhereSpacesOccurFromInputLine (String inputLine) {

		int i;
		char ch;
		boolean didCR;

		didCR = false;


		for (i = 0; i < inputLine.length (); i ++) {

			ch = inputLine.charAt (i);


			if (Character.isLetter (ch)) {

				System.out.print (ch);
				didCR = false;
			}
		
			else {


				if (didCR == false) {

					System.out.println ();
					didCR = true;
				}
			}
		}
	}
}