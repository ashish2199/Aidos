package bomberman.animations;

import bomberman.animations.sprites.Sprite;
import bomberman.animations.sprites.SpriteSpecification;
import bomberman.entity.Entity;

/* 
 * For entities that have only one sprite
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
