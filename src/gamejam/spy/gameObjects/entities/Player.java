package gamejam.spy.gameObjects.entities;

public class Player extends Entity {
	
	public String[] textures = {"playerIdle.png", "playerRun1.png", "playerRun2.png"}; // TODO: correct this
	
	public Player() {
		super();
		this.setTextureKey(textures[0]);
	}
	
	public void tick() {
		super.tick();
		
		// Movement
		
	}
	
}
