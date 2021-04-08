import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.canvas.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.input.*;
import javafx.geometry.*;

/*
This program will let the user play blackjack and will display a GUI that
updates based on whether they choose to hit or stand.
*/

public class Blackjack2D extends Application {

	private BorderPane root;
	private Canvas canvas;
	private GraphicsContext g;
	private Image cardImage;
	private double height;
	private double width;

	private Deck deck;
	private BlackjackHand dealerHand;
	private BlackjackHand userHand;
	private Card card;

	private int userCardCount;
	private int dealerCardCount;
	private boolean inProgress;

	private Button hit;
	private Button stand;
	private Button newGame;
	private Button instructions;
	private TextField betTextField;
	private Button go;
	private HBox buttonBar;

	private String instructionsLabel;

	private String dealersCards = "Dealer's Cards:";
	private String yourCards = "Your Cards:";
	private String message;
	private String message2;
	private String betValue;
	private int bet;
	private int pot = 100;

	/*
	The main method will launch the program.
	*/

	public static void main (String [] args) {

		launch ();
	}

	public void start (Stage stage) {

		Scene scene;
		int x;

		cardImage = new Image ("cards.png");
		root = new BorderPane ();
		root.setStyle ("-fx-border-color: darkred; -fx-border-width: 3px 3px 0px 3px");

		instructionsLabel = ("1. Blackjack starts with players making bets." + "\n" + "2. Dealer deals two cards to players and two to themselves." + "\n" + "3. All cards count as their face value, picture cards count as 10 and" + "\n" + "   aces count as 1 or 11." + "\n" + "4. Players must decide whether to hit and take another card or" + "\n" + "   stand and end the round." + "\n" + "5. The dealer must hit on 16 or less and stand on 17 through 21." + "\n" + "6. Players win if their hand totals more than the dealer or lose if" + "\n" + "   they have less or go over 21." + "\n" + "\n" + "Click on the screen to return to the dashboard.");

		width = 528;
		height = 400;
		
		canvas = new Canvas (width, height);
		g = canvas.getGraphicsContext2D ();

		g.setFill (Color.DARKGREEN);
		g.fillRect (0, 0, width, height);
		g.setFill (Color.SILVER);
		g.setFont (Font.font ("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 32));
		g.fillText ("Welcome to Blackjack!", (width / 2) - 150, height / 2);
		g.setFont (Font.font ("Times New Roman", FontWeight.BOLD, 16));
		g.fillText ("Click on the screen to start", (width / 2) - 80, (height / 2) + 20);


		for (x = 0; x <= 4; x ++) {

			g.drawImage (cardImage, 79 * 2, 123 * 4, 79, 123, 17 + (x * 100), 25, 79, 123);
			g.drawImage (cardImage, 79 * 2, 123 * 4, 79, 123, 17 + (x * 100), 250, 79, 123);
		}

		root.setCenter (canvas);

		canvas.setOnMousePressed (evt -> dashboard (evt));

		hit = new Button ("Hit");
		hit.setDisable (true);
		stand = new Button ("Stand");
		stand.setDisable (true);
		newGame = new Button ("New Game");
		instructions = new Button ("Instructions");
		betTextField = new TextField ("Amount Betting");
		go = new Button ("Go");
		go.setDisable (true);
		go.setPrefWidth (40);
		betTextField.setPrefWidth (170);
		betTextField.setDisable (true);
		buttonBar = new HBox (hit, stand, betTextField, go, instructions, newGame);
		buttonBar.setSpacing (10);
		buttonBar.setStyle ("-fx-border-color: darkred; -fx-border-width: 3px 0px 3px 0px; -fx-padding: 1px; -fx-background-color:beige");
		
		root.setBottom (buttonBar);

		instructions.setOnAction (evt -> instructions ());

		newGame.setOnAction (evt -> newGame ());
		hit.setOnAction (evt -> hit ());
		stand.setOnAction (evt -> stand ());
		go.setOnAction (evt -> processBet ());

		go.setDefaultButton (true);

		scene = new Scene (root);
		stage.setScene (scene);
		stage.setTitle ("Blackjack 2D");
		stage.setResizable (false);
		stage.show ();
	}

	public void dashboard (MouseEvent evt) {

		int x;


		if (inProgress == true) {

			return;
		}

		g.setFill (Color.DARKGREEN);
		g.fillRect (0, 0, width, height);


		for (x = 0; x <= 4; x ++) {

			g.drawImage (cardImage, 79 * 2, 123 * 4, 79, 123, 17 + (x * 100), 25, 79, 123);
			g.drawImage (cardImage, 79 * 2, 123 * 4, 79, 123, 17 + (x * 100), 250, 79, 123);
		}

		g.setFill (Color.SILVER);
		g.setFont (Font.font ("Times New Roman", FontWeight.BOLD, 20));
		g.fillText ("Click New Game to start a new game." + "\n" + "Click instructions to view the instructions.", (width / 2) - 160, (height / 2) - 10);
	}

	public void instructions () {

		g.setFill (Color.DARKGREEN);
		g.fillRect (0, 0, width, height);
		g.setFill (Color.SILVER);
		g.setFont (Font.font ("Times New Roman", FontWeight.BOLD, 16));
		g.fillText (instructionsLabel, 20, 50);
	}

	public void newGame () {

		if (pot == 0) {

			hit.setDisable (true);
			stand.setDisable (true);
			betTextField.setDisable (true);
			go.setDisable (true);
			instructions.setDisable (true);
			newGame.setDisable (true);

			g.setFill (Color.DARKGREEN);
			g.fillRect (20, 365, width, 25);
			message = ("You ran out of money! Reopen the program to play again.");
			g.setFill (Color.SILVER);
			g.fillText (message, 20, 385);

			return;
		}

		inProgress = true;
		hit.setDisable (true);
		stand.setDisable (true);
		betTextField.setDisable (false);
		instructions.setDisable (true);
		newGame.setDisable (true);
		go.setDisable (false);

		g.setFill (Color.DARKGREEN);
		g.fillRect (0, 0, width, height);
		g.setFill (Color.SILVER);
		g.setFont (Font.font ("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 16));
		g.fillText (dealersCards, 20, 20);
		g.fillText (yourCards, 20, 205);
		g.setFont (Font.font ("Times New Roman", FontWeight.BOLD, 16));
		g.setFill (Color.GOLD);
		g.fillText ("Current Pot: $" + String.valueOf (pot), 20, 365);

		dealerCardCount = 0;
		userCardCount = 0;
		inProgress = true;

		card = null;
		drawCard (30 + (dealerCardCount * 100), 35);
		drawCard (30 + (userCardCount * 100), 220);

		g.setFill (Color.DARKGREEN);
		g.fillRect (20, 365, width, 25);
		message = ("How much would you like to bet?");
		g.setFill (Color.SILVER);
		g.fillText (message, 20, 385);

		betTextField.selectAll ();
		betTextField.requestFocus ();
	}

	public void dealCards () {

		hit.setDisable (false);
		stand.setDisable (false);

		deck = new Deck ();
		dealerHand = new BlackjackHand ();
		userHand = new BlackjackHand ();

		deck.shuffle ();
		dealerHand.clear ();
		userHand.clear ();

		card = deck.dealCard ();
		dealerHand.addCard (card);
		drawCard (30 + (dealerCardCount * 50), 35);
		dealerCardCount ++;
		
		card = deck.dealCard ();
		userHand.addCard (card);
		drawCard (30 + (userCardCount * 50), 220);
		userCardCount = userCardCount + 2;
		card = deck.dealCard ();
		userHand.addCard (card);
		drawCard (30 + (userCardCount * 50), 220);
		userCardCount = userCardCount + 2;

		card = null;
		dealerCardCount ++;
		drawCard (30 + (dealerCardCount * 50), 35);
		dealerCardCount = dealerCardCount - 2;

		g.setFill (Color.DARKGREEN);
		g.fillRect (20, 365, width, 25);
		message = ("Hit or Stand? Your Blackjack value is " + userHand.getBlackjackValue ());
		g.setFill (Color.SILVER);
		g.fillText (message, 20, 385);

		message2 = ("The dealer's Blackjack value is " + dealerHand.getBlackjackValue ());
		g.setFill (Color.SILVER);
		g.fillText (message2, 20, 180);
	}

	public void processBet () {

		hit.setDisable (true);
		stand.setDisable (true);

		betValue = betTextField.getText ();
		bet = java.lang.Integer.parseInt (betValue);
		

		if (bet > pot || bet < 1) {

			g.setFill (Color.DARKGREEN);
			g.fillRect (20, 365, width, 25);
			message = ("You can't bet more than you have or less than $1. Try again.");
			g.setFill (Color.SILVER);
			g.fillText (message, 20, 385);
			betTextField.selectAll ();
			betTextField.requestFocus ();

			return;
		}
		
		else {

			g.setFill (Color.GOLD);
			g.fillText ("Current Bet: $" + bet, 375, 20);
			betTextField.setEditable (false);
			go.setDisable (true);
		
			dealCards ();
		}
	}

	public void hit () {

		card = deck.dealCard ();
		userHand.addCard (card);
		drawCard (30 + (userCardCount * 50), 220);
		userCardCount = userCardCount + 2;

		g.setFill (Color.DARKGREEN);
		g.fillRect (20, 365, width, 25);
		message = ("Hit or Stand? Your Blackjack value is " + userHand.getBlackjackValue ());
		g.setFill (Color.SILVER);
		g.fillText (message, 20, 385);


		if (userHand.getBlackjackValue () == 21) {

			gameWon ();
		}
	
		if (userHand.getBlackjackValue () > 21) {

			gameLost ();
		}
	
		if (userCardCount == 10 && userHand.getBlackjackValue () <= 21) {

			gameWon ();
		}
	}

	public void stand () {

		g.setFill (Color.DARKGREEN);
		g.fillRect (20, 365, width, 25);
		message = ("Your Blackjack value is " + userHand.getBlackjackValue ());
		g.setFill (Color.SILVER);
		g.fillText (message, 20, 385);


		do {

			card = deck.dealCard ();
			dealerHand.addCard (card);
			dealerCardCount = dealerCardCount + 2;
			drawCard (30 + (dealerCardCount * 50), 35);
			
		} while (dealerHand.getBlackjackValue () < 16);
	
		g.setFill (Color.DARKGREEN);
		g.fillRect (20, 160, width, 25);
		message2 = ("The dealer's Blackjack value is " + dealerHand.getBlackjackValue ());
		g.setFill (Color.SILVER);
		g.fillText (message2, 20, 180);
	

		if (dealerHand.getBlackjackValue () > userHand.getBlackjackValue () && dealerHand.getBlackjackValue () <= 21) {

			gameLost ();
		}
	
		if (dealerHand.getBlackjackValue () < userHand.getBlackjackValue () && userHand.getBlackjackValue () <= 21) {

			gameWon ();
		}

		if (dealerHand.getBlackjackValue () > 21 && userHand.getBlackjackValue () > 21) {

			gameLost ();
		}
	
		if (dealerHand.getBlackjackValue () > 21 && userHand.getBlackjackValue () <= 21) {

			gameWon ();
		}
	
		if (dealerHand.getBlackjackValue () < 21 && userHand.getBlackjackValue () < 21 && dealerHand.getBlackjackValue () == userHand.getBlackjackValue ()) {

			gameWon ();
		}
	}

	public void gameWon () {

		hit.setDisable (true);
		stand.setDisable (true);
		betTextField.setDisable (true);
		go.setDisable (true);
		instructions.setDisable (false);
		newGame.setDisable (false);
		newGame.setDisable (false);
		betTextField.setEditable (true);

		g.setFill (Color.DARKGREEN);
		g.fillRect (350, 0, 200, 25);

		pot += bet;

		g.fillRect (20, 345, 200, 25);
		g.setFill (Color.GOLD);
		g.fillText ("Current Pot: $" + String.valueOf (pot), 20, 365);

		g.fillText ("You Won!", 420, 385);
	}

	public void gameLost () {

		hit.setDisable (true);
		stand.setDisable (true);
		betTextField.setDisable (true);
		go.setDisable (true);
		instructions.setDisable (false);
		newGame.setDisable (false);
		betTextField.setEditable (true);

		g.setFill (Color.DARKGREEN);
		g.fillRect (350, 0, 200, 25);

		pot -= bet;

		g.fillRect (20, 345, 200, 25);
		g.setFill (Color.GOLD);
		g.fillText ("Current Pot: $" + String.valueOf (pot), 20, 365);

		g.setFill (Color.RED);
		g.fillText ("You Lost!", 420, 385);
	}

	public void drawCard (int x, int y) {

		int cardRow;
		int cardCol;
        double sx;
        double sy;


        if (card == null) {  
            
            cardRow = 4;   
            cardCol = 2;
        }
        
        else {
            
            cardRow = 3 - card.getSuit ();
            cardCol = card.getValue () - 1;
        }
        
        sx = 79 * cardCol;
        sy = 123 * cardRow;
        
        g.drawImage( cardImage, sx, sy, 79, 123, x, y, 79, 123);
    } 
}