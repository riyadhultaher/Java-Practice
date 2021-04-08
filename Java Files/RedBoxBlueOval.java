import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

/*
This program will continously draw a red square or blue oval based on
if the mouse is clicked and dragged. The blue oval is drawn only if 
the shift key is held down.
*/

public class RedBoxBlueOval extends Application {

    /*
    The main method launches the program.
    */

    private double startX;
    private double startY;
    private double prevX;
    private double prevY;
    private boolean dragging;
    private Canvas canvas;
    private GraphicsContext g;

    public static void main (String [] args) {

        launch (args);
    }

    /*
    The start method will create the canvas, install handlers to
    the mouse events and create the scene.
    */

    public void start (Stage stage) {

        BorderPane root;
        Scene scene;

        canvas = new Canvas (500, 500);
        g = canvas.getGraphicsContext2D ();
        g.setFill (Color.WHITE);
        g.fillRect (0, 0, 500, 500);

        canvas.setOnMousePressed (evt -> mousePressed (evt));
        canvas.setOnMouseDragged (evt -> mouseDragged (evt));
        canvas.setOnMouseReleased (evt -> mouseReleased (evt));

        root = new BorderPane ();
        root.setCenter (canvas);

        scene = new Scene (root);
        stage.setScene (scene);
        stage.setResizable (false);
        stage.setTitle ("RedBoxBlueOval");
        stage.show ();
    }

    /*
    The mousePressed method will keep track of where the x and y
    coordinates are if the mouse button is pressed.
    */

    public void mousePressed (MouseEvent evt) {

        if (evt.isSecondaryButtonDown ()) {

            g.setFill (Color.WHITE);
            g.fillRect (0, 0, 500, 500);

            return;
        }


        if (dragging == true) {

            return;
        }
    
        else {

            dragging = true;
            
            startX = evt.getX ();
            startY = evt.getY ();
            prevX = startX;
            prevY = startY;

            draw (startX, startY, evt);
        }
    }

    /*
    The mouseDragged method will continuously keep track of the x and y
    coordinates as the drawing is being dragged. 5 pixels are added to the
    x and y values each call to separate the drawings out more.
    */

    public void mouseDragged (MouseEvent evt) {

        double x;
        double y;


        if (dragging == false) {

            return;
        }
    
        x = evt.getX ();
        y = evt.getY ();

        draw (x, y, evt);

        prevX = x;
        prevY = y;
    }

    /*
    The mouseReleased method simply sets dragging to false when the
    mouse is released.
    */

    public void mouseReleased (MouseEvent evt) {

        if (dragging == false) {

            return;
        }
    
        dragging = false;
    }

    /*
    The draw method will draw a red box or a blue oval depending on
    whether the shift key is down.
    */

    public void draw (double x, double y, MouseEvent evt) {

        if (evt.isShiftDown ()) {

            g.setFill (Color.BLUE);
            g.fillOval (x - 30, y - 15, 60, 30);
            g.setStroke (Color.BLACK);
            g.strokeOval (x - 30, y - 15, 60, 30);
        }
    
        else {

            g.setFill (Color.RED);
            g.fillRect (x - 30, y - 15, 60, 30);
            g.setStroke (Color.BLACK);
            g.strokeRect (x - 30, y - 15, 60, 30);
        }
    }
}