package gamejam.spy.gameObjects.entities;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;

import gamejam.spy.SpyGame;
import gamejam.spy.controllers.KeyInput;
import gamejam.spy.controllers.TextureMap;
import gamejam.spy.gameObjects.collision.Lamina2D;
import gamejam.spy.gameObjects.collision.Vertex;
import gamejam.spy.gameObjects.tiles.Tile;

public class Player extends Entity {
	
	public String[] textures = {"playerRunning1", "playerRunning2", "playerRunning3", "playerRunning4", "playerRunning5", "playerRunning6", "playerRunning7"};
	public String idle = "player";
	private Vertex pos;
	private Lamina2D lamina;
	
	private int counter = 0;
	private int currentTex = 0;
	
	public int hat = -1;
	
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
	
	public Player setPosition(int x, int y) {
		position.setLocation(x,y);
		pos.setX(x);
		pos.setY(y);
		return this;
	}
	
	public void tick() {
		super.tick();
		if (KeyInput.isDown(KeyEvent.VK_D) || KeyInput.isDown(KeyEvent.VK_RIGHT)) {
			isRight = true;
			moveX(5);
			this.setTextureKey(textures[currentTex]);
			if (counter > 3) {
				counter -= 3;
				currentTex = (currentTex + 1) % textures.length;
			}
		} 
		else if (KeyInput.isDown(KeyEvent.VK_A) || KeyInput.isDown(KeyEvent.VK_LEFT)) {
			isRight = false;
			moveX(-5);
			this.setTextureKey(textures[currentTex]);
			if (counter > 3) {
				counter -= 3;
				currentTex = (currentTex + 1) % textures.length;
			}
		} else {
			this.setTextureKey(idle);
			counter = 0;
			currentTex = 0;
		}
		if ((KeyInput.isDown(KeyEvent.VK_W)  || KeyInput.isDown(KeyEvent.VK_UP))&& yv == 0) {
			this.yv = 10;
		}
		yv -= 0.9;
		moveY(-yv);
		
		// Resolve tile collision.
		Collection<Tile> tiles = SpyGame.loadedLevel.tileGrid.grid.values();
		for (Tile t : tiles) {
			lamina.resolvePen(t.getLamina());
			if (lamina.isTouching(t.getLamina())) {
				yv = 0;
				t.onCollide();
			}
		}
		
		// Resolve entity collision
		Collection<Entity> entities = SpyGame.loadedLevel.entities;
		for (Entity t : entities) {
			// Only do collision if the entity is solid.
			if(t.isSolid()) lamina.resolvePen(t.getLamina());
			
			if (lamina.isTouching(t.getLamina())) {
				yv = 0;
				t.onCollide();
			}
		}
		
		position.setLocation(pos.getX()-4, pos.getY());
		counter += 1;
	}
	
	public void render(Graphics g) {
		if (isRight) {
			g.drawImage(TextureMap.getTexture(getTextureKey()), position.getIX(), position.getIY(), null);
		} else {
			BufferedImage texture = (BufferedImage) TextureMap.getTexture(getTextureKey());
			AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
			tx.translate(-texture.getWidth(null), 0);
			AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
			texture = op.filter(texture, null);
			g.drawImage(texture, position.getIX(), position.getIY(), null);
		}
	}
	
}
