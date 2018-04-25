package bomberman;

import java.util.Observable;
import java.util.Observer;

import bomberman.constants.GlobalConstants;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GameController {
	
	private GameHandler game;
	private StringProperty level, state;

	public GameController(GameHandler gh) {
		game = gh;
		level = new SimpleStringProperty("");
		state = new SimpleStringProperty("");
	}
	
	StringProperty levelLabel() {
		return level;
	}
	
	StringProperty stateLabel() {
		return state;
	}
	
	void newGame() {
		loadLevel(1);
	}
	
	void pause() {
		game.stopGame();
		GameState.gameStatus = GlobalConstants.GameStatus.Paused;
		state.setValue("Game Status: " + GameState.gameStatus);
	}
	
	void play() {
		game.resumeGame();
		GameState.gameStatus = GlobalConstants.GameStatus.Running;
		state.setValue("Game Status: " + GameState.gameStatus);
	}
	
	void loadLevel(int newLevel) {
		GameState.gameStatus = GlobalConstants.GameStatus.Running;
		level.setValue("Level: " + game.getLCurrentLevel());
		state.setValue("Game Status: " + GameState.gameStatus);
		game.loadLevel(newLevel);
	}

}
