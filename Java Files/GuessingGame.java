import textio.TextIO;

public class GuessingGame {

    static int gamesPlayed;
    static int gamesWon;
    static int gamesLost;

    public static void main (String [] args) {

        boolean playAgain;

        System.out.println ("This program randomly selects a number between 1 and 100. You have six tries to get it correct. It will let you know if you are too high or too low. Good luck!");


        do {

            playGame ();
            System.out.println ("Would you like to play again? Answer true or false.");
            playAgain = TextIO.getBoolean ();
      
        } while (playAgain == true);

        System.out.println ("You played " + gamesPlayed + " games, winning " + gamesWon + " and losing " + gamesLost + " of those games.");
        System.out.println ("Goodbye.");

    }

    static void playGame () {

        int computerNumber;
        int guessCount;
        int usersGuess;

        computerNumber = (int)(Math.random () * 100) + 1;
        guessCount = 0;
        gamesPlayed ++;

        System.out.println ("What is your first guess?");
        
        
        while (true) {

            usersGuess = TextIO.getInt ();
            guessCount ++;


            if (usersGuess == computerNumber) {

               
                switch (guessCount) {

                    case 1 :
                    System.out.println ("You won! My number was " + computerNumber + ". It took you " + guessCount + " try to get it right.");
                    break;

                    default :
                    System.out.println ("You won! My number was " + computerNumber + ". It took you " + guessCount + " tries to get it right.");
                    break;
                }
              
                gamesWon ++;
                break;
            }
        
            if (guessCount == 6) {

                System.out.println ("Sorry you lose. My number was " + computerNumber + ". Better luck next time.");
                gamesLost ++;
                break;
            }

            if (usersGuess < computerNumber) {

                
                switch (6 - guessCount) {

                    case 1 :
                    System.out.println ("That's too low. Try again. You have " + (6 - guessCount) + " try remaining.");
                    break;

                    default :
                    System.out.println ("That's too low. Try again. You have " + (6 - guessCount) + " tries remaining.");
                    break;
                }   
            }

            else {


                if (usersGuess > computerNumber) {

                    
                    switch (6 - guessCount) {

                    case 1 :
                    System.out.println ("That's too high. Try again. You have " + (6 - guessCount) + " try remaining.");
                    break;

                    default :
                    System.out.println ("That's too high. Try again. You have " + (6 - guessCount) + " tries remaining.");
                    break;
                
                    }   
                }
            }

        }
    }

}