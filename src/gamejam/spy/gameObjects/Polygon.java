package gamejam.spy.gameObjects;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import gamejam.spy.Vector;

public class Polygon {
	Vector NOTHING = new Vector(0, 0);
	private List<Vector> vertices;
	private int numVertices;
	private double area;
	
	public Polygon(List<Vector> vertices) {
		this.vertices = vertices;
		this.numVertices = vertices.size();
	}
	
	//Utilities:
	/*
	double getMax(double *ns, int size) {
	    //Returns the largest integer from a list of integers.
	    int max = (int) ns[0];
	    for (int i = 0; i < size; i ++) {
	        if ((int) ns[i] > max) max = (int) ns[i];
	    }
	    return max;
	}
	double getMin(double ns, int size) {
	    //Returns the smallest integer from a list of integers.
	    int min =  (int) ns[0];
	    for (int i = 0; i < size; i ++) {
	        if ((int) ns[i] < min) min = (int) ns[i];
	    }
	    return min;
	}*/

	Vector getCentroid() {
	    double xSum = 0;
	    double ySum = 0;
	    int j = numVertices - 1;
	    for (int i = 0; i < numVertices; i ++) {
	        Vector v1 = vertices.get(i);
	        Vector v2 = vertices.get(j);
	        double x1 = v1.getX();
	        double y1 = v1.getY();
	        double x2 = v2.getX();
	        double y2 = v2.getY();
	        xSum += ((x1 + x2) * (x1 * y2 - x2 * y1));
	        ySum += ((y1 + y2) * (x1 * y2 - x2 * y1));
	        j = i;
	    }
	    double divisor = 6 * area;
	    Vector centroid = new Vector(xSum/divisor, ySum/divisor);
	    return centroid;
	}
	Rectangle getAABB(Polygon p) {
	    Rectangle aabb = new Rectangle();
	    aabb.x = getMin(p->xs, p->size);
	    aabb.y = getMin(p->ys, p->size);
	    aabb.w = getMax(p->xs, p->size) - aabb.x;
	    aabb.h = getMax(p->ys, p->size) - aabb.y;
	    return aabb;
	}
	
	public static Polygon newRegularPolygon(int size, double radius, double startX, double startY) {
		List<Vector> vertices = new ArrayList<>();

	    double angle = (2 * Math.PI) / (double) size;
	    boolean oddSides = (size % 2 != 0);
	    for (int i = 0; i < size; i ++) {
	        double k = oddSides ? (double) i - 0.25 : (double) i + 0.5;
	        double x = radius * Math.cos(angle * k) + startX;
	        double y = radius * Math.sin(angle * k) + startY;
	        vertices.add(new Vector(x, y));
	    }


	    return newPolygon(size, c, xs, ys);
	}

	//Constructors:
	Polygon *newPolygon(int size, Colour c, double xs[size], double ys[size]) {
	    Polygon *p = malloc(sizeof(Polygon));
	    p->size = size;
	    p->colour = c;

	    p->xs = malloc(size*sizeof(double));
	    p->ys = malloc(size*sizeof(double));
	    for (int i = 0; i < size; i ++) {
	        p->xs[i] = xs[i];
	        p->ys[i] = ys[i];
	    }

	    getArea(p);
	    return p;
	}
	static Nodes *newNodes(int size) {
	    Nodes *nodes = malloc(sizeof(Nodes));
	    nodes->xs = malloc(size * sizeof(double));
	    return nodes;
	}

