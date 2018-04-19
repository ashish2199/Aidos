package bomberman;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.Scene;

/**
 * Responsible for updating the sandbox and loading new maps as the player
 * advances through levels Holds player statistics such as points, lives, etc
 * 
 * @author tialim
 *
 */

public class GameHandler implements Observer{

	private MapLoader mapL = new MapLoader();
	private WindowManager window = new WindowManager(this);
	private Sandbox sb;
	private GameLoop loop = new GameLoop();
	private int level;

	public GameHandler() {
		level = 1;
		newGame();
	}

	Scene getScene() {
		return window.getScene();
	}
	
	private void nextLevel() {
		loadLevel(++level);
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
	
	private void loadLevel(int level) {
		loop.stop();
		mapL.loadLevel(level);
		double sceneW = mapL.getSceneWidth();
		double sceneH = mapL.getSceneHeight();
		window.resetCanvas(sceneW, sceneH);
		sb = new Sandbox(this, mapL.getEntities(), window.getGraphicsContext());
		loop.init(window.getGraphicsContext(), sb, sceneW, sceneH);
		loop.start();
	}

	public void update(Observable o, Object arg) {
		if (sb.gameWon()) {
			nextLevel();
		}
	}
	
}

