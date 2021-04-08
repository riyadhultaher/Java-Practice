import java.util.*;
import textio.TextIO;

public class TransposeArray {

	public static void main (String [] args) {

		int rows;
		int columns;
		int [][] currentArray;
		int i;
		int j;
		int onLine;

		System.out.println ("This program will transpose an array of random integers.");
		System.out.println ();
		
		System.out.println ("Please specify the number of rows.");
		rows = TextIO.getInt ();
		System.out.println ("Please specify the number of columns.");
		columns = TextIO.getInt ();

		currentArray = new int [rows][columns];

		System.out.println ("The initial array is: ");
		System.out.println ();

		onLine = 0;


		for (i = 0; i < rows; i ++) {


			for (j = 0; j < columns; j ++) {

				currentArray [i][j] = (int)(Math.random () * 10);
				System.out.print (currentArray [i][j] + " ");
				onLine ++;


				if (onLine == rows) {

					System.out.println ();
					onLine = 0;
				}
			}
		}
	
		System.out.println ();
		currentArray = returnTranspose (currentArray, rows, columns);
		printTranspose (currentArray, rows, columns);	
	}

	private static int [][] returnTranspose (int [][] array, int rowNum, int colNum) {

		int i;
		int j;
		int [][] newArray;

		newArray = new int [rowNum][colNum];

		
		for (i = 0; i < rowNum; i ++) {


			for (j = 0; j < colNum; j ++) {

				newArray [i][j] = array [j][i];
			}
		}
	
		return newArray;
	}

	private static void printTranspose (int [][] array, int rowNum, int colNum) {

		int i;
		int j;
		int onLine;

		onLine = 0;

		System.out.println ();
		System.out.println ("The new array is: ");
		System.out.println ();

		
		for (i = 0; i < rowNum; i ++) {


			for (j = 0; j < colNum; j ++) {

				System.out.print (array [i][j] + " ");
				onLine ++;


				if (onLine == rowNum) {

					System.out.println ();
					onLine = 0;
				}
			}
		}
	}
}