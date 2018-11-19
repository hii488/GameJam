package gamejam.spy.gameObjects;

import java.awt.Graphics;
import java.util.ArrayList;

import gamejam.spy.gameObjects.entities.Entity;
import gamejam.spy.interfaces.Renderable;

public class Level implements Renderable {
	
	public Grid tileGrid;
	public ArrayList<Entity> entities;
	
	public Level() {
		tileGrid = new Grid();
		entities = new ArrayList<Entity>();
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
}
