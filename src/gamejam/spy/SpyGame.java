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
		TextureMap.loadTexture("resources/textures/Player/Original/Player.png", "player");
		TextureMap.loadTexture("resources/textures/Player/Original/PlayerRunning1.png", "playerRunning1");
		TextureMap.loadTexture("resources/textures/Player/Original/PlayerRunning2.png", "playerRunning2");
		TextureMap.loadTexture("resources/textures/Player/Original/PlayerRunning3.png", "playerRunning3");
		TextureMap.loadTexture("resources/textures/Player/Original/PlayerRunning4.png", "playerRunning4");
		TextureMap.loadTexture("resources/textures/Player/Original/PlayerRunning5.png", "playerRunning5");
		TextureMap.loadTexture("resources/textures/Player/Original/PlayerRunning6.png", "playerRunning6");
		TextureMap.loadTexture("resources/textures/Player/Original/PlayerRunning7.png", "playerRunning7");
		TextureMap.loadTexture("resources/textures/Player/Original/PlayerJumping.png", "playerJumping");
		
		TextureMap.loadTexture("resources/textures/Player/BlueHat/PlayerBlueHat.png", "playerBlueHat");
		TextureMap.loadTexture("resources/textures/Player/BlueHat/PlayerBlueHatRunning1.png", "playerBlueHatRunning1");
		TextureMap.loadTexture("resources/textures/Player/BlueHat/PlayerBlueHatRunning2.png", "playerBlueHatRunning2");
		TextureMap.loadTexture("resources/textures/Player/BlueHat/PlayerBlueHatRunning3.png", "playerBlueHatRunning3");
		TextureMap.loadTexture("resources/textures/Player/BlueHat/PlayerBlueHatRunning4.png", "playerBlueHatRunning4");
		TextureMap.loadTexture("resources/textures/Player/BlueHat/PlayerBlueHatRunning5.png", "playerBlueHatRunning5");
		TextureMap.loadTexture("resources/textures/Player/BlueHat/PlayerBlueHatRunning6.png", "playerBlueHatRunning6");
		TextureMap.loadTexture("resources/textures/Player/BlueHat/PlayerBlueHatRunning7.png", "playerBlueHatRunning7");
		TextureMap.loadTexture("resources/textures/Player/BlueHat/PlayerBlueHatJumping.png", "playerBlueHatJumping");
		
		TextureMap.loadTexture("resources/textures/Player/SantaHat/PlayerSantaHat.png", "playerSantaHat");
		TextureMap.loadTexture("resources/textures/Player/SantaHat/PlayerSantaHatRunning1.png", "playerSantaHatRunning1");
		TextureMap.loadTexture("resources/textures/Player/SantaHat/PlayerSantaHatRunning2.png", "playerSantaHatRunning2");
		TextureMap.loadTexture("resources/textures/Player/SantaHat/PlayerSantaHatRunning3.png", "playerSantaHatRunning3");
		TextureMap.loadTexture("resources/textures/Player/SantaHat/PlayerSantaHatRunning4.png", "playerSantaHatRunning4");
		TextureMap.loadTexture("resources/textures/Player/SantaHat/PlayerSantaHatRunning5.png", "playerSantaHatRunning5");
		TextureMap.loadTexture("resources/textures/Player/SantaHat/PlayerSantaHatRunning6.png", "playerSantaHatRunning6");
		TextureMap.loadTexture("resources/textures/Player/SantaHat/PlayerSantaHatRunning7.png", "playerSantaHatRunning7");
		TextureMap.loadTexture("resources/textures/Player/SantaHat/PlayerSantaHatJumping.png", "playerSantaHatJumping");

		TextureMap.loadTexture("resources/textures/Player/ScubaMask/PlayerScubaMask.png", "playerScubaMask");
		TextureMap.loadTexture("resources/textures/Player/ScubaMask/PlayerScubaMaskRunning1.png", "playerScubaMaskRunning1");
		TextureMap.loadTexture("resources/textures/Player/ScubaMask/PlayerScubaMaskRunning2.png", "playerScubaMaskRunning2");
		TextureMap.loadTexture("resources/textures/Player/ScubaMask/PlayerScubaMaskRunning3.png", "playerScubaMaskRunning3");
		TextureMap.loadTexture("resources/textures/Player/ScubaMask/PlayerScubaMaskRunning4.png", "playerScubaMaskRunning4");
		TextureMap.loadTexture("resources/textures/Player/ScubaMask/PlayerScubaMaskRunning5.png", "playerScubaMaskRunning5");
		TextureMap.loadTexture("resources/textures/Player/ScubaMask/PlayerScubaMaskRunning6.png", "playerScubaMaskRunning6");
		TextureMap.loadTexture("resources/textures/Player/ScubaMask/PlayerScubaMaskRunning7.png", "playerScubaMaskRunning7");
		TextureMap.loadTexture("resources/textures/Player/ScubaMask/PlayerScubaMaskJumping.png", "playerScubaMaskJumping");
		
		TextureMap.loadTexture("resources/textures/SCENE1.png", "SCENE1");
		TextureMap.loadTexture("resources/textures/box.png", "box");
		
		TextureMap.loadTexture("resources/textures/SCENE2.png", "SCENE2");
		TextureMap.loadTexture("resources/textures/SpikeL.png", "SpikeL");
		TextureMap.loadTexture("resources/textures/SpikeR.png", "SpikeR");
		
		TextureMap.loadTexture("resources/textures/SCENE3.png", "SCENE3");
		TextureMap.loadTexture("resources/textures/Drop.png", "Drop");
		
		

		
		TextureMap.loadTexture("resources/textures/slime.png", "slime");
		TextureMap.loadTexture("resources/textures/ice.png", "ice");
		TextureMap.loadTexture("resources/textures/camera-green.png", "cameraGreen");
		TextureMap.loadTexture("resources/textures/camera-red.png", "cameraRed");
		TextureMap.loadTexture("resources/textures/industrial.v2.png", "industrial");
		TextureMap.loadTexture("resources/textures/skill-desc_0003_bg-1.png", "background1");
		TextureMap.loadTexture("resources/textures/hats/cap.png", "cap");
		TextureMap.loadTexture("resources/textures/hats/scuba mask.png", "scuba");
		TextureMap.loadTexture("resources/textures/hats/xmas-hat.png", "xmas");
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
				tick();
				
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
