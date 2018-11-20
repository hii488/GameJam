package gamejam.spy.gameObjects.levels;

import java.awt.Color;

import gamejam.spy.SpyGame;
import gamejam.spy.Vector;
import gamejam.spy.gameObjects.Level;
import gamejam.spy.gameObjects.entities.Camera;
import gamejam.spy.gameObjects.entities.Hat;
import gamejam.spy.gameObjects.entities.Player;
import gamejam.spy.gameObjects.tiles.DeathTile;
import gamejam.spy.gameObjects.tiles.LevelExit;
import gamejam.spy.gameObjects.tiles.Tile;

public class Level2 extends Level {

	public Level2() {
		super();
		this.backgroundImage = "SCENE2";
		music = "SPY1_INTRO.mp3";
		
		//Universal Death line
		for(int i = 0; i < 26; i++) {
			addTile(new DeathTile(), new Vector(i, 27));
		}
		
		// Walls
		for(int i = 0; i < 24; i++) {
			this.addTile(new Tile().setTextureKey("box"), new Vector(-1, i));
			this.addTile(new Tile().setTextureKey("box"), new Vector(31, i));
		}
		
		
		// Floor
		for(int i = 0; i < 9; i++) {
			addTile(new Tile().setTextureKey("box"), new Vector(i, 24));
		}
		
		// Death pit
		for(int i = 7; i < 26; i++) {
			addTile(new DeathTile().setTextureKey("box"), new Vector(i, 25));
		}
		
		// Ramp thing
		addTile(new Tile().setTextureKey("box"), new Vector(6, 23));
		addTile(new Tile().setTextureKey("box"), new Vector(7, 23));
		addTile(new Tile().setTextureKey("box"), new Vector(7, 22));
		addTile(new Tile().setTextureKey("box"), new Vector(7, 21));
		addTile(new Tile().setTextureKey("box"), new Vector(8, 23));
		addTile(new Tile().setTextureKey("box"), new Vector(8, 22));
		addTile(new Tile().setTextureKey("box"), new Vector(8, 21));
		addTile(new Tile().setTextureKey("box"), new Vector(8, 20));
		addTile(new Tile().setTextureKey("box"), new Vector(8, 19));
		
		// Middle ledges
		addTile(new Tile().setTextureKey("box"), new Vector(11, 19));
		addTile(new Tile().setTextureKey("box"), new Vector(12, 19));
		
		addTile(new Tile().setTextureKey("box"), new Vector(15, 20));
		addTile(new Tile().setTextureKey("box"), new Vector(16, 20));
		addTile(new Tile().setTextureKey("box"), new Vector(17, 20));
		addTile(new Tile().setTextureKey("box"), new Vector(18, 20));

		addTile(new Tile().setTextureKey("box"), new Vector(21, 19));
		addTile(new Tile().setTextureKey("box"), new Vector(22, 19));
		
		addTile(new Tile().setTextureKey("box"), new Vector(14, 24));
		
		// Spikes
		for(int i = 0; i < 4; i++) {
			addTile(new DeathTile().setTextureKey("SpikeL"), new Vector(24, 21 +i));
			addTile(new DeathTile().setTextureKey("SpikeR"), new Vector(28, 21 +i));
		}
		
		addTile(new LevelExit(), new Vector(26, 24));
	
		
		//Entities
		addEntity(new Player());
		
		Camera c = new Camera();
		c.setPosition((int) (16.5 * 32),  14 * 32);
		c.colour = Color.yellow;
		c.dist = 200;
		c.width = 20;
		
		addEntity(c);
		
		Hat h = new Hat();
		h.setPosition(14*32, 23*32);
		h.setHatID(Player.Hat.BLUE);
		h.setTextureKey("cap");
		addEntity(h);
		
	}
	
	@Override
	public void restartLevel() {
		System.out.println("restarting");
		SpyGame.loadedLevel = new Level2();
	}

	@Override
	public void nextLevel() {
		SpyGame.loadedLevel = new Level3();
	}

}
