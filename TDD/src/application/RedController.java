package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class RedController implements Initializable {
	@FXML
	private TextArea Redtext;
	String path ="TDD/Uebungsaufgaben/"+MainWindowsController.path+"/test.java";

	// Event Listener on Button.onAction
	@FXML
	public void Next(ActionEvent event) {
		try{
			((Node)event.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Parent root= FXMLLoader.load(getClass().getResource("/application/Green.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Green");
			Einlesen_speichern.speichern(path, Redtext);
			primaryStage.show();
			}catch(Exception e){

			}
	}

	public void initialize(URL location, ResourceBundle resources){
		try {
			Redtext.setText(Einlesen_speichern.einlesen(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
