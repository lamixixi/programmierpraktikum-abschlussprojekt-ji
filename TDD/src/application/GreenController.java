package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class GreenController implements Initializable{
	@FXML
	private TextArea Greentext;
	String path ="TDD/Uebungsaufgaben/"+MainWindowsController.path+"/code.java";

	
	public void initialize(URL location, ResourceBundle resources){
		try {
			Greentext.setText(Einlesen_speichern.einlesen(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	@FXML
	public void Back(ActionEvent event) {
		try{
			((Node)event.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Parent root= FXMLLoader.load(getClass().getResource("/application/Red.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Red");
			primaryStage.show();
			}catch(Exception e){

			}
		
	}
	@FXML
	public void Next(ActionEvent event) throws IOException {
		Einlesen_speichern.speichern(path, Greentext);
	}
	
	
}
