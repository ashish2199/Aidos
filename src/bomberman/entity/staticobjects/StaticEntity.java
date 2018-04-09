/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.entity.staticobjects;

import bomberman.Sandbox;
import bomberman.entity.Entity;

/**
 *
 * @author kdost
 */
public abstract class StaticEntity extends Entity {
	protected StaticEntity(int x, int y) {
		super(x, y);
	}
	
	public boolean isPersistant() {
		// assuming that static entity defaults to alive
		return true;
	}
	
	public void update(Sandbox sb) {};

}
