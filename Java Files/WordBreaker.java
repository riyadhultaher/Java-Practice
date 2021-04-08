import textio.TextIO;

public class WordBreaker {
	
	public static void main (String [] args) {

		String line;
		int i;
		char ch;
		boolean didCR;

		System.out.println("Write out a line of text");
		line = TextIO.getln();

		didCR = true;


		for (i = 0; i < line.length(); i ++) {

			ch = line.charAt(i);


			if (Character.isLetter(ch)) {

				System.out.print(ch);
				didCR = false;
			}
		
			else {

				if (didCR == false) {

					System.out.println();
					didCR = true;
				}
			}

		}

		System.out.println();

	}
}