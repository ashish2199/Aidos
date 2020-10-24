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
    boolean isPlayerCollisionFriendly();
    void draw();
    void removeFromScene();
    int getPositionX();
    int getPositionY();
    RectBoundedBox getBoundingBox();

    /**
     * Layering works by sorting the list of entities to be drawn based on the layer.( created a new layerComparator for this )
     * 	Player is rendered at layer 0
     * 	Anything to be rendered below the player will get layer < 0 i.e Negative
     * 	Anything to be rendered above the player will get layer > 0 i.e Positive
     * */
    int getLayer();

    double getScale();
}
