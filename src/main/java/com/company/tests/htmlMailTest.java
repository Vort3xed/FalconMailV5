package com.company.tests;

import com.company.FalconMailCore;

public class htmlMailTest {
    public static void main(String[] args) throws Exception {
        new FalconMailCore().sendHTMLMail("htmlTest");
    }
}
