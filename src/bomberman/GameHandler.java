package bomberman;

import bomberman.constants.GlobalConstants;
import bomberman.window.WindowManager;
//import bomberman.window.Window;
import javafx.scene.Group;
import javafx.scene.Scene;

/**
 * Responsible for updating the sandbox and loading new maps as the player
 * advances through levels Holds player statistics such as points, lives, etc
 * 
 * @author tialim
 *
 */

public class GameHandler {

	Sandbox sb;
	MapLoader mapL;
	WindowManager w;
	Group root;
	Scene s;

	public GameHandler() {
		root = GlobalConstants.parent;
		mapL = new MapLoader();
		int sceneW = mapL.getSceneWidth();
		int sceneH = mapL.getSceneHeight();
		w = new WindowManager(sceneW, sceneH);
		sb = new Sandbox(root, mapL.getEntities(), w.getGC());
		GameLoop.start(sb.getGraphicsContext(), sb, sceneW, sceneH);
	}

	public Scene getScene() {
		return w.getScene();
	}
	//
	// public void setUpScene() {
	// mapL.loadMap();
	// }
}
