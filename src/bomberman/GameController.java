package bomberman;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GameController implements GameObserver {

	private GameHandler game;
	private GameView view;
	private StringProperty level, state, lives;

	public GameController(GameHandler gh) {
		game = gh;
		gh.addObserver(this);
		level = new SimpleStringProperty("");
		state = new SimpleStringProperty("");
		lives = new SimpleStringProperty("");
	}

	StringProperty levelLabel() {
		return level;
	}

	StringProperty stateLabel() {
		return state;
	}
	
	StringProperty livesLabel() {
		return lives;
	}

	void setView(GameView view) {
		this.view = view;
	}

	void newGame() {
		game.newGame();
		updateLabels();
	}

	void pause() {
		game.stopGame();
		updateLabels();
	}

	void play() {
		game.resumeGame();
		updateLabels();
	}

	void loadLevel(int newLevel) {
		game.loadLevel(newLevel);
		updateLabels();
	}
	
	public void update() {
		updateLabels();
	}

	public void newLevel(double width, double height) {
		view.resetCanvas(width, height);
		updateLabels();
	}
	
	private void updateLabels() {
		level.setValue("Level: " + game.getLCurrentLevel());
		state.setValue("Game Status: " + game.getGameStatus());
		lives.setValue("Lives: " + game.getLives());
	}

}
