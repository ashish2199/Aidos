/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.entity;

/**
 *
 * @author kdost
 */
public abstract class KillableEntity extends MovingEntity {

	private int health;
	private boolean isAlive;

	protected KillableEntity(int x, int y) {
		super(x, y);
		health = getHealth();
		isAlive = true;
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

	public abstract void die();
	public abstract int setHealth();

}
