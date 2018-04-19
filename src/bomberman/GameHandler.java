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
		sb = new Sandbox(mapL.getEntities(), window.getGraphicsContext(), this);
		loop.init(window.getGraphicsContext(), sb, sceneW, sceneH);
		loop.start();
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}

