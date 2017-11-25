package bomberman;

import bomberman.constants.GlobalConstants;
import bomberman.entity.Entity;
import bomberman.gamecontroller.InputManager;
import bomberman.scenes.Sandbox;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

public class GameLoop {

    static double tickDuration;
    final static long startNanoTime = System.nanoTime();

    public static double getTickDuration() {
        return tickDuration;
    }

    public static void start(GraphicsContext gc) {
        GameState.gameStatus=GlobalConstants.GameStatus.Running;
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                tickDuration = (currentNanoTime - startNanoTime) / 1000000000.0;
                gc.clearRect(0, 0, 512, 512);
                //TODO This will have to be something like, currentScene.getEntities()
                updateGame();
                renderGame();
            }
        }.start();
    }

    public static void updateGame() {
        InputManager.handlePlayerMovements();
    }

    public static void renderGame() {
        for (Entity e : Sandbox.getEntities()) {
            e.draw();
        }
    }

}
