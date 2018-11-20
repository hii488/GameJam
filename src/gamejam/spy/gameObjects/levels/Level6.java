package gamejam.spy.gameObjects.levels;

import gamejam.spy.SpyGame;
import gamejam.spy.Vector;
import gamejam.spy.gameObjects.Level;
import gamejam.spy.gameObjects.tiles.DeathTile;

public class Level6 extends Level{

	
	public Level6() {
		super();

	//	SoundPlayer.playSound("SPY4_CLUB.wav");
		
		// Universal Death line
		for(int i = 0; i < 32; i++) {
			addTile(new DeathTile(), new Vector(i, 25));
		}
		
		
		
	}
	
	@Override
	public void restartLevel() {
		System.out.println("restarting");
		SpyGame.loadedLevel = new Level6();
	}

	@Override
	public void nextLevel() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
