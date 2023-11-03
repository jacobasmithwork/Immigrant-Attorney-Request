package group13;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class Review extends Application{
    public AttorneyForm attorneyForm;
    
    //The review needs to be able to flag each value that is incorrect
    //how should this be returned

    //I think that could just be left up to the comments ArrayList<String> using the
    //AttorneyForm's addComment(String comment) method. 

    public Review(AttorneyForm attorneyForm){
        this.attorneyForm = attorneyForm;
        //check workflow for next AttorneyForm in ReviewQueue
        //check and validate each field
        //update workflow 
    }

    public static void main(String[] args){
        //handle gui
        new Review();
        launch();
    }

    public void getNextReview(){
        attorneyForm = Workflow.getNextReview(); //etc.
    }

    public void checkImmId(){
        //do this
    }
    public void checkPhoneNum(){
        //do this
    }
    public void checkAttorneyName(){
        //do this
    }
    public void checkAddress(){
        //do this
    }
    public void checkName(String name){
        if(!name.equals(attorneyForm.name)){
            //Do this
        }
    }
    public void addComment(){
        //Do this
        attorneyForm.addComment("\nReviewed");
    }
    public void updateStatus(){
        attorneyForm.status = 1;
    }



}