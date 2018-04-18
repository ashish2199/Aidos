package bomberman;

import bomberman.constants.GlobalConstants;
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
	Group root;
	Scene s;

	public GameHandler() {
		root = GlobalConstants.parent;
		mapL = new MapLoader();
		int sceneW = mapL.getSceneWidth();
		int sceneH = mapL.getSceneHeight();
//		ToolBar toolBar1 = new ToolBar(new RadioButton("Medium"));
//		root.getChildren().add(toolBar1);
//		s = new Scene(root, sceneW, sceneH, GlobalConstants.BACKGROUND_COLOR);
		sb = new Sandbox(root, mapL.getEntities(), sceneW, sceneH);
//		root.getChildren().add(toolBar1);
//		EventHandler.attachEventHandlers(s);
		GameLoop.start(sb.getGraphicsContext(), sb);
	}

	public Scene getScene() {
		return sb.getScene();
	}
	//
	// public void setUpScene() {
	// mapL.loadMap();
	// }
}
