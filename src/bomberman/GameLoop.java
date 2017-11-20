package bomberman;

import bomberman.animations.Direction;
import bomberman.entity.player.Player;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

public class GameLoop
{
	   static double tickDuration;
	   final static long startNanoTime = System.nanoTime();
	   static Player player = new Player();

    public static double getTickDuration() {
        return tickDuration;
    }

	public static void start(GraphicsContext gc)
	{
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                tickDuration = (currentNanoTime - startNanoTime) / 1000000000.0;
                gc.clearRect(0, 0, 512, 512);
                player.draw();
                //Change this too see the different sprites and movement in action
                player.move(Direction.DOWN);
            }
        }.start();
	}
}