	//Drawing:
	static Nodes *getDrawList(Polygon *p, int y) {
	    //Get all the points that lie on the polygon at a given y value.
	    double *xs = p->xs;
	    double *ys = p->ys;
	    int j = p->size-1;
	    int count = 0;

	    //Initialise an empty set of nodes.
	    Nodes *nodes = newNodes(p->size);

	    //Iterate over all of the polygons edges.
	    for (int i = 0; i < p->size; i ++) {
	        if ((ys[i] < y && ys[j] >= y) || (ys[j] < y && ys[i] >= y)) {
	            //If the line through y intercects the edge, then record the the x coordinate of the intercept.
	            double x = (xs[i] + (y - ys[i])/(ys[j]-ys[i]) * (xs[j]-xs[i]));
	            nodes->xs[count] = x;
	            count ++; //Count the number of nodes
	        }
	        j = i;
	    }
	    nodes->size = count;

	    //Perform a bubble sort on the nodes. We want the nodes to be ordered as it is the space between each consecutive pair of ordered nodes that we need to fill.
	    int numSwaps = 1;
	    while (numSwaps != 0) {
	        numSwaps = 0;
	        for (int i = 0; i < nodes->size-1; i ++) {
	            if (nodes->xs[i] > nodes->xs[i+1]) {
	                int temp = nodes->xs[i];
	                nodes->xs[i] = nodes->xs[i+1];
	                nodes->xs[i+1] = temp;
	                numSwaps ++;
	            }
	        }
	    }
	    return nodes; //return the ordered nodes.
	}
	/*
	void drawAABB(Polygon *p, SDL_Renderer *renderer) {
	    SDL_Rect aabb = getAABB(p);
	    SDL_RenderDrawRect(renderer, &aabb);
	}*/
	void drawPolygon(Polygon *p, SDL_Renderer *renderer) {
	    Colour c = p->colour;
	    SDL_SetRenderDrawColor(renderer, c.r, c.g, c.b, c.a); //Set the colour of the renderer acording to the polygons colour.
	    int start = getMin(p->ys, p->size); //Gets the starting row.
	    int end = getMax(p->ys, p->size); //Get the ending row.
	    for (int y = start; y <= end; y ++) {
	        Nodes *drawList = getDrawList(p, y); //Collect all the nodes that lie on the edges of the polygon in the current row being rendered.
	        for (int i = 0; i < drawList->size-1; i += 2 ) { //Iterate over each pairs of node, as we will fill the gap between each pair.
	            int start = (int) drawList->xs[i];
	            int end = (int) drawList->xs[i+1];
	            for (int x = start; x <= end; x ++) {
	                SDL_RenderDrawPoint(renderer, x, y); //Draw all the pixels between and including the startind and ending nodes on each row.
	            }
	        }
	        free(drawList->xs);
	        free(drawList);
	    }
	}

	//Transformations:
	void movePolygon(Vector dp) {
	    for (int i = 0; i < numVertices; i ++) {
	        vertices.get(i).translate(dp);
	    }
	}
	void rotatePolygon(double angle) {
	    Vector axisOfRotation = getCentroid();
	    for (Vector v : vertices) {
	    	v.rotateRad(angle, axisOfRotation);
	    }
	}
	
	/*
	boolean aabbCollision(Polygon p2) {
	    Rectangle aabb1 = getAABB(p1);
	    Rectangle aabb2 = getAABB(p2);
	    return (aabb1.x + aabb1.w >= aabb2.x) && (aabb2.x + aabb2.w >= aabb1.x) &&
	           (aabb1.y + aabb1.h >= aabb2.y) && (aabb2.y + aabb2.h >= aabb1.y);
	}*/

