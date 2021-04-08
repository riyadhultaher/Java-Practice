public class IntegerArray {

	static int numberOfMaxDivisors;

	public static void main (String [] args) {

		int [] divisorArray;
		int maxDivisors;
		int n;

		divisorArray = new int [10001];
		maxDivisors = 0;


		for (n = 1; n <= 10000; n ++) {

			int d;
			int currentDivisors;

			currentDivisors = 0;


			for (d = 1; d <= n; d ++) {


				if (n % d == 0) {

					currentDivisors ++;
				}
				
				divisorArray [n] = currentDivisors;


				if (currentDivisors > maxDivisors) {

					maxDivisors = currentDivisors;
				}
			}
		}
		
		for (n = 1; n <= 10000; n ++) {
		
			
			if (divisorArray [n] == maxDivisors) {

				numberOfMaxDivisors ++;
			}
		}
		
		System.out.println ("Between the numbers 1 and 10000, there were " + numberOfMaxDivisors + " divisors with the maximum of " + maxDivisors + " divisors. These numbers were:");

		
		for (n = 1; n <= 10000; n ++) {


			if (divisorArray [n] == maxDivisors) {

				System.out.println (n);
			}
		}

	}
}