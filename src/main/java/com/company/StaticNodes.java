package com.company;

import javafx.animation.FadeTransition;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class StaticNodes {
    static VBox welcomeVbox = new VBox();
    static Label welcomeLabel = new Label();
    static Label welcomeSubLabel = new Label();
    static Button signInButton = new Button();

    static VBox recipientInfoVbox = new VBox();
    static VBox toAndFromAddressesVbox = new VBox();
    static Label dataLocationLabel = new Label();
    static Button removeStoredCredential = new Button();
    static Button sendEmail = new Button();
    static TextField recipientPhoneNumber = new TextField();
    static TextField recipientEmailAddress = new TextField();
    static TextField recipientCallName= new TextField();
    static TextField fromEmail = new TextField();

    static FadeTransition fd1 = new FadeTransition();
    static FadeTransition fd2 = new FadeTransition();

}

