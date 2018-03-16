package bomberman.entity.player;

import bomberman.GameLoop;
import bomberman.animations.PlayerAnimations;
import bomberman.constants.Direction;
import bomberman.constants.GlobalConstants;
import bomberman.entity.Entity;
import bomberman.entity.KillableEntity;

public class Player extends KillableEntity {

	public Player() {
		super(64, 64);
	}

	public void move(Direction direction) {
		move(1, direction);
	}

	public void die() {
		setCurrentSprite(((PlayerAnimations) animations).getPlayerDying());
		dead = true;
	}

	@Override
	public void move(int steps, Direction direction) {

		steps *= GameLoop.getDeltaTime();

		if (steps == 0) {
			setCurrentSprite(((PlayerAnimations) animations).getPlayerIdleSprite());
			return;
		} else {
			switch (direction) {
			case UP:
				if (!checkCollisions(positionX, positionY - steps)) {
					positionY -= steps;
					setCurrentSprite(((PlayerAnimations) animations).getMoveUpSprite());
					currentDirection = Direction.UP;
				}
				break;
			case DOWN:
				if (!checkCollisions(positionX, positionY + steps)) {
					positionY += steps;
					setCurrentSprite(((PlayerAnimations) animations).getMoveDownSprite());
					currentDirection = Direction.DOWN;
				}
				break;
			case LEFT:
				if (!checkCollisions(positionX - steps, positionY)) {
					positionX -= steps;
					setCurrentSprite(((PlayerAnimations) animations).getMoveLeftSprite());
					currentDirection = Direction.LEFT;
				}
				break;
			case RIGHT:
				 if (!checkCollisions(positionX + steps, positionY)) {
				 positionX += steps;
				 setCurrentSprite(((PlayerAnimations) animations).getMoveRightSprite());
				 currentDirection = Direction.RIGHT;
				 }
				break;
			default:
				setCurrentSprite(((PlayerAnimations) animations).getPlayerIdleSprite());
			}
		}
	}

	public void removeFromScene() {
		// throw new UnsupportedOperationException("Not supported yet."); // To change
		// body of generated methods, choose
		// // Tools | Templates.
	}

	public boolean isPlayerCollisionFriendly() {
		return true;
	}

	protected void setAnimations(Entity e) {
		animations = new PlayerAnimations(e);
	}

	protected int entityWidth() {
		return GlobalConstants.PLAYER_WIDTH;
	}

	protected int entityHeight() {
		return GlobalConstants.PLAYER_HEIGHT;
	}

	public int setHealth() {
		return 100;
	}

	protected String setName() {
		return "Player";
	}

}
