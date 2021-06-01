package kmeans;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerKnn implements Initializable{

    @FXML
    private TextField tf3;

    @FXML
    private TextField tf2;

    @FXML
    private TextField name;

    @FXML
    private TextArea textArea1;

    @FXML
    private TextField tf1;
    
    private List<Cluster> clusters = new ArrayList<Cluster>();
    private Class cl = new Class();
	
    public void initialize(URL location, ResourceBundle resources) {
		List<String> list = new ArrayList<String>();
		try{
            BufferedReader br = new BufferedReader(new FileReader("E:\\Eclipse\\test1.txt"));
            String s = null;
            while((s = br.readLine())!=null){
            	list.add(s);
            }
            br.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
		for(int i=0;i<list.size();i++) {
        	Student st = new Student();
        	String[] items = list.get(i).split("-");
        	st.setName(items[0]);
        	st.setdToan(Double.parseDouble(items[1]));
        	st.setdLy(Double.parseDouble(items[2]));
        	cl.addSt(st);
        }
		Kmeans kmeans = new Kmeans(2,cl);
    	kmeans.init();
    	clusters = kmeans.calculate();   	
    	String pr = new String();
					
		for(Cluster cl : clusters) {				
	    	List<Student> students = new ArrayList<Student>();
	    	students = cl.getCluster();
	    	pr += "##################\n"+ "Cluster" +(cl.getId()+1) + "\n";
	    	for(Student st : students) {
	    		pr += st.getName() + " "
						+st.getdToan() + " "+ st.getdLy() + "\n";
	    			
	    	}
	    }
		
		textArea1.setText(pr);	
	
	}
    
    public void submit (ActionEvent event) {
    	int k = 2;
    	
    	String tfx = tf1.getText();
    	double x = Double.parseDouble(tfx);
    	String tfy = tf2.getText();
    	double y = Double.parseDouble(tfy);
    	String Name = name.getText();
    	String tfk = tf3.getText();
    	int kn = Integer.parseInt(tfk);
    	    	
    	
    	Student st13 = new Student(Name,x,y);
    	Knn knn = new Knn(st13,cl,kn);
    	int a = knn.findCluster();
    	st13.setID(a);
    	cl.addSt(st13);
    	clusters.get(a).addStudent(st13);
    	String pr1 = new String();
    	pr1 += "New point has been added to cluster "+ a + "\n";
    	for(Cluster cl : clusters) {				
	    	List<Student> students = new ArrayList<Student>();
	    	students = cl.getCluster();
	    	pr1 += "##################\n"+ "Cluster" +(cl.getId()+1) + "\n";
	    	for(Student st : students) {
	    		pr1 += st.getName() + " "
						+st.getdToan() + " "+ st.getdLy() + "\n";	    			
	    	}
	    }	
		textArea1.setText(pr1);	
    }
    public void back(ActionEvent e) throws IOException {
		Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
		URL url = new File("src/view/ViewMain.fxml").toURI().toURL();
        Parent kmeans = FXMLLoader.load(url);
		
		Scene scene = new Scene(kmeans);
		
		stage.setScene(scene);
	}
}


