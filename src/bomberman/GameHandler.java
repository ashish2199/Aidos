package bomberman;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

/**
 * Responsible for updating the sandbox and loading new maps as the player
 * advances through levels Holds player statistics such as points, lives, etc
 * 
 * @author tialim
 *
 */

public class GameHandler {

	MapLoader mapL = new MapLoader();
	WindowManager window = new WindowManager(this);
	Sandbox sb;
	GameLoop loop = new GameLoop();

	public GameHandler() {
//		newGame();
		loadLevel(2);
	}

	Scene getScene() {
		return window.getScene();
	}

	void newGame() {
		loadLevel(1);
	}
	
	void stopGame() {
		loop.stop();
	}
	
	BorderPane getBorderPane() {
		return window.getBorder();
	}
	
	void resumeGame() {
		loop.start();
	}
	
	int getLCurrentLevel() {
		return mapL.getLevel();
	}
	
	private void loadLevel(int level) {
		loop.stop();
		mapL.setLevel(level);
		double sceneW = mapL.getSceneWidth();
		double sceneH = mapL.getSceneHeight();
		window.resetCanvas(sceneW, sceneH);
		sb = new Sandbox(mapL.getEntities(), window.getGraphicsContext());
		loop.init(window.getGraphicsContext(), sb, sceneW, sceneH);
		loop.start();
	}
}

