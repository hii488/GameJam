package gamejam.spy.gameObjects.entities;

import java.awt.Graphics;

import gamejam.spy.SpyGame;
import gamejam.spy.Vector;
import gamejam.spy.controllers.TextureMap;

public class Hat extends Entity{
	public Player.Hat hatID;
	
	public Hat() {
		setDimensions(new Vector(16,16));
	}
	
	public void onCollide() {
		((Player) SpyGame.loadedLevel.entities.get(0)).hat = hatID;
		SpyGame.loadedLevel.deleteEntity(this);
	}
	
	public Hat setHatID(Player.Hat id) {
		hatID = id;
		return this;
	}
	
	public Hat setTextureKey(String s) {
		this.textureKey = s;
		return this;
	}
	
	public void render(Graphics g) {
		g.drawImage(TextureMap.getTexture(getTextureKey()), position.getIX(), position.getIY(), 16, 16, null);
	}
	
}
