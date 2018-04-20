package bomberman.entity.player;

import bomberman.Sandbox;
import bomberman.constants.EntityDimensions;
import bomberman.constants.GlobalConstants;
import bomberman.entity.Entity;
import bomberman.entity.MovingEntity;
import bomberman.entityconfigurations.animations.PlayerAnimations;
import bomberman.entityconfigurations.boundedbox.CollidableType;
import bomberman.entityconfigurations.boundedbox.RectBoundedBox;
import bomberman.gamecontroller.InputManager;

public class Player extends MovingEntity {

	public Player(int x, int y) {
		super(x, y);
		entityBoundary = new RectBoundedBox(positionX, positionY, (int)ed.gameW - 10, (int)ed.gameH - 5);
		// this makes it easier to move player around the map 
		//TODO find a way to remove this
	}
	
	@Override
	protected void updateExtra(Sandbox sb) {
		if (((InputManager) movementStrategy).placeBomb()) {
			double x = positionX + EntityDimensions.PLAYERIDLED.width / 2;
			double y = positionY + EntityDimensions.PLAYERIDLED.height / 2;
			sb.addBombTo(x, y);
		}
	}

	protected void setAnimations(Entity e) {
		animations = new PlayerAnimations(e);
	}

	public int setHealth() {
		return 100;
	}

	protected String setName() {
		return "Player";
	}

	@Override
	protected void setED() {
		ed = EntityDimensions.PLAYERIDLED;
	}

	@Override
	protected void setMovementStrategy() {
		movementStrategy = new InputManager();
	}

	@Override
	protected void setSteps() {
		steps = GlobalConstants.PLAYER_SPEED;
	}
	
	@Override
	protected void setDirectionalSprite() {
		if (!dead) {
		switch (currentDirection) {
		case UP:
			setCurrentSprite(((PlayerAnimations) animations).getMoveUpSprite());
			break;
		case DOWN:
			setCurrentSprite(((PlayerAnimations) animations).getMoveDownSprite());
			break;
		case LEFT:
			setCurrentSprite(((PlayerAnimations) animations).getMoveLeftSprite());
			break;
		case RIGHT:
			setCurrentSprite(((PlayerAnimations) animations).getMoveRightSprite());
			break;
		default: // direction = IDLE, do nothing
			setCurrentSprite(animations.getSprite());
		}
	}
	}

	@Override
	protected void setCollidableType() {
		collidableType = CollidableType.PENETRABLE;
	}

}
