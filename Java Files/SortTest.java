import java.util.*;

public class SortTest {

	public static void main (String [] args) {

		int [] testArray;
		double selectionSeconds;
		double sortSeconds;
		int i;

		testArray = new int [100000];


		for (i = 0; i < testArray.length; i ++) {

			testArray [i] = (int)(Math.random () * 10000);
		}

		selectionSeconds = selectionSort (testArray);
		sortSeconds = arraySort (testArray);

		System.out.println ("It took " + selectionSeconds + " seconds to sort using selectionSort and " + sortSeconds + " seconds to sort using Array.sort.");

	}

	public static double selectionSort (int [] array) {

		long startTime;
        long endTime;
        long compTime;
        double seconds;
        int lastPlace;
        int maxLoc;
        int temp;
        int j;

        startTime = System.nanoTime ();

        for (lastPlace = array.length - 1; lastPlace > 0; lastPlace --) {
         
        	maxLoc = 0;
      
      		
      		for (j = 1; j <= lastPlace; j ++) {
         		
         		if (array [j] > array [maxLoc]) {
              
            		maxLoc = j;  
         		}
      		}
      
      		temp = array [maxLoc];
      		array [maxLoc] = array [lastPlace];
      		array [lastPlace] = temp;
   		}

        endTime = System.nanoTime ();
        compTime = endTime - startTime;
        seconds = compTime / 1000000000.0;

        return seconds;
	}

	public static double arraySort (int [] array) {

		long startTime;
        long endTime;
        long compTime;
        double seconds;

        startTime = System.nanoTime ();

        Arrays.sort (array);

        endTime = System.nanoTime ();
        compTime = endTime - startTime;
        seconds = compTime / 1000000000.0;

        return seconds;
	}
}