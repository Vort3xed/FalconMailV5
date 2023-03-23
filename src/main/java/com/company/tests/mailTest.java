package com.company.tests;

import com.company.FalconMailCore;

public class mailTest {
    public static void main(String[] args) throws Exception {
        String[] testCC = {"agneyat2@gmail.com","amehta@team4099.com"};
        //String[] testCC = {};
        //String attachmentFileLocation = "C:/Users/agney/OneDrive/Desktop/Other/peanut aarav.png";
        String attachmentFileLocation = "C:/Users/agney/Downloads/RoboCamps_Flyer.pdf";

        new FalconMailCore().sendMail("UnitTest", "UnitTest implemented into falconmail",
                attachmentFileLocation, testCC, testCC);
    }
}
