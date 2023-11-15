package group13;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ReviewController{

    AttorneyForm form = new AttorneyForm("Walter","308 Negra Arroyo Ln","Saul","Sauls's Firm",183,7033077733L);

    @FXML
    public Label address;

    @FXML
    public Label attorneyFirm;

    @FXML
    public Label attorneyName;

    @FXML
    public Label formid;

    @FXML
    public Label immid;

    @FXML
    public Label name;

    @FXML
    public Button nextForm;

    @FXML
    public Label phoneNum;

    @FXML
    public Label status;

    @FXML
    public void btnOKClicked(ActionEvent event){
        address.setText(form.address);
        name.setText(form.name);
        attorneyName.setText(form.attorneyName);
        attorneyFirm.setText(form.attorneyFirm);
        phoneNum.setText(""+form.phoneNum);
        immid.setText(""+form.immId);
    }

    @FXML
    public void btnSubmit(ActionEvent event){

    }

}