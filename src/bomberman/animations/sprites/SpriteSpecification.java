package bomberman.animations.sprites;

import java.util.ArrayList;
import java.util.List;

import bomberman.Renderer;
import bomberman.constants.GlobalConstants;
import bomberman.utils.ImageUtils;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public enum SpriteSpecification {

	PLAYERDOWN(30, 0.1, 0, 0, 3, GlobalConstants.PLAYER_WIDTH, GlobalConstants.PLAYER_HEIGHT, 2, false), 
	PLAYERLEFT(30, 0.1, 30, 0, 3, GlobalConstants.PLAYER_WIDTH, GlobalConstants.PLAYER_HEIGHT, 2, false), 
	PLAYERUP(30, 0.1, 60, 0, 3, GlobalConstants.PLAYER_WIDTH - 1.5, GlobalConstants.PLAYER_HEIGHT, 2, false), 
	PLAYERIDLE(30,0.1, 118, 0, 1, GlobalConstants.PLAYER_WIDTH + 2, GlobalConstants.PLAYER_HEIGHT, 2, false), 
	PLAYERRIGHT(30, 0.1, 90, 0, 3, GlobalConstants.PLAYER_WIDTH,GlobalConstants.PLAYER_HEIGHT, 2, false), 
	PLAYERDIE(30, 0.3, getDieSpecs(), GlobalConstants.PLAYER_WIDTH + 2, GlobalConstants.PLAYER_HEIGHT + 2, 2, false, false), 
	WALL(16, 0, 348, 123, 1, 16, 16, 2, false), 
	BOMB(30, 0.3, getBombSpecs(), GlobalConstants.PLAYER_WIDTH + 2, GlobalConstants.PLAYER_HEIGHT + 2, 2, false);

	private double playSpeed;
	private int spriteLocationOnSheetX;
	private int spriteLocationOnSheetY;
	private int numberOfFrames;
	private double width;
	private double height;
	private int scale;
	private int actualSize;
	private boolean leftToRight;
	private Image[] spriteImages;
	private boolean hasValidSpriteImages;
	private boolean loopPlay;

	SpriteSpecification(int actualSize, double playSpeed, int spriteLocationOnSheetX, int spriteLocationOnSheetY,
			int numberOfFrames, double width, double height, int scale, boolean leftToRight, boolean loopPlay) {
		spriteInit(actualSize, playSpeed, width, height, scale, leftToRight, numberOfFrames);
		this.spriteLocationOnSheetX = spriteLocationOnSheetX;
		this.spriteLocationOnSheetY = spriteLocationOnSheetY;
		this.loopPlay = loopPlay;
	}
	

	SpriteSpecification(int actualSize, double playSpeed, List<Rectangle> specifications, double width, double height,
			int scale, boolean leftToRight, boolean loopPlay) {
		spriteInit(actualSize, playSpeed, width, height, scale, leftToRight, specifications.size());
		final Image spriteSheet = Renderer.getSpiteSheet();
		hasValidSpriteImages = true;
		spriteImages = new Image[specifications.size()];
		this.loopPlay = loopPlay;
		for (int i = 0; i < specifications.size(); i++) {
			Rectangle specification = specifications.get(i);
			int x = (int) specification.getX();
			int y = (int) specification.getY();
			int w = (int) specification.getWidth();
			int h = (int) specification.getHeight();
			spriteImages[i] = ImageUtils.crop(spriteSheet, x, y, w, h);
		}
	}
	
	SpriteSpecification(int actualSize, double playSpeed, List<Rectangle> specifications, double width, double height,
			int scale, boolean leftToRight) {
		this(actualSize, playSpeed, specifications, width, height, scale, leftToRight, true);
	}
	
	SpriteSpecification(int actualSize, double playSpeed, int spriteLocationOnSheetX, int spriteLocationOnSheetY,
			int numberOfFrames, double width, double height, int scale, boolean leftToRight) {
		this(actualSize, playSpeed, spriteLocationOnSheetX, spriteLocationOnSheetY, numberOfFrames, width, height, scale, leftToRight, true);
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

	public int getFrames() {
		return numberOfFrames;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public int getScale() {
		return scale;
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

	private void spriteInit(int actualSize, double playSpeed, double width, double height, int scale,
			boolean leftToRight, int numberOfFrames) {
		this.actualSize = actualSize;
		this.playSpeed = playSpeed;
		this.width = width;
		this.height = height;
		this.scale = scale;
		this.leftToRight = leftToRight;
		this.numberOfFrames = numberOfFrames;
	}

	private static List<Rectangle> getBombSpecs() {
		List<Rectangle> specs = new ArrayList<>();
		specs.add(new Rectangle(181, 93, 17, 16));
		specs.add(new Rectangle(211, 93, 16, 16));
		specs.add(new Rectangle(240, 93, 18, 17));
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

}
