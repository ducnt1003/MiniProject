package Meanshift;

import java.awt.List;
import java.util.ArrayList;


public class MeanShift {
	private int numCluster;
	private ArrayList<Point> points ;
    private ArrayList<Cluster> clusters;
    private AllPoint aP;
    private double radius;
    
    public MeanShift(AllPoint aP, double r) {
    	this.points = new ArrayList();
    	this.clusters = new ArrayList();  
    	this.aP = aP;
    	this.radius = r;
    }
    
    public ArrayList<Cluster> calculate() {
    	Point center = aP.getPoint(0);
    	int j = 0;
    	
    	
    	for(int i = 0; i < aP.getnPoint(); i++) {  
    		
    		if(aP.getPoint(i).isCheck() == false) {  
    			
    			boolean finish=false;
    			Cluster cluster = new Cluster(j); 
    			center = aP.getPoint(i);
    			
    			while(!finish) {  
    			BandWith bW = new BandWith();
    			for (int k = 0; k < aP.getnPoint(); k++) {
    				Point point2 = aP.getPoint(k); 
    				if (center.distance(center, point2) < radius) {  
    					point2.setCheck(true);
    					bW.addPoint(point2);
    					cluster.addPoint(point2);
        				}
    				}   			
    				if (center.equal(center,bW.newCenter())) {
    					cluster.setId(j);    					
    					cluster.setClPoint(j);
    					cluster.setCenter(center);
    					clusters.add(cluster);
    					finish = true;	
    					j++;
    					}
    				center = bW.newCenter();   
    				
    			}
    			
    			for(int h = 0; h<j ; h++) {   				
    				Point oldCenter = clusters.get(h).getCenter(); 
    				double d = oldCenter.distance(oldCenter, center);
   
    				if((d<radius) && (d!=0) ) {   
    					cluster.setClPoint(h);
    					clusters.get(h).addCluster(cluster);
    					j--;
    	    			clusters.remove(j);
    					
    					}     					 					   				   		   					
    				}  				
    		}    			
    	}
    	return clusters;
    		
    }
    	
    
    public void print() {
    	for(Cluster cl : clusters) {
    		for(Point pt : cl.getPoints()) {
    			System.out.println(pt.getCluster()+" "+ pt.getX()+" "+pt.getY());
    		}
    	}
    }    
}
