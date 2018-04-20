package bomberman.entity.tile;

import bomberman.Sandbox;
import bomberman.constants.EntityDimensions;
import bomberman.entity.Entity;
import bomberman.entity.KillableEntity;
import bomberman.entityconfigurations.animations.KillableEntityAnimations;
import bomberman.entityconfigurations.animations.sprites.SpriteSpecification;
import bomberman.entityconfigurations.boundedbox.CollidableType;
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

	protected void setED() {
		ed = EntityDimensions.TILED;
	}

	protected void setCollidableType() {
		collidableType = CollidableType.EXPLODABLE;
	}

}
