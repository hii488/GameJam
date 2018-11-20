package gamejam.spy.gameObjects.entities;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import gamejam.spy.SpyGame;
import gamejam.spy.Vector;
import gamejam.spy.controllers.TextureMap;

public class Camera extends Entity {
	
	public int direction;
	public int cameraSpeed;
	public int movementState;
	public int counter;
	public int maxRot, minRot;
	public int width, dist;
	public Vector facing, upper, lower;
	public Vector lastPos;
	
	public Camera() {
		textureKey = "cameraGreen";
		direction = 0;
		cameraSpeed = 1;
		movementState = 0;
		counter = 0;
		minRot = -105;
		maxRot = 15;
		width = 30;
		dist = 150;
		facing = new Vector(0,0);
		upper = new Vector(0,0);
		lower = new Vector(0,0);
		lastPos = new Vector(0,0);
	}
	
	public void tick() {
		// Rotating the camera
		switch(movementState) {
		case 0:
			counter++;
			if(counter > 10) movementState++;
			break;
		case 1:
			direction += cameraSpeed;
			if(direction >=  maxRot) {
				movementState++;
				counter = 0;
			}
			break;
		case 2:
			counter++;
			if(counter > 10) movementState++;
			break;
		case 3:
			direction -= cameraSpeed;
			if(direction <=  minRot) {
				movementState = 0;
				counter = 0;
			}
			break;
		}
		
		facing = new Vector(-1,1).scale(dist).rotateDeg(direction);
		upper = facing.copy().rotateDeg(width);
		lower = facing.copy().rotateDeg(-width);
		
		Vector playerDirection1 = SpyGame.loadedLevel.entities.get(0).position.difference(position);
		Vector playerDirection2 = SpyGame.loadedLevel.entities.get(0).position.copy().translate(20, 30).difference(position); // Other corner
		
		double upperAngle = Math.atan(upper.getY()/upper.getX()) + (upper.getIX() <= 0 ? Math.PI : 0);
		double lowerAngle = Math.atan(lower.getY()/lower.getX()) + (lower.getIX() <= 0 ? Math.PI : 0);
		double playerAngle1 = Math.atan(playerDirection1.getY()/playerDirection1.getX()) + (playerDirection1.getIX() <= 0 ? Math.PI : 0);
		double playerAngle2 = Math.atan(playerDirection2.getY()/playerDirection2.getX()) + (playerDirection2.getIX() <= 0 ? Math.PI : 0);
		
		if     (playerAngle1 < upperAngle && playerAngle1 > lowerAngle && playerDirection1.magnitude() < dist) caught();
		else if(playerAngle2 < upperAngle && playerAngle2 > lowerAngle && playerDirection2.magnitude() < dist) caught();
		else lastPos.setLocation(-1, -1);
	}
	
	public void caught() {
		if(((Player) SpyGame.loadedLevel.entities.get(0)).hat == -1) SpyGame.loadedLevel.restartLevel();
		else if(!lastPos.equals(new Vector(-1,-1))) {
			if(!lastPos.equals(SpyGame.loadedLevel.entities.get(0).position)) {
				SpyGame.loadedLevel.restartLevel();
			}
		}
		else {
			lastPos.setLocation(SpyGame.loadedLevel.entities.get(0).position);
		}
	}
	
	
	public void render(Graphics g) {
		BufferedImage image = TextureMap.getTexture(getTextureKey());
		double rotationRequired = Math.toRadians (direction);
		double locationX = image.getWidth() / 2;
		double locationY = image.getHeight() / 2;
		AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);

		// Drawing the rotated image at the required drawing locations
		g.drawImage(op.filter(image, null), position.getIX(), position.getIY(), null);
		g.drawLine(position.getIX() + image.getWidth()/2, position.getIY() + image.getHeight()/2, position.getIX() + image.getWidth()/2 + upper.getIX() , position.getIY() + image.getHeight()/2 + upper.getIY());
		g.drawLine(position.getIX() + image.getWidth()/2, position.getIY() + image.getHeight()/2, position.getIX() + image.getWidth()/2 + lower.getIX() , position.getIY() + image.getHeight()/2 + lower.getIY());
	}
	
	
	
}
