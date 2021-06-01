package Meanshift;

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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


	public class ControllerMeanShift implements Initializable{
		@FXML
		private AnchorPane anchorPane;
		@FXML
	    private Button back;

	    @FXML
	    private Button run;
	    @FXML
	    private List<Circle> circles = new ArrayList<Circle>(); 
	    
	  
	    
	    private AllPoint aP = new AllPoint();
	    
	    private List<Cluster> clusters = new ArrayList<Cluster>();
	    
	    @Override
	    public void initialize(URL location, ResourceBundle resources) {
	    	List<String> list = new ArrayList<String>();
			try{
	            BufferedReader br = new BufferedReader(new FileReader("test.txt"));
	            String s = null;
	            while((s = br.readLine())!=null){
	            	list.add(s);
	            }
	            br.close();    
	        }catch(Exception e){
	            e.printStackTrace();
	        }
			for(int i=0;i<list.size();i++) {
	        	Point pt = new Point();
	        	String[] items = list.get(i).split("-");
	        	pt.setX(Double.parseDouble(items[0]));
	        	pt.setY(Double.parseDouble(items[1]));
	        	aP.addPoint(pt);
	        }
			
	    	for(int i =0;i<aP.getnPoint();i++) {
	    		Point pt = aP.getPoint(i);
	    		
	    			Circle circle = new Circle();
	    			circle.setCenterX(30+20*pt.getX());
	    			circle.setCenterY(30+193-15*pt.getY());
	    			circle.setRadius(3);
	    			circle.setFill(Color.BLACK);
	    			anchorPane.getChildren().add(circle);
	    			
	    		
	    	}
		
	    }
	    
	    @FXML
	    public void run(ActionEvent event) {
	    	
	    	
	    	MeanShift mS = new MeanShift(aP,2);
	    	clusters = mS.calculate();
	    	List<Color> color= new ArrayList<Color>();
	    	color.add(Color.RED);
	    	color.add(Color.BLUE);
	    	color.add(Color.YELLOW);
	    	color.add(Color.LIGHTGRAY);
	    	
	    	for(Cluster cl : clusters) {
	    		List<Point> points = new ArrayList<Point>();
	    		points = cl.getPoints();
	    		for(Point pt : points) {
	    			Circle circle = new Circle();
	    			circle.setCenterX(30+20*pt.getX());
	    			circle.setCenterY(30+193-15*pt.getY());
	    			circle.setRadius(3);
	    			circle.setFill(color.get(cl.getId()));
	    			anchorPane.getChildren().add(circle);
	    		
	    		}
	    	}
	    	
	    	
	    }
	    public void back(ActionEvent e) throws IOException {
			Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
			URL url = new File("src/view/ViewMain.fxml").toURI().toURL();
	        Parent kmeans = FXMLLoader.load(url);
			
			Scene scene = new Scene(kmeans);
			
			stage.setScene(scene);
		}

}
