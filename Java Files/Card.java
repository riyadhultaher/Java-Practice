/*
This class will allow other classes to create one of the 52 cards available
plus a joker.
*/

public class Card {

    public final static int SPADES = 0;
    public final static int CLUBS = 1;
    public final static int HEARTS = 2;
    public final static int DIAMONDS = 3;
    public final static int JOKER = 4;

    public final static int ACE = 1;
    public final static int JACK = 11;
    public final static int QUEEN = 12;
    public final static int KING = 13;

    private final int suit;
    private final int value;

    public Card () {

        suit = JOKER;
        value = 1;
    }

    public Card (int theValue, int theSuit) {

        if (theSuit != SPADES && theSuit != CLUBS && theSuit != HEARTS && theSuit != DIAMONDS && theSuit != JOKER) {

            throw new IllegalArgumentException ("Illegal playing card suit.");
        }
    
        if (theSuit != JOKER && (theValue < 1 || theValue > 13)) {

            throw new IllegalArgumentException ("Illegal playing card value.");
        }
    
        suit = theSuit;
        value = theValue;
    }

    public int getSuit () {

        return suit;
    }

    public int getValue () {

        return value;
    }

    public String getSuitAsString () {

        switch (suit) {

            case 0 :
            return "Spades";

            case 1 :
            return "Clubs";

            case 2 :
            return "Hearts";

            case 3 :
            return "Diamonds";

            default :
            return "Joker";
        }
    }

    public String getValueAsString () {

        if (suit == JOKER) {

            return "" + value;
        }

        else {

            switch (value) {

                case 1 :
                return "Ace";

                case 2 :
                return "2";

                case 3 :
                return "3";

                case 4 :
                return "4";

                case 5 :
                return "5";

                case 6 :
                return "6";

                case 7 :
                return "7";

                case 8 :
                return "8";

                case 9 :
                return "9";

                case 10 :
                return "10";

                case 11 :
                return "Jack";

                case 12 :
                return "Queen";

                default :
                return "King";
            }    
        }
    }

    public String toString () {

        if (suit == JOKER) {


            if (value == 1) {

                return "Joker";
            }
        
            else {

                return "Joker #" + value;
            }
        }
    
        else {

            return getValueAsString () + " of " + getSuitAsString ();
        }
    }
} 