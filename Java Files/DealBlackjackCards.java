import textio.TextIO;

/*
This program will take elements of the Hand class, Card class, and Deck class.
It will use the Blackjack class to deal a random number between 2 and 6
to deal from the deck to be added to the hand. It will then print out all the
cards in the hand and the blackjack value. This will continue as long as the user
wants to receive cards.
*/

public class DealBlackjackCards {

	/*
	The main method will deal a card from the Deck class and add it to the 
	Blackjack hand. It will then print out the current cards in the hand and
	the blackjack value.
	*/

	public static void main (String [] args) {

		Deck deck;
		BlackjackHand hand;
		Card card;
		int blackjackValue;
		int cardsDealtAtOnce;
		boolean tryAgain;
		int i;

		deck = new Deck ();
		hand = new BlackjackHand ();
		cardsDealtAtOnce = 0;
		tryAgain = false;

		System.out.println ("This program will add between 2 to 6 cards to the current blackjack hand. It will print out the suit of value of all cards and the blackjack value.");
		System.out.println ();


		do {

			hand.clear ();
			cardsDealtAtOnce = (int)(Math.random () * 5) + 2;
			System.out.println ("The cards currently in your hand are: ");

			for (i = 0; i < cardsDealtAtOnce; i ++) {

				deck.shuffle ();
				card = deck.dealCard ();
				hand.addCard (card);
				System.out.println (card.toString ());
			}
			
			blackjackValue = hand.getBlackjackValue ();
			System.out.println ("Your blackjack value is " + blackjackValue);

			System.out.println ();
			System.out.println ("Do you want to try again?");
			tryAgain = TextIO.getBoolean ();
		
		} while (tryAgain == true);
	}
}