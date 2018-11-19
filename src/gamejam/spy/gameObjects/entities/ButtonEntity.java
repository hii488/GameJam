package gamejam.spy.gameObjects.entities;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import gamejam.spy.Vector;
import gamejam.spy.controllers.MouseInput;

public class ButtonEntity extends Entity{
	
	public Vector dimensions = new Vector(10,10);
	public String text;
	public Color color = Color.BLACK;
	
	public void setText(String t) {
		text = t;
	}
	
	public void setDimensions(int x, int y) {
		dimensions.setLocation(x, y);
	}
	
	public void tick() {
		if(MouseInput.wasReleased(MouseEvent.BUTTON1)) {
			Vector mouse = new Vector(MouseInput.getX()-position.getX(), MouseInput.getY() - position.getY());
			System.out.println(mouse.toString() + "::" + MouseInput.getX() + ", " + MouseInput.getY());
			if((mouse.getIX() >= 0 && mouse.getIX() <= dimensions.getIX()) && (mouse.getIY() >= 0 && mouse.getIY() <= dimensions.getIY())) {
				System.out.println("onclick2");
				onClick();
			}
		}
	}
	
	public void onClick() {}
	
	public void render(Graphics g) {
		Color c = g.getColor();
		g.setColor(color);
		
		FontMetrics metrics = g.getFontMetrics(g.getFont());
		
		String[] s = text.replace("\t", "    ").split("\n");
		int x,y;
		
		for(int i = 0; i < s.length; i++){
			x = position.getIX() + (dimensions.getIX() - metrics.stringWidth(s[i])) / 2;
			
			y = position.getIY() + ((dimensions.getIY() - metrics.getHeight()) / 2) + ((i-s.length/2) * metrics.getHeight()) + metrics.getAscent();
			g.drawString(s[i], x, y);
		}
		
		g.drawRect(position.getIX(), position.getIY(), dimensions.getIX(), dimensions.getIY());
		
		g.setColor(c);
	}
	
}
