package bomberman;

import bomberman.constants.GlobalConstants;
import bomberman.entity.Entity;
import bomberman.entity.player.Player;
import bomberman.entity.staticobjects.BlackBomb;
import bomberman.gamecontroller.InputManager;
import bomberman.scenes.Sandbox;
import java.util.Iterator;
import java.util.Vector;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

public class GameLoop {

    static double currentGameTime;
    static double oldGameTime;
    static double deltaTime;
    final static long startNanoTime = System.nanoTime();

    public static double getCurrentGameTime() {
        return currentGameTime;
    }

    public static void start(GraphicsContext gc) {
        GameState.gameStatus=GlobalConstants.GameStatus.Running;
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
            	oldGameTime = currentGameTime;
            	currentGameTime = (currentNanoTime - startNanoTime) / 1000000000.0;
            	deltaTime = currentGameTime - oldGameTime;
                gc.clearRect(0, 0, GlobalConstants.CANVAS_WIDTH, GlobalConstants.CANVAS_WIDTH);
                //TODO This will have to be something like, currentScene.getEntities()
                updateGame();
                renderGame();
            }
        }.start();
    }

    public static double getDeltaTime() {
    	return deltaTime * 100;
    }

    public static void updateGame() {
        InputManager.handlePlayerMovements();
        Vector<Entity> entities = Sandbox.getEntities();
        Player player = Sandbox.getPlayer();
        Iterator<Entity> it = entities.iterator();
        //remove the current bomb
        while (it.hasNext()) {
            Entity entity = it.next();
            if(entity instanceof BlackBomb){
                boolean alive = ((BlackBomb) entity).isAlive();
                if(!alive){
                    // not removig directly from list to prevent ConcurrentModification
                    it.remove();
                    player.incrementBombCount();
                }
            }
        }
    }

    public static void renderGame() {
        for (Entity e : Sandbox.getEntities()) {
            e.draw();
        }
    }

}
