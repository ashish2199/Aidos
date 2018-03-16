package bomberman.animations.sprites;

import bomberman.entity.Entity;
import javafx.scene.image.Image;

public class Sprite {
	/**
	 *
	 * @author CoreyHendrey
	 */

	public Entity entityReference;
	SpriteSpecification specs;

	public Sprite(Entity e, SpriteSpecification ss) {
		entityReference = e;
		specs = ss;
	}

	public int getXPosition() {
		return entityReference.getPositionX();
	}

	public int getYPosition() {
		return entityReference.getPositionY();
	}

	public Image[] getSpriteImages() {
		return specs.getSpriteImages();
	}

	public double getPlaySpeed() {
		return specs.getPlaySpeed();
	}

	public int getX() {
		return specs.getX();
	}

	public int getY() {
		return specs.getY();
	}

	public int getFrames() {
		return specs.getFrames();
	}

	public double getWidth() {
		return specs.getWidth();
	}

	public double getHeight() {
		return specs.getHeight();
	}

	public int getScale() {
		return specs.getScale();
	}

	public int getSize() {
		return specs.getSize();
	}
	
	public boolean getReversePlay() {
		return specs.getReversePlay();
	}
	
	public boolean hasValidImage() {
		return specs.hasValidImage();
	}
	
	public boolean loopPlay() {
		return specs.loopPlay();
	}
}
