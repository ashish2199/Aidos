package bomberman;

import bomberman.animations.PlayerAnimations;
import bomberman.constants.GlobalConstants;
import bomberman.utils.Animator;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class Bomberman extends Application {

    @Override
    public void start(Stage primaryStage) {
		primaryStage.setTitle(GlobalConstants.GAME_NAME + GlobalConstants.GAME_VERSION);

	    Group root = new Group();
	    Scene theScene = new Scene( root );
	    primaryStage.setScene( theScene );

	    Canvas canvas = new Canvas( 512, 512 );
	    root.getChildren().add( canvas );

	    GraphicsContext gc = canvas.getGraphicsContext2D();

        final long startNanoTime = System.nanoTime();

        Animator.init();

        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;
                gc.clearRect(0, 0, 512,512);
                PlayerAnimations.walkDownAnimation(gc, t);
            }
        }.start();

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
