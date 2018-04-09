/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.entity;

import static bomberman.constants.Direction.*;

import bomberman.Sandbox;
import bomberman.constants.Direction;
import bomberman.entity.configurations.movements.MovementStrategy;

/**
 * @author tialim
 * @author kdost
 */
public abstract class MovingEntity extends KillableEntity {

	protected MovementStrategy movementStrategy;
	protected int steps;
	protected Direction currentDirection;

	protected MovingEntity(int x, int y) {
		super(x, y);
		setMovementStrategy();
		setSteps();
		currentDirection = IDLE;
	}

	@Override
	public void update(Sandbox sb) {
		move(sb);
		if (!dead) {
			updateExtra(sb);
		}
	}

	protected boolean checkCollisions(int x, int y, Sandbox sb) {
		entityBoundary.setPosition(x, y);
		for (Entity e : sb) {
			if (!e.equals(this) && isColliding(e) && !e.isPlayerCollisionFriendly()) {
				entityBoundary.setPosition(positionX, positionY);
				return true;
			}
		}
		entityBoundary.setPosition(positionX, positionY);
		return false;
	}

	protected void move(Sandbox sb) {
		if (!dead) {
			currentDirection = movementStrategy.getDirection();
			switch (currentDirection) {
			case UP:
				positionY -= findMaxSteps(steps, 0, -1, sb);
				break;
			case DOWN:
				positionY += findMaxSteps(steps, 0, 1, sb);
				break;
			case LEFT:
				positionX -= findMaxSteps(steps, -1, 0, sb);
				break;
			case RIGHT:
				positionX += findMaxSteps(steps, 1, 0, sb);
				break;
			default: // do nothing
			}
			setDirectionalSprite();
		}
	}

	protected int findMaxSteps(int steps, int stepsInX, int stepsInY, Sandbox sb) {
		// adjusts entity position so that it is right at the boundary of the entity
		// that it collides with
		if (steps == 0 || !checkCollisions(positionX + steps * stepsInX, positionY + steps * stepsInY, sb)) {
			return steps;
		}
		return findMaxSteps(steps - 1, stepsInX, stepsInY, sb);
	}

	protected void updateExtra(Sandbox sb) {
	} // additional operations can be added for each update call

	protected void setDirectionalSprite() {
	} // for entities that have specific directions, this can be set here

	protected abstract void setMovementStrategy();

	protected abstract void setSteps(); // this will determine the speed at which the Entity moves

}
