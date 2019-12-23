/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.scenes;

import bomberman.GameLoop;
import bomberman.Renderer;
import bomberman.entity.Entity;
import bomberman.entity.player.Player;
import bomberman.entity.staticobjects.Wall;
import bomberman.gamecontroller.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

import static bomberman.constants.GlobalConstants.*;

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

	static Comparator<Entity> layerComparator=new Comparator<Entity>() {
        @Override
        public int compare(Entity o1, Entity o2) {
            int result = Integer.compare(o1.getLayer(),o2.getLayer());
            return result;
        }
    };

	public static boolean addEntityToGame(Entity e){
		if(!entities.contains(e)){
			entities.add(e);
            Collections.sort(entities,layerComparator);
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

        //load map
        try
        {
            loadMap(new File("Resources/maps/sandbox_map.txt"));
        } catch (IOException e)
        {
            System.err.println("Unable to load map file.");
            System.exit(1);
        }

        //should be called at last it based on player
        EventHandler.attachEventHandlers(s);

    }


    //Eventually this should take some kind of map input, maybe a text file or something
    public static void loadMap(File file) throws IOException
    {
    	Vector<Wall> walls = new Vector<Wall>();
    	boolean playerSet = false;

        try(BufferedReader inputStream = new BufferedReader(new FileReader(file)))
        {
            String line;
            int y = 0;
            while((line = inputStream.readLine()) != null)
            {
                for(int x = 0; x < line.length(); x++)
                {
                    switch (line.charAt(x))
                    {
                        case 'W':
                            walls.add(new Wall(x * CELL_SIZE, y * CELL_SIZE));
                            break;
                        case 'P':
                            //Initialize Objects
                            setPlayer(new Player(x * CELL_SIZE, y * CELL_SIZE));
                            playerSet = true;
                            break;
                    }
                }
                y++;
            }
        }

        if(!playerSet)
        {
            System.err.println("No player location is set on map.");
            System.exit(1);
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
