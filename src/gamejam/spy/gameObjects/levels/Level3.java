package gamejam.spy.gameObjects.levels;

import gamejam.spy.SpyGame;
import gamejam.spy.gameObjects.Level;

public class Level3 extends Level{

	@Override
	public void restartLevel() {
		System.out.println("restarting");
		SpyGame.loadedLevel = new Level3();
	}

	@Override
	public void nextLevel() {
		// TODO Auto-generated method stub

	}
	
}
