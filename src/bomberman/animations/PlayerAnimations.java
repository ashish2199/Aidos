/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.animations;

import bomberman.Renderer;
import bomberman.constants.GlobalConstants;
import bomberman.entity.Entity;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

/**
 * @author Ashish
 */
public class PlayerAnimations {

    Sprite moveRight;
    Sprite moveLeft;
    Sprite moveUp;
    Sprite moveDown;
    Sprite idle;
    Sprite die;
    double playSpeed;
    public PlayerAnimations(Entity e,int scale) {
        Image img = Renderer.getSpiteSheet();
        playSpeed=0.1;
        moveDown  = new Sprite(e, 30, 0.1, 0,  0, 3, GlobalConstants.PLAYER_WIDTH, GlobalConstants.PLAYER_HEIGHT, scale, false);
        moveLeft  = new Sprite(e, 30, 0.1, 30, 0, 3, GlobalConstants.PLAYER_WIDTH, GlobalConstants.PLAYER_HEIGHT, scale, false);
        moveUp    = new Sprite(e, 30, 0.1, 60, 0, 3, GlobalConstants.PLAYER_WIDTH - 1.5, GlobalConstants.PLAYER_HEIGHT, scale, false);
        moveRight = new Sprite(e, 30, 0.1, 90, 0, 3, GlobalConstants.PLAYER_WIDTH, GlobalConstants.PLAYER_HEIGHT, scale, false);
        idle      = new Sprite(e, 30, 0.1,118, 0, 1, GlobalConstants.PLAYER_WIDTH + 2, GlobalConstants.PLAYER_HEIGHT, scale, false);
        
        List<Rectangle> specs=new ArrayList<>();
        specs.add(new Rectangle(149, 0,20,21));
        specs.add(new Rectangle(179, 1,19,20));
        specs.add(new Rectangle(118, 30,21,21));
        specs.add(new Rectangle(149, 30,20,21));
        specs.add(new Rectangle(179, 30,19,21));
        specs.add(new Rectangle(118, 60,21,21));
        specs.add(new Rectangle(147, 60,23,22));
        die = new Sprite(e,30,playSpeed,img, specs,GlobalConstants.PLAYER_WIDTH+2, GlobalConstants.PLAYER_HEIGHT+2, scale, false);
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
    public Sprite getPlayerDying(){
        return die;
    }
}
