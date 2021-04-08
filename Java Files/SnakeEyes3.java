/*
This program will randomly roll two dice until the sum turns up snake eyes.
This program will call a function to roll the dice and will return the number
of attempts back to the main method. If the sum is not snake eyes, the function
will throw an IllegalArgumentException.
*/

public class SnakeEyes3 {

  /*
  The main method will call the computeSnakeEyes function and will print out how many
  attempts it took once snake eyes is achieved.
  */

  public static void main (String [] args) {

    int snakeEyes;
    int attempts;

    snakeEyes = 2;

    System.out.println ("This program will print out how many attempts it took to achieve snake eyes.");
    System.out.println ();

    attempts = computeSnakeEyes (snakeEyes);

    System.out.println ("It took " + attempts + " attempts to achieve snake eyes.");
    System.out.println ();

  }

 /*
 This method will roll two dice randomly until it achieves snake eyes. It will record how
 many attempts it took.
 */

  private static int computeSnakeEyes (int goal) {

    int dice1;
    int dice2;
    int result;
    int attempts;

    result = 0;
    attempts = 0;

   
    if (goal < 2 || goal > 12) {

        throw new IllegalArgumentException ("Impossible total.");
      }

   
    do { 

      dice1 = (int)(Math.random () * 6) + 1;
      dice2 = (int)(Math.random () * 6) + 1;
      result = dice1 + dice2;
      attempts ++;

     } while (result != goal);
  
     return attempts;
  }
}