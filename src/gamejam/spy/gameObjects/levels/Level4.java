package gamejam.spy.gameObjects.levels;

import gamejam.spy.SpyGame;
import gamejam.spy.Vector;
import gamejam.spy.gameObjects.Level;
import gamejam.spy.gameObjects.entities.MovingPlatformVertical;
import gamejam.spy.gameObjects.entities.Player;
import gamejam.spy.gameObjects.tiles.DeathTile;
import gamejam.spy.gameObjects.tiles.LevelExit;
import gamejam.spy.gameObjects.tiles.SlimeDispenser;
import gamejam.spy.gameObjects.tiles.Tile;

public class Level4 extends Level{

	public Level4() {
		super();
		this.backgroundImage = "SCENE3";

	//	SoundPlayer.playSound("SPY2_SEWER.wav");
		
		//Universal Death line
		for(int i = 0; i < 32; i++) {
			addTile(new DeathTile().setTextureKey("slime"), new Vector(i, 24));
		}
		
		// Walls
		for(int i = 0; i < 24; i++) {
			this.addTile(new Tile(), new Vector(-1, i));
			this.addTile(new Tile(), new Vector(31, i));
		}
		
		addTile(new Tile().setTextureKey("box"), new Vector(0, 3));
		addTile(new Tile().setTextureKey("box"), new Vector(1, 3));
		addTile(new Tile().setTextureKey("box"), new Vector(2, 3));
		
		addTile(new SlimeDispenser().setChance(0.004f).setTextureKey("box"), new Vector(6, -1));
		addTile(new SlimeDispenser().setChance(0.005f).setTextureKey("box"), new Vector(9, -1));
		addTile(new SlimeDispenser().setChance(0.007f).setTextureKey("box"), new Vector(12, -1));
		addTile(new SlimeDispenser().setTextureKey("box"), new Vector(17, -1));
		addTile(new SlimeDispenser().setChance(0.007f).setTextureKey("box"), new Vector(20, -1));
		addTile(new SlimeDispenser().setChance(0.007f).setTextureKey("box"), new Vector(23, -1));
		
		addTile(new Tile().setTextureKey("box"), new Vector(18, 15));
		addTile(new Tile().setTextureKey("box"), new Vector(21, 15));
		
		addTile(new LevelExit().setTextureKey("box"), new Vector(28, 13));
		
		// Entities
		addEntity(new Player());
		
		MovingPlatformVertical mpv = new MovingPlatformVertical(32*10, 32*25);
		mpv.setPosition(32 * 5, 32 * 11);
		mpv.setTextureKey("box");
		addEntity(mpv);
		
		mpv = new MovingPlatformVertical(32*14, 32*25);
		mpv.setPosition(32 * 7, 32 * 24);
		mpv.setTextureKey("box");
		mpv.speed = 1;
		addEntity(mpv);
		
		mpv = new MovingPlatformVertical(32*12, 32*25);
		mpv.setPosition(32 * 10, 32 * 12);
		mpv.setTextureKey("box");
		mpv.speed = 0.7f;
		addEntity(mpv);
		
		mpv = new MovingPlatformVertical(32*13, 32*25);
		mpv.setPosition(32 * 14, 32 * 22);
		mpv.setTextureKey("box");
		mpv.speed = 1.2f;
		addEntity(mpv);
		

		mpv = new MovingPlatformVertical(32*13, 32*25);
		mpv.setPosition(32 * 25, 32 * 22);
		mpv.setTextureKey("box");
		mpv.speed = 1.2f;
		addEntity(mpv);
	}
	
	
	@Override
	public void restartLevel() {
		System.out.println("restarting");
		SpyGame.loadedLevel = new Level4();
	}

	@Override
	public void nextLevel() {
		SpyGame.loadedLevel = new Level5();
	}
	
}
