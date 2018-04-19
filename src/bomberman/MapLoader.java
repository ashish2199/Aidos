package bomberman;

import static bomberman.constants.GlobalConstants.GRID_SIZE;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Vector;

import bomberman.entity.Entity;
import bomberman.entity.KillableEntity;
import bomberman.entity.factory.EntityFactory;
import bomberman.entity.player.Player;
import bomberman.utils.Tiling;

/**
 * Configuration class for the Sandbox, used to load the different maps 
 * @author tialim
 *
 */

public class MapLoader {

	// File mapFile;
	Player player;
	private static final EntityFactory factory = EntityFactory.INSTANCE;
	private int widthTile, heightTile, level;
	private Collection<Entity> entities;
	private Collection<KillableEntity> killableEntities;
	File file;
	String parentPath = "src/resources/scenes/";
	
	public MapLoader() {
		this(1);
	}

	public MapLoader(int gameLevel) {
		level = gameLevel-1;
		entities = new Vector<Entity>();	// vector used for synchronization, opening a possibility of running multi-player on different threads
		killableEntities = new Vector<KillableEntity>();
		loadNextMap();
	}

	Player getPlayer() {
		return player;
	}
	
	void setLevel(int gameLevel) {
		level = gameLevel-1;
		loadNextMap();
	}
	
	int getLevel() {
		return level;
	}

	Collection<Entity> getEntities() {
		return entities;
	}

	Collection<KillableEntity> getKillableEntities() {
		return killableEntities;
	}

	int getSceneWidth() {
		return widthTile * GRID_SIZE;
	}

	int getSceneHeight() {
		return heightTile * GRID_SIZE;
	}
	
	private void loadNextMap() {
		entities.clear();
		killableEntities.clear();
		loadMap("Level" + ++level + ".txt");
	}

	private void addEntity(char entityType, int x, int y) {
		// adds new entity to the entity list
		entities.add(factory.create(entityType, x, y));
	}

	private void loadMap(String filePath) {
		String[] map = readFile(filePath);
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length(); j++) {
				char c = map[i].charAt(j);
				if (c != ' ') {
					addEntity(map[i].charAt(j), Tiling.tileToPixel(j), Tiling.tileToPixel(i));
				}
			}
		}
	}

	private String[] readFile(String filePath) {
		String[] mapFile = null;
		try {
			InputStream is = new FileInputStream(loadFile(filePath));
			BufferedReader buf = new BufferedReader(new InputStreamReader(is));

			String[] meta = buf.readLine().split(" ");
			level = Integer.parseInt(meta[0]);
			widthTile = Integer.parseInt(meta[1]);
			heightTile = Integer.parseInt(meta[2]);
			Tiling.tileHeight = heightTile;
			Tiling.tileWidth = widthTile;

			mapFile = new String[heightTile];
			String line = buf.readLine();
			for (int i = 0; i < heightTile; i++) {
				mapFile[i] = line;
				line = buf.readLine();
			}
			buf.close();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mapFile;
	}

	private File loadFile(String filePath) {
		File file = new File(parentPath + filePath);
		String path = file.getAbsolutePath();
		if (File.separatorChar == '\\') {
			// From Windows to Linux/Mac
			path = path.replace('/', File.separatorChar);
			path = path.replace("\\", "\\\\");
		} else {
			// From Linux/Mac to Windows
			path = path.replace('\\', File.separatorChar);
		}
		return new File(path);
	}
}
