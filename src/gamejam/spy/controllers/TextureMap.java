package gamejam.spy.controllers;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class TextureMap {
	
	public static HashMap<String, BufferedImage> map = new HashMap<String, BufferedImage>();
	
	static {
	//	loadTexture("textures/error.png", "errorImage");
	}
	
	public static BufferedImage getTexture(String key) {
		return map.containsKey(key) ? map.get(key) : map.get("errorImage");
	}
	
	public static void loadTexture(String path, String key) {
		try {
			BufferedImage i = ImageIO.read(new FileInputStream(path));
			map.put(key, i);
		} catch (IOException e) {
			System.out.println("Failed to load image: " + path + " :: " + key);
			e.printStackTrace();
		}
	}
	
}
