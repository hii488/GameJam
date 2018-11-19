package gamejam.spy.gameObjects.entities;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collection;

import gamejam.spy.SpyGame;
import gamejam.spy.controllers.KeyInput;
import gamejam.spy.controllers.MouseInput;
import gamejam.spy.gameObjects.collision.Lamina2D;
import gamejam.spy.gameObjects.collision.Vertex;
import gamejam.spy.gameObjects.tiles.Tile;

public class Player extends Entity {
	
	public String[] textures = {"player", "PlayerRunning1.png", "playerRun2.png"}; // TODO: correct this
	
	private Vertex pos;
	private Lamina2D lamina;
	
	public Player() {
		super();
		ArrayList<Vertex> vertices = new ArrayList<>();
		pos = new Vertex(0, 0);
		
		vertices.add(new Vertex(32, 0));
		vertices.add(pos);
		vertices.add(new Vertex(0, 64));
		vertices.add(new Vertex(32, 64));
		
		lamina = new Lamina2D(vertices, false);
		
		this.setTextureKey(textures[0]);
	}
	
	public void moveX(double x) {
		lamina.addX(x);
	}
	
	public void moveY(double y) {
		lamina.addY(y);
	}
	
	public void tick() {
		super.tick();
		if (KeyInput.isDown(KeyEvent.VK_D)) {
			moveX(10);
		}
		if (KeyInput.isDown(KeyEvent.VK_A)) {
			moveX(-10);
		}
		if (KeyInput.isDown(KeyEvent.VK_W)) {
			moveY(-10);
		}
		if (KeyInput.isDown(KeyEvent.VK_S)) {
			moveY(10);
		}
		Collection<Tile> tiles = SpyGame.loadedLevel.tileGrid.grid.values();
		for (Tile t : tiles) {
			lamina.resolvePen(t.getLamina());
		}
		position.setLocation(pos.getX(), pos.getY());
		
	}
	
}
