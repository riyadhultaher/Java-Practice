import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CheckerboardHighlight extends Application {

	private Canvas canvas;
	private GraphicsContext g;
	private int prevRow;
	private int prevCol;
	private boolean alreadyClicked = true;

	public static void main (String [] args) {

		launch();
	}

	public void start (Stage stage) {

		BorderPane root;
		Scene scene;
		int width;
		int height;

		width = 400;
		height = 400;
		
		canvas = new Canvas (width, height);
		g = canvas.getGraphicsContext2D ();

		canvas.setOnMousePressed (evt -> {

			drawPicture (width, height);
			highlight (evt);
		});

		drawPicture (width, height);
		
		root = new BorderPane (canvas);
		root.setStyle("-fx-border-width: 4px; -fx-border-color: #444");

		scene = new Scene (root);

		stage.setScene (scene);
		stage.setTitle ("Checkerboard");
		stage.setResizable (false);
		stage.show();
	}

	public void highlight (MouseEvent evt) {

		double x;
		double y;
		int row;
		int col;

		x = evt.getX ();
		y = evt.getY ();

		row = (int)(y / 50);
		col = (int)(x / 50);

		
		if (row == prevRow && col == prevCol && alreadyClicked == false) {

			g.setStroke (Color.SILVER);
			g.strokeRect (0, 0, 0, 0);
			alreadyClicked = true;

			return;
		}

		g.setStroke (Color.SILVER);
		g.strokeRect (col * 50, row * 50, 50, 50);

		prevRow = row;
		prevCol = col;
		alreadyClicked = false;
	}

	public void drawPicture (int width, int height) {

		int row;
		int col;
		int x;
		int y;


		for (row = 0; row < 8; row ++) {


			for (col = 0; col < 8; col ++) {

				y = col * 50;
				x = row * 50;


				if (row % 2 == col % 2) {

					g.setFill(Color.RED);
				}
			
				else {

					g.setFill(Color.BLACK);
				}

			g.fillRect(x, y, 50, 50);

			}
		}
	}
}