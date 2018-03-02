package bomberman.animations;

import bomberman.entity.Entity;

public class WallAnimations implements Animations {
	
	Sprite s;

	public WallAnimations(Entity e) {
		s = new Sprite(e, 16, 0, 348, 123, 1, 16, 16, 2, false);
	}

	public Sprite getSprite() {
		return s;
	}

}
