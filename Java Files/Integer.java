import textio.TextIO;

public class Integer {

	public static void main (String [] args) {

		
		int n;
		int maxDivisors;
		int numWithMax;

		maxDivisors = 0;
		numWithMax = 0;

		
		for (n = 1; n <= 10000; n ++) {

			int currentDivisors;
			int d;
			
			currentDivisors = 0;


			for (d = 1; d <= n; d ++) {


				if (n % d == 0) {

					currentDivisors ++;
				}

			if (currentDivisors > maxDivisors) {

				maxDivisors = currentDivisors;
				numWithMax = n;
			}

			}

		}
		
		System.out.println(numWithMax + " has the most divisors between 1 and 10000 at " + maxDivisors + " divisors.");
	}

}