package bomberman.entity.killableentity.enemy;

import bomberman.Sandbox;
import bomberman.entity.configurations.boundedbox.CollidableType;
import bomberman.entity.configurations.movements.MovingEntity;

public abstract class Enemy extends MovingEntity{

	protected Enemy(int x, int y) {
		super(x, y);
	}
	
	protected void updateExtra(Sandbox sb) {
		sb.killPlayersColliding(this);
	}
	
	protected void setCollidableType() {
		collidableType = CollidableType.PENETRABLE;
	}

}
