package gamejam.spy;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class TextureMap {
	
	public static HashMap<String, Image> map = new HashMap<String, Image>();
	
	static {
		loadTexture("textures/error.png", "errorImage");
	}
	
	public static void addTexture(String key, Image texture) {
		map.put(key, texture);
	}
	
	public static Image getTexture(String key) {
		return map.containsKey(key) ? map.get(key) : map.get("errorImage");
	}
	
	public static void loadTexture(String path, String key) {
		try {
			BufferedImage i = ImageIO.read(TextureMap.class.getClassLoader().getResourceAsStream(path));
			map.put(key, i);
		} catch (IOException e) {
			System.out.println("Failed to load image: " + path + " :: " + key);
			e.printStackTrace();
		}
	}
	
}
