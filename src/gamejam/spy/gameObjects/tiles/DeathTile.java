package gamejam.spy.gameObjects.tiles;

import gamejam.spy.SpyGame;

public class DeathTile extends Tile {
	
	public void onCollide() {
		SpyGame.loadedLevel.restartLevel();
	}
	
}
