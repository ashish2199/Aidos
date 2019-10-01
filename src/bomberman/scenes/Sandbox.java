/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.scenes;

import static bomberman.constants.GlobalConstants.CANVAS_HEIGHT;
import static bomberman.constants.GlobalConstants.CANVAS_WIDTH;
import static bomberman.constants.GlobalConstants.CELL_SIZE;
import static bomberman.constants.GlobalConstants.SCENE_HEIGHT;
import static bomberman.constants.GlobalConstants.SCENE_WIDTH;

import java.util.Vector;

import bomberman.GameLoop;
import bomberman.Renderer;
import bomberman.entity.Entity;
import bomberman.entity.player.Player;
import bomberman.entity.staticobjects.BlackBomb;
import bomberman.entity.staticobjects.Wall;
import bomberman.gamecontroller.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author Ashish
 */
public class Sandbox {

    static Scene s;
    static Group root;
    static Canvas c;
    static GraphicsContext gc;
    private static boolean sceneStarted;
    static Player sandboxPlayer;
    static{
        sceneStarted=false;
    }

	private static Vector<Entity> entities = new Vector<Entity>();

	public static Vector<Entity> getEntities(){
		return entities;
	}

	public static boolean addEntityToGame(Entity e){
		if(!entities.contains(e)){
			entities.add(e);
			return true;
		} else {
			return false;
		}
	}

    private static void init() {
        root = new Group();
        s = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
        c = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
        root.getChildren().add(c);
        gc = c.getGraphicsContext2D();
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(2);
        gc.setFill(Color.BLUE);
        Renderer.init();
        GameLoop.start(gc);

        //Initialize Objects
        Player p = new Player();
        setPlayer(p);
        
        //load map
        loadMap();

        //should be called at last it based on player
        EventHandler.attachEventHandlers(s);

    }


    //Eventually this should take some kind of map input, maybe a text file or something
    public static void loadMap() {
    	Vector<Wall> walls = new Vector<Wall>();

    	for(int i = 0; i < SCENE_WIDTH; i += CELL_SIZE){
    		for(int j = 0; j < SCENE_HEIGHT; j += CELL_SIZE){
    			if(i == 0 || i + CELL_SIZE + 1 > SCENE_HEIGHT || j == 0 || j + CELL_SIZE + 1 > SCENE_WIDTH) {
    				walls.add(new Wall(i, j));
    			}
    		}
    	}

    	for(Wall wall : walls) {
    		addEntityToGame(wall);
    	}
    }

    public static void setupScene(){
        if(!sceneStarted){
            init();
            sceneStarted=true;
        }
    }
    public static Scene getScene() {
        return s;
    }

    public static GraphicsContext getGraphicsContext() {
        return gc;
    }

    public static Canvas getCanvas() {
        return c;
    }

    public static void setPlayer(Player p){
        sandboxPlayer = p;
        addEntityToGame(p);
    }
    public static Player getPlayer(){
        return sandboxPlayer;
    }
}
