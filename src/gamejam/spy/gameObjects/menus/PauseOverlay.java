package gamejam.spy.gameObjects.menus;

import gamejam.spy.SpyGame;
import gamejam.spy.gameObjects.Level;
import gamejam.spy.gameObjects.entities.ButtonEntity;

public class PauseOverlay {
	
	public static ButtonEntity continueButton;
	public static ButtonEntity quitButton;
	
	public static void createOverlay() {
		continueButton = new ButtonEntity() {
			public void onClick() {
				SpyGame.paused = false;
				SpyGame.loadedLevel.entities.remove(this);
				SpyGame.loadedLevel.entities.remove(quitButton);
			}
		};
		
		quitButton = new ButtonEntity() {
			public void onClick() {
				System.exit(0);
			}
		};
	}
	
}
