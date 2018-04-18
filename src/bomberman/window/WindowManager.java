package bomberman.window;

import bomberman.constants.GlobalConstants;
import bomberman.gamecontroller.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;

public class WindowManager {

	Group root;
	Scene s;
	BorderPane b;
	Canvas c;
	
	public WindowManager() {
		root = GlobalConstants.parent;
		s = new Scene(root, GlobalConstants.BACKGROUND_COLOR);
		b = new BorderPane();
		b.setTop(createToolBar());
		root.getChildren()
				.add(b);
		EventHandler.attachEventHandlers(s);

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
	}

	private MenuBar createMenuBar() {
		MenuBar menuBar = new MenuBar();
		Menu menuFile = new Menu("File");
		menuFile.getItems()
				.add(new CustomMenuItem(new Label("testing")));
		menuBar.getMenus()
				.add(menuFile);
		return menuBar;
	}

	private ToolBar createToolBar() {
		ToolBar toolBar = new ToolBar(createMenuBar());
		toolBar.getItems()
				.add(new Label("HI"));
		return toolBar;
	}

}
