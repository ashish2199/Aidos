package bomberman.entityconfigurations.animations;

import bomberman.entity.Entity;
import bomberman.entityconfigurations.animations.sprites.Sprite;
import bomberman.entityconfigurations.animations.sprites.SpriteSpecification;

/**
 * For entities that have only one sprite
 * @author tialim
 */
//TODO better descriptor

public class SingleSpriteAnimations implements Animations {

	private Sprite sprite;
	
	public SingleSpriteAnimations(Entity e, SpriteSpecification ss) {
		sprite = new Sprite(e, ss);
	}
	
	public Sprite getSprite() {
		return sprite;
	}

}
