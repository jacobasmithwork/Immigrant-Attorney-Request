package group13;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Aprrove extends Application{

    //AttorneyForm form = new AttorneyForm("Chidera","123 fake street","Frank","best firm",123,1010101099);
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(this.getClass().getResource("Approval.fxml"));

            Parent parent = loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(parent);
            primaryStage.setTitle("Attorney Application");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
