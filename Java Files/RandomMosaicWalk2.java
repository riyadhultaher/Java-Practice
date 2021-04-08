/*
* This program opens a window full of black squares. A disturbance
* moves randomly around in the window, adding a small amount of green 
* to each square that is visits. This program runs until the user closes the window
*/

public class RandomMosaicWalk2 {

    static int currentRow;
    static int currentColumn;

    /* 
    * The main method creates the window, fills it with black squares
    * then moves the disturbance in a random walk around the window as long
    * as the window is open.
    */

    public static void main (String [] args) {

      Mosaic.open (80, 80, 5, 5);
      currentRow = 40;
      currentColumn = 40;


      while (true) {

        addGreen (currentRow, currentColumn);
        randomMove ();
        Mosaic.delay (1);
      }
    }
    
    /*
    * Adds green to the current square.
    * Precondition: The global variables currentRow and currentColumn are in the 
    * legal range of row and column numbers.
    * Postcondition: Will make the current square greener.
    */

    private static void addGreen (int rowNumber, int columnNumber) {

      int green;
      int red;
      int blue;

      green = Mosaic.getBlue (rowNumber, columnNumber);
      green += 25;
      red = 0;
      blue = 0;

      Mosaic.setColor (rowNumber, columnNumber, red, green, blue);
    }

    /* 
    * Moves the disturbance.
    * Precondition : The global variables currentRow and currentColumn are in the
    * legal range of row and column numbers
    * Postcondition : currentRow or currentColumn is changed to one of the neighboring
    * positions: up, down, left, right. If it is moved outside the grid, then it is moved
    * to the opposite side of the grid.
    */

    private static void randomMove () {

      int directionNumber;

      directionNumber = (int)(Math.random() * 4);


      switch (directionNumber) {

        case 0 :
        currentRow --;


        if (currentRow < 0) {

          currentRow = 79;
        }
      
        break;
    
        case 1 :
        currentRow ++;


        if (currentRow > 79) {

          currentRow = 0;
        }
    
        break;

        case 2 :
        currentColumn --;


        if (currentColumn < 0) {

          currentColumn = 79;
        }
      
        break;

        case 3 :
        currentColumn ++;


        if (currentColumn > 79) {

          currentColumn = 0;
        }
    
        break;
      }
    }
  }