package bomberman;

import bomberman.entity.configurations.animations.sprites.Sprite;
import bomberman.utils.ImageUtils;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Renderer {

	/**
	 *
	 * @author CoreyHendrey
	 *
	 *         gc is GraphicsContext on which we draw the sprite time is the current
	 *         time duration that we need to sync up to, ie the time duration of the
	 *         tick from the gameloop
	 *
	 *         This works by first finding the top left pixel of the animation that
	 *         is playing, with spriteLocationOnSheet(X/Y). It then figures out
	 *         which from we are up to using findCurrentFrame().
	 *
	 *         It then draws the frame at x, y using the height and width.
	 *
	 *         It uses 'actualSize' to find the next sprite, because of padding on
	 *         the width and height.
	 *
	 */
	static Image img1, img2;
	static {
		img1 = ImageUtils.loadImage("src/Resources/img/sprites_without_border.png");
		img2 = ImageUtils.loadImage("src/Resources/img/sprite2.png");
	}

	public static Image getSpriteSheet(int index) {
		return (index == 1) ? img1: img2;
	}

	public static void playAnimation(Sprite sprite, GraphicsContext gc) {
		double time = GameLoop.getCurrentGameTime();
		playAnimation(sprite, gc, time, sprite.hasValidImage());
	}

	private static void playAnimation(Sprite sprite, GraphicsContext gc, double time, boolean hasValidImage) {
		int index = sprite.getFrame(time);
		Image[] imgs = sprite.getSpriteImages();
		double w = sprite.ED().gameW;
		double h = sprite.ED().gameH;
		if (hasValidImage) {
			gc.drawImage(imgs[index], sprite.getXPosition(), sprite.getYPosition(), w, h);
		} else {
			int newSpriteSheetX = sprite.leftToRight() ? sprite.getX() + index * sprite.getSize() : sprite.getX();
			int newSpriteSheetY = sprite.leftToRight() ? sprite.getY() : sprite.getY() + index * sprite.getSize();
			gc.drawImage(img1, newSpriteSheetX, newSpriteSheetY, sprite.ED().width, sprite.ED().height, sprite.getXPosition(),
					sprite.getYPosition(), w, h);
		}
	}
}
