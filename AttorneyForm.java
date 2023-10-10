public class AttorneyForm{
    public String name;
    public String address;
    public String attorneyName;
    public int immId;
    public int phoneNum;
    public int status;

    public AttorneyForm(String name, String address, String attorneyName, int immId, int phoneNum){
        this.name = name;
        this.address = address;
        this.attorneyName = attorneyName;
        this.immId = immId;
        
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
    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }
    public void setStatus(int status) {
        this.status = status;
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
    public int getPhoneNum() {
        return phoneNum;
    }
    public int getStatus() {
        return status;
    }

    
}