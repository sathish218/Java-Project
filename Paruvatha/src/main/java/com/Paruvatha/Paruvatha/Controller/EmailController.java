package com.Paruvatha.Paruvatha.Controller;

import com.Paruvatha.Paruvatha.Model.Email;
import com.Paruvatha.Paruvatha.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
@CrossOrigin(origins = "*") // Allow frontend access
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send-ticket")
    public String sendTicket(@RequestBody Email email) {
        emailService.sendTicketEmail(email);
        return "Ticket email sent!";
    }
}
