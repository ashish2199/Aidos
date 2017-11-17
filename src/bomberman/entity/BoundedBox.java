package bomberman.entity;

import javafx.geometry.Rectangle2D;

public class BoundedBox
{
	int x;
	int y;
	int width;
	int height;

	 public Rectangle2D getBoundary()
    {
        return new Rectangle2D( x, y, width, height);
    }

	public boolean checkCollision(BoundedBox b)
	{
		return b.getBoundary().intersects(getBoundary());
	}
}
