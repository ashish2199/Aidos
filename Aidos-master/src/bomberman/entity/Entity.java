/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.entity;

import bomberman.Renderer;
import bomberman.Sandbox;
import bomberman.animations.Animations;
import bomberman.animations.sprites.Sprite;
import bomberman.constants.EntityDimensions;
import bomberman.entity.boundedbox.CollidableType;
import bomberman.entity.boundedbox.RectBoundedBox;

/**
 *
 * @author Ashish
 */
public abstract class Entity {
	protected static int IDGenerator = 0;
	protected int ID;
	protected int positionX;
	protected int positionY;
	protected boolean isPersistant;
	protected EntityDimensions ed;
	protected RectBoundedBox entityBoundary;
	protected Sprite sprite;
	protected Animations animations;
	protected String name;
	protected CollidableType collidableType;

	protected Entity(int x, int y) {
		positionX = x;
		positionY = y;
		ed = setED();
		setAnimations(this);
		sprite = animations.getSprite();
		entityBoundary = new RectBoundedBox(positionX, positionY, (int)ed.gameW, (int)ed.gameH);
		isPersistant = true;
		name = setName();
		ID = IDGenerator++;
		setCollidableType();
	}

	public boolean isColliding(Entity b) {
		RectBoundedBox otherEntityBoundary = (RectBoundedBox) b.getBoundingBox();
		return entityBoundary.checkCollision(otherEntityBoundary);
	}

	public void draw(Sandbox sb) {
		if (sprite != null) {
			Renderer.playAnimation(sprite, sb.getGraphicsContext());
		}
	}

	public int getPositionX() {
		return positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public String toString() {
		String s = "Entity: " + name + "\t Location: " + "(" + positionX + ", " + positionY + ").";
		return s;
	}
	
	public boolean isKillable() {
		return false;
	}
	
	public boolean equals(Entity other) {
		return ID == other.ID;
	}

	protected void setCurrentSprite(Sprite s) {
		if (s != null) {
			sprite = s;
		} else {
			System.out.println("Sprite missing!");
		}
	}
	
	protected RectBoundedBox getBoundingBox() {
		entityBoundary.setPosition(positionX, positionY);
		return entityBoundary;
	}

	public boolean isPlayerCollisionFriendly() {
		return collidableType.isPlayerCollidable();
	}
	
	public boolean isExplodable() {
		return collidableType.isExplodable();
	}
	
	public boolean isImpermeable() {
		return collidableType.isImpermeable();
	}
	
	public abstract boolean isPersistant();

	protected abstract void setAnimations(Entity e);
	
	protected abstract void setCollidableType();
	
	public abstract void update(Sandbox sb);

	protected abstract String setName();
	
	protected abstract EntityDimensions setED();
	

}
