package bomberman.entity.configurations.animations.sprites;

import java.util.ArrayList;
import java.util.List;

import bomberman.Renderer;
import bomberman.constants.EntityDimensions;

import static bomberman.constants.EntityDimensions.*;
import bomberman.utils.ImageUtils;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

/**
 * Caches the specific parameters for each sprite for easier retrieval by the Sprite class
 * @author tialim
 */


public enum SpriteSpecification {
	// TODO make playSpeed global final constants
	
	//PLAYER animations
	PLAYERDOWN(30, 0.1, 0, 0, 3, false, true, PLAYERDOWND), 
	PLAYERLEFT(30, 0.1, 30, 0, 3, false, true,PLAYERLEFTD), 
	PLAYERUP(30, 0.1, 60, 0, 3, false, true, PLAYERUPD), 
	PLAYERIDLE(30, 0.1, 118, 0, 1, false, true, PLAYERIDLED), 
	PLAYERRIGHT(30, 0.1, 90, 0, 3, false, true, PLAYERRIGHTD), 
	PLAYERDIE(0.25, getDieSpecs(), false, PLAYERDIED, 1), 
	
	//ENEMIES
	BALLOOM(30, 0.2, 0, 123, 4, true, true, BALLOMD), 
	BALLOOMDIE(30, 0.2, 30, 153, 6, true, false, BALLOMD), 
	DORIA(0.2, getDoriaSpecs(), true, DORIAD, 1),
	DORIADIE(0.1, getDoriaDieSpecs(), false, DORIAD, 1),
	BEAR(0.2, getBearSpecs(), true, DORIAD, 2),
	BEARDIE(0.1, getBearDieSpecs(), false, DORIAD, 2),
	
	// MISC ENTITY animations
	WALL(16, 0, 348, 123, 1, false, true, TILED), 
	BOMB(0.3, getBombSpecs(), true, BOMBD, 2), 
	EXPLOSION(0.3, getExplosionSpecs(), false, EXPLOSIOND, 2), 
	BRICKWALL(0, getBrickWallSpecs(), false, TILED, 2);

	private double playSpeed;	// the rate at which the frames changes 
	private int spriteLocationOnSheetX, spriteLocationOnSheetY, numberOfFrames, actualSize;
	/*
	 * leftToRight is true if the sprite crops are laid out horizontally on the sprite image file, 
	 * loopPlay is true if the animation continuously loops through the frames instead of terminate
	 */
	private boolean leftToRight, hasValidSpriteImages, loopPlay;	
	private EntityDimensions ed;
	private Image[] spriteImages;	// Array that holds the all the frames belonging to the sprite

	SpriteSpecification(int actualSize, double playSpeed, int spriteLocationOnSheetX, int spriteLocationOnSheetY,
			int numberOfFrames, boolean leftToRight, boolean loopPlay, EntityDimensions ed) {
		spriteInit(actualSize, playSpeed, leftToRight, numberOfFrames, ed, loopPlay);
		this.spriteLocationOnSheetX = spriteLocationOnSheetX;
		this.spriteLocationOnSheetY = spriteLocationOnSheetY;
	}

	SpriteSpecification(double playSpeed, List<Rectangle> specifications, boolean loopPlay, EntityDimensions ed,
			int imageIndex) {
		spriteInit(0, playSpeed, false, specifications.size(), ed, loopPlay);
		Image spriteSheet = Renderer.getSpriteSheet(imageIndex);
		hasValidSpriteImages = true;
		spriteImages = new Image[specifications.size()];
		for (int i = 0; i < specifications.size(); i++) {
			Rectangle specification = specifications.get(i);
			int x = (int) specification.getX();
			int y = (int) specification.getY();
			int w = (int) specification.getWidth();
			int h = (int) specification.getHeight();
			spriteImages[i] = ImageUtils.crop(spriteSheet, x, y, w, h);
		}
	}

	public Image[] getSpriteImages() {
		return spriteImages;
	}

