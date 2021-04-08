import textio.TextIO;

public class CitySales {
	
	public static void main (String [] args) {

		try {

			TextIO.readFile("sales.dat");
			
		}
		
		catch (IllegalArgumentException e) {

		System.out.println("Cannot open file \"sales.dat\" for reading. Please make sure the file is present before running the program.");
		System.exit(1);
			
			}

		double salesTotal;
		int numberOfCitiesWithNoData;

		salesTotal = 0;
		numberOfCitiesWithNoData = 0;


		while (TextIO.eof() == false) {

		char ch;
		double sales;
		String dataString;


			do {

				ch = TextIO.getChar();

			} while (ch != ':');


			dataString = TextIO.getln();


			try {

				sales = Double.parseDouble(dataString);
				salesTotal += sales;
			}

			catch (NumberFormatException e) {

				numberOfCitiesWithNoData ++;
			}

		}
	
	
	if (numberOfCitiesWithNoData == 0) {

		System.out.println("Total number of sales is " + salesTotal + " with data received from all cities.");
	}

	else if (numberOfCitiesWithNoData == 1) {

		System.out.println("Total number of sales is " + salesTotal + " with data missing from one city.");
	}
	
	else {

		System.out.println("Total number of sales is " + salesTotal + " with data missing from " + numberOfCitiesWithNoData +  " cities.");
	}

	}
}