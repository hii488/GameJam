package gamejam.spy;

import java.awt.Image;
import java.util.HashMap;

public class TextureMap {
	
	public static HashMap<String, Image> map = new HashMap<String, Image>();
	
	public static void addTexture(String key, Image texture) {
		map.put(key, texture);
	}
	
	public static Image getTexture(String key) {
		return map.containsKey(key) ? map.get(key) : map.get("errorImage");
	}
	
}
