import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.animation.AnimationTimer;

/*
This program will roll a pair of dice randomly. It will then draw the
visual representation of the value of the dice.
*/

public class DrawPairOfDice2 extends Application {

	private Canvas canvas;
	private GraphicsContext g;
	private Button rollButton;
	private int frameNumber;

	/*
	This subclass will create an animation timer to display an 
	animation of the dice rolling.
	*/

	private AnimationTimer animator = new AnimationTimer () {

		public void handle (long time) {

				roll (g);
				frameNumber ++;


				if (frameNumber == 60) {

					animator.stop ();
					rollButton.setDisable (false);
				}
			}
		};

	/*
	The main method will launch the program.
	*/

	public static void main (String [] args) {

		launch ();
	}

	/*
	The start method will create the canvas, install handlers onto
	the button and call the roll method every time the button is
	pressed.
	*/

	public void start (Stage stage) {

		BorderPane root;
		Scene scene;

		canvas = new Canvas (100, 100);
		g = canvas.getGraphicsContext2D ();
		g.setFill (Color.BLUE);
		g.fillRect (0, 0, 100, 100);

		rollButton = new Button ("Roll");

		rollButton.setOnAction (evt -> {
			
			frameNumber = 0;
			rollButton.setDisable (true);
			animator.start ();
			roll (g);
		});
		
		root = new BorderPane ();
		root.setCenter (canvas);
		root.setBottom (rollButton);
		root.setAlignment (rollButton, Pos.BOTTOM_CENTER);

		scene = new Scene (root);
		stage.setScene (scene);
		stage.setResizable (false);
		stage.setTitle ("Draw Pair of Dice");
		stage.show ();
	}

	/*
	The roll method will roll a pair of dice at random and will draw
	the resulting value.
	*/

	public void roll (GraphicsContext g) {

		int dice1;
		int dice2;

		dice1 = (int)(Math.random () * 6) + 1;
		dice2 = (int)(Math.random () * 6) + 1;

		g.setFill (Color.WHITE);
		g.fillRect (10, 10, 30, 30);
		g.fillRect (60, 60, 30, 30);
		g.setStroke (Color.BLACK);
		g.strokeRect (10, 10, 30, 30);
		g.strokeRect (60, 60, 30, 30);
		g.setFill (Color.BLACK);


		switch (dice1) {

			case 1 :
			g.fillOval (20, 20, 10, 10);
			break;

			case 2 :
			g.fillOval (12, 28, 10, 10);
			g.fillOval (28, 12, 10, 10);
			break;

			case 3 :
			g.fillOval (12, 12, 10, 10);
			g.fillOval (20, 20, 10, 10);
			g.fillOval (28, 28, 10, 10);
			break;

			case 4 :
			g.fillOval (12, 12, 10, 10);
			g.fillOval (12, 28, 10, 10);
			g.fillOval (28, 12, 10, 10);
			g.fillOval (28, 28, 10, 10);
			break;

			case 5 :
			g.fillOval (12, 12, 10, 10);
			g.fillOval (12, 28, 10, 10);
			g.fillOval (28, 12, 10, 10);
			g.fillOval (28, 28, 10, 10);
			g.fillOval (20, 20, 10, 10);
			break;

			case 6 :
			g.fillOval (12, 12, 10, 10);
			g.fillOval (12, 28, 10, 10);
			g.fillOval (28, 12, 10, 10);
			g.fillOval (28, 28, 10, 10);
			g.fillOval (20, 28, 10, 10);
			g.fillOval (20, 12, 10, 10);
			break;
		}
	
		switch (dice2) {

			case 1 :
			g.fillOval (70, 70, 10, 10);
			break;

			case 2 :
			g.fillOval (62, 78, 10, 10);
			g.fillOval (78, 62, 10, 10);
			break;

			case 3 :
			g.fillOval (62, 62, 10, 10);
			g.fillOval (70, 70, 10, 10);
			g.fillOval (78, 78, 10, 10);
			break;

			case 4 :
			g.fillOval (62, 62, 10, 10);
			g.fillOval (62, 78, 10, 10);
			g.fillOval (78, 62, 10, 10);
			g.fillOval (78, 78, 10, 10);
			break;

			case 5 :
			g.fillOval (62, 62, 10, 10);
			g.fillOval (62, 78, 10, 10);
			g.fillOval (78, 62, 10, 10);
			g.fillOval (78, 78, 10, 10);
			g.fillOval (70, 70, 10, 10);
			break;

			case 6 :
			g.fillOval (62, 62, 10, 10);
			g.fillOval (62, 78, 10, 10);
			g.fillOval (78, 62, 10, 10);
			g.fillOval (78, 78, 10, 10);
			g.fillOval (70, 78, 10, 10);
			g.fillOval (70, 62, 10, 10);
			break;
		}
	}
}