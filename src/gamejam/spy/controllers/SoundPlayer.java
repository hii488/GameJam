package gamejam.spy.controllers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class SoundPlayer {
	
	public static void playSound(String filename) {
		try {
			InputStream in = new FileInputStream("resources/music/" + filename);
			
			AudioStream as = new AudioStream(in);
			
			AudioPlayer.player.start(as);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
