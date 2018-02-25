/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.entity.staticobjects;

import bomberman.Renderer;
import bomberman.animations.Sprite;
import bomberman.entity.Entity;
import bomberman.entity.StaticEntity;
import bomberman.geometry.Boundary;
import javafx.scene.paint.Color;

/**
 *
 * @author kdost
 */
public class Wall implements StaticEntity {
    private Color wallColor;
    private Sprite sprite;
    Boundary entityBoundary;

    public Wall (int x, int y) {
    	sprite = new Sprite(this, 16, 0, 348, 123, 1, 16, 16, 2, false);
    	entityBoundary = new Boundary(x, y, 16, 16);
    }

    public void changeColor(Color color) {
        wallColor = color;
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
    public Boundary getBoundary()
    {
            return entityBoundary;
    }

    @Override
    public boolean isPlayerCollisionFriendly() {
        return false;
    }

}
