/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.entity;

import bomberman.animations.Direction;

/**
 *
 * @author kdost
 */
public class MovingEntity implements Entity {
    
    private int health;
    
    public void move(int steps, Direction direction) {
        
    }
    public void die() {
        
    }
    public void reduceHealth(int damage) {
        if (health - damage <= 0) {
            this.die();
        } else {
            health -= damage;            
        }

    }
    public int getHealth() {
        return health;
    }

    @Override
    public boolean isColliding(Entity b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void draw() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeFromScene() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
