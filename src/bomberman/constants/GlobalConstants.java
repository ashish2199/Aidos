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

    public static int SCENE_WIDTH = 640;
    public static int SCENE_HEIGHT = 640;
    public static int CELL_SIZE = 32; //Cells are square
    public static int CANVAS_WIDTH = 640;
    public static int CANVAS_HEIGHT = 640;
    public static String GAME_NAME = "BomberMan";
    public static String GAME_VERSION = "  v 0.1";
    public static Color BACKGROUND_COLOR = Color.WHITE;
    public static int PLAYER_WIDTH = 18;
    public static int PLAYER_HEIGHT = 21;
    public static int PLAYER_SCALE = 2;
    public static enum GameStatus{
        Running,Paused,GameOver
    }
}
