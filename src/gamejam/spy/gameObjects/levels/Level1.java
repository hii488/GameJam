package gamejam.spy.gameObjects.levels;

import gamejam.spy.SpyGame;
import gamejam.spy.Vector;
import gamejam.spy.gameObjects.Level;
import gamejam.spy.gameObjects.entities.Camera;
import gamejam.spy.gameObjects.entities.Player;
import gamejam.spy.gameObjects.tiles.Tile;

public class Level1 extends Level {
	
	public Level1(){
		super();
		music = "SPY1_INTRO.mp3";
		
		// Walls
		for(int i = 0; i < 24; i++) {
			this.addTile(new Tile(), new Vector(-1, i));
			this.addTile(new Tile(), new Vector(31, i));
		}
		
		
		// Floor
		for(int i = 0; i < 31; i++) {
			addTile(new Tile(), new Vector(i, 24));
		}
		
		// Ramp thing
		addTile(new Tile(), new Vector(6, 23));
		addTile(new Tile(), new Vector(7, 23));
		addTile(new Tile(), new Vector(7, 22));
		addTile(new Tile(), new Vector(8, 23));
		addTile(new Tile(), new Vector(8, 22));
		addTile(new Tile(), new Vector(8, 21));
		
		// Opposite Ramp thing
		addTile(new Tile(), new Vector(18, 23));
		addTile(new Tile(), new Vector(17, 23));
		addTile(new Tile(), new Vector(17, 22));
		addTile(new Tile(), new Vector(16, 23));
		addTile(new Tile(), new Vector(16, 22));
		addTile(new Tile(), new Vector(16, 21));
		
		
		
		//Entities
		addEntity(new Player());
		
		Camera c = new Camera();
		c.setPosition(24 * 32,  18 * 32);
		addEntity(c);
	}
	
	public void restartLevel() {
		System.out.println("restarting");
		SpyGame.loadedLevel = new Level1();
	}
	
	public void nextLevel() {
		System.out.println("next level");
	}
	
}
