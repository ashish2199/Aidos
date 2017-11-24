package bomberman.entity.player;

import bomberman.Renderer;
import bomberman.constants.Direction;
import bomberman.animations.PlayerAnimations;
import bomberman.animations.Sprite;
import bomberman.constants.GlobalConstants;
import bomberman.entity.Entity;
import bomberman.entity.KillableEntity;
import bomberman.entity.MovingEntity;
import bomberman.entity.boundedbox.RectBoundedBox;


public class Player implements MovingEntity, KillableEntity {

    private int health;
    private boolean isAlive;
    RectBoundedBox playerBoundary;

    Sprite currentSprite;
    PlayerAnimations playerAnimations;

    Direction currentDirection;

    public int positionX = 0;
    public int positionY = 0;

    String name;

    public Player() {
        init(0,0);
    }

    public Player(int posX, int posY) {
        init(posX, posY);
        health = 100;
        isAlive = true;
    }

    private void init(int x,int y) {
        name = "Player";
        playerBoundary = new RectBoundedBox(positionX, positionY, GlobalConstants.PLAYER_WIDTH, GlobalConstants.PLAYER_HEIGHT);

        playerAnimations = new PlayerAnimations(this);

        positionX = x;
        positionY = y;

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
        RectBoundedBox otherEntityBoundary = (RectBoundedBox) b;
        return playerBoundary.checkCollision(otherEntityBoundary);
    }

    @Override
    public void draw() {
        if (currentSprite != null) {
            Renderer.playAnimation(currentSprite);
        }
    }

    @Override
    public void move(int steps, Direction direction) {
        if (steps == 0) {
            setCurrentSprite(playerAnimations.getPlayerIdleSprite());
            return;
        } else {
            switch (direction) {
                case UP:
                    positionY -= steps;
                    setCurrentSprite(playerAnimations.getMoveUpSprite());
                    currentDirection = Direction.UP;
                    break;
                case DOWN:
                    setCurrentSprite(playerAnimations.getMoveDownSprite());
                    currentDirection = Direction.DOWN;
                    positionY += steps;
                    break;
                case LEFT:
                    setCurrentSprite(playerAnimations.getMoveLeftSprite());
                    currentDirection = Direction.LEFT;
                    positionX -= steps;
                    break;
                case RIGHT:
                    setCurrentSprite(playerAnimations.getMoveRightSprite());
                    currentDirection = Direction.RIGHT;
                    positionX += steps;
                    break;
                default:
                    setCurrentSprite(playerAnimations.getPlayerIdleSprite());
            }
        }
    }

    @Override
    public void die() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        return this.positionX;
    }

    @Override
    public int getPositionY() {
        return this.positionY;
    }
}
