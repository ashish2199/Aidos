package bomberman.animations;

import bomberman.animations.sprites.Sprite;
import bomberman.animations.sprites.SpriteSpecification;
import bomberman.entity.Entity;

public class WallAnimations implements Animations {
	
	Sprite s;

	public WallAnimations(Entity e) {
		s = new Sprite(e, SpriteSpecification.WALL);
	}

	public Sprite getSprite() {
		return s;
	}

}
