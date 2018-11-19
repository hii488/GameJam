package gamejam.spy.gameObjects.tiles;

import java.awt.Graphics;
import java.util.ArrayList;

import gamejam.spy.Vector;
import gamejam.spy.gameObjects.Grid;
import gamejam.spy.gameObjects.collision.Lamina2D;
import gamejam.spy.gameObjects.collision.Vertex;
import gamejam.spy.interfaces.Renderable;
import gamejam.spy.interfaces.Textured;

public class TriangleTile extends Tile implements Renderable, Textured {
	
	private int orientation;
	public TriangleTile (int orientation) {
		this.orientation = orientation;
	}
	public void setGrid(Grid g) {
		parentGrid = g;

		ArrayList<Vertex> vertices = new ArrayList<>();
		if (orientation == 0) {
			vertices.add(new Vertex(parentGrid.tileSize, parentGrid.tileSize));
			vertices.add(new Vertex(0, parentGrid.tileSize));
			vertices.add(new Vertex(parentGrid.tileSize, 0)); //Slope pos gradient
			
		} else if (orientation == 1) { //Each one rotated by 90deg anti clock
			vertices.add(new Vertex(parentGrid.tileSize, 0)); 
			vertices.add(new Vertex(0, 0));
			vertices.add(new Vertex(parentGrid.tileSize, parentGrid.tileSize));
		} else if (orientation == 2) {
			vertices.add(new Vertex(parentGrid.tileSize, 0)); 
			vertices.add(new Vertex(0, 0));
			vertices.add(new Vertex(0, parentGrid.tileSize));
		} else {
			vertices.add(new Vertex(0, parentGrid.tileSize));
			vertices.add(new Vertex(0, 0));
			vertices.add(new Vertex(parentGrid.tileSize, parentGrid.tileSize));



		}
		lamina = new Lamina2D(vertices, true);
		lamina.addX(gridPosition.getX() * parentGrid.tileSize);
		lamina.addY(gridPosition.getY() * parentGrid.tileSize);
	}
	
	public void setGridPosition(Vector position) {
		gridPosition = position.copy();
	}
	
	public void tick() {
		
	}

	public void setTextureKey(String key) {
		textureKey = key;
	}
	
	@Override
	public String getTextureKey() {
		return textureKey;
	}

}