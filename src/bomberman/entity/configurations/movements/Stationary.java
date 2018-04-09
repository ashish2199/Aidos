package bomberman.entity.configurations.movements;

import bomberman.constants.Direction;

public class Stationary implements MovementStrategy {

	public Direction getDirection() {
		return Direction.IDLE;
	}

}
