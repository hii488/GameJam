package gamejam.spy.gameObjects.collision;

import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;

public class Lamina2D {
	private ArrayList<Vertex> vertices = new ArrayList<Vertex>();
	public boolean
	canMove = false,
	immovable;
	
	public Lamina2D(ArrayList<Vertex> vertices, boolean immovable){
		this.vertices = vertices;
		this.immovable = immovable;
	}
	public int getNumVertices(){
		return vertices.size();
	}
	public ArrayList<Vertex> getAxes1(){
		ArrayList<Vertex> axes = new ArrayList<Vertex>();
		for (int i = 0; i < getNumVertices(); i++) {
			Vertex v1 = vertices.get(i);
			Vertex v2 = vertices.get(i+1 == getNumVertices() ? 0 : 1+i);
			Vertex axis = v1.getDistance(v2).getNormaltoXAxis();
			axes.add(axis);
		}
		return axes;
	}
	public ArrayList<Vertex> getAxes2(){
		ArrayList<Vertex> axes = new ArrayList<Vertex>();
		for (int i = 0; i < getNumVertices(); i++) {
			Vertex v1 = vertices.get(i);
			Vertex v2 = vertices.get(i+1 == getNumVertices() ? 0 : 1+i);
			Vertex axis = v1.getDistance(v2).getNormaltoYAxis();
			axes.add(axis);
		}
		return axes;
	}
	private Projection project(Vertex axis){
		double min = axis.dot(vertices.get(0));
		double max = min;
		for (Vertex v : vertices) {
			double p = axis.dot(v);
			if (p < min) {
				min = p;
			}else if (p > max){
				max = p;
			}
		}
		return new Projection(min, max);
	}

	public boolean isTouching(Lamina2D l2){
		ArrayList<Vertex> axes1 = getAxes1();
		for (Vertex axis : axes1) {
			Projection p1 = project(axis);
			Projection p2 = l2.project(axis);
			if (!p1.overlap(p2)) {
				return false;
			}
		}
		ArrayList<Vertex> axes2 = l2.getAxes2();
		for (Vertex axis : axes2) {
			Projection p1 = project(axis);
			Projection p2 = l2.project(axis);
			if (!p1.overlap(p2)) {
				return false;
			}
		}
		return true;
	}
	public void resolvePen(Lamina2D l2){
		double overlap = Double.POSITIVE_INFINITY;
		Vertex smallest = new Vertex(0,0);
		ArrayList<Vertex> axes1 = getAxes1();
		ArrayList<Vertex> axes2 = l2.getAxes2();
		for (Vertex axis : axes1) {
			Vertex an1 = axis.getNormalized();
			Projection p1 = project(an1);
			Projection p2 = l2.project(an1);
			if (p1.overlap(p2)) {
				double o = p1.getOverlap(p2);
				if (o < overlap) {
					overlap = o;
					smallest = an1;
				}
			}else{
				return;
			}
		}
		
		for (Vertex axis : axes2) {
			Vertex an2 = axis.getNormalized();
			Projection p1 = project(an2);
			Projection p2 = l2.project(an2);
			if (p1.overlap(p2)) {
				double o = p1.getOverlap(p2);
				if (o < overlap) {
					overlap = o;
					smallest = an2;
				}
			}else{
				return;
			}
		}
		if (immovable) {
			l2.addX(overlap*smallest.getX());
			l2.addY(overlap*smallest.getY());
		}else if (l2.immovable){
			addX(overlap*smallest.getX());
			addY(overlap*smallest.getY());
		}else{
			addX(overlap/2*smallest.getX());
			addY(overlap/2*smallest.getY());
			l2.addX(-overlap/2*smallest.getX());
			l2.addY(-overlap/2*smallest.getY());
		}
	}
	public void addX(double dx){
		for (Vertex v : vertices) {
			v.setX(v.getX()+dx);
		}
	}
	public void addY(double dy){
		for (Vertex v : vertices) {
			v.setY(v.getY()+dy);
		}
	}
	public void translate(Vertex d) {
		addX(d.getX());
		addY(d.getY());
	}
	
	public Polygon getPolygon(){
		int[] xPoints = new int[vertices.size()];
		int[] yPoints = new int[vertices.size()];
		for (int i=0 ; i < vertices.size(); i++) {
			Vertex v = vertices.get(i);
			xPoints[i] = (int) v.getX();
			yPoints[i] = (int) v.getY();
		}
		return new Polygon(xPoints, yPoints, xPoints.length);
	}

	public void render(Graphics g) {
		g.fillPolygon(getPolygon());
	}
	
	public Vertex getCentre(){
		double xSum = 0;
		double ySum = 0;
		for (Vertex v : vertices) {
			xSum += v.getX();
			ySum += v.getY();
		}
		return new Vertex(xSum/vertices.size(), ySum/vertices.size());
	}
	class Projection {
		private double
		min,
		max;
		Projection(double min, double max){
			this.min = min;
			this.max = max;
		}
		public boolean overlap(Projection p2){
			return (min <= p2.max && p2.min <= max);
		}
		public double getOverlap(Projection p2){
			return Math.abs(p2.max-min);
		}
	}
}
