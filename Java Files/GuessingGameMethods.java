import textio.TextIO;

/* 
* This program will choose a random number between 1 and 100. The user will have six chances to get
* it correct. If they get the exact number then they win, if all of the attempts are used up, they lose.
* The program will let the user know if their guess was too high or too low.
*/

public class GuessingGameMethods {

	static int gamesPlayed;
	static int gamesWon;
	static int gamesLost;

	/*
	* Preconditions: User must be able to input numbers.
	* Postconditions: This main method will run the playGame method then will ask the user if they want to play
	* again. Once the user no longer wishes to continue the method will print out how many games they played, how
	* many they won, and how many they lost.
	*/

	public static void main (String [] args) {

		boolean tryAgain;

		System.out.println ("This program will choose a random number between 1 and 100. You have six guesses to get it right. The program will let you know if your guess is too high or too low.");
		System.out.println ();

		
		do {

			playGame ();

			System.out.println ("Would you like to play again?");
			tryAgain = TextIO.getBoolean ();
		
		} while (tryAgain == true);
	
		System.out.println ("You played " + gamesPlayed + " games, winning " + gamesWon + " and losing " + gamesLost + " of those games.");
		System.out.println ();
	}

	/*
	* Preconditions: None.
	* Postconditions: This method will choose a random number for the user to guess. The method continues to run until
	* the user gets the right number or the user makes their sixth guess. The method tells the user if they are too high 
	* or too low.
	*/

	private static void playGame () {

		int computerNumber;
		int inputNumber;
		int numberOfGuesses;

		numberOfGuesses = 0;

		computerNumber = (int)(Math.random () * 100) + 1;

		
		while (true) {
			

			if (numberOfGuesses >= 1) {

				System.out.println ("Make another guess.");
			}
			
			else {

				System.out.println ("What is your first guess?");
			}
			
			inputNumber = TextIO.getInt ();
			numberOfGuesses ++;
			gamesPlayed ++;


			if (inputNumber == computerNumber) {

				System.out.println ("You won! The number was " + computerNumber + ". You achieved this in " + numberOfGuesses + " guesses.");
				gamesWon ++;
				return;
			}
	
			if (numberOfGuesses == 6) {

				System.out.println ("Sorry, you lost. The number was " + computerNumber);
				gamesLost ++;
				return;
			}
			
			if (inputNumber > computerNumber) {

				System.out.println ("Too high! You have " + (6 - numberOfGuesses) + " remaining.");
			}

			if (inputNumber < computerNumber) {

				System.out.println ("Too low! You have " + (6 - numberOfGuesses) + " remaining.");
			}
		}
	}
}