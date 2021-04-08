import textio.TextIO;

public class IntegerArray2 {

	public static void main (String [] args) {

		int n;
		int maxDivisors;
		int [] divisorArray;

		divisorArray = new int [10001];

		maxDivisors = 0;
		divisorArray [1] = 1;


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
	
		System.out.println("Among integers between 1 and 10000, the maximum number of divisors was " + maxDivisors);
		System.out.println("Numbers with that many divisors include:");


		for (n = 1; n <= 10000; n ++) {


			if (divisorArray [n] == maxDivisors) {

				System.out.println(n);
			}
		}

	}
}