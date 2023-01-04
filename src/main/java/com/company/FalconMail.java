package com.company;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import static com.company.StaticNodes.*;

public class FalconMail extends Application {
    Group signInLayout = new Group();
    Group userInterfaceLayout = new Group();
    Scene signInScene = new Scene(signInLayout, 800, 600);
    Scene userInterfaceScene = new Scene(userInterfaceLayout, 800, 600);

    public void start(Stage stage) {
        signInLayout.getChildren().addAll(welcomeVbox);
        userInterfaceLayout.getChildren().addAll(recipientInfoVbox, toAndFromAddressesVbox);

        Styling.styleVBox(welcomeVbox,244,100, 10);
        welcomeVbox.setAlignment(Pos.CENTER);
        welcomeVbox.getChildren().addAll(welcomeLabel, welcomeSubLabel, signInButton);

        recipientInfoVbox.getChildren().addAll(dataLocationLabel,recipientPhoneNumber,recipientEmailAddress,recipientCallName);

        styleSignInPage();
        setFadePhysics();
        styleUserInterface();

        signInButton.setOnAction(e ->{
            fd1.play();
            fd1.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    fd2.play();
                    stage.setScene(userInterfaceScene);
                }
            });
        });

        signInScene.setFill(new LinearGradient(
                0, 0, 1, 1, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.web("#DBD8AE")),
                new Stop(0.5, Color.web("#CA907E")),
                new Stop(1, Color.web("#994636")))
        );

        stage.setScene(signInScene);
        stage.show();
    }
    public static void setFadePhysics(){
        fd1.setDuration(Duration.millis(500));
        fd1.setFromValue(10);
        fd1.setToValue(0);
        fd1.setCycleCount(1);

        fd2.setDuration(Duration.millis(900));
        fd2.setFromValue(0);
        fd2.setToValue(10);
        fd2.setCycleCount(1);

        fd1.setNode(welcomeVbox);
        fd2.setNode(recipientInfoVbox);

    }
    public void styleSignInPage(){
        Styling.styleLabels(welcomeLabel,"Welcome to FalconMail", Font.font(30));
        Styling.styleLabels(welcomeSubLabel,"Only team account can be used!", Font.font(20));
        Styling.styleButtons(signInButton,"Enter Application",40,30,"-fx-background-color: #EAF4D3");
    }
    public void styleUserInterface(){
        Styling.styleLabels(dataLocationLabel,"Enter recipient info below",Font.font(15));
        userInterfaceScene.setFill(new LinearGradient(
                0, 0, 1, 1, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.web("#DBD8AE")),
                new Stop(0.5, Color.web("#CA907E")),
                new Stop(1, Color.web("#994636")))
        );
    }

    public static void main(String[] args) {
        //DO NOT RUN THIS MAIN METHOD. IT WONT WORK BECAUSE JAVA IS DUMB. PLEASE RUN THE MAIN METHOD IN Main.java. TRUST ME.
        Application.launch(args);
    }
}
