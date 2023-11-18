package group13;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Review extends Application{
    


    public static void main(String[] args){
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(this.getClass().getResource("ReviewScreen.fxml"));

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

}