/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.entity;

import bomberman.constants.Direction;
import bomberman.scenes.Sandbox;

/**
 *
 * @author kdost
 */
public abstract class MovingEntity extends Entity {
	
	protected Direction currentDirection;
	
    protected MovingEntity(int x, int y) {
		super(x, y);
	}
    
	protected boolean checkCollisions(int x, int y) {
		entityBoundary.setPosition(x, y);

		for (Entity e : Sandbox.getEntities()) {
			if (e != this && isColliding(e) && !e.isPlayerCollisionFriendly()) {
				entityBoundary.setPosition(positionX, positionY);

				// System.out.println("Player x=" + getPositionX() + " y=" + getPositionY() + "
				// colliding with x="
				// + e.getPositionX() + " y=" + e.getPositionY());

				return true;
			}
		}
		entityBoundary.setPosition(positionX, positionY);
		return false;
	}

	public abstract void move(int steps, Direction direction);

}
