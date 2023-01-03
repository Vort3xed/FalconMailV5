package com.company;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import static com.company.StaticNodes.*;

public class FalconMail extends Application {
    Group signInLayout = new Group();
    Group userInterfaceLayout = new Group();
    Scene signInScene = new Scene(signInLayout, 800, 600);
    Scene userInterfaceScene = new Scene(userInterfaceLayout, 800, 600);

    public void start(Stage stage) {
        signInLayout.getChildren().addAll(welcomeVbox,signInVbox);
        userInterfaceLayout.getChildren().add(logOutButton);

        Styling.styleVBox(welcomeVbox,244,100, 10);
        Styling.styleVBox(signInVbox,325,230,15);
        welcomeVbox.setAlignment(Pos.CENTER);
        signInVbox.setAlignment(Pos.CENTER);
        welcomeVbox.getChildren().addAll(welcomeLabel, signInStatus);
        signInVbox.getChildren().addAll(usernameLabel, usernameField, passwordLabel, passwordField, signInButton);

        styleSignInPage();

        signInButton.setOnAction(this::handleSignIn);
        logOutButton.setOnAction(this::handleLogOut);

        // show the SignIn scene
        stage.setScene(signInScene);
        stage.show();

    }
    public static void styleSignInPage(){
        Styling.styleLabels(welcomeLabel,"Welcome to FalconMail", Font.font(30));
        Styling.styleLabels(signInStatus,"Enter Credentials", Font.font(20));
        Styling.styleLabels(usernameLabel,"Username", Font.font(15));
        Styling.styleLabels(passwordLabel,"Password", Font.font(15));
        Styling.styleTextBoxes(usernameField,"Enter Username",true);
        Styling.styleTextBoxes(passwordField,"Enter Password",true);
        Styling.styleButtons(signInButton,"Sign In",15,20,"-fx-background-color: #808080");
    }


    public void handleSignIn(ActionEvent event){
        String username = usernameField.getText();
        String password = passwordField.getText();
        System.out.println("TEst");
        //primaryStage.setScene(userInterfaceScene);
    }
    public void handleLogOut(ActionEvent event){

    }

    public static void main(String[] args) {
        //DO NOT RUN THIS MAIN METHOD. IT WONT WORK BECAUSE JAVA IS DUMB. PLEASE RUN THE MAIN METHOD IN Main.java. TRUST ME.
        Application.launch(args);
    }
}
