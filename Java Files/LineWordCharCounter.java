import javafx.application.Application;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.geometry.*;

/*
This program will allow the user to type into a textbox. A button called
Process the Text will display the number of lines, words, and characters that
the user has typed.
*/

public class LineWordCharCounter extends Application {

	private TextArea textArea;
	private int lineCount;
	private int wordCount;
	private int charCount;

	private Label line;
	private Label word;
	private Label character;

	private Button process;

	private VBox root;

	/*
	The main method will launch the program.
	*/

	public static void main (String [] args) {

		launch ();
	}

	/*
	The start method will create the GUI, install event handlers
	to the process button, and call the count method when the 
	button is pressed.
	*/

	public void start (Stage stage) {

		Scene scene;

		textArea = new TextArea ();
		textArea.setPrefRowCount (20);
		textArea.setWrapText (true);

		line = new Label (" Number of lines: " + lineCount);
		line.setStyle ("-fx-padding: 5px; -fx-font: bold 18pt sans-serif");
		word = new Label (" Number of words: " + wordCount);
		word.setStyle ("-fx-padding: 5px; -fx-font: bold 18pt sans-serif");
		character = new Label (" Number of characters: " + charCount);
		character.setStyle ("-fx-padding: 5px; -fx-font: bold 18pt sans-serif");

		process = new Button ("Process the Text");
		process.setMaxWidth (Double.POSITIVE_INFINITY);

		process.setOnAction (evt -> count ());
		process.setDefaultButton (true);

		root = new VBox (textArea, process, line, word, character);
		root.setSpacing (5);

		scene = new Scene (root);
		stage.setScene (scene);
		stage.setResizable (false);
		stage.setTitle ("Word");
		stage.show ();
	}

	/*
	The count method will calculate the number of lines, words, and
	characters that are currently in the textbox. It will then call
	the showResults method.
	*/

	public void count () {

		String result;
		int i;
		char ch;
		char behindCh;

		wordCount = 0;
		lineCount = 1;
		behindCh = ' ';

		result = textArea.getText ();

		charCount = result.length ();
		

		for (i = 0; i < result.length (); i ++) {

			ch = result.charAt (i);


			if (ch == '\n') {

				lineCount ++;
			}
			
			if (Character.isLetter (ch) && ! Character.isLetter (behindCh)) {

				wordCount ++;
			}	
			
			behindCh = ch;
		}
	
		textArea.selectAll ();
		textArea.requestFocus ();

		showResults ();
	}

	/*
	The showResults method will update the values of the labels to reflect
	what was calculated in count.
	*/

	public void showResults () {

		line.setText (" Number of lines: " + lineCount);
		line.setStyle ("-fx-padding: 5px; -fx-font: bold 18pt sans-serif");
		word.setText (" Number of words: " + wordCount);
		word.setStyle ("-fx-padding: 5px; -fx-font: bold 18pt sans-serif");
		character.setText (" Number of characters: " + charCount);
		character.setStyle ("-fx-padding: 5px; -fx-font: bold 18pt sans-serif");
	}
}