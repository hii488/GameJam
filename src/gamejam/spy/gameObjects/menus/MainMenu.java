package gamejam.spy.gameObjects.menus;

import java.awt.Color;
import java.awt.Graphics;

import gamejam.spy.SpyGame;
import gamejam.spy.gameObjects.Level;
import gamejam.spy.gameObjects.entities.ButtonEntity;

public class MainMenu extends Level {
	
	public MainMenu() {
		super();
		
		this.canPause = false;
		
		System.out.println("in main menu");
		
		ButtonEntity start = new ButtonEntity() {
			@Override
			public void onClick() {
				// TODO: start first level.
				System.out.println("start first level");
			}
		};
		
		ButtonEntity quit = new ButtonEntity() {
			@Override
			public void onClick() {
				System.exit(0);
			}
		};
		
		start.setPosition(SpyGame.window.width/2 - 100, SpyGame.window.height/2 - 50);
		start.setDimensions(200, 30);
		start.text = "Start";
		start.color = Color.WHITE;
		
		quit.setPosition(SpyGame.window.width/2 - 90, SpyGame.window.height/2 + 25);
		quit.setDimensions(180, 30);
		quit.text = "Quit";
		quit.color = Color.WHITE;
		
		this.addEntity(start);
		this.addEntity(quit);
	}
	
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, SpyGame.window.width, SpyGame.window.height);
		
		super.render(g);
	}
	
}
