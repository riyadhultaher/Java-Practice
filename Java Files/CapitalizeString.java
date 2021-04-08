import textio.TextIO;

/*
This program will capitalize the first letter of each word in a string
inputted by the user.
*/

public class CapitalizeString {

    /*
    The main method will call the capitalizeLetters method and will ask the user
    if they would like to input another string.
    */

    public static void main (String [] args) {

        String line;
        boolean tryAgain;

        System.out.println ("This program will take a line from the user and capitalize the first letter of each word.");
        System.out.println ();


        do {

            System.out.println ("Please enter a line of text or enter 0 if you do not wish to continue.");
            line = TextIO.getln ();


            if (line.equals ("0")) {

                break;
            }
             
            capitalizeLetters (line);
            System.out.println ();

            System.out.println ("Would you like to input another line?");

            tryAgain = TextIO.getBoolean ();
       
        } while (tryAgain == true);

    
        System.out.println ("Goodbye.");
        System.out.println ();
    }

   /*
   This method will look for the first letter of each word and capitalize it.
   It will print out the line in full with capitalized first letters of each word.
   */

    private static void capitalizeLetters (String stringLine) {

        int i;
        char ch;
        char prevCh;

        prevCh = '.';

        for (i = 0; i < stringLine.length (); i ++) {

            ch = stringLine.charAt (i);


            if ((Character.isLetter (ch)) && ( ! (Character.isLetter (prevCh)))) {

                System.out.print (Character.toUpperCase (ch));
            }

            else {

                System.out.print (ch);
            }   
            
            prevCh = ch;
       }          
    }
}