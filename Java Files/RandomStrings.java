import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.text.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.Color;

/*
This program will display 25 copies of a message with a random color,
position, and font. The font is randomly chosen from five premade fonts.
The user can redraw the image by pressing the redraw button.
*/

public class RandomStrings extends Application {

	private final static String MESSAGE = "Hello JavaFX";
	private Font font1;
	private Font font2;
	private Font font3;
	private Font font4;
	private Font font5;
	private Canvas canvas;

	/*
	The main method will launch the program.
	*/

	public static void main (String [] args) {

		launch ();
	}

	/*
	The start method will create the window and assign the fonts to values.
	It will then create a button for the user to redraw the canvas. This method
	will call the draw method every time the redraw button is pressed. The user 
	can close the window when they want to quit.
	*/

	public void start (Stage stage) {

		BorderPane root;
		StackPane bottom;
		Button redraw;
		Scene scene;

		font1 = Font.font ("Times New Roman", FontWeight.BOLD, 20);
		font2 = Font.font ("Arial", FontWeight.BOLD, FontPosture.ITALIC, 28);
		font3 = Font.font ("Verdana", 32);
		font4 = Font.font (40);
		font5 = Font.font ("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 60);

		canvas = new Canvas (500, 300);
		draw ();

		redraw = new Button ("Redraw");
		redraw.setOnAction (e -> draw ());

		bottom = new StackPane (redraw);
		bottom.setStyle ("-fx-background-color: gray; -fx-padding: 5px" + "-fx-border-color: black; -fx-border-width: 2px 0 0 0");

		root = new BorderPane (canvas);
		root.setBottom (bottom);
		root.setStyle ("-fx-border-color: black; -fx-border-width: 2px");

		scene = new Scene (root, Color.BLACK);
		stage.setScene (scene);
		stage.setTitle ("Random Strings");
		stage.setResizable (false);
		stage.show ();
	}

	/*
	The draw method will draw one iteration of the HelloFX message 25
	times in random fonts and random places.
	*/

	public void draw () {

		GraphicsContext g;
		double width;
		double height;
		int fontNumber;
		int i;
		double hue;
		double x;
		double y;

		g = canvas.getGraphicsContext2D ();

		width = canvas.getWidth ();
		height = canvas.getHeight ();

		g.setFill (Color.WHITE);
		g.fillRect (0, 0, width, height);


		for (i = 0; i < 25; i ++) {

			fontNumber = (int)(Math.random () * 5) + 1;


			switch (fontNumber) {

				case 1 :
				g.setFont (font1);
				break;

				case 2 :
				g.setFont (font2);
				break;

				case 3 :
				g.setFont (font3);
				break;

				case 4 :
				g.setFont (font4);
				break;

				case 5 :
				g.setFont (font5);
				break;
			}
		
			hue = Math.random () * 360;
			g.setFill (Color.hsb (hue, 1.0, 1.0));

			x = Math.random () * width;
			y = Math.random () * height;

			g.fillText (MESSAGE, x, y);
			g.setStroke (Color.BLACK);
			g.strokeText (MESSAGE, x, y);
		}
	}
}