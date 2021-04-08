import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.canvas.*;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;

/*
This program will display five cards selected at random from a Deck. The redraw
button will allow the user to select new random cards.
*/

public class RandomCards extends Application {

	private Canvas canvas;
	private Image cardImage;

	/*
	The main method will launch the program.
	*/

	public static void main (String [] args) {

		launch ();
	}

	/*
	The start method will create the canvas and the buttons. It will also
	call the draw method every time the user presses the Deal Again button.
	*/

	public void start (Stage stage) {

		BorderPane root;
		StackPane bottom;
		Button redraw;
		Scene scene;

		cardImage = new Image ("cards.png");

		canvas = new Canvas (5 * 79 + 120, 123 + 40);

		draw ();

		redraw = new Button ("Deal Again");
		redraw.setOnAction (e -> draw ());

		bottom = new StackPane (redraw);
		bottom.setStyle ("-fx-background-color: gray; -fx-padding: 5 px;" + "-fx-border-color: blue; -fx-border-width: 2px 0 0 0");

		root = new BorderPane (canvas);
		root.setBottom (bottom);
		root.setStyle ("-fx-border-color: blue; -fx-border-width: 2px; -fx-background-color: lightblue");

		scene = new Scene (root, Color.BLACK);
		stage.setScene (scene);
		stage.setResizable (false);
		stage.show ();
	}

	/*
	The draw method will draw one iteration of the random set of cards.
	*/

	private void draw () {

		GraphicsContext g;
		Deck deck;
		Card card;
		double sx;
		double sy;
		double dx;
		double dy;
		int i;

		g = canvas.getGraphicsContext2D ();

		deck = new Deck ();
		deck.shuffle ();


		for (i = 0; i < 5; i ++) {

			card = deck.dealCard ();
			sx = 79 * (card.getValue () - 1);
			sy = 123 * (3 - card.getSuit ());
			dx = 20 + (79 + 20) * i;
			dy = 20;

			g.drawImage (cardImage, sx, sy, 79, 123, dx, dy, 79, 123);
		}
	}
}