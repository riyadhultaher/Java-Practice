import textio.TextIO;

/*
This program will take elements from the StatCalc class and allow a 
user to input numbers in order to find specific statistics behind a 
set of data. This includes the max, the min, the average, the total number
of numbers entered, the standard deviation, and the sum of all numbers.
*/

public class StatCalculator {

    /*
    The main method will continuously take data from the user. It will stop
    taking data once the user enters 0.It will then print out the six statistics 
    corresponding to the data.
    */

    public static void main (String [] args) {

        StatCalc calculator;
        double inputNumber;
        int count;
        double sum;
        double mean;
        double standardDeviation;
        double max;
        double min;

        calculator = new StatCalc ();

        System.out.println ("This program will take data from the user. It will then print out the total numbers entered, the sum, the average, the max, the min, and the standard deviation.");
        System.out.println ();
        System.out.println ("At any time, you can enter 0 if you are finished entering data.");
        System.out.println ();
        System.out.println ("Please enter the first number.");


        while (true) {

            inputNumber = TextIO.getDouble ();
            

            if (inputNumber == 0) {

                break;
            }
            
            calculator.enter (inputNumber);

            System.out.println ("Please enter the next number or enter 0 if you no longer wish to continue.");
            System.out.println ();
        }
    
        count = calculator.getCount ();
        sum = calculator.getSum ();
        mean = calculator.getMean ();
        standardDeviation = calculator.getStandardDeviation ();
        max = calculator.getMax ();
        min = calculator.getMin ();

        System.out.println ();
        System.out.println ("Count: " + count);
        System.out.println ("Sum: " + sum);
        System.out.println ("Average: " + mean);
        System.out.println ("Standard Deviation: " + standardDeviation);
        System.out.println ("Max: " + max);
        System.out.println ("Min: " + min);
    }
}