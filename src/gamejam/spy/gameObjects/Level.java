package gamejam.spy.gameObjects;

import java.awt.Graphics;
import java.util.ArrayList;

import gamejam.spy.Vector;
import gamejam.spy.gameObjects.entities.Entity;
import gamejam.spy.gameObjects.tiles.Tile;
import gamejam.spy.interfaces.Renderable;

public class Level implements Renderable {
	
	public Grid tileGrid;
	public ArrayList<Entity> entities;
	
	public Level() {
		tileGrid = new Grid();
		entities = new ArrayList<Entity>();
	}
	
	public void addEntity(Entity e) {
		entities.add(e);
	}
	
	public void addTile(Tile t) {
		tileGrid.addTile(t);
	}
	
	public void addTile(Tile t, Vector v) {
		t.setGridPosition(v);
		addTile(t);
	}

	@Override
	public void render(Graphics g) {
		tileGrid.grid.values().forEach(e-> e.render(g));
		entities.forEach(e -> e.render(g));
	}
	
}
