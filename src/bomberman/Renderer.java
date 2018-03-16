package bomberman;

import bomberman.animations.sprites.Sprite;
import bomberman.scenes.Sandbox;
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
	static Image img;
	static {
		img = ImageUtils.loadImage("src/Resources/img/sprites_without_border.png");
	}

	public static void init() {

	}

	public static Image getSpiteSheet() {
		return img;
	}

	public static void playAnimation(Sprite sprite) {
		double time = GameLoop.getCurrentGameTime();
		GraphicsContext gc = Sandbox.getGraphicsContext();
		playAnimation(sprite, gc, time, sprite.hasValidImage());
	}

	private static void playAnimation(Sprite sprite, GraphicsContext gc, double time, boolean hasValidImage)  {
		int index = findCurrentFrame(time, sprite.getFrames(), sprite.getPlaySpeed());
		Image[] imgs = sprite.getSpriteImages();
		double w = sprite.getWidth() * sprite.getScale();
		double h = sprite.getHeight() * sprite.getScale();
		if (hasValidImage) {
			gc.drawImage(imgs[index], sprite.getXPosition(), sprite.getYPosition(), w, h);
		}
		else {
			int newSpriteSheetX = sprite.getReversePlay() ? sprite.getX() + index * sprite.getSize() : sprite.getX() ;
			int newSpriteSheetY = sprite.getReversePlay() ? sprite.getY()  : sprite.getY()  + index * sprite.getSize();
			gc.drawImage(img, newSpriteSheetX, newSpriteSheetY, sprite.getWidth(), sprite.getHeight(), sprite.getXPosition(), sprite.getYPosition(), w, h);;
		}
	}

	private static int findCurrentFrame(double time, int totalFrames, double speed) {
		return (int) (time % (totalFrames * speed) / speed);
	}
}
