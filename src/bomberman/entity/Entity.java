/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.entity;

import bomberman.entity.boundedbox.RectBoundedBox;

/**
 *
 * @author Ashish
 */
public interface Entity {
    boolean isColliding(Entity b);
    void draw();
    void removeFromScene();
    int getPositionX();
    int getPositionY();
	RectBoundedBox getBoundingBox();
}
