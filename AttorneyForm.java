public class AttorneyForm{
    public String name; //Immigrant's Name
    public String address; //Immigrant's Address
    public String attorneyName; //Attorney's name
    public String comments;  //Comments for between steps
    public long phoneNum; //Attorney's Phone number
    public int immId; //Immigrant ID
    public int status; //Form's status through the workflow
    
    public AttorneyForm(String name, String address, String attorneyName, int immId, long phoneNum){
        this.name = name;
        this.address = address;
        this.attorneyName = attorneyName; 
        this.immId = immId;
        this.phoneNum = phoneNum;
        this.status = 1;
        this.comments = "";
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
    public void setComments(String comments) {
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
    public String getComments() {
        return this.comments;
    }


    
}