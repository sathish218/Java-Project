package com.Paruvatha.Paruvatha.Service;

import com.Paruvatha.Paruvatha.Model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendTicketEmail(Email email) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email.getEmail());
            message.setSubject("Paruvatha Ticket Confirmation");

            String seatList = String.join(", ", email.getSeatNumbers());

            String body = String.format(
                    "Hello %s,\n\nThank you for booking with Paruvatha.\n\n" +
                            "Here are your ticket details:\n" +
                            "Name      : %s\n" +
                            "Email     : %s\n" +
                            "Phone     : %s\n" +
                            "Bus Name  : %s\n" +
                            "Route     : %s → %s\n" +
                            "Date      : %s\n" +
                            "Seats     : %s\n\n" +
                            "Please reach the boarding point 15 minutes before departure.\n\n" +
                            "Regards,\nParuvatha Team",
                    email.getName(),
                    email.getName(),
                    email.getEmail(),
                    email.getPhone(),
                    email.getBusName(),
                    email.getFrom(),
                    email.getTo(),
                    email.getDate(),
                    seatList
            );

            message.setText(body);
            mailSender.send(message);

            System.out.println("Ticket email sent to " + email.getEmail());
        } catch (MailException e) {
            System.err.println("Email sending failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
