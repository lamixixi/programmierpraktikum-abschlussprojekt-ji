package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Labeled;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MainWindowsController implements Initializable {

	public static String path;
	private String Fielname[];
	
	protected Labeled selected;

	@FXML
	private TableView<UebungsAufgaben> table;
	private ObservableList<UebungsAufgaben> date = FXCollections.observableArrayList();

	@FXML
	private TableColumn<UebungsAufgaben, String> column1;
	
	public void initialize(URL location, ResourceBundle resources){
	
		// Hier wird alle Datei in der Ordnung Uebungsaufgaben in der Tabelle
		// darstellt.
		File file = new File("TDD/Uebungsaufgaben/");
		Fielname = file.list();
		int j = 0;
		try {
			while (j <= Fielname.length) {
				date.addAll(new UebungsAufgaben(Fielname[j]));
				column1.setCellValueFactory(new PropertyValueFactory<UebungsAufgaben, String>("Name"));
				table.setItems(null);
				table.setItems(date);
				j++;
			}
		} catch (Exception e) {

		}
		// was passiert wenn was von der Tabelle ausgewahlt hat.
		table.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
					if (mouseEvent.getClickCount() == 1) {
						table.getSelectionModel().selectedItemProperty()
								.addListener((observable, oldValue, newValue) -> {
									if (newValue == null) {
										selected.setText("");
										return;
									}
									path = newValue.getName();
								});
					}
				}
			}
		});
	}

	@FXML
	public void Next(ActionEvent event) { // Butto fur NEXT

		try {
			((Node) event.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/Red.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Red");
			primaryStage.show();
		} catch (Exception e) {

		}

	}
	
	
	@FXML
	public void Erweiterung1(ActionEvent event) { // Butto fur Erweiterung 1

	}

	@FXML
	public void Erweiterung2(ActionEvent event) { // Butto fur Erweiterung 2

	}

}
