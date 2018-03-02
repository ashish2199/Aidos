/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.gamecontroller;

import java.util.List;

import bomberman.constants.Direction;
import bomberman.entity.player.Player;
import bomberman.entity.staticobjects.BlackBomb;
import bomberman.scenes.Sandbox;
import javafx.scene.input.KeyCode;

/**
 *
 * @author Ashish
 */
public class InputManager {

	public static void handlePlayerMovements() {
		List<KeyCode> keyboardInputs = EventHandler.getInputList();
		Player player = Sandbox.getPlayer();
		if (keyboardInputs.isEmpty()) {
			player.move(0, Direction.DOWN);
		} else {
			switch (keyboardInputs.get(0)) {
			case UP:
			case W:
				player.move(5, Direction.UP);
				break;
			case DOWN:
			case S:
				player.move(5, Direction.DOWN);
				break;
			case LEFT:
			case A:
				player.move(5, Direction.LEFT);
				break;
			case RIGHT:
			case D:
				player.move(5, Direction.RIGHT);
				break;
			case SPACE:
				Sandbox.addEntityToGame(new BlackBomb(player.getPositionX(), player.getPositionY()));
				break;
			default:
				player.move(0, Direction.DOWN);
				break;
			}
		}
	}
}
