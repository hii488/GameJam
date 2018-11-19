package gamejam.spy.graphics;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import com.sun.glass.events.KeyEvent;

import gamejam.spy.controllers.KeyInput;
import gamejam.spy.gameObjects.collision.Lamina2D;
import gamejam.spy.gameObjects.collision.Vertex;

@SuppressWarnings("serial")
public class Display extends Canvas{
	public Lamina2D player;
	public List<Lamina2D> terrain = new ArrayList<>();
	public Display(Window window) {
		setBounds(0, 0, window.width, window.height);
		ArrayList<Vertex> vertices1 = new ArrayList<Vertex>();
		ArrayList<Vertex> vertices2 = new ArrayList<Vertex>();
		ArrayList<Vertex> vertices3 = new ArrayList<Vertex>();
		vertices1.add(new Vertex(200,100));
		vertices1.add(new Vertex(200,200));
		vertices1.add(new Vertex(100,200));
		vertices1.add(new Vertex(100,100));
		vertices2.add(new Vertex(200,100));
		vertices2.add(new Vertex(200,200));
		vertices2.add(new Vertex(100,200));
		vertices3.add(new Vertex(200,100));
		vertices3.add(new Vertex(200,200));
		vertices3.add(new Vertex(100,200));
		vertices3.add(new Vertex(100,100));
		player = new Lamina2D(vertices1, false);
		terrain.add(new Lamina2D(vertices2, true));
		terrain.add(new Lamina2D(vertices3, true));
		
		terrain.get(1).translate(new Vertex(100, 100));
		//p1.translate(new Vector(200, 200));
	}
	
	public void render(Graphics g){
	//	g.setColor(Settings.Texture.background);
	//	g.fillRect(0, 0, getWidth(), getHeight());
		try{
			//SpyGame.loadedLevel.render(g);
			player.render(g);
			for (Lamina2D p : terrain) {
				p.render(g);
			}
			if (KeyInput.isDown(KeyEvent.VK_D)) {
				player.addX(10);
			}
			if (KeyInput.isDown(KeyEvent.VK_A)) {
				player.addX(-10);
			}
			if (KeyInput.isDown(KeyEvent.VK_W)) {
				player.addY(-10);
			}
			if (KeyInput.isDown(KeyEvent.VK_S)) {
				player.addY(10);
			}
			
			for (Lamina2D p : terrain) {
				player.resolvePen(p);
			}
			
		}
		catch(Exception e){
			System.err.println("Error rendering");
			e.printStackTrace();
		}
	}
	
}