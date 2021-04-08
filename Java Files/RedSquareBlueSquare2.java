import javafx.application.Application;
import javafx.stage.Stage;
import java.util.*;
import javafx.scene.paint.Color;
import javafx.scene.input.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

/*
This program will display a red square and a blue square that the user
can move around. If the user presses the return key, the squares will
return to their original starting position.
*/

public class RedSquareBlueSquare2 extends Application {

    public static class Square {

    	double startX;
    	double startY;

    	int r = (int)(Math.random () * 255);
    	int g = (int)(Math.random () * 255);
    	int b = (int)(Math.random () * 255);
    }
    
    private ArrayList <Square> squareList = new ArrayList <Square> ();
    
    private Square square;
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
		redraw ();
		
		canvas.setOnMousePressed (evt -> mousePressed (evt));
        canvas.setOnMouseDragged (evt -> mouseDragged (evt));
        canvas.setOnMouseReleased (evt -> mouseReleased (evt));

        root = new BorderPane ();
        root.setCenter (canvas);

        scene = new Scene (root);
        scene.setOnKeyPressed (evt -> {

        	if (evt.getCode () == KeyCode.ESCAPE) {

    			redraw ();
        	}
        });

        stage.setScene (scene);
        stage.setResizable (false);
        stage.setTitle ("RedSquareBlueSquare2");
        stage.show ();
	}

	public void mousePressed (MouseEvent evt) {

		double x;
		double y;
		

		if (evt.isShiftDown () == true || evt.getButton () == MouseButton.SECONDARY) {

			x = evt.getX ();
			y = evt.getY ();


			if (dragging == true) {

				return;
			}
	
			for (Square currentSquare : squareList) {

				if (x >= currentSquare.startX && x < currentSquare.startX + 20 && y >= currentSquare.startY && y < currentSquare.startY + 20) {

					dragging = true;
					offsetX = x - currentSquare.startX;
					offsetY = y - currentSquare.startY;			
				}
			}
		}
	
		else {

			square = new Square ();
			square.startX = evt.getX ();
			square.startY = evt.getY ();
			squareList.add (square);
			draw ();
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


		for (Square currentSquare : squareList) {
			
			if (x >= currentSquare.startX && x < currentSquare.startX + 20 && y >= currentSquare.startY && y < currentSquare.startY + 20) {

				currentSquare.startX = x - offsetX;
				currentSquare.startY = y - offsetY;
			}

			if (currentSquare.startX >= 495 || currentSquare.startX <= 5 || currentSquare.startY >= 485 || currentSquare.startY <= 15) {

				squareList.remove (currentSquare);
			}
		
			draw ();
		}
	}

	public void mouseReleased (MouseEvent evt) {

		

		dragging = false;
	}

	public void draw () {

		g.setFill (Color.WHITE);
		g.fillRect (0, 0, 500, 500);


		for (Square currentSquare : squareList) {
	
			g.setFill (Color.rgb (currentSquare.r, currentSquare.g, currentSquare.b));
			g.fillRect (currentSquare.startX, currentSquare.startY, 20, 20);
			g.setStroke (Color.BLACK);
			g.strokeRect (currentSquare.startX, currentSquare.startY, 20, 20);
		}
	}

	public void redraw () {

		squareList.clear ();
		g.setFill (Color.WHITE);
		g.fillRect (0, 0, 500, 500);
	}
}