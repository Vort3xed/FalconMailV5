package com.company;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.util.ArrayList;

import static com.company.FalconMailCore.setFromEmail;
import static com.company.FalconMailCore.setToEmail;
import static com.company.FalconMailCore.setClientKeyLocation;
import static com.company.StaticNodes.*;

public class FalconMail extends Application {
    static Group signInLayout = new Group();
    static Group userInterfaceLayout = new Group();

    Scene signInScene = new Scene(signInLayout, 800, 600);
    Scene userInterfaceScene = new Scene(userInterfaceLayout, 800, 600);

    static String templateFileLocation = "src/main/java/resources/templates.txt";
    static String spreadsheetFileLocation = "src/main/java/resources/EmailLog.xlsx";
    static ArrayList<String> templateArray;

    InterfaceStyling inter = new InterfaceStyling();

    final String gradient1 = inter.getGradient1();
    final String gradient2 = inter.getGradient2();
    final String gradient3 = inter.getGradient3();
    final String buttonColor = inter.getButtonColor();
    final String textColor = inter.getTextColor();
    final String buttonTextColor = inter.getButtonTextColor();

    public void start(Stage stage) {
        stage.setTitle("FalconMail V5");
        buildScenes();
        styleSignInPage();
        setFadePhysics();
        styleUserInterface();
        implementButtons();

        signInButton.setOnAction(e -> {
            fd1.play();
            fd1.setOnFinished(event -> {
                fd2.play();
                stage.setScene(userInterfaceScene);
            });
        });

        signInScene.setFill(new LinearGradient(
                0, 0, 1, 1, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.web(gradient1)),
                new Stop(0.5, Color.web(gradient2)),
                new Stop(1, Color.web(gradient3)))
        );

