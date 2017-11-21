package bomberman.animations;

import bomberman.utils.ImageUtils;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class Sprite
{
	/**
	 *
	 * @author CoreyHendrey
	 */
	public double playSpeed;
	public int spriteLocationOnSheetX;
	public int spriteLocationOnSheetY;
	public int numberOfFrames;
	public int width;
	public int height;
	public int scale;
	public int actualSize;
	public boolean resersePlay;
        
        public Image[] spriteImages;
        public boolean hasValidSpriteImages;
        
	public Sprite(int actualSize, double playSpeed, int spriteLocationOnSheetX, int spriteLocationOnSheetY, int numberOfFrames, int width, int height,
			int scale, boolean leftToRight)
	{
		super();
		this.actualSize = actualSize;
		this.playSpeed = playSpeed;
		this.spriteLocationOnSheetX = spriteLocationOnSheetX;
		this.spriteLocationOnSheetY = spriteLocationOnSheetY;
		this.numberOfFrames = numberOfFrames;
		this.width = width;
		this.height = height;
		this.scale = scale;
		this.resersePlay = leftToRight;
	}
        
        public Sprite(Image spriteSheet,Rectangle[] specifications){
            spriteImages=new Image[specifications.length];
            for (int i = 0; i < specifications.length; i++) {
                Rectangle specification = specifications[i];
                int x=(int)specification.getX();
                int y=(int)specification.getY();
                int w=(int)specification.getWidth();
                int h=(int)specification.getHeight();
                
                //To DO Check dimensions provided are not going out of spritesheet dimensions\
                
                spriteImages[i]=ImageUtils.crop(spriteSheet, x, y, w, h);
            }
            hasValidSpriteImages=true;
        }
}
