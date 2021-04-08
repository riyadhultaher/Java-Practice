/*
This program will record the average number of rolls per each possible total
when two dice are rolled. It will then print out each possible total's average
in a table.
*/

public class RollTheDice2 {

	static int attempts;

	/*
	The main method will call the computeAverage method. It will then print out a 
	table to display these findings.
	*/

	public static void main (String [] args) {

		int i;
		int [] averages;
		double [] averagesTable;

		averages = new int [13];
		averagesTable = new double [13];

		System.out.println ("This program will roll a pair of dice 10000 times.");
		System.out.println ("It will make note of each possible total then calculate the average number of rolls per total.");
		System.out.println ("This program will then create a table displaying all the findings.");
		System.out.println ();

		averages = computeAverage (averages);
		

		for (i = 2; i < 11; i ++) {

			averagesTable [i] = 10000 / averages [i];
		}
	
		System.out.println ("Total On Dice    Average Number of Rolls");
		System.out.println ("-------------    ------------------------");


		for (i = 2; i < 11; i ++) {

			System.out.println ("      " + i + "                     " + averagesTable [i]);
		}
	}

	/*
	This method will take the result from the computeRoll method and store them in
	the corresponding element in the array averageTotals.
 	*/

  	private static int [] computeAverage (int [] averageTotals) {

  		int totalRoll;


  		while (attempts < 10000) {

  			totalRoll = computeRoll ();


  			switch (totalRoll) {

  				case 2 :
  				averageTotals [2] ++;
  				break;

  				case 3 :
  				averageTotals [3] ++;
  				break;

  				case 4 :
  				averageTotals [4] ++;
  				break;

  				case 5 :
  				averageTotals [5] ++;
  				break;

  				case 6 :
  				averageTotals [6] ++;
  				break;

  				case 7 :
  				averageTotals [7] ++;
  				break;

  				case 8 :
  				averageTotals [8] ++;
  				break;

  				case 9 :
  				averageTotals [9] ++;
  				break;

  				case 10 :
  				averageTotals [10] ++;
  				break;

  				case 11 :
  				averageTotals [11] ++;
  				break;

  				case 12 :
  				averageTotals [12] ++;
  				break;
  			}
  		}
  	
  		return averageTotals;
  	}

  	/*
  	This method will randomly roll two dice and return the result to computeAverage.
  	*/

  	private static int computeRoll () {

    	int dice1;
   		int dice2;
   		int result;

    	result = 0;

      	dice1 = (int)(Math.random () * 6) + 1;
      	dice2 = (int)(Math.random () * 6) + 1;
      	result = dice1 + dice2;
      	attempts ++;
	
		return result;
  	}
}