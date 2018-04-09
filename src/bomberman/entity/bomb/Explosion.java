package bomberman.entity.bomb;

import java.util.Date;

import bomberman.Sandbox;
import bomberman.animations.SingleSpriteAnimations;
import bomberman.animations.sprites.SpriteSpecification;
import bomberman.constants.EntityDimensions;
import bomberman.entity.Entity;
import bomberman.entity.boundedbox.CollidableType;

public class Explosion extends Entity {

	Date addedDate;
	private final int EXPLOSION_DURATION = 400;

	protected Explosion(int x, int y) {
		super(x, y);
		addedDate = new Date();
	}

	public boolean isPersistant() {
		// // TODO make variable
		return timePast() < EXPLOSION_DURATION;
	}

	public void update(Sandbox sb) {
		if (timePast() < EXPLOSION_DURATION / 2) {
			sb.killCollidingEntities(this);
		}
	}

	protected void setAnimations(Entity e) {
		animations = new SingleSpriteAnimations(e, SpriteSpecification.EXPLOSION);
	}

	protected String setName() {
		return "Explosion" + ID;
	}

	protected EntityDimensions setED() {
		return EntityDimensions.EXPLOSIOND;
	}

	private long timePast() {
		return new Date().getTime() - (addedDate.getTime());
	}

	protected void setCollidableType() {
		collidableType = CollidableType.PENETRABLE;
	}

}
