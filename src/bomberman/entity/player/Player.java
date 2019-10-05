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
import bomberman.geometry.Boundary;
import bomberman.scenes.Sandbox;

public class Player implements MovingEntity, KillableEntity {

    private int health;
    private boolean isAlive;
    Boundary boundary;

    Sprite currentSprite;
    PlayerAnimations playerAnimations;

    Direction currentDirection;
    String name;

    public Player() {
        init(64, 64);
    }

    public Player(int posX, int posY) {
        init(posX, posY);
        health = 100;
        isAlive = true;
    }

    private void init(int x, int y) {
        name = "Player";
        playerAnimations = new PlayerAnimations(this);
        boundary = new Boundary(x, y, GlobalConstants.PLAYER_WIDTH, GlobalConstants.PLAYER_HEIGHT);
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
        return boundary.intersects(b.getBoundary());
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

    private boolean checkCollisions(double x, double y) {
        Boundary collision = boundary.getMin(x, y);

        for (Entity e : Sandbox.getEntities()) {
            if (e != this && !e.isPlayerCollisionFriendly() &&
                collision.intersects(e.getBoundary())) {
                return true;
            }
        }

        boundary.setMin(x, y);
        return false;
    }

    @Override
    public void move(double steps, Direction direction) {

        steps *= GameLoop.getDeltaTime();

        if (steps == 0) {
            setCurrentSprite(playerAnimations.getPlayerIdleSprite());
            return;
        } else {
            switch (direction) {
                case UP:
                	if(!checkCollisions(boundary.getMinX(), boundary.getMinY() - steps)) {
	                    setCurrentSprite(playerAnimations.getMoveUpSprite());
	                    currentDirection = Direction.UP;
                	}
                    break;
                case DOWN:
                	if(!checkCollisions(boundary.getMinX(), boundary.getMinY() + steps)) {
	                    setCurrentSprite(playerAnimations.getMoveDownSprite());
	                    currentDirection = Direction.DOWN;
                	}
                    break;
                case LEFT:
                	if(!checkCollisions(boundary.getMinX() - steps, boundary.getMinY())) {
	                    setCurrentSprite(playerAnimations.getMoveLeftSprite());
	                    currentDirection = Direction.LEFT;
                	}
                    break;
                case RIGHT:
                	if(!checkCollisions(boundary.getMinX() + steps, boundary.getMinY())) {
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
    public double getPositionX() {
        return boundary.getMinX();
    }

    @Override
    public double getPositionY() {
        return boundary.getMinY();
    }

    @Override
    public Boundary getBoundary() {
        return boundary;
    }

    @Override
    public boolean isPlayerCollisionFriendly() {
        return true;
    }
}
