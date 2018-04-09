package bomberman.entity.movements;

import bomberman.constants.Direction;

public class Stationary implements MovementStrategy {

	public Direction getDirection() {
		return Direction.IDLE;
	}

}
