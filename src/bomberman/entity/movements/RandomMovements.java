package bomberman.entity.movements;

import bomberman.constants.Direction;

import static bomberman.constants.Direction.*;

public class RandomMovements implements MovementStrategy {
	// TODO testing purposes, replace with AI later

	private int counter, directionChangeFrequency;
	Direction prev;

	public RandomMovements(int dCF) {
		prev = IDLE;
		counter = 0;
		directionChangeFrequency = dCF;
	}

	public Direction getDirection() {
		counter++;
		if (counter % directionChangeFrequency == 0) {
			int random = (int) (Math.random() * 5 + 1);
			switch (random) {
			case 1:
				prev = UP;
				break;
			case 2:
				prev = DOWN;
				break;
			case 3:
				prev = RIGHT;
				break;
			case 4:
				prev = LEFT;
				break;
			default:
				prev = IDLE;
			}
		}
		return prev;
	}

}
