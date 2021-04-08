import textio.TextIO;

/* 
* This program will open the file "sales.dat" and read the data from it. This file does
* not actually exist but the file is supposed to have a list of cities with the dollar 
* amount of sales that city has earned. If the city had not made any sales there will 
* not be a number. The purpose of this program is to read the data from the file and
* display the total sales from all cities and the number of cities that is missing data.
*/

public class CitySalesMethods {

	static double totalSales;
	static int citiesWithNoData;

	/* 
	* Preconditions: The file "sales.dat" must exist in the same folder and must be available
	* to open. (This file does not actually exist).
	* Postconditions: This method will attempt to open the file and throw an illegal argument
	* exception if it cannot be opened. This method will have the total city sales and number of
	* cities with no data to returned to it then printed.
	*/

	public static void main (String [] args) {

		try {

			TextIO.readFile ("sales.dat");
		}
	
		catch (IllegalArgumentException e) {

			System.out.println ("Unable to read file. Please make sure the file exists and accessible before running the program.");
			System.exit (1);
		}

		totalSales = computeTotalSales (totalSales, citiesWithNoData);
		

		switch (citiesWithNoData) {

			case 0 :
			System.out.println ("Total sales were " + totalSales + " with data missing from no cities.");
			break;

			case 1 :
			System.out.println ("Total sales were " + totalSales + " with data missing from one city.");
			break;

			default :
			System.out.println ("Total sales were " + totalSales + " with data missing from " + NumberToWordConverter.numberToWord (citiesWithNoData) + " cities.");
			break;
		}

		System.out.println ();
	}

	/*
	* Preconditions: The file "sales.dat" must be passed into this method.
	* Postconditions: This method will read each line in the file disposing of all characters until it
	* reaches the ':' character. The method will then store the number value in sales and add it to totalSales.
	* If there is no number value, the method will throw a number format exception and add one to citiesWithNoData.
	* This method computes the sales portion.
	*/

	private static double computeTotalSales (double totalSales, int citiesWithNoData) {


		while (TextIO.eof () == false) {

			double sales;
			char ch;
			String dataString;

			sales = 0;


			do {

				ch = TextIO.getChar ();
			
			} while (ch != ':');
		
			dataString = TextIO.getln ();


			try {

				sales = Double.parseDouble (dataString);
				totalSales += sales;
			}
		
			catch (NumberFormatException e) {

				citiesWithNoData ++;
			}
		}
	
		return totalSales;
	}
}