package kmeans;

import java.util.ArrayList;
import java.util.List;

public class Knn {
	private Student st;
	private Class cl;
	private int k;
	private ArrayList<Student> knn = new ArrayList<Student>(k);
	public Knn(Student st, Class cl, int k) {
		super();
		this.st = st;
		this.cl = cl;
		this.k = k;
	}
	public int findCluster() {
		for(int i = 0 ;i < k; i++) {
	
			double Min = 10;
			Student stMin= new Student();
			for(int j = 0; j<cl.getnStudent(); j++) {
				Student st1= new Student();
				st1 = cl.getStudent(j);
				double distance = Student.distance(st1,st);
				if(distance < Min ) {
					Min = distance;
					stMin=st1;								
				}
			}
			cl.removeSt(stMin);
			knn.add(stMin);
		}
		
		int[] array = {0,0,0,0,0,0,0,0};
		for(Student st1 : knn) {
			array[st1.getID()]++;
		}
		int max = array[0];
		int j = 0;
		for(int i = 0; i<7; i++) {
			if(max<array[i]) {
				max = array[i];
				j = i;
			}
		}
		return j;
		
	}
	
	public ArrayList<Student> getKnn() {
		return knn;
	}
	public void setKnn(ArrayList<Student> knn) {
		this.knn = knn;
	}
	
}
