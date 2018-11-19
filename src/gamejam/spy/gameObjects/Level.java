package gamejam.spy.gameObjects;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import gamejam.spy.SpyGame;
import gamejam.spy.Vector;
import gamejam.spy.controllers.KeyInput;
import gamejam.spy.gameObjects.entities.Entity;
import gamejam.spy.gameObjects.tiles.Tile;
import gamejam.spy.interfaces.Renderable;
import gamejam.spy.interfaces.Textured;

public class Level implements Renderable, Textured {
	
	public Grid tileGrid;
	public ArrayList<Entity> entities;
	public String backgroundImage = "defaultBackgroundImage";
	public boolean canPause = true;
	
	public Level() {
		tileGrid = new Grid();
		tileGrid.tileSize = 32;
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
		
		if(KeyInput.isDown(KeyEvent.VK_P)) {
			SpyGame.paused = true;
		}
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
