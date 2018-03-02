/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.animations;

import bomberman.animations.sprites.Sprite;
import bomberman.animations.sprites.SpriteSpecification;
import bomberman.entity.Entity;

/**
 *
 * @author Ashish
 */
public class BombAnimations implements Animations{
    Sprite blackBomb;
    double playSpeed;
    
    public BombAnimations(Entity e) {
        blackBomb = new Sprite(e,SpriteSpecification.BOMB);
    }
    
    public Sprite getSprite() {
    		return getBlackBomb();
    }
    
    public Sprite getBlackBomb() {
        return blackBomb;
    }

    public void setBlackBomb(Sprite blackBomb) {
        this.blackBomb = blackBomb;
    }
}
