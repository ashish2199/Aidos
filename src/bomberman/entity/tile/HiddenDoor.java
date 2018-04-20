package bomberman.entity.tile;

import java.util.Collection;

import bomberman.Sandbox;
import bomberman.constants.EntityDimensions;
import bomberman.entity.Entity;
import bomberman.entity.StaticEntity;
import bomberman.entity.player.Player;
import bomberman.entityconfigurations.animations.SingleSpriteAnimations;
import bomberman.entityconfigurations.animations.sprites.SpriteSpecification;
import bomberman.entityconfigurations.boundedbox.CollidableType;

public class HiddenDoor extends StaticEntity {
	
	BrickWall brickWall;
	private boolean brickWallAdded;

	public HiddenDoor(int x, int y) {
		super(x, y);
		brickWall = new BrickWall(x, y);
	}

	protected void setAnimations(Entity e) {
		animations = new SingleSpriteAnimations(e, SpriteSpecification.DOOR);
	}

	protected void setCollidableType() {
		collidableType = CollidableType.PENETRABLE;
	}

	public void update(Sandbox sb) {
		if (! brickWallAdded) {
			sb.addEntityToGame(new BrickWall(positionX, positionY));
			brickWallAdded = true;
		}
		// check if player is entering door
		Collection<Entity> colliding = sb.getEntityColliding(this);
		if (colliding.stream().anyMatch(e -> e instanceof Player)) {
			sb.playerOnDoor();
		}
	}

	protected String setName() {
		return "Hidden Wall" + ID;
	}

	protected void setED() {
		ed = EntityDimensions.TILED;
	}

}
