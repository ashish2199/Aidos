/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.animations;

import bomberman.constants.GlobalConstants;
import bomberman.utils.Animator;
import javafx.scene.canvas.GraphicsContext;

/**
 * @author Ashish
 */
public class PlayerAnimations {

    public static void walkDownAnimation(GraphicsContext gc, double time) {
    	Animator.playAnimation(gc, time, 30, 0, 3, GlobalConstants.playerX, GlobalConstants.playerY, GlobalConstants.playerWidth, GlobalConstants.playerHeight, GlobalConstants.playerScale, false);
    }

}
