package gamejam.spy.gameObjects.entities;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collection;

import gamejam.spy.SpyGame;
import gamejam.spy.controllers.KeyInput;
import gamejam.spy.controllers.TextureMap;
import gamejam.spy.gameObjects.collision.Lamina2D;
import gamejam.spy.gameObjects.collision.Vertex;
import gamejam.spy.gameObjects.tiles.Tile;

public class Player extends Entity {
	
	public String[] textures = {"playerRunning1", "playerRunning2", "playerRunning3", "playerRunning4", "playerRunning5", "playerRunning6", "playerRunning7"}; // TODO: correct this
	public String idle = "player";
	private Vertex pos;
	private Lamina2D lamina;
	
	private int counter = 0;
	private int currentTex = 0;
	
	private double yv = 0;
	
	boolean isRight = true;
	
	public Player() {
		super();
		ArrayList<Vertex> vertices = new ArrayList<>();
		pos = new Vertex(0, 0);
		
		vertices.add(new Vertex(22, 0));
		vertices.add(pos);
		vertices.add(new Vertex(0, 64));
		vertices.add(new Vertex(22, 64));
		
		lamina = new Lamina2D(vertices, false);
		
		this.setTextureKey(idle);
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
			isRight = true;
			moveX(5);
			if (counter > 3) {
				this.setTextureKey(textures[currentTex]);
				counter -= 3;
				currentTex = (currentTex + 1) % textures.length;
			}
		} else {
			this.setTextureKey(idle);
			counter = 0;
			currentTex = 0;
		}
		if (KeyInput.isDown(KeyEvent.VK_A)) {
			isRight = false;
			moveX(-5);
			if (counter > 3) {
				this.setTextureKey(textures[currentTex]);
				counter -= 3;
				currentTex = (currentTex + 1) % textures.length;
			}
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
		counter += 1;
	}
	
	public void render(Graphics g) {
		if (isRight) {
			g.drawImage(TextureMap.getTexture(getTextureKey()), position.getIX(), position.getIY(), null);
		} else {
			
		}
	}
	
}
