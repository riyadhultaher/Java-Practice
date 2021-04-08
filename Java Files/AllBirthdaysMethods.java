/** This program will randomly select a number from the 365 days of the year until
* we have found a "birthday" on each of those days.
**/

public class AllBirthdaysMethods {

	/** The main method will simply print out what the result of the computeBirthdays
	* method returns.
	**/

	public static void main (String [] args) {

		int result;

		result = 0;

		System.out.print ("We had to check ");

		result = computeBirthdays (result);

		System.out.println (result + " people in order to find a birthday on each day.");
	}

	/** Preconditions: None
	Postconditions: This method will return the result of how many people it took to cover
	* every day of the year.
	**/

	private static int computeBirthdays (int count) {

		boolean [] birthdayArray;
		int birthdaysFound;

		birthdayArray = new boolean [365];
		birthdaysFound = 0;


		while (birthdaysFound < 365) {

			int birthday;

			birthday = (int)(Math.random () * 365);
			count ++;


			if (birthdayArray [birthday] == false) {

				birthdaysFound ++;
			}
		
			birthdayArray [birthday] = true;

		}

		return count;
	}
}