package bomberman.animations;

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
	public int x;
	public int y;
	public int width;
	public int height;
	public int scale;
	public int actualSize;
	public boolean resersePlay;

	public Sprite(int actualSize, double playSpeed, int spriteLocationOnSheetX, int spriteLocationOnSheetY, int numberOfFrames, int x, int y, int width, int height,
			int scale, boolean leftToRight)
	{
		super();
		this.actualSize = actualSize;
		this.playSpeed = playSpeed;
		this.spriteLocationOnSheetX = spriteLocationOnSheetX;
		this.spriteLocationOnSheetY = spriteLocationOnSheetY;
		this.numberOfFrames = numberOfFrames;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.scale = scale;
		this.resersePlay = leftToRight;
	}

	public void setPosition(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}
