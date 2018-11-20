package gamejam.spy.gameObjects.tiles;

import gamejam.spy.SpyGame;

public class LevelExit extends Tile{

	public void onCollide() {
		SpyGame.loadedLevel.nextLevel();
	}
	
}