        stage.setScene(signInScene);
        stage.show();
    }
    public void implementButtons(){
        chooseClientKey.setOnAction(this::handleFileSelection);
        chooseTemplateFile.setOnAction(this::handleFileSelection);
        chooseSpreadsheetFile.setOnAction(this::handleFileSelection);
        removeStoredCredential.setOnAction(this::handleTokenRemoval);
        sendEmail.setOnAction(this::handleEmailSending);
    }

    public static void setFadePhysics() {
        fd1.setDuration(Duration.millis(500));
        fd1.setFromValue(10);
        fd1.setToValue(0);
        fd1.setCycleCount(1);

        fd2.setDuration(Duration.millis(1300));
        fd2.setFromValue(0);
        fd2.setToValue(10);
        fd2.setCycleCount(1);

        fd1.setNode(welcomeVbox);
        fd2.setNode(userInterfaceLayout);

    }

    public static void buildScenes() {
        signInLayout.getChildren().addAll(welcomeVbox);
        userInterfaceLayout.getChildren().addAll(recipientInfoVbox, toAndFromAddressesVbox, templateVbox, userInfoVbox, credentialsVbox, fileInputVbox, emailingVbox);
    }

    public void styleSignInPage() {
        Styling.styleVBox(welcomeVbox, 244, 100, 10);
        welcomeVbox.setAlignment(Pos.CENTER);
        welcomeVbox.getChildren().addAll(welcomeLabel, welcomeSubLabel, signInButton);
        Styling.styleLabels(welcomeLabel, "Welcome to FalconMail", Font.font(30),"-fx-text-fill:"+textColor);
        Styling.styleLabels(welcomeSubLabel, "Only team account can be used!", Font.font(20),"-fx-text-fill:"+textColor);
        Styling.styleButtons(signInButton, "Enter Application", 40, 30, "-fx-background-color: " + buttonColor + "; -fx-text-fill:"+buttonTextColor);
    }

    public void styleUserInterface() {
        Styling.styleVBox(recipientInfoVbox, 490, 30, 12);
        recipientInfoVbox.getChildren().addAll(dataLocationLabel, recipientEmailAddress, recipientPhoneNumber, recipientCallName, emailSubject);
        Styling.styleTextBoxes(recipientEmailAddress, "Enter Recipient Email", true);
        Styling.styleTextBoxes(recipientPhoneNumber, "Enter Recipient Phone", true);
        Styling.styleTextBoxes(recipientCallName, "Enter Recipient Name", true);
        Styling.styleLabels(dataLocationLabel, "Enter recipient info below", Font.font(15),"-fx-text-fill:"+textColor);
        Styling.styleTextBoxes(emailSubject, "Enter the email subject!", true);

        appendTemplates();
        Styling.styleVBox(templateVbox, 30, 30, 12);
        templateVbox.getChildren().addAll(templateSelectionIdentifier, chooseTemplateFile, templateList);
        Styling.styleButtons(chooseTemplateFile, "Select a Template File", 30, 40, "-fx-background-color: " + buttonColor + "; -fx-text-fill:"+buttonTextColor);
        Styling.styleLabels(templateSelectionIdentifier, "Set the email body", Font.font(15),"-fx-text-fill:"+textColor);

        Styling.styleVBox(userInfoVbox, 30, 280, 12);
        userInfoVbox.getChildren().addAll(userInfoIdentifier, fromEmail, username);
        Styling.styleTextBoxes(fromEmail, "Enter your email", true);
        Styling.styleTextBoxes(username, "Enter your name", true);
        Styling.styleLabels(userInfoIdentifier, "Enter your info:", Font.font(15),"-fx-text-fill:"+textColor);

        Styling.styleVBox(fileInputVbox, 30, 430, 12);
        fileInputVbox.getChildren().addAll(spreadSheetIdentifier, chooseSpreadsheetFile, clientKeyIdentifier, chooseClientKey);
        Styling.styleLabels(spreadSheetIdentifier, "Upload a spreadsheet to update!", Font.font(15),"-fx-text-fill:"+textColor);
        Styling.styleButtons(chooseSpreadsheetFile, "Select a spreadsheet", 30, 40, "-fx-background-color: " + buttonColor + "; -fx-text-fill:"+buttonTextColor);
        Styling.styleLabels(clientKeyIdentifier, "Select a Client Key!", Font.font(15),"-fx-text-fill:"+textColor);
        Styling.styleButtons(chooseClientKey,"Select a Key", 30,40,"-fx-background-color: " + buttonColor + "; -fx-text-fill:"+buttonTextColor);

        Styling.styleVBox(emailingVbox, 300, 430, 12);
        emailingVbox.getChildren().addAll(emailStatus, sendEmail);
        Styling.styleLabels(emailStatus, "Email Status: ", Font.font(15),"-fx-text-fill:"+textColor);
        Styling.styleButtons(sendEmail, "Send Email", 50, 200, "-fx-background-color: " + buttonColor + "; -fx-text-fill:"+buttonTextColor);

        Styling.styleVBox(credentialsVbox, 300, 280, 12);
        credentialsVbox.getChildren().addAll(credentialLabel, removeStoredCredential);
        Styling.styleLabels(credentialLabel, "Token Status: ", Font.font(15),"-fx-text-fill:"+textColor);
        Styling.styleButtons(removeStoredCredential, "Remove the Saved Account Token", "-fx-background-color: " + buttonColor + "; -fx-text-fill:"+buttonTextColor);


        userInterfaceScene.setFill(new LinearGradient(
                0, 0, 1, 1, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.web(gradient1)),
                new Stop(0.5, Color.web(gradient2)),
                new Stop(1, Color.web(gradient3)))
        );
    }

    public static void appendTemplates() {
        File file = new File(templateFileLocation);
        TextFileReader reader = new TextFileReader(file);
        templateArray = reader.getTextBlocks();
        reader.readTextFile(templateList);
    }

    private void handleFileSelection(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select file");
        File selectedFile = fileChooser.showOpenDialog(chooseTemplateFile.getScene().getWindow());
        if (selectedFile != null && getFileExtension(selectedFile).equals("txt")) {
            templateFileLocation = selectedFile.getAbsolutePath();
            chooseTemplateFile.setText("Uploaded: " + selectedFile.getName());
            appendTemplates();
        } else if (selectedFile != null && getFileExtension(selectedFile).equals("xlsx")) {
            spreadsheetFileLocation = selectedFile.getAbsolutePath();
            chooseSpreadsheetFile.setText("Uploaded: " + selectedFile.getName());
        } else if (selectedFile != null && getFileExtension(selectedFile).equals("json")){
            setClientKeyLocation(selectedFile.getAbsolutePath());
            chooseClientKey.setText("Uploaded Key!");
        }
    }

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }

    private void handleTokenRemoval(ActionEvent event) {
        File token = new File("tokens/StoredCredential");
        if (token.delete()) {
            credentialLabel.setText("Token Removed Successfully");
        } else {
            credentialLabel.setText("Token Removal Failed, File does not exist");
        }
    }

    private void handleEmailSending(ActionEvent event) {
        try {
            emailStatus.setText("Sending Email");
            setFromEmail(fromEmail.getText());
            setToEmail(recipientEmailAddress.getText());
            if (templateList.getSelectionModel().getSelectedIndex() != -1 && username.getText() != null &&
                    recipientEmailAddress.getText() != null && recipientCallName.getText() != null &&
                    emailSubject.getText() != null) {

                new FalconMailCore().sendMail(emailSubject.getText(), useNames(
                        templateArray.get(templateList.getSelectionModel().getSelectedIndex()),
                        "{COMPANY_NAME}", recipientCallName.getText(),"{USER_NAME}",username.getText()));

                ExcelUpdater updater = new ExcelUpdater(spreadsheetFileLocation);
                updater.updateExcelFile(username.getText(), recipientCallName.getText(), recipientEmailAddress.getText(),
                        recipientPhoneNumber.getText());
                emailStatus.setText("Sent Email");
            } else {
                emailStatus.setText("Email Failed! Make sure all fields are filled");
            }

            recipientEmailAddress.clear();
            recipientCallName.clear();
            recipientPhoneNumber.clear();
        } catch (Exception e) {
            emailStatus.setText("Email Failed! Unexpected error caught");
            System.out.println("If you saw this because you're running the program in an IDE, there is a high chance that the \"resources\" folder is not marked as resources in the project structure.");
        }
    }

    public static String useNames(String emailBody, String recipientSuperKey, String recipientName, String userSuperKey, String userName) {
        String returnString = "";
        try {
            returnString = emailBody.replace(recipientSuperKey, recipientName).replace(userSuperKey,userName);
            return returnString;
        } catch (Exception e) {
            System.out.println("Critical Error! (Superkeys do not exist in template?)");
        }
        return emailBody;
    }

    public static void main(String[] args) {
        //DO NOT RUN THIS MAIN METHOD. IT WON'T WORK BECAUSE JAVA IS DUMB. PLEASE RUN THE MAIN METHOD IN Main.java. TRUST ME.
        Application.launch(args);
    }
}
