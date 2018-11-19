package gamejam.spy;

import gamejam.spy.controllers.KeyInput;
import gamejam.spy.controllers.MouseInput;
import gamejam.spy.gameObjects.Level;
import gamejam.spy.gameObjects.entities.Player;
import gamejam.spy.gameObjects.menus.MainMenu;
import gamejam.spy.gameObjects.tiles.Tile;
import gamejam.spy.graphics.Window;

public class SpyGame {
	
	public static boolean running, paused, debug;
	public static Level loadedLevel;
	public static Window window;
	
	public static void main(String[] args) {
		window = new Window("Spy Game", 1000, 800);
		window.createDisplay();
		
		running = true;
		paused = false;
		debug = false;
		
		loadedLevel = new MainMenu();
		
		gameLoop(window);
	}
	
	public void init() {
		Level l = new Level();
		l.addEntity(new Player());
		l.addTile(new Tile(), new Vector(2, 2));
	}
	
	public static void gameLoop(Window w) {
		int tick = 0;
		
		int targetTPS = 60;
		
		double fpsTimer = System.currentTimeMillis();
		double secondsPerTick = 1D / targetTPS;
		double nsPerTick = secondsPerTick * 1000000000D;
		double then = System.nanoTime();
		double now;
		double unprocessed = 0;
		
		while(running) {
			now = System.nanoTime();
			unprocessed += (now - then) / nsPerTick;
			then = now;
			if (unprocessed >= 1) {
				if(!paused) tick();
				
				tick++;
				unprocessed--;
			}
			
			// Might be best to move this into the tick thing, so that it only happens on tick.
			render(w);
			
			// If the current time is 1 second greater than the last time we printed
			if (System.currentTimeMillis() - fpsTimer >= 1000) {
				tick = 0;
				fpsTimer += 1000;
				
				if(debug) System.out.println("TPS: " + tick);
			}
			
			// This is NOT to sleep, but to limit the game loop
			try { 
				if(unprocessed > 2) Thread.sleep(1);
				else Thread.sleep(5); 
			} catch (InterruptedException e) {e.printStackTrace();}
		}
	}
	
	public static void tick() {
		loadedLevel.tick();
		KeyInput.update();
		MouseInput.update();
	}
	
	public static void render(Window w) {
		w.render();
	}
	
}
