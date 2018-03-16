/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.animations;

import bomberman.animations.sprites.Sprite;
import bomberman.animations.sprites.SpriteSpecification;
import bomberman.entity.Entity;

/**
 * @author Ashish
 */
public class PlayerAnimations implements Animations {

	Sprite moveRight;
	Sprite moveLeft;
	Sprite moveUp;
	Sprite moveDown;
	Sprite idle;
	Sprite die;
	double playSpeed;

	public PlayerAnimations(Entity e) {
		playSpeed = 0.1;
		moveDown = new Sprite(e, SpriteSpecification.PLAYERDOWN);
		moveLeft = new Sprite(e, SpriteSpecification.PLAYERLEFT);
		moveUp = new Sprite(e, SpriteSpecification.PLAYERUP);
		moveRight = new Sprite(e, SpriteSpecification.PLAYERRIGHT);
		idle = new Sprite(e, SpriteSpecification.PLAYERIDLE);
		die = new Sprite(e, SpriteSpecification.PLAYERDIE);
	}

	public Sprite getMoveRightSprite() {
		return moveRight;
	}

	public Sprite getMoveLeftSprite() {
		return moveLeft;
	}

	public Sprite getMoveUpSprite() {
		return moveUp;
	}

	public Sprite getMoveDownSprite() {
		return moveDown;
	}

	public Sprite getPlayerIdleSprite() {
		return idle;
	}

	public Sprite getPlayerDying() {
		return die;
	}

	public Sprite getSprite() {
		return getPlayerIdleSprite();
	}

}
