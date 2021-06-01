package Meanshift;

public class Point {
	private double x;
	private double y;
	private int cluster_number;
	private boolean check = false;
	
	public Point() {
		super();
	}
	
	public Point(double x, double y) {
		super();
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

	public void setY(double y) {
		this.y = y;
	}
	
	 public void setCluster(int n) {
	        this.cluster_number = n;
	    }
	    
	 public int getCluster() {
	        return this.cluster_number;
	    }
	
	public double distance(Point p1,Point p2) {
		return Math.sqrt(Math.pow((p1.getX()-p2.getX()),2)+ Math.pow((p1.getY()-p2.getY()),2));
	}
	public boolean equal(Point p1, Point p2) {
		if((p1.getX()==p2.getX()) && (p1.getY()==p2.getY())){
			return true;
		}else return false;
	}
	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}
}
