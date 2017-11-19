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
	 */
    static Image img;

    public static void init() {
        img = ImageUtils.loadImage("src/Resources/img/sprites.png");
    }

    // "ActualSize" refers to how many pixels across to look for the next sprite
    
    public static void playAnimation(Sprite sprite) {
        double time =  Sandbox.getTickDuration();
        GraphicsContext gc = Sandbox.getGraphicsContext();
        playAnimation(gc, time, sprite.actualSize, sprite.spriteLocationOnSheetX, sprite.spriteLocationOnSheetY, sprite.numberOfFrames, sprite.x, sprite.y, sprite.width, sprite.height, sprite.scale, sprite.resersePlay);
    }

    public static void playAnimation(GraphicsContext gc, double time, int actualSize, int startingPointX, int startingPointY, int numberOfFrames, int x, int y, int width, int height, boolean leftToRight) {
    	playAnimation(gc, time, actualSize, startingPointX, startingPointY, numberOfFrames, x, y, width, actualSize, 1, leftToRight);
    }

    public static void playAnimation(GraphicsContext gc, double time, int actualSize, int startingPointX, int startingPointY, int numberOfFrames, int x, int y, int width, int height, double scale, boolean reversePlay) {
    	double duration = 0.3;
    	int index = (int)(time % (numberOfFrames * duration) / duration);

		int newX = reversePlay ? startingPointX + index * actualSize : startingPointX;
		int newY = reversePlay ? startingPointY : startingPointY + index * actualSize;

		gc.drawImage(img, newX, newY, width, height, x, y, width * scale, height * scale);
    }
}
