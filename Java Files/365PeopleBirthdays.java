import textio.TextIO;

public class 365PeopleBirthdays {

	public static void main (String [] args) {

		int i;
		int count;
		int day;
		boolean used [];

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