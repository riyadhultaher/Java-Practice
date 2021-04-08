import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Platform;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class HelloWorldFX extends Application {

	/*
	The main method launches the program/
	*/

	public static void main (String [] args) {

		launch ();
	}

	/*
	The start method creates three buttons to display three different
	messages on the window. The user can quit by pressing the quit
	button.
	*/

	public void start (Stage stage) {

		BorderPane root;
		Label message;
		Button helloButton;
		Button goodbyeButton;
		Button quitButton;
		HBox buttonBar;
		Scene scene;
		
		message = new Label ("First FX Application");
		message.setFont (new Font (40));

		helloButton = new Button ("Say Hello");
		goodbyeButton = new Button ("Say Goodbye");
		quitButton = new Button ("Quit");

		buttonBar = new HBox (20, helloButton, goodbyeButton, quitButton);
		buttonBar.setAlignment (Pos.CENTER);

		helloButton.setOnAction (e -> message.setText ("Hello World!"));
		goodbyeButton.setOnAction (e -> message.setText ("Goodbye World!"));
		quitButton.setOnAction (e -> Platform.exit ());

		root = new BorderPane ();
		root.setCenter (message);
		root.setBottom (buttonBar);

		scene = new Scene (root, 450, 200);
		stage.setScene (scene);
		stage.setTitle ("JavaFX Test");
		stage.show ();

	}
}