package gamejam.spy.gameObjects.menus;

import gamejam.spy.SpyGame;
import gamejam.spy.gameObjects.Level;
import gamejam.spy.gameObjects.entities.ButtonEntity;

public class PauseOverlay {
	
	public static ButtonEntity continueButton;
	public static ButtonEntity quitButton;
	
	public static void createOverlay() {
		continueButton = new ButtonEntity() {
			Level l;
			
			public void setLevel(Level lev) {
				l = lev;
			}
			
			public void onClick() {
				SpyGame.paused = false;
			}
		};
		
		quitButton = new ButtonEntity() {
			
		};
	}
	
}
