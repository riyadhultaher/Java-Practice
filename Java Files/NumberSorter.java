import java.util.*;
import textio.TextIO;

public class NumberSorter {

	public static void main (String [] args) {

		ArrayList <Double> list;
		double userInput;
		int lastPlace;
		int maxLoc;

		list = new ArrayList <Double> ();

		System.out.println ("Please enter up to 100 numbers for this program to sort from smallest to largest.");
		System.out.println ("Press 0 when you are finished.");
		System.out.println ();


		do {

			userInput = TextIO.getDouble ();
			list.add (userInput);


			if (list.size () == 100) {

				break;
			}
		
		} while (userInput != 0);
	
		
		if (list.size () != 100) {

			list.remove (list.size () -1);
		}

		System.out.println ("Your list unsorted is: ");
		System.out.println ();


		for (double number : list) {

			System.out.print (number + " ");
		}
	
		System.out.println ();
		System.out.println ();


		for (lastPlace = list.size () - 1; lastPlace > 0; lastPlace --) {

			int i;
			double temp;

			maxLoc = 0;


			for (i = 1; i <= lastPlace; i ++) {

				if (list.get (i) > list.get (maxLoc)) {

					maxLoc = i;
				}
			}
		
			temp = list.get (maxLoc);
			list.set (maxLoc, list.get (lastPlace));
			list.set (lastPlace, temp);
		}
	
		System.out.println ("Your list sorted is: ");
		System.out.println ();


		for (double number : list) {

			System.out.print (number + " ");
		}
		
		System.out.println ();
	}
}