	//Seperating axis:
	List<Vector> getAxes1() {
	    int size = numVertices;
	    List<Vector> axes = new ArrayList<Vector>();
	    int j = size-1;
	    for (int i = 0; i < size; i++) {
	        Vector v1 = axes.get(i);
	        Vector v2 = axes.get(j);
	        Vector edge = subtractV2D(v2, v1);
	        Vector normal = leftNormal(edge);
	        axes->vectors[i] = unitV2D(normal);
	        j = i;
	    }
	    return *axes;
	}
	List<Vector> getAxes2() {
	    List<Vector> axes = new ArrayList<>();
	    int j = numVertices - 1;
	    for (int i = 0; i < p->size; i++) {
	        Vector v1 = axes.get(i);
	        Vector v2 = axes.get(j);
	        Vector edge = v2.translate(v1.negated());
	        Vector normal = edge.rightNormal(edge);
	        axes.add(unitV2D(normal));
	        j = i;
	    }
	    return axes;
	}
	Projection project(Vector2D axis, Polygon *p){
	    Vector2D v0 = {p->xs[0], p->ys[0]};
	    double min = dotV2D(axis, v0);
	    double max = min;
	    for (int i = 0; i < p->size; i ++) {
	        Vector2D v = {p->xs[i], p->ys[i]};
	        double dp = dotV2D(axis, v);
	        if (dp < min) {
	            min = dp;
	        }else if (dp > max){
	            max = dp;
	        }
	    }
	    Projection proj = {min, max};
	    return proj;
	}
	boolean overlaps(Projection p1, Projection p2) {
	    return (p1.min <= p2.max && p2.min <= p1.max);
	}
	double getOverlap(Projection p1, Projection p2) {
	    return abs(p2.max - p1.min);
	}
	boolean colliding(Polygon p1, Polygon p2) {
	    bool colliding = aabbCollision(p1, p2);
	    if (colliding) {
	        Vector2DArray axes1 = getAxes1(p1);
	        Vector2DArray axes2 = getAxes1(p2);

	        for (int i = 0; i < axes1.size && colliding; i ++) {
	            Vector2D axis = axes1.vectors[i];
	            Projection proj1 = project(axis, p1);
	            Projection proj2 = project(axis, p2);
	            if (! overlaps(proj1, proj2)) {
	                colliding = false;
	            }
	        }

	        for (int i = 0; i < axes2.size && colliding; i ++) {
	            Vector2D axis = axes2.vectors[i];
	            Projection proj1 = project(axis, p1);
	            Projection proj2 = project(axis, p2);
	            if (! overlaps(proj1, proj2)) {
	                colliding = false;
	            }
	        }
	    }
	    return colliding;
	}
	Vector getMTV(Polygon p1, Polygon p2) {
	    boolean colliding = true;//aabbCollision(p1, p2);
	    double overlap = Double.MAX_VALUE;

	    Vector smallest = NOTHING;
	    List<Vector> axes1 = getAxes1(p1);
	    List<Vector> axes2 = getAxes2(p2);

	    for (int i = 0; i < axes1.size && colliding; i ++) {
	        Vector2D axis = axes1.vectors[i];
	        Projection proj1 = project(axis, p1);
	        Projection proj2 = project(axis, p2);
	        if (overlaps(proj1, proj2)) {
	            double o = getOverlap(proj1, proj2);
	            if (o < overlap) {
	                overlap = o;
	                smallest = axis;
	            }
	        }else{
	            colliding = false;
	        }
	    }

	    for (int i = 0; i < axes2.size && colliding; i ++) {
	        Vector2D axis = axes2.vectors[i];
	        Projection proj1 = project(axis, p1);
	        Projection proj2 = project(axis, p2);
	        if (overlaps(proj1, proj2)) {
	            double o = getOverlap(proj1, proj2);
	            if (o < overlap) {
	                overlap = o;
	                smallest = axis;
	            }
	        }else{
	            colliding = false;
	        }
	    }

	    Vector2D MTV;
	    if (colliding) {
	        MTV = multiplyV2D(smallest, overlap);
	    } else {
	        MTV = NOTHING;
	    }

	    return MTV;
	}
	void resolvePenEq(Polygon p1, Polygon p2) {
	    Vector mtv = getMTV(p1, p2);
	    if (! mtv.equals(NOTHING)) {
	    	mtv.scale(0.5);
	        p1.movePolygon(mtv);
	        p2.movePolygon(mtv);
	    }
	}
	
	void resolvePenDom(Polygon p2) {
	    Vector mtv = getMTV(this, p2);
	    if (! mtv.equals(NOTHING)) {
	    	mtv.scale(-1);
	        p2.movePolygon(mtv);
	    }
	    
	}
}
