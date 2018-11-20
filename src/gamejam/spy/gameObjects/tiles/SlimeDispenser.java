package gamejam.spy.gameObjects.tiles;

import java.util.Random;

import gamejam.spy.SpyGame;
import gamejam.spy.Vector;
import gamejam.spy.gameObjects.entities.FallingSlime;

public class SlimeDispenser extends Tile {
	
	public float chance = 0.01f;
	
	public void tick() {
		Random rand = new Random();
		if(rand.nextFloat() < chance) {
			FallingSlime slime = new FallingSlime();
			slime.position = this.gridPosition.copy().scale(parentGrid.tileSize).translate(0,34);
			slime.setDimensions(new Vector(4,4));
			slime.setTextureKey("Drop");
			SpyGame.loadedLevel.addEntity(slime);
		}
	}
	
	public SlimeDispenser setChance(float f) {
		chance = f;
		return this;
	}

}
