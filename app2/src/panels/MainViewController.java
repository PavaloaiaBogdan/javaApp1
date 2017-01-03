package panels;

import java.io.File;
import java.util.ArrayList;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class MainViewController {
	@FXML
	private TextField txt1;
	@FXML
	private Button openBtn;
	@FXML
	private Button compBtn;
	@FXML
	private ChoiceBox box1;
	
	ArrayList<String> data;
	
	public void OpenFileBtnAction(ActionEvent event){
		FileChooser fileChooser = new FileChooser();
		File file = fileChooser.showOpenDialog(null);
        if (file != null) {
        	data = new ArrayList<String>(FileHandler.readFileData(file));
        }
	}
	
	public void CompressFileBtnAction(ActionEvent event){
		for(String s: data)
			System.out.println(s);
	}
        
	
	
}
