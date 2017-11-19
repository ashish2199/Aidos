package bomberman.entity;

import java.util.Vector;

import bomberman.animations.Direction;
import bomberman.Renderer;
import bomberman.animations.Sprite;
import javafx.scene.canvas.GraphicsContext;

public class CharacterEntity implements MovingEntity
{
	/**
	 *
	 * @author CoreyHendrey
	 */
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

	public String toString() {
		return name;
	}


	@Override
	public boolean isColliding(Entity b)
	{
		return false;
	}


	@Override
	public void draw()
	{       
		if(currentSprite != null)
			Renderer.playAnimation(currentSprite);
	}

    @Override
    public void removeFromScene() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void move(int steps, Direction direction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void die() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reduceHealth(int damage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getHealth() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
