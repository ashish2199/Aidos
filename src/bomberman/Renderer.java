package bomberman;

import bomberman.animations.Sprite;
import bomberman.scenes.Sandbox;
import bomberman.utils.ImageUtils;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Renderer
{
	/**
	 *
	 * @author CoreyHendrey
	 *
	 * gc is GraphicsContext on which to draw the sprite
	 * time is the current time to sync up too, ie the time from the gameloop
	 *
	 * This works by first finding the top left pixel of the animation that is playing, with spriteLocationOnSheet(X/Y).
	 * It then figures out which from we are up to using findCurrentFrame().
	 *
	 * It then draws the frame at x, y using the height and width.
	 *
	 * It uses 'actualSize' to find the next sprite, because of padding on the width and height.
	 *
	 */

   static Image img;

    public static void init() {
        img = ImageUtils.loadImage("src/Resources/img/sprites.png");
    }

    public static void playAnimation(Sprite sprite) {
        double time =  GameLoop.getTickDuration();
        GraphicsContext gc = Sandbox.getGraphicsContext();
        playAnimation(gc, time, sprite.actualSize, sprite.spriteLocationOnSheetX, sprite.spriteLocationOnSheetY, sprite.numberOfFrames, sprite.x, sprite.y, sprite.width, sprite.height, sprite.scale, sprite.resersePlay, sprite.playSpeed);
    }

    public static void playAnimation(GraphicsContext gc, double time, int actualSize, int startingPointX, int startingPointY, int numberOfFrames, int x, int y, int width, int height, boolean leftToRight, double playSpeed) {
    	playAnimation(gc, time, actualSize, startingPointX, startingPointY, numberOfFrames, x, y, width, actualSize, 1, leftToRight, playSpeed);
    }

    public static void playAnimation(GraphicsContext gc, double time, int actualSize, int startingPointX, int startingPointY, int numberOfFrames, int x, int y, int width, int height, double scale, boolean reversePlay, double playSpeed) {
    	double speed = playSpeed >= 0 ? playSpeed : 0.3;
    	int index = findCurrentFrame(time, numberOfFrames, speed);

		int newX = reversePlay ? startingPointX + index * actualSize : startingPointX;
		int newY = reversePlay ? startingPointY : startingPointY + index * actualSize;

                System.out.println(index+" "+newX+" "+newY+" "+width+" "+height+" "+x+" "+y+" "+width * scale+" "+height * scale);

		gc.drawImage(img, newX, newY, width, height, x, y, width * scale, height * scale);
    }

    private static int findCurrentFrame(double time, int totalFrames, double speed) {
    	return (int)(time % (totalFrames * speed) / speed);
    }
}
