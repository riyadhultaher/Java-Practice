import java.util.*;

public class RandomIntArrayList {

	public void random (int numberOfInt, int maxValueOfInt) {

		ArrayList <java.lang.Integer> list;
		int randomInt;
		int i;
		int k;

		list = new ArrayList <java.lang.Integer> ();


		for (i = 0; i < numberOfInt; i ++) {


			do {

				randomInt = (int)(Math.random () * maxValueOfInt) + 1;
			
			} while (list.indexOf (randomInt) != -1);
			
			list.add (randomInt);
		}
	
		for (int j : list) {

			System.out.print(" " + j);
		}
	}
}