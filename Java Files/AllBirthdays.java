import textio.TextIO;

public class AllBirthdays {
	
	public static void main (String [] args) {

		boolean [] used;
		int count;
		int birthdaysFound;

		used = new boolean [365];

		count = 0;
		birthdaysFound = 0;


		while (birthdaysFound < 365) {

			int birthday;

			birthday = (int)(Math.random() * 365);
			count ++;


			if (used [birthday] == false) {

				birthdaysFound ++;
				used [birthday] = true;
			}
		}
	
		System.out.println("It took " + count + " people to check every birthday.");

	}
}