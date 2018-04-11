package bomberman.entity.tile;

import bomberman.Sandbox;
import bomberman.constants.EntityDimensions;
import bomberman.entity.Entity;
import bomberman.entity.StaticEntity;
import bomberman.entity.configurations.animations.SingleSpriteAnimations;
import bomberman.entity.configurations.animations.sprites.SpriteSpecification;
import bomberman.entity.configurations.boundedbox.CollidableType;

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
	}

	protected String setName() {
		return "Hidden Wall" + ID;
	}

	protected void setED() {
		ed = EntityDimensions.TILED;
	}

}
