package bomberman.animations;

import bomberman.entity.Entity;
import bomberman.utils.ImageUtils;
import java.util.List;
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
	public double width;
	public double height;
	private double scale;
	public int actualSize;
	public boolean resersePlay;
	public Image[] spriteImages;
	public boolean hasValidSpriteImages;
	public Entity entityReference;

	public Sprite(Entity e, int actualSize, double playSpeed, int spriteLocationOnSheetX, int spriteLocationOnSheetY, int numberOfFrames, double width, double height,
				  double scale, boolean leftToRight)
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
		resersePlay = leftToRight;
        this.entityReference=e;
	}

	public int getXPosition() {
		return entityReference.getPositionX();
	}

	public int getYPosition() {
		return entityReference.getPositionY();
	}


    public Sprite(Entity e,int actualSize,double playSpeed,Image spriteSheet,List<Rectangle> specifications,double width, double height,double scale, boolean leftToRight){
        super();
        this.actualSize = actualSize;
        this.playSpeed = playSpeed;
        this.numberOfFrames=specifications.size();
        this.width = width;
        this.height = height;
        this.scale = scale;
        resersePlay = leftToRight;
        this.entityReference=e;
        hasValidSpriteImages=true;
        spriteImages=new Image[specifications.size()];
        for (int i = 0; i < specifications.size(); i++) {
            Rectangle specification = specifications.get(i);
            int x=(int)specification.getX();
            int y=(int)specification.getY();
            int w=(int)specification.getWidth();
            int h=(int)specification.getHeight();

            //To DO Check dimensions provided are not going out of spritesheet dimensions\
            spriteImages[i]=ImageUtils.crop(spriteSheet, x, y, w, h);
        }
    }

	public Entity getEntityReference() {
		return entityReference;
	}

	public void setEntityReference(Entity entityReference) {
		this.entityReference = entityReference;
	}

	public double getScale() {
		return scale;
	}

	public void setScale(double scale) {
		this.scale = scale;
	}

}
