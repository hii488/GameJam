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

public class Level1 extends Level {
	
	public Level1(){		
		super();
		this.backgroundImage = "SCENE1";
	//	SoundPlayer.playSound("SPY1_INTRO.wav");
		
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
		for(int i = 0; i < 31; i++) {
			addTile(new Tile().setTextureKey("box"), new Vector(i, 24));
		}
		
		// Ramp thing
		addTile(new Tile().setTextureKey("box"), new Vector(6, 23));
		addTile(new Tile().setTextureKey("box"), new Vector(7, 23));
		addTile(new Tile().setTextureKey("box"), new Vector(7, 22));
		addTile(new Tile().setTextureKey("box"), new Vector(8, 23));
		addTile(new Tile().setTextureKey("box"), new Vector(8, 22));
		addTile(new Tile().setTextureKey("box"), new Vector(8, 21));
		
		// Opposite Ramp thing
		addTile(new Tile().setTextureKey("box"), new Vector(18, 23));
		addTile(new Tile().setTextureKey("box"), new Vector(17, 23));
		addTile(new Tile().setTextureKey("box"), new Vector(17, 22));
		addTile(new Tile().setTextureKey("box"), new Vector(16, 23));
		addTile(new Tile().setTextureKey("box"), new Vector(16, 22));
		addTile(new Tile().setTextureKey("box"), new Vector(16, 21));
		
		// Level Exit
		addTile(new LevelExit().setTextureKey("box"), new Vector(30, 23));
		
		
		//Entities
		addEntity(new Player());
		
		Camera c = new Camera();
		c.setPosition(24 * 32,  18 * 32);
		c.colour = Color.yellow;
		addEntity(c);
		
		Hat h = new Hat();
		h.setPosition(12*32, 23*32);
		h.setHatID(Player.Hat.BLUE);
		h.setTextureKey("cap");
		addEntity(h);
	}
	
	public void restartLevel() {
		System.out.println("restarting");
		SpyGame.loadedLevel = new Level1();
	}
	
	public void nextLevel() {
		SpyGame.loadedLevel = new Level2();
	}
	
}
