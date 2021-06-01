package Meanshift;

import java.util.ArrayList;



public class Cluster {
	private Point center;
	private ArrayList<Point> points = new ArrayList<Point>();
	private int id;
	public Cluster(int id) {
		super();
		this.id = id;
	}
	
	
	public Cluster() {
		super();
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public Point getCenter() {
		return center;
	}


	public void setCenter(Point center) {
		this.center = center;
	}
	
	public void addPoint(Point point) {
		if(points.contains(point)==false)
			points.add(point);
	}
	
	public ArrayList<Point> getPoints() {
		return points;
	}


	public void setPoints(ArrayList<Point> points) {
		this.points = points;
	}


	public void addCluster(Cluster cluster) {
		ArrayList<Point> points1 = cluster.getPoints();		
		for(Point cl : points1) {
			if(points.contains(cl)==false) 
				points.add(cl);
		}
		
	}
	public void setClPoint(int j) {
		for(Point pt : points) {
			pt.setCluster(j);
		}
	}
	
	
	
}
