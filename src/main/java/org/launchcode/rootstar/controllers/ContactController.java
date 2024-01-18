package org.launchcode.rootstar.controllers;


import org.launchcode.rootstar.models.Contact;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
    @CrossOrigin
    @PostMapping("/submitContactForm")
    public String submitContactForm(@RequestBody Contact contact) {
        // Process the contact form data (you can save to a database, send an email, etc.)
        // For simplicity, let's just print the data for now
        System.out.println("Received contact form submission:");
        System.out.println("Name: " + contact.getName());
        System.out.println("Email: " + contact.getEmail());
        System.out.println("Message: " + contact.getMessage());

        return "Contact form submitted successfully!";
    }
}