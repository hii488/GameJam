package gamejam.spy.gameObjects.entities;

import java.awt.Graphics;
import java.awt.Image;
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
	
<<<<<<< Updated upstream
	public String[] textures = {"playerRunning1", "playerRunning2", "playerRunning3", "playerRunning4", "playerRunning5", "playerRunning6", "playerRunning7"};
	public String idle = "player";
=======
	public String[] textures = {"playerRunning1", "playerRunning2", "playerRunning3", "playerRunning4", "playerRunning5", "playerRunning6", "playerRunning7"}; // TODO: correct this
	public String[] textures2 = {"playerBlueHatRunning1", "playerBlueHatRunning2", "playerBlueHatRunning3", "playerBlueHatRunning4", "playerBlueHatRunning5", "playerBlueHatRunning6", "playerBlueHatRunning7"};
	
	public String[] idle = {"player", "playerBlueHat"};
>>>>>>> Stashed changes
	private Vertex pos;
	private Lamina2D lamina;
	
	private int counter = 0;
	private int currentTex = 0;
	
<<<<<<< Updated upstream
	public int hat = -1;
	
=======
>>>>>>> Stashed changes
	private double yv = 0;
	
	boolean isOriginal = false;
	boolean isBlueHat = true;
	boolean isSantaHat = false;
	boolean isScubaMask = false;
	
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
		
		if(isOriginal) {
			this.setTextureKey(idle[0]);
		}
		if(isBlueHat) {
			this.setTextureKey(idle[1]);
		}
	}
	
	public void moveX(double x) {
		lamina.addX(x);
	}
	
	public void moveY(double y) {
		lamina.addY(y);
	}
	
	public void setPosition(int x, int y) {
		position.setLocation(x,y);
		pos.setX(x);
		pos.setY(y);
	}
	
	public void tick() {
		super.tick();
		if (KeyInput.isDown(KeyEvent.VK_D) || KeyInput.isDown(KeyEvent.VK_RIGHT)) {
			isRight = true;
			isMoving = true;
			moveX(5);
			if (counter > 3) {
				if(isOriginal) {
					this.setTextureKey(textures[currentTex]);
				}
				if(isBlueHat) {
					this.setTextureKey(textures2[currentTex]);
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
				if(isOriginal) {
					this.setTextureKey(textures[currentTex]);
				}
				if(isBlueHat) {
					this.setTextureKey(textures2[currentTex]);
				}
				counter -= 3;
				currentTex = (currentTex + 1) % textures.length;
				System.out.println(currentTex);
			}
		} else {
			if (!isJumping) {
				if(isOriginal) {
					this.setTextureKey(idle[0]);
				}
				if(isBlueHat) {
					this.setTextureKey(idle[1]);
				}
			}
			counter = 0;
			currentTex = 0;
			isMoving = false;
		}
		if ((KeyInput.isDown(KeyEvent.VK_W)  || KeyInput.isDown(KeyEvent.VK_UP))&& yv == 0) {
			
			if (! isMoving) {
				if(isOriginal) {
					this.setTextureKey("playerJumping");
				}
				if(isBlueHat) {
					this.setTextureKey("playerBlueHatJumping");
				}
			}
			
			this.isJumping = true;
			this.yv = 10;
		}
		yv -= 0.9;
		moveY(-yv);
		Collection<Tile> tiles = SpyGame.loadedLevel.tileGrid.grid.values();
		for (Tile t : tiles) {
			lamina.resolvePen(t.getLamina());
			if (lamina.isTouching(t.getLamina())) {
				yv = 0;
<<<<<<< Updated upstream
				t.onCollide();
=======
				this.isJumping = false;
>>>>>>> Stashed changes
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
