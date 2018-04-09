/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.entity;

import bomberman.Sandbox;

/**
 * @author tialim
 * @author kdost
 */
public abstract class StaticEntity extends Entity {
	protected StaticEntity(int x, int y) {
		super(x, y);
	}
	
	public boolean isPersistant() {
		// assuming that static entity always remains on the scene
		return true;
	}
	
	public void update(Sandbox sb) {};

}
