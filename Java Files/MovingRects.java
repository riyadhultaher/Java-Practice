import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MovingRects extends Application {

	public static void main (String [] args) {

		launch();
	}

	public void drawFrame (GraphicsContext g, int frameNumber, double elapsedSeconds, int width, int height) {

		g.setFill(Color.WHITE);
		g.fillRect(0, 0, width, height);

		double inset;
		double rectWidth;
		double rectHeight;

		g.setStroke(Color.BLACK);

		inset = frameNumber % 15;

		rectWidth = width - (2 * inset);
		rectHeight = height - (2 * inset);


		while (rectWidth >= 0 && rectHeight >= 0) {

			g.strokeRect(inset, inset, rectWidth, rectHeight);
			inset += 15;
			rectWidth -= 30;
			rectHeight -= 30;
		}
	}

	public void start (Stage stage) {

		int width = 800;
		int height = 600;
		Canvas canvas = new Canvas (width, height);
		drawFrame(canvas.getGraphicsContext2D(), 0, 0, width, height);
		BorderPane root = new BorderPane (canvas);
		root.setStyle("-fx-border-width: 4px; -fx-border-color: #444");
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Infinite Moving Rects");
		stage.show();
		stage.setResizable(false);
		AnimationTimer anim = new AnimationTimer() {

			private int frameNum;
			private long startTime = -1;
			private long previousTime;
			public void handle (long now) {

				
				if (startTime < 0) {

					startTime = previousTime = now;
					drawFrame(canvas.getGraphicsContext2D(), 0, 0, width, height);
				}
			
				else if (now - previousTime > 0.95e9/60) {

					frameNum ++;
					drawFrame(canvas.getGraphicsContext2D(), frameNum, (now-startTime)/1e9, width, height);
					previousTime = now;
				}
			}
		};
		anim.start();

	}

}