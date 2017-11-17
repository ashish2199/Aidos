package bomberman.utils;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Animator
{
	   static Image img;

    public static void init() {
        img = ImageUtils.loadImage("src/Resources/img/sprites.png");
    }

    // "ActualSize" refers to how many pixels across to look for the next sprite

    public static void playAnimation(GraphicsContext gc, double time, Sprite sprite) {
    	playAnimation(gc, time, sprite.actualSize, sprite.spriteLocationOnSheetX, sprite.spriteLocationOnSheetY, sprite.numberOfFrames, sprite.x, sprite.y, sprite.width, sprite.height, sprite.scale, sprite.leftToRight);
    }

    public static void playAnimation(GraphicsContext gc, double time, int actualSize, int startingPointX, int startingPointY, int numberOfFrames, int x, int y, int width, int height, boolean leftToRight) {
    	playAnimation(gc, time, actualSize, startingPointX, startingPointY, numberOfFrames, x, y, width, actualSize, 1, leftToRight);
    }

    public static void playAnimation(GraphicsContext gc, double time, int actualSize, int startingPointX, int startingPointY, int numberOfFrames, int x, int y, int width, int height, double scale, boolean leftToRight) {
    	double duration = 0.3;
    	int index = (int)(time % (numberOfFrames * duration) / duration);

    	System.out.println("Index: " + index);
    	System.out.println("XY: " + startingPointX + ", " + startingPointY + index * actualSize);
    	System.out.println("Actual Size: " + actualSize);
    	System.out.println("W / H: " + width + " / " + height);

		int newX = leftToRight ? startingPointX + index * actualSize : startingPointX;
		int newY = leftToRight ? startingPointY : startingPointY + index * actualSize;

		gc.drawImage(img, newX, newY, width, height, x, y, width * scale, height * scale);
    }
}
