package gamejam.spy.controllers;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import gamejam.spy.interfaces.InputUser;

public class InputDistributer implements InputUser{
	
	public static InputDistributer instance = new InputDistributer();
	public static ArrayList<InputUser> inputUsers = new ArrayList<InputUser>();
	
	public static void addInputUser(InputUser i){
		if(!(i instanceof InputDistributer));
		inputUsers.add(i);
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		for(InputUser i : inputUsers) i.keyPressed(arg0);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		for(InputUser i : inputUsers) i.keyReleased(arg0);
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		for(InputUser i : inputUsers) i.keyTyped(arg0);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		for(InputUser i : inputUsers) i.mouseClicked(arg0);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		for(InputUser i : inputUsers) i.mouseEntered(arg0);
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		for(InputUser i : inputUsers) i.mouseExited(arg0);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		for(InputUser i : inputUsers) i.mousePressed(arg0);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		for(InputUser i : inputUsers) i.mouseReleased(arg0);
}


	
}
