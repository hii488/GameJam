package gamejam.spy.gameObjects.entities;

import java.awt.Graphics;

import gamejam.spy.Vector;
import gamejam.spy.interfaces.Renderable;
import gamejam.spy.interfaces.Textured;

public class Entity implements Renderable, Textured {
	
	public Vector position = new Vector(0,0);
	public String textureKey = "";
	
	@Override
	public void render(Graphics g) {}

	public void tick() {}

	public void setPosition(int x, int y) {
		position.setLocation(x,y);
	}
	
	public void setTextureKey(String key) {
		textureKey = key;
	}

	@Override
	public String getTextureKey() {
		return textureKey;
	}

}
