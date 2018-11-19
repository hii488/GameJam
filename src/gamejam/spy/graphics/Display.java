package gamejam.spy.graphics;

import java.awt.Canvas;
import java.awt.Graphics;

import gamejam.spy.SpyGame;

@SuppressWarnings("serial")
public class Display extends Canvas{

	public Display(Window window) {
		setBounds(0, 0, window.width, window.height);
	}
	
	public void render(Graphics g){
	//	g.setColor(Settings.Texture.background);
	//	g.fillRect(0, 0, getWidth(), getHeight());
		try{
			SpyGame.loadedLevel.render(g);
		}
		catch(Exception e){
			System.err.println("Error rendering");
			e.printStackTrace();
		}
	}
	
}