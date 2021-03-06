package gamejam.spy.gameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import gamejam.spy.SpyGame;
import gamejam.spy.Vector;
import gamejam.spy.controllers.KeyInput;
import gamejam.spy.controllers.TextureMap;
import gamejam.spy.gameObjects.entities.Entity;
import gamejam.spy.gameObjects.tiles.Tile;
import gamejam.spy.interfaces.Renderable;
import gamejam.spy.interfaces.Textured;

public abstract class Level implements Renderable, Textured {
	
	public Grid tileGrid;
	public ArrayList<Entity> entities;
	public ArrayList<Entity> toDelete;
	public String backgroundImage = "defaultBackgroundImage";
	public boolean canPause = true;
	
	public Level() {
		tileGrid = new Grid();
		tileGrid.tileSize = 32;
		entities = new ArrayList<Entity>();	
		toDelete = new ArrayList<Entity>();
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
	
	public void deleteEntity(Entity e) {
		toDelete.add(e);
	}
	
	public void addTile(Tile t, Vector v) {
		t.setGridPosition(v);
		addTile(t);
	}
	
	public void tick() {
		try {
			if(!SpyGame.paused) {
				tileGrid.grid.values().forEach(e -> e.tick());
				entities.forEach(e -> e.tick());
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		if(KeyInput.isDown(KeyEvent.VK_P)) {
			SpyGame.paused = !SpyGame.paused;
		}
		
		if(KeyInput.isDown(KeyEvent.VK_N)) {
			nextLevel();
		}
		
		if(KeyInput.isDown(KeyEvent.VK_R)) {
			restartLevel();
		}
		
		if(KeyInput.isDown(KeyEvent.VK_S)) {
			SpyGame.showingDeaths = !SpyGame.showingDeaths;
		}
		
		if(KeyInput.isDown(KeyEvent.VK_M)) {
			SpyGame.playMusic = !SpyGame.playMusic;
		}
		
		entities.removeAll(toDelete);
		toDelete.clear();
	}
	
	public abstract void restartLevel();
	public abstract void nextLevel();

	@Override
	public void render(Graphics g) {
		g.drawImage(TextureMap.getTexture(backgroundImage), 0, 0, SpyGame.window.width, SpyGame.window.height, null);
		tileGrid.grid.values().forEach(e-> e.render(g));
		entities.forEach(e -> e.render(g));
		
		if(SpyGame.showingDeaths) {
			Color c = g.getColor();
			g.setColor(Color.RED);
			g.drawString("Deaths: " + SpyGame.deaths, 5, 12);
			g.setColor(c);
		}
		
		if(!SpyGame.playMusic) {
			Color c = g.getColor();
			g.setColor(Color.RED);
			g.drawString("Music off" + SpyGame.deaths, 40, 12);
			g.setColor(c);
		}
	}

	@Override
	public String getTextureKey() {
		return null;
	}
	
}
