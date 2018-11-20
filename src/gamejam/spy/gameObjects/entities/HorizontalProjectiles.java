package gamejam.spy.gameObjects.entities;

import gamejam.spy.SpyGame;

public class HorizontalProjectiles extends Entity{
	
	public int direction = 1;
	
	public void onCollide() {
		SpyGame.loadedLevel.restartLevel();
	}
	
	public void tick() {
		super.tick();

		lamina.addX(2 * direction);
		position.translate(2 * direction, 0);
	}
	
}
