package bomberman.utils;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Animator
{
	   static Image img;

    public static void init() {
        img = ImageUtils.loadImage("src/Resources/img/sprites.png");
    }

    public static void playAnimation(GraphicsContext gc, double time, Sprite sprite) {
    	playAnimation(gc, time, sprite.actualSize, sprite.spriteLocationOnSheet, sprite.numberOfFrames, sprite.x, sprite.y, sprite.width, sprite.actualSize, sprite.scale, sprite.leftToRight);
    }

    public static void playAnimation(GraphicsContext gc, double time, int actualSize, int startingPoint, int numberOfFrames, int x, int y, int width, int height, boolean leftToRight) {
    	playAnimation(gc, time, actualSize, startingPoint, numberOfFrames, x, y, width, actualSize, 1, leftToRight);
    }

    public static void playAnimation(GraphicsContext gc, double time, int actualSize, int startingPoint, int numberOfFrames, int x, int y, int width, int height, double scale, boolean leftToRight) {
    	double duration = 0.3;
    	int index = (int)(time % (numberOfFrames * duration) / duration);

		int newX = leftToRight ? startingPoint + index * actualSize : startingPoint;
		int newY = leftToRight ? startingPoint : startingPoint + index * actualSize;

		gc.drawImage(img, newX, newY, width, height, x, y, width * scale, height * scale);
    }
}
