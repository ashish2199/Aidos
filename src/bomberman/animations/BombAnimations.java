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

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Ashish
 */
public class BombAnimations {
    Sprite blackBomb;
    double playSpeed;

    public Sprite getBlackBomb() {
        return blackBomb;
    }

    public void setBlackBomb(Sprite blackBomb) {
        this.blackBomb = blackBomb;
    }

    public BombAnimations(Entity e) {
        Image img = Renderer.getSpiteSheet();
        playSpeed=0.3;
        
        List<Rectangle> specs=new ArrayList<>();
        specs.add(new Rectangle(181, 94, 16, 15));
        specs.add(new Rectangle(211, 93, 15, 16));
        specs.add(new Rectangle(241, 93, 16, 16));
        blackBomb = new Sprite(e,30,playSpeed,img, specs,GlobalConstants.PLAYER_WIDTH+2, GlobalConstants.PLAYER_HEIGHT+2, e.getScale(), false);
    }
}
