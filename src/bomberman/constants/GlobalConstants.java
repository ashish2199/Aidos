/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.constants;

import javafx.scene.paint.Color;

/**
 *
 * @author Ashish
 */
public class GlobalConstants {
	
	public static final int GRID_SIZE = 42;
    public static String GAME_NAME = "BomberMan";
    public static String GAME_VERSION = "  v 0.1";
    public static Color BACKGROUND_COLOR = Color.WHITE;
    
    public static enum GameStatus{
        Running,Paused,GameOver
    }
    
    public static final int PLAYER_SPEED = 3;
	public static final int BOMB_EXPLODING_TIME = 100;
    public static final double PERSISTANCE_TIME = 0.5; // duration a killable entity should be kept in the game after dying
    public static final int EXPLOSION_RADIUS = 3;
}
