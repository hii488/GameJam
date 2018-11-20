package gamejam.spy.gameObjects.entities;

import gamejam.spy.SpyGame;

public class FallingSlime extends Entity{
	
	public void onCollide() {
		SpyGame.loadedLevel.restartLevel();
	}
	
	public void tick() {
		super.tick();

		lamina.addY(0.9);
		position.translate(0, 0.9);
	}
	
}
