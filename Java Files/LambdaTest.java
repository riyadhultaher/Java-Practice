public class LambdaTest {

	public static final ArrayProcessor max = array -> {

			int i;
			double currentMax;

			currentMax = array [0];


			for (i = 0; i < array.length; i ++) {


				if (array [i] > currentMax) {

					currentMax = array [i];
				}
			}
		
			return currentMax;
		};
	
	public static final ArrayProcessor min = array -> {

			int i;
			double currentMin;

			currentMin = array [0];


			for (i = 0; i < array.length; i ++) {


				if (array [i] < currentMin) {

					currentMin = array [i];
				}
			}
		
			return currentMin;
		};
	
	public static final ArrayProcessor sum = array -> {

			int i;
			double currentSum;

			currentSum = 0;

			
			for (i = 0; i < array.length; i ++) {

				currentSum += array [i];
			}
		
			return currentSum;
		};
	
	public static final ArrayProcessor average = array -> 

		sum.apply (array) / array.length;


	public static void main (String [] args) {

		double [] list = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		System.out.println ("Sum of list is " + sum.apply (list));
		System.out.println ("Average of list is " + average.apply (list));
		System.out.println ("Max of list is " + max.apply (list));
		System.out.println ("Min of list is " + min.apply (list));
		System.out.println ("Count of the number 5 is " + counter (5.0).apply (list));

		System.out.println ();
	}
	
	public static ArrayProcessor counter (double value) {

		return array -> {

			int i;
			int counter;

			counter = 0;

			
			for (i = 0; i < array.length; i ++) {


				if (array [i] == value) {

					counter ++;
				}
			}
		
			return counter;
		};
	}
}