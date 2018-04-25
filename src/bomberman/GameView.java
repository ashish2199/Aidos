package bomberman;

import bomberman.constants.GlobalConstants;
import bomberman.gamecontroller.GameEventHandler;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 * This class controls how the window is displayed, including how each new level
 * is loaded onto the window, controls, buttons and text displays
 * 
 * @author tialim
 *
 */

public class GameView {

	GameController controller;
	Scene s;
	BorderPane b = new BorderPane();
	Canvas c = new Canvas();
	StringProperty level = new SimpleStringProperty("");
	StringProperty state = new SimpleStringProperty("");

	public GameView(GameController controller) {
		this.controller = controller;
//		controller.setView(this);
		s = new Scene(b, GlobalConstants.BACKGROUND_COLOR);
		b.setTop(createToolBar());
		b.setBackground(Background.EMPTY); // for scene background to show through
		GameEventHandler.attachEventHandlers(s);
	}

	public Scene getScene() {
		return s;
	}

//	public GraphicsContext getGraphicsContext() {
//		return c.getGraphicsContext2D();
//	}

	public void resetCanvas(double width, double height) {
		c = new Canvas(width, height);
		b.setCenter(c);
		Renderer.gc = c.getGraphicsContext2D();
	}

	private HBox createControlBar() {
		// -------- create menu items --------
		Button newGame = new Button("New Game");
		newGame.setFocusTraversable(false);
		newGame.setOnAction(event -> {
			controller.newGame();
		});

		ToggleButton pauseGame = new ToggleButton("Pause/Play");
		pauseGame.setFocusTraversable(false);
		pauseGame.setOnAction(event -> {
			if (pauseGame.isSelected()) {
				controller.pause();
			} else {
				controller.play();
			}
			state.setValue("Game Status: " + GameState.gameStatus);
		});
		return new HBox(newGame, pauseGame, createLevelMenu());
	}

	private ToolBar createToolBar() {
		HBox hbox = new HBox(20);
		Label levelStats = new Label("Level: 0");
		Label gameState = new Label("gameState: -");
		levelStats.textProperty()
				.bind(controller.levelLabel());
		gameState.textProperty()
				.bind(controller.stateLabel());
		hbox.setAlignment(Pos.CENTER_LEFT);
		hbox.getChildren()
				.addAll(createControlBar(), levelStats, new Separator(Orientation.VERTICAL), gameState);
		ToolBar toolBar = new ToolBar(hbox);
		return toolBar;
	}

	// used for development
	private MenuButton createLevelMenu() {
		MenuButton levelSwitch = new MenuButton("Change Level");

		// level 2 button
		MenuItem level2 = new MenuItem("Level 2");
		level2.setOnAction(event -> controller.loadLevel(2));

		// level 3 button
		MenuItem level3 = new MenuItem("Level 3");
		level3.setOnAction(event -> controller.loadLevel(3));

		levelSwitch.getItems()
				.addAll(level2, level3);
		levelSwitch.setFocusTraversable(false);
		return levelSwitch;
	}

}
