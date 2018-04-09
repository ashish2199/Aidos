/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.entity.bomb;

import bomberman.Sandbox;
import bomberman.animations.SingleSpriteAnimations;
import bomberman.animations.sprites.SpriteSpecification;
import bomberman.constants.Direction;
import bomberman.constants.EntityDimensions;
import bomberman.constants.GlobalConstants;
import bomberman.entity.Entity;
import bomberman.entity.boundedbox.CollidableType;
import bomberman.utils.Tiling;

import java.util.Date;

/**
 *
 * @author Ashish
 */
public class BlackBomb extends Entity {
	private Date addedDate;
	private final int timerDurationInMillis = 2000;
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
		if (!hasExploded && isExploding()) {
			hasExploded = true;
			explode(sb);
		}
	}

	public boolean isPersistant() {
		return !hasExploded;
	}

	public boolean isExploding() {
		return checkBombState() == STATE.EXPLODING;
	}

	private STATE checkBombState() {
		long timePast = new Date().getTime() - (timerDurationInMillis + addedDate.getTime());
		STATE s;
		if (timePast < 0) {
			s = STATE.ACTIVE;
		} else if (timePast < GlobalConstants.BOMB_EXPLODING_TIME) {
			s = STATE.EXPLODING;
		} else {
			s = STATE.DEAD;
		}
		return s;
	}

	private void explode(Sandbox sb) {
		for (Direction d: Direction.values()) {
			ExplosionChain.addExplosionChain(positionX, positionY, d, sb);
		}
	}

	protected void setAnimations(Entity e) {
		animations = new SingleSpriteAnimations(e, SpriteSpecification.BOMB);
	}

	protected String setName() {
		return "Bomb  " + ID;
	}

	@Override
	protected EntityDimensions setED() {
		return EntityDimensions.BOMBD;
//		return EntityDimensions.EXPLOSIOND;
	}

	protected void setCollidableType() {
		collidableType = CollidableType.PENETRABLE;
	}

}
