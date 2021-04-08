import java.util.*;
import textio.TextIO;

/*
This program will test out the RandomIntArrayList class.
*/

public class RandomIntArrayTest {

	public static void main (String [] args) {

		int totalInt;
		int maxValue;
		RandomIntArrayList intList;

		intList = new RandomIntArrayList ();

		System.out.println ("This program will list random integers up to a max value of your choosing and amount of your choosing.");
		System.out.println ();
		System.out.println ("Please enter the number of integers to be in the list.");
		totalInt = TextIO.getInt ();
		

		do {
			
			System.out.println ("Please enter the max value of the integers.");
			maxValue = TextIO.getInt ();


			if (maxValue < totalInt) {

				System.out.println ("Max value cannot be less than total integers.");
			}

		} while (maxValue < totalInt);

		intList.random (totalInt, maxValue);

		System.out.println ();
	}
}