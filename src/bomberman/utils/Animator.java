package bomberman.utils;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Animator
{
	   static Image img;

    public static void init() {
        img = ImageUtils.loadImage("src/Resources/img/sprites.png");
    }

    public static void playAnimation(GraphicsContext gc, double time, int actualHeight, int startingPoint, int numberOfFrames, int x, int y, int width, int height) {
    	double scale = 1;
    	double duration = 0.3;
    	int num = numberOfFrames;
    	int index = (int)(time % (num * duration) / duration);

    	//gc.fillRect(x, y, width * scale, height * scale);
    	gc.drawImage(img, startingPoint, index * actualHeight, width, height, x, y, width * scale, height * scale);
    }

    public static void playAnimation(GraphicsContext gc, double time, int actualHeight, int startingPoint, int numberOfFrames, int x, int y, int width, int height, double scale) {
    	double duration = 0.3;
    	int num = numberOfFrames;
    	int index = (int)(time % (num * duration) / duration);

    	//gc.fillRect(x, y, width * scale, height * scale);
    	gc.drawImage(img, startingPoint, index * actualHeight, width, height, x, y, width * scale, height * scale);
    }
}
