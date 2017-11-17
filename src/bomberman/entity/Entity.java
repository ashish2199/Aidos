/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.entity;

import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author Ashish
 */
public interface Entity {
    boolean isColliding(Entity b);
    void draw(GraphicsContext gc, double time);
}
