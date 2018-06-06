package bomberman.entity.enemy;

import bomberman.constants.EntityDimensions;
import bomberman.entity.Entity;
import bomberman.entityconfigurations.animations.KillableEntityAnimations;
import bomberman.entityconfigurations.animations.sprites.SpriteSpecification;
import bomberman.entityconfigurations.movements.RandomMovements;

public class Ballom extends Enemy {

	public Ballom(int x, int y) {
		super(x, y);
	}

	public int setHealth() {
		// TODO Auto-generated method stub
		return 0;
	}

	protected void setMovementStrategy() {
		movementStrategy = new RandomMovements(20);
//		movementStrategy = new Stationary();
	}

	protected void setAnimations(Entity e) {
		animations = new KillableEntityAnimations(e, SpriteSpecification.BALLOOM, SpriteSpecification.BALLOOMDIE);
	}

	protected String setName() {
		return "Balloon";
	}

	@Override
	protected void setED() {
		ed = EntityDimensions.BALLOMD;
	}

}
