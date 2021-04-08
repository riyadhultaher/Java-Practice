import textio.TextIO;

/*
This program will let the user play Blackjack with the computer as a dealer.
Once the game is over, the program will ask the user if they want to 
play again.
*/

public class Blackjack {

	public static int gamesPlayed;
	public static int gamesWon;
	public static int gamesLost;
	public static int currentMoney;
	public static int bet;

	/*
	The main method will The main method will call the playBlackjack method to play one game. It will then
	ask the player if they want to play another game. This continues repeatedly until the
	player no longers wishes to play anymore. This method will also record the number of 
	games played, games won, and games lost.
	*/

	public static void main (String [] args) {

		boolean winOrLose;
		boolean instruction;
		boolean playAgain;

		System.out.println ();
		System.out.println ("WELCOME TO BLACKJACK!");
		System.out.println ();
		System.out.println ();
		System.out.println ("If you would like to read the instructions, please enter Yes.");
		System.out.println ("Otherwise, you can enter No to start the game.");
		System.out.println ();

		instruction = TextIO.getBoolean ();
		

		while (instruction == true) {

			System.out.println ("First, two cards are dealt into each player's hand. If the dealer's hand has a value of 21 at this point, then the dealer wins. Otherwise, if the user has 21, then the user wins.");
			System.out.println ("Note that the dealer wins on a tie, so if both players have Blackjack, then the dealer wins.");
			System.out.println ();
			System.out.println ("If the game has not ended, the user gets a chance to add some cards to their hand.");
			System.out.println ("In this phase, the user sees their own cards and sees one of the dealer's two cards.");
			System.out.println ();
			System.out.println ("The user makes a decision whether to Hit, which means to add another card to their hand, or to Stand, which means to stop taking cards.");
			System.out.println ("If the user Hits, there is a possibility that the user will go over 21. In that case, the game is over and the user loses. If not, then the process continues. The user gets to decide again whether to Hit or Stand.");
			System.out.println ("If the user Stands, the game will end, but first the dealer gets a chance to draw cards. The dealer only follows rules, without any choice. The rule is that as long as the value of the dealer's hand is less than or equal to 16, the dealer Hits.");
			System.out.println ();
			System.out.println ("The user should see all the dealer's cards at this point.");
			System.out.println ();
			System.out.println ("The winner can be determined: If the dealer has gone over 21, the user wins.");
			System.out.println ("Otherwise, if the dealer's total is greater than or equal to the user's total, then the dealer wins. Otherwise, the user wins.");
			System.out.println ("You will start out with $100 to bet.");
			System.out.println ();
			System.out.println ();
			System.out.println ("Do you want to read the instructions again?");

			instruction = TextIO.getBoolean ();
		}
		
		System.out.println ();
		System.out.println ("STARTING GAME...");
		System.out.println ();


		do {
			
			currentMoney = 100;


			while (true) {

				winOrLose = playBlackjack ();
				gamesPlayed ++;


				if (winOrLose == true) {

					gamesWon ++;
					currentMoney += bet;
					System.out.println ();
					System.out.println ("You won that game.");
					System.out.println ("You currently have " + currentMoney + " dollars remaining.");
				}
		
				else {

					gamesLost ++;
					currentMoney -= bet;
					System.out.println ();
					System.out.println ("You lost that game.");
					System.out.println ("You currently have " + currentMoney + " dollars remaining.");
				}
		
				if (currentMoney == 0) {

					System.out.println ("You ran out of money!");
					break;
				}
			}
			
			System.out.println ("You played " + gamesPlayed + " games, winning " + gamesWon + " and losing " + gamesLost + " of those games.");
			System.out.println ();
			System.out.println ("Do you want to play again?");
			
			playAgain = TextIO.getBoolean ();
		
		} while (playAgain == true);
	
		System.out.println ();
		System.out.println ();
		System.out.println ("THANKS FOR PLAYING!");

		System.out.println ();
	}

	/*
	This method will allow the user to play one game of Blackjack. A Deck object is
	created from the Deck class to represent the deck of cards. Two BlackjackHand objects
	are created from the BlackjackHand class to represent the dealer's hand and the user's
	hand.
	*/

	public static boolean playBlackjack () {

		Deck deck;
		BlackjackHand dealerHand;
		BlackjackHand userHand;
		Card card;
		char hitOrStand;

		deck = new Deck ();
		dealerHand = new BlackjackHand ();
		userHand = new BlackjackHand ();

		deck.shuffle ();
		dealerHand.clear ();
		userHand.clear ();

		System.out.println ("How much would you like to bet?");
		bet = TextIO.getInt ();


		while (bet > currentMoney) {

			System.out.println ("You cannot bet more than you have!");
			System.out.println ("Please enter a number less than or equal to " + currentMoney);
			bet = TextIO.getInt ();
		}
	
		System.out.println ("CARDS ARE BEING DEALT...");
		System.out.println ();

		System.out.println ("The cards currently in your hand are: ");

		card = deck.dealCard ();
		userHand.addCard (card);
		System.out.println (card.toString ());
		card = deck.dealCard ();
		userHand.addCard (card);
		System.out.println (card.toString ());

		System.out.println ("Your current Blackjack value is " + userHand.getBlackjackValue ());
		System.out.println ();
		
		System.out.println ("The cards currently in the dealer's hand are: ");

		card = deck.dealCard ();
		dealerHand.addCard (card);
		System.out.println (card.toString ());
		System.out.println ("CARD HIDDEN");

		System.out.println ("The dealer's current Blackjack value is " + dealerHand.getBlackjackValue ());
		System.out.println ();


		if (userHand.getBlackjackValue () == 21) {

			return true;
		}

		do {

			System.out.println ("Press H if you want to Hit or S if you want to Stand.");
			hitOrStand = TextIO.getChar ();


			while ( ! (hitOrStand == 'H' || hitOrStand == 'h' || hitOrStand == 'S' || hitOrStand == 's')) {

				System.out.println ();
				System.out.println ("Invalid response. Please try again.");
				hitOrStand = TextIO.getChar ();
			}

			if (hitOrStand == 'H' || hitOrStand == 'h') {

				System.out.println ();
				card = deck.dealCard ();
				userHand.addCard (card);
				
				System.out.println ("The card that has been added is: ");
				System.out.println (card.toString ());
				System.out.println ("Your new Blackjack value is " + userHand.getBlackjackValue ());
				System.out.println ();


				if (userHand.getBlackjackValue () > 21) {

					return false;
				}
			}

			if (hitOrStand == 'S' || hitOrStand == 's') {

				System.out.println ();
				card = deck.dealCard ();
				dealerHand.addCard (card);

				System.out.println ("The hidden card is: ");
				System.out.println (card.toString ());
				System.out.println ("The dealer's new Blackjack value is " + dealerHand.getBlackjackValue ());
				System.out.println ();
				

				do {

					
					if (dealerHand.getBlackjackValue () > 16) {

						break;
					}

					card = deck.dealCard ();
					dealerHand.addCard (card);

					System.out.println ("The card that has been added to the dealer is: ");
					System.out.println (card.toString ());
					System.out.println ("The dealer's new Blackjack value is " + dealerHand.getBlackjackValue ());
				
				} while (dealerHand.getBlackjackValue () < 16);
			}

		} while ( ! (hitOrStand == 'S' || hitOrStand == 's'));
	

		if (userHand.getBlackjackValue () <= 21 && userHand.getBlackjackValue () > dealerHand.getBlackjackValue ()) {

			return true;
		}
	
		else {

			return false;
		}
	}
}