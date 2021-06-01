package Meanshift;

import java.util.ArrayList;

public class AllPoint {
	private ArrayList<Point> points = new ArrayList<Point>();
	private int nPoint;
	public AllPoint() {
		super();
	}
	public int getnPoint() {
		return nPoint;
	}
	public void setnPoint(int nPoint) {
		this.nPoint = nPoint;
	}
	public void addPoint(Point point) {
		nPoint++;
		points.add(point);
	}
	public Point getPoint(int k) {
		return points.get(k);
	}
	public void print() {
		for(Point p : points) {
			System.out.println(p.getCluster()+ " "+ p.getX()+ " "+ p.getY());
		}
	}
}
