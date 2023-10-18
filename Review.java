public class Review {
    public AttorneyForm attorneyForm;
    
    //The review needs to be able to flag each value that is incorrect
    //how should this be returned

    public Review(AttorneyForm attorneyForm){
        this.attorneyForm = attorneyForm;
        //check workflow for next AttorneyForm in ReviewQueue
        //check and validate each field
        //update workflow 
    }

    public void getNextReview(){
        attorneyForm = Workflow.readyToReview[0]; //etc.
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
        attorneyForm.comments += "\nReviewed";
    }
    public void updateStatus(){
        attorneyForm.status = 1;
    }



}