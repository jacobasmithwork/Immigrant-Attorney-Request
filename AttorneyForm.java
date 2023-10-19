import java.util.ArrayList;

public class AttorneyForm{
    public String name; //Immigrant's Name
    public String address; //Immigrant's Address
    public String attorneyName; //Attorney's name
    public ArrayList<String> comments; //Comments for between steps
    public long phoneNum; //Attorney's Phone number
    public int immId; //Immigrant ID
    public int status; //Form's status through the workflow
    public int formId; //The trackable unique id of the form, generated as it is inserted into DB / WF.
    
    public AttorneyForm(String name, String address, String attorneyName, int immId, long phoneNum){
        this.name = name;
        this.address = address;
        this.attorneyName = attorneyName; 
        this.immId = immId;
        this.phoneNum = phoneNum;
        this.status = 0;
        this.comments = new ArrayList<String>();
    }
    //Constructor if formId is known (issues with Integer vs int?)
    public AttorneyForm(String name, String address, String attorneyName, int immId, long phoneNum, Integer formId){
        this.name = name;
        this.address = address;
        this.attorneyName = attorneyName; 
        this.immId = immId;
        this.phoneNum = phoneNum;
        this.status = 0;
        this.comments = new ArrayList<String>();
        this.formId = formId;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setAttorneyName(String attorneyName) {
        this.attorneyName = attorneyName;
    }
    public void setImmId(int immId) {
        this.immId = immId;
    }
    public void setPhoneNum(long phoneNum) {
        this.phoneNum = phoneNum;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public void setComments(ArrayList<String> comments) { //More likely to use addComment
        this.comments = comments;
    }
    
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getAttorneyName() {
        return attorneyName;
    }
    public int getImmId() {
        return immId;
    }
    public long getPhoneNum() {
        return phoneNum;
    }
    public int getStatus() {
        return status;
    }
    public ArrayList<String> getComments() {
        return this.comments;
    }

    public void addComment(String comment){ //Appends comment to preserve comment history & order
        comments.add(comment);
    }
    
    public void sendToWf(int status){ //0 = in DE, 1 = send to review queue, 2 = send to approve queue
        this.status = status;
        if(status > 2 || status < 0){
            //invalid status input
        }
        if(status == 1){
            //place in review
            Workflow.readyToReview.add(this.formId);
            sendToDb();
        }
        else if(status == 2){ //dont see this being necessary
            //place in approval
            Workflow.readyToReview.add(this.formId);
            sendToDb();
        }
        else{
            sendToDb();
            //save in database for later editing - if status is unchanged, the form is not submitted
        } 
         
    }

    public void sendToDb(){
        //Generate unique form ID based on hash of object
        //Double check via query that ID is not taken, and assign form ID
        //Send to database and save
    }

    public void updateDb(){
        //uses unique form ID to edit the form in database without disrupting others
    }

}