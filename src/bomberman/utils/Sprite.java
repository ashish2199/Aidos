package bomberman.utils;

public class Sprite
{
	int playSpeed;
	int spriteLocationOnSheet;
	int numberOfFrames;
	int x;
	int y;
	int width;
	int height;
	int scale;
	int actualSize;
	boolean leftToRight;

	public Sprite(int actualSize, int playSpeed, int spriteLocationOnSheet, int numberOfFrames, int x, int y, int width, int height,
			int scale, boolean leftToRight)
	{
		super();
		this.actualSize = actualSize;
		this.playSpeed = playSpeed;
		this.spriteLocationOnSheet = spriteLocationOnSheet;
		this.numberOfFrames = numberOfFrames;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.scale = scale;
		this.leftToRight = leftToRight;
	}
}
