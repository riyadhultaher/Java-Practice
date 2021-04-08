/*
* This program opens a window full of randomly colored squares. A disturbance
* moves randomly around in the window, randomly changing the color of each square
* that is visits. This program runs until the user closes the window
*/

public class RandomMosaicWalk {

	static int currentRow;
	static int currentColumn;

	/* 
	* The main method creates the window, fills it with random colors
	* then moves the disturbance in a random walk around the window as long
	* as the window is open.
	*/

	public static void main (String [] args) {

		Mosaic.open (16, 20, 25, 25);
		fillWithRandomColors ();
		currentRow = 8;
		currentColumn = 10;


		while (true) {

			changeToRandomColor (currentRow, currentColumn);
			randomMove ();
			Mosaic.delay (10);
		}
	}

	/* 
	* Fills the window with randomly colored squares.
	* Precondition : Mosaic window is open.
	* Postcondition : Each square is set to a random color.
	*/

	static void fillWithRandomColors () {

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

	static void changeToRandomColor (int rowNum, int colNum) {

		int red;
		int green;
		int blue;

		red = (int)(Math.random() * 256);
		green = (int)(Math.random() * 256);
		blue = (int)(Math.random() * 256);
		Mosaic.setColor (rowNum, colNum, red, green, blue);
	}

	/* 
	* Moves the disturbance.
	* Precondition : The global variables currentRow and currentColumn are in the
	* legal range of row and column numbers
	* Postcondition : currentRow or currentColumn is changed to one of the neighboring
	* positions: up, down, left, right. If it is moved outside the grid, then it is moved
	* to the opposite side of the grid.
	*/

	static void randomMove () {

		int directionNumber;

		directionNumber = (int)(Math.random() * 4);


		switch (directionNumber) {

			case 0 :
			currentRow --;


			if (currentRow < 0) {

				currentRow = 15;
			}
			
			break;
		
			case 1 :
			currentRow ++;


			if (currentRow > 15) {

				currentRow = 0;
			}
		
			break;

			case 2 :
			currentColumn --;


			if (currentColumn < 0) {

				currentColumn = 19;
			}
			
			break;

			case 3 :
			currentColumn ++;


			if (currentColumn > 19) {

				currentColumn = 0;
			}
		
			break;
		}
	}
}