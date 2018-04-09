/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.entity.tile;

import bomberman.constants.EntityDimensions;
import bomberman.entity.Entity;
import bomberman.entity.StaticEntity;
import bomberman.entity.configurations.animations.SingleSpriteAnimations;
import bomberman.entity.configurations.animations.sprites.SpriteSpecification;
import bomberman.entity.configurations.boundedbox.CollidableType;
import bomberman.entity.configurations.boundedbox.RectBoundedBox;
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
