package bomberman.constants;

import static bomberman.constants.GlobalConstants.GRID_SIZE;

/**
 * Caches the specific dimensions of each entity in the game. Used to set the dimensions for the bounding box,
 * and makes it simpler to adjust the dimensions of the game. 
 * @author Tia Lim
 */

public enum EntityDimensions {
	
	//PLAYER
	PLAYERIDLED(20, 20), 
	PLAYERLEFTD(18,21),
	PLAYERUPD(16.5, 21),
	PLAYERRIGHTD(18, 21),
	PLAYERDOWND(17,20),
	PLAYERDIED(20, 23),
	
	//MAP
	TILED(16, 16), 
	
	//BOMB
	BOMBD(16,16),
	EXPLOSIOND(80, 80),
	
	//ENEMIES
	BALLOMD(18, 16),
	DORIAD(16,16);
	
	
	public final double width, height, gameW, gameH;
	public final double scale;
	
	private EntityDimensions(double width, double height) {
		this.width = width;
		this.height = height;
		this.scale = (double)GRID_SIZE/(double)Math.max(width, height);	// so that entity fits exactly in the grid
		this.gameW = width*scale;
		this.gameH = height*scale;
	}
}
