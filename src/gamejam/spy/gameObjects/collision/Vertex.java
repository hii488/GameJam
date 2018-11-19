package gamejam.spy.gameObjects.collision;

public class Vertex {
	private double
	x,
	y;
	public Vertex(double x, double y){
		this.x = x;
		this.y = y;
	}
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	public void setX(double x){
		this.x = x;
	}
	public void setY(double y){
		this.y = y;
	}
	public double dot(Vertex v2){
		return getX()*v2.getX() + getY()*v2.getY(); //returns length of the projection of v2 onto this unit vector.
	}
	public double getMagnitude(){
		return Math.hypot(getX(), getY());
	}
	public Vertex getDistance(Vertex v2){
		return new Vertex(v2.getX() - getX(), v2.getY() - getY());
	}
	public Vertex getNormaltoXAxis(){
		return new Vertex(-getY(), getX());
	}
	public Vertex getNormaltoYAxis(){
		return new Vertex(getY(), -getX());
	}
	public Vertex getNormalized(){
		return new Vertex(getX()/getMagnitude(), getY()/getMagnitude());
	}
}
