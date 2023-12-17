package org.launchcode.rootstar.controllers;

import jakarta.servlet.http.HttpSession;
import org.launchcode.rootstar.models.User;
import org.launchcode.rootstar.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class AuthenticationController {

    @Autowired
    private UserRepository userRepository; // gives us access to database for the User

    private static final String userSessionKey  = "user"; // the key establish that the User has created a session



    private static void  setUserInSession(HttpSession session, User user) { // to create a session object
        session.setAttribute(userSessionKey, user.getId()); // "I want to create a key (user session key = String "user")-value pair (userid)"
    }

    public User getUserFromSession(HttpSession session) { //now we need to look for the user in the session

        Integer userId = (Integer) session.getAttribute(userSessionKey); //"go get the user that is associated with this session key"

        if (userId == null){
            return null;
        }

    Optional<User> userOpt = userRepository.findById(userId); //Optional container (may be we get the user may be not)

        if (userOpt.isEmpty()) {
            return null;
        }
        return userOpt.get(); // we need to unbox the user object (takes it out of the optional and unbox it)
    }

}
