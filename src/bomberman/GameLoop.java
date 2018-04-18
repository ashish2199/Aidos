package bomberman;

import bomberman.constants.GlobalConstants;
import bomberman.entity.Entity;

import java.util.Iterator;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

public class GameLoop {

	private static double currentGameTime, oldGameTime, deltaTime, width, height;
	private final long startNanoTime = System.nanoTime();
	private boolean isStopped;
	private AnimationTimer animationT;
	private GraphicsContext gc;
	private Sandbox sb;
	
	public GameLoop () {
		isStopped = true;
	};

	public GameLoop(GraphicsContext graphicC, Sandbox sandbox, double w, double h) {
		isStopped = true;
		init(graphicC, sandbox, w, h);
	}

	public void init(GraphicsContext graphicC, Sandbox sandbox, double w, double h) {
		width = w;
		height = h;
		gc = graphicC;
		sb = sandbox;
		animationT = new AnimationTimer() {
			public void handle(long currentNanoTime) {
				oldGameTime = currentGameTime;
				currentGameTime = (currentNanoTime - startNanoTime) / 1000000000.0;
				deltaTime = currentGameTime - oldGameTime;
				gc.clearRect(0, 0, width, height);
				updateGame(sb);
				renderGame(sb);
			}
		};
	}

	public static double getCurrentGameTime() {
		return currentGameTime;
	}

	public void start() {
		if (isStopped) {
			GameState.gameStatus = GlobalConstants.GameStatus.Running;
			animationT.start();
			isStopped = false;
		}
	}

	public void stop() {
		if (!isStopped) {
			GameState.gameStatus = GlobalConstants.GameStatus.Paused;
			animationT.stop();
			isStopped = true;
		}
	}

	public double getDeltaTime() {
		return deltaTime * 100;
	}

	public static void updateGame(Sandbox sb) {
		sb.updateEntities();
		sb.killEntities();
		cleanUpEntities(sb);
	}

	public static void renderGame(Sandbox sb) {
		sb.forEach(e -> e.draw(sb));
	}

	private static void cleanUpEntities(Sandbox sb) {
		// removes unwanted entities from the game
		Iterator<Entity> it = sb.iterator();
		while (it.hasNext()) {
			Entity entity = it.next();
			if (!entity.isPersistant()) {
				it.remove(); // not removing directly from list to prevent ConcurrentModification
			}
		}
	}

}
