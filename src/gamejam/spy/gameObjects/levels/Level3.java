package gamejam.spy.gameObjects.levels;

import gamejam.spy.SpyGame;
import gamejam.spy.Vector;
import gamejam.spy.gameObjects.Level;
import gamejam.spy.gameObjects.entities.Camera;
import gamejam.spy.gameObjects.entities.Hat;
import gamejam.spy.gameObjects.entities.Player;
import gamejam.spy.gameObjects.tiles.DeathTile;
import gamejam.spy.gameObjects.tiles.LevelExit;
import gamejam.spy.gameObjects.tiles.SlimeDispenser;
import gamejam.spy.gameObjects.tiles.Tile;

public class Level3 extends Level {
	
	public Level3() {
		super();

	//	SoundPlayer.playSound("SPY2_SEWER.wav");
		
		//Universal Death line
		for(int i = 0; i < 32; i++) {
			addTile(new DeathTile().setTextureKey("slime"), new Vector(i, 24));
		}
		
		// Walls
		for(int i = 0; i < 24; i++) {
			this.addTile(new Tile().setTextureKey("box"), new Vector(-1, i));
			this.addTile(new Tile().setTextureKey("box"), new Vector(31, i));
		}
		
		
		// Random floating platforms
		addTile(new Tile().setTextureKey("box"), new Vector(0, 3));
		addTile(new Tile().setTextureKey("box"), new Vector(1, 3));
		addTile(new Tile().setTextureKey("box"), new Vector(2, 3));
		
		addTile(new Tile().setTextureKey("box"), new Vector(4, 5));
		
		addTile(new Tile().setTextureKey("box"), new Vector(8, 0));
		
		addTile(new Tile().setTextureKey("box"), new Vector(9, 2));
		addTile(new Tile().setTextureKey("box"), new Vector(10, 2));
		addTile(new Tile().setTextureKey("box"), new Vector(11, 3));
		addTile(new Tile().setTextureKey("box"), new Vector(12, 2));
		
		//Slime dispensers
		addTile(new SlimeDispenser().setTextureKey("box"), new Vector(9, 3));
		addTile(new SlimeDispenser().setTextureKey("box"), new Vector(2, 3));

		addTile(new Tile().setTextureKey("box"), new Vector(12, 5));
		addTile(new Tile().setTextureKey("box"), new Vector(13, 5));
		
		addTile(new Tile().setTextureKey("box"), new Vector(6, 9));
		
		addTile(new Tile().setTextureKey("box"), new Vector(11, 9));
		
		addTile(new Tile().setTextureKey("box"), new Vector(14, 8));
		
		addTile(new Tile().setTextureKey("box"), new Vector(15, 6));
		
		addTile(new Tile().setTextureKey("box"), new Vector(17, 7));
		addTile(new Tile().setTextureKey("box"), new Vector(18, 7));
		addTile(new Tile().setTextureKey("box"), new Vector(19, 7));
		addTile(new Tile().setTextureKey("box"), new Vector(20, 7));
		addTile(new Tile().setTextureKey("box"), new Vector(21, 7));
		
		addTile(new Tile().setTextureKey("box"), new Vector(22, 6));
		addTile(new Tile().setTextureKey("box"), new Vector(23, 5));
		
		addTile(new Tile().setTextureKey("box"), new Vector(23, 2));
		addTile(new Tile().setTextureKey("box"), new Vector(23, 1));
		addTile(new Tile().setTextureKey("box"), new Vector(24, 0));
		
		// Tiles to hat
		addTile(new Tile().setTextureKey("box"), new Vector(10, 13));
		addTile(new Tile().setTextureKey("box"), new Vector(7, 15));
		addTile(new Tile().setTextureKey("box"), new Vector(5, 16));
		addTile(new Tile().setTextureKey("box"), new Vector(4, 16));
		
		addTile(new Tile().setTextureKey("box"), new Vector(1, 16));
		
		// Tiles to end
		addTile(new Tile().setTextureKey("box"), new Vector(23, 5));
		addTile(new Tile().setTextureKey("box"), new Vector(24, 5));
		addTile(new Tile().setTextureKey("box"), new Vector(25, 5));
		
		addTile(new Tile().setTextureKey("box"), new Vector(27, 23));
		addTile(new Tile().setTextureKey("box"), new Vector(27, 24));
		addTile(new Tile().setTextureKey("box"), new Vector(29, 23));
		addTile(new Tile().setTextureKey("box"), new Vector(29, 24));

		addTile(new LevelExit(), new Vector(28, 24));
		
		//Entities
		addEntity(new Player());
		
		Hat h = new Hat();
		h.setPosition(1*32, 15*32);
		h.setHatID(Player.Hat.SCUBA);
		h.setTextureKey("scuba");
		addEntity(h);
		
		Camera c = new Camera();
		c.setPosition((int) (20 * 32),  2 * 32);
		c.dist = 170;
		c.width = 25;
		
		addEntity(c);
	}
	
	@Override
	public void restartLevel() {
		System.out.println("restarting");
		SpyGame.loadedLevel = new Level3();
	}

	@Override
	public void nextLevel() {
		SpyGame.loadedLevel = new Level4();
	}

}
