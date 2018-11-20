package gamejam.spy.gameObjects.entities;

import java.awt.Graphics;
import java.util.ArrayList;

import gamejam.spy.Vector;
import gamejam.spy.controllers.TextureMap;
import gamejam.spy.gameObjects.collision.Lamina2D;
import gamejam.spy.gameObjects.collision.Vertex;
import gamejam.spy.interfaces.Renderable;
import gamejam.spy.interfaces.Textured;

public class Entity implements Renderable, Textured {
	
	public Vector position = new Vector(0,0);
	public String textureKey = "";
	
	public Lamina2D lamina;
	public boolean solid = false;;
	
	public Entity() {
		setDimensions(new Vector(32, 32));
	}
	
	public Entity(Vector dimensions) {
		setDimensions(dimensions);
	}
	
	public void setDimensions(Vector dimensions) {
		ArrayList<Vertex> vertices = new ArrayList<>();
		vertices.add(new Vertex(0, dimensions.getY()));
		vertices.add(new Vertex(dimensions.getX(), dimensions.getY()));
		vertices.add(new Vertex(dimensions.getX(), 0));
		vertices.add(new Vertex(0, 0));
		
		lamina = new Lamina2D(vertices, true);
		lamina.addX(position.getX());
		lamina.addY(position.getY());
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(TextureMap.getTexture(getTextureKey()), position.getIX(), position.getIY(), null);
	}

	public void tick() {}

	public Entity setPosition(int x, int y) {
		position.setLocation(x,y);
		lamina.translate(new Vertex(x,y));
		return this;
	}
	
	public Entity setTextureKey(String key) {
		textureKey = key;
		return this;
	}

	@Override
	public String getTextureKey() {
		return textureKey;
	}
	
	public Lamina2D getLamina() {
		return lamina;
	}
	
	public void onCollide() {}
	
	public boolean isSolid() {
		return solid;
	}
	
	public Entity setSolid(boolean b) {
		solid = b;
		return this;
	}
	
}
