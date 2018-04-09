/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.gamecontroller;

import java.util.List;

import static bomberman.constants.Direction.*;

import bomberman.constants.Direction;
import bomberman.entity.movements.MovementStrategy;
import javafx.scene.input.KeyCode;

/**
 *
 * @author Ashish
 */
public class InputManager implements MovementStrategy {

	Direction direction;
	boolean placeBomb;

	public InputManager() {
		direction = IDLE;
		placeBomb = false;
	}

	public void handlePlayerMovements() {
		List<KeyCode> keyboardInputs = EventHandler.getInputList();
		if (keyboardInputs.isEmpty()) {
			direction = IDLE;
		} else {
			switch (keyboardInputs.get(0)) {
			case UP:
			case W:
				direction = UP;
				break;
			case DOWN:
			case S:
				direction = DOWN;
				break;
			case LEFT:
			case A:
				direction = LEFT;
				break;
			case RIGHT:
			case D:
				direction = RIGHT;
				break;
			case SPACE:
				placeBomb = true;
				break;
			default:
				direction = IDLE;
				break;
			}
		}
	}

	public Direction getDirection() {
		handlePlayerMovements();
		return direction;
	}

	public boolean placeBomb() {
		placeBomb = false;
		handlePlayerMovements();
		return placeBomb;
	}
}
