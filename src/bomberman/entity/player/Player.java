package bomberman.entity.player;

import bomberman.GameLoop;
import bomberman.Renderer;
import bomberman.animations.PlayerAnimations;
import bomberman.animations.Sprite;
import bomberman.constants.Direction;
import bomberman.constants.GlobalConstants;
import bomberman.entity.Entity;
import bomberman.entity.KillableEntity;
import bomberman.entity.MovingEntity;
import bomberman.entity.boundedbox.RectBoundedBox;
import bomberman.scenes.Sandbox;

public class Player implements MovingEntity, KillableEntity {

    private int health;
    private boolean isAlive;
    RectBoundedBox playerBoundary;

    Sprite currentSprite;
    PlayerAnimations playerAnimations;

    Direction currentDirection;

    public int positionX = 0;
    public int positionY = 0;
    int layer;
    String name;
    double scale = 1;
    double reduceBoundarySizePercent=0.45;
    public int bombCount = 1;

    public Player() {
        init(64, 64);
    }

    public Player(int posX, int posY) {
        init(posX, posY);
        health = 100;
        isAlive = true;
        layer=0;
    }

    private void init(int x, int y) {
        name = "Player";

        playerAnimations = new PlayerAnimations(this,2);
        setScale(2);
        positionX = x;
        positionY = y;

        playerBoundary = new RectBoundedBox(positionX+(int)(GlobalConstants.PLAYER_WIDTH*getReduceBoundarySizePercent()),
                                            positionY+(int)(GlobalConstants.PLAYER_WIDTH*getReduceBoundarySizePercent()),
                                            (int)(GlobalConstants.PLAYER_WIDTH * getScale())-2*+(int)(GlobalConstants.PLAYER_WIDTH*getReduceBoundarySizePercent()),
                                            (int)(GlobalConstants.PLAYER_HEIGHT * getScale())-2*+(int)(GlobalConstants.PLAYER_HEIGHT*getReduceBoundarySizePercent())
                                            );

        currentSprite = playerAnimations.getPlayerIdleSprite();
    }

    public void move(Direction direction) {
        move(1, direction);
    }

    private void setCurrentSprite(Sprite s) {
        if (s != null) {
            currentSprite = s;
        } else {
            System.out.println("Sprite missing!");
        }
    }

    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public String toString() {
        return name;
    }

    @Override
    public boolean isColliding(Entity b) {
       // playerBoundary.setPosition(positionX, positionY);
        RectBoundedBox otherEntityBoundary = (RectBoundedBox) b.getBoundingBox();
        return playerBoundary.checkCollision(otherEntityBoundary);
    }

    @Override
    public void draw() {
        if (currentSprite != null) {
            Renderer.playAnimation(currentSprite);
        }
    }

    @Override
    public void die() {
        setCurrentSprite(playerAnimations.getPlayerDying());
    }

    private boolean checkCollisions(int x, int y) {
    	playerBoundary.setPosition(x, y,getReduceBoundarySizePercent());

        for (Entity e : Sandbox.getEntities()) {
            if (e != this && isColliding(e) && !e.isPlayerCollisionFriendly()) {
            	playerBoundary.setPosition(positionX, positionY,getReduceBoundarySizePercent());
                /*
                System.out.println("Player x="+getPositionX()+" y="
                        +getPositionY()+" colliding with x="+e.getPositionX()
                        +" y="+e.getPositionY());
                */
                return true;
            }
        }
    	playerBoundary.setPosition(positionX, positionY,getReduceBoundarySizePercent());
        return false;
    }

    @Override
    public void move(int steps, Direction direction) {

        //if(steps!=0){System.out.println("Steps before="+steps+" now="+steps * GameLoop.getDeltaTime());}
        //steps *= GameLoop.getDeltaTime();

        if (steps == 0) {
            setCurrentSprite(playerAnimations.getPlayerIdleSprite());
            return;
        } else {
            switch (direction) {
                case UP:
                	if(!checkCollisions(positionX, positionY - steps)) {
	                    positionY -= steps;
	                    setCurrentSprite(playerAnimations.getMoveUpSprite());
	                    currentDirection = Direction.UP;
                	}
                    break;
                case DOWN:
                	if(!checkCollisions(positionX, positionY + steps)) {
                		positionY += steps;
	                    setCurrentSprite(playerAnimations.getMoveDownSprite());
	                    currentDirection = Direction.DOWN;
                	}
                    break;
                case LEFT:
                	if(!checkCollisions(positionX - steps, positionY)) {
                		positionX -= steps;
	                    setCurrentSprite(playerAnimations.getMoveLeftSprite());
	                    currentDirection = Direction.LEFT;
                	}
                    break;
                case RIGHT:
                	if(!checkCollisions(positionX + steps, positionY)) {
                		 positionX += steps;
	                    setCurrentSprite(playerAnimations.getMoveRightSprite());
	                    currentDirection = Direction.RIGHT;
                	}
                    break;
                default:
                    setCurrentSprite(playerAnimations.getPlayerIdleSprite());
            }
        }
    }

    @Override
    public void reduceHealth(int damage) {
        if (health - damage <= 0) {
            die();
        } else {
            health -= damage;
        }
    }

    @Override
    public void removeFromScene() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getPositionX() {
        return positionX;
    }

    @Override
    public int getPositionY() {
        return positionY;
    }

    @Override
    public RectBoundedBox getBoundingBox() {
        playerBoundary.setPosition(positionX, positionY,getReduceBoundarySizePercent());
        return playerBoundary;
    }

    @Override
    public boolean isPlayerCollisionFriendly() {
        return true;
    }

    @Override
    public int getLayer() { return layer; }

    public double getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public double getReduceBoundarySizePercent() {
        return reduceBoundarySizePercent;
    }

    public void setReduceBoundarySizePercent(double reduceBoundarySizePercent) {
        this.reduceBoundarySizePercent = reduceBoundarySizePercent;
    }

    public boolean hasMoreBombs() {
        return bombCount>0;
    }

    public void incrementBombCount(){
        ++bombCount;
    }

    public void decrementBombCount(){
        --bombCount;
    }
}
