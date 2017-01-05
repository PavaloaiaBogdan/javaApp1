package compression.model.LZ;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
	
	
	public void initialize(){
		leftTextArea.setWrapText(true);
		rightTextArea.setWrapText(true);
		
		//let TextBoxArea listener 
		leftTextArea.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable,
		    		String oldValue, String newValue) {
		    		rightTextArea.setText(leftTextArea.getText());		    		
		    }
		});
		
	}
	
	public void openFile(ActionEvent event) throws IOException{
		FileChooser fc = new FileChooser();
		File selectedFile = fc.showOpenDialog(null);
		
//		File selectedFile = new File("C:\\Users\\Bogdan\\Desktop\\test.txt");
		if(selectedFile!=null){
			leftTextArea.clear();
			rightTextArea.clear();
			//System.out.println(selectedFile.getAbsolutePath());
			for (String line : Files.readAllLines(Paths.get(selectedFile.getAbsolutePath()))) {
			    leftTextArea.appendText(line+"\n");
			}
			rightTextArea.setText(leftTextArea.getText());

		}
	}
	
	public void onMouseClicked(MouseEvent event){
		rightTextArea.setText((new CompressionAlgorithms.LZ.LZ77.LZ77Encoder(leftTextArea.getText())).getCompressedText());
		
	}
}
