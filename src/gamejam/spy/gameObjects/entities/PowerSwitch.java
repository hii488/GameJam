package gamejam.spy.gameObjects.entities;

import gamejam.spy.SpyGame;

public class PowerSwitch extends Entity{

	public void onCollide() {
		for(Entity e : SpyGame.loadedLevel.entities) {
			if(e instanceof Camera) {
				((Camera) e).turnOff();
			}
		}
	}
	
}
