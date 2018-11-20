package gamejam.spy.gameObjects.levels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import gamejam.spy.SpyGame;
import gamejam.spy.gameObjects.Level;
import gamejam.spy.gameObjects.entities.ButtonEntity;

public class MainMenu extends Level {
	
	public MainMenu() {
		super();
		
		SpyGame.deaths = 0;
		
		this.canPause = false;
		
		System.out.println("in main menu");
		
		ButtonEntity start = new ButtonEntity() {
			@Override
			public void onClick() {
				SpyGame.loadedLevel = new Level1();
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
		
		Font f = g.getFont();
		g.setColor(Color.WHITE);
		
		g.setFont(new Font("Ariel", Font.BOLD, 50));
		g.drawString("A Spy Game", SpyGame.window.width/2 - 175, 200);
		
		g.setColor(Color.BLACK);
		g.setFont(f);
		
		super.render(g);
	}
	
	public void restartLevel() {}
	public void nextLevel() {}
	
}
