package gamejam.spy.gameObjects;

import java.util.ArrayList;

import gamejam.spy.gameObjects.entities.Entity;

public class Level {
	
	public Grid tileGrid;
	public ArrayList<Entity> entities;
	
	public Level() {
		tileGrid = new Grid();
		entities = new ArrayList<Entity>();
	}
	
}
