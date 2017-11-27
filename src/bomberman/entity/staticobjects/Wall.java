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
import javafx.scene.paint.Color;

/**
 *
 * @author kdost
 */
public class Wall implements StaticEntity {
    public int positionX = 0;
    public int positionY = 0;
    private int height;
    private int width;
    private Color wallColor;
    private Sprite sprite;


    public Wall (int x, int y) {
    	positionX = x;
    	positionY = y;

    	width = 16;
    	height = 16;

    	sprite = new Sprite(this, 16, 0, 248, 123, 1, 16, 16, 1, false);
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
    public int getPositionX() {
        return positionX;
    }

    @Override
    public int getPositionY() {
        return positionY;
    }

}
