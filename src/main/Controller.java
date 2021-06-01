package main;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;


public class Controller {

    @FXML
    private Button confirm;
        
    @FXML
    public ChoiceBox cB;
         
    public void submit(ActionEvent e) throws IOException {
    	String selected = (String) cB.getSelectionModel().getSelectedItem();
    	if (selected.equals("KMeans")) {
    		Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
    		URL url = new File("src/view/ViewKmeans.fxml").toURI().toURL();
	        Parent kmeans = FXMLLoader.load(url);
    		
    		Scene scene = new Scene(kmeans);
    		stage.setScene(scene);
    	}else if (selected.equals("Knn")) {
    		Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
    		URL url = new File("src/view/ViewKnn.fxml").toURI().toURL();
	        Parent knn = FXMLLoader.load(url);
    		
    		Scene scene = new Scene(knn);
    		
    		stage.setScene(scene);
    	}else if (selected.equals("MeanShift")) {
    		Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
    		URL url = new File("src/view/ViewMeanShift.fxml").toURI().toURL();
	        Parent ms = FXMLLoader.load(url);
    		
    		Scene scene = new Scene(ms);
    		
    		stage.setScene(scene);
    	}
    }
    

}
