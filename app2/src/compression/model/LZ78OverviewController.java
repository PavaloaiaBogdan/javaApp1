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

public class LZ78OverviewController {
	

	@FXML MenuItem men1;
	@FXML MenuItem men2;
	@FXML MenuItem men3;
	@FXML Button openFileButton;
//	@FXML private Parent root ;
	
    @FXML private void initialize() {
  
    }
    @FXML
    private void handleMenuAction(ActionEvent event) throws IOException{
        Stage stage = null; 
        Parent root = null;
        if(event.getSource()== men1){      
           stage= (Stage) openFileButton.getScene().getWindow();
           root = FXMLLoader.load(getClass().getResource("/compression/view/LZ77Overview.fxml"));
         }
        else if(event.getSource()== men2){
          stage=(Stage) openFileButton.getScene().getWindow();
          root = FXMLLoader.load(getClass().getResource("/compression/view/LZ78Overview.fxml"));
         }
         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
       }

    

}
