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
		
		direction ++;
		
		facing = new Vector(-1,1).scale(dist).rotateDeg(direction);
		upper = facing.copy().rotateDeg(width);
		lower = facing.copy().rotateDeg(-width);
		
		Vector playerDirection = SpyGame.loadedLevel.entities.get(0).position.difference(position);
		
		double upperAngle = Math.atan(upper.getY()/upper.getX()) + (upper.getIX() <= 0 ? Math.PI : 0);
		double lowerAngle = Math.atan(lower.getY()/lower.getX()) + (lower.getIX() <= 0 ? Math.PI : 0);
		double playerAngle = Math.atan(playerDirection.getY()/playerDirection.getX()) + (playerDirection.getIX() <= 0 ? Math.PI : 0);
		
		if(playerAngle < upperAngle && playerAngle > lowerAngle && playerDirection.magnitude() < dist) {
			System.out.println("In camera");
		}
	}
	
	public void caught() {
		// Restart the level.
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
