package bomberman;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

import bomberman.constants.GlobalConstants.GameStatus;

import static bomberman.constants.GlobalConstants.GameStatus.*;
import static bomberman.constants.GlobalConstants.NUM_LEVELS;

/**
 * Manages the game at the highest level, and holds information such as the
 * current level, etc. When a player has won a map, it is responsible for
 * loading the second map onto the window.
 * 
 * @author tialim
 *
 */

public class GameHandler implements Observer {

	private MapLoader mapL;
	private Sandbox sb;
	private GameLoop loop;
	private GameStatus state;
	private Collection<GameObserver> observers;
	private int level = 1;

	public GameHandler() {
		mapL = new MapLoader();
		loop = new GameLoop();
		observers = new ArrayList<GameObserver>();
	}

	public void update(Observable o, Object arg) {
		if (sb.gameWon()) {
			nextLevel();
		}
	}

	public void addObserver(GameObserver ob) {
		observers.add(ob);
	}

	// -------- Methods for buttons and screen controls---------

	void stopGame() {
		state = Paused;
		loop.stop();
	}

	void resumeGame() {
		state = Running;
		loop.start();
	}

	int getLCurrentLevel() {
		return level;
	}

	GameStatus getGameStatus() {
		return state;
	}

	// -------- Private Methods -----------

	private void nextLevel() {
		if ((level) < NUM_LEVELS) {
			loadLevel(++level);
		}
	}

	void loadLevel(int newLevel) { // TODO change to private later; kept open for dev.
		this.level = newLevel;
		
		mapL.loadLevel(level);
		double sceneW = mapL.getSceneWidth();
		double sceneH = mapL.getSceneHeight();
		observers.forEach(ob -> ob.newLevel(sceneW, sceneH));
		
		sb = new Sandbox(this, mapL.getEntities());
		stopGame();
		loop.init(sb, sceneW, sceneH);
		resumeGame();
	}

}
