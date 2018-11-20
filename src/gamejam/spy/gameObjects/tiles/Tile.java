package gamejam.spy.gameObjects.tiles;

import java.awt.Graphics;
import java.util.ArrayList;

import gamejam.spy.Vector;
import gamejam.spy.controllers.TextureMap;
import gamejam.spy.gameObjects.Grid;
import gamejam.spy.gameObjects.collision.Lamina2D;
import gamejam.spy.gameObjects.collision.Vertex;
import gamejam.spy.interfaces.Renderable;
import gamejam.spy.interfaces.Textured;

public class Tile implements Renderable, Textured {
	
	public Vector gridPosition;
	public Grid parentGrid;
	public String textureKey;
	public Lamina2D lamina;
	public Tile () {
		
	}
	
	public void setGrid(Grid g) {
		parentGrid = g;
		
		
		ArrayList<Vertex> vertices = new ArrayList<>();
		vertices.add(new Vertex(0, parentGrid.tileSize));
		vertices.add(new Vertex(parentGrid.tileSize, parentGrid.tileSize));
		vertices.add(new Vertex(parentGrid.tileSize, 0));
		vertices.add(new Vertex(0, 0));
		
		lamina = new Lamina2D(vertices, true);
		lamina.addX(gridPosition.getX() * parentGrid.tileSize);
		lamina.addY(gridPosition.getY() * parentGrid.tileSize);
	}
	
	public void onCollide() {}
	
	public void setGridPosition(Vector position) {
		gridPosition = position.copy();
	}
	
	public Lamina2D getLamina() {
		return this.lamina;
	}
	
	public void tick() {
		
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(TextureMap.getTexture(getTextureKey()), gridPosition.getIX() * parentGrid.tileSize, gridPosition.getIY() * parentGrid.tileSize, parentGrid.tileSize, parentGrid.tileSize, null);
		//g.drawPolygon(lamina.getPolygon());
	}

	public Tile setTextureKey(String key) {
		textureKey = key;
		return this;
	}
	
	@Override
	public String getTextureKey() {
		return textureKey;
	}

}
