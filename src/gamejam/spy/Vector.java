package gamejam.spy;

import java.awt.Rectangle;

public class Vector {
	public final static Vector ORIGIN = new Vector(0,0);
	
	private double x, y;
	
	public Vector() {
		x = 0;
		y = 0;
	}
	
	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}
	
	public int getIX() {
		return (int) x;
	}

	public int getIY() {
		return (int) y;
	}
	
	public Vector getIV() {
		return new Vector(getIX(), getIY());
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public Vector translate(Vector v) {
		x += v.x;
		y += v.y;
		return this;
	}
	
	public Vector translate(double vx, double vy) {
		x += vx;
		y += vy;
		return this;
	}
	
	public void setLocation(Vector v) {
		x = v.x;
		y = v.y;
	}
	
	public void setLocation(double vx, double vy) {
		x = vx;
		y = vy;
	}
	
	public double magnitude() {
		return this.distance(ORIGIN);
	}
	
	public double distance(Vector v) {
		return Math.sqrt(Math.pow(v.x- x, 2) + Math.pow(v.y - y, 2));
	}
	
	public double distance(double vx, double vy) {
		return Math.sqrt(Math.pow(vx- x, 2) + Math.pow(vy - y, 2));
	}
	
	public Vector getUnitVector() {
		double dist = distance(ORIGIN);
		return new Vector(x/dist, y/dist);
	}
	
	public boolean isUnitVector() {
		return distance(ORIGIN) == 1;
	}
	
	public Vector rotateRad(double radians, Vector v){
		double oldX = x, oldY = y;
		x = Math.cos(radians)*(oldX-v.x) - Math.sin(radians)*(oldY-v.y) + v.x;
		y = Math.sin(radians)*(oldX-v.x) + Math.cos(radians)*(oldY-v.y) + v.y;
		return this;
	}
	
	public Vector rotateDeg(double degrees, Vector v){
		return rotateRad(Math.PI*degrees/180, v);
	}

	public Vector rotateRad(double radians) {
		return rotateRad(radians, new Vector(0,0));
	}
	
	public Vector rotateDeg(double degrees) {
		return rotateRad(Math.PI*degrees/180);
	}
	
	/** Essentially a clone method.
	 *  
	 *  @return a copy of this vector. */
	public Vector getLocation() {
		return new Vector(x, y);
	}
	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	public Vector negated() {
		return new Vector(-x,-y);
	}
	
	public static Rectangle convertToRectangle(Vector a, Vector b){
		double x1 = a.x < b.x ? a.x : b.x, x2 = a.x > b.x ? a.x : b.x;
		double y1 = a.y < b.y ? a.y : b.y, y2 = a.y > b.y ? a.y : b.y;
		if(x2 - x1 == 0) x2 += 1;
		if(y2 - y1 == 0) y2 += 1;
		
		return new Rectangle((int) x1, (int) y1, (int) (x2-x1), (int) (y2-y1));
	}

	public Vector scale(double d) {
		x *= d;
		y *= d;
		return this;
	}
	
	public Vector scale(double dx, double dy) {
		x *= dx;
		y *= dy;
		return this;
	}
	
	public boolean equals(Object v) {
		if(!(v instanceof Vector)) return false;
		
		return ((Vector) v).x == x && ((Vector) v).y == y;
	}
	
	public int hashCode() {
		return (int) (x*61 + y*163);
	}

	//New methods:
	public Vector rightNormal(Vector v){
	    Vector rotated = new Vector(v.getY(), -v.getX());
	    return rotated;
	}
	public Vector leftNormal(Vector v){
	    Vector rotated = new Vector(-v.getY(), v.getX());
	    return rotated;
	}
	double dotV2D(Vector v1, Vector v2) {
	    return (v1.getX() * v2.getX()) + (v1.getY() * v2.getY());
	}
	double crossV2D(Vector v1, Vector v2) {
	    return (v1.getX() * v2.getY()) - (v2.getX() * v1.getY());
	}
}