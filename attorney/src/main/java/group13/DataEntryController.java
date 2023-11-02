package group13;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class DataEntryController {

    public int language = 0; //0 = English, 1 = Spanish

    public Text appInfo;
    public Text attInfo;

    public Button submitButton;
    public TextField immName;
    public TextField immAddress;
    public TextField immID;
    public TextField immPhoneNum;
    public TextField attName;
    public TextField attFirm;
    
    public Text immNameLabel;
    public Text immAddressLabel;
    public Text immIDLabel;
    public Text immPhoneNumLabel;
    public Text attNameLabel;
    public Text attFirmLabel;
    
    public Text immNameError;
    public Text immAddressError;
    public Text immIDError;
    public Text immPhoneNumError;
    public Text attNameError;
    public Text attFirmError;

    public MenuButton languageSelector;

    public void attemptSubmit(ActionEvent e){
        System.out.println("BUTTON CLICKED");
        if(validateForms() == true){
            submitButton.setText("Submitted!");
        }
    }

    public void makeEnglish(ActionEvent e){
        if(language != 0){
            immNameError.setOpacity(0);
            immNameError.setOpacity(0);
            immAddressError.setOpacity(0);
            immIDError.setOpacity(0);
            immPhoneNumError.setOpacity(0);
            attNameError.setOpacity(0);
            attFirmError.setOpacity(0);
    
            immNameLabel.setText("Applicant Name");
            immAddressLabel.setText("Applicant Address");
            immIDLabel.setText("Applicant Immigrant ID");
            immPhoneNumLabel.setText("Applicant Phone Number");
            attNameLabel.setText("Attorney Name");
            attFirmLabel.setText("Attorney Firm");
    
            appInfo.setText("Applicant Information");
            attInfo.setText("Attorney Information");
    
            submitButton.setText("Submit Request");
            languageSelector.setText("English");
        }
    }

    public void makeSpanish(ActionEvent e){
        //Disable all errors
        //Set all texts
        if(language != 1){
            language = 1;
            immNameError.setOpacity(0);
            immNameError.setOpacity(0);
            immAddressError.setOpacity(0);
            immIDError.setOpacity(0);
            immPhoneNumError.setOpacity(0);
            attNameError.setOpacity(0);
            attFirmError.setOpacity(0);
    
            immNameLabel.setText("Nombre del solicitante");
            immAddressLabel.setText("Dirección del solicitante");
            immIDLabel.setText("Identificación de Inmigrante del Solicitante");
            immPhoneNumLabel.setText("Número de teléfono del solicitante");
            attNameLabel.setText("Nombre del abogado");
            attFirmLabel.setText("Firma de abogados");
    
            appInfo.setText("Información del aplicante");
            attInfo.setText("Información del abogado");
    
            submitButton.setText("Enviar peticion");
            languageSelector.setText("Español");
        }
    }

    public boolean validateForms(){
        /*
         * Validations to make:
         *      Phone Number is at least 10 digits and only numeric. Longest country code is 6 digits, 
         *          so no more than 16 allowed in field.
         *      Email Address contains an @ and a . not as the last character only.
         *      Address are incredibly varried, so only check if filled in.
         *      More than one name in box (sorry mononym-havers).
         *      ImmId is all numeric.
         *      There is input in all fields.
         */
        //First, hide all current errors.
        immNameError.setOpacity(0);
        immNameError.setOpacity(0);
        immAddressError.setOpacity(0);
        immIDError.setOpacity(0);
        immPhoneNumError.setOpacity(0);
        attNameError.setOpacity(0);
        attFirmError.setOpacity(0);

        switch (language) {
            case 0: //English errors
                //Immigrant Name 
                String immNameVal = immName.getText();
                if(immNameVal.length() == 0 || immNameVal.strip() == ""){
                    immNameError.setText("Needs to be filled in.");
                    immNameError.setOpacity(1);
                }
                else if(immNameVal.contains(" ") == false){
                    immNameError.setText("Must have full name.");
                    immNameError.setOpacity(1);
                }
                //Immigrant Address
                String immAddressVal = immAddress.getText();
                if(immAddressVal.length() == 0 || immAddressVal.strip() == ""){
                    immAddressError.setText("Needs to be filled in.");
                    immAddressError.setOpacity(1);
                }
                //Immigrant ID
                int immIdVal;
                try{
                    immIdVal = Integer.parseInt(immID.getText());
                }
                catch(NumberFormatException e){
                    immIDError.setText("Immigrant ID must be numeric.");
                    immIDError.setOpacity(1);
                }
                //Immigrant Phone Number
                String immPhoneNumString = immPhoneNum.getText();
                //Strip of parenthese, hyphens, and + signs.
                immPhoneNumString.replaceAll("[\\s\\-()+]", "");
                long immPhoneNumVal = 0;
                try{
                    immPhoneNumVal = Long.parseLong(immPhoneNumString);
                }
                catch(NumberFormatException e){
                    immPhoneNumError.setText("Phone Number must be numeric.");
                    immPhoneNumError.setOpacity(1);
                }
                if(String.valueOf(immPhoneNumVal).length() < 10){
                    immPhoneNumError.setText("Phone number needs to be at least 10 digits.");
                    immPhoneNumError.setOpacity(1);
                }
                //Attorney Name
                String attNameVal = attName.getText();
                if(attNameVal.length() == 0 || attNameVal.strip() == ""){
                    attNameError.setText("Needs to be filled in.");
                    attNameError.setOpacity(1);
                }
                else if(attNameVal.contains(" ") == false){
                    attNameError.setText("Must have full name.");
                    attNameError.setOpacity(1);
                }
                //Attorney Firm
                String attFirmVal = attFirm.getText();
                if(attFirmVal.length() == 0 || attFirmVal.strip() == ""){
                    attNameError.setText("Needs to be filled in.");
                    attNameError.setOpacity(1);
                }
                break;
            case 1: //Spanish errors

                break;
            default:
                break;
        }

        return true;
    }
}