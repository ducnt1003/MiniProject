package main;

import java.io.File;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application {

	@Override
	public void start(Stage primaryStage) {
try {
			
			URL url = new File("src/view/ViewMain.fxml").toURI().toURL();
	        Parent root = FXMLLoader.load(url);
	        primaryStage.setTitle("main");
	        primaryStage.setScene(new Scene(root));
	        primaryStage.show();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
