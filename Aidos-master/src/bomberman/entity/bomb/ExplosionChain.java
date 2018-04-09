package bomberman.entity.bomb;

import java.util.function.Predicate;

import bomberman.Sandbox;
import bomberman.constants.Direction;
import static bomberman.constants.Direction.*;
import bomberman.constants.GlobalConstants;
import bomberman.entity.Entity;
import bomberman.utils.Tiling;

public class ExplosionChain {

	private static int x, y, radius;
	private static Direction direction;
	private static Sandbox sb;

	public static void addExplosionChain(int xPos, int yPos, Direction d, Sandbox sandbox) {
		init(xPos, yPos, d, sandbox);
		Entity explosion = new Explosion(x, y);
		while (!isColliding(explosion) && radius > 0) {
			sb.addEntityToGame(explosion);

			if (hasExploded(explosion)) {
				// explosion chain length ends where it meets an entity
				break;
			}

			nextCoordinates();
			explosion = new Explosion(x, y);
			radius--;
		}
	}

	private static void init(int xPos, int yPos, Direction d, Sandbox sandbox) {
		x = xPos;
		y = yPos;
		direction = d;
		sb = sandbox;
		radius = (d.equals(IDLE)) ? 1 : GlobalConstants.EXPLOSION_RADIUS;
		nextCoordinates();
	}

	private static boolean isColliding(Entity exp) {
		// returns true if explosion is colliding with any non-collidable entities
		return testEncounter(exp, e -> e.isImpermeable());
	}

	private static boolean hasExploded(Entity exp) {
		// returns true if explosion has encountered something that is explodable before
		return testEncounter(exp, e -> e.isExplodable());
	}

	private static boolean testEncounter(Entity exp, Predicate<Entity> pred1) {
		Predicate<Entity> pred2 = e -> (!e.equals(exp) && exp.isColliding(e) && pred1.test(e));
		return sb.getEntities().stream().anyMatch(pred2);
	}

	private static void nextCoordinates() {
		switch (direction) {
		case UP:
			y = Tiling.tileToPixel(Tiling.pixelToTile(y) - 1);
			break;
		case DOWN:
			y = Tiling.tileToPixel(Tiling.pixelToTile(y) + 1);
			break;
		case LEFT:
			x = Tiling.tileToPixel(Tiling.pixelToTile(x) - 1);
			break;
		case RIGHT:
			x = Tiling.tileToPixel(Tiling.pixelToTile(x) + 1);
			break;
		default: // stationary explosion, do nothing
		}
	}
}
