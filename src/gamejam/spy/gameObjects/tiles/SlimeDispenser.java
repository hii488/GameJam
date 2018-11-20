package gamejam.spy.gameObjects.tiles;

import java.util.Random;

import gamejam.spy.SpyGame;
import gamejam.spy.Vector;
import gamejam.spy.gameObjects.entities.FallingSlime;

public class SlimeDispenser extends Tile {
	
	public void tick() {
		Random rand = new Random();
		if(rand.nextFloat() < 0.01) {
			FallingSlime slime = new FallingSlime();
			slime.position = this.gridPosition.copy().scale(parentGrid.tileSize).translate(0,34);
			slime.setDimensions(new Vector(4,4));
			slime.setTextureKey("slime");
			SpyGame.loadedLevel.addEntity(slime);
		}
	}

}
