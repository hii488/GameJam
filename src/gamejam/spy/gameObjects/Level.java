package gamejam.spy.gameObjects;

import java.awt.Graphics;
import java.util.ArrayList;

import gamejam.spy.Vector;
import gamejam.spy.gameObjects.entities.Entity;
import gamejam.spy.gameObjects.tiles.Tile;
import gamejam.spy.interfaces.Renderable;
import gamejam.spy.interfaces.Textured;

public class Level implements Renderable, Textured {
	
	public Grid tileGrid;
	public ArrayList<Entity> entities;
	public String backgroundImage = "defaultBackgroundImage";
	
	public Level() {
		tileGrid = new Grid();
		entities = new ArrayList<Entity>();	
	}
	
	public Level(String backgroundImage) {
		this.backgroundImage = backgroundImage;
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
	
	public void tick() {
		tileGrid.grid.values().forEach(e -> e.tick());
		entities.forEach(e -> e.tick());
	}

	@Override
	public void render(Graphics g) {
		tileGrid.grid.values().forEach(e-> e.render(g));
		entities.forEach(e -> e.render(g));
	}

	@Override
	public String getTextureKey() {
		return null;
	}
	
}
