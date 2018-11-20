package gamejam.spy.gameObjects.levels;

import java.awt.Color;

import gamejam.spy.SpyGame;
import gamejam.spy.Vector;
import gamejam.spy.gameObjects.Level;
import gamejam.spy.gameObjects.entities.Camera;
import gamejam.spy.gameObjects.entities.Hat;
import gamejam.spy.gameObjects.entities.Player;
import gamejam.spy.gameObjects.entities.PowerSwitch;
import gamejam.spy.gameObjects.tiles.DeathTile;
import gamejam.spy.gameObjects.tiles.HorizontalProjectileFlingers;
import gamejam.spy.gameObjects.tiles.LevelExit;
import gamejam.spy.gameObjects.tiles.Tile;

public class Level5 extends Level{

	
	public Level5() {
		super();

	//	SoundPlayer.playSound("SPY3_FREEZER.wav");
		
		// Universal Death line
		for(int i = 0; i < 32; i++) {
			addTile(new DeathTile(), new Vector(i, 25));
		}
		
		for(int i = 0; i < 25; i++) addTile(new DeathTile().setTextureKey("SpikeL"), new Vector(i, 10));
		for(int i = 24; i < 32; i++) addTile(new DeathTile().setTextureKey("SpikeL"), new Vector(i, 17));
		
		addTile(new Tile().setTextureKey("ice"), new Vector(0, 3));
		addTile(new Tile().setTextureKey("ice"), new Vector(1, 3));
		addTile(new Tile().setTextureKey("ice"), new Vector(2, 3));
		
		// Top set
		addTile(new Tile().setTextureKey("ice"), new Vector(3, 8));
		addTile(new Tile().setTextureKey("ice"), new Vector(8, 8));
		addTile(new Tile().setTextureKey("ice"), new Vector(10, 7));
		addTile(new Tile().setTextureKey("ice"), new Vector(10, 6));
		addTile(new Tile().setTextureKey("ice"), new Vector(11, 6));
		addTile(new Tile().setTextureKey("ice"), new Vector(13, 7));
		addTile(new Tile().setTextureKey("ice"), new Vector(16, 8));
		addTile(new Tile().setTextureKey("ice"), new Vector(17, 5));
		addTile(new Tile().setTextureKey("ice"), new Vector(20, 4));
		addTile(new Tile().setTextureKey("ice"), new Vector(23, 6));
		addTile(new Tile().setTextureKey("ice"), new Vector(27, 8));
		
		// Bottom set
		addTile(new Tile().setTextureKey("ice"), new Vector(1, 20));
		addTile(new Tile().setTextureKey("ice"), new Vector(6, 18));
		addTile(new Tile().setTextureKey("ice"), new Vector(9, 20));
		addTile(new Tile().setTextureKey("ice"), new Vector(13, 18));
		addTile(new Tile().setTextureKey("ice"), new Vector(13, 17));
		addTile(new Tile().setTextureKey("ice"), new Vector(17, 20));
		addTile(new Tile().setTextureKey("ice"), new Vector(20, 18));
		addTile(new Tile().setTextureKey("ice"), new Vector(22, 16));
		addTile(new Tile().setTextureKey("ice"), new Vector(27, 16));
		addTile(new Tile().setTextureKey("ice"), new Vector(27, 22));
		addTile(new Tile().setTextureKey("ice"), new Vector(28, 22));
		addTile(new Tile().setTextureKey("ice"), new Vector(29, 22));
		addTile(new Tile().setTextureKey("ice"), new Vector(23, 22));
		addTile(new Tile().setTextureKey("ice"), new Vector(19, 22));
		
		addTile(new LevelExit().setTextureKey("ice"), new Vector(28, 21));
		
		addTile(new HorizontalProjectileFlingers().setChance(0.004f).setTextureKey("present"), new Vector(-1, 4));
		addTile(new HorizontalProjectileFlingers().setChance(0.004f).setTextureKey("present"), new Vector(-1, 5));
		addTile(new HorizontalProjectileFlingers().setChance(0.004f).setTextureKey("present"), new Vector(-1, 6));
		addTile(new HorizontalProjectileFlingers().setChance(0.004f).setTextureKey("present"), new Vector(-1, 7));
		
		// Entities
		addEntity(new Player());
		
		Camera c = new Camera();
		c.setPosition((int) (30 * 32),  18 * 32);
		c.colour = Color.BLUE;
		c.dist = 170;
		c.width = 40;
		c.direction = 0;
		c.minRot = -3;
		c.maxRot = 2;
		c.cameraSpeed = 3;
		addEntity(c);
		
		Camera c2 = new Camera();
		c2.setPosition((int) (14 * 32),  14 * 32);
		c2.colour = Color.BLUE;
		c2.dist = 170;
		c2.width = 25;
		addEntity(c2);
		
		Hat h = new Hat();
		h.setPosition(23*32, 21*32);
		h.setHatID(Player.Hat.SANTA);
		h.setTextureKey("xmas");
		addEntity(h);
		
		PowerSwitch p = new PowerSwitch();
		p.setPosition(1 * 32, 19 * 32);
		p.setTextureKey("switch");
		addEntity(p);
		
	}
	
	@Override
	public void restartLevel() {
		System.out.println("restarting");
		SpyGame.loadedLevel = new Level5();
	}

	@Override
	public void nextLevel() {
		SpyGame.loadedLevel = new Level6();
	}
	
	
	
}
