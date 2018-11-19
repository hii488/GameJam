package gamejam.spy.gameObjects;

import java.util.HashMap;

import gamejam.spy.Vector;
import gamejam.spy.gameObjects.tiles.Tile;

public class Grid {
	public HashMap<Vector, Tile> grid = new HashMap<Vector, Tile>();
	
	public void addTile(Tile t) {
		t.setGrid(this);
		grid.put(t.gridPosition, t);
	}
}
