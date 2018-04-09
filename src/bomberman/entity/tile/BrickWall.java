package bomberman.entity.tile;

import bomberman.Sandbox;
import bomberman.constants.EntityDimensions;
import bomberman.entity.Entity;
import bomberman.entity.KillableEntity;
import bomberman.entity.configurations.animations.KillableEntityAnimations;
import bomberman.entity.configurations.animations.sprites.SpriteSpecification;
import bomberman.entity.configurations.boundedbox.CollidableType;
import bomberman.utils.Tiling;

public class BrickWall extends KillableEntity {

	public BrickWall(int x, int y) {
		super(Tiling.snapTile(x), Tiling.snapTile(y));
	}

	public int setHealth() {
		return 0;
	}

	public void update(Sandbox sb) {}
	
	public boolean isPersistant() {
		return !dead;
	}

	protected void setAnimations(Entity e) {
		animations = new KillableEntityAnimations(e, SpriteSpecification.BRICKWALL, SpriteSpecification.BRICKWALL);
	}

	protected String setName() {
		return "Brick Wall " + ID;
	}

	protected EntityDimensions setED() {
		return EntityDimensions.WALLD;
	}

	protected void setCollidableType() {
		collidableType = CollidableType.EXPLODABLE;
	}

}
