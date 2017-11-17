package bomberman.utils;

public class Sprite
{
	double playSpeed;
	int spriteLocationOnSheetX;
	int spriteLocationOnSheetY;
	int numberOfFrames;
	int x;
	int y;
	int width;
	int height;
	int scale;
	int actualSize;
	boolean leftToRight;

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
		this.leftToRight = leftToRight;
	}

	public void setPosition(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}
