package bomberman.entity.enemy;

import bomberman.constants.EntityDimensions;
import bomberman.entity.Entity;
import bomberman.entity.configurations.animations.KillableEntityAnimations;
import bomberman.entity.configurations.animations.sprites.SpriteSpecification;
import bomberman.entity.configurations.movements.RandomMovements;

public class Bear extends Enemy {

	public Bear(int x, int y) {
		super(x, y);
	}

	@Override
	protected void setMovementStrategy() {
		movementStrategy = new RandomMovements(20);

	}

	@Override
	protected void setSteps() {
		steps = 2;

	}

	@Override
	public int setHealth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected void setAnimations(Entity e) {
		animations = new KillableEntityAnimations(e, SpriteSpecification.BEAR, SpriteSpecification.BEARDIE);
	}

	@Override
	protected String setName() {
		return "Bear" + ID;
	}

	@Override
	protected void setED() {
		ed = EntityDimensions.DORIAD;
	}

}
