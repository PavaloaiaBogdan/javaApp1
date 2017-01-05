package compression.model;

import java.awt.MenuBar;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainOverviewController {

	@FXML
	MenuItem layout_LZ;
	@FXML
	MenuItem layout_RLE;
	@FXML
	MenuItem layout_VL;
	@FXML
	BorderPane mainBorderPane;
	
	
	@FXML
	private void initialize() {
		
	}
	@FXML
	private void handleMenuAction(ActionEvent event) throws IOException {
		Stage stage = null;	
		if (event.getSource() == layout_LZ) {
			mainBorderPane.setCenter(null);
			Node temp = FXMLLoader.load(getClass().getResource("/compression/view/LZ/LZ_Overview.fxml"));
			mainBorderPane.setCenter(temp);
			stage=(Stage) mainBorderPane.getScene().getWindow();
			stage.setTitle("LZ Compression");	
		} else if (event.getSource() == layout_RLE) {
			mainBorderPane.setCenter(null);
			Node temp = FXMLLoader.load(getClass().getResource("/compression/view/RLE/RLE_Overview.fxml"));
			mainBorderPane.setCenter(temp);
			stage=(Stage) mainBorderPane.getScene().getWindow();
			stage.setTitle("RLE Compression");
		} else if (event.getSource() == layout_VL) {
			Node temp = FXMLLoader.load(getClass().getResource("/compression/view/VL/VL_Overview.fxml"));
			mainBorderPane.setCenter(temp);
			stage=(Stage) mainBorderPane.getScene().getWindow();
			stage.setTitle("VL Compression");

		}
	}

}
