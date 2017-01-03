package compression.model;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class VL_OverviewController {
	

	@FXML MenuItem layout_LZ;
	@FXML MenuItem layout_RLE;
	@FXML MenuItem layout_VL;
	@FXML Button openFileButton;
	@FXML Button compressFileButton;
	@FXML Button decompressFileButton;
	
    @FXML private void initialize() {
  
    }
    @FXML
	private void handleMenuAction(ActionEvent event) throws IOException {
		Stage stage = null;
		Parent root = null;
		Scene oldScene = openFileButton.getScene();
		if (event.getSource() == layout_LZ) {
			stage = (Stage) openFileButton.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("/compression/view/LZ_Overview.fxml"));
	
		} else if (event.getSource() == layout_RLE) {
			stage = (Stage) openFileButton.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("/compression/view/RLE_Overview.fxml"));
		} else if (event.getSource() == layout_VL) {
			stage = (Stage) openFileButton.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("/compression/view/VL_Overview.fxml"));

		}
		Scene scene = new Scene(root, oldScene.getWidth(), oldScene.getHeight());
		stage.setScene(scene);
		stage.show();
	}

    

}
