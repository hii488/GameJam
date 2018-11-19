package gamejam.spy.gameObjects.tiles;

import java.awt.Graphics;

import gamejam.spy.Vector;
import gamejam.spy.gameObjects.Grid;
import gamejam.spy.interfaces.Renderable;

public class Tile implements Renderable {
	
	public Vector gridPosition;
	public Grid parentGrid;
	
	public void setGrid(Grid g) {
		parentGrid = g;
	}
	
	public void setGridPosition(Vector position) {
		gridPosition = position.getLocation();
	}
	
	@Override
	public void render(Graphics g) {
		
	}

}
