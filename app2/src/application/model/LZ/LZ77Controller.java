package application.model.LZ;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import CompressionAlgorithms.LZ.LZ77.LZ77;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

public class LZ77Controller {
	
	@FXML Button openFileButton;
	@FXML Button compressFileButton;
	@FXML Button decompressFileButton;
	@FXML TextArea leftTextArea;
	@FXML TextArea rightTextArea;
	
	private boolean encodeFlag=true;
	
	public void initialize(){
		leftTextArea.setWrapText(true);
		rightTextArea.setWrapText(true);
		
		//listener for input text
		leftTextArea.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable,
		    		String oldValue, String newValue) {
		    	if(encodeFlag==true){
		    		rightTextArea.setText(LZ77.encode(leftTextArea.getText()));
		    	}else{
		    		rightTextArea.setText(LZ77.decode(leftTextArea.getText()));	
		    	}
		    			    		
		    }
		});
		
	}
	
	public void openFile(ActionEvent event) throws IOException{
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt*")
//                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
//                new FileChooser.ExtensionFilter("PNG", "*.png")
            );
		
		File selectedFile = fc.showOpenDialog(null);
		if(selectedFile!=null){
			leftTextArea.clear();
			rightTextArea.clear();
			for (String line : Files.readAllLines(Paths.get(selectedFile.getAbsolutePath()))) {
			    leftTextArea.appendText(line+"\n");
			}
			rightTextArea.setText(leftTextArea.getText());

		}
	}
	
	public void compressButtonClicked(MouseEvent event){
		encodeFlag = true;
		rightTextArea.setText(LZ77.encode(leftTextArea.getText()));
	}
	
	public void decompressButtonClicked(MouseEvent event){
		encodeFlag = false;
		rightTextArea.setText(LZ77.decode(leftTextArea.getText()));
	}
}
