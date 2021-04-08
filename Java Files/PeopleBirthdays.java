import textio.TextIO;

public class PeopleBirthdays {

	public static void main (String [] args) {

		int i;
		int day;
		int count;
		boolean used [];

		count = 0;

		used = new boolean [365];


		for (i = 1; i < 365; i ++) {

			int birthday;

			birthday = (int)(Math.random() * 365);
			used [birthday] = true;
		}
	
		for (day = 1; day < 365; day ++) {

			
			if (used [day] == true) {

				count ++;
			}
		}

		System.out.println("There were " + count + " different birthdays from 365 people.");

	}
}