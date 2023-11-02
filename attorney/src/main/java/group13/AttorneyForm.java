package group13;
import java.util.ArrayList;
//my second commit
/**
 * The Business Object for the Attorney Request functional area.
 * 
 */
public class AttorneyForm{
    /**
     * The String representing the user's name.
     */
    public String name;
    /**
     * The String representing the user's address.
     */
    public String address;
    /**
     * The String representing the name of the user's requested attorney.
     */
    public String attorneyName;
    /**
     * The String representing the name of the attorney's firm.
     */
    public String attorneyFirm;
    /**
     * The ArrayList of Strings for recording notes from the reviewer and approver on the user's attorney request form.
     */
    public ArrayList<String> comments;
    /**
     * A value of type long representing the requested attorney's phone number.
     */
    public long phoneNum;
    /**
     * An integer value representing the user's identification number.
     */
    public int immId;
    /**
     * An integer value representing the status of the user's respective AttorneyForm object.
     *  A value of 0 represents the form yet to be submitted to review.
     *  A value of 1 represents the form ready for Review.
     *  A value of 2 represents the form ready for Approval.
     */
    public int status; //Form's status through the workflow
    /**
     * An integer value representing an AttorneyForm object's unique id number that is generated as it is inserted into the 
     * functional area 3 Database and Workflow object.
     */
    public int formId;
    
    /**The default constructor method for the AttorneyForm.
     * 
     * Initializes the form's comment attribute and its status to zero.
     * @param name is the String value of the user's inputted name. 
     * @param address is the String value of the user's inputted address.
     * @param attorneyName is the String value of the name of the user's requested attorney.
     * @param attorneyFirm is the String value of the name of the attorney's firm.
     * @param immId is the interger type id number of user.
     * @param phoneNum is the long type representation of the user's phone number.
     */
    public AttorneyForm(String name, String address, String attorneyName, String attorneyFirm, int immId, long phoneNum){
        this.name = name;
        this.address = address;
        this.attorneyName = attorneyName; 
        this.immId = immId;
        this.phoneNum = phoneNum;
        this.status = 0;
        this.comments = new ArrayList<String>();
        this.formId = 1; //TODO: change to available id
    }
    //Constructor if formId is known (issues with Integer vs int?)

    /**A contructor method for the AttorneyForm that accounts for a known form id number.
     * 
     * Initializes the form's comment attribute and its status to zero.
     * @param name is the String value of the user's inputted name.
     * @param address is the String value of the user's inputted address.
     * @param attorneyName is the String value of the name of the user's requested attorney.
     * @param attorneyFirm is the String value of the name of the attorney's firm.
     * @param immId is the interger type id number of user.
     * @param phoneNum is the long type representation of the user's phone number.
     * @param formId is the integer value representing an AttorneyForm object's unique id number.
     */
    public AttorneyForm(String name, String address, String attorneyName, String attorneyFirm, int immId, long phoneNum, Integer formId){
        this.name = name;
        this.address = address;
        this.attorneyName = attorneyName; 
        this.immId = immId;
        this.phoneNum = phoneNum;
        this.status = 0;
        this.comments = new ArrayList<String>();
        this.formId = formId;
    }
    
    /**A set method for an AttorneyForm object's name attribute.
     * 
     * @param name a String representing the user's name.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**A set method for an AttorneyForm object's address attribute.
     * 
     * @param address a String representing the user's address.
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**A set method for an AttorneyForm object's attorneyName attribute.
     * 
     * @param attorneyName a String representing the user's attorney's name.
     */
    public void setAttorneyName(String attorneyName) {
        this.attorneyName = attorneyName;
    }
    /**A set method for an AttorneyForm object's immId attribute.
     * 
     * @param immId is the interger type id number of user.
     */
    public void setImmId(int immId) {
        this.immId = immId;
    }
    /**A set method for an AttorneyForm object's phoneNum attribute.
     * 
     * @param phoneNum is the long type representation of the user's phone number.
     */
    public void setPhoneNum(long phoneNum) {
        this.phoneNum = phoneNum;
    }
    /**A set method for an AttorneyForm object's status attribute.
     * 
     * @param status is the integer value representing an AttorneyForm object's status.
     */
    public void setStatus(int status) {
        this.status = status;
    }
    /**A set method for an AttorneyForm object's comments attribute.
     * 
     * @param comments is an Arraylist of Strings that represent comments left by the reviewer and approver on the user's form.
     */
    public void setComments(ArrayList<String> comments) { //More likely to use addComment
        this.comments = comments;
    }
    
    /**A get method for an AttorneyForm object's name attribute.
     * 
     * @return the String of the user's name.
     */
    public String getName() {
        return name;
    }
    /**A get method for an AttorneyForm object's address attribute.
     * 
     * @return the String of the user's address.
     */
    public String getAddress() {
        return address;
    }
    /**A get method for an AttorneyForm object's attorneyName attribute.
     * 
     * @return the String of the user's requested attorney's name.
     */
    public String getAttorneyName() {
        return attorneyName;
    }
    /**A get method for an AttorneyForm object's immigrant ID attribute.
     * 
     * @return an int of the user's identification number.
     */
    public int getImmId() {
        return immId;
    }
    /**A get method for an AttorneyForm object's phone number attribute.
     * 
     * @return a long of the attorney's phone number.
     */
    public long getPhoneNum() {
        return phoneNum;
    }
    /**A get method for an AttorneyForm object's status attribute.
     * 
     * @return the int status of the form.
     */
    public int getStatus() {
        return status;
    }
    /**A get method for an AttorneyForm object's comments attribute.
     * 
     * @return the ArrayList of String comments.
     */
    public ArrayList<String> getComments() {
        return this.comments;
    }

    /**This method adds comments to an Attorney Form objct's comment attribute.
     * 
     * @param comment the String of comments to be appended to the ArrayList of comments.
     */
    public void addComment(String comment){ //Appends comment to preserve comment history & order
        comments.add(comment);
    }
    
    /**This method sends an AttorneyForm object to the workflow depending on its status.
     * A status of 1 will add the object to the readyToReview LinkedList in the Workflow object.
     * A status of 2 will add the object to the readyToApprove LinkedList in the workflow object.
     * 
     * @param status is the integer status to which the object will be updated.
     */
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

    /**This method saves the AttorneyForm object to the database.
     * 
     */
    public void sendToDb(){
        //Generate unique form ID based on hash of object
        //Double check via query that ID is not taken, and assign form ID
        //Send to database and save
    }

    
    /**This method updates an AttorneyForm already contained in the Database.
     * 
     */
    public void updateDb(){
        //uses unique form ID to edit the form in database without disrupting others
    }

    // @Override
    public String toString(){
        return String.format(
            "Attorney Form ID: %d\n\tImmigrant Name: %s\n\tImmigrant address: %s\n\tImmigrant ID: %d\n\tAttorney Name: %s\n\tAttorney Firm: %s\n\tAttorney Phone Number: %L\n\t",
            this.formId, this.name, this.address, this.immId, this.attorneyName, this.attorneyFirm, this.phoneNum
        );
    }
}