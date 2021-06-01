package kmeans;

import java.util.ArrayList;

public class Class {
	private int nStudent = 0;
	private int numCluster;
	
	private ArrayList<Student> room = new ArrayList<Student>();

	public Class() {
		super();
	}

	
	public Student getStudent(int k) {
		Student st = new Student();
		st = room.get(k);
		return st;
	}
	public void addSt(Student st) {
		this.setnStudent(this.getnStudent() + 1);
		room.add(st);
	}
	public void removeSt(Student st) {
		this.setnStudent(this.getnStudent() - 1);
		room.remove(st);
	}

	public int getnStudent() {
		return nStudent;
	}

	public void setnStudent(int nStudent) {
		this.nStudent = nStudent;
	}


	public int getNumCluster() {
		return numCluster;
	}


	public void setNumCluster(int numCluster) {
		this.numCluster = numCluster;
	}
	
}
