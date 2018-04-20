package bomberman;

import java.util.Observable;
import java.util.Observer;
import static bomberman.constants.GlobalConstants.NUM_LEVELS;

import javafx.scene.Scene;

/**
 * Manages the game at the highest level, and holds information such as the
 * current level, etc. When a player has won a map, it is responsible for
 * loading the second map onto the window.
 * 
 * @author tialim
 *
 */

public class GameHandler implements Observer {

	private MapLoader mapL = new MapLoader();
	private WindowManager window = new WindowManager(this);
	private Sandbox sb;
	private GameLoop loop = new GameLoop();
	private int level = 1;

	public GameHandler() {
		newGame();
	}

	Scene getScene() {
		return window.getScene();
	}
	
	public void update(Observable o, Object arg) {
		if (sb.gameWon()) {
			nextLevel();
		}
	}

	// -------- Methods for buttons and screen controls---------

	void stopGame() {
		loop.stop();
	}

	void resumeGame() {
		loop.start();
	}

	void newGame() {
		loadLevel(1);
	}

	int getLCurrentLevel() {
		return level;
	}

	// -------- Private Methods -----------

	private void nextLevel() {
		if ((level) < NUM_LEVELS) {
			loadLevel(++level);
		}
	}

	void loadLevel(int newLevel) { // TODO change to private later; kept open for dev.
		this.level = newLevel;
		mapL.loadLevel(level);
		double sceneW = mapL.getSceneWidth();
		double sceneH = mapL.getSceneHeight();
		window.resetCanvas(sceneW, sceneH);
		sb = new Sandbox(this, mapL.getEntities(), window.getGraphicsContext());
		loop.stop();
		loop.init(window.getGraphicsContext(), sb, sceneW, sceneH);
		loop.start();
	}

}
