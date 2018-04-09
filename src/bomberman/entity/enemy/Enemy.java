package bomberman.entity.enemy;

import bomberman.Sandbox;
import bomberman.entity.MovingEntity;
import bomberman.entity.configurations.boundedbox.CollidableType;

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
