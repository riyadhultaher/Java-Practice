/*
This program will create an endless loop of starting with a dark square
in the center and getting darker as it reaches the border, eventually
becoming the whole thing dark.
*/

public class RandomMosaicWalk4 {

	/*
	The main method will call the strobe method and repeat the cycle.
	*/

	public static void main (String [] args) {

		Mosaic.open (41, 41, 6, 6);
		
		
		while (true) {

			Mosaic.delay (1000);
			strobe ();
			Mosaic.fill (0, 0, 0);
		}
	}

	private static void outlineRectangle (int topRow, int leftColumn, int widthOfOutline, int heightOfOutline, int redLevel, int greenLevel, int blueLevel) {

		int row;
		int col;


		for (col = leftColumn; col <= leftColumn + widthOfOutline - 1; col ++) {

			Mosaic.setColor (topRow, col, redLevel, greenLevel, blueLevel);
			Mosaic.setColor (topRow + heightOfOutline - 1, col, redLevel, greenLevel, blueLevel);
		}
			
		for (row = topRow; row <= topRow + heightOfOutline - 1; row ++) {

			Mosaic.setColor (row, leftColumn, redLevel, greenLevel, blueLevel);
			Mosaic.setColor (row, leftColumn + widthOfOutline - 1, redLevel, greenLevel, blueLevel);
		}
	}

	private static void strobe () {

		int left;
		int top;
		int size;
		int brightness;

		left = 20;
		top = 20;
		size = 1;
		brightness = 50;


		while (left >= 0) {

			outlineRectangle (top, left, size, size, brightness, brightness, brightness);
			Mosaic.delay (200);

			left --;
			top --;
			size += 2;
			brightness += 10;
		}
	}
}