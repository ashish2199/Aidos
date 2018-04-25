package bomberman.entity.enemy;

import bomberman.Sandbox;
import bomberman.entity.MovingEntity;
import bomberman.entityconfigurations.boundedbox.CollidableType;

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
	
	protected void setSteps() {
		steps = 2;
	}

}
