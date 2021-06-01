package Meanshift;

import java.util.ArrayList;

public class BandWith {
	private ArrayList <Point> bandWith = new ArrayList<Point>();
	private double radius;
	private Point center;
	
	public BandWith() {
		super();
	}
	public BandWith(double radius, Point center) {
		super();
		this.radius = radius;
		this.center = center;
	}
	public void addPoint(Point point) {
		bandWith.add(point);
		
	}
	public Point newCenter() {		
		double x = 0, y = 0 ;
		for(Point pt : bandWith) {
			x += pt.getX();
			y += pt.getY();
		}
		x = x/bandWith.size();
		y = y/bandWith.size();
		Point center = new Point(x,y);
		return center ;
	}
	
}
