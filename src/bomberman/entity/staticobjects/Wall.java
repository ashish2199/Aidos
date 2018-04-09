/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.entity.staticobjects;

import bomberman.animations.SingleSpriteAnimations;
import bomberman.animations.sprites.SpriteSpecification;
import bomberman.constants.EntityDimensions;
import bomberman.entity.Entity;
import bomberman.entity.boundedbox.CollidableType;
import bomberman.entity.boundedbox.RectBoundedBox;
import javafx.scene.paint.Color;

/**
 *
 * @author kdost
 */
public class Wall extends StaticEntity {

	// private Color wallColor;
	RectBoundedBox entityBoundary;

	public Wall(int x, int y) {
		super(x, y);
	}

	public void changeColor(Color color) {
		// wallColor = color;
	}

	public boolean isPersistant() {
		return true;
	}

	protected void setAnimations(Entity e) {
		animations = new SingleSpriteAnimations(e, SpriteSpecification.WALL);
	}

	protected String setName() {
		return "Wall";
	}

	@Override
	protected EntityDimensions setED() {
		return EntityDimensions.WALLD;
	}

	protected void setCollidableType() {
		collidableType = CollidableType.IMPERMEABLE;
	}

}
