package gamejam.spy.gameObjects;

import java.util.List;

import gamejam.spy.Vector;

public class Polygon extends java.awt.Polygon {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Vector> vertices;
	private int size;
	private double area;
	
	public Polygon(List<Vector> vertices){
		this.vertices = vertices;
		this.size = vertices.size();
		this.area = getArea();
	}
	
	private double getArea() {
	    double area = 0;
	    int j = size - 1;
	    for (int i = 0; i < size; i ++) {
	        Vector v1 = vertices.get(i);
	        Vector v2 = vertices.get(j);
	        double x1 = v1.getX();
	        double y1 = v1.getY();
	        double x2 = v1.getX();
	        double y2 = v1.getY();
	        j = i;
	        area += (x1 + x2) * (y1 - y2);
	    }
	    return area / 2;
	}
	
	private Vector getCentroid() {
	    double xSum = 0;
	    double ySum = 0;
	    int j = size - 1;
	    for (int i = 0; i < size; i ++) {
	        Vector v1 = vertices.get(i);
	        Vector v2 = vertices.get(j);
	        double x1 = v1.getX();
	        double y1 = v1.getY();
	        double x2 = v1.getX();
	        double y2 = v1.getY();
	        xSum += ((x1 + x2) * (x1 * y2 - x2 * y1));
	        ySum += ((y1 + y2) * (x1 * y2 - x2 * y1));
	        j = i;
	    }
	    double divisor = 6 * area;
	    Vector centroid = new Vector(xSum/divisor, ySum/divisor);
	    return centroid;
	}
	
	public void rotate(double angle) {
		Vector centroid = getCentroid();
		for (Vector v : vertices) {
			v.rotateRad(angle, centroid);
		}
	}
	
	private class Projection {
		private double min, max;
		public Projection(double min, double max) {
			this.min = min;
			this.max = max;
		}
		public double getMin() {
			return this.min;
		}
		public double getMax() {
			return this.max;
		}
	}
	
	/** TODO:
	Rectangle getAABB() {
	    Rectangle aabb;
	    aabb.x = getMin(p->xs, p->size);
	    aabb.y = getMin(p->ys, p->size);
	    aabb.w = getMax(p->xs, p->size) - aabb.x;
	    aabb.h = getMax(p->ys, p->size) - aabb.y;
	    return aabb;
	}
	*/
	
	
}
