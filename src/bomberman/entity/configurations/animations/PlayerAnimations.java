/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.entity.configurations.animations;

import bomberman.entity.Entity;
import bomberman.entity.configurations.animations.sprites.Sprite;
import bomberman.entity.configurations.animations.sprites.SpriteSpecification;

/**
 * Specific class created for Player Animations since the player uniquely holds several sprites,
 * one for each direction of motion.
 * @author tialim
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
