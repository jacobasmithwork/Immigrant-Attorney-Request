package group13;
public class Review {
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

    public void getNextReview(){
        attorneyForm = Workflow.getNextReview(); //etc.
    }

    // public void checkImmId(){
    //     //do this
    // }
    // public void checkPhoneNum(){
    //     //do this
    // }
    // public void checkAttorneyName(){
    //     //do this
    // }
    // public void checkAddress(){
    //     //do this
    // }
    // public void checkName(String name){
    //     if(!name.equals(attorneyForm.name)){
    //         //Do this
    //     }
    // }
    // public void addComment(){
    //     //Do this
    //     attorneyForm.addComment("\nReviewed");
    // }
    // public void updateStatus(){
    //     attorneyForm.status = 1;
    // }


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