/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;
import java.util.function.Predicate;

import bomberman.entity.Entity;
import bomberman.entity.KillableEntity;
import bomberman.entity.factory.EntityFactory;
import bomberman.entity.player.Player;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author Ashish
 */
public class Sandbox extends Observable implements Iterable<Entity> {
	private GraphicsContext gc; // temporarily stores the entities to be added to the game at each loop
	private boolean sceneStarted;
	private Collection<Player> players;
	private Collection<Entity> toBeAdded, entities;
	private Collection<KillableEntity> toBeKilled, killableEntities;
	private EntityFactory factory;

	public Sandbox(Collection<Entity> ent, GraphicsContext gc, Observer o) {
		this.gc = gc;
		entities = ent;
		killableEntities = new Vector<KillableEntity>();
		players = new Vector<Player>();
		toBeAdded = new ArrayList<Entity>();
		toBeKilled = new ArrayList<KillableEntity>();
		factory = EntityFactory.INSTANCE;
		setupScene();
		addObserver(o);
	}

	/*
	 * ************ Getters and Setters ************
	 */

	public Collection<Entity> getEntities() {
		return entities;
	}

	public GraphicsContext getGraphicsContext() {
		return gc;
	}

	public Collection<Player> getPlayers() {
		return players;
	}

	/*
	 * ************ Methods for Manipulating the game ************
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
		players.forEach(p -> {
			if (p.isColliding(e)) {
				toBeKilled.add(p);
			}
		});
	}

	public Collection<Entity> getEntityColliding(Entity e) {
		Predicate<Entity> isNotColliding = other -> other.equals(e) || !other.isColliding(e);
		return filterOutEntities(isNotColliding, entities);
	}

	/*
	 * ************ Gameloop Methods ************
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
	
	void cleanUpEntities() {
		// removes unwanted entities from the game
		entities.removeIf(e -> !e.isPersistant());
	}

	/*
	 * ************ Private Helper Methods ************
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

	private void setupScene() {
		if (!sceneStarted) {
			processEntities();
			sceneStarted = true;
		}
	}

	private void addNewEntity(char entityType, int x, int y) {
		addEntityToGame(factory.create(entityType, x, y));
	}

	private void processEntities() {
		for (Entity e : entities) {
			if (e instanceof KillableEntity) {
				killableEntities.add((KillableEntity) e);
			}
			if (e instanceof Player) {
				players.add((Player) e);
			}
		}
	}

}
