/*
This program will roll a pair of dice 10000 times, 11 separate times
to find out the average number of rolls to achieve the desired total
of two dice.
*/

public class RollTheDiceAlternate {

	/*
	The main method will iterate all the possible totals then call the 
	computeRoll function to roll the dice 10000 times. The main method
	will then print a table showing the average number of rolls to get
	a given total per possible total.
	*/

	public static void main (String [] args) {

		int i;
		double averageNumberOfRolls;
		double [] averageTable;

		averageTable = new double [13]; 

		System.out.println ("This program will roll a pair of dice 10000 times for each possible total.");
		System.out.println ("It will then create a table for the average number of rolls it took to achieve that total.");
		System.out.println ();


		for (i = 2; i <= 12; i ++) {

			averageNumberOfRolls = computeRoll (i);
			averageTable [i] = averageNumberOfRolls;
		}
	
		System.out.println ("Total On Dice    Average Number of Rolls");
		System.out.println ("-------------    -----------------------");

		
		for (i = 2; i <= 12; i ++) {

			System.out.println ("     " + i + "               " + averageTable [i]);
		}

		System.out.println ();
	}

	/*
 	This method will roll two dice randomly until it achieves 10000 rolls. It will record the
 	average number of rolls it took.
 	*/

  	private static double computeRoll (int goal) {

    	int dice1;
    	int dice2;
    	int result;
    	double attempts;
    	double numberOfTimesGoalWasHit;
    	double average;

    	numberOfTimesGoalWasHit = 0.0;
    	attempts = 0.0;

   
    	do { 

      		result = 0;

      		dice1 = (int)(Math.random () * 6) + 1;
      		dice2 = (int)(Math.random () * 6) + 1;
      		result = dice1 + dice2;
      		attempts ++;


      		if (result == goal) {

      			numberOfTimesGoalWasHit ++;
      		}

     	} while (attempts < 10000.0);
  
     	average = attempts / numberOfTimesGoalWasHit;

     	return average;
  	}
}