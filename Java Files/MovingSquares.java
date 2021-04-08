import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MovingSquares extends Application {

	public static void main (String [] args) {

		launch ();
	}

	public void drawFrame (GraphicsContext g, int frameNumber, double elapsedSeconds, int width, int height) {

		g.setFill (Color.WHITE);
		g.fillRect (0, 0, width, height);
	
		int cyclicFrameNum;

		cyclicFrameNum = frameNumber % 300;
		g.setFill (Color.RED);
		g.fillRect (cyclicFrameNum, 0, 20, 20);

		cyclicFrameNum = frameNumber % 150;
		g.setFill (Color.GREEN);
		g.fillRect (cyclicFrameNum * 2, 20, 20, 20);

		cyclicFrameNum = frameNumber % 100;
		g.setFill (Color.BLUE);
		g.fillRect (cyclicFrameNum * 3, 40, 20, 20);

		int oscillationFrameNum;

		oscillationFrameNum = frameNumber % 600;


		if (oscillationFrameNum > 300) {

			oscillationFrameNum = 600 - oscillationFrameNum;
		}

		g.setFill (Color.CYAN);
		g.fillRect (oscillationFrameNum, 60, 20, 20);
	

		oscillationFrameNum = frameNumber % 300;


		if (oscillationFrameNum > 150) {

			oscillationFrameNum = 300 - oscillationFrameNum;
		}

		g.setFill (Color.MAGENTA);
		g.fillRect (oscillationFrameNum * 2, 80, 20, 20);
		

		oscillationFrameNum = frameNumber % 200;


		if (oscillationFrameNum > 100) {

			oscillationFrameNum = 200 - oscillationFrameNum;
		}

		g.setFill (Color.YELLOW);
		g.fillRect (oscillationFrameNum * 3, 100, 20, 20);
		

		int y;
		g.setStroke (Color.BLACK);


		for (y = 20; y < 120; y += 20) {

			g.strokeLine (0, y + 0.5, 320, y + 0.5);
		}

	}

	public void start (Stage stage) {

		int width = 320;
		int height = 120;
		Canvas canvas = new Canvas (width, height);
		drawFrame (canvas.getGraphicsContext2D (), 0, 0, width, height);
		BorderPane root = new BorderPane (canvas);
		root.setStyle ("-fx-border-width: 4px; -fx-border-color: #444");
		Scene scene = new Scene (root);
		stage.setScene (scene);
		stage.setTitle ("Motion Demo");
		stage.show ();
		stage.setResizable (false);
		AnimationTimer anim = new AnimationTimer () {
            private int frameNum;
            private long startTime = -1;
            private long previousTime;
            public void handle (long now) {
                

                if (startTime < 0) {
                    startTime = previousTime = now;
                    drawFrame (canvas.getGraphicsContext2D (), 0, 0, width, height);
                }
                
                else if (now - previousTime > 0.95e9 / 60) {

                	frameNum ++;
                	drawFrame (canvas.getGraphicsContext2D (), frameNum, (now-startTime)/1e9, width, height);
                    previousTime = now;
                }
			}

		};
		anim.start ();
	}

}
