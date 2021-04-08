import textio.TextIO;

public class RootCalculator {

	public static void main (String [] args) {

		boolean tryAgain;
		double inputA;
		double inputB;
		double inputC;
		double result;

		System.out.println ("This program will take input of three numbers indicated by the user and will return the larger of the two roots of the quadratic equation.");
		System.out.println ();


		do {

			System.out.println ("Please enter the first number.");
			inputA = TextIO.getDouble ();
			System.out.println ();
			System.out.println ("Please enter the second number.");
			inputB = TextIO.getDouble ();
			System.out.println ();
			System.out.println ("Please enter the third number.");
			inputC = TextIO.getDouble ();

			
			try {
				
				result = root (inputA, inputB, inputC);
				System.out.println ("Your result is " + result);
			}
			
			catch (IllegalArgumentException e) {

				System.out.println ("Unable to process.");
				System.out.println (e.getMessage ());
			}
			
			System.out.println ();
			System.out.println ("Would you like to try again?");
			tryAgain = TextIO.getBoolean ();
			System.out.println ();
		
		} while (tryAgain == true);
	
		System.out.println ();
	}

	private static double root (double a, double b, double c) throws IllegalArgumentException {
    
    	if (a == 0) {
      		
      		throw new IllegalArgumentException ("First number can't be zero.");
    	}
    	
    	else {
       		
       		double disc;

       		disc = b * b - 4 * a * c;
       		

       		if (disc < 0) {
          		
          		throw new IllegalArgumentException ("Discriminant < zero.");
       		}

       	return  (-b + Math.sqrt (disc)) / (2 * a);
    }
	}
}