/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.scenes;

import static bomberman.constants.GlobalConstants.canvasHeight;
import static bomberman.constants.GlobalConstants.canvasWidth;
import static bomberman.constants.GlobalConstants.sceneHeight;
import static bomberman.constants.GlobalConstants.sceneWidth;

import java.util.Vector;

import bomberman.GameLoop;
import bomberman.Renderer;
import bomberman.entity.Entity;
import bomberman.entity.player.Player;
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
        s = new Scene(root, sceneWidth, sceneHeight);
        c = new Canvas(canvasWidth, canvasHeight);
        root.getChildren().add(c);
        gc = c.getGraphicsContext2D();
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(2);
        gc.setFill(Color.BLUE);
        Renderer.init();
        GameLoop.start(gc);

        //Initialize Objects
        Player p = new Player();
        Player p2 = new Player();
        p2.positionX = 300;
        p2.positionY = 100;

        addEntityToGame(p);
        addEntityToGame(p2);
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
}
