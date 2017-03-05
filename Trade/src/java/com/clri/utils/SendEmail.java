/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clri.utils;

/**
 *
 * @author CDURAI
 */
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class SendEmail {

    public static final String MAIL_SERVER = "smtp.gmail.com";
    public static final String USERNAME = "c.bala1988@gmail.com";
    public static final String PASSWORD = "";

    public void smtpMail(String to, String subject, String mailMessage) {

        // Recipient's email ID needs to be mentioned.
//      String to = "abcd@gmail.com";

        // Sender's email ID needs to be mentioned
//      String from = "web@gmail.com";

        // Assuming you are sending email from localhost

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", MAIL_SERVER);
        properties.put("mail.smtps.auth", "true");

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(USERNAME));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: header field
            message.setSubject(subject);

            // Now set the actual message
            message.setText(mailMessage);

            Transport tr = session.getTransport("smtps");
            tr.connect(MAIL_SERVER, USERNAME, PASSWORD);
            tr.sendMessage(message, message.getAllRecipients());
            tr.close();
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
