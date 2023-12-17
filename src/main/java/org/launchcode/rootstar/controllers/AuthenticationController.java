package org.launchcode.rootstar.controllers;

import jakarta.servlet.http.HttpSession;
import org.launchcode.rootstar.models.User;
import org.launchcode.rootstar.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AuthenticationController {

    @Autowired
    private UserRepository userRepository; // gives us access to database for the User

    private static final String userSessionKey  = "user"; // the key establish that the User has created a session



    private static void  setUserInSession(HttpSession session, User user) {
        session.setAttribute(userSessionKey, user.getId());
    }

    public User getUserFromSession(HttpSession session) {

        Integer userId = (Integer) session.getAttribute(userSessionKey);

        if (userId = null);
        return null

        return

    }



}
