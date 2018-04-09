/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.entity;

import bomberman.GameLoop;
import bomberman.constants.GlobalConstants;
import bomberman.entity.configurations.animations.KillableEntityAnimations;
import bomberman.entity.configurations.animations.sprites.Sprite;

/**
 * @author tialim
 * @author kdost
 */
public abstract class KillableEntity extends Entity {

	private int health;
	protected boolean dead;
	protected double timeDying; // TODO implement so that removed after timeDying is 0
	// TODO find a way to combine dead and isAlive

	protected KillableEntity(int x, int y) {
		super(x, y);
		health = getHealth();
		dead = false;
	}

	public void reduceHealth(int damage) {
		if (health - damage <= 0) {
			die();
		} else {
			health -= damage;
		}
	}

	public int getHealth() {
		return health;
	}

	public boolean isPersistant() {
		if (dead) {
			return (GameLoop.getCurrentGameTime() - timeDying < GlobalConstants.PERSISTANCE_TIME);
		}
		return true;
	} 

	protected void setCurrentSprite(Sprite s) {
		if (!dead && s != null) {
			sprite = s;
		} else if (s == null) {
			System.out.println("Sprite missing!");
		}
	}
	
	public void die() {
		setCurrentSprite(((KillableEntityAnimations) animations).getDyingSprite());
		dead = true;
		timeDying = GameLoop.getCurrentGameTime();
	}

	public abstract int setHealth();

}
