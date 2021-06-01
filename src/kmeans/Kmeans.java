package kmeans;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import kmeans.Score;
import kmeans.Student;

public class Kmeans {
	private int k;
	private Class cl1;
	private List<Cluster> clusters;
	public Kmeans(int k, Class cl1) {
		super();
		this.k = k;
		this.cl1 = cl1;
		this.clusters = new ArrayList<Cluster>();
	}
	private String process = new String();
	public void init() {
		for(int i = 0; i < k; i++) {
			Cluster cluster = new Cluster(i);
			Score center = Score.createRandomScore(0,10);
			cluster.setCenter(center);
			clusters.add(cluster);
		}
	}
	private void clearClusters() {
    	for(Cluster cluster : clusters) {
    		cluster.clear();
    	}
    }
	private List<Score> getCenters() {
		List<Score> centers = new ArrayList<>(k);
		for(Cluster cluster : clusters) {
			Score aux = cluster.getCenter();
			Score score = new Score(aux.getdToan(),aux.getdLy());
			centers.add(score);
		}
		return centers;
	}
	private void assignCluster() {
		double max = Double.MAX_VALUE;
		double min = max;
		double distance = 0.0;
		int cluster = 0;
		
		for(int i = 0 ;i < cl1.getnStudent(); i++) {
			Student st= new Student();
			st = cl1.getStudent(i);
			min = max;
			for(int j = 0; j<k;j++) {
				Cluster c = clusters.get(j);
				distance = Student.distance(st,c.getCenter());
				if(distance < min) {
					min = distance;
					cluster = j;
				}
			}
			st.setID(cluster);
			clusters.get(cluster).addStudent(st);
		}
	}
	
	private void calculateCenter() {
		for(Cluster cluster : clusters) {
			double sumX = 0;
			double sumY = 0;
			List<Student> list = cluster.getCluster();
			int n_st = list.size();
			for(Student student : list) {
				sumX += student.getdToan();
				sumY += student.getdLy();
			}
			Score center = cluster.getCenter();
			if(n_st != 0) {
				double newX = sumX/n_st;
				double newY = sumY/n_st;
				center.setdToan(newX);
				center.setdLy(newY);				
			}
		}
	}
	
	public List<Cluster> calculate() {
		boolean finish = false;
		int iteration = 0;
		
		while(!finish) {
			clearClusters();
			
			List<Score> lastCenter = getCenters();
			
			assignCluster();
			
			calculateCenter();
			
			iteration ++;
			
			List<Score> currentCenter = getCenters();
			
			double distance = 0;
			for(int i =0 ; i < lastCenter.size(); i++) {
				distance +=Score.distances(lastCenter.get(i), currentCenter.get(i));				
			}
        	process += "#################\n"+ "Iteration: " + iteration+ "\n" + plotClusters();       	
        	if(distance == 0) {
        		finish = true;
        		
//        		System.out.println("#################"); 
//            	System.out.println("Iteration: " + iteration);
//            	plotClusters();
        	}
		}
		return clusters;
	}
	private String plotClusters() {
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		String str = new String();
		for(Cluster cl : clusters) {				
	    	List<Student> students = new ArrayList<Student>();
	    	students = cl.getCluster();
	    	str += "##################\n"+ "Cluster" +(cl.getId()+1) +
	    			 " Center:  " +decimalFormat.format(cl.getCenter().getdToan())  + "-"+ decimalFormat.format(cl.getCenter().getdLy()) +"\n";
	    	for(Student st : students) {
	    		str += st.getName() + " "
						+st.getdToan() + " "+ st.getdLy() + "\n";
	    			
	    	}
	    }
    	return str;
    }	
	public String getProcess() {
		return process;
	}
}
	
		

	
	
	
	
	
	
