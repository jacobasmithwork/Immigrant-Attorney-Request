package group13;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.ProgressIndicator;
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
    public ProgressIndicator progressCircle;
    
    //Language Support: Labels
    String[][] labelTexts = { //0 = English, 1 = Spanish,
        {"Submitted!", "Applicant Name","Applicant Address", "Applicant Immigrant ID", 
        "Attorney Phone Number", "Attorney Name", "Attorney Firm", "Applicant Information", 
        "Attorney Information", "Submit Request", "English"},//End English
        {"Enviado!", "Nombre del solicitante", "Dirección del solicitante", "Identificación de Inmigrante del Solicitante",
         "Número de teléfono del abogado", "Nombre del abogado", "Firma de abogados", "Información del aplicante",
          "Información del abogado", "Enviar peticion", "Español"}//End Spanish
    };
    //Language Support: Errors
    String[][] errorTexts = {//0 = English, 1 = Spanish,
        {"Needs to be filled in.", "Must have full name.", "Immigrant ID must be numeric.",
         "Phone Number must be numeric.", "Phone number needs to be at least 10 digits."},
        {"Necesita ser completado.", "Debe tener nombre completo.", 
        "La identificación de inmigrante debe ser numérica.", "El número de teléfono debe ser numérico.", 
        "El número de teléfono debe tener al menos 10 dígitos."}
    };

    public void attemptSubmit(ActionEvent e){
        if(validateForms() == true){
            submitButton.setText(labelTexts[language][0]);
            AttorneyForm af = new AttorneyForm(immName.getText(), immAddress.getText(),
             attName.getText(), attFirm.getText(), Integer.parseInt(immID.getText()),
              Long.parseLong(attPhoneNum.getText().replaceAll("[\\s\\-()+]", "")));
            System.out.println(af.toString());
            progressCircle.setProgress(1);
        }
        else{
            int mistakes = 0;
            if(immNameError.getOpacity() == 1){mistakes++;}
            if(immNameError.getOpacity() == 1) {mistakes++;}
            if(immAddressError.getOpacity() == 1) {mistakes++;}
            if(immIDError.getOpacity() == 1) {mistakes++;}
            if(attPhoneNumError.getOpacity() == 1) {mistakes++;}
            if(attNameError.getOpacity() == 1) {mistakes++;}
            if(attFirmError.getOpacity() == 1) {mistakes++;}
            System.out.println();
            double percentage = ((6-mistakes) / 6.0);
            progressCircle.setProgress(percentage);
            System.out.println(String.format("percentage: %f\nprogress' progress: %f", percentage, progressCircle.getProgress()));
        }
    }

    public void updateLabels(){
        immNameError.setOpacity(0);
        immNameError.setOpacity(0);
        immAddressError.setOpacity(0);
        immIDError.setOpacity(0);
        attPhoneNumError.setOpacity(0);
        attNameError.setOpacity(0);
        attFirmError.setOpacity(0);

        immNameLabel.setText(labelTexts[language][1]);
        immAddressLabel.setText(labelTexts[language][2]);
        immIDLabel.setText(labelTexts[language][3]);
        attPhoneNumLabel.setText(labelTexts[language][4]);
        attNameLabel.setText(labelTexts[language][5]);
        attFirmLabel.setText(labelTexts[language][6]);

        appInfo.setText(labelTexts[language][7]);
        attInfo.setText(labelTexts[language][8]);

        submitButton.setText(labelTexts[language][9]);
        languageSelector.setText(labelTexts[language][10]);
    }

    public void makeEnglish(ActionEvent e){
        if(language != 0){
            language = 0;
            updateLabels();
        }
    }

    public void makeSpanish(ActionEvent e){
        //Disable all errors
        //Set all texts
        if(language != 1){
            language = 1;
            updateLabels();
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
        //Immigrant Name 
        String immNameVal = immName.getText();
        if(immNameVal.length() == 0 || immNameVal.strip() == ""){
            immNameError.setText(errorTexts[language][0]);
            immNameError.setOpacity(1);
            fail = 1;
        }
        else if(immNameVal.contains(" ") == false){
            immNameError.setText(errorTexts[language][1]);
            immNameError.setOpacity(1);
            fail = 1;
            fail = 1;
        }
        //Immigrant Address
        String immAddressVal = immAddress.getText();
        if(immAddressVal.length() == 0 || immAddressVal.strip() == ""){
            immAddressError.setText(errorTexts[language][0]);
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
                immIDError.setText(errorTexts[language][0]);
            }
            else{
                immIDError.setText(errorTexts[language][2]);
            }
            immIDError.setOpacity(1);
            fail = 1;
        }
        //Attorney Phone Number
        String attPhoneNumString = attPhoneNum.getText();
        if(attPhoneNumString.length() == 0){
            attPhoneNumError.setText(errorTexts[language][0]);
            attPhoneNumError.setOpacity(1);
            fail = 1;
        }
        else{
            //Strip of parentheses, hyphens, and + signs.
            attPhoneNumString = attPhoneNumString.replaceAll("[\\s\\-()+]", "");
            long attPhoneNumVal = 0;
            int phoneFail = 0; //If fails to be long-ified, set to 1 for proper error message.
            try{
                attPhoneNumVal = Long.parseLong(attPhoneNumString);
            }
            catch(NumberFormatException e){
                attPhoneNumError.setText(errorTexts[language][3]);
                attPhoneNumError.setOpacity(1);
                phoneFail = 1;
                fail = 1;
            }
            if(phoneFail == 0 && String.valueOf(attPhoneNumVal).length() < 10){
                attPhoneNumError.setText(errorTexts[language][4]);
                attPhoneNumError.setOpacity(1);
                fail = 1;
            }
        }
        //Attorney Name
        String attNameVal = attName.getText();
        if(attNameVal.length() == 0 || attNameVal.strip() == ""){
            attNameError.setText(errorTexts[language][0]);
            attNameError.setOpacity(1);
            fail = 1;
        }
        else if(attNameVal.contains(" ") == false){
            attNameError.setText(errorTexts[language][1]);
            attNameError.setOpacity(1);
            fail = 1;
        }
        //Attorney Firm
        String attFirmVal = attFirm.getText();
        if(attFirmVal.length() == 0 || attFirmVal.strip() == ""){
            attFirmError.setText(errorTexts[language][0]);
            attFirmError.setOpacity(1);
            fail = 1;
        }
        if(fail == 0){
            return true;
        }
        return false;
    }
}