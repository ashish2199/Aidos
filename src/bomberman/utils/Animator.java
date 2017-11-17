package bomberman.utils;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Animator
{
	   static Image img;

    public static void init() {
        img = ImageUtils.loadImage("src/Resources/img/sprites.png");
    }

    public static void playAnimation(GraphicsContext gc, double time, int actualSize, int startingPoint, int numberOfFrames, int x, int y, int width, int height, boolean leftToRight) {
    	playAnimation(gc, time, actualSize, startingPoint, numberOfFrames, x, y, width, actualSize, 1, leftToRight);
    }

    public static void playAnimation(GraphicsContext gc, double time, int actualSize, int startingPoint, int numberOfFrames, int x, int y, int width, int height, double scale, boolean leftToRight) {
    	double duration = 0.3;
    	int num = numberOfFrames;
    	int index = (int)(time % (num * duration) / duration);

    	if(leftToRight)
    		gc.drawImage(img, startingPoint + index * actualSize, startingPoint, width, height, x, y, width * scale, height * scale);
    	else
    		gc.drawImage(img, startingPoint, startingPoint + index * actualSize, width, height, x, y, width * scale, height * scale);
    }
}
