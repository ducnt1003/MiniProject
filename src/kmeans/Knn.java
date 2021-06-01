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
			Student st1= new Student();
			st1 = cl.getStudent(i);
			knn.add(st1);
		}
		for(int i = k; i<cl.getnStudent(); i++) {
			Student st1= new Student();
			st1 = cl.getStudent(i);
			double distance = Student.distance(st1,st);
			for(Student st2 : knn) {
				if(distance < Student.distance(st1,st)) {
					knn.remove(st2);
					knn.add(st1);
				}					
			}
		}
		int[] array = {0,0,0};
		for(Student st1 : knn) {
			array[st1.getID()]++;
		}
		int max = array[0];
		int j = 0;
		for(int i = 0; i<3; i++) {
			if(max<array[i]) {
				max = array[i];
				j = i;
			}
		}
		return j;
		
	}
}
