package gamejam.spy.gameObjects.levels;

import gamejam.spy.SpyGame;
import gamejam.spy.Vector;
import gamejam.spy.gameObjects.Level;
import gamejam.spy.gameObjects.tiles.DeathTile;
import gamejam.spy.gameObjects.tiles.Tile;

public class Level4 extends Level{

	public Level4() {
		super();
		music = "SPY2_SEWER.mp3";
		
		//Universal Death line
		for(int i = 0; i < 26; i++) {
			addTile(new DeathTile(), new Vector(i, 24));
		}
		
		// Walls
		for(int i = 0; i < 24; i++) {
			this.addTile(new Tile(), new Vector(-1, i));
			this.addTile(new Tile(), new Vector(31, i));
		}
		
		addTile(new Tile(), new Vector(1, 2));
		addTile(new Tile(), new Vector(1, 3));
		
	}
	
	
	@Override
	public void restartLevel() {
		System.out.println("restarting");
		SpyGame.loadedLevel = new Level4();
	}

	@Override
	public void nextLevel() {
		// TODO Auto-generated method stub

	}
	
}
