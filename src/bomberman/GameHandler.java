package bomberman;

import bomberman.constants.GlobalConstants;
import bomberman.window.WindowManager;
import javafx.scene.Scene;

/**
 * Responsible for updating the sandbox and loading new maps as the player
 * advances through levels Holds player statistics such as points, lives, etc
 * 
 * @author tialim
 *
 */

public class GameHandler {

	MapLoader mapL = new MapLoader();
	WindowManager w = new WindowManager(this);
	Sandbox sb;

	public GameHandler() {
		newGame();
	}

	public Scene getScene() {
		return w.getScene();
	}

	public void newGame() {
		mapL.setLevel(1);
		w.resetCanvas(mapL.getSceneWidth(), mapL.getSceneHeight());
		sb = new Sandbox(GlobalConstants.parent, mapL.getEntities(), w.getGraphicsContext());
		GameLoop.start(sb.getGraphicsContext(), sb, mapL.getSceneWidth(), mapL.getSceneWidth());
	}
}
