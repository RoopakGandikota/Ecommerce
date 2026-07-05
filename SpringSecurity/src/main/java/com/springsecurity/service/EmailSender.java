package com.springsecurity.service;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;

public class EmailSender {
/*****
	@Autowired
	static
	MyUserDetailsService userservice;
	
    public static void main(String[] args) {

        final String from = "roopakgandikota12@gmail.com";
        final String password = "GANDIKOTA71845";
        String to = userservice.getUserId();
        System.out.println(to);
        Properties properties = new Properties();

        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(to)
            );

            message.setSubject("Test Mail");
            message.setText("Hello! This mail is sent from Java.");

            Transport.send(message);

            System.out.println("Mail sent successfully.");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
       
    }
     *******/
}
