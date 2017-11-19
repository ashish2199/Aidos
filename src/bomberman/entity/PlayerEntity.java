package bomberman.entity;

import bomberman.constants.GlobalConstants;
import bomberman.animations.Sprite;

public class PlayerEntity extends CharacterEntity {

    public PlayerEntity() {
        init();
    }

    private void init() {
        x = GlobalConstants.playerX;
        y = GlobalConstants.playerY;

        Sprite moveDown = new Sprite(30, 0.1, 0, 0, 3, x, y, GlobalConstants.playerWidth, GlobalConstants.playerHeight, 2, false);
        Sprite moveLeft = new Sprite(30, 0.1, 30, 0, 3, x, y, GlobalConstants.playerWidth, GlobalConstants.playerHeight, 2, false);
        Sprite moveUp = new Sprite(30, 0.1, 60, 0, 3, x, y, GlobalConstants.playerWidth, GlobalConstants.playerHeight, 2, false);
        Sprite moveRight = new Sprite(30, 0.1, 90, 0, 3, x, y, GlobalConstants.playerWidth, GlobalConstants.playerHeight, 2, false);

        setMoveSprites(moveUp, moveDown, moveLeft, moveRight);

        currentSprite = moveDown;
    }
}
