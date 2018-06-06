/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.entity.bomb;

import bomberman.Sandbox;
import bomberman.constants.Direction;
import bomberman.constants.EntityDimensions;
import bomberman.constants.GlobalConstants;
import bomberman.entity.Entity;
import bomberman.entityconfigurations.animations.SingleSpriteAnimations;
import bomberman.entityconfigurations.animations.sprites.SpriteSpecification;
import bomberman.entityconfigurations.boundedbox.CollidableType;
import bomberman.utils.Tiling;

import java.util.Date;

/**
 * @author tialim
 * @author Ashish
 */
public class BlackBomb extends Entity {
	private Date addedDate;
	private boolean hasExploded;

	enum STATE {
		INACTIVE, // INACTIVE when bomb's timer hasnt yet started
		ACTIVE, // Active when bomb's timer has started and it will explode soon
		EXPLODING, // when bomb is exploding
		DEAD; // when the bomb has already exploded
	}

	public BlackBomb(double x, double y) {
		super(Tiling.snapTile(x), Tiling.snapTile(y));
		hasExploded = false;
		addedDate = new Date();
	}

	public void update(Sandbox sb) {
		if (!hasExploded && timeToExplode()) {
			hasExploded = true;
			explode(sb);
		}
	}

	public boolean isPersistant() {
		return !hasExploded;
	}
	
	private boolean timeToExplode() {
		long timePast = new Date().getTime() - addedDate.getTime();
		return timePast > GlobalConstants.BOMB_EXPLODING_TIME;
	}

	private void explode(Sandbox sb) {
		for (Direction direction: Direction.values()) {
			ExplosionChain.addExplosionChain(positionX, positionY, direction, sb);
		}
	}

	protected void setAnimations(Entity e) {
		animations = new SingleSpriteAnimations(e, SpriteSpecification.BOMB);
	}

	protected String setName() {
		return "Bomb  " + ID;
	}

	protected void setED() {
		ed = EntityDimensions.BOMBD;
	}

	protected void setCollidableType() {
		collidableType = CollidableType.PENETRABLE;
	}

}
