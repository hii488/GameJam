package gamejam.spy.gameObjects.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import gamejam.spy.SpyGame;
import gamejam.spy.gameObjects.collision.Lamina2D;
import gamejam.spy.gameObjects.collision.Vertex;
import gamejam.spy.gameObjects.tiles.Tile;

public class Player extends Entity {
	
	public String[] textures = {"playerIdle.png", "playerRun1.png", "playerRun2.png"}; // TODO: correct this
	
	private Vertex pos;
	private Lamina2D lamina;
	
	public Player() {
		super();
		ArrayList<Vertex> vertices = new ArrayList<>();
		pos = new Vertex(0, 0);
		
		vertices.add(new Vertex(32, 0));
		vertices.add(pos);
		vertices.add(new Vertex(0, 64));
		vertices.add(new Vertex(32, 64));
		
		lamina = new Lamina2D(vertices, false);
		
		this.setTextureKey(textures[0]);
	}
	
	public void tick() {
		super.tick();
		Collection<Tile> tiles = SpyGame.loadedLevel.tileGrid.grid.values();
		for (Tile t : tiles) {
			lamina.resolvePen(t.getLamina());
		}
		
	}
	
}
