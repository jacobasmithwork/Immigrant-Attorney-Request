package group13;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ApprovalController{

    AttorneyForm form = Workflow.getNextApproval();

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

    public TextField comment;

    @FXML
    public void btnOKClicked(ActionEvent event){
        if(form == null){
            formid.setText("Empty");
            status.setText("Empty");
            address.setText("Empty");
            name.setText("Empty");
            attorneyName.setText("Empty");
            attorneyFirm.setText("Empty");
            phoneNum.setText("Empty");
            immid.setText("Empty");
        }
        else{ 
            formid.setText(""+form.formId);
            status.setText(""+form.status);
            address.setText(form.address);
            name.setText(form.name);
            attorneyName.setText(form.attorneyName);
            attorneyFirm.setText(form.attorneyFirm);
            phoneNum.setText(""+form.phoneNum);
            immid.setText(""+form.immId);
        }
    }

    public void approve(ActionEvent event){
        System.out.println("APPROVED! =)");
    }

    public void reject(ActionEvent event){
        if(form != null){
            form.addComment(comment.getText());
            System.out.println("REJCTED! =(");
            Workflow.sendToReview(form.formId);
        }
    }
}
