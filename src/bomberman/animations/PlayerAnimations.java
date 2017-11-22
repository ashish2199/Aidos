/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.animations;

import bomberman.constants.GlobalConstants;
import bomberman.entity.Entity;

/**
 * @author Ashish
 */
public class PlayerAnimations {

    Sprite moveRight;
    Sprite moveLeft;
    Sprite moveUp;
    Sprite moveDown;
    Sprite idle;

    public PlayerAnimations(Entity e) {
        moveDown  = new Sprite(e, 30, 0.1, 0,  0, 3, GlobalConstants.PLAYER_WIDTH, GlobalConstants.PLAYER_HEIGHT, 2, false);
        moveLeft  = new Sprite(e, 30, 0.1, 30, 0, 3, GlobalConstants.PLAYER_WIDTH, GlobalConstants.PLAYER_HEIGHT, 2, false);
        moveUp    = new Sprite(e, 30, 0.1, 60, 0, 3, GlobalConstants.PLAYER_WIDTH - 1.5, GlobalConstants.PLAYER_HEIGHT, 2, false);
        moveRight = new Sprite(e, 30, 0.1, 90, 0, 3, GlobalConstants.PLAYER_WIDTH, GlobalConstants.PLAYER_HEIGHT, 2, false);
        idle      = new Sprite(e, 30, 0.1,118, 0, 1, GlobalConstants.PLAYER_WIDTH + 2, GlobalConstants.PLAYER_HEIGHT, 2, false);
    }

    public Sprite getMoveRightSprite() {
        return moveRight;
    }

    public Sprite getMoveLeftSprite() {
        return moveLeft;
    }

    public Sprite getMoveUpSprite() {
        return moveUp;
    }

    public Sprite getMoveDownSprite() {
        return moveDown;
    }
    public Sprite getPlayerIdleSprite(){
        return idle;
    }
}
