/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.entity.staticobjects;

import bomberman.entity.Entity;
import bomberman.entity.StaticEntity;
import javafx.scene.paint.Color;

/**
 *
 * @author kdost
 */
public class Wall implements StaticEntity {
    private int height;
    private int width;
    private int health;
    private Color wallColor;
    
    public void changeColor(Color color) {
        wallColor = color;
    }
    public void getDamageLevel() {
        
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
