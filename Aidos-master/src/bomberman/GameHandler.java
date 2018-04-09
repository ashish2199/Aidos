package bomberman;

import java.io.File;

import javafx.scene.Scene;

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
//	public void setUpScene() {
//		mapL.loadMap();
//	}
}

