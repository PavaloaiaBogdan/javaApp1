package compression.model.LZ;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LZ_OverviewController {

	@FXML Button openFileButton;
	@FXML Button compressFileButton;
	@FXML Button decompressFileButton;
	@FXML ListView<String> lz_algorithm_list;
	@FXML BorderPane lz_borderpane;
	@FXML Pane lz_centerpane;
	
	
    @FXML private void initialize() {
    	 ObservableList<String> algorithms = FXCollections.observableArrayList("Lempel-Ziv 1977 (LZ77)", "Lempel-Ziv 1978 (LZ78)", "Lempel–Ziv–Welch (LZW)");
    	 lz_algorithm_list.setItems(algorithms);
    }
	
    @FXML
    private void onMouseClicked(MouseEvent event) throws IOException {
    	
        final String selectedItem = lz_algorithm_list.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            return;
        }
        if(selectedItem=="Lempel-Ziv 1977 (LZ77)"){
        	lz_borderpane.setCenter(null);
        	Node activeNode = FXMLLoader.load(getClass().getResource("/compression/view/LZ/LZ77.fxml"));
        	lz_borderpane.setCenter(activeNode);
        }else if(selectedItem=="Lempel-Ziv 1978 (LZ78)"){
        	lz_borderpane.setCenter(null);
        	Node activeNode = FXMLLoader.load(getClass().getResource("/compression/view/LZ/LZ78.fxml"));
        	lz_borderpane.setCenter(activeNode);
        }else if(selectedItem=="Lempel–Ziv–Welch (LZW)"){
        	lz_borderpane.setCenter(null);
        	Node activeNode = FXMLLoader.load(getClass().getResource("/compression/view/LZ/LZW.fxml"));
        	lz_borderpane.setCenter(activeNode);
        }
        
        	
    }
    
    
	
}
