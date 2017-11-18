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
public class Player extends MovingEntity {
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
}
