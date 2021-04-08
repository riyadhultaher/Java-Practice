/*
* This program opens a window full of randomly colored squares. A disturbance
* moves randomly around in the window, changing the color of  a neighbor of each square
* that is visits. It will randomly take the color of randomRow or randomColumn and assign it to the neighbor.
* This program runs until the user closes the window
*/

public class RandomMosaicWalk3 {

	static int randomRow;
	static int randomColumn;

	/* 
	* The main method creates the window, fills it with random colors
	* then calls the neighborChange method.
	*/

	public static void main (String [] args) {

		Mosaic.open (16, 20, 25, 25);
		fillWithRandomColors ();


		while (true) {

			randomRow = (int)(Math.random () * 16);
			randomColumn = (int)(Math.random () * 20);
			neighborChange ();
			Mosaic.delay (1);
		}
	}

	/* 
	* Fills the window with randomly colored squares.
	* Precondition : Mosaic window is open.
	* Postcondition : Each square is set to a random color.
	*/

	private static void fillWithRandomColors () {

		int row;
		int column;


		for (row = 0; row < 16; row ++) {


			for (column = 0; column < 20; column ++) {

				changeToRandomColor (row, column);
			}
		}
	}

	/* 
	* Changes one square to a randomly selected color.
	* Precondition : The specified row and column are in the valid range of
	* row and column numbers.
	* Postcondition : The square in the specified row and column has been set to
	* a random color.
	*/

	private static void changeToRandomColor (int rowNum, int colNum) {

		int red;
		int green;
		int blue;

		red = (int)(Math.random() * 256);
		green = (int)(Math.random() * 256);
		blue = (int)(Math.random() * 256);
		Mosaic.setColor (rowNum, colNum, red, green, blue);
	}

	/* 
	* Changes the neighbor color.
	* Precondition : The global variables rowNeighbor and columnNeighbor are in the
	* legal range of row and column numbers
	* Postcondition : rowNeighbor or columnNeighbor is changed to one of the neighboring
	* positions: up, down, left, right. If it is moved outside the grid, then it is moved
	* to the opposite side of the grid.
	*/

	private static void neighborChange () {

		int row;
		int column;
		int red;
		int green;
		int blue;
		int directionNumber;

		directionNumber = (int)(Math.random() * 4);
		row = randomRow;
		column = randomColumn;


		switch (directionNumber) {

			case 0 :
			row = randomRow - 1;


			if (randomRow == 0) {

				row = 15;
			}
			
			break;
		
			case 1 :
			row = randomRow + 1;


			if (randomRow == 15) {

				row = 0;
			}
		
			break;

			case 2 :
			column = randomColumn - 1;


			if (randomColumn == 0) {

				column = 19;
			}
			
			break;

			case 3 :
			column = randomColumn + 1;


			if (randomColumn == 19) {

				column = 0;
			}
		
			break;
		}
	
		red = Mosaic.getRed (randomRow, randomColumn);
		green = Mosaic.getGreen (randomRow, randomColumn);
		blue = Mosaic.getBlue (randomRow, randomColumn);

		Mosaic.setColor (row, column, red, green, blue);
	}
}