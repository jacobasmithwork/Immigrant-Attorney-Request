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
    public TextField attPhoneNum;
    public TextField attName;
    public TextField attFirm;
    
    public Text immNameLabel;
    public Text immAddressLabel;
    public Text immIDLabel;
    public Text attPhoneNumLabel;
    public Text attNameLabel;
    public Text attFirmLabel;
    
    public Text immNameError;
    public Text immAddressError;
    public Text immIDError;
    public Text attPhoneNumError;
    public Text attNameError;
    public Text attFirmError;

    public MenuButton languageSelector;

    public void attemptSubmit(ActionEvent e){
        if(validateForms() == true){
            submitButton.setText("Submitted!");
            AttorneyForm af = new AttorneyForm(immName.getText(), immAddress.getText(),
             attName.getText(), attFirm.getText(), Integer.parseInt(immID.getText()),
              Long.parseLong(attPhoneNum.getText().replaceAll("[\\s\\-()+]", "")));
    
            System.out.println(af.toString());
        }
    }

    public void makeEnglish(ActionEvent e){
        if(language != 0){
            immNameError.setOpacity(0);
            immNameError.setOpacity(0);
            immAddressError.setOpacity(0);
            immIDError.setOpacity(0);
            attPhoneNumError.setOpacity(0);
            attNameError.setOpacity(0);
            attFirmError.setOpacity(0);
    
            immNameLabel.setText("Applicant Name");
            immAddressLabel.setText("Applicant Address");
            immIDLabel.setText("Applicant Immigrant ID");
            attPhoneNumLabel.setText("Attorney Phone Number");
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
            attPhoneNumError.setOpacity(0);
            attNameError.setOpacity(0);
            attFirmError.setOpacity(0);
    
            immNameLabel.setText("Nombre del solicitante");
            immAddressLabel.setText("Dirección del solicitante");
            immIDLabel.setText("Identificación de Inmigrante del Solicitante");
            attPhoneNumLabel.setText("Número de teléfono del abogado");
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
        attPhoneNumError.setOpacity(0);
        attNameError.setOpacity(0);
        attFirmError.setOpacity(0);
        
        int fail = 0; //1 means failure on some level.

        switch (language) {
            case 0: //English errors
                //Immigrant Name 
                String immNameVal = immName.getText();
                if(immNameVal.length() == 0 || immNameVal.strip() == ""){
                    immNameError.setText("Needs to be filled in.");
                    immNameError.setOpacity(1);
                    fail = 1;
                }
                else if(immNameVal.contains(" ") == false){
                    immNameError.setText("Must have full name.");
                    immNameError.setOpacity(1);
                    fail = 1;
                    fail = 1;
                }
                //Immigrant Address
                String immAddressVal = immAddress.getText();
                if(immAddressVal.length() == 0 || immAddressVal.strip() == ""){
                    immAddressError.setText("Needs to be filled in.");
                    immAddressError.setOpacity(1);
                    fail = 1;
                }
                //Immigrant ID
                int immIdVal;
                try{
                    immIdVal = Integer.parseInt(immID.getText());
                }
                catch(NumberFormatException e){
                    if(immID.getText().length() == 0){
                        immIDError.setText("Needs to be filled in.");
                    }
                    else{
                        immIDError.setText("Immigrant ID must be numeric.");
                    }
                    immIDError.setOpacity(1);
                    fail = 1;
                }
                //Attorney Phone Number
                String attPhoneNumString = attPhoneNum.getText();
                if(attPhoneNumString.length() == 0){
                    attPhoneNumError.setText("Needs to be filled in.");
                    attPhoneNumError.setOpacity(1);
                    fail = 1;
                }
                else{
                    //Strip of parentheses, hyphens, and + signs.
                    attPhoneNumString = attPhoneNumString.replaceAll("[\\s\\-()+]", "");
                    System.out.println(attPhoneNumString);
                    long attPhoneNumVal = 0;
                    int phoneFail = 0; //If fails to be long-ified, set to 1 for proper error message.
                    try{
                        attPhoneNumVal = Long.parseLong(attPhoneNumString);
                    }
                    catch(NumberFormatException e){
                        attPhoneNumError.setText("Phone Number must be numeric.");
                        attPhoneNumError.setOpacity(1);
                        phoneFail = 1;
                        fail = 1;
                    }
                    if(phoneFail == 0 && String.valueOf(attPhoneNumVal).length() < 10){
                        attPhoneNumError.setText("Phone number needs to be at least 10 digits.");
                        attPhoneNumError.setOpacity(1);
                        fail = 1;
                    }
                }
                //Attorney Name
                String attNameVal = attName.getText();
                if(attNameVal.length() == 0 || attNameVal.strip() == ""){
                    attNameError.setText("Needs to be filled in.");
                    attNameError.setOpacity(1);
                    fail = 1;
                }
                else if(attNameVal.contains(" ") == false){
                    attNameError.setText("Must have full name.");
                    attNameError.setOpacity(1);
                    fail = 1;
                }
                //Attorney Firm
                String attFirmVal = attFirm.getText();
                if(attFirmVal.length() == 0 || attFirmVal.strip() == ""){
                    attNameError.setText("Needs to be filled in.");
                    attNameError.setOpacity(1);
                    fail = 1;
                }
                break;
                
            case 1: //Spanish errors
                //Immigrant Name 
                immNameVal = immName.getText();
                if(immNameVal.length() == 0 || immNameVal.strip() == ""){
                    immNameError.setText("Necesita ser completado.");
                    immNameError.setOpacity(1);
                    fail = 1;
                }
                else if(immNameVal.contains(" ") == false){
                    immNameError.setText("Debe tener nombre completo.");
                    immNameError.setOpacity(1);
                    fail = 1;
                    fail = 1;
                }
                //Immigrant Address
                immAddressVal = immAddress.getText();
                if(immAddressVal.length() == 0 || immAddressVal.strip() == ""){
                    immAddressError.setText("Necesita ser completado.");
                    immAddressError.setOpacity(1);
                    fail = 1;
                }
                //Immigrant ID
                try{
                    immIdVal = Integer.parseInt(immID.getText());
                }
                catch(NumberFormatException e){
                    if(immID.getText().length() == 0){
                        immIDError.setText("Necesita ser completado.");
                    }
                    else{
                        immIDError.setText("La identificación de inmigrante debe ser numérica.");
                    }
                    immIDError.setOpacity(1);
                    fail = 1;
                }
                //Attorney Phone Number
                attPhoneNumString = attPhoneNum.getText();
                if(attPhoneNumString.length() == 0){
                    attPhoneNumError.setText("Necesita ser completado.");
                    attPhoneNumError.setOpacity(1);
                    fail = 1;
                }
                else{
                    //Strip of parentheses, hyphens, and + signs.
                    attPhoneNumString = attPhoneNumString.replaceAll("[\\s\\-()+]", "");
                    System.out.println(attPhoneNumString);
                    long attPhoneNumVal = 0;
                    int phoneFail = 0; //If fails to be long-ified, set to 1 for proper error message.
                    try{
                        attPhoneNumVal = Long.parseLong(attPhoneNumString);
                    }
                    catch(NumberFormatException e){
                        attPhoneNumError.setText("El número de teléfono debe ser numérico.");
                        attPhoneNumError.setOpacity(1);
                        phoneFail = 1;
                        fail = 1;
                    }
                    if(phoneFail == 0 && String.valueOf(attPhoneNumVal).length() < 10){
                        attPhoneNumError.setText("El número de teléfono debe tener al menos 10 dígitos.");
                        attPhoneNumError.setOpacity(1);
                        fail = 1;
                    }
                }
                //Attorney Name
                attNameVal = attName.getText();
                if(attNameVal.length() == 0 || attNameVal.strip() == ""){
                    attNameError.setText("Necesita ser completado.");
                    attNameError.setOpacity(1);
                    fail = 1;
                }
                else if(attNameVal.contains(" ") == false){
                    attNameError.setText("Debe tener nombre completo.");
                    attNameError.setOpacity(1);
                    fail = 1;
                }
                //Attorney Firm
                attFirmVal = attFirm.getText();
                if(attFirmVal.length() == 0 || attFirmVal.strip() == ""){
                    attNameError.setText("Necesita ser completado.");
                    attNameError.setOpacity(1);
                    fail = 1;
                }
                break;
            default:
                break;
        }
        if(fail == 0){
            return true;
        }
        return false;
    }
}