	public double getPlaySpeed() {
		return playSpeed;
	}

	public int getX() {
		return spriteLocationOnSheetX;
	}

	public int getY() {
		return spriteLocationOnSheetY;
	}

	public int getNoOfFrames() {
		return numberOfFrames;
	}

	public EntityDimensions ED() {
		return ed;
	}

	public int getSize() {
		return actualSize;
	}

	public boolean leftToRight() {
		return leftToRight;
	}

	public boolean hasValidImage() {
		return hasValidSpriteImages;
	}

	public boolean loopPlay() {
		return loopPlay;
	}

	private void spriteInit(int actualSize, double playSpeed, boolean leftToRight, int numberOfFrames,
			EntityDimensions ed, boolean loopPlay) {
		this.ed = ed;
		this.actualSize = actualSize;
		this.playSpeed = playSpeed;
		this.leftToRight = leftToRight;
		this.numberOfFrames = numberOfFrames;
		this.loopPlay = loopPlay;
	}

	private static List<Rectangle> getBombSpecs() {
		List<Rectangle> specs = new ArrayList<>();
		specs.add(new Rectangle(140,204, 16, 16));
		specs.add(new Rectangle(164, 204, 16, 16));
		specs.add(new Rectangle(188, 204, 16, 16));
		return specs;
	}

	private static List<Rectangle> getDieSpecs() {
		List<Rectangle> specs = new ArrayList<>();
		specs.add(new Rectangle(149, 0, 20, 21));
		specs.add(new Rectangle(179, 0, 19, 20));
		specs.add(new Rectangle(119, 30, 21, 21));
		specs.add(new Rectangle(149, 30, 20, 21));
		specs.add(new Rectangle(179, 30, 19, 21));
		specs.add(new Rectangle(118, 60, 21, 21));
		specs.add(new Rectangle(147, 60, 23, 22));
		specs.add(new Rectangle(179, 60, 23, 22));
		return specs;
	}

	private static List<Rectangle> getExplosionSpecs() {
		List<Rectangle> specs = new ArrayList<>();
		specs.add(new Rectangle(37, 445, 80, 80));
		specs.add(new Rectangle(127, 445, 80, 80));
		specs.add(new Rectangle(34, 556, 80, 80));
		specs.add(new Rectangle(133, 557, 80, 80));
		specs.add(new Rectangle(34, 556, 80, 80));
		specs.add(new Rectangle(127, 445, 80, 80));
		specs.add(new Rectangle(37, 445, 80, 80));
		return specs;
	}
	
	private static List<Rectangle> getBrickWallSpecs() {
		List<Rectangle> specs = new ArrayList<>();
		specs.add(new Rectangle(78, 205, 16, 16));
		return specs;
	}
	
	private static List<Rectangle> getBearSpecs() {
		List<Rectangle> specs = new ArrayList<>();
		specs.add(new Rectangle(143, 310, 16, 16));
		specs.add(new Rectangle(169, 310, 16, 16));
		specs.add(new Rectangle(195, 310, 16, 16));
		return specs;
	}
	
	private static List<Rectangle> getBearDieSpecs() {
		List<Rectangle> specs = new ArrayList<>();
		specs.add(new Rectangle(221, 311, 16, 16));
		specs.add(new Rectangle(221, 311, 16, 16));
		specs.add(new Rectangle(221, 311, 16, 16));
		return specs;
	}
	
	
	private static List<Rectangle> getDoriaSpecs() {
		List<Rectangle> specs = new ArrayList<>();
		specs.add(new Rectangle(121, 123, 16, 16));
		specs.add(new Rectangle(151, 123, 16, 16));
		specs.add(new Rectangle(181, 123, 16, 16));
		return specs;
	}
	
	private static List<Rectangle> getDoriaDieSpecs() {
		List<Rectangle> specs = new ArrayList<>();
		specs.add(new Rectangle(211, 123, 16, 16));
		specs.add(new Rectangle(241, 123, 16, 16));
		return specs;
	}
}
