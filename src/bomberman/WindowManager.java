package bomberman;

import bomberman.constants.GlobalConstants;
import bomberman.gamecontroller.GameEventHandler;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

public class WindowManager {
	
	GameHandler gameHandler;
	Group root;
	Scene s;
	BorderPane b;
	Canvas c;
	StringProperty level = new SimpleStringProperty("");
	StringProperty state = new SimpleStringProperty("");

	public WindowManager(GameHandler gh) {
		gameHandler = gh;
		root = GlobalConstants.parent;
		s = new Scene(root, GlobalConstants.BACKGROUND_COLOR);
		b = new BorderPane();
		b.setTop(createToolBar());
		root.getChildren()
				.add(b);
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
		level.setValue("Level: " + gameHandler.getLevel());
		state.setValue("Game Status: " + GameState.gameStatus);
	}
	
	private HBox createMenuBar() {
		// -------- create menu items --------
		Button newGame = new Button("New Game");
		newGame.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				gameHandler.newGame();
			}
		});
		
		ToggleButton pauseGame = new ToggleButton("Pause/Play");
		pauseGame.setOnAction(event -> {
		    if (pauseGame.isSelected()) {
		    	gameHandler.stopGame();
		    }else {
		    	gameHandler.resumeGame();
		    }
		    state.setValue("Game Status: " + GameState.gameStatus);
		});
		
		return new HBox(newGame, pauseGame);
	}

	private ToolBar createToolBar() {
		HBox hbox = new HBox(20);
		Label levelStats = new Label("Level: 0");
		Label gameState = new Label("gameState: -");
		levelStats.textProperty().bind(level);
		gameState.textProperty().bind(state);
		hbox.setAlignment(Pos.CENTER_LEFT);
		hbox.getChildren().addAll(createMenuBar(), levelStats, new Separator(Orientation.VERTICAL), gameState);
		ToolBar toolBar = new ToolBar(hbox);
		return toolBar;
	}

}
