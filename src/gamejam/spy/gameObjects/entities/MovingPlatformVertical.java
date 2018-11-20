package gamejam.spy.gameObjects.entities;

public class MovingPlatformVertical extends Entity{
	
	public int highestPoint, lowestPoint;
	private int movementState = 1;
	public float speed = 0.3f;
	
	public MovingPlatformVertical(int highestPoint, int lowestPoint) {
		super();
		
		this.highestPoint = highestPoint;
		this.lowestPoint = lowestPoint;
		this.solid = true;
	}
	
	public void tick() {
		this.lamina.addY(speed * movementState);
		this.position.translate(0, speed * movementState);
		
		if(movementState < 0 && position.getIY() <= highestPoint) movementState = 1;
		if(movementState > 0 && position.getIY() >= lowestPoint) movementState = -1;
	}
	
	
	
}
