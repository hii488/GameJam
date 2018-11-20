package gamejam.spy.gameObjects.tiles;

import java.util.Random;

import gamejam.spy.SpyGame;
import gamejam.spy.Vector;
import gamejam.spy.gameObjects.entities.FallingSlime;

public class NoteDispenser extends Tile {
	
	public float chance = 0.01f;
	
	public void tick() {
		Random rand = new Random();
		if(rand.nextFloat() < chance) {
			FallingSlime note = new FallingSlime();
			note.position = this.gridPosition.copy().scale(parentGrid.tileSize).translate(0,34);
			note.setDimensions(new Vector(4,4));
			note.setTextureKey("Drop");
			SpyGame.loadedLevel.addEntity(note);
		}
	}
	
	public NoteDispenser setChance(float f) {
		chance = f;
		return this;
	}

}
