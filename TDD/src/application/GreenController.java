package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class GreenController {
	@FXML
	private TextArea Greentext;

	// Event Listener on Button.onAction
	@FXML
	public void Back(ActionEvent event) {
		// TODO Autogenerate
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
	// Event Listener on Button.onAction
	@FXML
	public void Next(ActionEvent event) {
		// TODO Autogenerated
	}
}