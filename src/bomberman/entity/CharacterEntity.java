package bomberman.entity;

import java.util.Vector;

import bomberman.animations.Direction;
import bomberman.utils.Animator;
import bomberman.utils.Sprite;
import javafx.scene.canvas.GraphicsContext;

public class CharacterEntity
{
	Sprite currentSprite;

	Sprite moveRight;
	Sprite moveLeft;
	Sprite moveUp;
	Sprite moveDown;

	Vector<Sprite> spriteList = new Vector<Sprite>();

	Direction currentDirection;

	int x = 0;
	int y = 0;

	String name;

	public CharacterEntity()
	{
		name = "Unnamed Entity";
	}


	// This might be better eventually as a state machine I imagine.
	// Because this is very quickly growing into a pain in the ass

	public void move(Direction direction)
	{
		switch(direction)
		{
			case UP:
				y--;
				setCurrentSprite(moveUp);
				currentDirection = Direction.UP;
				break;
			case DOWN:
				setCurrentSprite(moveDown);
				currentDirection = Direction.DOWN;
				y++;
				break;
			case LEFT:
				setCurrentSprite(moveLeft);
				currentDirection = Direction.LEFT;
				x--;
				break;
			case RIGHT:
				setCurrentSprite(moveRight);
				currentDirection = Direction.RIGHT;
				x++;
				break;
		}

		recalulatePositionForSprites();
	}

	private void recalulatePositionForSprites()
	{
		for(Sprite s : spriteList)
		{
			if(s != null)
				s.setPosition(x, y);
		}
	}


	private void setCurrentSprite(Sprite s)
	{
		if(s != null)
			currentSprite = s;
		else
			System.out.println("Sprite missing!");
	}

	public void setMoveSprites(Sprite moveUp, Sprite moveDown, Sprite moveLeft, Sprite moveRight)
	{
		if(moveUp != null) this.moveUp = moveUp;
		if(moveDown != null) this.moveDown = moveDown;
		if(moveLeft != null) this.moveLeft = moveLeft;
		if(moveRight != null) this.moveRight = moveRight;

		if(!spriteList.contains(moveUp)) spriteList.add(moveUp);
		if(!spriteList.contains(moveLeft)) spriteList.add(moveLeft);
		if(!spriteList.contains(moveDown)) spriteList.add(moveDown);
		if(!spriteList.contains(moveRight)) spriteList.add(moveRight);
	}

	public void render(GraphicsContext gc, double time)
	{
		if(currentSprite != null)
			Animator.playAnimation(gc, time, currentSprite);
	}

	public String toString() {
		return name;
	}

}
