/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.entity;

import bomberman.Renderer;
import bomberman.animations.Animations;
import bomberman.animations.Sprite;
import bomberman.entity.boundedbox.RectBoundedBox;

/**
 *
 * @author Ashish
 */
public abstract class Entity {
	protected int positionX;
	protected int positionY;
	private int height;
	private int width;
	protected RectBoundedBox entityBoundary;
	protected Sprite sprite;
	protected Animations animations;
	protected boolean isAlive;
	protected String name;

	protected Entity(int x, int y) {
		positionX = x;
		positionY = y;
		width = entityWidth();
		height = entityHeight();
		setAnimations(this);
		sprite = animations.getSprite();
		entityBoundary = new RectBoundedBox(positionX, positionY, width, height);
		isAlive = true;
		name = setName();
	}

	public boolean isColliding(Entity b) {
		RectBoundedBox otherEntityBoundary = (RectBoundedBox) b.getBoundingBox();
		return entityBoundary.checkCollision(otherEntityBoundary);
	}

	public void draw() {
		if (sprite != null) {
			Renderer.playAnimation(sprite);
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

	public abstract boolean isPlayerCollisionFriendly();

	public abstract void removeFromScene();
	
	public abstract boolean isAlive();

	protected abstract void setAnimations(Entity e);

	protected abstract int entityWidth();

	protected abstract int entityHeight();

	protected abstract String setName();

}
