package kmeans;

public class Student extends Score {
	private Integer ID;
	private String name;
	
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		this.ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Student() {
		super();
	}
	public Student(double dToan, double dLy) {
		super(dToan, dLy);
	}
	public Student( String name, double dToan, double dLy) {
		super(dToan,dLy);
		this.name = name;
		
	}
	protected static double distance(Student st, Score center) {
		double f;
		f = Math.sqrt(Math.pow((st.getdToan()- center.getdToan()),2)+ 
				Math.pow((st.getdLy()- center.getdLy()),2));
		return f;
	}
	protected static double distance(Student st, Student center) {
		double f;
		f = Math.sqrt(Math.pow((st.getdToan()- center.getdToan()),2)+ 
				Math.pow((st.getdLy()- center.getdLy()),2));
		return f;
	}
	public void printSt() {
		System.out.println(name + " " + super.getdToan() + " " + super.getdLy());
	}
	
	
}
