package gamejam.spy.gameObjects.levels;

import gamejam.spy.SpyGame;
import gamejam.spy.Vector;
import gamejam.spy.gameObjects.Level;
import gamejam.spy.gameObjects.entities.Camera;
import gamejam.spy.gameObjects.entities.Hat;
import gamejam.spy.gameObjects.entities.MovingPlatformVertical;
import gamejam.spy.gameObjects.entities.Player;
import gamejam.spy.gameObjects.tiles.DeathTile;
import gamejam.spy.gameObjects.tiles.HorizontalProjectileFlingers;
import gamejam.spy.gameObjects.tiles.LevelExit;
import gamejam.spy.gameObjects.tiles.NoteDispenser;
import gamejam.spy.gameObjects.tiles.Tile;

public class Level6 extends Level{

	
	public Level6() {
		super();

	//	SoundPlayer.playSound("SPY4_CLUB.wav");
		
		// Universal Death line
		for(int i = 0; i < 32; i++)	addTile(new DeathTile().setTextureKey("SpikeL"), new Vector(i, 25));
		for(int i = 0; i < 20; i++) addTile(new DeathTile().setTextureKey("SpikeL"), new Vector(6, i));
		for(int i = 5; i < 24; i++) addTile(new DeathTile().setTextureKey("SpikeL"), new Vector(11, i));
		for(int i = 11; i < 26; i++) addTile(new DeathTile().setTextureKey("SpikeL"), new Vector(i, 5));
		for(int i = 5; i < 20; i++) addTile(new DeathTile().setTextureKey("SpikeL"), new Vector(26, i));
		
		addTile(new Tile().setTextureKey("box"), new Vector(0, 3));
		addTile(new Tile().setTextureKey("box"), new Vector(1, 3));
		addTile(new Tile().setTextureKey("box"), new Vector(2, 3));
		
		addTile(new Tile().setTextureKey("box"), new Vector(4, 6));
		addTile(new Tile().setTextureKey("box"), new Vector(1, 9));
		addTile(new Tile().setTextureKey("box"), new Vector(3, 10));
		addTile(new Tile().setTextureKey("box"), new Vector(2, 12));
		addTile(new Tile().setTextureKey("box"), new Vector(0, 14));
		addTile(new Tile().setTextureKey("box"), new Vector(3, 14));
		addTile(new Tile().setTextureKey("box"), new Vector(2, 17));
		addTile(new Tile().setTextureKey("box"), new Vector(4, 19));
		addTile(new Tile().setTextureKey("box"), new Vector(1, 21));
		addTile(new Tile().setTextureKey("box"), new Vector(2, 22));
		addTile(new Tile().setTextureKey("box"), new Vector(3, 24));
		addTile(new Tile().setTextureKey("box"), new Vector(6, 23));
		addTile(new Tile().setTextureKey("box"), new Vector(8, 24));
		
		addTile(new Tile().setTextureKey("box"), new Vector(11, 3));
		addTile(new Tile().setTextureKey("box"), new Vector(14, 2));
		addTile(new Tile().setTextureKey("box"), new Vector(16, 4));
		addTile(new Tile().setTextureKey("box"), new Vector(19, 3));
		addTile(new Tile().setTextureKey("box"), new Vector(20, 2));
		addTile(new Tile().setTextureKey("box"), new Vector(24, 3));
		addTile(new Tile().setTextureKey("box"), new Vector(28, 2));
		
		addTile(new Tile().setTextureKey("box"), new Vector(26, 24));
		addTile(new Tile().setTextureKey("box"), new Vector(21, 23));
		addTile(new Tile().setTextureKey("box"), new Vector(16, 24));
		addTile(new Tile().setTextureKey("box"), new Vector(13, 22));
		addTile(new Tile().setTextureKey("box"), new Vector(12, 20));
		
		addTile(new Tile().setTextureKey("box"), new Vector(17, 10));
		addTile(new Tile().setTextureKey("box"), new Vector(18, 10));
		addTile(new Tile().setTextureKey("box"), new Vector(19, 10));
		addTile(new Tile().setTextureKey("box"), new Vector(20, 10));
		addTile(new Tile().setTextureKey("box"), new Vector(21, 10));
		
		addTile(new LevelExit().setTextureKey("box"), new Vector(19, 9));
		
		addTile(new NoteDispenser().setChance(0.003f), new Vector(1, -1));
		addTile(new NoteDispenser().setChance(0.003f), new Vector(2, -1));
		addTile(new NoteDispenser().setChance(0.003f), new Vector(3, -1));
		addTile(new NoteDispenser().setChance(0.003f), new Vector(4, -1));
		addTile(new NoteDispenser().setChance(0.003f), new Vector(5, -1));
		
		addTile(new NoteDispenser().setChance(0.001f), new Vector(8, -1));
		addTile(new NoteDispenser().setChance(0.001f), new Vector(9, -1));
		
		addTile(new NoteDispenser().setChance(0.0005f), new Vector(27, -1));
		addTile(new NoteDispenser().setChance(0.0005f), new Vector(28, -1));
		addTile(new NoteDispenser().setChance(0.0005f), new Vector(29, -1));
		addTile(new NoteDispenser().setChance(0.0005f), new Vector(30, -1));
		
		addTile(new HorizontalProjectileFlingers().setdirection(-1).setChance(0.001f), new Vector(31, 0));
		addTile(new HorizontalProjectileFlingers().setdirection(-1).setChance(0.001f), new Vector(31, 1));
		addTile(new HorizontalProjectileFlingers().setdirection(-1).setChance(0.001f), new Vector(31, 2));
		addTile(new HorizontalProjectileFlingers().setdirection(-1).setChance(0.001f), new Vector(31, 3));
		addTile(new HorizontalProjectileFlingers().setdirection(-1).setChance(0.001f), new Vector(31, 4));
		
		addTile(new HorizontalProjectileFlingers().setdirection(1).setChance(0.003f), new Vector(-1, 21));
		addTile(new HorizontalProjectileFlingers().setdirection(1).setChance(0.003f), new Vector(-1, 22));
		addTile(new HorizontalProjectileFlingers().setdirection(1).setChance(0.003f), new Vector(-1, 23));
		addTile(new HorizontalProjectileFlingers().setdirection(1).setChance(0.003f), new Vector(-1, 24));
		
		// Entities
		addEntity(new Player());
		
		Hat h = new Hat();
		h.setPosition(2*32, 2*32);
		h.setHatID(Player.Hat.BLUE);
		h.setTextureKey("cap");
		addEntity(h);
		
		
		Camera c2 = new Camera();
		c2.setPosition((int) (16 * 32),  0);
		c2.dist = 170;
		c2.width = 25;
	//	addEntity(c2);
		

		MovingPlatformVertical mpv = new MovingPlatformVertical(32*17, 32*23);
		mpv.setPosition(32 * 8, 32 * 18);
		mpv.setTextureKey("box");
		mpv.speed = 1.3f;
		addEntity(mpv);
		
		mpv = new MovingPlatformVertical(32*10, 32*16);
		mpv.setPosition(32 * 9, 32 * 18);
		mpv.setTextureKey("box");
		mpv.speed = 1.5f;
		addEntity(mpv);
		
		mpv = new MovingPlatformVertical(32*5, 32*10);
		mpv.setPosition(32 * 8, 32 * 13);
		mpv.setTextureKey("box");
		mpv.speed = 1.8f;
		addEntity(mpv);
		
		mpv = new MovingPlatformVertical(32*11, 32*18);
		mpv.setPosition(32 * 14, 32 * 14);
		mpv.setTextureKey("box");
		mpv.speed = 1.3f;
		addEntity(mpv);
		
	}
	
	@Override
	public void restartLevel() {
		System.out.println("restarting");
		SpyGame.loadedLevel = new Level6();
	}

	@Override
	public void nextLevel() {
		SpyGame.loadedLevel = new MainMenu();
	}
	
	
	
}
