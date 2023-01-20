package com.company;

import javafx.animation.FadeTransition;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class StaticNodes {
    static VBox welcomeVbox = new VBox();
    static Label welcomeLabel = new Label();
    static Label welcomeSubLabel = new Label();
    static Button signInButton = new Button();

    static VBox recipientInfoVbox = new VBox();
    static Label dataLocationLabel = new Label();

    static VBox emailingVbox = new VBox();
    static Label emailStatus = new Label();
    static Button sendEmail = new Button();

    static VBox toAndFromAddressesVbox = new VBox();
    static TextField recipientPhoneNumber = new TextField();
    static TextField recipientEmailAddress = new TextField();
    static TextField recipientCallName= new TextField();
    static TextField emailSubject = new TextField();

    static VBox userInfoVbox = new VBox();
    static Label userInfoIdentifier = new Label();
    static TextField fromEmail = new TextField();
    static TextField username = new TextField();

    static VBox credentialsVbox = new VBox();
    static Label credentialLabel = new Label();
    static Button removeStoredCredential = new Button();

    static VBox templateVbox = new VBox();
    static Label templateSelectionIdentifier = new Label();
    static ComboBox<String> templateList = new ComboBox<>();
    static Button chooseTemplateFile = new Button();

    static VBox fileInputVbox = new VBox();
    static Label spreadSheetIdentifier = new Label();
    static Button chooseSpreadsheetFile = new Button();
    static Label clientKeyIdentifier = new Label();
    static Button chooseClientKey = new Button();

    static FadeTransition fd1 = new FadeTransition();
    static FadeTransition fd2 = new FadeTransition();

}

