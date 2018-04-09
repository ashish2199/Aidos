package bomberman;

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

	public GameHandler() {
		mapL = new MapLoader();
		sb = new Sandbox(mapL.getEntities(), mapL.getSceneWidth(), mapL.getSceneHeight());
	}

	public Scene getScene() {
		return sb.getScene();
	}
	//
	// public void setUpScene() {
	// mapL.loadMap();
	// }
}
