import textio.TextIO;

/*
This program will read a string from the user that has hexadecimal digits.
It will find the hexadecimal value for each character in the user string.
It will then print the base-10 integer based on those digits.
*/ 

public class HexClass {

	/*
	The main method will call the hexValue function. It will also read
	all the values from hexValue and print out the corresponding base-10 value.
	It will then ask the user if they would like to try again.
	*/

	public static void main (String [] args) {

		String line;
		boolean tryAgain;
		int i;
		char lineCharacter;
		long value;
		int hexValue;

		value = 0;

		System.out.println ("This program will take a line input by the user and create a base-10 value based on it's hexadecimal value.");
		System.out.println ();


		do {

			System.out.println ("Please enter a line of text. The numbers must be between 0 and 9 and the letters must be between A and F");
			line = TextIO.getln ();


			for (i = 0; i < line.length (); i ++) {

				lineCharacter = line.charAt (i);
				hexValue = hexValue (lineCharacter);


				if (hexValue == -1) {

					System.out.println ("There was an error.");
					System.exit (1);
				}
				
				value = (value * 16) + hexValue;

			}
		
			System.out.println ("Your base-10 value is " + value);
			System.out.println ();
			System.out.println ("Do you want to try again?");
			tryAgain = TextIO.getBoolean ();
			System.out.println ();

		} while (tryAgain == true);
	
		System.out.println ("Goodbye.");
		System.out.println ();
	}

	/*
	This method will return the hexadecimal value of the current character to the main method.
	*/

	private static int hexValue (char ch) {

		switch (ch) {

			case '0' :
			return 0;

			case '1' :
			return 1;

			case '2' :
			return 2;

			case '3' :
			return 3;

			case '4' :
			return 4;

			case '5' :
			return 5;

			case '6' :
			return 6;

			case '7' :
			return 7;

			case '8' :
			return 8;

			case '9' :
			return 9;

			case 'a' :
			case 'A' :
			return 10;

			case 'b' :
			case 'B' :
			return 11;

			case 'c' :
			case 'C' :
			return 12;

			case 'd' :
			case 'D' :
			return 13;

			case 'e' :
			case 'E' :
			return 14;

			case 'f' :
			case 'F' :
			return 15;
		
			default :
			return -1;
		}
	}
}