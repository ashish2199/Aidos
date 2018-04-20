package bomberman.entityconfigurations.animations;

import bomberman.entity.Entity;
import bomberman.entityconfigurations.animations.sprites.Sprite;
import bomberman.entityconfigurations.animations.sprites.SpriteSpecification;

/**
 * Animations for Killable Entities that have two sprites -- idle and dying
 * @author tialim
 */

public class KillableEntityAnimations implements Animations {
	
	protected Sprite idle, die;

	public KillableEntityAnimations(Entity e, SpriteSpecification idleSS, SpriteSpecification dyingSS) {
		idle = new Sprite(e, idleSS);
		die = new Sprite(e, dyingSS);
	}
	
	public Sprite getDyingSprite() {
		return die;
	}

	public Sprite getSprite() {
		return idle;
	}

}
