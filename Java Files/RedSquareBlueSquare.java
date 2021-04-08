import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.input.KeyCode;

/*
This program will display a red square and a blue square that the user
can move around. If the user presses the return key, the squares will
return to their original starting position.
*/

public class RedSquareBlueSquare extends Application {

	/*
	The main method will launch the program.
	*/

	private double redStartX = 250;
    private double redStartY = 100;
    private double blueStartX = 250;
    private double blueStartY = 400;
    
    private double offsetX;
    private double offsetY;
    private boolean dragging;
    private Canvas canvas;
    private GraphicsContext g;

	public static void main (String [] args) {

		launch (args);
	}

	public void start (Stage stage) {

		BorderPane root;
		Scene scene;

		canvas = new Canvas (500, 500);
		g = canvas.getGraphicsContext2D ();
		draw ();
		
		canvas.setOnMousePressed (evt -> mousePressed (evt));
        canvas.setOnMouseDragged (evt -> mouseDragged (evt));
        canvas.setOnMouseReleased (evt -> mouseReleased (evt));

        root = new BorderPane ();
        root.setCenter (canvas);

        scene = new Scene (root);
        scene.setOnKeyPressed (evt -> {

        	if (evt.getCode () == KeyCode.ESCAPE) {

        		redStartX = 250;
    			redStartY = 100;
    			blueStartX = 250;
    			blueStartY = 400;
    			draw ();
        	}
        });

        stage.setScene (scene);
        stage.setResizable (false);
        stage.setTitle ("RedSquareBlueSquare");
        stage.show ();
	}

	public void mousePressed (MouseEvent evt) {

		double x;
		double y;

		x = evt.getX ();
		y = evt.getY ();


		if (dragging == true) {

			return;
		}
	
		if (x >= redStartX && x < redStartX + 20 && y >= redStartY && y < redStartY + 20) {

			dragging = true;
			offsetX = x - redStartX;
			offsetY = y - redStartY;			
		}

		else if (x >= blueStartX && x < blueStartX + 20 && y >= blueStartY && y < blueStartY + 20) {

			dragging = true;
			offsetX = x - blueStartX;
			offsetY = y - blueStartY;
		}
	}

	public void mouseDragged (MouseEvent evt) {

		double x;
		double y;


		if (dragging == false) {

			return;
		}
	
		x = evt.getX ();
		y = evt.getY ();


		if (x >= redStartX && x < redStartX + 20 && y >= redStartY && y < redStartY + 20) {

			redStartX = x - offsetX;
			redStartY = y - offsetY;
		}
	
		else if (x >= blueStartX && x < blueStartX + 20 && y >= blueStartY && y < blueStartY + 20) {

			blueStartX = x - offsetX;
			blueStartY = y - offsetY;
			
		}
	
		draw ();
	}

	public void mouseReleased (MouseEvent evt) {
	
		dragging = false;
	}

	public void draw () {

		g.setFill (Color.WHITE);
		g.fillRect (0, 0, 500, 500);
		g.setFill (Color.RED);
		g.fillRect (redStartX, redStartY, 20, 20);
		g.setFill (Color.BLUE);
		g.fillRect (blueStartX, blueStartY, 20, 20);
	}
}