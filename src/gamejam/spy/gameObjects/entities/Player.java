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
	public String[] textures2 = {"playerBlueHatRunning1", "playerBlueHatRunning2", "playerBlueHatRunning3", "playerBlueHatRunning4", "playerBlueHatRunning5", "playerBlueHatRunning6", "playerBlueHatRunning7"};
	public String[] textures3 = {"playerSantaHatRunning1", "playerSantaHatRunning2", "playerSantaHatRunning3", "playerSantaHatRunning4", "playerSantaHatRunning5", "playerSantaHatRunning6", "playerSantaHatRunning7"};
	public String[] textures4 = {"playerScubaMaskRunning1", "playerScubaMaskRunning2", "playerScubaMaskRunning3", "playerScubaMaskRunning4", "playerScubaMaskRunning5", "playerScubaMaskRunning6", "playerScubaMaskRunning7"};
	public String[] idle = {"player", "playerBlueHat", "playerSantaHat", "playerScubaMask"};

	private Vertex pos;
	private Lamina2D lamina;
	
	private int counter = 0;
	private int currentTex = 0;

	private double yv = 0;
	
	public enum Hat{ORIGINAL, BLUE, SANTA, SCUBA;}
	Hat hat = Hat.ORIGINAL;
	
	boolean isRight = true;
	boolean isJumping = false;
	boolean isMoving = false;
	
	public Player() {
		super();
		ArrayList<Vertex> vertices = new ArrayList<>();
		pos = new Vertex(0, 0);
		
		vertices.add(new Vertex(22, 0));
		vertices.add(pos);
		vertices.add(new Vertex(0, 64));
		vertices.add(new Vertex(22, 64));
		
		lamina = new Lamina2D(vertices, false);
		
		lamina.addY(150);
		lamina.addX(30);
		
		
		switch(hat) {
		case ORIGINAL:
			this.setTextureKey(idle[0]);
			break;
		case BLUE:
			this.setTextureKey(idle[1]);
			break;
		case SANTA:
			this.setTextureKey(idle[2]);
			break;
		case SCUBA:
			this.setTextureKey(idle[3]);
			break;
		}
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
			isMoving = true;
			moveX(5);
			if (counter > 3) {
				switch(hat) {
				case ORIGINAL:
					this.setTextureKey(textures[currentTex]);
					break;
				case BLUE:
					this.setTextureKey(textures2[currentTex]);
					break;
				case SANTA:
					this.setTextureKey(textures3[currentTex]);
					break;
				case SCUBA:
					this.setTextureKey(textures4[currentTex]);
					break;
				}
				counter -= 3;
				currentTex = (currentTex + 1) % textures.length;
			}
		} 
		else if (KeyInput.isDown(KeyEvent.VK_A) || KeyInput.isDown(KeyEvent.VK_LEFT)) {
			isRight = false;
			isMoving = true;
			moveX(-5);
			if (counter > 3) {
				switch(hat) {
				case ORIGINAL:
					this.setTextureKey(textures[currentTex]);
					break;
				case BLUE:
					this.setTextureKey(textures2[currentTex]);
					break;
				case SANTA:
					this.setTextureKey(textures3[currentTex]);
					break;
				case SCUBA:
					this.setTextureKey(textures4[currentTex]);
					break;
				}
				counter -= 3;
				currentTex = (currentTex + 1) % textures.length;
				System.out.println(currentTex);
			}
		} else {
			if (!isJumping) {
				switch(hat) {
				case ORIGINAL:
					this.setTextureKey(idle[0]);
					break;
				case BLUE:
					this.setTextureKey(idle[1]);
					break;
				case SANTA:
					this.setTextureKey(idle[2]);
					break;
				case SCUBA:
					this.setTextureKey(idle[3]);
					break;
				}
			}
			counter = 0;
			currentTex = 0;
			isMoving = false;
		}
		if ((KeyInput.isDown(KeyEvent.VK_W)  || KeyInput.isDown(KeyEvent.VK_UP))&& yv == 0) {
			
			if (! isMoving) {
				switch(hat) {
				case ORIGINAL:
					this.setTextureKey("playerJumping");
					break;
				case BLUE:
					this.setTextureKey("playerBlueHatJumping");
					break;
				case SANTA:
					this.setTextureKey("playerSantaHatJumping");
					break;
				case SCUBA:
					this.setTextureKey("playerScubaMaskJumping");
					break;
				}
			}
			
			this.isJumping = true;
			this.yv = 14;
		}
		yv -= 0.9;
		moveY(-yv);
		
		// Resolve tile collision.
		Collection<Tile> tiles = SpyGame.loadedLevel.tileGrid.grid.values();
		for (Tile t : tiles) {
			
			if (lamina.resolvePen(t.getLamina())) {
				yv = 0;
				t.onCollide();
				this.isJumping = false;
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
