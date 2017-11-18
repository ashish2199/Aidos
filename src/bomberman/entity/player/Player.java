/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.entity.player;

import bomberman.animations.Direction;
import bomberman.entity.Entity;
import bomberman.entity.MovingEntity;


public class Player implements MovingEntity {
    private int positionX;
    private int positionY;
    private int health;
    private boolean isAlive;
    
    public Player(int posX, int posY) {
        health = 100;
        positionX = posX;
        positionY = posY;
        isAlive = true;
    }
    public int getHealth() {
        return health;
    }
    public boolean isAlive() {
        return isAlive;
    }
    public void run(int steps, Direction direction) {
        
    }
    public int[] getPosition() {
        int[] currentPosition = { positionX, positionY };
        return currentPosition;
    }
    @Override
    public void move(int steps, Direction direction) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void die() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void reduceHealth(int damage) {
        if (health - damage <= 0) {
            this.die();
        } else {
            health -= damage;            
        }

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
