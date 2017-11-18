/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.entity;

import javafx.scene.paint.Color;

/**
 *
 * @author kdost
 */
public class Wall extends StaticEntity {
    private int height;
    private int width;
    private int health;
    private Color wallColor;
    
    public void changeColor(Color color) {
        wallColor = color;
    }
    public void getDamageLevel() {
        
    }
    
}
