package bomberman.entityconfigurations.movements;

import bomberman.constants.Direction;

/**
 * Every moving entity holds a movement strategy object
 * This object is responsible for making a decision on the next movement of its holding entity
 * at every loop of the game
 * @author tialim
 *
 */

public interface MovementStrategy {
	Direction getDirection();
}
