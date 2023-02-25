# FalconMailv5
A program that can rapidly send emails and edit a spreadsheet with the recipient's information

# Installation and Usage
## Required:
1) Java 15
2) A registered application with gmail API enabled

## Steps:
1) Install java 15 by going to OpenJDK's website and installing "Java 15 (Azul Zulu)"
2) Go to Google Cloud Console and sign in to the email of your organization.
3) Create a new project. Make the project internal to the organization and provide the application with the Gmail API.
4) Provide the Gmail API with permissions to send, recieve, and modify emails.
5) Download the OAuth2.0 Client key and use it to run the application.
6) You have now created your own cloud application and have implemented it to use Gmail APIs. 
7) Import that client key (.json) into the resources folder
8) Go to FalconMailCore and modify the clientKeyLocation string to have the file name of your client key. Make sure that you keep the "/" before the name.
9) To run the application, make sure you run Main.java and **not** FalconMail.java

### TODO:
1) ~~implement a class that will update and modify an Excel spreadsheet~~
2) ~~remove sign in from initial page and make it a welcome page~~
3) ~~set up everything in the main interface~~
4) ~~give the main interface the ability to pick a certain email body template~~
5) ~~make a method that gets the user's name~~
6) ~~make user input for recipient email, phone number, and name~~
7) ~~make a method that gets the recipients name to make personalized emails~~ (impossible)
8) ~~make it so that you know what file is uploaded on the button for spreadsheet upload~~
9) ~~make it so that recipient info clears after it updates the spreadsheet and sends the email~~
10) ~~fill up some space in main interface~~
11) make a label stating to the user that the spreadsheet cannot be open while the program is running
12) find a way to encrypt the client secret (IMPORTANT or not?)
13) ~~get user input for the email subject~~
14) ~~recolor the app in team colors~~
15) dark mode and light mode switch?