/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.animations;

import bomberman.constants.GlobalConstants;

/**
 * @author Ashish
 */
public class PlayerAnimations {

    Sprite moveRight;
    Sprite moveLeft;
    Sprite moveUp;
    Sprite moveDown;

    public PlayerAnimations () {
        moveDown = new Sprite(30, 0.1, 0, 0, 3, 0, 0, GlobalConstants.playerWidth, GlobalConstants.playerHeight, 2, false);
        moveLeft = new Sprite(30, 0.1, 0, 0, 30, 0, 3, GlobalConstants.playerWidth, GlobalConstants.playerHeight, 2, false);
        moveUp = new Sprite(30, 0.1, 0, 0, 60, 0, 3, GlobalConstants.playerWidth-1.5, GlobalConstants.playerHeight, 2, false);
        moveRight = new Sprite(30, 0.1, 0, 0, 90, 0, 3, GlobalConstants.playerWidth, GlobalConstants.playerHeight, 2, false);
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

}
