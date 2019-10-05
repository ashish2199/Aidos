/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.entity.staticobjects;

import bomberman.Renderer;
import bomberman.animations.BombAnimations;
import bomberman.animations.Sprite;
import bomberman.entity.Entity;
import bomberman.entity.StaticEntity;
import bomberman.geometry.Boundary;
import java.util.Date;

/**
 *
 * @author Ashish
 */
public class BlackBomb implements StaticEntity {
    private Sprite sprite;
    Boundary entityBoundary;
    BombAnimations bomb_animations;
    Date addedDate;
    int timerDurationInMillis = 2000;
    STATE bombState;

    enum STATE
    {
        INACTIVE,   //INACTIVE when bomb's timer hasnt yet started
        ACTIVE,     //Active when bomb's timer has started and it will explode soon
        EXPLODING,  //when bomb is exploding
        DEAD;   //when the bomb has already exploded
    }

    public BlackBomb(double x, double y) {
        bomb_animations = new BombAnimations(this);
        sprite = bomb_animations.getBlackBomb();
        entityBoundary = new Boundary(x, y, 16, 16);
        addedDate = new Date();
        bombState = STATE.ACTIVE;
    }

    public boolean isAlive(){
        STATE s = checkBombState();
        if(s==STATE.DEAD){
            return false;
        }
        else{
            if(s==STATE.ACTIVE||s==STATE.INACTIVE){
                return true;
            }
            return true;
        }
    }

    public STATE checkBombState(){
        if(new Date().getTime()>timerDurationInMillis+addedDate.getTime()){
            return STATE.DEAD;
        }else{
            return STATE.ACTIVE;
        }
    }

    @Override
    public boolean isColliding(Entity b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void draw() {
        Renderer.playAnimation(sprite);
    }

    @Override
    public void removeFromScene() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getPositionX() {
        return entityBoundary.getMinX();
    }

    @Override
    public double getPositionY() {
        return entityBoundary.getMinY();
    }

    @Override
    public Boundary getBoundary() {
        return entityBoundary;
    }

    @Override
    public boolean isPlayerCollisionFriendly() {
        return true;
    }

}
