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

public class WindowManager {

	GameHandler gameHandler;
	Scene s;
	BorderPane b = new BorderPane();
	Canvas c = new Canvas();
	StringProperty level = new SimpleStringProperty("");
	StringProperty state = new SimpleStringProperty("");

	public WindowManager(GameHandler gh) {
		gameHandler = gh;
		s = new Scene(b, GlobalConstants.BACKGROUND_COLOR);
		b.setTop(createToolBar());
		b.setBackground(Background.EMPTY); // for scene background to show through
		GameEventHandler.attachEventHandlers(s);
	}

	public Scene getScene() {
		return s;
	}

	public GraphicsContext getGraphicsContext() {
		return c.getGraphicsContext2D();
	}

	public void resetCanvas(double width, double height) {
		c = new Canvas(width, height);
		b.setCenter(c);
		level.setValue("Level: " + gameHandler.getLCurrentLevel());
		state.setValue("Game Status: " + GameState.gameStatus);
		System.out.println(width + " ... " + height);
		System.out.println(b.getWidth());
		System.out.println(b.getHeight());
		System.out.println(s.getWidth());
		System.out.println(s.getHeight());
	}

	private HBox createControlBar() {
		// -------- create menu items --------
		Button newGame = new Button("New Game");
		newGame.setFocusTraversable(false);
		newGame.setOnAction(event -> gameHandler.newGame());

		ToggleButton pauseGame = new ToggleButton("Pause/Play");
		pauseGame.setFocusTraversable(false);
		pauseGame.setOnAction(event -> {
			if (pauseGame.isSelected()) {
				gameHandler.stopGame();
			} else {
				gameHandler.resumeGame();
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
				.bind(level);
		gameState.textProperty()
				.bind(state);
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
		level2.setOnAction(event -> gameHandler.loadLevel(2));
		
		levelSwitch.getItems().add(level2);
		levelSwitch.setFocusTraversable(false);
		return levelSwitch;
	}

}
