package gamejam.spy.gameObjects.tiles;

import java.awt.Graphics;

import gamejam.spy.Vector;
import gamejam.spy.gameObjects.Grid;
import gamejam.spy.interfaces.Renderable;
import gamejam.spy.interfaces.Textured;

public class Tile implements Renderable, Textured {
	
	public Vector gridPosition;
	public Grid parentGrid;
	public String textureKey;
	
	public void setGrid(Grid g) {
		parentGrid = g;
	}
	
	public void setGridPosition(Vector position) {
		gridPosition = position.copy();
	}
	
	public void tick() {
		
	}
	
	@Override
	public void render(Graphics g) {
		
	}

	public void setTextureKey(String key) {
		textureKey = key;
	}
	
	@Override
	public String getTextureKey() {
		return textureKey;
	}

}
