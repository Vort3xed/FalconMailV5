package com.company;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Message;
import org.apache.commons.codec.binary.Base64;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;

import static com.google.api.services.gmail.GmailScopes.GMAIL_SEND;
import static javax.mail.Message.RecipientType.CC;
import static javax.mail.Message.RecipientType.TO;

public class FalconMailCore {
    private static String FROM_EMAIL = "atharun@team4099.com";
    private static String TO_EMAIL = "atharun@team4099.com";
    private static String clientKeyLocation = "/client_secret_772614566753-bd3mfnqsnfb00eimeemtu0462imp05m5.apps.googleusercontent.com.json";
    private final Gmail service;

    public static void setFromEmail(String fromEmail) {
        FROM_EMAIL = fromEmail;
    }

    public static void setToEmail(String toEmail) {
        TO_EMAIL = toEmail;
    }

    public static void setClientKeyLocation(String keyLocation) {
        clientKeyLocation = keyLocation;
    }

    public FalconMailCore() throws Exception {
        NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        GsonFactory jsonFactory = GsonFactory.getDefaultInstance();
        service = new Gmail.Builder(httpTransport, jsonFactory, getCredentials(httpTransport, jsonFactory))
                .setApplicationName("FalconMail")
                .build();
    }

    private static Credential getCredentials(final NetHttpTransport httpTransport, GsonFactory jsonFactory)
            throws IOException {
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(jsonFactory, new InputStreamReader(FalconMailCore.class.getResourceAsStream(clientKeyLocation)));

        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                httpTransport, jsonFactory, clientSecrets, Set.of(GMAIL_SEND))
                .setDataStoreFactory(new FileDataStoreFactory(Paths.get("tokens").toFile()))
                .setAccessType("offline")
                .build();

        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }

    public void sendMail(String subject, String message, String attachmentLocation, String[] ccedMembers) throws Exception {
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);
        MimeMessage email = new MimeMessage(session);
        email.setFrom(new InternetAddress(FROM_EMAIL));
        email.addRecipient(TO, new InternetAddress(TO_EMAIL));
        email.setSubject(subject);

        Multipart multipart = new MimeMultipart();
        MimeBodyPart textBodyPart = new MimeBodyPart();
        textBodyPart.setText(message);

        if (!Objects.equals(attachmentLocation, "")) {
            MimeBodyPart attachmentBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(attachmentLocation);
            attachmentBodyPart.setDataHandler(new DataHandler(source));
            multipart.addBodyPart(attachmentBodyPart);
        }
        multipart.addBodyPart(textBodyPart);

        email.setContent(multipart);

        for (String ccedMember : ccedMembers) {
            email.addRecipients(CC, String.valueOf(new InternetAddress(ccedMember)));
        }

        //Multipart multipart = new MimeMultipart();

        //MimeBodyPart textBodyPart = new MimeBodyPart();
        //textBodyPart.setText(message);

        //MimeBodyPart attachmentBodyPart= new MimeBodyPart();
        //DataSource source = new FileDataSource(attachmentPath); // ex : "C:\\test.pdf"
        //attachmentBodyPart.setDataHandler(new DataHandler(source));
        //attachmentBodyPart.setFileName(fileName); // ex : "test.pdf"

        //multipart.addBodyPart(textBodyPart);  // add the text part
        //multipart.addBodyPart(attachmentBodyPart); // add the attachment part

        //email.setContent(multipart);

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        email.writeTo(buffer);
        byte[] rawMessageBytes = buffer.toByteArray();
        String encodedEmail = Base64.encodeBase64URLSafeString(rawMessageBytes);
        Message msg = new Message();
        msg.setRaw(encodedEmail);

        try {
            msg = service.users().messages().send("me", msg).execute();
            System.out.println("Message id: " + msg.getId());
            System.out.println(msg.toPrettyString());
        } catch (GoogleJsonResponseException e) {
            GoogleJsonError error = e.getDetails();
            if (error.getCode() == 403) {
                System.err.println("Unable to send message: " + e.getDetails());
            } else {
                throw e;
            }
        }
    }
    public void sendHTMLMail(String subject) throws Exception {
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);
        MimeMessage email = new MimeMessage(session);
        email.setFrom(new InternetAddress(FROM_EMAIL));
        email.addRecipient(TO, new InternetAddress(TO_EMAIL));
        email.setSubject(subject);

        Multipart multipart = new MimeMultipart();

        MimeBodyPart htmlBodyPart = new MimeBodyPart();
        htmlBodyPart.setContent("""
                html test
                <p1> p1 tag </p1>
                 
                <b> bolded </b>
                
                <ul>
                    <li>bullet point</li>
                    <li>bullet point</li>
                    <li>bullet point</li>
                    <li>bullet point</li>
                </ul>
                
                <ol>
                    <li>ordered list</li>
                    <li>ordered list</li>
                    <li>ordered list</li>
                </ol>
                ""","text/html");

        multipart.addBodyPart(htmlBodyPart);

        email.setContent(multipart);

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        email.writeTo(buffer);
        byte[] rawMessageBytes = buffer.toByteArray();
        String encodedEmail = Base64.encodeBase64URLSafeString(rawMessageBytes);
        Message msg = new Message();
        msg.setRaw(encodedEmail);

        try {
            msg = service.users().messages().send("me", msg).execute();
            System.out.println("Message id: " + msg.getId());
            System.out.println(msg.toPrettyString());
        } catch (GoogleJsonResponseException e) {
            GoogleJsonError error = e.getDetails();
            if (error.getCode() == 403) {
                System.err.println("Unable to send message: " + e.getDetails());
            } else {
                throw e;
            }
        }
    }


}
