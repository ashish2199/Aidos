package bomberman.entity.bomb;

import java.util.Date;

/**
 * @author tialim
 */

import bomberman.Sandbox;
import bomberman.constants.EntityDimensions;
import bomberman.entity.Entity;
import bomberman.entity.configurations.animations.SingleSpriteAnimations;
import bomberman.entity.configurations.animations.sprites.SpriteSpecification;
import bomberman.entity.configurations.boundedbox.CollidableType;

public class Explosion extends Entity {

	Date addedDate;
	private final int EXPLOSION_DURATION = 400;

	protected Explosion(int x, int y) {
		super(x, y);
		addedDate = new Date();
	}

	public boolean isPersistant() {
		return timePast() < EXPLOSION_DURATION;
	}

	public void update(Sandbox sb) {
		// explosion is only "dangerous" during exploding phase
		// ie when the animation is represented by a growing explosion, not when it is fading off
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

	protected void setED() {
		ed = EntityDimensions.EXPLOSIOND;
	}

	private long timePast() {
		return new Date().getTime() - (addedDate.getTime());
	}

	protected void setCollidableType() {
		collidableType = CollidableType.PENETRABLE;
	}

}
