package gamejam.spy.controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter{
	private static final int NUM_BUTTONS = 10; //No mouse will have more than 10 buttons.
	private static final boolean[] buttons = new boolean[NUM_BUTTONS]; //Create and empty list of a large enough size to store whether or not a button is up or down for all mouse buttons.
	private static final boolean[] lastButtons = new boolean[NUM_BUTTONS];
	private static double scale = 1.00; //The scale is 1 by default.
	private static int
	x = -1,
	y = -1;
	
	public static void setScale(double newScale){
		scale = 1/newScale; //Update the scale of the mouse input for when the window is resized.
	}
	public void mousePressed(MouseEvent e){
		buttons[e.getButton()] = true; //When the mouse is pressed, store true in the buttons list at the position of the mouse button number.
	}
	public void mouseReleased(MouseEvent e) {
		buttons[e.getButton()] = false; //When the mouse is released, store true in the buttons list at the position of the mouse button number.
	}
	public void mouseMoved(MouseEvent e) {
		//When the mouse is moved, store the mouse's x and y position multiplied by the scale.
		x = (int) (e.getX()*scale); 
		y = (int) (e.getY()*scale);
	}
	public void mouseDragged(MouseEvent e) {
		//When the mouse is dragged, store the mouse's x and y position multiplied by the scale.
		x = (int) (e.getX()*scale);
		y = (int) (e.getY()*scale);
	}
	public static int getX(){
		return x;
	}
	public static int getY(){
		return y;
	}
	public static void update() {
		//Keep a record of the status of the mouse buttons in the previous tick.
		for (int i = 0; i < NUM_BUTTONS; i++){
			lastButtons[i] = buttons[i];
		}
	}
	public static boolean isDown(int button){
		return buttons[button]; //Return the status of the mouse button being checked (whether or not it is down).
	}
	public static boolean wasPressed(int button){
		return isDown(button) && !lastButtons[button]; //Return true if the mouse button is down in this tick, but wasn't down in the last tick.
	}
	public static boolean wasReleased(int button){
		return !isDown(button) && lastButtons[button]; //Return true if the mouse button isn't down in this tick, but was down in the last tick.
	}
}

