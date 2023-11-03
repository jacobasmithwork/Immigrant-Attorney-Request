package group13;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.MenuButton;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
    //Report variables
    public Hyperlink reportProblem;
    public Text explainLabel;
    public Text stepsLabel;

    public Text explainError;
    public Text stepsError;

    public TextField explain;
    public TextField steps;

    public Button submitReportButton;



    //Language Support: Labels
    String[][] labelTexts = { //0 = English, 1 = Spanish, 2 = Chinese, 3 = Hindi, 4 = French
        {"Submitted!", "Applicant Name","Applicant Address", "Applicant Immigrant ID", 
        "Attorney Phone Number", "Attorney Name", "Attorney Firm", "Applicant Information", 
        "Attorney Information", "Submit Request", "English", "Report Problem", "Explain the issue in full detail.",
        "Give a step-by-step on how the problem happened.", "Submit Report"},//End English report == 11 
        {"Enviado!", "Nombre del solicitante", "Dirección del solicitante", "Identificación de Inmigrante del Solicitante",
         "Número de teléfono del abogado", "Nombre del abogado", "Firma de abogados", "Información del aplicante",
          "Información del abogado", "Enviar peticion", "Español", "Informar problema", 
          "Explique el problema con todo detalle.", "Dé un paso a paso de cómo ocurrió el problema.", "Enviar informe"},//End Spanish
        {"已提交！", "申请人姓名","申请人地址", "申请人移民 ID",
        "律师电话号码","律师姓名","律师事务所","申请人信息",
        "律师信息","提交请求","中国人", "报告问题", "详细解释问题。",
        "详细说明问题是如何发生的。", "提交报告"},//End Chinese
        {"प्रस्तुत!", "आवेदक का नाम", "आवेदक का पता", "आवेदक अप्रवासी आईडी",
        "वकील फ़ोन नंबर", "वकील का नाम", "वकील फर्म", "आवेदक की जानकारी",
        "वकील सूचना", "अनुरोध सबमिट करें", "हिंदी", "समस्या की रिपोर्ट करें", "समस्या को पूरे विस्तार से समझाएं।",
        "समस्या कैसे हुई, इसके बारे में चरण-दर-चरण बताएं।", "रिपोर्ट सबमिट करें"},//End Hindi
        {"Envoyé !", "Nom du demandeur", "Adresse du demandeur", "ID d'immigrant du demandeur",
        "Numéro de téléphone de l'avocat", "Nom de l'avocat", "Cabinet d'avocat", "Informations sur le candidat",
        "Informations sur l'avocat", "Soumettre la demande", "Français", "Signaler un problème", "Expliquez le problème en détail.",
        "Expliquez étape par étape comment le problème s'est produit.", "Soumettre le rapport"}//End French
    };
    //Language Support: Errors
    String[][] errorTexts = {//0 = English, 1 = Spanish, 2 = Chinese, 3 = Hindi, 4 = French
        {"Needs to be filled in.", "Must have full name.", "Immigrant ID must be numeric.",
         "Phone Number must be numeric.", "Phone number needs to be at least 10 digits."},
        {"Necesita ser completado.", "Debe tener nombre completo.", 
        "La identificación de inmigrante debe ser numérica.", "El número de teléfono debe ser numérico.", 
        "El número de teléfono debe tener al menos 10 dígitos."},
        {"需要填写。", "必须有全名。", "移民 ID 必须是数字。",
        "电话号码必须是数字。","电话号码至少需要 10 位数字。"},
        {"भरने की जरूरत है।", "पूरा नाम होना चाहिए।", "अप्रवासी आईडी संख्यात्मक होनी चाहिए।",
        "फ़ोन नंबर संख्यात्मक होना चाहिए।", "फ़ोन नंबर कम से कम 10 अंकों का होना चाहिए।"},
        {"Doit être rempli.", "Doit avoir le nom complet.", "La carte d'identité de l'immigrant doit être numérique.",
        "Le numéro de téléphone doit être numérique.", "Le numéro de téléphone doit comporter au moins 10 chiffres."}
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
            if(immNameError.getOpacity() == 1) {mistakes++;}
            if(immAddressError.getOpacity() == 1) {mistakes++;}
            if(immIDError.getOpacity() == 1) {mistakes++;}
            if(attPhoneNumError.getOpacity() == 1) {mistakes++;}
            if(attNameError.getOpacity() == 1) {mistakes++;}
            if(attFirmError.getOpacity() == 1) {mistakes++;}
            double percentage = ((6-mistakes) / 6.0);
            progressCircle.setProgress(percentage);
            // System.out.println(String.format("percentage: %f\nprogress' progress: %f", percentage, progressCircle.getProgress()));
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
        if(language != 1){
            language = 1;
            updateLabels();
        }
    }

    public void makeChinese(ActionEvent e){
        if(language != 2){
            language = 2;
            updateLabels();
        }
    }

    public void makeHindi(ActionEvent e){
        if(language != 3){
            language = 3;
            updateLabels();
        }
    }

    public void makeFrench(ActionEvent e){
        if(language != 4){
            language = 4;
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

    public void openReport(ActionEvent e) throws InterruptedException{
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(this.getClass().getResource("ReportProblemScreen.fxml"));

            Parent parent = loader.load();

            // Show the scene containing the root layout.
            Stage stage = new Stage();
            Scene scene = new Scene(parent);
            stage.setTitle("Error Report");
            stage.setScene(scene);
            stage.getIcons().add(new Image("https://cdn.staticcrate.com/stock-hd/effects/footagecrate-red-error-icon-prev-full.png"));
            stage.show();
            while(stepsError == null){
                wait(100);
            }
            updateReportLabels();
            
        } catch (IOException f) {
            f.printStackTrace();
        }
    }

    public void submitReport(ActionEvent e){
        if(validateReport() == true){
            System.out.println(String.format("Issue: \n\t%s\nSteps:\n\t%s", explain.getText(), steps.getText()));
        }
    }

    public boolean validateReport(){
        int fail = 0;
        if(explain.getText().strip().length() == 0){
            explainError.setOpacity(1);
            fail = 1;
        }
        if(steps.getText().strip().length() == 0){
            stepsError.setOpacity(1);
            fail = 1;
        }
        if(fail == 1){
            return false;
        }
        return true;
    }

    public void updateReportLabels(){
        explainLabel.setText(labelTexts[language][11]);
        stepsLabel.setText(labelTexts[language][12]);
        submitReportButton.setText(labelTexts[language][13]);

        explainError.setText(errorTexts[language][0]);
        stepsError.setText(errorTexts[language][0]);
    }
}