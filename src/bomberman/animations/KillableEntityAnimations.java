package bomberman.animations;

import bomberman.animations.sprites.Sprite;
import bomberman.animations.sprites.SpriteSpecification;
import bomberman.entity.Entity;

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
