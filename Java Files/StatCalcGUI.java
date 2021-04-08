import javafx.application.Application;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Slider;
import javafx.scene.control.*;

/*
This program will display the number of entries, sum, average, and standard
deviation of a set of numbers input by the user. Pressing the clear 
button will reset the statistics.
*/

public class StatCalcGUI extends Application {

	private StatCalc calculator;
	private int calculatorCount;
	private double calculatorSum;
	private double calculatorAverage;
	private double calculatorStandardDeviation;

	private String parseCount;
	private String parseSum;
	private String parseAverage;
	private String parseStandardDeviation;

	private Label count;
	private Label sum;
	private Label average;
	private Label standardDeviation;

	private Button enter;
	private Button clear;
	private TextField input;
	private Label title;
	private HBox buttonBar;
	private HBox entryBar;
	private HBox sumBar;
	private HBox averageBar;
	private HBox standardDeviationBar;
	private TilePane root;

	/*
	The main method will launch the program.
	*/

	public static void main (String [] args) {

		launch ();
	}

	/*
	The start method will create the GUI, assign handlers to the
	buttons, and format all child nodes into separate HBoxes and
	then all into a TilePane.
	*/

	public void start (Stage stage) {

		Scene scene;

		title = new Label ("Enter a number, click Enter:");

		enter = new Button ("Enter");
		clear = new Button ("Clear");

		parseCount = String.valueOf (calculatorCount);
		parseSum = String.valueOf (calculatorSum);
		parseAverage = String.valueOf (calculatorAverage);
		parseStandardDeviation = String.valueOf (calculatorStandardDeviation);

		count = new Label (parseCount);
		sum = new Label (parseSum);
		average = new Label (parseAverage);
		standardDeviation = new Label (parseStandardDeviation);

		input = new TextField ();

		buttonBar = new HBox (input, enter, clear);

		entryBar = new HBox (new Label (" Number of Entries:   "), count);
		entryBar.setMaxWidth (Double.POSITIVE_INFINITY);
		sumBar = new HBox (new Label (" Sum:   "), sum);
		sumBar.setMaxWidth (Double.POSITIVE_INFINITY);
		averageBar = new HBox (new Label (" Average:   "), average);
		averageBar.setMaxWidth (Double.POSITIVE_INFINITY);
		standardDeviationBar = new HBox (new Label (" Standard Deviation:   "), standardDeviation);
		standardDeviationBar.setMaxWidth (Double.POSITIVE_INFINITY);

		enter.setOnAction (evt -> calculate ());
		clear.setOnAction (evt -> reset ());

		enter.setDefaultButton (true);

		calculator = new StatCalc ();

		root = new TilePane (title, buttonBar, entryBar, sumBar, averageBar, standardDeviationBar);
		root.setPrefRows (6);
		root.setPrefColumns (1);
		root.setVgap (5);

		scene = new Scene (root);
		stage.setScene (scene);
		stage.setResizable (false);
		stage.setTitle ("Stat Calculator GUI");
		stage.show ();

	}

	/*
	The calculate method will be called every time the enter button
	is pressed. It will add each additional number and the StatCalc
	object will calculate the statistics.
	*/

	public void calculate () {

		String stringValue;
		double value;

		stringValue = input.getText ();
		value = Double.parseDouble (stringValue);

		calculator.enter (value);
		calculatorCount = calculator.getCount ();
		calculatorSum = calculator.getSum ();
		calculatorAverage = calculator.getMean ();
		calculatorStandardDeviation = calculator.getStandardDeviation ();

		input.selectAll ();
		input.requestFocus ();

		showData ();
	}

	/*
	The reset method will set all the data back to 0.
	*/

	public void reset () {

		calculator = new StatCalc ();
		calculatorCount = 0;
		calculatorSum = 0.0;
		calculatorAverage = 0.0;
		calculatorStandardDeviation = 0.0;

		input.selectAll ();
		input.requestFocus ();

		showData ();
	}

	/*
	The showData method will show update the current statistics
	displayed on the GUI.
	*/

	public void showData () {

		parseCount = String.valueOf (calculatorCount);
		parseSum = String.valueOf (calculatorSum);
		parseAverage = String.valueOf (calculatorAverage);
		parseStandardDeviation = String.valueOf (calculatorStandardDeviation);

		count.setText (parseCount);
		sum.setText (parseSum);
		average.setText (parseAverage);
		standardDeviation.setText (parseStandardDeviation);
	}
}