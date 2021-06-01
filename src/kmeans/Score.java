package kmeans;

import java.util.Random;

public class Score {
	private double dToan;
	private double dLy;
	
	public Score() {
		super();
	}
	public Score(double dToan, double dLy) {
		super();
		this.dToan = dToan;
		this.dLy = dLy;
	}
	public double getdToan() {
		return dToan;
	}
	public void setdToan(double dToan) {
		this.dToan = dToan;
	}
	public double getdLy() {
		return dLy;
	}
	public void setdLy(double dLy) {
		this.dLy = dLy;
	}
	
	protected static Score createRandomScore(int min, int max) {
		Random r = new Random();
    	float x = min + (max - min) * r.nextFloat();
    	float y = min + (max - min) * r.nextFloat();
    	
    	return new Score(x,y);
	}
	protected static double distances(Score st, Score center) {
		double f;
		f = Math.sqrt(Math.pow((st.getdToan()- center.getdToan()),2)+ 
				Math.pow((st.getdLy()- center.getdLy()),2));
		return f;
	}
		
}
