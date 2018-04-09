/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;
import java.util.function.Predicate;

import bomberman.entity.Entity;
import bomberman.entity.KillableEntity;
import bomberman.entity.factory.EntityFactory;
import bomberman.entity.player.Player;
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
public class Sandbox implements Iterable<Entity> {
	private Scene s;
	private Group root;
	private Canvas c;
	private GraphicsContext gc; // temporarily stores the entities to be added to the game at each loop
	private boolean sceneStarted;
	private Player sandboxPlayer;
	private Collection<Entity> toBeAdded, entities;
	private Collection<KillableEntity> toBeKilled, killableEntities;
	private EntityFactory factory;
	private int sceneW, sceneH;

	public Sandbox(Collection<Entity> ent, int sceneWidth, int sceneHeight) {
		entities = ent;
		sceneW = sceneWidth;
		sceneH = sceneHeight;
		killableEntities = new Vector<KillableEntity>();
		toBeAdded = new ArrayList<Entity>(); 
		toBeKilled = new ArrayList<KillableEntity>();
		factory = EntityFactory.INSTANCE;
		setupScene();
	}
	
	/*
	 *  ************ Getters and Setters  ************
	 */

	public Collection<Entity> getEntities() {
		return entities;
	}
	
	public Scene getScene() {
		return s;
	}
	
	public void setScene(Scene scene) {
		s = scene;
	}
	
	public int getSceneW() {
		return sceneW;
	}
	
	public int getSceneH() {
		return sceneH;
	}

	public GraphicsContext getGraphicsContext() {
		return gc;
	}

	public Canvas getCanvas() {
		return c;
	}
	
	public void setCanvas(Canvas canvas) {
		c = canvas;
	}

	public void setPlayer(Player p) {
		sandboxPlayer = p;
		addEntityToGame(p);
	}

	public Player getPlayer() {
		return sandboxPlayer;
	}
	
	/*
	 *  ************ Methods for Manipulating the game ************
	 */

	public boolean addEntityToGame(Entity e) {
		if (!entities.contains(e)) {
			toBeAdded.add(e);
			return true;
		} else {
			return false;
		}
	}

	public void addBombTo(double x, double y) {
		// adds a bomb to the map on coordinates (x,y)
		addNewEntity('O', (int) x, (int) y);
	}

	public void killCollidingEntities(Entity e) {
		// add any entity colliding with e to the kill list
		toBeKilled.addAll(getKillableEntitiesColliding(e));
	}

	public void killPlayersColliding(Entity e) {
		// add any player colliding with e to the kill list
		// TODO for multiplayer, add players to list and loop through list
		if (sandboxPlayer.isColliding(e)) {
			toBeKilled.add(sandboxPlayer);
		}
	}

	public Collection<Entity> getEntityColliding(Entity e) {
		Predicate<Entity> isNotColliding = other -> other.equals(e) || !other.isColliding(e);
		return filterOutEntities(isNotColliding, entities);
	}
	
	/*
	 *  ************ Gameloop Methods ************
	 */

	void killEntities() {
		// kills each entity that is on the kill list
		toBeKilled.forEach(KillableEntity::die);
		toBeKilled.clear();
	}
	
	void updateEntities() {
		// adds the necessary entities to the game, and updates the Sandbox entity list
		entities.forEach(e -> e.update(this));
		entities.addAll(toBeAdded);
		for (Entity e : toBeAdded) {
			if (e instanceof KillableEntity) {
				killableEntities.add((KillableEntity) e);
			}
		}
		toBeAdded.clear();
	}
	
	/*
	 *  ************ Private Helper Methods ************
	 */

	private Collection<KillableEntity> getKillableEntitiesColliding(Entity e) {
		Predicate<Entity> isNotKillable = entity -> !(entity instanceof KillableEntity);
		Collection<Entity> temp = filterOutEntities(isNotKillable, getEntityColliding(e));
		Collection<KillableEntity> result = new ArrayList<KillableEntity>();
		for (Entity ent : temp) {
			assert (ent instanceof KillableEntity);
			result.add((KillableEntity) ent);
		}
		return result;
	}

	private Collection<Entity> filterOutEntities(Predicate<Entity> pred, Collection<Entity> entityList) {
		Collection<Entity> result = new ArrayList<Entity>();
		result.addAll(entityList);
		result.removeIf(pred);
		return result;
	}

	public Iterator<Entity> iterator() {
		return entities.iterator();
	}
	
	private void init() {
		root = new Group();
		s = new Scene(root, sceneW, sceneH);
		c = new Canvas(sceneW, sceneH);
		root.getChildren().add(c);
		gc = c.getGraphicsContext2D();
		gc.setStroke(Color.BLUE);
		gc.setLineWidth(2);
		gc.setFill(Color.BLUE);
		Renderer.init();
		GameLoop.start(gc, this);
		EventHandler.attachEventHandlers(s);
	}


	private void setupScene() {
		if (!sceneStarted) {
			init();
			processEntities();
			sceneStarted = true;
		}
	}

	private void addNewEntity(char entityType, int x, int y) {
		addEntityToGame(factory.create(entityType, x, y));
	}
	
	private void processEntities() {
		for (Entity e: entities) {
			if (e instanceof KillableEntity) {
				killableEntities.add((KillableEntity) e);
			}
			if (e instanceof Player) {
				sandboxPlayer = (Player) e;
			}
		}
	}

}
