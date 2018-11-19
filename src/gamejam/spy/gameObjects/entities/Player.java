package gamejam.spy.gameObjects.entities;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collection;

import gamejam.spy.SpyGame;
import gamejam.spy.Vector;
import gamejam.spy.controllers.KeyInput;
import gamejam.spy.controllers.MouseInput;
import gamejam.spy.gameObjects.collision.Lamina2D;
import gamejam.spy.gameObjects.collision.Vertex;
import gamejam.spy.gameObjects.tiles.Tile;

public class Player extends Entity {
	
	public String[] textures = {"player", "PlayerRunning1.png", "playerRun2.png"}; // TODO: correct this
	
	private Vertex pos;
	private Lamina2D lamina;
	
	private double yv = 0;
	
	public Player() {
		super();
		ArrayList<Vertex> vertices = new ArrayList<>();
		pos = new Vertex(0, 0);
		
		vertices.add(new Vertex(22, 0));
		vertices.add(pos);
		vertices.add(new Vertex(0, 64));
		vertices.add(new Vertex(22, 64));
		
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
			moveX(5);
		}
		if (KeyInput.isDown(KeyEvent.VK_A)) {
			moveX(-5);
		}
		if (KeyInput.isDown(KeyEvent.VK_W) && yv == 0) {
			this.yv = 10;
		}
		yv -= 0.9;
		moveY(-yv);
		Collection<Tile> tiles = SpyGame.loadedLevel.tileGrid.grid.values();
		for (Tile t : tiles) {
			lamina.resolvePen(t.getLamina());
			if (lamina.isTouching(t.getLamina())) {
				yv = 0;
			}
		}
		position.setLocation(pos.getX()-4, pos.getY());
		
	}
	
}
