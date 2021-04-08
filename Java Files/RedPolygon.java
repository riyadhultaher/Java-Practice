import javafx.application.Application;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.canvas.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/*
This program will allow the user to draw a polygon. Once the ending vertex
comes close to the starting vertex, the polygon will connect and fill
with red. The next click will clear the screen.
*/

public class RedPolygon extends Application {

	private Canvas canvas;
	private GraphicsContext g;
	
	private double [] currentX;
	private double [] currentY;
	private double x1;
	private double y1;
	private double x2;
	private double y2;
	private int vertexCount;
	private boolean isFilled;

	/*
	The main method will launch the program.
	*/

	public static void main (String [] args) {

		launch ();
	}

	public void start (Stage stage) {

		BorderPane root;
		Scene scene;

		canvas = new Canvas (400, 400);
		g = canvas.getGraphicsContext2D ();

		isFilled = false;

		currentX = new double [100];
		currentY = new double [100];

		canvas.setOnMousePressed (evt -> {

			
			if (isFilled == true) {

				g.setFill (Color.WHITE);
				g.fillRect (0, 0, 400, 400);
				isFilled = false;
				currentX = new double [100];
				currentY = new double [100];
				vertexCount = 0;

				return;
			}


			if (vertexCount == 0) {

				x1 = evt.getX ();
				y1 = evt.getY ();
				g.setFill (Color.BLACK);
				g.fillOval (x1, y1, 5, 5);
				currentX [0] = x1;
				currentY [0] = y1;
				vertexCount ++;

				return;
			}
			
			x2 = evt.getX ();
			y2 = evt.getY ();

			currentX [vertexCount] = evt.getX ();
			currentY [vertexCount] = evt.getY ();

			g.setStroke (Color.BLACK);
			g.setFill (Color.BLACK);
			g.fillOval (x2, y2, 5, 5);
			g.strokeLine (x1, y1, x2, y2);

			x1 = x2;
			y1 = y2;

			vertexCount ++;

		
			if ((x2 <= currentX [0] + 25 && x2 >= currentX [0] - 25) && (y2 <= currentY [0] + 25 && y2 >= currentY [0] - 25) && isFilled == false) {

				drawPolygon ();
				isFilled = true;
			}
		});
	
		root = new BorderPane (canvas);
		root.setCenter (canvas);

		scene = new Scene (root);

		stage.setScene (scene);
		stage.setTitle ("Red Polygon");
		stage.setResizable (false);
		stage.show ();
	}

	public void drawPolygon () {

		g.setStroke (Color.BLACK);
		g.strokePolygon (currentX, currentY, vertexCount);
		g.setFill (Color.PINK);
		g.fillPolygon (currentX, currentY, vertexCount);
	}
}