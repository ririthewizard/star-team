package org.launchcode.rootstar.controllers;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.servlet.http.HttpSession;
import org.launchcode.rootstar.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.launchcode.rootstar.models.dto.LoginFormDTO;
import org.launchcode.rootstar.models.dto.RegistrationFormDTO;
import org.launchcode.rootstar.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;
@Controller
//@RestController
@RequestMapping
@CrossOrigin
public class AuthenticationController {

    @Autowired
    private UserRepository userRepository; // gives us access to database for the User

    private static final String userSessionKey  = "user"; // the key establish that the User has created a session

    private static void  setUserInSession(HttpSession session, User user) { // to create a session object
        session.setAttribute(userSessionKey, user.getId()); // "I want to create a key (user session key = String "user")-value pair (userid)"
        System.out.println("session: " + session.getAttribute("user"));
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


    // create handlers

    @GetMapping ("/register")
    public String displayRegistrationForm (Model model, HttpSession session) { //Model class to pass data
        model.addAttribute(new RegistrationFormDTO());
        model.addAttribute("loggedIn", session.getAttribute(userSessionKey) != null);

        return "register";
    }

    @PostMapping ("/register")
        public String processRegistrationForm (@ModelAttribute @Valid RegistrationFormDTO registrationFormDTO,
                                               Errors errors,
                                               HttpServletRequest request ) {
            //@ModelAttribute is to handle DTO object, @Valid to handle validation


            //  send user back to the form if errors are found

            if (errors.hasErrors()) {
                System.out.println("Registration form has errors");
                return "register";

            }

            User existingUser = userRepository.findByUsername(registrationFormDTO.getUsername());


            if (existingUser != null) {
                errors.rejectValue("username","username.alreadyExists", "the user with that username already exists");
                return "register";
            }

            String password = registrationFormDTO.getPassword();
            String verifyPassword = registrationFormDTO.getVerifyPassword();
             if (!password.equals(verifyPassword)) {
                 errors.rejectValue("password", "passwords.mismatch", "passwords do not match");
                 return "register";
             }

             User newUser = new User(registrationFormDTO.getUsername(),registrationFormDTO.getPassword());

             userRepository.save(newUser);
             setUserInSession(request.getSession(),newUser);
            System.out.println("Registration form processed");
             return "redirect:/home"; // sends user to the view-garden page (in  GardenController)
    }

    @GetMapping("/login")
    public String displayLoginForm(Model model,HttpSession session) {
            model.addAttribute(new LoginFormDTO());
        model.addAttribute("loggedIn", session.getAttribute(userSessionKey) != null);
        return "login";
    }

    @PostMapping ("/login")
    public String processLoginForm(@ModelAttribute @Valid LoginFormDTO loginFormDTO,
                                   Errors errors,
                                   HttpServletRequest request) {

            if (errors.hasErrors()) {
                return "login";
            }

            User theUser = userRepository.findByUsername(loginFormDTO.getUsername());

            String password = loginFormDTO.getPassword();

            if (theUser == null || !theUser.isMatchingPassword(password)) {

                errors.rejectValue(
                        "password",
                        "login.invalid",
                        "Wrong credentials. Try again"
                );
                return "login";
            }


            setUserInSession(request.getSession(), theUser);
            return "redirect:/home";
    }



//        return ResponseEntity.ok("{\"message\": \"Login successful\"}");
//    }





    @GetMapping ("/logout")
    public String logout (HttpServletRequest request) {
            request.getSession().invalidate();
            return "redirect:/login";
    }


}
