package bomberman.entity;

import bomberman.animations.Direction;
import bomberman.utils.Sprite;

public class Character
{
	Sprite currentSprite;

	Sprite moveRight;
	Sprite moveLeft;
	Sprite moveUp;
	Sprite moveDown;

	public void move(Direction direction)
	{
		switch(direction)
		{
			case UP:
				setSprite(moveUp);
				break;
			case DOWN:
				setSprite(moveDown);
				break;
			case LEFT:
				setSprite(moveLeft);
				break;
			case RIGHT:
				setSprite(moveRight);
				break;
		}
	}

	private void setSprite(Sprite s) {
		currentSprite = s;
	}

}
