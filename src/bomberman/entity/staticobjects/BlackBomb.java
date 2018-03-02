/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.entity.staticobjects;

import bomberman.animations.BombAnimations;
import bomberman.entity.Entity;
import bomberman.entity.StaticEntity;
import java.util.Date;

/**
 *
 * @author Ashish
 */
public class BlackBomb extends StaticEntity {
	private final int bombWidth = 16;
	private final int bombHeight = 16;
	private Date addedDate;
	private final int timerDurationInMillis = 2000;
	private final int explodingTime = 100;
	private STATE bombState;
	private static int bombCounter = 0;
	
	enum STATE {
		INACTIVE, // INACTIVE when bomb's timer hasnt yet started
		ACTIVE, // Active when bomb's timer has started and it will explode soon
		EXPLODING, // when bomb is exploding
		DEAD; // when the bomb has already exploded
	}

	public BlackBomb(int x, int y) {
		super(x, y);
		addedDate = new Date();
		bombState = STATE.ACTIVE;
	}

	public boolean isAlive() {
		return checkBombState() != STATE.DEAD;
	}
	
	public boolean isExploding() {
		return checkBombState() == STATE.EXPLODING;
	}

	private STATE checkBombState() {
		long timePast = new Date().getTime() - (timerDurationInMillis + addedDate.getTime());
		STATE s;
		if (timePast < 0) {
			s = STATE.ACTIVE;
		}
		else if (timePast < explodingTime) {
			s = STATE.EXPLODING;
		}
		else {
			s = STATE.DEAD;
		}
		return s;
	}

	@Override
	public boolean isColliding(Entity b) {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}

	@Override
	public void removeFromScene() {
//		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
//																		// Tools | Templates.
	}


	public boolean isPlayerCollisionFriendly() {
		return true;
	}

	protected void setAnimations(Entity e) {
		animations = new BombAnimations(e);
		
	}

	protected int entityWidth() {
		return bombWidth;
	}

	protected int entityHeight() {
		return bombHeight;
	}

	protected String setName() {
		bombCounter++;
		return "Bomb  " + bombCounter;
	}

}
