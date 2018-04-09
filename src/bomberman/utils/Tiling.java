package bomberman.utils;

import static bomberman.constants.GlobalConstants.GRID_SIZE;

/**
 * Used for proper positioning on the tiled game map
 * referenced from carlosflorencio's bomberman
 * 
 * @author tialim
 *
 */

public class Tiling {

	// TODO find way to adjust this
	public static int tileWidth;
	public static int tileHeight;

	public static int pixelToTile(double i) {
		return (int) (Math.rint(i / GRID_SIZE));
	}

	public static int snapTile(double i) {
		return pixelToTile(i) * GRID_SIZE;
	}

	public static int tileToPixel(int i) {
		return tileToPixel((double) i);
	}

	public static int tileToPixel(double i) {
		// TODO account for direction
		if (i > tileWidth) {
			return tileWidth;
		} else if (i < 0) {
			return 0;
		}
		return (int) i * GRID_SIZE;
	}
}
