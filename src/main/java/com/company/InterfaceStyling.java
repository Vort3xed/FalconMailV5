package com.company;

import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;

public class InterfaceStyling {
    private String gradient1;
    private String gradient2;
    private String gradient3;
    private String buttonColor;
    private String textColor;
    private String buttonTextColor;
    private LinearGradient gradientUnit;

    public InterfaceStyling(){
        gradient1 = "#0D1117";
        gradient2 = "#0D1117";
        gradient3 = "#0D1117";
        buttonColor = "#EFAE04";
        textColor = "#FFFFFF";
        buttonTextColor = "#FFFFFF";
        gradientUnit = new LinearGradient(
                0, 0, 1, 1, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.web(gradient1)),
                new Stop(0.5, Color.web(gradient2)),
                new Stop(1, Color.web(gradient3)));
    }

    public InterfaceStyling(String gradient1, String gradient2, String gradient3, String buttonColor, String textColor, String buttonTextColor) {
        this.gradient1 = gradient1;
        this.gradient2 = gradient2;
        this.gradient3 = gradient3;
        this.buttonColor = buttonColor;
        this.textColor = textColor;
        this.buttonTextColor = buttonTextColor;
    }

    public String getGradient1() {
        return gradient1;
    }

    public void setGradient1(String gradient1) {
        this.gradient1 = gradient1;
    }

    public String getGradient2() {
        return gradient2;
    }

    public void setGradient2(String gradient2) {
        this.gradient2 = gradient2;
    }

    public String getGradient3() {
        return gradient3;
    }

    public void setGradient3(String gradient3) {
        this.gradient3 = gradient3;
    }

    public String getButtonColor() {
        return buttonColor;
    }

    public void setButtonColor(String buttonColor) {
        this.buttonColor = buttonColor;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public String getButtonTextColor() {
        return buttonTextColor;
    }

    public void setButtonTextColor(String buttonTextColor) {
        this.buttonTextColor = buttonTextColor;
    }
}
