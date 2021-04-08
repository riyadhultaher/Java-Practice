import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Checkerboard extends Application {

	public static void main (String [] args) {

		launch();
	}

	public void drawPicture (GraphicsContext g, int width, int height) {

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

	public void start (Stage stage) {

		int width = 400;
		int height = 400;
		Canvas canvas = new Canvas (width, height);

		drawPicture (canvas.getGraphicsContext2D(), width, height);
		BorderPane root = new BorderPane (canvas);
		root.setStyle("-fx-border-width: 4px; -fx-border-color: #444");

		Scene scene = new Scene (root);

		stage.setScene (scene);
		stage.setTitle ("Checkerboard");
		stage.show();
		stage.setResizable (false);
	}

}