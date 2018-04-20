package bomberman.entity.enemy;

import bomberman.constants.EntityDimensions;
import bomberman.entity.Entity;
import bomberman.entityconfigurations.animations.KillableEntityAnimations;
import bomberman.entityconfigurations.animations.sprites.SpriteSpecification;
import bomberman.entityconfigurations.movements.RandomMovements;

public class Doria extends Enemy {

	public Doria(int x, int y) {
		super(x, y);
	}

	protected void setMovementStrategy() {
		movementStrategy = new RandomMovements(20);
	}
	
	protected void setSteps() {
		steps = 2;
	}

	public int setHealth() {
		// TODO Auto-generated method stub
		return 0;
	}

	protected void setAnimations(Entity e) {
		animations = new KillableEntityAnimations(e, SpriteSpecification.DORIA, SpriteSpecification.DORIADIE);
	}

	protected String setName() {
		return "Doria" + ID;
	}

	protected void setED() {
		ed = EntityDimensions.DORIAD;
	}

}
