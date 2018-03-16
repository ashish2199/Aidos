/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.entity;

import bomberman.animations.sprites.Sprite;

/**
 *
 * @author kdost
 */
public abstract class KillableEntity extends MovingEntity {

	private int health;
	private boolean isAlive;
	protected boolean dead = false;
	// TODO find a way to combine dead and isAlive

	protected KillableEntity(int x, int y) {
		super(x, y);
		health = getHealth();
		isAlive = true;
		dead = false;
	}

	public void reduceHealth(int damage) {
		if (health - damage <= 0) {
			isAlive = false;
		} else {
			health -= damage;
		}
	}

	public int getHealth() {
		return health;
	}

	public boolean isAlive() {
		return isAlive;
	}

	@Override
	protected void setCurrentSprite(Sprite s) {
		if (!dead && s != null) {
			sprite = s;
		} else if (s == null) {
			System.out.println("Sprite missing!");
		}
	}

	public abstract void die();

	public abstract int setHealth();

}
