package gamejam.spy.gameObjects.entities;

import gamejam.spy.SpyGame;

public class HorizontalProjectiles extends Entity{
	
	public float direction = 1;
	
	public void onCollide() {
		SpyGame.loadedLevel.restartLevel();
	}
	
	public void tick() {
		super.tick();

		lamina.addX(4 * direction);
		position.translate(4 * direction, 0);
	}
	
}
