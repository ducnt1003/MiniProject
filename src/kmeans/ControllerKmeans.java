package kmeans;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import kmeans.Cluster;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ControllerKmeans implements Initializable{
	
	@FXML
	private TextArea textArea;
	@FXML
	private TextField textField;
	@FXML
	private Button button1;
	@FXML
	private Button button2;
	
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
		for(int i =0 ; i < cl.getnStudent(); i++) {
			textArea.appendText(cl.getStudent(i).getName() + " "+ cl.getStudent(i).getdToan()+" "+ cl.getStudent(i).getdLy()+"\n");
		}
			
	
	}
	
	public void submit (ActionEvent event) {
		String km = textField.getText();
		int k = Integer.parseInt(km);
		
    	Kmeans kmeans = new Kmeans(k,cl);
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
		
		textArea.setText(pr);	
	

	}
	public void back(ActionEvent e) throws IOException {
		Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
		URL url = new File("src/view/ViewMain.fxml").toURI().toURL();
        Parent kmeans = FXMLLoader.load(url);
		
		Scene scene = new Scene(kmeans);
		
		stage.setScene(scene);
	}
}
