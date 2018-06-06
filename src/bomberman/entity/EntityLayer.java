package bomberman.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bomberman.Sandbox;
import bomberman.constants.EntityDimensions;
import bomberman.entityconfigurations.boundedbox.CollidableType;

/**
 * Decorator class for Entity that to account for entities layered on top of each other on the same tile.
 * The constructor of a layered entity object takes in another entity, which
 * will be "layered" over it.
 * 
 * @author tialim
 *
 */

public class EntityLayer extends KillableEntity {

	List<Entity> entities = new ArrayList<Entity>();// entities holds an ordered list of entities. the first element of e will be
							// the bottom-most entity and the last will be the topmost entity.

	public EntityLayer(int x, int y, Entity... e) {
		super(x, y);
		entities.addAll(Arrays.asList(e));
	}

	public boolean isPersistant() {
		return !entities.isEmpty();
	}

	@Override
	public void draw(Sandbox sb) {
		entities.forEach(e -> e.draw(sb));
	}

	protected void setCollidableType() {
		collidableType = CollidableType.PENETRABLE;
//		if (!entities.isEmpty()) {
//			collidableType = entities.stream()
//					.map(e -> e.collidableType)
//					.max((t1, t2) -> t1.compareTo(t2))
//					.get();
//		}
	}

	protected void setAnimations(Entity e) {}

	public void update(Sandbox sb) {
		entities.removeIf(e -> !e.isPersistant());
		if (isPersistant()) {
			setCollidableType();
			entities.forEach(e -> e.update(sb)); // update each entity
		}
	}

	protected String setName() {
//		String s = entities.stream()
//				.map(e -> e.name)
//				.reduce("", (s1, s2) -> (s1 + "\n \t" + s2));
		return "Layered Entity " + ID; // + ": \n \t" + s;
	}

	protected void setED() {
		ed = EntityDimensions.TILED;
	}

	@Override
	public int setHealth() {
		// TODO Auto-generated method stub
		return 0;
	}


}
