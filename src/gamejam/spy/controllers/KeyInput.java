package gamejam.spy.controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener{
	private static final int NUM_BUTTONS = 256;
	static boolean[] keys = new boolean[NUM_BUTTONS];
	static boolean[] lastKeys = keys;
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}
	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}
	public static boolean isDown(int key){
		return keys[key];
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	public static void update() {
		//Keep a record of the status of the keys in the previous tick.
		for (int i = 0; i < NUM_BUTTONS; i++){
			lastKeys[i] = keys[i];
		}
	}
	public static boolean wasPressed(int key){
		return isDown(key) && !lastKeys[key]; //Return true if the key is down in this tick, but wasn't down in the last tick.
	}
	public static boolean wasReleased(int key){
		return !isDown(key) && lastKeys[key]; //Return true if the key isn't down in this tick, but was down in the last tick.
	}

}
