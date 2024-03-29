<div align="center">

![FalconMail Logo (2).png](src%2Fmain%2Fjava%2Fcom%2Fcompany%2Fother%2FFalconMail%20Logo%20%282%29.png)

A program that can rapidly send emails and edit a spreadsheet with the recipient's information

**This is the prototype edition.**
</div>

# Installation and Usage
## Required:
1) Java 15
2) A client_secret file (contact me for one or create your own by following installation steps)

## Installation Steps:
1) Install java 15 by going to OpenJDK's website and installing "Java 15 (Azul Zulu)"
2) Go to Google Cloud Console and sign in to the email of your organization.
3) Create a new project. Make the project internal to the organization and provide the application with the Gmail API.
4) Provide the Gmail API with permissions to send, receive, and modify emails.
5) Download the OAuth2.0 Client key and use it to run the application.
6) You have now created your own cloud application and have implemented it to use Gmail APIs. 
7) Import that client key (.json) into the resources folder
8) Go to FalconMailCore and modify the clientKeyLocation string to have the file name of your client key. Make sure that you keep the "/" before the name.
9) To run the application, make sure you run Main.java and **not** FalconMail.java

## Screen Shots:
![home.png](src%2Fmain%2Fjava%2Fcom%2Fcompany%2Fother%2Fhome.png)
---
![notemplatemainframe.png](src%2Fmain%2Fjava%2Fcom%2Fcompany%2Fother%2Fnotemplatemainframe.png)
---
![withtemplatemainframe.png](src%2Fmain%2Fjava%2Fcom%2Fcompany%2Fother%2Fwithtemplatemainframe.png)

### TODO:
1) make a label stating to the user that the spreadsheet cannot be open while the program is running
2) find a way to distribute existing client secret
3) ~~recolor the app in phs colors~~
4) dark mode and light mode switch?
