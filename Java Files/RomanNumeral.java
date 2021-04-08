import textio.TextIO;

public class RomanNumeral {
	
	private final int num;

	private static int [] numbers = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
	private static String [] letters = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

	public RomanNumeral (String string) {
		
		if (string.length () == 0) {

			throw new NumberFormatException ("Not a valid Roman numeral. Try again.");
		}
	
		int i;
		int arabic;
		char letter;
		int number;
		int nextNumber;


		string = string.toUpperCase ();

		i = 0;
		arabic = 0;


		while (i < string.length ()) {

			letter = string.charAt (i);
			number = letterToNumber (letter);

			i ++;


			if (i == string.length ()) {

				arabic += number;
			}
		
			else {

				nextNumber = letterToNumber (string.charAt (i));


				if (nextNumber > number) {

					arabic += (nextNumber - number);
					i ++;
				}
			
				else {

					arabic += number;
				}
			}
		}
	
		if (arabic > 3999) {

			throw new NumberFormatException ("Roman numeral must have a value of 3999 or less.");
		}
	
		num = arabic;
	}

	public RomanNumeral (int integer) {

		if (integer < 1 || integer > 3999) {

			throw new NumberFormatException ("Out of bounds input. Try again.");
		}
	
		num = integer;
	}

	public int toInt () {

		return num;
	}

	public String toString () {

		String roman;
		int n;
		int i;

		roman = "";
		n = num;


		for (i = 0; i < numbers.length; i ++) {

			while (n >= numbers [i]) {

				roman += letters [i];
				n -= numbers [i];
			}
		}
	
		return roman;
	}

	private int letterToNumber (char letter) {

		switch (letter) {

			case 'I' :
			return 1;

			case 'V' :
			return 5;

			case 'X' :
			return 10;

			case 'L' :
			return 50;

			case 'C' :
			return 100;

			case 'D' :
			return 500;

			case 'M' :
			return 1000;

			default :
			throw new NumberFormatException ("Illegal character.");
		}
	}
}