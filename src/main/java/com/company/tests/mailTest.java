package com.company.tests;

import com.company.FalconMailCore;

import static com.company.StaticNodes.*;

public class mailTest {
    public static void main(String[] args) throws Exception {
        String[] testCC = {"agneyat2@gmail.com","amehta@team4099.com"};
        //String[] testCC = {};
        //String attachmentFileLocation = "C:/Users/agney/OneDrive/Desktop/Other/peanut aarav.png";
        String attachmentFileLocation = "";

        new FalconMailCore().sendMail("JUnitTest", "JUnitTest implementation with falconmail",
                attachmentFileLocation, testCC);
    }
}
