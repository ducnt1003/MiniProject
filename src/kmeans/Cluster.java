package kmeans;

import java.util.ArrayList;

public class Cluster {
	private Score center;
	private ArrayList<Student> st = new ArrayList<Student>();
	private int id;
	
	
	
	public Cluster(int id) {
		super();
		this.center = null;
		this.id = id;
	}
	public Score getCenter() {
		return center;
	}
	public void setCenter(Score center) {
		this.center = center;
	}
	
	public ArrayList<Student> getCluster() {
		return st;
	}
	public void setCluster(ArrayList<Student> cluster) {
		this.st = cluster;
	}
	public void addStudent(Student st1) {
		st.add(st1);
	}
	public void clear() {
		st.clear();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
