package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    private Parent rootNode;
   
//
//    public static void main(final String[] args) {
//        Application.launch(args);
//    }

    @Override
    public void init() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/view/MainOverview.fxml"));
        rootNode = fxmlLoader.load();
       
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(rootNode));
        stage.setTitle("Compression Algorithms");
        stage.show();
    }

}