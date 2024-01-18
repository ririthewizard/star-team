package org.launchcode.rootstar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class HomepageController {
//
//    // Corresponds to http://localhost:8080
//    @GetMapping("/")
//    public String renderHomePage(Model model) {
//        model.addAttribute("headingText", "HOME");
//        return "index";
//    }
//
//}


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomepageController {

    @GetMapping("/home")
    public String home() {
        // Handle the request for the /home endpoint
        return "Welcome to ADMIN portal";
    }
}