/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.entity.staticobjects;

import bomberman.animations.WallAnimations;
import bomberman.entity.Entity;
import bomberman.entity.StaticEntity;
import bomberman.entity.boundedbox.RectBoundedBox;
import javafx.scene.paint.Color;

/**
 *
 * @author kdost
 */
public class Wall extends StaticEntity {
	
	private final int wallWidth = 16;
	private final int wallHeight = 16;
	private Color wallColor;
    RectBoundedBox entityBoundary;


    public Wall (int x, int y) {
    		super(x, y);
    }

    public void changeColor(Color color) {
        wallColor = color;
    }

    @Override
    public boolean isColliding(Entity b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeFromScene() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean isPlayerCollisionFriendly() {
        return false;
    }

	public boolean isAlive() {
		return true;
	}

	protected void setAnimations(Entity e) {
		animations = new WallAnimations(e);
	}

	protected int entityWidth() {
		return wallWidth;
	}

	protected int entityHeight() {
		return wallHeight;
	}

	protected String setName() {
		return "Wall";
	}

}
