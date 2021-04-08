import textio.TextIO;

public class ThreeBirthdays2 {

	public static void main (String [] args) {

		int [] numFound;
		int count;

		numFound = new int [365];

		count = 0;


		while (true) {

			int birthday;
			int last;

			birthday = (int)(Math.random() * 365);
			count ++;

			last = birthday % 10;


			if (birthday > 10 && birthday < 20) {

				System.out.println("Person number " + count + " has a birthday on the " + birthday + "th day of the year.");
			}
			

			else {


				switch (last) {

					case 1 :
					System.out.println("Person number " + count + " has a birthday on the " + birthday + "st day of the year.");
					break;

					case 2 :
					System.out.println("Person number " + count + " has a birthday on the " + birthday + "nd day of the year.");
					break;

					case 3 :
					System.out.println("Person number " + count + " has a birthday on the " + birthday + "rd day of the year.");
					break;

					default :
					System.out.println("Person number " + count + " has a birthday on the " + birthday + "th day of the year.");


				}
			}

			numFound [birthday] ++;


			if (numFound [birthday] == 3) {

				break;
			}

			}
		
		System.out.println("We found three similar birthdays after going through " + count + " people.");

		}
	}