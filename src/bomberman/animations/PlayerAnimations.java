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
public class PlayerAnimations extends KillableEntityAnimations {

	private Sprite moveRight, moveLeft, moveUp, moveDown;

	public PlayerAnimations(Entity e) {
		super(e, SpriteSpecification.PLAYERIDLE, SpriteSpecification.PLAYERDIE);
		moveDown = new Sprite(e, SpriteSpecification.PLAYERDOWN);
		moveLeft = new Sprite(e, SpriteSpecification.PLAYERLEFT);
		moveUp = new Sprite(e, SpriteSpecification.PLAYERUP);
		moveRight = new Sprite(e, SpriteSpecification.PLAYERRIGHT);
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

	public Sprite getSprite() {
		return idle;
	}

}
