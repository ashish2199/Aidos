package bomberman.entity.configurations.animations.sprites;

import bomberman.constants.EntityDimensions;
import bomberman.entity.Entity;
import javafx.scene.image.Image;

public class Sprite {
	/**
	 * Holds the specific collection of cropped images and necessary dimensions used
	 * by the Renderer to animate each entity
	 * @author CoreyHendrey
	 * @author tialim
	 */

	private Entity entityReference;
	private SpriteSpecification specs;
	private double frameCounterHelper;
	private int frameCounter; //

	public Sprite(Entity e, SpriteSpecification ss) {
		entityReference = e;
		specs = ss;
		frameCounterHelper = 0;
		frameCounter = 0;	// an index pointing to the specific frame that should be played at any time
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

	public int getX() {
		return specs.getX();
	}

	public int getY() {
		return specs.getY();
	}

	public int getFrame(double time) {
		int totalFrames = specs.getNoOfFrames();
		double speed = specs.getPlaySpeed();
		return (specs.loopPlay()) ? (int) ((time % (totalFrames * speed)) / speed) : nextFrame();
	}

	public EntityDimensions ED() {
		return specs.ED();
	}

	public int getSize() {
		return specs.getSize();
	}

	public boolean leftToRight() {
		return specs.leftToRight();
	}

	public boolean hasValidImage() {
		return specs.hasValidImage();
	}

	private int nextFrame() {
		// if there is a next frame, return its index, otherwise return the last frame's
		// index
		int maxFrame = specs.getNoOfFrames() - 1;
		frameCounterHelper += specs.getPlaySpeed();
		frameCounter = (int) (frameCounterHelper);
		return (frameCounter <= maxFrame) ? frameCounter : maxFrame;
	}
}
