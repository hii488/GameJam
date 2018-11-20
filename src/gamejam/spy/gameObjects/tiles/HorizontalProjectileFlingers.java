package gamejam.spy.gameObjects.tiles;

import java.util.Random;

import gamejam.spy.SpyGame;
import gamejam.spy.Vector;
import gamejam.spy.gameObjects.entities.HorizontalProjectiles;

public class HorizontalProjectileFlingers extends Tile{

	public float chance = 0.01f;
	public float direction = 1;
	
	public void tick() {
		Random rand = new Random();
		if(rand.nextFloat() < chance) {
			HorizontalProjectiles slime = new HorizontalProjectiles();
			slime.position = this.gridPosition.copy().scale(parentGrid.tileSize).translate(0,34);
			slime.setDimensions(new Vector(4,4));
			slime.setTextureKey("Drop");
			slime.direction = direction;
			SpyGame.loadedLevel.addEntity(slime);
			System.out.println("added");
		}
	}
	
	public HorizontalProjectileFlingers setChance(float f) {
		chance = f;
		return this;
	}
	
	public HorizontalProjectileFlingers setdirection(float f) {
		direction = f;
		return this;
	}
	
}
