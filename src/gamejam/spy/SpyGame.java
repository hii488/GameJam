package gamejam.spy;

import gamejam.spy.controllers.KeyInput;
import gamejam.spy.controllers.MouseInput;
import gamejam.spy.controllers.TextureMap;
import gamejam.spy.gameObjects.Level;
import gamejam.spy.gameObjects.levels.MainMenu;
import gamejam.spy.graphics.Window;

public class SpyGame {
	
	public static boolean running, paused, debug;
	public static Level loadedLevel;
	public static Window window;
	
	public static void main(String[] args) {
		window = new Window("Spy Game", 992, 800);
		init();
			
		gameLoop(window);
	}
	
	public static void init() {
		window.createDisplay();
		
		running = true;
		paused = false;
		debug = false;
		
		loadedLevel = new MainMenu();
		loadTextures();
	}
	
	public static void loadTextures() {
		TextureMap.loadTexture("resources/textures/Player.png", "player");
		TextureMap.loadTexture("resources/textures/PlayerRunning1.png", "playerRunning1");
		TextureMap.loadTexture("resources/textures/PlayerRunning2.png", "playerRunning2");
		TextureMap.loadTexture("resources/textures/PlayerRunning3.png", "playerRunning3");
		TextureMap.loadTexture("resources/textures/PlayerRunning4.png", "playerRunning4");
		TextureMap.loadTexture("resources/textures/PlayerRunning5.png", "playerRunning5");
		TextureMap.loadTexture("resources/textures/PlayerRunning6.png", "playerRunning6");
		TextureMap.loadTexture("resources/textures/PlayerRunning7.png", "playerRunning7");
		TextureMap.loadTexture("resources/textures/slime.png", "slime");
		TextureMap.loadTexture("resources/textures/ice.png", "ice");
		TextureMap.loadTexture("resources/textures/camera-green.png", "cameraGreen");
		TextureMap.loadTexture("resources/textures/camera-red.png", "cameraRed");
		TextureMap.loadTexture("resources/textures/industrial.v2.png", "industrial");
		TextureMap.loadTexture("resources/textures/skill-desc_0003_bg-1.png", "background1");
	}
	
	
	public static void gameLoop(Window w) {
		int tick = 0;
		
		int targetTPS = 30;
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
			while (unprocessed >= 1) {
				if(!paused) tick();
				
				tick++;
				unprocessed--;
			}
			
			// Might be best to move this into the tick thing, so that it only happens on tick.
			render(w);
			
			// If the current time is 1 second greater than the last time we printed
			if (System.currentTimeMillis() - fpsTimer >= 1000) {
				System.out.println(tick);
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
